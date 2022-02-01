package com.tencent.avgame.gamelogic.controller;

import android.app.Activity;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.business.handler.HandlerFactory;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.GameActivityCenterEntry;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gamelogic.handler.GameRoomHandler;
import com.tencent.avgame.gamelogic.observer.GameRoomObserver;
import com.tencent.avgame.ui.AVGameHandler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.avgameshare.AVGameShareUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

public class GameActivityCenterCtrl
{
  private static GameActivityCenterCtrl jdField_a_of_type_ComTencentAvgameGamelogicControllerGameActivityCenterCtrl = null;
  private long jdField_a_of_type_Long = 0L;
  private GameActivityCenterEntry jdField_a_of_type_ComTencentAvgameGamelogicDataGameActivityCenterEntry = null;
  private GameRoomObserver jdField_a_of_type_ComTencentAvgameGamelogicObserverGameRoomObserver = new GameActivityCenterCtrl.2(this);
  private WeakReference<Activity> jdField_a_of_type_MqqUtilWeakReference = null;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  
  private Activity a()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference == null) {
      return null;
    }
    return (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();
  }
  
  private AVGameAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof AVGameAppInterface)) {
      return (AVGameAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public static GameActivityCenterCtrl a()
  {
    if (jdField_a_of_type_ComTencentAvgameGamelogicControllerGameActivityCenterCtrl == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentAvgameGamelogicControllerGameActivityCenterCtrl == null) {
        jdField_a_of_type_ComTencentAvgameGamelogicControllerGameActivityCenterCtrl = new GameActivityCenterCtrl();
      }
      return jdField_a_of_type_ComTencentAvgameGamelogicControllerGameActivityCenterCtrl;
    }
    finally {}
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = a();
    long l = Math.abs(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long);
    boolean bool;
    if (!paramBoolean) {
      if (l > 5000L) {
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("GameACCtrl", 2, "requestActivityCenterData, needGetData[" + bool + "], force[" + paramBoolean + "], interval[" + l + "], appInterface[" + localObject + "]");
      }
      if ((localObject != null) && (bool))
      {
        ((AVGameAppInterface)localObject).addObserver(this.jdField_a_of_type_ComTencentAvgameGamelogicObserverGameRoomObserver, true);
        localObject = (GameRoomHandler)((AVGameAppInterface)localObject).getBusinessHandler(HandlerFactory.a);
        if (localObject != null)
        {
          this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
          ((GameRoomHandler)localObject).a();
        }
      }
      return;
      bool = false;
      continue;
      bool = paramBoolean;
    }
  }
  
  public void a(Activity paramActivity)
  {
    if (paramActivity != null) {
      this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramActivity);
    }
    if (!this.jdField_a_of_type_Boolean) {
      a(this.b);
    }
    this.b = false;
    this.jdField_a_of_type_Boolean = true;
    AVGameHandler.a().b().post(new GameActivityCenterCtrl.RefreshEntryTask());
    if (QLog.isDevelopLevel()) {
      QLog.i("GameACCtrl", 4, "enterGameRoom, activity[" + paramActivity + "]");
    }
  }
  
  public void a(Activity paramActivity, String paramString)
  {
    if (paramActivity != null) {
      this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramActivity);
    }
    paramActivity = a();
    if (paramActivity != null)
    {
      paramActivity.addObserver(this.jdField_a_of_type_ComTencentAvgameGamelogicObserverGameRoomObserver, true);
      paramActivity = (GameRoomHandler)paramActivity.getBusinessHandler(HandlerFactory.a);
      if (paramActivity != null) {
        paramActivity.a(paramString);
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("GameACCtrl", 4, "onShareGameSuc, playGameId[" + paramString + "]");
    }
  }
  
  public void b(Activity paramActivity)
  {
    this.jdField_a_of_type_Boolean = false;
    if (paramActivity != null) {
      this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramActivity);
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("GameACCtrl", 4, "leaveGameRoom, activity[" + paramActivity + "]");
    }
  }
  
  public void c(Activity paramActivity)
  {
    if (paramActivity != null) {
      this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramActivity);
    }
    AVGameAppInterface localAVGameAppInterface = GameEngine.a().a();
    String str2 = localAVGameAppInterface.getCurrentAccountUin();
    EngineData localEngineData = GameEngine.a().a();
    long l;
    String str1;
    if (localEngineData != null)
    {
      l = localEngineData.a();
      str1 = localEngineData.a().getNick(str2);
    }
    for (int i = localEngineData.d();; i = 0)
    {
      AVGameShareUtil.a().a(localAVGameAppInterface, l, Long.valueOf(str2).longValue(), str1, 3, "", i, new GameActivityCenterCtrl.1(this, str1));
      if (QLog.isColorLevel()) {
        QLog.i("GameACCtrl", 2, "openGameActivityCenter, ctx[" + paramActivity + "], entry[" + this.jdField_a_of_type_ComTencentAvgameGamelogicDataGameActivityCenterEntry + "]");
      }
      return;
      l = 0L;
      str1 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.controller.GameActivityCenterCtrl
 * JD-Core Version:    0.7.0.1
 */