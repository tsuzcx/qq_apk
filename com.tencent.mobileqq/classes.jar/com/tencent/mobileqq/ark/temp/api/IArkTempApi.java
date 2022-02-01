package com.tencent.mobileqq.ark.temp.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IArkTempApi
  extends QRouteApi
{
  public abstract String getCurrentAppConfig();
  
  public abstract void initArkEnv();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.temp.api.IArkTempApi
 * JD-Core Version:    0.7.0.1
 */