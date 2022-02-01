package com.tencent.avgame.business;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.avgame.business.handler.AvGameRoomListHandler;
import com.tencent.avgame.business.observer.AvGameRoomListObserver;
import com.tencent.avgame.gameresult.GameResultUploadMgrForRemote;
import com.tencent.avgame.ipc.AVGameUtilService;
import com.tencent.avgame.ipc.BroadcastCenter;
import com.tencent.avgame.ui.AvGameLoadingActivity;
import com.tencent.avgame.util.AVGamePerfReporter;
import com.tencent.avgame.util.AvGameEntranceUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.util.IliveEntranceUtil;
import java.lang.ref.WeakReference;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class AvGameManager
  implements Manager
{
  private volatile int jdField_a_of_type_Int;
  private AvGameRoomListObserver jdField_a_of_type_ComTencentAvgameBusinessObserverAvGameRoomListObserver = new AvGameManager.1(this);
  GameResultUploadMgrForRemote jdField_a_of_type_ComTencentAvgameGameresultGameResultUploadMgrForRemote;
  BroadcastCenter jdField_a_of_type_ComTencentAvgameIpcBroadcastCenter = null;
  private ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver = null;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString = null;
  private boolean jdField_a_of_type_Boolean = false;
  
  public AvGameManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentAvgameIpcBroadcastCenter = new BroadcastCenter(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentAvgameIpcBroadcastCenter.a();
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentAvgameBusinessObserverAvGameRoomListObserver);
  }
  
  private void a(Activity paramActivity, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameManager", 2, "showRealNameDialog roomId: " + paramString2);
    }
    ReportController.b(null, "dc00898", "", "", "0X800B077", "0X800B077", paramInt3, 0, "", "", "", "");
    WeakReference localWeakReference = new WeakReference(paramActivity);
    paramActivity = DialogUtil.a(paramActivity, 230, paramActivity.getString(2131690597), paramActivity.getString(2131690596), paramActivity.getString(2131699088), paramActivity.getString(2131699090), new AvGameManager.8(this, localWeakReference, paramInt3, paramString2, paramInt1, paramInt2, paramString1, paramActivity), new AvGameManager.9(this));
    paramActivity.setCancelable(false);
    paramActivity.show();
  }
  
  private void a(Activity paramActivity, boolean paramBoolean)
  {
    String str = paramActivity.getString(2131690386);
    if (!paramBoolean) {
      str = paramActivity.getString(2131690434);
    }
    QQCustomDialog localQQCustomDialog = DialogUtil.a(paramActivity, 230);
    if (localQQCustomDialog != null)
    {
      localQQCustomDialog.setMessage(str);
      QLog.d("AvGameManager", 2, "showInPlayDialog  ");
      paramActivity = new AvGameManager.5(this, paramActivity);
      localQQCustomDialog.setPositiveButton(2131690572, paramActivity);
      localQQCustomDialog.setNegativeButton(2131690800, paramActivity);
      localQQCustomDialog.show();
      return;
    }
    QLog.e("AvGameManager", 1, "preCheckIsUserGamePlaying dialog null");
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.excute(new AvGameManager.2(paramQQAppInterface), 16, null, true);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {}
    do
    {
      do
      {
        return;
        TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        TroopInfo localTroopInfo = localTroopManager.a(paramString);
        if (localTroopInfo == null) {
          break;
        }
        localTroopInfo.setIsAVGameOpen(paramBoolean);
        localTroopManager.b(localTroopInfo);
      } while (!QLog.isColorLevel());
      QLog.d("AvGameManager", 2, "setIsAVGameOpen: " + paramBoolean + " troopUin: " + paramString);
      return;
    } while (!QLog.isColorLevel());
    QLog.e("AvGameManager", 1, "setIsAVGameOpen troopinfo is null! troopUin: " + paramString);
  }
  
  private boolean a(Activity paramActivity, boolean paramBoolean, String paramString)
  {
    if (!a()) {
      return false;
    }
    if (paramBoolean) {
      a(paramActivity, true);
    }
    for (;;)
    {
      return true;
      String str = a();
      if (TextUtils.isEmpty(str))
      {
        QLog.e("AvGameManager", 1, "preCheckIsUserGamePlaying join  roomPlayingId empty");
        return true;
      }
      if (str.equals(paramString))
      {
        c();
        AvGameLoadingActivity.a(false, paramActivity, null, str, null, "", false, false, null);
      }
      else
      {
        a(paramActivity, false);
      }
    }
  }
  
  private boolean a(boolean paramBoolean)
  {
    QLog.d("AvGameManager", 2, "preCheckIsOtherBusinessOpen bCreate " + paramBoolean);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      QLog.e("AvGameManager", 1, "preCheckIsUserGamePlaying app null");
    }
    do
    {
      return false;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a())
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext(), 2131690349, 1).a();
        QLog.e("AvGameManager", 1, "preCheckIsUserGamePlaying isPhoneCalling");
        return true;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().b())
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext(), 2131690349, 1).a();
        QLog.e("AvGameManager", 1, "preCheckIsUserGamePlaying isAvChating");
        return true;
      }
    } while (!IliveEntranceUtil.a());
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext(), 2131698893, 1).a();
    QLog.e("AvGameManager", 1, "preCheckIsUserGamePlaying qq is in live show");
    return true;
  }
  
  private boolean b(Activity paramActivity, boolean paramBoolean, String paramString)
  {
    if (!AvGameEntranceUtil.b()) {
      AvGameEntranceUtil.a(paramActivity, paramActivity.getString(2131690392));
    }
    do
    {
      return false;
      if (!NetworkUtil.a())
      {
        AvGameEntranceUtil.a(paramActivity, paramActivity.getString(2131690479));
        return false;
      }
    } while (a(paramBoolean));
    if (a(paramActivity, paramBoolean, paramString))
    {
      QLog.e("AvGameManager", 1, "createAvGameRoom preCheckIsUserGamePlaying  true ");
      return false;
    }
    return true;
  }
  
  private void c()
  {
    AudioManager localAudioManager = (AudioManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext().getSystemService("audio");
    if (localAudioManager != null) {
      localAudioManager.requestAudioFocus(null, 3, 2);
    }
  }
  
  private boolean d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AvGameManager", 2, "preCheckRealNameStatus remove observer");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    }
    return ((ConfigHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).c();
  }
  
  public GameResultUploadMgrForRemote a()
  {
    if (this.jdField_a_of_type_ComTencentAvgameGameresultGameResultUploadMgrForRemote == null) {
      this.jdField_a_of_type_ComTencentAvgameGameresultGameResultUploadMgrForRemote = new GameResultUploadMgrForRemote(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return this.jdField_a_of_type_ComTencentAvgameGameresultGameResultUploadMgrForRemote;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    boolean bool = a();
    if (QLog.isColorLevel()) {
      QLog.d("AvGameManager", 2, "onEnterBackground isPlaying = " + bool);
    }
    if (bool) {
      AVGameUtilService.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameManager", 2, "startStrangerMatchNotCheck " + paramInt);
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_stranger_match", true);
    c();
    AvGameLoadingActivity.a(true, paramInt, null, null, 0, localBundle);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_JavaLangString = null;
      AudioManager localAudioManager = (AudioManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext().getSystemService("audio");
      if (localAudioManager != null) {
        localAudioManager.abandonAudioFocus(null);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt;
      QLog.e("AvGameManager", 2, "setCurrentAvGameRoomInfo manager " + paramInt + " roomId" + paramString);
      return;
      if (paramInt == 2)
      {
        if (this.jdField_a_of_type_JavaLangString != null)
        {
          this.jdField_a_of_type_JavaLangString = null;
          QLog.e("AvGameManager", 2, "ac game process death in room playing");
        }
      }
      else {
        this.jdField_a_of_type_JavaLangString = paramString;
      }
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if ((paramInt == 1) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      ThreadManager.getSubThreadHandler().post(new AvGameManager.6(this, paramString1, paramString2));
    }
    QLog.i("AvGameManager", 2, "notifySendMsg shareType " + paramInt + " friendUin" + paramString1 + "roomId " + paramString2);
  }
  
  public void a(Activity paramActivity)
  {
    int k = 1;
    if ((paramActivity == null) || (paramActivity.isFinishing()))
    {
      QLog.e("AvGameManager", 2, "on Permision Denied activity not exist");
      return;
    }
    Object localObject1;
    label37:
    Object localObject2;
    label50:
    int i;
    if ((paramActivity instanceof com.tencent.mobileqq.app.BaseActivity))
    {
      localObject1 = (com.tencent.mobileqq.app.BaseActivity)paramActivity;
      if (!(paramActivity instanceof mqq.app.BaseActivity)) {
        break label141;
      }
      localObject2 = (mqq.app.BaseActivity)paramActivity;
      if ((localObject1 == null) && (localObject2 == null)) {
        break label145;
      }
      if (localObject1 == null) {
        break label158;
      }
      if (((com.tencent.mobileqq.app.BaseActivity)localObject1).checkSelfPermission("android.permission.CAMERA") == 0) {
        break label147;
      }
      i = 1;
      label78:
      if (((com.tencent.mobileqq.app.BaseActivity)localObject1).checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        break label152;
      }
    }
    for (;;)
    {
      label89:
      if ((i != 0) && (k != 0)) {
        localObject1 = paramActivity.getResources().getString(2131690492);
      }
      for (;;)
      {
        localObject2 = new AvGameManager.7(this, paramActivity);
        DialogUtil.a(paramActivity, null, (String)localObject1, (DialogInterface.OnClickListener)localObject2, (DialogInterface.OnClickListener)localObject2, null);
        return;
        localObject1 = null;
        break label37;
        label141:
        localObject2 = null;
        break label50;
        label145:
        break;
        label147:
        i = 0;
        break label78;
        label152:
        k = 0;
        break label89;
        label158:
        if (localObject2 == null) {
          break label236;
        }
        if (((mqq.app.BaseActivity)localObject2).checkSelfPermission("android.permission.CAMERA") != 0) {}
        for (int j = 1;; j = 0)
        {
          i = j;
          if (((mqq.app.BaseActivity)localObject2).checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
            break;
          }
          k = 0;
          i = j;
          break;
        }
        if (i != 0) {
          localObject1 = paramActivity.getResources().getString(2131690491);
        } else {
          localObject1 = paramActivity.getResources().getString(2131690490);
        }
      }
      label236:
      i = 1;
    }
  }
  
  public void a(Activity paramActivity, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameManager", 2, "startStrangerMatch " + paramInt);
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_stranger_match", true);
    a(paramActivity, paramInt, null, 0, localBundle);
  }
  
  public void a(Activity paramActivity, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameManager", 2, "startStrangerMatchV2 " + paramInt1 + " " + paramInt2);
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_stranger_match_v2", true);
    localBundle.putInt("key_stranger_match_v2_from", paramInt2);
    localBundle.putInt("key_game_type", paramInt1);
    a(paramActivity, paramInt3, null, paramInt1, localBundle);
  }
  
  public void a(Activity paramActivity, int paramInt1, String paramString, int paramInt2)
  {
    QLog.i("AvGameManager", 1, "createAvGameRoom fType " + paramInt1 + " pUin" + paramString + " gType" + paramInt2);
    a(paramActivity, paramInt1, paramString, paramInt2, null);
  }
  
  public void a(Activity paramActivity, int paramInt1, String paramString, int paramInt2, Bundle paramBundle)
  {
    AVGameUtilService.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
    if ((paramActivity == null) || (paramActivity.isFinishing())) {
      QLog.e("AvGameManager", 1, "createAvGameRoom activity finish");
    }
    do
    {
      return;
      if (!b(paramActivity, true, null))
      {
        QLog.e("AvGameManager", 1, "createAvGameRoom preCheckIfOkBeforeEnter finish");
        return;
      }
      if (!d())
      {
        if ((paramInt1 == 9) || (paramInt1 == 11) || (paramInt1 == 13)) {}
        for (int i = 3;; i = 2)
        {
          a(paramActivity, paramInt1, paramString, "", paramInt2, i);
          return;
        }
      }
      AVGamePerfReporter.a().a("param_StepEntrance");
    } while (!AvGameEntranceUtil.a(paramActivity, new AvGameManager.3(this, paramActivity, paramInt1, paramString, paramInt2, paramBundle)));
    c();
    AvGameLoadingActivity.a(true, paramInt1, paramString, null, paramInt2, paramBundle);
  }
  
  public void a(Activity paramActivity, int paramInt, String paramString1, String paramString2)
  {
    QLog.i("AvGameManager", 1, "joinAvGameRoom fType " + paramInt + " rId" + paramString1 + " sUin" + paramString2);
    if ((paramActivity == null) || (paramActivity.isFinishing())) {
      QLog.e("AvGameManager", 2, "joinAvGameRoom activity finish");
    }
    do
    {
      return;
      if (!b(paramActivity, false, paramString1))
      {
        QLog.e("AvGameManager", 2, "createAvGameRoom preCheckIfOkBeforeEnter finish");
        return;
      }
      if (TextUtils.isEmpty(paramString1))
      {
        QQToast.a(paramActivity, 2131690574, 0).a();
        QLog.e("AvGameManager", 2, "joinAvGameRoom with Empty room id");
        return;
      }
      if (!d())
      {
        if ((paramInt == 6) || (paramInt == 8) || (paramInt == 1000)) {}
        for (int i = 3;; i = 1)
        {
          a(paramActivity, paramInt, paramString2, paramString1, 1, i);
          return;
        }
      }
      AVGamePerfReporter.a().a("param_StepEntrance");
    } while (!AvGameEntranceUtil.a(paramActivity, new AvGameManager.4(this, paramActivity, paramInt, paramString1, paramString2)));
    c();
    AvGameLoadingActivity.a(false, paramInt, paramString2, paramString1, 0, null);
  }
  
  public void a(Activity paramActivity, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameManager", 2, "startSurvivalGame " + paramInt1 + " " + paramBoolean + " sourceType:" + paramInt2);
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_pk_type", paramInt1);
    localBundle.putBoolean("key_pk_qqcj", paramBoolean);
    localBundle.putInt("key_pk_qqcj_source_type", paramInt2);
    a(paramActivity, 10, null, 0, localBundle);
  }
  
  public void a(Activity paramActivity, int paramInt1, boolean paramBoolean, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameManager", 2, "startSurvivalGame " + paramInt1 + " " + paramBoolean + " sourceType:" + paramInt2);
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_pk_type", paramInt1);
    localBundle.putBoolean("key_pk_qqcj", paramBoolean);
    localBundle.putInt("key_pk_qqcj_source_type", paramInt2);
    localBundle.putString("key_pk_qqcj_qr_to_uin", paramString);
    a(paramActivity, 10, null, 0, localBundle);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    boolean bool = true;
    if (!AVGameUtilService.a())
    {
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_JavaLangString = null;
      QLog.i("AvGameManager", 2, "isAVGameAlive false");
      return false;
    }
    if (b())
    {
      QLog.d("AvGameManager", 2, "isAvGameRoomExist isCurrentPkSurvivalEmptyRoom");
      return true;
    }
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      QLog.d("AvGameManager", 2, "isAvGameRoomExist mGameRoomId=" + this.jdField_a_of_type_JavaLangString + " strLen=" + this.jdField_a_of_type_JavaLangString.length());
      if (this.jdField_a_of_type_JavaLangString.length() > 0) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
    }
    QLog.d("AvGameManager", 2, "isAvGameRoomExist mGameRoomId=null");
    return false;
  }
  
  public boolean a(long paramLong1, long paramLong2, String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong3)
  {
    AvGameRoomListHandler localAvGameRoomListHandler = (AvGameRoomListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.AV_GAME_HANDLER);
    if (localAvGameRoomListHandler != null)
    {
      localAvGameRoomListHandler.a(paramLong1, paramLong2, paramString1, paramInt1, paramString2, paramInt2, paramLong3);
      return true;
    }
    return false;
  }
  
  public boolean a(Activity paramActivity)
  {
    if (!AVGameUtilService.a()) {
      QLog.i("AvGameManager", 2, "isAVGameAlive false");
    }
    while (this.jdField_a_of_type_JavaLangString == null) {
      return false;
    }
    a(paramActivity, false);
    return true;
  }
  
  public boolean a(String paramString)
  {
    AvGameRoomListHandler localAvGameRoomListHandler = (AvGameRoomListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.AV_GAME_HANDLER);
    if (localAvGameRoomListHandler != null)
    {
      localAvGameRoomListHandler.a(paramString);
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2)
  {
    AvGameRoomListHandler localAvGameRoomListHandler = (AvGameRoomListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.AV_GAME_HANDLER);
    if (localAvGameRoomListHandler != null)
    {
      localAvGameRoomListHandler.a(paramString, paramInt1, 10, paramInt2);
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString, long paramLong)
  {
    AvGameRoomListHandler localAvGameRoomListHandler = (AvGameRoomListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.AV_GAME_HANDLER);
    if (localAvGameRoomListHandler != null)
    {
      localAvGameRoomListHandler.a(paramString, paramLong);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    boolean bool = a();
    if (QLog.isColorLevel()) {
      QLog.d("AvGameManager", 2, "onEnterForeground isPlaying = " + bool);
    }
    if (bool) {
      AVGameUtilService.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Int == 3;
  }
  
  public boolean b(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    paramString = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a(paramString);
    if (paramString != null) {}
    for (boolean bool = paramString.isAVGameOpen();; bool = false)
    {
      return bool;
      if (QLog.isColorLevel()) {
        QLog.e("AvGameManager", 2, "isAVGameOpen troopinfo is null");
      }
    }
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean c(String paramString)
  {
    paramString = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a(paramString);
    if (paramString != null) {
      return paramString.isOnlyAllowManagerCreateAVGame();
    }
    if (QLog.isColorLevel()) {
      QLog.e("AvGameManager", 1, "isOnlyAllowManagerCreateAVGame troopinfo is null");
    }
    return false;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentAvgameIpcBroadcastCenter != null) {
      this.jdField_a_of_type_ComTencentAvgameIpcBroadcastCenter.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AvGameManager", 2, "onDestroy remove observer");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentAvgameBusinessObserverAvGameRoomListObserver);
    if (this.jdField_a_of_type_ComTencentAvgameGameresultGameResultUploadMgrForRemote != null)
    {
      this.jdField_a_of_type_ComTencentAvgameGameresultGameResultUploadMgrForRemote.a();
      this.jdField_a_of_type_ComTencentAvgameGameresultGameResultUploadMgrForRemote = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.business.AvGameManager
 * JD-Core Version:    0.7.0.1
 */