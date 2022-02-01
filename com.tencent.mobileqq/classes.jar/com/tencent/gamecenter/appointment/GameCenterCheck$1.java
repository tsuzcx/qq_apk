package com.tencent.gamecenter.appointment;

import com.tencent.gamecenter.wadl.api.IQQGameNetService;
import com.tencent.mobileqq.qroute.QRoute;

class GameCenterCheck$1
  implements Runnable
{
  GameCenterCheck$1(GameCenterCheck paramGameCenterCheck) {}
  
  public void run()
  {
    ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).getAutoDownloadApk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.appointment.GameCenterCheck.1
 * JD-Core Version:    0.7.0.1
 */