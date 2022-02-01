package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event;

import com.tencent.TMG.utils.QLog;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.open.downloadnew.DownloadListener;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadCallbackHandler
{
  private static final ConcurrentHashMap<Integer, Object> a = new ConcurrentHashMap();
  
  public static <T extends DownloadListener,  extends WadlProxyServiceCallBackInterface> T a(T paramT)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    if (paramT == null) {
      return null;
    }
    Object localObject2 = localObject3;
    try
    {
      int i = System.identityHashCode(paramT);
      localObject2 = localObject3;
      if (a.containsKey(Integer.valueOf(i)))
      {
        localObject2 = localObject3;
        localObject1 = (DownloadListener)a.get(Integer.valueOf(i));
      }
      localObject2 = localObject1;
      if (localObject1 != null) {
        return localObject2;
      }
      localObject2 = localObject1;
      localObject1 = new DownloadCallbackHandler.DownloadCallbackProxy(paramT);
      try
      {
        a.put(Integer.valueOf(i), localObject1);
        return localObject1;
      }
      catch (Throwable paramT)
      {
        localObject2 = localObject1;
      }
      localObject1 = new StringBuilder();
    }
    catch (Throwable paramT) {}
    ((StringBuilder)localObject1).append("getDownloadCallbackProxy: ");
    ((StringBuilder)localObject1).append(paramT.getMessage());
    QLog.d("DownloadCallbackHandler", 0, ((StringBuilder)localObject1).toString());
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.DownloadCallbackHandler
 * JD-Core Version:    0.7.0.1
 */