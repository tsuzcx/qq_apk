package com.tencent.mobileqq.apollo.api.web.impl;

import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader.OnFaceDataDownloadListener;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.sink.CmShowAssetsData;
import mqq.os.MqqHandler;

class ApolloJsPluginImpl$7$1
  implements IApolloResDownloader.OnFaceDataDownloadListener
{
  ApolloJsPluginImpl$7$1(ApolloJsPluginImpl.7 param7, CmShowAssetsData paramCmShowAssetsData) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    ThreadManager.getFileThreadHandler().post(new ApolloJsPluginImpl.7.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.web.impl.ApolloJsPluginImpl.7.1
 * JD-Core Version:    0.7.0.1
 */