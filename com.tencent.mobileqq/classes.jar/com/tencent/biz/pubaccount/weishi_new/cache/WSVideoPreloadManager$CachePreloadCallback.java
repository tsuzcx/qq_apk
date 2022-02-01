package com.tencent.biz.pubaccount.weishi_new.cache;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerUtils;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSPlayerPreDownloader.Listener;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WSVideoPreloadManager$CachePreloadCallback
  implements IWSPlayerPreDownloader.Listener
{
  private WSVideoPreDownloadManager a;
  private String b;
  
  WSVideoPreloadManager$CachePreloadCallback(WSVideoPreDownloadManager paramWSVideoPreDownloadManager, String paramString)
  {
    this.a = paramWSVideoPreDownloadManager;
    this.b = paramString;
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    WSLog.a("WSVideoPreloadManager", "onPreloadFailed");
    this.a.a();
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString2 = new StringBuilder();
    paramString2.append("[WSVideoPreloadManager.java][onPreloadSuccess] videoVid:");
    paramString2.append(paramString1);
    WSLog.a("WSVideoPreloadManager", paramString2.toString());
    if ((TextUtils.isEmpty(this.b)) || (TextUtils.equals(paramString1, WSPlayerUtils.b(this.b))))
    {
      this.a.a();
      WSLog.a("WSVideoPreloadManager", "videoPreDownloadManager destroy");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WSVideoPreloadManager.CachePreloadCallback
 * JD-Core Version:    0.7.0.1
 */