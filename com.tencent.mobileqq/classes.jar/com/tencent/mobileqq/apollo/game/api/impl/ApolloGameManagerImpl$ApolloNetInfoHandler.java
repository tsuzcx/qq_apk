package com.tencent.mobileqq.apollo.game.api.impl;

import com.tencent.mobileqq.apollo.res.api.impl.ApolloSoLoaderImpl;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class ApolloGameManagerImpl$ApolloNetInfoHandler
  implements INetInfoHandler
{
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString)
  {
    ApolloSoLoaderImpl.loadSo("onNetMobile2Wifi");
  }
  
  public void onNetNone2Mobile(String paramString) {}
  
  public void onNetNone2Wifi(String paramString)
  {
    ApolloSoLoaderImpl.loadSo("onNetNone2Wifi");
  }
  
  public void onNetWifi2Mobile(String paramString) {}
  
  public void onNetWifi2None() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.api.impl.ApolloGameManagerImpl.ApolloNetInfoHandler
 * JD-Core Version:    0.7.0.1
 */