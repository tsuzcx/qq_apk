package com.tencent.biz.pubaccount.Advertisement.manager;

import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCallback;
import java.io.File;
import org.json.JSONObject;

class AdvertisementVideoPreloadManager$PreloadCallback
  implements TVK_ICacheMgr.IPreloadCallback
{
  private AdvertisementVideoPreloadManager$PreloadCallback(AdvertisementVideoPreloadManager paramAdvertisementVideoPreloadManager) {}
  
  public void onPreLoadFailed(String paramString1, int paramInt, String paramString2)
  {
    synchronized (AdvertisementVideoPreloadManager.a(this.a))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPreLoadFailed vid:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", i:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", callbackMsg:");
      localStringBuilder.append(paramString2);
      AdvertisementVideoPreloadManager.c(localStringBuilder.toString());
      AdvertisementVideoPreloadManager.a(this.a, AdvertisementVideoPreloadManager.a(this.a));
      return;
    }
  }
  
  public void onPreLoadSucess(String paramString1, String paramString2)
  {
    synchronized (AdvertisementVideoPreloadManager.a(this.a))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPreLoadSucess vid:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", detail:");
      localStringBuilder.append(paramString2);
      AdvertisementVideoPreloadManager.c(localStringBuilder.toString());
      try
      {
        paramString2 = new JSONObject(paramString2);
        long l1 = paramString2.optLong("fileSize");
        long l2 = paramString2.optLong("offset");
        if ((l1 > 0L) && (l2 > 0L) && (l2 >= l1))
        {
          paramString2 = new File(AdvertisementVideoPreloadManager.b(paramString1));
          if (paramString2.exists()) {
            paramString2.renameTo(new File(AdvertisementVideoPreloadManager.a(paramString1)));
          }
          AdvertisementVideoPreloadManager.a(this.a, AdvertisementVideoPreloadManager.a(this.a));
        }
      }
      catch (Exception paramString1)
      {
        label152:
        break label152;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager.PreloadCallback
 * JD-Core Version:    0.7.0.1
 */