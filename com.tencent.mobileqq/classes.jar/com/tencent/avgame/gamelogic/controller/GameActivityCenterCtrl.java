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
import com.tencent.common.app.business.BaseAVGameAppInterface;
import com.tencent.mobileqq.app.avgameshare.AVGameShareUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

public class GameActivityCenterCtrl
{
  private static GameActivityCenterCtrl a;
  private GameActivityCenterEntry b = null;
  private WeakReference<Activity> c = null;
  private boolean d = false;
  private boolean e = false;
  private long f = 0L;
  private GameRoomObserver g = new GameActivityCenterCtrl.2(this);
  
  public static GameActivityCenterCtrl a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new GameActivityCenterCtrl();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = c();
    long l = Math.abs(SystemClock.elapsedRealtime() - this.f);
    boolean bool;
    if (!paramBoolean)
    {
      if (l > 5000L) {
        bool = true;
      } else {
        bool = false;
      }
    }
    else {
      bool = paramBoolean;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestActivityCenterData, needGetData[");
      localStringBuilder.append(bool);
      localStringBuilder.append("], force[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], interval[");
      localStringBuilder.append(l);
      localStringBuilder.append("], appInterface[");
      localStringBuilder.append(localObject);
      localStringBuilder.append("]");
      QLog.i("GameACCtrl", 2, localStringBuilder.toString());
    }
    if ((localObject != null) && (bool))
    {
      ((AVGameAppInterface)localObject).addObserver(this.g, true);
      localObject = (GameRoomHandler)((AVGameAppInterface)localObject).getBusinessHandler(HandlerFactory.a);
      if (localObject != null)
      {
        this.f = SystemClock.elapsedRealtime();
        ((GameRoomHandler)localObject).a();
      }
    }
  }
  
  private Activity b()
  {
    WeakReference localWeakReference = this.c;
    if (localWeakReference == null) {
      return null;
    }
    return (Activity)localWeakReference.get();
  }
  
  private AVGameAppInterface c()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof AVGameAppInterface)) {
      return (AVGameAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public void a(Activity paramActivity)
  {
    if (paramActivity != null) {
      this.c = new WeakReference(paramActivity);
    }
    if (!this.d) {
      a(this.e);
    }
    this.e = false;
    this.d = true;
    AVGameHandler.a().c().post(new GameActivityCenterCtrl.RefreshEntryTask());
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enterGameRoom, activity[");
      localStringBuilder.append(paramActivity);
      localStringBuilder.append("]");
      QLog.i("GameACCtrl", 4, localStringBuilder.toString());
    }
  }
  
  public void a(Activity paramActivity, String paramString)
  {
    if (paramActivity != null) {
      this.c = new WeakReference(paramActivity);
    }
    paramActivity = c();
    if (paramActivity != null)
    {
      paramActivity.addObserver(this.g, true);
      paramActivity = (GameRoomHandler)paramActivity.getBusinessHandler(HandlerFactory.a);
      if (paramActivity != null) {
        paramActivity.a(paramString);
      }
    }
    if (QLog.isDevelopLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("onShareGameSuc, playGameId[");
      paramActivity.append(paramString);
      paramActivity.append("]");
      QLog.i("GameACCtrl", 4, paramActivity.toString());
    }
  }
  
  public void b(Activity paramActivity)
  {
    this.d = false;
    if (paramActivity != null) {
      this.c = new WeakReference(paramActivity);
    }
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("leaveGameRoom, activity[");
      localStringBuilder.append(paramActivity);
      localStringBuilder.append("]");
      QLog.i("GameACCtrl", 4, localStringBuilder.toString());
    }
  }
  
  public void c(Activity paramActivity)
  {
    if (paramActivity != null) {
      this.c = new WeakReference(paramActivity);
    }
    BaseAVGameAppInterface localBaseAVGameAppInterface = GameEngine.a().f();
    String str = localBaseAVGameAppInterface.getCurrentAccountUin();
    EngineData localEngineData = GameEngine.a().s();
    long l;
    Object localObject;
    int i;
    if (localEngineData != null)
    {
      l = localEngineData.i();
      localObject = localEngineData.e().getNick(str);
      i = localEngineData.p();
    }
    else
    {
      l = 0L;
      localObject = "";
      i = 0;
    }
    AVGameShareUtil.a().a(localBaseAVGameAppInterface, l, Long.valueOf(str).longValue(), (String)localObject, 3, "", i, new GameActivityCenterCtrl.1(this, (String)localObject));
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("openGameActivityCenter, ctx[");
      ((StringBuilder)localObject).append(paramActivity);
      ((StringBuilder)localObject).append("], entry[");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append("]");
      QLog.i("GameACCtrl", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.controller.GameActivityCenterCtrl
 * JD-Core Version:    0.7.0.1
 */