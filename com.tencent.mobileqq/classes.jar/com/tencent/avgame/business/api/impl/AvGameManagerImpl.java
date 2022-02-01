package com.tencent.avgame.business.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.avbiz.IModule;
import com.tencent.avgame.business.api.IAvGameManager;
import com.tencent.avgame.business.handler.AvGameRoomListHandler;
import com.tencent.avgame.business.observer.AvGameRoomListObserver;
import com.tencent.avgame.gameresult.GameResultUploadMgrForRemote;
import com.tencent.avgame.ipc.AVGameUtilService;
import com.tencent.avgame.ipc.BroadcastCenter;
import com.tencent.avgame.report.AVGamePerfReporter;
import com.tencent.avgame.ui.AvGameLoadingActivity;
import com.tencent.avgame.util.AvGameEntranceUtil;
import com.tencent.avgame.util.AvGameEntranceUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.util.IliveEntranceUtil;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.app.BaseActivity;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class AvGameManagerImpl
  implements IAvGameManager
{
  public static final String TAG = "AvGameManager";
  private BaseQQAppInterface app;
  private ConfigObserver configObserver = null;
  private boolean lobbyEntryStatus = false;
  private AvGameRoomListObserver mAvGameRoomListObserver = new AvGameManagerImpl.1(this);
  BroadcastCenter mBroadcastCenter = null;
  GameResultUploadMgrForRemote mGameResultMgr;
  private String mGameRoomId = null;
  private volatile int mStatus;
  
  public static void asyncPreloadAVGameProcess(AppRuntime paramAppRuntime)
  {
    ThreadManager.excute(new AvGameManagerImpl.2(paramAppRuntime), 16, null, true);
  }
  
  private void getAudio()
  {
    AudioManager localAudioManager = (AudioManager)this.app.getApp().getBaseContext().getSystemService("audio");
    if (localAudioManager != null) {
      localAudioManager.requestAudioFocus(null, 3, 2);
    }
  }
  
  private void init(AppRuntime paramAppRuntime)
  {
    this.app = ((BaseQQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null));
    this.mBroadcastCenter = new BroadcastCenter(this.app);
    this.mBroadcastCenter.a();
    this.app.addObserver(this.mAvGameRoomListObserver);
  }
  
  private boolean preCheckIfOkBeforeEnter(Activity paramActivity, boolean paramBoolean, String paramString)
  {
    if (!AvGameEntranceUtil.a())
    {
      AvGameEntranceUtil.a(paramActivity, paramActivity.getString(2131690316));
      return false;
    }
    if (!NetworkUtil.isNetworkAvailable())
    {
      AvGameEntranceUtil.a(paramActivity, paramActivity.getString(2131690403));
      return false;
    }
    if (preCheckIsOtherBusinessOpen(paramBoolean)) {
      return false;
    }
    if (preCheckIsUserGamePlaying(paramActivity, paramBoolean, paramString))
    {
      QLog.e("AvGameManager", 1, "createAvGameRoom preCheckIsUserGamePlaying  true ");
      return false;
    }
    return true;
  }
  
  private boolean preCheckIsOtherBusinessOpen(boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("preCheckIsOtherBusinessOpen bCreate ");
    ((StringBuilder)localObject1).append(paramBoolean);
    QLog.d("AvGameManager", 2, ((StringBuilder)localObject1).toString());
    if (this.app == null)
    {
      QLog.e("AvGameManager", 1, "preCheckIsUserGamePlaying app null");
      return false;
    }
    localObject1 = AVBizModuleFactory.a("一起派对").b();
    if (!"true".equals(localObject1))
    {
      Object localObject2 = this.app.getApp().getBaseContext();
      QQToast.a((Context)localObject2, String.format(((Context)localObject2).getString(2131690259), new Object[] { localObject1 }), 1).a();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("preCheckIsUserGamePlaying, res[");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("]");
      QLog.e("AvGameManager", 1, ((StringBuilder)localObject2).toString());
      return true;
    }
    if (IliveEntranceUtil.a())
    {
      QQToast.a(this.app.getApp().getBaseContext(), 2131698972, 1).a();
      QLog.e("AvGameManager", 1, "preCheckIsUserGamePlaying qq is in live show");
      return true;
    }
    return false;
  }
  
  private boolean preCheckIsUserGamePlaying(Activity paramActivity, boolean paramBoolean, String paramString)
  {
    if (!isAvGameRoomExist()) {
      return false;
    }
    if (paramBoolean)
    {
      showInPlayDialog(paramActivity, true);
      return true;
    }
    String str = getAvGameRoomId();
    if (TextUtils.isEmpty(str))
    {
      QLog.e("AvGameManager", 1, "preCheckIsUserGamePlaying join  roomPlayingId empty");
      return true;
    }
    if (str.equals(paramString))
    {
      getAudio();
      AvGameLoadingActivity.a(false, paramActivity, null, str, null, "", false, false, null);
      return true;
    }
    showInPlayDialog(paramActivity, false);
    return true;
  }
  
  private boolean preCheckRealNameStatus()
  {
    if (this.configObserver != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AvGameManager", 2, "preCheckRealNameStatus remove observer");
      }
      this.app.removeObserver(this.configObserver);
    }
    return ((ConfigHandler)this.app.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).c();
  }
  
  private void setIsAVGameOpen(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return;
    }
    Object localObject = (ITroopInfoService)this.app.getRuntimeService(ITroopInfoService.class, "");
    TroopInfo localTroopInfo = ((ITroopInfoService)localObject).findTroopInfoInUI(paramString);
    if (localTroopInfo != null)
    {
      localTroopInfo.setIsAVGameOpen(paramBoolean);
      ((ITroopInfoService)localObject).saveTroopInfo(localTroopInfo);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setIsAVGameOpen: ");
        ((StringBuilder)localObject).append(paramBoolean);
        ((StringBuilder)localObject).append(" troopUin: ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("AvGameManager", 2, ((StringBuilder)localObject).toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setIsAVGameOpen troopinfo is null! troopUin: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("AvGameManager", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  private void showInPlayDialog(Activity paramActivity, boolean paramBoolean)
  {
    String str = paramActivity.getString(2131690309);
    if (!paramBoolean) {
      str = paramActivity.getString(2131690358);
    }
    QQCustomDialog localQQCustomDialog = DialogUtil.a(paramActivity, 230);
    if (localQQCustomDialog != null)
    {
      localQQCustomDialog.setMessage(str);
      QLog.d("AvGameManager", 2, "showInPlayDialog  ");
      paramActivity = new AvGameManagerImpl.5(this, paramActivity);
      localQQCustomDialog.setPositiveButton(2131690500, paramActivity);
      localQQCustomDialog.setNegativeButton(2131690728, paramActivity);
      localQQCustomDialog.show();
      return;
    }
    QLog.e("AvGameManager", 1, "preCheckIsUserGamePlaying dialog null");
  }
  
  private void showRealNameDialog(Activity paramActivity, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showRealNameDialog roomId: ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.i("AvGameManager", 2, ((StringBuilder)localObject).toString());
    }
    ReportController.b(null, "dc00898", "", "", "0X800B077", "0X800B077", paramInt3, 0, "", "", "", "");
    Object localObject = new WeakReference(paramActivity);
    paramActivity = DialogUtil.a(paramActivity, 230, paramActivity.getString(2131690525), paramActivity.getString(2131690524), paramActivity.getString(2131699195), paramActivity.getString(2131699197), new AvGameManagerImpl.8(this, (WeakReference)localObject, paramInt3, paramString2, paramInt1, paramInt2, paramString1, paramActivity), new AvGameManagerImpl.9(this));
    paramActivity.setCancelable(false);
    paramActivity.show();
  }
  
  public void createAvGameRoom(Activity paramActivity, int paramInt1, String paramString, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("createAvGameRoom fType ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" pUin");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" gType");
    localStringBuilder.append(paramInt2);
    QLog.i("AvGameManager", 1, localStringBuilder.toString());
    createAvGameRoom(paramActivity, paramInt1, paramString, paramInt2, null);
  }
  
  public void createAvGameRoom(Activity paramActivity, int paramInt1, String paramString, int paramInt2, Bundle paramBundle)
  {
    AVGameUtilService.a(this.app, true);
    if ((paramActivity != null) && (!paramActivity.isFinishing()))
    {
      if (!preCheckIfOkBeforeEnter(paramActivity, true, null))
      {
        QLog.e("AvGameManager", 1, "createAvGameRoom preCheckIfOkBeforeEnter finish");
        return;
      }
      if (!preCheckRealNameStatus())
      {
        int i;
        if ((paramInt1 != 9) && (paramInt1 != 11) && (paramInt1 != 13)) {
          i = 2;
        } else {
          i = 3;
        }
        showRealNameDialog(paramActivity, paramInt1, paramString, "", paramInt2, i);
        return;
      }
      AVGamePerfReporter.a().a("param_StepEntrance");
      if (!AvGameEntranceUtils.a(paramActivity, new AvGameManagerImpl.3(this, paramActivity, paramInt1, paramString, paramInt2, paramBundle))) {
        return;
      }
      getAudio();
      AvGameLoadingActivity.a(true, paramInt1, paramString, null, paramInt2, paramBundle);
      return;
    }
    QLog.e("AvGameManager", 1, "createAvGameRoom activity finish");
  }
  
  public boolean destroyAllGameRoom(String paramString)
  {
    AvGameRoomListHandler localAvGameRoomListHandler = (AvGameRoomListHandler)this.app.getBusinessHandler(AvGameRoomListHandler.a);
    if (localAvGameRoomListHandler != null)
    {
      localAvGameRoomListHandler.a(paramString);
      return true;
    }
    return false;
  }
  
  public String getAvGameRoomId()
  {
    return this.mGameRoomId;
  }
  
  public GameResultUploadMgrForRemote getGameResultShareMgr()
  {
    if (this.mGameResultMgr == null) {
      this.mGameResultMgr = new GameResultUploadMgrForRemote(this.app);
    }
    return this.mGameResultMgr;
  }
  
  public boolean isAVGameOpen(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    paramString = ((ITroopInfoService)this.app.getRuntimeService(ITroopInfoService.class, "")).findTroopInfoInUI(paramString);
    if (paramString != null) {
      return paramString.isAVGameOpen();
    }
    if (QLog.isColorLevel()) {
      QLog.e("AvGameManager", 2, "isAVGameOpen troopinfo is null");
    }
    return false;
  }
  
  public boolean isAvGameRoomExist()
  {
    boolean bool2 = AVGameUtilService.a();
    boolean bool1 = false;
    if (!bool2)
    {
      this.mStatus = 0;
      this.mGameRoomId = null;
      QLog.i("AvGameManager", 2, "isAVGameAlive false");
      return false;
    }
    if (isCurrentPkSurvivalEmptyRoom())
    {
      QLog.d("AvGameManager", 2, "isAvGameRoomExist isCurrentPkSurvivalEmptyRoom");
      return true;
    }
    if (this.mGameRoomId != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isAvGameRoomExist mGameRoomId=");
      localStringBuilder.append(this.mGameRoomId);
      localStringBuilder.append(" strLen=");
      localStringBuilder.append(this.mGameRoomId.length());
      QLog.d("AvGameManager", 2, localStringBuilder.toString());
      if (this.mGameRoomId.length() > 0) {
        bool1 = true;
      }
      return bool1;
    }
    QLog.d("AvGameManager", 2, "isAvGameRoomExist mGameRoomId=null");
    return false;
  }
  
  public boolean isAvGameRoomExistReEnterDialog(Activity paramActivity)
  {
    if (!AVGameUtilService.a())
    {
      QLog.i("AvGameManager", 2, "isAVGameAlive false");
      return false;
    }
    if (this.mGameRoomId != null)
    {
      showInPlayDialog(paramActivity, false);
      return true;
    }
    return false;
  }
  
  public boolean isCurrentPkSurvivalEmptyRoom()
  {
    return this.mStatus == 3;
  }
  
  public boolean isLobbyEntryStatus()
  {
    return this.lobbyEntryStatus;
  }
  
  public boolean isOnlyAllowManagerCreateAVGame(String paramString)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localAppRuntime == null) {
      return false;
    }
    paramString = ((ITroopInfoService)localAppRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfoInUI(paramString);
    if (paramString != null) {
      return paramString.isOnlyAllowManagerCreateAVGame();
    }
    if (QLog.isColorLevel()) {
      QLog.e("AvGameManager", 1, "isOnlyAllowManagerCreateAVGame troopinfo is null");
    }
    return false;
  }
  
  public void joinAvGameRoom(Activity paramActivity, int paramInt, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("joinAvGameRoom fType ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" rId");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" sUin");
    localStringBuilder.append(paramString2);
    QLog.i("AvGameManager", 1, localStringBuilder.toString());
    if ((paramActivity != null) && (!paramActivity.isFinishing()))
    {
      if (!preCheckIfOkBeforeEnter(paramActivity, false, paramString1))
      {
        QLog.e("AvGameManager", 2, "createAvGameRoom preCheckIfOkBeforeEnter finish");
        return;
      }
      if (TextUtils.isEmpty(paramString1))
      {
        QQToast.a(paramActivity, 2131690502, 0).a();
        QLog.e("AvGameManager", 2, "joinAvGameRoom with Empty room id");
        return;
      }
      if (!preCheckRealNameStatus())
      {
        int i;
        if ((paramInt != 6) && (paramInt != 8) && (paramInt != 1000)) {
          i = 1;
        } else {
          i = 3;
        }
        showRealNameDialog(paramActivity, paramInt, paramString2, paramString1, 1, i);
        return;
      }
      AVGamePerfReporter.a().a("param_StepEntrance");
      if (!AvGameEntranceUtils.a(paramActivity, new AvGameManagerImpl.4(this, paramActivity, paramInt, paramString1, paramString2))) {
        return;
      }
      getAudio();
      AvGameLoadingActivity.a(false, paramInt, paramString2, paramString1, 0, null);
      return;
    }
    QLog.e("AvGameManager", 2, "joinAvGameRoom activity finish");
  }
  
  public void notifySendMsg(int paramInt, String paramString1, String paramString2)
  {
    if ((paramInt == 1) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      ThreadManager.getSubThreadHandler().post(new AvGameManagerImpl.6(this, paramString1, paramString2));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifySendMsg shareType ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" friendUin");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("roomId ");
    localStringBuilder.append(paramString2);
    QLog.i("AvGameManager", 2, localStringBuilder.toString());
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    init(paramAppRuntime);
  }
  
  public void onDestroy()
  {
    Object localObject = this.mBroadcastCenter;
    if (localObject != null) {
      ((BroadcastCenter)localObject).b();
    }
    if (this.configObserver != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AvGameManager", 2, "onDestroy remove observer");
      }
      this.app.removeObserver(this.configObserver);
    }
    this.app.removeObserver(this.mAvGameRoomListObserver);
    localObject = this.mGameResultMgr;
    if (localObject != null)
    {
      ((GameResultUploadMgrForRemote)localObject).a();
      this.mGameResultMgr = null;
    }
  }
  
  public void onEnterBackground()
  {
    boolean bool = isAvGameRoomExist();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onEnterBackground isPlaying = ");
      localStringBuilder.append(bool);
      QLog.d("AvGameManager", 2, localStringBuilder.toString());
    }
    if (bool) {
      AVGameUtilService.a(this.app.getApp());
    }
  }
  
  public void onEnterForeground()
  {
    boolean bool = isAvGameRoomExist();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onEnterForeground isPlaying = ");
      localStringBuilder.append(bool);
      QLog.d("AvGameManager", 2, localStringBuilder.toString());
    }
    if (bool) {
      AVGameUtilService.b(this.app.getApp());
    }
  }
  
  public void onPermisionDenied(Activity paramActivity)
  {
    if ((paramActivity != null) && (!paramActivity.isFinishing()))
    {
      boolean bool = paramActivity instanceof QBaseActivity;
      Object localObject2 = null;
      Object localObject1;
      if (bool) {
        localObject1 = (QBaseActivity)paramActivity;
      } else {
        localObject1 = null;
      }
      if ((paramActivity instanceof BaseActivity)) {
        localObject2 = (BaseActivity)paramActivity;
      }
      if ((localObject1 == null) && (localObject2 == null)) {
        return;
      }
      int j = 1;
      int k = 1;
      int i;
      if (localObject1 != null)
      {
        if (((QBaseActivity)localObject1).checkSelfPermission("android.permission.CAMERA") != 0) {
          i = 1;
        } else {
          i = 0;
        }
        if (((QBaseActivity)localObject1).checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
          j = k;
        } else {
          j = 0;
        }
      }
      else if (localObject2 != null)
      {
        if (((BaseActivity)localObject2).checkSelfPermission("android.permission.CAMERA") != 0) {
          i = 1;
        } else {
          i = 0;
        }
        if (((BaseActivity)localObject2).checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
          j = 0;
        }
      }
      else
      {
        i = 1;
      }
      if ((i != 0) && (j != 0)) {
        localObject1 = paramActivity.getResources().getString(2131690416);
      } else if (i != 0) {
        localObject1 = paramActivity.getResources().getString(2131690415);
      } else {
        localObject1 = paramActivity.getResources().getString(2131690414);
      }
      localObject2 = new AvGameManagerImpl.7(this, paramActivity);
      DialogUtil.a(paramActivity, null, (String)localObject1, (DialogInterface.OnClickListener)localObject2, (DialogInterface.OnClickListener)localObject2, null);
      return;
    }
    QLog.e("AvGameManager", 2, "on Permision Denied activity not exist");
  }
  
  public boolean requestGameRoomListForGroup(String paramString, int paramInt1, int paramInt2)
  {
    AvGameRoomListHandler localAvGameRoomListHandler = (AvGameRoomListHandler)this.app.getBusinessHandler(AvGameRoomListHandler.a);
    if (localAvGameRoomListHandler != null)
    {
      localAvGameRoomListHandler.a(paramString, paramInt1, 10, paramInt2);
      return true;
    }
    return false;
  }
  
  public boolean requestGetShareLink(long paramLong1, long paramLong2, String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong3)
  {
    AvGameRoomListHandler localAvGameRoomListHandler = (AvGameRoomListHandler)this.app.getBusinessHandler(AvGameRoomListHandler.a);
    if (localAvGameRoomListHandler != null)
    {
      localAvGameRoomListHandler.a(paramLong1, paramLong2, paramString1, paramInt1, paramString2, paramInt2, paramLong3);
      return true;
    }
    return false;
  }
  
  public boolean requestShareInviteBackflowInfo(String paramString, long paramLong)
  {
    AvGameRoomListHandler localAvGameRoomListHandler = (AvGameRoomListHandler)this.app.getBusinessHandler(AvGameRoomListHandler.a);
    if (localAvGameRoomListHandler != null)
    {
      localAvGameRoomListHandler.a(paramString, paramLong);
      return true;
    }
    return false;
  }
  
  public void setCurrentAvGameRoomInfo(int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      this.mGameRoomId = null;
      localObject = (AudioManager)this.app.getApp().getBaseContext().getSystemService("audio");
      if (localObject != null) {
        ((AudioManager)localObject).abandonAudioFocus(null);
      }
    }
    else if (paramInt == 2)
    {
      if (this.mGameRoomId != null)
      {
        this.mGameRoomId = null;
        QLog.e("AvGameManager", 2, "ac game process death in room playing");
      }
    }
    else
    {
      this.mGameRoomId = paramString;
    }
    this.mStatus = paramInt;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setCurrentAvGameRoomInfo manager ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" roomId");
    ((StringBuilder)localObject).append(paramString);
    QLog.e("AvGameManager", 2, ((StringBuilder)localObject).toString());
  }
  
  public void setLobbyEntryStatus(boolean paramBoolean)
  {
    this.lobbyEntryStatus = paramBoolean;
  }
  
  public void startStrangerMatch(Activity paramActivity, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startStrangerMatch ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("AvGameManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putBoolean("key_stranger_match", true);
    createAvGameRoom(paramActivity, paramInt, null, 0, (Bundle)localObject);
  }
  
  public void startStrangerMatchNotCheck(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startStrangerMatchNotCheck ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("AvGameManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putBoolean("key_stranger_match", true);
    getAudio();
    AvGameLoadingActivity.a(true, paramInt, null, null, 0, (Bundle)localObject);
  }
  
  public void startStrangerMatchV2(Activity paramActivity, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startStrangerMatchV2 ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.i("AvGameManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putBoolean("key_stranger_match_v2", true);
    ((Bundle)localObject).putInt("key_stranger_match_v2_from", paramInt2);
    ((Bundle)localObject).putInt("key_game_type", paramInt1);
    createAvGameRoom(paramActivity, paramInt3, null, paramInt1, (Bundle)localObject);
  }
  
  public void startSurvivalGame(Activity paramActivity, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startSurvivalGame ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("AvGameManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("key_pk_type", paramInt);
    ((Bundle)localObject).putBoolean("key_pk_qqcj", paramBoolean);
    createAvGameRoom(paramActivity, 10, null, 0, (Bundle)localObject);
  }
  
  public void startSurvivalGame(Activity paramActivity, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startSurvivalGame ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" sourceType:");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.i("AvGameManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("key_pk_type", paramInt1);
    ((Bundle)localObject).putBoolean("key_pk_qqcj", paramBoolean);
    ((Bundle)localObject).putInt("key_pk_qqcj_source_type", paramInt2);
    createAvGameRoom(paramActivity, 10, null, 0, (Bundle)localObject);
  }
  
  public void startSurvivalGame(Activity paramActivity, int paramInt1, boolean paramBoolean, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startSurvivalGame ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" sourceType:");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.i("AvGameManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("key_pk_type", paramInt1);
    ((Bundle)localObject).putBoolean("key_pk_qqcj", paramBoolean);
    ((Bundle)localObject).putInt("key_pk_qqcj_source_type", paramInt2);
    ((Bundle)localObject).putString("key_pk_qqcj_qr_to_uin", paramString);
    createAvGameRoom(paramActivity, 10, null, 0, (Bundle)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.business.api.impl.AvGameManagerImpl
 * JD-Core Version:    0.7.0.1
 */