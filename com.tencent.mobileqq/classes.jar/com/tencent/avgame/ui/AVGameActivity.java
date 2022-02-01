package com.tencent.avgame.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.av.utils.QAVConfigUtils;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.controller.GameActivityCenterCtrl;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Game;
import com.tencent.avgame.gamelogic.data.GameActivityCenterEntry;
import com.tencent.avgame.gamelogic.data.GameRecordInfo;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo;
import com.tencent.avgame.gameresult.GamePKResultFragment;
import com.tencent.avgame.gameresult.GamePKResultHelper;
import com.tencent.avgame.gameresult.GameResultBaseHelper;
import com.tencent.avgame.gameresult.GameResultFragment;
import com.tencent.avgame.gameresult.GameResultHelper;
import com.tencent.avgame.gameroom.GameRoomFragment;
import com.tencent.avgame.ipc.AVGameClientQIPCModule;
import com.tencent.avgame.ipc.ProcessMonitor;
import com.tencent.avgame.qav.IAVGameBusinessCtrl.IOnEnterRoom;
import com.tencent.avgame.report.AVGameNodeReportUtil;
import com.tencent.avgame.report.AVGamePerfReporter;
import com.tencent.avgame.report.CJSurvivalReporterUtil;
import com.tencent.avgame.util.AVGameUtil;
import com.tencent.avgame.util.AvGameEntranceUtil;
import com.tencent.avgame.util.CostTraceUtil;
import com.tencent.common.app.business.BaseAVGameAppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.avgameshare.AVGameShareUtil;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.util.FPSCalculator;
import com.tencent.mobileqq.util.FPSCalculator.GetFPSListener;
import com.tencent.qav.thread.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

