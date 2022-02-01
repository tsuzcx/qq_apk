package com.tencent.mobileqq.ark.api;

import com.tencent.mobileqq.ark.event.IArkAppLifeEventCallback;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IArkAppLifeEvent
  extends QRouteApi
{
  public static final int EVENT_CREATEAPP = 0;
  public static final int EVENT_CREATEVIEW = 2;
  public static final int EVENT_DESTROYAPP = 1;
  public static final int EVENT_DESTROYVIEW = 3;
  
  public abstract void attachEvent(String paramString1, String paramString2, IArkAppLifeEventCallback paramIArkAppLifeEventCallback);
  
  public abstract void detachEvent(String paramString1, String paramString2);
  
  public abstract void doAction(int paramInt, String paramString, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.IArkAppLifeEvent
 * JD-Core Version:    0.7.0.1
 */