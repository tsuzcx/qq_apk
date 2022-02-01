package com.tencent.gdtad.api.interstitial;

import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback;

class GdtArkPreDownloadTask$6
  implements ArkAppMgr.IGetAppPathByNameCallback
{
  GdtArkPreDownloadTask$6(GdtArkPreDownloadTask paramGdtArkPreDownloadTask) {}
  
  public void onGetAppPathByName(int paramInt, String paramString, ArkAppMgr.AppPathInfo paramAppPathInfo)
  {
    AdThreadManager.INSTANCE.post(new GdtArkPreDownloadTask.6.1(this, paramAppPathInfo, paramInt, paramString), 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.6
 * JD-Core Version:    0.7.0.1
 */