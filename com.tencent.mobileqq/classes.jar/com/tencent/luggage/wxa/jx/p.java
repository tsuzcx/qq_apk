package com.tencent.luggage.wxa.jx;

import com.tencent.luggage.wxa.qz.o;

public class p
  extends n
{
  private static final int CTRL_INDEX = 248;
  private static final String NAME = "onUserCaptureScreen";
  
  public static void c(c paramc)
  {
    o.d("MicroMsg.AppBrandOnUserCaptureScreenEvent", "user capture screen event dispatch, appId:%s", new Object[] { paramc.getAppId() });
    new p().a(paramc).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.p
 * JD-Core Version:    0.7.0.1
 */