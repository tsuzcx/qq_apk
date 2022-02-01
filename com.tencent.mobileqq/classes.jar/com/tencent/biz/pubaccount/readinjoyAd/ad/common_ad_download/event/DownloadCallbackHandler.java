package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event;

import com.tencent.TMG.utils.QLog;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.open.downloadnew.DownloadListener;
import java.util.concurrent.ConcurrentHashMap;

class DownloadCallbackHandler
{
  private static final ConcurrentHashMap<Integer, Object> a = new ConcurrentHashMap();
  
  public static <T extends DownloadListener,  extends WadlProxyServiceCallBackInterface> T a(T paramT)
  {
    DownloadListener localDownloadListener = null;
    if (paramT == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        i = System.identityHashCode(paramT);
        if (a.containsKey(Integer.valueOf(i))) {
          localDownloadListener = (DownloadListener)a.get(Integer.valueOf(i));
        }
        if (localDownloadListener != null) {
          continue;
        }
      }
      catch (Throwable localThrowable2)
      {
        int i;
        paramT = null;
        continue;
        Object localObject;
        return localObject;
      }
      try
      {
        paramT = new DownloadCallbackHandler.DownloadCallbackProxy(paramT);
        try
        {
          a.put(Integer.valueOf(i), paramT);
          return paramT;
        }
        catch (Throwable localThrowable1) {}
      }
      catch (Throwable localThrowable3)
      {
        paramT = localThrowable2;
        localObject = localThrowable3;
      }
    }
    QLog.d("DownloadCallbackHandler", 0, "getDownloadCallbackProxy: " + localThrowable1.getMessage());
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.DownloadCallbackHandler
 * JD-Core Version:    0.7.0.1
 */