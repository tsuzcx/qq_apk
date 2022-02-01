package com.tencent.mobileqq.apollo.utils.api.impl;

import com.tencent.mobileqq.apollo.aio.ApolloResponseManager;
import com.tencent.mobileqq.apollo.aio.message.ApolloElemDecoder;
import com.tencent.mobileqq.apollo.api.impl.GetApolloContentUpdateStatus;
import com.tencent.mobileqq.apollo.debug.ApolloDebugFragment;
import com.tencent.mobileqq.apollo.handler.ApolloContentUpdateHandler;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionServlet;
import com.tencent.mobileqq.apollo.model.MessageForApollo;
import com.tencent.mobileqq.apollo.store.ApolloStoreActivity;
import com.tencent.mobileqq.apollo.utils.ApolloRecentManager;
import com.tencent.mobileqq.apollo.utils.api.IApolloClassFactory;
import com.tencent.mobileqq.apollo.web.CmShowWebIPCModule;

public class ApolloClassFactoryImpl
  implements IApolloClassFactory
{
  public String getApolloContentUpdateHandlerClassName()
  {
    return ApolloContentUpdateHandler.a;
  }
  
  public Class getApolloContentUpdateStatusClass()
  {
    return GetApolloContentUpdateStatus.class;
  }
  
  public Class getApolloDebugFragment()
  {
    return ApolloDebugFragment.class;
  }
  
  public Class getApolloElemDecoderClass()
  {
    return ApolloElemDecoder.class;
  }
  
  public String getApolloExtensionHandlerClassName()
  {
    return ApolloExtensionHandler.a;
  }
  
  public Class getApolloExtensionServletClass()
  {
    return ApolloExtensionServlet.class;
  }
  
  public Class getApolloRecentManagerClass()
  {
    return ApolloRecentManager.class;
  }
  
  public Class getApolloResponseManagerClass()
  {
    return ApolloResponseManager.class;
  }
  
  public Class getApolloStoreActivityClass()
  {
    return ApolloStoreActivity.class;
  }
  
  public Class getCmShowModuleClass()
  {
    return CmShowWebIPCModule.class;
  }
  
  public Class getMessageForApolloClass()
  {
    return MessageForApollo.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.api.impl.ApolloClassFactoryImpl
 * JD-Core Version:    0.7.0.1
 */