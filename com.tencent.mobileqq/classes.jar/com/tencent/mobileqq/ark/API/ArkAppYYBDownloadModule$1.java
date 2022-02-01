package com.tencent.mobileqq.ark.API;

import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.ArkAppCenter;

class ArkAppYYBDownloadModule$1
  implements ArkAppYYBDownloadModule.DownloadStateListener
{
  ArkAppYYBDownloadModule$1(ArkAppYYBDownloadModule paramArkAppYYBDownloadModule) {}
  
  public void a(String paramString)
  {
    ArkAppCenter.a().post(this.a.a, new ArkAppYYBDownloadModule.1.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppYYBDownloadModule.1
 * JD-Core Version:    0.7.0.1
 */