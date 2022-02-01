package com.tencent.gamecenter.appointment;

import com.tencent.gamecenter.wadl.api.IQQGameCheckService;
import com.tencent.gamecenter.wadl.api.IQQGameConfigService;
import com.tencent.gamecenter.wadl.biz.receiver.GameCenterBroadcastReceiver;
import com.tencent.gamecenter.wadl.util.GameCenterSpUtils;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqgamepub.api.IQQGameAdService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class GameCenterCheck
  extends AsyncStep
{
  public final long a = 30L;
  
  protected int doStep()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterCheck", 2, "GameCenterCheck doStep");
    }
    Object localObject1 = (IQQGameAdService)QRoute.api(IQQGameAdService.class);
    long l = System.currentTimeMillis();
    int i = 1;
    ((IQQGameAdService)localObject1).updatePullAdInfo(true, l);
    ((IQQGameAdService)QRoute.api(IQQGameAdService.class)).pullAd();
    GameCenterUtil.a();
    if ((!GameCenterUtil.b) && (!GameCenterUtil.a) && (!GameCenterUtil.c) && (!GameCenterUtil.d) && (!GameCenterUtil.e))
    {
      if (QLog.isColorLevel()) {
        QLog.w("GameCenterCheck", 2, "GameCenterCheck switch is off");
      }
      return super.doStep();
    }
    Object localObject3 = Long.valueOf(GameCenterSpUtils.a("APPOINTMENT_LASTGET_TIME"));
    Object localObject2 = Long.valueOf(GameCenterSpUtils.a("APPOINTMENT_LOAD_GAP"));
    localObject1 = localObject2;
    if (0L == ((Long)localObject2).longValue()) {
      localObject1 = Long.valueOf(30L);
    }
    l = NetConnInfoCenter.getServerTime();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("GameCenterCheck loadGap=");
      ((StringBuilder)localObject2).append(localObject1);
      ((StringBuilder)localObject2).append(", lastTime:");
      ((StringBuilder)localObject2).append(localObject3);
      ((StringBuilder)localObject2).append(",isAppointDownload=");
      ((StringBuilder)localObject2).append(GameCenterUtil.b);
      ((StringBuilder)localObject2).append(",isDelayDownload=");
      ((StringBuilder)localObject2).append(GameCenterUtil.a);
      ((StringBuilder)localObject2).append(",isUpdateDownload=");
      ((StringBuilder)localObject2).append(GameCenterUtil.c);
      ((StringBuilder)localObject2).append(",isResApkDownload=");
      ((StringBuilder)localObject2).append(GameCenterUtil.d);
      ((StringBuilder)localObject2).append(",isResDefDownload=");
      ((StringBuilder)localObject2).append(GameCenterUtil.e);
      QLog.i("GameCenterCheck", 2, ((StringBuilder)localObject2).toString());
    }
    if (l - ((Long)localObject3).longValue() >= ((Long)localObject1).longValue()) {
      i = 0;
    }
    localObject2 = (IQQGameCheckService)this.mAutomator.a.getRuntimeService(IQQGameCheckService.class, "");
    if (i != 0)
    {
      ((IQQGameCheckService)localObject2).checkGameCenter();
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("GameCenterCheck getPreDownloadList loadGap=");
        ((StringBuilder)localObject3).append(localObject1);
        QLog.d("GameCenterCheck", 2, ((StringBuilder)localObject3).toString());
      }
      ThreadManager.excute(new GameCenterCheck.1(this), 192, null, false);
    }
    if (((IQQGameCheckService)localObject2).hasAppointTask()) {
      GameCenterBroadcastReceiver.a();
    }
    QRoute.api(IQQGameConfigService.class);
    ((IQQGameConfigService)QRoute.api(IQQGameConfigService.class)).checkConfigUpdate(false, -1L);
    return super.doStep();
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterCheck", 2, "onCreate");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.appointment.GameCenterCheck
 * JD-Core Version:    0.7.0.1
 */