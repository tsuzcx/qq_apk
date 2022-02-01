package com.tencent.ilivesdk.pluginloaderservice.download;

import com.tencent.falco.base.libapi.downloader.IDownLoaderListener;
import com.tencent.ilivesdk.pluginloaderservice.utils.LogUtil;
import java.util.concurrent.CountDownLatch;

final class Downloader$1
  implements IDownLoaderListener
{
  Downloader$1(CountDownLatch paramCountDownLatch) {}
  
  public void onDownloadStateChanged(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    LogUtil.a("Downloader", "InterruptedException: state[%d] url[%s] saveDir[%s] errorCode[%d].", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2 });
  }
  
  public void onFail(int paramInt, String paramString1, String paramString2)
  {
    LogUtil.b("Downloader", "InterruptedException: errorCode[%d] url[%s] saveDir[%s].", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
    this.a.countDown();
  }
  
  public void onProgress(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    LogUtil.a("Downloader", "InterruptedException: url[%s] totalLength[%d] percent[%s] speed[%d].", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public void onSuccess(String paramString1, String paramString2)
  {
    LogUtil.b("Downloader", "onSuccess: url[%s] saveDir[%s] ", new Object[] { paramString1, paramString2 });
    this.a.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.pluginloaderservice.download.Downloader.1
 * JD-Core Version:    0.7.0.1
 */