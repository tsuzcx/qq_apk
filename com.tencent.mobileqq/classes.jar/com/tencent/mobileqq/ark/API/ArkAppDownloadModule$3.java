package com.tencent.mobileqq.ark.API;

import com.tencent.ark.ArkDispatchTask;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.mobileqq.ark.ArkAppCenter;

class ArkAppDownloadModule$3
  implements ArkAppDownloadModule.DownloadStateListener
{
  ArkAppDownloadModule$3(ArkAppDownloadModule paramArkAppDownloadModule) {}
  
  public void a(WadlResult paramWadlResult)
  {
    ArkAppCenter.a().post(this.a.a, new ArkAppDownloadModule.3.1(this, paramWadlResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppDownloadModule.3
 * JD-Core Version:    0.7.0.1
 */