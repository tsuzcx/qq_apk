package com.tencent.mobileqq.ark.api.module;

import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.qroute.QRoute;

class ArkAppDownloadModule$3
  implements ArkAppDownloadModule.DownloadStateListener
{
  ArkAppDownloadModule$3(ArkAppDownloadModule paramArkAppDownloadModule) {}
  
  public void a(WadlResult paramWadlResult)
  {
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToAppThread(ArkAppDownloadModule.c(this.a), new ArkAppDownloadModule.3.1(this, paramWadlResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppDownloadModule.3
 * JD-Core Version:    0.7.0.1
 */