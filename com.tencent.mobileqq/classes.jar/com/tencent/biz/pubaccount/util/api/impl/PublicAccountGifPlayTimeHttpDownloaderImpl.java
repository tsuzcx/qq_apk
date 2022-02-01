package com.tencent.biz.pubaccount.util.api.impl;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountGifPlayTimeHttpDownloader;
import com.tencent.biz.pubaccount.util.api.IPublicAccountGifPlayTimeHttpDownloader.LooperGifImage;
import com.tencent.image.DownloadParams;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawableHandler;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONObject;

public class PublicAccountGifPlayTimeHttpDownloaderImpl
  extends PublicAccountHttpDownloaderImpl
  implements IPublicAccountGifPlayTimeHttpDownloader
{
  final int playTime = 3;
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if (GifDrawable.isGifFile(paramFile)) {
      if (!(paramDownloadParams.mExtraInfo instanceof JSONObject)) {
        break label52;
      }
    }
    label52:
    for (int i = ((JSONObject)paramDownloadParams.mExtraInfo).optInt("gifPlayCount", 3);; i = 3)
    {
      return new IPublicAccountGifPlayTimeHttpDownloader.LooperGifImage(paramFile, true, i);
      return super.decodeFile(paramFile, paramDownloadParams, paramURLDrawableHandler);
    }
  }
  
  public URL getPubURL(String paramString)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountGifPlayTimeHttpDownloaderImpl
 * JD-Core Version:    0.7.0.1
 */