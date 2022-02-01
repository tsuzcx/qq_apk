package com.tencent.mobileqq.apollo.utils.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IApolloEngineHelper
  extends QRouteApi
{
  public abstract boolean isEngineReady();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.api.IApolloEngineHelper
 * JD-Core Version:    0.7.0.1
 */