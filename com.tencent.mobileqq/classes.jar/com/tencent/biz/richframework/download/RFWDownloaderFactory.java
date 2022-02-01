package com.tencent.biz.richframework.download;

import java.util.concurrent.ConcurrentHashMap;

public class RFWDownloaderFactory
{
  private static final String TAG = "RFWDownloaderFactory";
  private static ConcurrentHashMap<String, RFWDownloader> mDownloaderMap = new ConcurrentHashMap();
  
  public static RFWDownloader getDownloader(RFWDownloadStrategy paramRFWDownloadStrategy)
  {
    RFWDownloader localRFWDownloader = (RFWDownloader)mDownloaderMap.get(paramRFWDownloadStrategy.getBusinessKey());
    if (localRFWDownloader == null) {
      try
      {
        localRFWDownloader = new RFWDownloader(paramRFWDownloadStrategy);
        mDownloaderMap.put(paramRFWDownloadStrategy.getBusinessKey(), localRFWDownloader);
        return localRFWDownloader;
      }
      finally {}
    }
    return localRFWDownloader;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.richframework.download.RFWDownloaderFactory
 * JD-Core Version:    0.7.0.1
 */