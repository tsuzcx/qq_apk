package com.tencent.mobileqq.apollo.api.handler;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IApolloExtensionHandlerProxy
  extends QRouteApi
{
  public abstract String getImplClassName();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.handler.IApolloExtensionHandlerProxy
 * JD-Core Version:    0.7.0.1
 */