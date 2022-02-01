package com.tencent.mobileqq.apollo.utils;

import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

public class ApolloResDownloaderUtil
{
  @Nullable
  public static DownloaderInterface a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = (DownloaderFactory)paramAppRuntime.getManager(QQManagerFactory.DOWNLOADER_FACTORY);
    if (paramAppRuntime == null) {
      return null;
    }
    paramAppRuntime = paramAppRuntime.a(3);
    if (paramAppRuntime == null) {
      return null;
    }
    return paramAppRuntime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloResDownloaderUtil
 * JD-Core Version:    0.7.0.1
 */