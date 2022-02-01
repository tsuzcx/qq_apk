package com.tencent.avgame.ui;

import Override;
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
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import aobd;
import bggs;
import bggu;
import bjda;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.data.GameRecordInfo;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gameresult.GameResultFragment;
import com.tencent.avgame.gameroom.GameRoomFragment;
import com.tencent.avgame.ipc.ProcessMonitor;
import com.tencent.avgame.util.AVGameNodeReportUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mxl;
import myc;
import ndd;
import ndx;
import nen;
import nep;
import neq;
import nfr;
import nfu;
import ngg;

public class AVGameActivity
  extends FragmentActivity
  implements ndx, nfr
{
  public static int a;
  public BroadcastReceiver a;
  private PowerManager.WakeLock jdField_a_of_type_AndroidOsPowerManager$WakeLock;
  private View jdField_a_of_type_AndroidViewView;
  bggu jdField_a_of_type_Bggu = new nen(this);
  private AVGameAppInterface jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface;
  private GameBaseFragment jdField_a_of_type_ComTencentAvgameUiGameBaseFragment;
  private Runnable jdField_a_of_type_JavaLangRunnable = new AVGameActivity.2(this);
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private Runnable jdField_b_of_type_JavaLangRunnable = new AVGameActivity.3(this);
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  private Runnable jdField_c_of_type_JavaLangRunnable = new AVGameActivity.7(this);
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  
  static
  {
    jdField_a_of_type_Int = 10000;
  }
  
  public AVGameActivity()
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new nep(this);
  }
  
  private GameBaseFragment a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return GameRoomFragment.a();
    }
    return GameResultFragment.a();
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return GameBaseFragment.class.getName() + "-unknown";
    case 1: 
      return GameRoomFragment.class.getName();
    }
    return GameResultFragment.class.getName();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    QLog.i("AVGameActivity", 1, "enterAVGameFail, reason[" + paramInt1 + "], retCode[" + paramInt2 + "]");
    if (paramInt1 == 4)
    {
      AVGameNodeReportUtil.b(-102);
      a(getString(2131690339));
      AVGameNodeReportUtil.b(-202);
    }
    for (;;)
    {
      this.d = true;
      mxl.a().a(false, 7);
      return;
      a(getString(2131690260));
      AVGameNodeReportUtil.b(-201);
    }
  }
  
  private void a(Intent paramIntent)
  {
    b(paramIntent);
    if ((QLog.isDevelopLevel()) && (paramIntent.getBooleanExtra("enter_game_result", false)))
    {
      b(2);
      return;
    }
    f();
    if (mxl.a().a().a() == 10)
    {
      c();
      return;
    }
    b();
  }
  
  private void b(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentAvgameUiGameBaseFragment != null) && (paramInt == this.jdField_b_of_type_Int)) {
      return;
    }
    String str = a(paramInt);
    Object localObject2 = getSupportFragmentManager();
    Object localObject1 = (GameBaseFragment)((FragmentManager)localObject2).findFragmentByTag(str);
    FragmentTransaction localFragmentTransaction = ((FragmentManager)localObject2).beginTransaction();
    if ((this.jdField_a_of_type_ComTencentAvgameUiGameBaseFragment != null) && (paramInt != this.jdField_b_of_type_Int))
    {
      this.jdField_a_of_type_ComTencentAvgameUiGameBaseFragment.a(paramInt);
      localFragmentTransaction.hide(this.jdField_a_of_type_ComTencentAvgameUiGameBaseFragment);
    }
    if (localObject1 == null)
    {
      localObject2 = a(paramInt);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localFragmentTransaction.add(2131367067, (Fragment)localObject2, str);
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      localFragmentTransaction.commitAllowingStateLoss();
      this.jdField_a_of_type_ComTencentAvgameUiGameBaseFragment = ((GameBaseFragment)localObject1);
      this.jdField_b_of_type_Int = paramInt;
      ((GameBaseFragment)localObject1).a(paramInt);
      return;
      localFragmentTransaction.show((Fragment)localObject1);
    }
  }
  
  private void b(Intent paramIntent)
  {
    boolean bool = false;
    String str = paramIntent.getStringExtra("key_room_id");
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("key_sig");
    if (TextUtils.isEmpty(str)) {}
    this.e = paramIntent.getBooleanExtra("key_room_be_new_enter", false);
    if (((!this.e) || (arrayOfByte == null) || (arrayOfByte.length != 0)) || (TextUtils.isEmpty(str)))
    {
      a(4, 0);
      return;
    }
    this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("key_room_friend_uin");
    Object localObject = paramIntent.getBundleExtra("key_room_bundle");
    if (localObject != null)
    {
      localObject = ((Bundle)localObject).getSerializable("key_room_info");
      if ((localObject instanceof RoomInfo))
      {
        localObject = (RoomInfo)localObject;
        QLog.d("AVGameActivity", 2, "roominfo :  " + ((RoomInfo)localObject).toString() + " players:" + ((RoomInfo)localObject).players.size());
      }
    }
    for (;;)
    {
      long l = Long.valueOf(str).longValue();
      if (l == mxl.a().a().a()) {}
      for (;;)
      {
        paramIntent = paramIntent.getSerializableExtra("key_game_record_info");
        if ((paramIntent instanceof GameRecordInfo))
        {
          localObject = (GameRecordInfo)paramIntent;
          myc localmyc = mxl.a().a();
          localmyc.a(((GameRecordInfo)localObject).videoFilePath, ((GameRecordInfo)localObject).photoFilePath, ((GameRecordInfo)localObject).startGameTimeMills);
          localmyc.a(((GameRecordInfo)localObject).extraJsonData);
        }
        if (QLog.isColorLevel()) {
          QLog.d("AVGameActivity", 2, "initData roomId " + str + " mRoomId " + this.jdField_a_of_type_JavaLangString + " signature " + arrayOfByte + " bNewEnter " + this.e + " needPullSnapshot " + bool + " recordInfo " + paramIntent);
        }
        this.jdField_a_of_type_JavaLangString = str;
        this.jdField_a_of_type_ArrayOfByte = arrayOfByte;
        if (!bool) {
          break;
        }
        mxl.a().a(l, getCurrentAccountUin(), true, true);
        return;
        if (localObject != null)
        {
          mxl.a().a((RoomInfo)localObject);
          bool = true;
        }
        else
        {
          localObject = new RoomInfo();
          ((RoomInfo)localObject).id = l;
          mxl.a().a((RoomInfo)localObject);
          bool = true;
        }
      }
      localObject = null;
    }
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVGameActivity", 2, "beginRoomProcess");
    }
    nfu.a().a("param_StepGameReady");
    mxl.a().a(Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue());
    mxl.a().a(Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin());
    neq.a().a().post(this.jdField_b_of_type_JavaLangRunnable);
  }
  
  @SuppressLint({"InvalidWakeLockTag"})
  private void g()
  {
    if (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock == null) {
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock = ((PowerManager)getApplicationContext().getSystemService("power")).newWakeLock(536870918, "AVGameActivity");
    }
    if (!this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.isHeld()) {
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.acquire();
    }
    if (QLog.isColorLevel()) {
      QLog.d("AVGameActivity", 2, "remainScreenOn");
    }
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_AndroidOsPowerManager$WakeLock != null) && (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.isHeld()))
    {
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AVGameActivity", 2, "cancelRemainScreenOn");
    }
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getApp().sendBroadcast(new Intent("com.tencent.avgame.ui.AvGameLoadingActivity.ACTION_LOADING_FINISH"));
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(int paramInt)
  {
    QLog.i("AVGameActivity", 1, "onEnterRoom mGameExited:" + this.d + " retCode:" + paramInt + " mRoomId:" + this.jdField_a_of_type_JavaLangString + " mFriendUinByCreateC2CRoom" + this.jdField_b_of_type_JavaLangString);
    if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (paramInt == 0)) {
      this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a().a(1, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
    }
    if (this.d) {}
    do
    {
      return;
      AVGameNodeReportUtil.c();
      bjda.c(new AVGameActivity.6(this, paramInt));
    } while (paramInt != 0);
    myc localmyc = mxl.a().a();
    if (QLog.isColorLevel()) {
      QLog.i("AVGameActivity", 2, "onEnterRoom changeUserStatus and EngineData is " + localmyc);
    }
    mxl.a().a(localmyc.a(), mxl.a().a().getAccount(), 1, 1);
  }
  
  public void a(String paramString)
  {
    neq.a().b().post(new AVGameActivity.5(this, paramString));
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVGameActivity", 2, "showRoom data: " + mxl.a().a());
    }
    b(1);
  }
  
  public boolean b()
  {
    return this.e;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVGameActivity", 2, "showResult data: " + mxl.a().a());
    }
    b(2);
  }
  
  public boolean c()
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return isDestroyed();
    }
    return this.f;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVGameActivity", 1, "notifyExitGamed mGameExited:" + this.d);
    }
    this.d = true;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == jdField_a_of_type_Int)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AVGameActivity", 1, "doOnActivityResult:" + paramInt2);
      }
      if (paramInt2 == -1) {
        e();
      }
    }
  }
  
  public void doOnBackPressed()
  {
    if ((this.jdField_a_of_type_ComTencentAvgameUiGameBaseFragment != null) && (this.jdField_a_of_type_ComTencentAvgameUiGameBaseFragment.a())) {
      return;
    }
    super.doOnBackPressed();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    ProcessMonitor.a().a("AVGameActivity_doOnCreate");
    ngg.a().b("AVGameActivityInit");
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    getActivity().getWindow().getDecorView().setBackgroundDrawable(null);
    getWindow().setFlags(16777216, 16777216);
    super.doOnCreate(paramBundle);
    getWindow().addFlags(128);
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface = ((AVGameAppInterface)getAppInterface());
    setContentView(2131558705);
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      QLog.d("AVGameActivity", 1, "doOnCreate intent == null");
      finish();
      return false;
    }
    this.jdField_a_of_type_AndroidViewView = findViewById(2131367067);
    nfu.a().a(paramBundle);
    AVGameNodeReportUtil.b(paramBundle);
    ngg.a().a("AvGameOpenInit", paramBundle);
    this.d = false;
    this.f = false;
    a(paramBundle);
    if (this.g) {
      bggs.a().a(this.jdField_a_of_type_Bggu);
    }
    aobd.a().a(this.jdField_a_of_type_AndroidContentBroadcastReceiver, this);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    neq.a().b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    QLog.i("AVGameActivity", 1, "doOnDestroy mExitByFinished：" + this.jdField_c_of_type_Boolean);
    a();
    neq.a().a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    neq.a().b().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    aobd.a().a();
    h();
    this.jdField_a_of_type_ComTencentAvgameUiGameBaseFragment = null;
    this.jdField_b_of_type_Int = 0;
    this.f = true;
    if (this.g) {
      bggs.a().b(this.jdField_a_of_type_Bggu);
    }
    aobd.a().b(this.jdField_a_of_type_AndroidContentBroadcastReceiver, this);
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    ProcessMonitor.a().a("AVGameActivity_doOnNewIntent");
    a(paramIntent);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    neq.a().b().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 600L);
    neq.a().b().postDelayed(this.jdField_c_of_type_JavaLangRunnable, 32L);
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    this.jdField_c_of_type_Boolean = false;
    this.d = false;
    g();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    a();
    h();
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((this.jdField_b_of_type_Boolean) && (paramBoolean))
    {
      this.jdField_b_of_type_Boolean = false;
      ngg.a().c("AVGameActivityInit");
      ngg.a().a("AVGameActivityFirstShow", getIntent());
      nfu.a().a("param_StepLoading", 0);
      nfu.a().a("param_StepPrepareGame", 0);
      nfu.a().a("param_StepGameReady");
    }
  }
  
  public void e()
  {
    if (((this.jdField_a_of_type_ComTencentAvgameUiGameBaseFragment instanceof GameRoomFragment)) && (mxl.a().a()) && (mxl.a().a().h() <= 1)) {
      ((GameRoomFragment)this.jdField_a_of_type_ComTencentAvgameUiGameBaseFragment).a(getString(2131690280));
    }
  }
  
  public void finish()
  {
    QLog.i("AVGameActivity", 1, "finish", new Throwable("not crash, print stack"));
    this.jdField_c_of_type_Boolean = true;
    super.finish();
  }
  
  public boolean isWrapContent()
  {
    if (this.jdField_a_of_type_ComTencentAvgameUiGameBaseFragment != null) {
      return this.jdField_a_of_type_ComTencentAvgameUiGameBaseFragment.b();
    }
    return super.isWrapContent();
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((this.jdField_a_of_type_ComTencentAvgameUiGameBaseFragment != null) && (this.jdField_a_of_type_ComTencentAvgameUiGameBaseFragment.a(paramInt, paramKeyEvent))) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameActivity
 * JD-Core Version:    0.7.0.1
 */