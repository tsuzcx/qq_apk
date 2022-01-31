package com.tencent.component.network.downloader.impl;

import android.text.TextUtils;
import com.tencent.component.network.downloader.Downloader;

public class ImageDownloaderInitializer
{
  private static final char CHAR_EQUALS = '=';
  private static final int IMAGE_URL_KP_ALLOWED = 1;
  public static final int IMAGE_URL_PT_QZONE_ALBUM = 0;
  
  public static void initImageDownloader(Downloader paramDownloader)
  {
    if (paramDownloader == null) {
      return;
    }
    paramDownloader.setPreprocessStrategy(new ImageDownloaderInitializer.1(paramDownloader));
    paramDownloader.setContentHandler(new ImageDownloaderInitializer.2());
  }
  
  private static boolean isMADomain(String paramString)
  {
    boolean bool1 = false;
    try
    {
      if ((!"m.qpic.cn".equalsIgnoreCase(paramString)) && (!"a1.qpic.cn".equalsIgnoreCase(paramString)) && (!"a2.qpic.cn".equalsIgnoreCase(paramString)) && (!"a3.qpic.cn".equalsIgnoreCase(paramString)))
      {
        boolean bool2 = "a4.qpic.cn".equalsIgnoreCase(paramString);
        if (!bool2) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  private static boolean needCookie(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.endsWith("photo.store.qq.com")) && (!paramString.endsWith("qpic.cn"))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.ImageDownloaderInitializer
 * JD-Core Version:    0.7.0.1
 */