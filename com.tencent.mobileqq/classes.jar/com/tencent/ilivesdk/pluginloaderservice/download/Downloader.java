package com.tencent.ilivesdk.pluginloaderservice.download;

import com.tencent.falco.base.libapi.downloader.DownLoaderInterface;
import com.tencent.ilivesdk.pluginloaderservice.utils.LogUtil;
import java.io.File;
import java.util.concurrent.CountDownLatch;

public class Downloader
{
  private static DownLoaderInterface a;
  
  public static File a(String paramString1, String paramString2, String paramString3)
  {
    if (a == null)
    {
      LogUtil.a("Downloader", "downloadFile: the downloader is null", new Object[0]);
      return null;
    }
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append("/");
    localStringBuilder.append(paramString3);
    paramString2 = new File(localStringBuilder.toString());
    if (paramString2.exists())
    {
      LogUtil.b("Downloader", "downloadFile: the file[%s] is exists delete it. ", new Object[] { paramString2.getAbsolutePath() });
      paramString2.delete();
    }
    a.start(paramString1, paramString2.getAbsolutePath(), 4, 0, new Downloader.1(localCountDownLatch));
    try
    {
      localCountDownLatch.await();
    }
    catch (InterruptedException paramString1)
    {
      LogUtil.b("Downloader", "InterruptedException: %s ", new Object[] { paramString1 });
    }
    if (paramString2.exists())
    {
      LogUtil.b("Downloader", "downloadFile: download success file size %s", new Object[] { Long.valueOf(paramString2.length()) });
      return paramString2;
    }
    LogUtil.b("Downloader", "downloadFile :download fail.", new Object[0]);
    return null;
  }
  
  public static void a()
  {
    a = null;
  }
  
  public static void a(DownLoaderInterface paramDownLoaderInterface)
  {
    a = paramDownLoaderInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.pluginloaderservice.download.Downloader
 * JD-Core Version:    0.7.0.1
 */