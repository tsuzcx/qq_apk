package com.tencent.mobileqq.ark.api.module;

import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.qroute.QRoute;

class ArkAppYYBDownloadModule$1
  implements ArkAppYYBDownloadModule.DownloadStateListener
{
  ArkAppYYBDownloadModule$1(ArkAppYYBDownloadModule paramArkAppYYBDownloadModule) {}
  
  public void a(String paramString)
  {
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToAppThread(ArkAppYYBDownloadModule.a(this.a), new ArkAppYYBDownloadModule.1.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppYYBDownloadModule.1
 * JD-Core Version:    0.7.0.1
 */