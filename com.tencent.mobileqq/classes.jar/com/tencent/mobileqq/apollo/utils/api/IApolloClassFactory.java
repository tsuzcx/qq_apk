package com.tencent.mobileqq.apollo.utils.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IApolloClassFactory
  extends QRouteApi
{
  public abstract String getApolloContentUpdateHandlerClassName();
  
  public abstract Class getApolloContentUpdateStatusClass();
  
  public abstract Class getApolloDebugFragment();
  
  public abstract Class getApolloElemDecoderClass();
  
  public abstract String getApolloExtensionHandlerClassName();
  
  public abstract Class getApolloExtensionServletClass();
  
  public abstract Class getApolloRecentManagerClass();
  
  public abstract Class getApolloResponseManagerClass();
  
  public abstract Class getApolloStoreActivityClass();
  
  public abstract Class getMessageForApolloClass();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.api.IApolloClassFactory
 * JD-Core Version:    0.7.0.1
 */