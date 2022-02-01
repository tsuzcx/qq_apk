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
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.tencent.av.utils.QAVConfigUtils;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.business.handler.HandlerFactory;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.controller.GameActivityCenterCtrl;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Game;
import com.tencent.avgame.gamelogic.data.GameActivityCenterEntry;
import com.tencent.avgame.gamelogic.data.GameRecordInfo;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo;
import com.tencent.avgame.gamelogic.handler.GameRoomHandler;
import com.tencent.avgame.gameresult.GamePKResultFragment;
import com.tencent.avgame.gameresult.GamePKResultHelper;
import com.tencent.avgame.gameresult.GameResultBaseHelper;
import com.tencent.avgame.gameresult.GameResultFragment;
import com.tencent.avgame.gameresult.GameResultHelper;
import com.tencent.avgame.gameroom.GameRoomFragment;
import com.tencent.avgame.gameroom.festivalreport.CJSurvivalFestivalReporter;
import com.tencent.avgame.ipc.AVGameClientQIPCModule;
import com.tencent.avgame.ipc.ProcessMonitor;
import com.tencent.avgame.qav.AVGameBusinessCtrl.IOnEnterRoom;
import com.tencent.avgame.util.AVGameNodeReportUtil;
import com.tencent.avgame.util.AVGamePerfReporter;
import com.tencent.avgame.util.AVGameUtils;
import com.tencent.avgame.util.CostTraceUtil;
import com.tencent.mobileqq.app.avgameshare.AVGameShareUtil;
import com.tencent.mobileqq.util.FPSCalculator;
import com.tencent.mobileqq.util.FPSCalculator.GetFPSListener;
import com.tencent.qav.thread.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class AVGameActivity
  extends FragmentActivity
  implements AVGameBusinessCtrl.IOnEnterRoom, IAVGameRootContainer
{
  public static int a;
  public BroadcastReceiver a;
  private PowerManager.WakeLock jdField_a_of_type_AndroidOsPowerManager$WakeLock = null;
  private View jdField_a_of_type_AndroidViewView;
  private AVGameAppInterface jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface;
  private AVGameBackAction jdField_a_of_type_ComTencentAvgameUiAVGameBackAction = null;
  private GameBaseFragment jdField_a_of_type_ComTencentAvgameUiGameBaseFragment;
  FPSCalculator.GetFPSListener jdField_a_of_type_ComTencentMobileqqUtilFPSCalculator$GetFPSListener = new AVGameActivity.1(this);
  private Runnable jdField_a_of_type_JavaLangRunnable = new AVGameActivity.2(this);
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, GameResultBaseHelper> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = false;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private Runnable jdField_b_of_type_JavaLangRunnable = new AVGameActivity.3(this);
  private String jdField_b_of_type_JavaLangString = null;
  private boolean jdField_b_of_type_Boolean = true;
  private Runnable jdField_c_of_type_JavaLangRunnable = new AVGameActivity.7(this);
  private boolean jdField_c_of_type_Boolean = false;
  private boolean d;
  private boolean e;
  private boolean f = false;
  private boolean g = false;
  private boolean h = false;
  
  static
  {
    jdField_a_of_type_Int = 10000;
  }
  
  public AVGameActivity()
  {
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new AVGameActivity.8(this);
  }
  
  private GameBaseFragment a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return GameRoomFragment.a();
    case 2: 
      return GameResultFragment.a();
    }
    return GamePKResultFragment.a();
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return GameBaseFragment.class.getName() + "-unknown";
    case 1: 
      return GameRoomFragment.class.getName();
    case 2: 
      return GameResultFragment.class.getName();
    }
    return GamePKResultFragment.class.getName();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    QLog.i("AVGameActivity", 1, "enterAVGameFail, reason[" + paramInt1 + "], retCode[" + paramInt2 + "]");
    if (paramInt1 == 4)
    {
      AVGameNodeReportUtil.b(-102);
      a(getString(2131690532));
      AVGameNodeReportUtil.b(-202);
    }
    for (;;)
    {
      this.jdField_d_of_type_Boolean = true;
      GameEngine.a().a(false, 7);
      return;
      a(getString(2131690404));
      AVGameNodeReportUtil.b(-201);
    }
  }
  
  private void a(Intent paramIntent)
  {
    int i;
    if ((GameEngine.a().f()) || (paramIntent.getBooleanExtra("key_from_survival", false)))
    {
      i = 1;
      this.g = paramIntent.getBooleanExtra("key_start_match", false);
      if (i == 0) {
        break label52;
      }
      b(paramIntent);
    }
    for (;;)
    {
      d(paramIntent);
      return;
      i = 0;
      break;
      label52:
      c(paramIntent);
    }
  }
  
  private void b(Intent paramIntent)
  {
    this.jdField_e_of_type_Boolean = paramIntent.getBooleanExtra("key_room_be_new_enter", false);
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a().a(3, "");
      boolean bool = paramIntent.getBooleanExtra("key_pk_qqcj", false);
      GameEngine.a().a().a(paramIntent.getIntExtra("key_pk_type", 0), bool);
      if (bool)
      {
        i = paramIntent.getIntExtra("key_pk_qqcj_source_type", 0);
        CJSurvivalFestivalReporter.a(i);
        if (i == 3) {
          CJSurvivalFestivalReporter.a(paramIntent.getStringExtra("key_pk_qqcj_qr_to_uin"));
        }
      }
      GameEngine.a().l();
      if (bool) {
        GameEngine.a().o();
      }
    }
    e(paramIntent);
    int i = GameEngine.a().a().o();
    if ((i == 6) || (i == 7)) {
      GameEngine.a().a().f(0);
    }
    b();
    int j = GameEngine.a().a().a();
    if ((j != 0) && (j != 10) && (i == 3))
    {
      f(paramIntent);
      f();
    }
  }
  
  private void c(int paramInt)
  {
    int k = 0;
    int i;
    Object localObject2;
    Object localObject1;
    if ((GameEngine.a().f()) && (GameEngine.a().i()) && (paramInt == 3))
    {
      i = 1;
      int j = k;
      if (paramInt != 1)
      {
        j = k;
        if (paramInt != 3) {
          j = 1;
        }
      }
      if (((!QAVConfigUtils.m()) || (j == 0)) && (i == 0)) {
        break label234;
      }
      if (paramInt != 2) {
        break label168;
      }
      localObject2 = (GameResultBaseHelper)this.jdField_a_of_type_JavaUtilHashMap.get(GameResultHelper.class.getSimpleName());
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new GameResultHelper(this);
        ((GameResultBaseHelper)localObject1).b();
        this.jdField_a_of_type_JavaUtilHashMap.put(GameResultHelper.class.getSimpleName(), localObject1);
      }
    }
    for (;;)
    {
      label123:
      if (localObject1 != null)
      {
        this.jdField_b_of_type_Int = paramInt;
        this.jdField_a_of_type_ComTencentAvgameUiGameBaseFragment = null;
        ((GameResultBaseHelper)localObject1).a();
        if (GameEngine.a().i()) {
          CJSurvivalFestivalReporter.a();
        }
        GameActivityCenterCtrl.a().b(this);
      }
      label168:
      label234:
      do
      {
        return;
        i = 0;
        break;
        if (paramInt != 3) {
          break label433;
        }
        localObject2 = (GameResultBaseHelper)this.jdField_a_of_type_JavaUtilHashMap.get(GamePKResultHelper.class.getSimpleName());
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label123;
        }
        localObject1 = new GamePKResultHelper(this);
        ((GameResultBaseHelper)localObject1).b();
        this.jdField_a_of_type_JavaUtilHashMap.put(GamePKResultHelper.class.getSimpleName(), localObject1);
        break label123;
      } while ((this.jdField_a_of_type_ComTencentAvgameUiGameBaseFragment != null) && (paramInt == this.jdField_b_of_type_Int));
      String str = a(paramInt);
      localObject2 = getSupportFragmentManager();
      localObject1 = (GameBaseFragment)((FragmentManager)localObject2).findFragmentByTag(str);
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
          ((GameBaseFragment)localObject2).a(this.g);
          localFragmentTransaction.add(2131367438, (Fragment)localObject2, str);
          localObject1 = localObject2;
        }
      }
      for (;;)
      {
        localFragmentTransaction.commitAllowingStateLoss();
        this.jdField_a_of_type_ComTencentAvgameUiGameBaseFragment = ((GameBaseFragment)localObject1);
        this.jdField_b_of_type_Int = paramInt;
        if (localObject1 != null) {
          ((GameBaseFragment)localObject1).a(paramInt);
        }
        if (this.jdField_b_of_type_Int != 1) {
          break;
        }
        GameActivityCenterCtrl.a().a(this);
        return;
        ((GameBaseFragment)localObject1).a(this.g);
        localFragmentTransaction.show((Fragment)localObject1);
      }
      GameActivityCenterCtrl.a().b(this);
      return;
      label433:
      localObject1 = null;
    }
  }
  
  private void c(Intent paramIntent)
  {
    f(paramIntent);
    g();
    int i = GameEngine.a().a().a();
    if ((i == 10) && (!this.jdField_e_of_type_Boolean))
    {
      c();
      return;
    }
    if (i == 10)
    {
      GameEngine.a().a().a().a();
      b();
      return;
    }
    b();
  }
  
  private void d(Intent paramIntent)
  {
    EngineData localEngineData = GameEngine.a().a();
    boolean bool1 = paramIntent.getBooleanExtra("key_room_be_new_enter", false);
    int i = paramIntent.getIntExtra("key_room_from_type", 0);
    boolean bool2 = paramIntent.getBooleanExtra("key_room_is_create", true);
    if (bool1)
    {
      localEngineData.j = i;
      localEngineData.jdField_e_of_type_Boolean = bool2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AVGameActivity", 2, "setFromTypeAndIsCreate isNewEnter：" + bool1 + " fromIsCreate:" + bool2 + " fromType:" + i);
    }
  }
  
  private void e(Intent paramIntent)
  {
    int i = 1;
    if (!paramIntent.getBooleanExtra("key_pk_restart_process", false)) {}
    long l;
    label300:
    label303:
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AVGameActivity", 2, "dealPkFromRestartProcess " + paramIntent.getExtras());
      }
      EngineData localEngineData = GameEngine.a().a();
      localEngineData.jdField_a_of_type_Boolean = true;
      localEngineData.jdField_b_of_type_Int = paramIntent.getIntExtra("key_pk_pool_id", 0);
      localEngineData.jdField_c_of_type_Int = paramIntent.getIntExtra("key_pk_type", 0);
      localEngineData.jdField_d_of_type_Int = paramIntent.getIntExtra("key_pk_cur_round", 0);
      localEngineData.jdField_e_of_type_Int = paramIntent.getIntExtra("key_pk_game_status", 0);
      localEngineData.f = paramIntent.getIntExtra("key_pk_match_status", 0);
      localEngineData.jdField_a_of_type_Long = paramIntent.getLongExtra("key_pk_join_roomid", 0L);
      localEngineData.jdField_d_of_type_Boolean = paramIntent.getBooleanExtra("key_pk_has_av_room", true);
      localEngineData.h = paramIntent.getIntExtra("key_pk_total_num", 0);
      localEngineData.i = localEngineData.h;
      localEngineData.jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("key_pk_qqcj", false);
      Serializable localSerializable = paramIntent.getSerializableExtra("key_pk_result_info");
      if ((localSerializable instanceof SurvivalPkResultInfo)) {
        localEngineData.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo = ((SurvivalPkResultInfo)localSerializable);
      }
      if (paramIntent.getBooleanExtra("key_pk_enter_pool", false))
      {
        GameEngine.a().l();
        if (!localEngineData.jdField_c_of_type_Boolean) {
          break label300;
        }
      }
      for (;;)
      {
        if (localEngineData.f != 2) {
          break label303;
        }
        localEngineData.e(3);
        paramIntent = (GameRoomHandler)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getBusinessHandler(HandlerFactory.jdField_a_of_type_JavaLangString);
        l = localEngineData.jdField_a_of_type_Long;
        if (l > 0L) {
          break label305;
        }
        paramIntent.a(10, null, 0, i);
        return;
        GameEngine.a().n();
        break;
        i = 0;
      }
    }
    label305:
    paramIntent.a(7, String.valueOf(l), "", i);
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVGameActivity", 2, "beginRoomProcess");
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    do
    {
      return;
      AVGamePerfReporter.a().a("param_StepGameReady");
      GameEngine.a().a(Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue());
      GameEngine.a().a(Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin());
    } while (!GameEngine.a().g());
    AVGameHandler.a().a().post(this.jdField_b_of_type_JavaLangRunnable);
  }
  
  private void f(Intent paramIntent)
  {
    boolean bool = false;
    String str = paramIntent.getStringExtra("key_room_id");
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("key_sig");
    if (TextUtils.isEmpty(str)) {}
    this.jdField_e_of_type_Boolean = paramIntent.getBooleanExtra("key_room_be_new_enter", false);
    if (((!this.jdField_e_of_type_Boolean) || (arrayOfByte == null) || (arrayOfByte.length != 0)) || (TextUtils.isEmpty(str)))
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
      EngineData localEngineData = GameEngine.a().a();
      if ((localEngineData != null) && (l == localEngineData.a())) {}
      for (;;)
      {
        paramIntent = paramIntent.getSerializableExtra("key_game_record_info");
        if ((paramIntent instanceof GameRecordInfo))
        {
          localObject = (GameRecordInfo)paramIntent;
          localEngineData = GameEngine.a().a();
          localEngineData.a(((GameRecordInfo)localObject).videoFilePath, ((GameRecordInfo)localObject).photoFilePath, ((GameRecordInfo)localObject).startGameTimeMills);
          localEngineData.a(((GameRecordInfo)localObject).extraJsonData);
        }
        if (QLog.isColorLevel()) {
          QLog.d("AVGameActivity", 2, "initData roomId " + str + " mRoomId " + this.jdField_a_of_type_JavaLangString + " signature " + arrayOfByte + " bNewEnter " + this.jdField_e_of_type_Boolean + " needPullSnapshot " + bool + " recordInfo " + paramIntent);
        }
        this.jdField_a_of_type_JavaLangString = str;
        this.jdField_a_of_type_ArrayOfByte = arrayOfByte;
        if (bool) {
          GameEngine.a().a(l, getCurrentAccountUin(), true, true);
        }
        g(getIntent());
        return;
        if (localObject != null)
        {
          GameEngine.a().a((RoomInfo)localObject);
          bool = true;
        }
        else
        {
          localObject = new RoomInfo();
          ((RoomInfo)localObject).id = l;
          GameEngine.a().a((RoomInfo)localObject);
          bool = true;
        }
      }
      localObject = null;
    }
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVGameActivity", 2, "beginRoomProcess");
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    AVGamePerfReporter.a().a("param_StepGameReady");
    GameEngine.a().a(Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue());
    GameEngine.a().a(Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin());
    AVGameHandler.a().a().post(this.jdField_b_of_type_JavaLangRunnable);
  }
  
  private void g(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("key_start_match", false))
    {
      if (this.jdField_e_of_type_Boolean)
      {
        int i = getIntent().getIntExtra("key_match_game_type", 0);
        GameEngine.a().c(i);
      }
      if (AVGameUtils.b() == 2) {
        GameEngine.a().a().e(true);
      }
    }
  }
  
  @SuppressLint({"InvalidWakeLockTag"})
  private void h()
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
  
  private void i()
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
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
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
    QLog.i("AVGameActivity", 1, "onEnterRoom mGameExited:" + this.jdField_d_of_type_Boolean + " retCode:" + paramInt + " mRoomId:" + this.jdField_a_of_type_JavaLangString + " mFriendUinByCreateC2CRoom" + this.jdField_b_of_type_JavaLangString);
    if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (paramInt == 0)) {
      this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a().a(1, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_d_of_type_Boolean) {}
    EngineData localEngineData;
    do
    {
      do
      {
        return;
        AVGameNodeReportUtil.c();
        ThreadManager.c(new AVGameActivity.6(this, paramInt));
      } while (paramInt != 0);
      localEngineData = GameEngine.a().a();
      if (QLog.isColorLevel()) {
        QLog.i("AVGameActivity", 2, "onEnterRoom changeUserStatus and EngineData is " + localEngineData);
      }
    } while (GameEngine.a().f());
    GameEngine.a().a(localEngineData.a(), GameEngine.a().a().getAccount(), 1, 1);
  }
  
  public void a(GameActivityCenterEntry paramGameActivityCenterEntry)
  {
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentAvgameUiGameBaseFragment instanceof GameRoomFragment)) {
      localObject = (GameRoomFragment)this.jdField_a_of_type_ComTencentAvgameUiGameBaseFragment;
    }
    for (;;)
    {
      if (localObject != null) {
        ((GameRoomFragment)localObject).a(paramGameActivityCenterEntry);
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("AVGameActivity", 4, "refreshActivityCenter, fragment[" + localObject + "], entry[" + paramGameActivityCenterEntry + "]");
      }
      return;
      localObject = a(1);
      localObject = (GameBaseFragment)getSupportFragmentManager().findFragmentByTag((String)localObject);
      if ((localObject instanceof GameRoomFragment)) {
        localObject = (GameRoomFragment)localObject;
      } else {
        localObject = null;
      }
    }
  }
  
  public void a(String paramString)
  {
    AVGameHandler.a().b().post(new AVGameActivity.5(this, paramString));
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_JavaLangString = String.valueOf(paramString);
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public boolean a()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVGameActivity", 2, "showRoom data: " + GameEngine.a().a());
    }
    c(1);
  }
  
  public void b(int paramInt)
  {
    GameEngine.a().a(paramInt, this);
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVGameActivity", 2, "showResult data: " + GameEngine.a().a());
    }
    if (GameEngine.a().f())
    {
      c(3);
      return;
    }
    c(2);
  }
  
  public boolean c()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVGameActivity", 1, "notifyExitGamed mGameExited:" + this.jdField_d_of_type_Boolean);
    }
    this.jdField_d_of_type_Boolean = true;
  }
  
  public boolean d()
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return isDestroyed();
    }
    return this.f;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
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
      if (paramInt2 == -1)
      {
        e();
        AVGameShareUtil.a().a(this, 1, true);
      }
    }
    if (paramInt1 == 291)
    {
      if (!GameEngine.a().f()) {
        break label113;
      }
      paramIntent = (GameResultBaseHelper)this.jdField_a_of_type_JavaUtilHashMap.get(GamePKResultHelper.class.getSimpleName());
      if (paramInt2 != 273) {
        break label133;
      }
      if (paramIntent != null) {
        paramIntent.d();
      }
    }
    label113:
    while (paramInt2 != 546)
    {
      return;
      paramIntent = (GameResultBaseHelper)this.jdField_a_of_type_JavaUtilHashMap.get(GameResultHelper.class.getSimpleName());
      break;
    }
    label133:
    if (paramIntent != null) {
      paramIntent.a(true);
    }
    finish();
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
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface = ((AVGameAppInterface)getAppInterface());
    setContentView(2131558754);
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      QLog.d("AVGameActivity", 1, "doOnCreate intent == null");
      finish();
      return false;
    }
    this.jdField_a_of_type_ComTencentAvgameUiAVGameBackAction = AVGameBackAction.a(paramBundle);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131367438);
    AVGamePerfReporter.a().a(paramBundle);
    AVGameNodeReportUtil.b(paramBundle);
    CostTraceUtil.a().a("AvGameOpenInit", paramBundle);
    this.jdField_d_of_type_Boolean = false;
    this.f = false;
    a(paramBundle);
    if (this.h) {
      FPSCalculator.a().a(this.jdField_a_of_type_ComTencentMobileqqUtilFPSCalculator$GetFPSListener);
    }
    AVGameShareUtil.a().a(this.jdField_a_of_type_AndroidContentBroadcastReceiver, this);
    b(0);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    AVGameHandler.a().b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    QLog.i("AVGameActivity", 1, "doOnDestroy mExitByFinished：" + this.jdField_c_of_type_Boolean);
    a();
    AVGameHandler.a().a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    AVGameHandler.a().b().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    AVGameShareUtil.a().a();
    i();
    this.jdField_a_of_type_ComTencentAvgameUiGameBaseFragment = null;
    this.jdField_b_of_type_Int = 0;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((GameResultBaseHelper)((Map.Entry)localIterator.next()).getValue()).c();
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.f = true;
    com.tencent.avgame.gamelogic.gameres.AvGameResDownloadManager.jdField_a_of_type_JavaLangString = null;
    if (this.h) {
      FPSCalculator.a().b(this.jdField_a_of_type_ComTencentMobileqqUtilFPSCalculator$GetFPSListener);
    }
    AVGameShareUtil.a().b(this.jdField_a_of_type_AndroidContentBroadcastReceiver, this);
    b(5);
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
    if (this.jdField_b_of_type_Int == 1) {
      GameActivityCenterCtrl.a().b(this);
    }
    b(3);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (Build.VERSION.SDK_INT >= 30) {
      AVGameHandler.a().b().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 0L);
    }
    for (;;)
    {
      AVGameHandler.a().b().postDelayed(this.jdField_c_of_type_JavaLangRunnable, 32L);
      if (this.jdField_b_of_type_Int == 1) {
        GameActivityCenterCtrl.a().a(this);
      }
      b(2);
      QLog.i("AVGameActivity", 1, "!!!!!!!!doOnResume");
      return;
      AVGameHandler.a().b().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 600L);
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    h();
    b(1);
    QLog.i("AVGameActivity", 1, "!!!!!!!!doOnStart");
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    a();
    i();
    b(4);
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((this.jdField_b_of_type_Boolean) && (paramBoolean))
    {
      this.jdField_b_of_type_Boolean = false;
      CostTraceUtil.a().c("AVGameActivityInit");
      CostTraceUtil.a().a("AVGameActivityFirstShow", getIntent());
      AVGamePerfReporter.a().a("param_StepLoading", 0);
      AVGamePerfReporter.a().a("param_StepPrepareGame", 0);
      AVGamePerfReporter.a().a("param_StepGameReady");
    }
    QLog.e("AVGameActivity", 1, "!!!!!!!!!!!!doOnWindowFocusChanged " + paramBoolean);
  }
  
  public void e()
  {
    if (((this.jdField_a_of_type_ComTencentAvgameUiGameBaseFragment instanceof GameRoomFragment)) && (GameEngine.a().a()) && (GameEngine.a().a().h() <= 1)) {
      ((GameRoomFragment)this.jdField_a_of_type_ComTencentAvgameUiGameBaseFragment).a(getString(2131690429));
    }
  }
  
  public void finish()
  {
    QLog.i("AVGameActivity", 1, "finish", new Throwable("not crash, print stack"));
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentAvgameUiAVGameBackAction != null) {
      this.jdField_a_of_type_ComTencentAvgameUiAVGameBackAction.a(this);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameActivity
 * JD-Core Version:    0.7.0.1
 */