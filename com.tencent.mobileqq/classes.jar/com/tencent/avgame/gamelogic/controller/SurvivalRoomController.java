package com.tencent.avgame.gamelogic.controller;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.business.handler.HandlerFactory;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gamelogic.handler.GameRoomHandler;
import com.tencent.avgame.gamelogic.listener.GameActivityLifeCycleListener;
import com.tencent.avgame.ipc.AVGameClientQIPCModule;
import com.tencent.avgame.qav.AVGameBusinessCtrl;
import com.tencent.avgame.qav.AVGameBusinessCtrl.IOnEnterRoom;
import com.tencent.avgame.session.AVGameSession;
import com.tencent.avgame.ui.AVGameActivity;
import com.tencent.avgame.ui.AVGameHandler;
import com.tencent.avgame.util.AVGameNodeReportUtil;
import com.tencent.avgame.util.AVGamePerfReporter;
import com.tencent.avgame.util.AVGameUtils;
import com.tencent.avgame.util.AvGameEntranceUtil;
import com.tencent.avgame.videorecord.SimpleGameRoomStatusListener;
import com.tencent.common.app.AppInterface;
import com.tencent.qav.thread.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class SurvivalRoomController
  implements ISurvivalRoomController, AVGameBusinessCtrl.IOnEnterRoom
{
  private RoomController jdField_a_of_type_ComTencentAvgameGamelogicControllerRoomController;
  private final GameActivityLifeCycleListener jdField_a_of_type_ComTencentAvgameGamelogicListenerGameActivityLifeCycleListener = new SurvivalRoomController.2(this);
  private SimpleGameRoomStatusListener jdField_a_of_type_ComTencentAvgameVideorecordSimpleGameRoomStatusListener = new SurvivalRoomController.1(this);
  private Runnable jdField_a_of_type_JavaLangRunnable;
  
  public SurvivalRoomController(RoomController paramRoomController)
  {
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerRoomController = paramRoomController;
    GameEngine.a().a(this.jdField_a_of_type_ComTencentAvgameVideorecordSimpleGameRoomStatusListener);
    GameEngine.a().a(this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameActivityLifeCycleListener);
  }
  
  private AVGameActivity a()
  {
    Activity localActivity = this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameActivityLifeCycleListener.a();
    if ((localActivity != null) && ((localActivity instanceof AVGameActivity))) {
      return (AVGameActivity)localActivity;
    }
    return null;
  }
  
  private void a(AVGameActivity paramAVGameActivity, int paramInt1, int paramInt2)
  {
    QLog.i("SurvivalRoomController", 1, "enterAVGameFail, reason[" + paramInt1 + "], retCode[" + paramInt2 + "]");
    if (paramInt1 == 4)
    {
      AVGameNodeReportUtil.b(-102);
      AVGameUtils.a(paramAVGameActivity.getString(2131690532), paramAVGameActivity);
      AVGameNodeReportUtil.b(-202);
    }
    for (;;)
    {
      paramAVGameActivity.d();
      GameEngine.a().a(false, 7);
      return;
      AVGameUtils.a(paramAVGameActivity.getString(2131690404), paramAVGameActivity);
      AVGameNodeReportUtil.b(-201);
    }
  }
  
  private void a(AVGameActivity paramAVGameActivity, long paramLong, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SurvivalRoomController", 2, "beginRoomProcess");
    }
    AVGamePerfReporter.a().a("param_StepGameReady");
    GameEngine.a().a(Long.valueOf(paramLong).longValue());
    GameEngine.a().a(Long.valueOf(paramLong).longValue(), paramAVGameActivity.getAppInterface().getCurrentAccountUin());
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      AVGameHandler.a().a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    this.jdField_a_of_type_JavaLangRunnable = new SurvivalRoomController.3(this, paramAVGameActivity, paramLong, paramArrayOfByte);
    AVGameHandler.a().a().post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  private void a(AVGameActivity paramAVGameActivity, String paramString, byte[] paramArrayOfByte)
  {
    QLog.i("SurvivalRoomController", 1, "doEnterVirtualAVRoomProcess begin isFinishing:" + paramAVGameActivity.isFinishing() + " mRoomId:" + paramString);
    paramAVGameActivity.a(String.valueOf(paramString), paramArrayOfByte);
    a(0);
  }
  
  private void b(AVGameActivity paramAVGameActivity, String paramString, byte[] paramArrayOfByte)
  {
    QLog.i("SurvivalRoomController", 1, "doEnterAVRoomProcess begin isFinishing:" + paramAVGameActivity.isFinishing() + " mRoomId:" + paramString);
    String str = AVGameSession.a(11, Long.valueOf(paramString).longValue());
    AVGameSession localAVGameSession = AVGameBusinessCtrl.b().a();
    int i;
    if ((localAVGameSession != null) && (localAVGameSession.a.equalsIgnoreCase(str))) {
      if (localAVGameSession.a() == 2)
      {
        a(5);
        i = 0;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        return;
        if (localAVGameSession.a() == 1)
        {
          a(6);
          i = 0;
        }
      }
      else
      {
        if (localAVGameSession != null)
        {
          l = System.currentTimeMillis();
          AVGamePerfReporter.a().a(0, GameEngine.a().a().a(), GameEngine.a().a().b(), 0L);
          AVGameHandler.a().a().post(new SurvivalRoomController.4(this, l));
          if (QLog.isColorLevel()) {
            QLog.d("SurvivalRoomController", 2, "mEnterAvRoomRunnable exit old session");
          }
        }
        long l = System.currentTimeMillis();
        if (TextUtils.isEmpty(paramString))
        {
          a(paramAVGameActivity, 1, 1);
          return;
        }
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
        {
          a(paramAVGameActivity, 1, 2);
          return;
        }
        AVGameNodeReportUtil.b();
        if ((GameEngine.a().f()) && (GameEngine.a().i())) {}
        for (i = 4;; i = 2)
        {
          i = AVGameBusinessCtrl.b().a(paramString, paramArrayOfByte, 1, i, this);
          if (QLog.isColorLevel()) {
            QLog.d("SurvivalRoomController", 2, "doEnterAVRoomProcess enterRoom coast " + (System.currentTimeMillis() - l) + " retCode=" + i);
          }
          if (i == 0) {
            break;
          }
          a(paramAVGameActivity, 2, i);
          return;
        }
        if (AVGameBusinessCtrl.b().a() == null)
        {
          a(paramAVGameActivity, 3, 1);
          return;
        }
        QLog.i("SurvivalRoomController", 1, "doEnterAVRoomProcess end isFinishing:" + paramAVGameActivity.isFinishing());
        return;
      }
      i = 1;
    }
  }
  
  private void c()
  {
    EngineData localEngineData = GameEngine.a().a();
    if (localEngineData.c) {}
    GameRoomHandler localGameRoomHandler;
    long l;
    for (int i = 1;; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SurvivalRoomController", 2, "dealPkCreateRoomOrJoinAfterExitRoom  " + localEngineData.n());
      }
      if (localEngineData.n() == 2)
      {
        localEngineData.e(3);
        localGameRoomHandler = (GameRoomHandler)GameEngine.a().a().getBusinessHandler(HandlerFactory.a);
        l = localEngineData.a;
        if (l > 0L) {
          break;
        }
        localGameRoomHandler.a(10, null, 0, i);
      }
      return;
    }
    localGameRoomHandler.a(7, String.valueOf(l), "", i);
  }
  
  private void c(boolean paramBoolean, int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SurvivalRoomController", 2, "dealWithRoomEnter " + paramBoolean + " retCode:" + paramInt);
    }
    AVGameActivity localAVGameActivity = a();
    if (localAVGameActivity == null) {}
    do
    {
      return;
      if ((paramInt != 0) || (paramRoomInfo == null)) {
        break;
      }
      paramLong = paramRoomInfo.id;
    } while (localAVGameActivity.d());
    GameEngine.a().a(paramRoomInfo);
    localAVGameActivity.a(String.valueOf(paramLong), paramArrayOfByte);
    GameEngine.a().a(paramLong, localAVGameActivity.getAppInterface().getCurrentAccountUin(), true, true);
    a(localAVGameActivity, paramLong, paramArrayOfByte);
    return;
    AVGameUtils.a(AvGameEntranceUtil.a(paramBoolean, localAVGameActivity, paramInt, paramLong, paramString), localAVGameActivity);
    GameEngine.a().a(false, 7);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SurvivalRoomController", 2, "leavePkRoom ");
    }
    GameEngine.a().b(false, 12);
    GameEngine.a().a().a().a(0, "");
  }
  
  public void a(int paramInt)
  {
    AVGameActivity localAVGameActivity = a();
    if (localAVGameActivity == null) {}
    while (localAVGameActivity.a()) {
      return;
    }
    AVGameNodeReportUtil.c();
    ThreadManager.c(new SurvivalRoomController.5(this, localAVGameActivity, paramInt));
  }
  
  public void a(long paramLong, int paramInt, String paramString, RoomInfo paramRoomInfo)
  {
    paramString = GameEngine.a().a();
    if (paramString.n() == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SurvivalRoomController", 2, "onLeaveGameRoomSuccess() pk to create or join new room ");
      }
      if (paramString.n() == 2) {
        c();
      }
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SurvivalRoomController", 2, String.format("onCreateRoom isSuc:%b retCode:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
    if (!paramBoolean)
    {
      GameEngine.a().m();
      return;
    }
    GameEngine.a().a().e(4);
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerRoomController.a(paramRoomInfo, true);
    c(true, paramInt, paramString, paramRoomInfo, paramArrayOfByte, paramLong);
  }
  
  public void a(boolean paramBoolean1, long paramLong1, boolean paramBoolean2, long paramLong2, boolean paramBoolean3, long paramLong3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SurvivalRoomController", 2, String.format("onSurvivalPkRoomAction isSuc:%b create:%b roomId:%d peerUin:%d", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Long.valueOf(paramLong2), Long.valueOf(paramLong3) }));
    }
    Object localObject;
    int i;
    if (paramBoolean1)
    {
      localObject = GameEngine.a().a();
      ((EngineData)localObject).f(1);
      if (!((EngineData)localObject).c) {
        break label161;
      }
      i = 1;
      ((EngineData)localObject).b = paramLong3;
      if (((EngineData)localObject).a() > 0L)
      {
        ((EngineData)localObject).e(2);
        if (paramBoolean2) {
          break label167;
        }
      }
    }
    label161:
    label167:
    for (((EngineData)localObject).a = paramLong2;; ((EngineData)localObject).a = 0L)
    {
      a();
      ((EngineData)localObject).e(3);
      localObject = (GameRoomHandler)GameEngine.a().a().getBusinessHandler(HandlerFactory.a);
      if (!paramBoolean2) {
        break label176;
      }
      ((GameRoomHandler)localObject).a(10, null, 0, i);
      return;
      i = 0;
      break;
    }
    label176:
    ((GameRoomHandler)localObject).a(7, String.valueOf(paramLong2), "", i);
  }
  
  public void b()
  {
    GameEngine.a().b(this.jdField_a_of_type_ComTencentAvgameVideorecordSimpleGameRoomStatusListener);
    GameEngine.a().b(this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameActivityLifeCycleListener);
  }
  
  protected void b(boolean paramBoolean, int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SurvivalRoomController", 2, String.format("onJoinRoom isSuc:%b retCode:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
    if (!paramBoolean)
    {
      GameEngine.a().m();
      return;
    }
    GameEngine.a().a().f(2);
    GameEngine.a().a().e(4);
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerRoomController.a(paramRoomInfo, true);
    c(false, paramInt, paramString, paramRoomInfo, paramArrayOfByte, paramLong);
    GameEngine.a().b("", GameEngine.a().a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.controller.SurvivalRoomController
 * JD-Core Version:    0.7.0.1
 */