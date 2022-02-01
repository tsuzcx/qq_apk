package com.qwallet.temp.impl;

import com.qwallet.temp.IQQAppInterfaceTemp;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.api.IAppBadgeService;
import mqq.app.AppRuntime;

public class QQAppInterfaceTempImpl
  implements IQQAppInterfaceTemp
{
  public boolean QQAppInterface$isPttRecordingOrPlaying(AppInterface paramAppInterface)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      return ((QQAppInterface)paramAppInterface).isPttRecordingOrPlaying();
    }
    return false;
  }
  
  public boolean QQAppInterface$isRingerSilent(AppInterface paramAppInterface)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      return ((QQAppInterface)paramAppInterface).isRingerSilent();
    }
    return false;
  }
  
  public boolean QQAppInterface$isVideoChatting(AppInterface paramAppInterface)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      return ((QQAppInterface)paramAppInterface).isVideoChatting();
    }
    return false;
  }
  
  public void QQAppInterface$refreshAppBadge(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      ((IAppBadgeService)paramAppRuntime.getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
    }
  }
  
  public int getALLGeneralSettingRing(AppInterface paramAppInterface)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      return ((QQAppInterface)paramAppInterface).getALLGeneralSettingRing();
    }
    return 1;
  }
  
  public int getALLGeneralSettingVibrate(AppInterface paramAppInterface)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      return ((QQAppInterface)paramAppInterface).getALLGeneralSettingVibrate();
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.qwallet.temp.impl.QQAppInterfaceTempImpl
 * JD-Core Version:    0.7.0.1
 */