@RoutePage(desc="一起派对游戏房间activity，包含房间页和结果页fragment", path="/business/avgame/avgameactivity")
public class AVGameActivity
  extends QBaseActivity
  implements IAVGameBusinessCtrl.IOnEnterRoom, IAVGameRootContainer
{
  private static final String TAG = "AVGameActivity";
  FPSCalculator.GetFPSListener fpsListener = new AVGameActivity.1(this);
  private boolean fpsSwitch = false;
  private AVGameAppInterface mApp;
  private AVGameBackAction mBackAction = null;
  private GameBaseFragment mCurFragment;
  private int mCurFragmentType;
  private Runnable mEnterAvRoomRunnable = new AVGameActivity.3(this);
  private boolean mExitByFinished = false;
  private View mFragmentContainer;
  private String mFriendUinByCreateC2CRoom = null;
  private boolean mGameExited = false;
  private boolean mHasActivityDestroy = false;
  private boolean mHasSendLoadingFinishBroadcast = false;
  private HashMap<String, GameResultBaseHelper> mHelperMap = new HashMap();
  private boolean mIsFirst = true;
  private boolean mIsNewEnter = false;
  private boolean mIsStartMatchWhenEnterRoom = false;
  private Runnable mNotifyMainProcessLoadingFinishRunnable = new AVGameActivity.2(this);
  private String mRoomId;
  private PowerManager.WakeLock mScreenWakeLoack = null;
  public BroadcastReceiver mShareResultReceiver = new AVGameActivity.8(this);
  private byte[] mSignature;
  private Runnable mUpdateRootMarginTopOfScreenRunnable = new AVGameActivity.7(this);
  
  private void beginRoomProcess()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVGameActivity", 2, "beginRoomProcess");
    }
    if (TextUtils.isEmpty(this.mRoomId)) {
      return;
    }
    AVGamePerfReporter.a().a("param_StepGameReady");
    GameEngine.a().a(Long.valueOf(this.mRoomId).longValue());
    GameEngine.a().a(Long.valueOf(this.mRoomId).longValue(), this.mApp.getCurrentAccountUin());
    AVGameHandler.a().b().post(this.mEnterAvRoomRunnable);
  }
  
  private void beginSurvivalRoomProcess()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVGameActivity", 2, "beginRoomProcess");
    }
    if (TextUtils.isEmpty(this.mRoomId)) {
      return;
    }
    AVGamePerfReporter.a().a("param_StepGameReady");
    GameEngine.a().a(Long.valueOf(this.mRoomId).longValue());
    GameEngine.a().a(Long.valueOf(this.mRoomId).longValue(), this.mApp.getCurrentAccountUin());
    if (GameEngine.a().B()) {
      AVGameHandler.a().b().post(this.mEnterAvRoomRunnable);
    }
  }
  
  private void cancelRemainScreenOn()
  {
    PowerManager.WakeLock localWakeLock = this.mScreenWakeLoack;
    if ((localWakeLock != null) && (localWakeLock.isHeld()))
    {
      this.mScreenWakeLoack.release();
      this.mScreenWakeLoack = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AVGameActivity", 2, "cancelRemainScreenOn");
    }
  }
  
  private void checkMatchingStatus(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("key_start_match", false))
    {
      if (this.mIsNewEnter)
      {
        int i = getIntent().getIntExtra("key_match_game_type", 0);
        GameEngine.a().c(i);
      }
      if (AVGameUtil.b() == 2) {
        GameEngine.a().s().f(true);
      }
    }
  }
  
  private GameBaseFragment createFragment(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return null;
        }
        return GamePKResultFragment.a();
      }
      return GameResultFragment.a();
    }
    return GameRoomFragment.a();
  }
  
  private void dealPkFromRestartProcess(Intent paramIntent)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void dealWithRoomEnter(boolean paramBoolean, int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dealWithRoomEnter ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" retCode:");
      localStringBuilder.append(paramInt);
      QLog.d("AVGameActivity", 2, localStringBuilder.toString());
    }
    if ((paramInt == 0) && (paramRoomInfo != null))
    {
      paramLong = paramRoomInfo.id;
      if (!isFinishing())
      {
        GameEngine.a().a(paramRoomInfo);
        this.mRoomId = String.valueOf(paramLong);
        this.mSignature = paramArrayOfByte;
        GameEngine.a().a(paramLong, getCurrentAccountUinFromRuntime(), true, true);
        beginRoomProcess();
      }
    }
    else
    {
      showDialogTip(AvGameEntranceUtil.a(paramBoolean, this, paramInt, paramLong, paramString));
      GameEngine.a().a(false, 7);
    }
  }
  
  private void exitGameRoom(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enterAVGameFail, reason[");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("], retCode[");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("]");
    QLog.i("AVGameActivity", 1, localStringBuilder.toString());
    if (paramInt1 == 4)
    {
      AVGameNodeReportUtil.b(-102);
      showDialogTip(getString(2131887368));
      AVGameNodeReportUtil.b(-202);
    }
    else
    {
      showDialogTip(getString(2131887239));
      AVGameNodeReportUtil.b(-201);
    }
    this.mGameExited = true;
    GameEngine.a().a(false, 7);
  }
  
  private String getFragmentTag(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(GameBaseFragment.class.getName());
          localStringBuilder.append("-unknown");
          return localStringBuilder.toString();
        }
        return GamePKResultFragment.class.getName();
      }
      return GameResultFragment.class.getName();
    }
    return GameRoomFragment.class.getName();
  }
  
  private void initData(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("key_room_id");
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("key_sig");
    TextUtils.isEmpty(str);
    boolean bool = false;
    this.mIsNewEnter = paramIntent.getBooleanExtra("key_room_be_new_enter", false);
    if ((this.mIsNewEnter) && (arrayOfByte != null)) {
      int i = arrayOfByte.length;
    }
    if (TextUtils.isEmpty(str))
    {
      exitGameRoom(4, 0);
      return;
    }
    this.mFriendUinByCreateC2CRoom = paramIntent.getStringExtra("key_room_friend_uin");
    Object localObject2 = null;
    Object localObject3 = paramIntent.getBundleExtra("key_room_bundle");
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((Bundle)localObject3).getSerializable("key_room_info");
      localObject1 = localObject2;
      if ((localObject3 instanceof RoomInfo))
      {
        localObject1 = (RoomInfo)localObject3;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("roominfo :  ");
        ((StringBuilder)localObject2).append(((RoomInfo)localObject1).toString());
        ((StringBuilder)localObject2).append(" players:");
        ((StringBuilder)localObject2).append(((RoomInfo)localObject1).players.size());
        QLog.d("AVGameActivity", 2, ((StringBuilder)localObject2).toString());
      }
    }
    long l = Long.valueOf(str).longValue();
    localObject2 = GameEngine.a().s();
    if ((localObject2 == null) || (l != ((EngineData)localObject2).i()))
    {
      if (localObject1 != null)
      {
        GameEngine.a().a((RoomInfo)localObject1);
      }
      else
      {
        localObject1 = new RoomInfo();
        ((RoomInfo)localObject1).id = l;
        GameEngine.a().a((RoomInfo)localObject1);
      }
      bool = true;
    }
    paramIntent = paramIntent.getSerializableExtra("key_game_record_info");
    if ((paramIntent instanceof GameRecordInfo))
    {
      localObject1 = (GameRecordInfo)paramIntent;
      localObject2 = GameEngine.a().s();
      ((EngineData)localObject2).a(((GameRecordInfo)localObject1).videoFilePath, ((GameRecordInfo)localObject1).photoFilePath, ((GameRecordInfo)localObject1).startGameTimeMills);
      ((EngineData)localObject2).a(((GameRecordInfo)localObject1).extraJsonData);
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("initData roomId ");
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append(" mRoomId ");
      ((StringBuilder)localObject1).append(this.mRoomId);
      ((StringBuilder)localObject1).append(" signature ");
      ((StringBuilder)localObject1).append(arrayOfByte);
      ((StringBuilder)localObject1).append(" bNewEnter ");
      ((StringBuilder)localObject1).append(this.mIsNewEnter);
      ((StringBuilder)localObject1).append(" needPullSnapshot ");
      ((StringBuilder)localObject1).append(bool);
      ((StringBuilder)localObject1).append(" recordInfo ");
      ((StringBuilder)localObject1).append(paramIntent);
      QLog.d("AVGameActivity", 2, ((StringBuilder)localObject1).toString());
    }
    this.mRoomId = str;
    this.mSignature = arrayOfByte;
    if (bool) {
      GameEngine.a().a(l, getCurrentAccountUinFromRuntime(), true, true);
    }
    checkMatchingStatus(getIntent());
  }
  
  private void loadDataAndUI(Intent paramIntent)
  {
    int i;
    if ((!GameEngine.a().A()) && (!paramIntent.getBooleanExtra("key_from_survival", false))) {
      i = 0;
    } else {
      i = 1;
    }
    this.mIsStartMatchWhenEnterRoom = paramIntent.getBooleanExtra("key_start_match", false);
    if (i != 0) {
      loadDataForSurvival(paramIntent);
    } else {
      loadDataForNormal(paramIntent);
    }
    setFromTypeAndIsCreate(paramIntent);
  }
  
  private void loadDataForNormal(Intent paramIntent)
  {
    initData(paramIntent);
    beginRoomProcess();
    int i = GameEngine.a().s().j();
    if ((i == 10) && (!this.mIsNewEnter))
    {
      showResult();
      return;
    }
    if (i == 10)
    {
      GameEngine.a().s().h().b();
      showRoom();
      return;
    }
    showRoom();
  }
  
  private void loadDataForSurvival(Intent paramIntent)
  {
    this.mIsNewEnter = paramIntent.getBooleanExtra("key_room_be_new_enter", false);
    if (this.mIsNewEnter)
    {
      this.mApp.a().b(3, "");
      boolean bool = paramIntent.getBooleanExtra("key_pk_qqcj", false);
      GameEngine.a().s().a(paramIntent.getIntExtra("key_pk_type", 0), bool);
      if (bool)
      {
        i = paramIntent.getIntExtra("key_pk_qqcj_source_type", 0);
        CJSurvivalReporterUtil.a().a(i);
        if (i == 3) {
          CJSurvivalReporterUtil.a().a(paramIntent.getStringExtra("key_pk_qqcj_qr_to_uin"));
        }
      }
      GameEngine.a().x();
      if (bool) {
        GameEngine.a().F();
      }
    }
    dealPkFromRestartProcess(paramIntent);
    int i = GameEngine.a().s().X();
    if ((i == 6) || (i == 7)) {
      GameEngine.a().s().g(0);
    }
    showRoom();
    int j = GameEngine.a().s().j();
    if ((j != 0) && (j != 10) && (i == 3))
    {
      initData(paramIntent);
      beginSurvivalRoomProcess();
    }
  }
  
  @SuppressLint({"InvalidWakeLockTag"})
  private void remainScreenOn()
  {
    if (this.mScreenWakeLoack == null) {
      this.mScreenWakeLoack = ((PowerManager)getApplicationContext().getSystemService("power")).newWakeLock(536870918, "AVGameActivity");
    }
    if (!this.mScreenWakeLoack.isHeld()) {
      this.mScreenWakeLoack.acquire();
    }
    if (QLog.isColorLevel()) {
      QLog.d("AVGameActivity", 2, "remainScreenOn");
    }
  }
  
  private void setFromTypeAndIsCreate(Intent paramIntent)
  {
    EngineData localEngineData = GameEngine.a().s();
    boolean bool1 = paramIntent.getBooleanExtra("key_room_be_new_enter", false);
    int i = paramIntent.getIntExtra("key_room_from_type", 0);
    boolean bool2 = paramIntent.getBooleanExtra("key_room_is_create", true);
    if (bool1)
    {
      localEngineData.A = i;
      localEngineData.B = bool2;
    }
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("setFromTypeAndIsCreate isNewEnter：");
      paramIntent.append(bool1);
      paramIntent.append(" fromIsCreate:");
      paramIntent.append(bool2);
      paramIntent.append(" fromType:");
      paramIntent.append(i);
      QLog.d("AVGameActivity", 2, paramIntent.toString());
    }
  }
  
  private void showFragment(int paramInt)
  {
    boolean bool = GameEngine.a().A();
    int k = 0;
    int i;
    if ((bool) && (GameEngine.a().D()) && (paramInt == 3) && (!TextUtils.isEmpty(GameEngine.a().s().Z().awardUrl))) {
      i = 1;
    } else {
      i = 0;
    }
    int j = k;
    if (paramInt != 1)
    {
      j = k;
      if (paramInt != 3) {
        j = 1;
      }
    }
    if (((QAVConfigUtils.u()) && (j != 0)) || (i != 0))
    {
      if (paramInt == 2)
      {
        localObject2 = (GameResultBaseHelper)this.mHelperMap.get(GameResultHelper.class.getSimpleName());
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new GameResultHelper(this);
          ((GameResultBaseHelper)localObject1).b();
          this.mHelperMap.put(GameResultHelper.class.getSimpleName(), localObject1);
        }
      }
      else if (paramInt == 3)
      {
        localObject2 = (GameResultBaseHelper)this.mHelperMap.get(GamePKResultHelper.class.getSimpleName());
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new GamePKResultHelper(this);
          ((GameResultBaseHelper)localObject1).b();
          this.mHelperMap.put(GamePKResultHelper.class.getSimpleName(), localObject1);
        }
      }
      else
      {
        localObject1 = null;
      }
      if (localObject1 != null)
      {
        this.mCurFragmentType = paramInt;
        this.mCurFragment = null;
        ((GameResultBaseHelper)localObject1).a();
        GameActivityCenterCtrl.a().b(this);
      }
      return;
    }
    if ((this.mCurFragment != null) && (paramInt == this.mCurFragmentType)) {
      return;
    }
    String str = getFragmentTag(paramInt);
    Object localObject2 = getSupportFragmentManager();
    Object localObject1 = (GameBaseFragment)((FragmentManager)localObject2).findFragmentByTag(str);
    FragmentTransaction localFragmentTransaction = ((FragmentManager)localObject2).beginTransaction();
    localObject2 = this.mCurFragment;
    if ((localObject2 != null) && (paramInt != this.mCurFragmentType))
    {
      ((GameBaseFragment)localObject2).a(paramInt);
      localFragmentTransaction.hide(this.mCurFragment);
    }
    if (localObject1 == null)
    {
      localObject2 = createFragment(paramInt);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        ((GameBaseFragment)localObject2).a(this.mIsStartMatchWhenEnterRoom);
        localFragmentTransaction.add(2131433669, (Fragment)localObject2, str);
        localObject1 = localObject2;
      }
    }
    else
    {
      ((GameBaseFragment)localObject1).a(this.mIsStartMatchWhenEnterRoom);
      localFragmentTransaction.show((Fragment)localObject1);
    }
    localFragmentTransaction.commitAllowingStateLoss();
    this.mCurFragment = ((GameBaseFragment)localObject1);
    this.mCurFragmentType = paramInt;
    if (localObject1 != null) {
      ((GameBaseFragment)localObject1).a(paramInt);
    }
    if (this.mCurFragmentType == 1)
    {
      GameActivityCenterCtrl.a().a(this);
      return;
    }
    GameActivityCenterCtrl.a().b(this);
  }
  
  private void showToastTip(int paramInt, String paramString)
  {
    AVGameHandler.a().c().post(new AVGameActivity.4(this, paramInt, paramString));
  }
  
  public boolean checkDestroyed()
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return isDestroyed();
    }
    return this.mHasActivityDestroy;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 10000)
    {
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("doOnActivityResult:");
        paramIntent.append(paramInt2);
        QLog.i("AVGameActivity", 1, paramIntent.toString());
      }
      if (paramInt2 == -1)
      {
        showTransientTip();
        AVGameShareUtil.a().a(this, 1, true);
      }
    }
    if (paramInt1 == 291)
    {
      if (GameEngine.a().A()) {
        paramIntent = (GameResultBaseHelper)this.mHelperMap.get(GamePKResultHelper.class.getSimpleName());
      } else {
        paramIntent = (GameResultBaseHelper)this.mHelperMap.get(GameResultHelper.class.getSimpleName());
      }
      if (paramInt2 == 273)
      {
        if (paramIntent != null) {
          paramIntent.d();
        }
      }
      else if (paramInt2 == 546)
      {
        if (paramIntent != null) {
          paramIntent.a(true);
        }
        finish();
      }
    }
  }
  
  public void doOnBackPressed()
  {
    GameBaseFragment localGameBaseFragment = this.mCurFragment;
    if ((localGameBaseFragment != null) && (localGameBaseFragment.e())) {
      return;
    }
    super.doOnBackPressed();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    ProcessMonitor.a().a("AVGameActivity_doOnCreate");
    CostTraceUtil.a().b("AVGameActivityInit");
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    getActivity().getWindow().getDecorView().setBackgroundDrawable(null);
    getWindow().setFlags(16777216, 16777216);
    super.doOnCreate(paramBundle);
    getWindow().addFlags(128);
    if (ImmersiveUtils.couldSetStatusTextColor()) {
      ImmersiveUtils.setStatusTextColor(false, getWindow());
    }
    this.mApp = ((AVGameAppInterface)getAppRuntime());
    setContentView(2131624270);
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      QLog.d("AVGameActivity", 1, "doOnCreate intent == null");
      finish();
      return false;
    }
    this.mBackAction = AVGameBackAction.a(paramBundle);
    this.mFragmentContainer = findViewById(2131433669);
    AVGamePerfReporter.a().a(paramBundle);
    AVGameNodeReportUtil.b(paramBundle);
    CostTraceUtil.a().a("AvGameOpenInit", paramBundle);
    this.mGameExited = false;
    this.mHasActivityDestroy = false;
    loadDataAndUI(paramBundle);
    if (this.fpsSwitch) {
      FPSCalculator.a().a(this.fpsListener);
    }
    AVGameShareUtil.a().a(this.mShareResultReceiver, this);
    setActivityState(0);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    AVGameHandler.a().c().removeCallbacks(this.mNotifyMainProcessLoadingFinishRunnable);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doOnDestroy mExitByFinished：");
    ((StringBuilder)localObject).append(this.mExitByFinished);
    QLog.i("AVGameActivity", 1, ((StringBuilder)localObject).toString());
    notifyMainProcessLoadingFinish();
    AVGameHandler.a().b().removeCallbacks(this.mEnterAvRoomRunnable);
    AVGameHandler.a().c().removeCallbacks(this.mUpdateRootMarginTopOfScreenRunnable);
    AVGameShareUtil.a().b();
    cancelRemainScreenOn();
    this.mCurFragment = null;
    this.mCurFragmentType = 0;
    localObject = this.mHelperMap.entrySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((GameResultBaseHelper)((Map.Entry)((Iterator)localObject).next()).getValue()).c();
    }
    this.mHelperMap.clear();
    this.mHasActivityDestroy = true;
    com.tencent.avgame.gamelogic.gameres.AvGameResDownloadManager.a = null;
    if (this.fpsSwitch) {
      FPSCalculator.a().b(this.fpsListener);
    }
    AVGameShareUtil.a().b(this.mShareResultReceiver, this);
    setActivityState(5);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    ProcessMonitor.a().a("AVGameActivity_doOnNewIntent");
    loadDataAndUI(paramIntent);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.mCurFragmentType == 1) {
      GameActivityCenterCtrl.a().b(this);
    }
    setActivityState(3);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (Build.VERSION.SDK_INT >= 30) {
      AVGameHandler.a().c().postDelayed(this.mNotifyMainProcessLoadingFinishRunnable, 0L);
    } else {
      AVGameHandler.a().c().postDelayed(this.mNotifyMainProcessLoadingFinishRunnable, 600L);
    }
    AVGameHandler.a().c().postDelayed(this.mUpdateRootMarginTopOfScreenRunnable, 32L);
    if (this.mCurFragmentType == 1) {
      GameActivityCenterCtrl.a().a(this);
    }
    setActivityState(2);
    QLog.i("AVGameActivity", 1, "!!!!!!!!doOnResume");
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    this.mExitByFinished = false;
    this.mGameExited = false;
    remainScreenOn();
    setActivityState(1);
    QLog.i("AVGameActivity", 1, "!!!!!!!!doOnStart");
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    notifyMainProcessLoadingFinish();
    cancelRemainScreenOn();
    setActivityState(4);
  }
  
  protected void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((this.mIsFirst) && (paramBoolean))
    {
      this.mIsFirst = false;
      CostTraceUtil.a().c("AVGameActivityInit");
      CostTraceUtil.a().a("AVGameActivityFirstShow", getIntent());
      AVGamePerfReporter.a().a("param_StepLoading", 0);
      AVGamePerfReporter.a().a("param_StepPrepareGame", 0);
      AVGamePerfReporter.a().a("param_StepGameReady");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("!!!!!!!!!!!!doOnWindowFocusChanged ");
    localStringBuilder.append(paramBoolean);
    QLog.e("AVGameActivity", 1, localStringBuilder.toString());
  }
  
  public void finish()
  {
    QLog.i("AVGameActivity", 1, "finish", new Throwable("not crash, print stack"));
    this.mExitByFinished = true;
    AVGameBackAction localAVGameBackAction = this.mBackAction;
    if (localAVGameBackAction != null) {
      localAVGameBackAction.a(this);
    }
    super.finish();
  }
  
  public boolean getGameExitStatus()
  {
    return this.mGameExited;
  }
  
  public String getRoomId()
  {
    return this.mRoomId;
  }
  
  public boolean isExitByFinish()
  {
    return this.mExitByFinished;
  }
  
  public boolean isNewEnter()
  {
    return this.mIsNewEnter;
  }
  
  protected boolean isWrapContent()
  {
    GameBaseFragment localGameBaseFragment = this.mCurFragment;
    if (localGameBaseFragment != null) {
      return localGameBaseFragment.c();
    }
    return super.isWrapContent();
  }
  
  public void notifyExitGamed()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyExitGamed mGameExited:");
      localStringBuilder.append(this.mGameExited);
      QLog.i("AVGameActivity", 1, localStringBuilder.toString());
    }
    this.mGameExited = true;
  }
  
  public void notifyMainProcessLoadingFinish()
  {
    if (!this.mHasSendLoadingFinishBroadcast) {
      this.mApp.getApp().sendBroadcast(new Intent("com.tencent.avgame.ui.AvGameLoadingActivity.ACTION_LOADING_FINISH"));
    }
    this.mHasSendLoadingFinishBroadcast = true;
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onEnterRoom(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onEnterRoom mGameExited:");
    ((StringBuilder)localObject).append(this.mGameExited);
    ((StringBuilder)localObject).append(" retCode:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" mRoomId:");
    ((StringBuilder)localObject).append(this.mRoomId);
    ((StringBuilder)localObject).append(" mFriendUinByCreateC2CRoom");
    ((StringBuilder)localObject).append(this.mFriendUinByCreateC2CRoom);
    QLog.i("AVGameActivity", 1, ((StringBuilder)localObject).toString());
    if ((!TextUtils.isEmpty(this.mFriendUinByCreateC2CRoom)) && (paramInt == 0)) {
      this.mApp.a().a(1, this.mFriendUinByCreateC2CRoom, this.mRoomId);
    }
    if (this.mGameExited) {
      return;
    }
    AVGameNodeReportUtil.c();
    ThreadManager.c(new AVGameActivity.6(this, paramInt));
    if (paramInt == 0)
    {
      localObject = GameEngine.a().s();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onEnterRoom changeUserStatus and EngineData is ");
        localStringBuilder.append(localObject);
        QLog.i("AVGameActivity", 2, localStringBuilder.toString());
      }
      if (GameEngine.a().A()) {
        return;
      }
      GameEngine.a().a(((EngineData)localObject).i(), GameEngine.a().f().getAccount(), 1, 1);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    GameBaseFragment localGameBaseFragment = this.mCurFragment;
    if ((localGameBaseFragment != null) && (localGameBaseFragment.a(paramInt, paramKeyEvent))) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
  }
  
  public void refreshActivityCenter(GameActivityCenterEntry paramGameActivityCenterEntry)
  {
    Object localObject = this.mCurFragment;
    if ((localObject instanceof GameRoomFragment))
    {
      localObject = (GameRoomFragment)localObject;
    }
    else
    {
      localObject = getFragmentTag(1);
      localObject = (GameBaseFragment)getSupportFragmentManager().findFragmentByTag((String)localObject);
      if ((localObject instanceof GameRoomFragment)) {
        localObject = (GameRoomFragment)localObject;
      } else {
        localObject = null;
      }
    }
    if (localObject != null) {
      ((GameRoomFragment)localObject).a(paramGameActivityCenterEntry);
    }
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshActivityCenter, fragment[");
      localStringBuilder.append(localObject);
      localStringBuilder.append("], entry[");
      localStringBuilder.append(paramGameActivityCenterEntry);
      localStringBuilder.append("]");
      QLog.i("AVGameActivity", 4, localStringBuilder.toString());
    }
  }
  
  public void setActivityState(int paramInt)
  {
    GameEngine.a().a(paramInt, this);
  }
  
  public void showDialogTip(String paramString)
  {
    AVGameHandler.a().c().post(new AVGameActivity.5(this, paramString));
  }
  
  public void showResult()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showResult data: ");
      localStringBuilder.append(GameEngine.a().s());
      QLog.i("AVGameActivity", 2, localStringBuilder.toString());
    }
    if (GameEngine.a().A())
    {
      showFragment(3);
      return;
    }
    showFragment(2);
  }
  
  public void showRoom()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showRoom data: ");
      localStringBuilder.append(GameEngine.a().s());
      QLog.i("AVGameActivity", 2, localStringBuilder.toString());
    }
    showFragment(1);
  }
  
  public void showTransientTip()
  {
    if (((this.mCurFragment instanceof GameRoomFragment)) && (GameEngine.a().d()) && (GameEngine.a().s().I() <= 1)) {
      ((GameRoomFragment)this.mCurFragment).a(getString(2131887264));
    }
  }
  
  public void updateRoomInfo(String paramString, byte[] paramArrayOfByte)
  {
    this.mRoomId = String.valueOf(paramString);
    this.mSignature = paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameActivity
 * JD-Core Version:    0.7.0.1
 */