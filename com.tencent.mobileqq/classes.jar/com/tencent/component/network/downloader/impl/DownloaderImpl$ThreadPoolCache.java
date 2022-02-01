package com.tencent.component.network.downloader.impl;

import com.tencent.component.network.downloader.strategy.DownloadPreprocessStrategy.DownloadPool;
import com.tencent.component.network.module.base.Config;
import com.tencent.component.network.utils.thread.PriorityThreadPool;
import java.util.HashMap;

final class DownloaderImpl$ThreadPoolCache
{
  private final String mName;
  private final int mPoolSize;
  private final HashMap<String, PriorityThreadPool> mThreadPoolMap = new HashMap();
  
  DownloaderImpl$ThreadPoolCache(String paramString, int paramInt)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    int i = paramInt;
    if (paramInt <= 0) {
      i = 1;
    }
    this.mName = str;
    this.mPoolSize = i;
  }
  
  public PriorityThreadPool get(String paramString)
  {
    String str = this.mName + "-" + paramString;
    ??? = (PriorityThreadPool)this.mThreadPoolMap.get(str);
    if (??? != null) {
      return ???;
    }
    synchronized (this.mThreadPoolMap)
    {
      PriorityThreadPool localPriorityThreadPool = (PriorityThreadPool)this.mThreadPoolMap.get(str);
      if (localPriorityThreadPool != null) {
        return localPriorityThreadPool;
      }
    }
    if ((paramString != null) && (paramString.equals(DownloadPreprocessStrategy.DownloadPool.HTTP2.getName()))) {}
    for (paramString = new PriorityThreadPool(str, Config.getDefaultHttp2ThreadPoolSize());; paramString = new PriorityThreadPool(str, this.mPoolSize))
    {
      this.mThreadPoolMap.put(str, paramString);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.DownloaderImpl.ThreadPoolCache
 * JD-Core Version:    0.7.0.1
 */