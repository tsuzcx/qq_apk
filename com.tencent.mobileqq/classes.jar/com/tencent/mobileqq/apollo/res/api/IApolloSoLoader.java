package com.tencent.mobileqq.apollo.res.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IApolloSoLoader
  extends QRouteApi
{
  public abstract boolean apiIsLibReady();
  
  public abstract void apiLoadSo(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.res.api.IApolloSoLoader
 * JD-Core Version:    0.7.0.1
 */