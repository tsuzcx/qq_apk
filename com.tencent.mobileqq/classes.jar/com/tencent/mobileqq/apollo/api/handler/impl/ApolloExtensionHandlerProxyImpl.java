package com.tencent.mobileqq.apollo.api.handler.impl;

import com.tencent.mobileqq.apollo.api.handler.IApolloExtensionHandlerProxy;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public class ApolloExtensionHandlerProxyImpl
  implements IApolloExtensionHandlerProxy
{
  public String getImplClassName()
  {
    return ApolloExtensionHandlerImpl.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionHandlerProxyImpl
 * JD-Core Version:    0.7.0.1
 */