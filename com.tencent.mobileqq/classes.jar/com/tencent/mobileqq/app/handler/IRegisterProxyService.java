package com.tencent.mobileqq.app.handler;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IRegisterProxyService
  extends QRouteApi
{
  public abstract void onNewRegisterProxyRestPacketEnd();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.IRegisterProxyService
 * JD-Core Version:    0.7.0.1
 */