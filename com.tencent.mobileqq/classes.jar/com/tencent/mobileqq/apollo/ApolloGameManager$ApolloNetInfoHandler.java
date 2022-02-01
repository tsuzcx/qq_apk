package com.tencent.mobileqq.apollo;

import com.tencent.mobileqq.apollo.api.res.impl.ApolloSoLoaderImpl;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class ApolloGameManager$ApolloNetInfoHandler
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloGameManager.ApolloNetInfoHandler
 * JD-Core Version:    0.7.0.1
 */