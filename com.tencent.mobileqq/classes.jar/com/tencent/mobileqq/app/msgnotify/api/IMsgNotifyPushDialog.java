package com.tencent.mobileqq.app.msgnotify.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={""})
public abstract interface IMsgNotifyPushDialog
  extends QRouteApi
{
  public abstract void parsePushOpenNotifyXML(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.msgnotify.api.IMsgNotifyPushDialog
 * JD-Core Version:    0.7.0.1
 */