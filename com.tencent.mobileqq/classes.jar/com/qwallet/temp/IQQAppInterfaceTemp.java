package com.qwallet.temp;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IQQAppInterfaceTemp
  extends QRouteApi
{
  public abstract boolean QQAppInterface$isPttRecordingOrPlaying(AppInterface paramAppInterface);
  
  public abstract boolean QQAppInterface$isRingerSilent(AppInterface paramAppInterface);
  
  public abstract boolean QQAppInterface$isVideoChatting(AppInterface paramAppInterface);
  
  public abstract void QQAppInterface$refreshAppBadge(AppRuntime paramAppRuntime);
  
  public abstract int getALLGeneralSettingRing(AppInterface paramAppInterface);
  
  public abstract int getALLGeneralSettingVibrate(AppInterface paramAppInterface);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qwallet.temp.IQQAppInterfaceTemp
 * JD-Core Version:    0.7.0.1
 */