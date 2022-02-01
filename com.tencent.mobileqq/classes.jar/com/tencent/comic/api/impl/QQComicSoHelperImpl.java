package com.tencent.comic.api.impl;

import com.tencent.comic.VipComicSoHelper;
import com.tencent.comic.api.IQQComicSoHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class QQComicSoHelperImpl
  implements IQQComicSoHelper
{
  public static final String TAG = "QQComicSoHelperImpl";
  
  public String getComicPlayerSoPath()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(VipComicSoHelper.a());
    localStringBuilder.append("libqgplayer_841.so");
    return localStringBuilder.toString();
  }
  
  public String getComicPlayerSoZipPath()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(VipComicSoHelper.a());
    localStringBuilder.append("libQGamePlayer.zip");
    return localStringBuilder.toString();
  }
  
  public void onSoDownloadCompleted(AppRuntime paramAppRuntime, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSoDownloadCompleted: code=");
      localStringBuilder.append(paramInt);
      QLog.i("QQComicSoHelperImpl", 2, localStringBuilder.toString());
    }
    VipComicSoHelper.a(paramAppRuntime, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.api.impl.QQComicSoHelperImpl
 * JD-Core Version:    0.7.0.1
 */