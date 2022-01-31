package com.tencent.biz.pubaccount.util;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawableHandler;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class GifPlayTimeHttpDownloader
  extends PubAccountHttpDownloader
{
  final int a = 3;
  
  public GifPlayTimeHttpDownloader(BaseApplicationImpl paramBaseApplicationImpl)
  {
    super(paramBaseApplicationImpl);
  }
  
  public static URL a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = new URL("pubaccountimage_gifplaytime", null, paramString);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      for (;;)
      {
        QLog.e("PubAccountHttpDownloader", 2, "getPubURL urlString", paramString);
        paramString = null;
      }
    }
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if (GifDrawable.isGifFile(paramFile)) {
      return new GifPlayTimeHttpDownloader.LooperGifImage(paramFile, true, 3);
    }
    return super.decodeFile(paramFile, paramDownloadParams, paramURLDrawableHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.GifPlayTimeHttpDownloader
 * JD-Core Version:    0.7.0.1
 */