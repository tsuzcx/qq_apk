package com.tencent.component.network.module.base;

import com.tencent.component.network.module.base.inter.IDownloadConfig;
import java.util.HashMap;
import java.util.Properties;

public class Config
{
  public static final boolean DEFAULT_ENABLE_DNS114 = true;
  public static final int DEFAULT_HTTP2_LIVE_TIME = 120;
  public static final int DEFAULT_HTTP2_THREAD_POOLSIZE = 2;
  public static final int DEFAULT_HTTP_LIVE_TIME = 120;
  public static final int DEFAULT_KP_CONFIG = -1;
  public static final int DEFAULT_KP_PROXY_CONFIG = -1;
  public static final String DEFAULT_QUA = "";
  public static final String DEFAULT_REFER = "tencent";
  public static final int DEFAULT_REPORT_PERCENT = 5;
  public static final String DEFAULT_TERMINAL = "android";
  public static final int DEFAULT_THREAD_POOLSIZE = 2;
  public static final String DEFAULT_USER_AGENT = "android-tencent";
  public static final String DEFAULT_VERSION = "1.0";
  public static final String MAIN_KEY_PHOTO_SVRLIST = "PhotoSvrList";
  public static final String SECONDARY_KEY_HTTPS_DIS_VALID_TIME = "disable_https_time";
  public static final long SECONDARY_KEY_HTTPS_DIS_VALID_TIME_DEFAULT = 86400L;
  public static final String SECONDARY_KEY_HTTPS_FAILCOUNT = "disable_https_failcount";
  public static final long SECONDARY_KEY_HTTPS_FAILCOUNT_DEFAULT = 6L;
  private static IDownloadConfig sRealConfig;
  
  public static boolean canRetCodeRetry(int paramInt)
  {
    IDownloadConfig localIDownloadConfig = sRealConfig;
    if (localIDownloadConfig != null) {
      return localIDownloadConfig.canRetCodeRetry(paramInt);
    }
    return false;
  }
  
  public static boolean enableDns114()
  {
    IDownloadConfig localIDownloadConfig = sRealConfig;
    if (localIDownloadConfig != null) {
      return localIDownloadConfig.enableDns114();
    }
    return true;
  }
  
  public static long getConfig(String paramString1, String paramString2, long paramLong)
  {
    IDownloadConfig localIDownloadConfig = sRealConfig;
    long l = paramLong;
    if (localIDownloadConfig != null) {
      l = localIDownloadConfig.getConfig(paramString1, paramString2, paramLong);
    }
    return l;
  }
  
  public static long getCurrentUin()
  {
    IDownloadConfig localIDownloadConfig = sRealConfig;
    if (localIDownloadConfig != null) {
      return localIDownloadConfig.getCurrentUin();
    }
    return 0L;
  }
  
  public static long getDefaultHttp2LiveTime()
  {
    IDownloadConfig localIDownloadConfig = sRealConfig;
    if ((localIDownloadConfig != null) && (localIDownloadConfig.getDefaultHttp2LiveTime() > 0L)) {
      return sRealConfig.getDefaultHttp2LiveTime();
    }
    return 120L;
  }
  
  public static int getDefaultHttp2ThreadPoolSize()
  {
    IDownloadConfig localIDownloadConfig = sRealConfig;
    if ((localIDownloadConfig != null) && (localIDownloadConfig.getDefaultHttp2ThreadPoolSize() > 0)) {
      return sRealConfig.getDefaultHttp2ThreadPoolSize();
    }
    return 2;
  }
  
  public static long getDefaultHttpLiveTime()
  {
    IDownloadConfig localIDownloadConfig = sRealConfig;
    if ((localIDownloadConfig != null) && (localIDownloadConfig.getDefaultHttpLiveTime() > 0L)) {
      return sRealConfig.getDefaultHttpLiveTime();
    }
    return 120L;
  }
  
  public static int getDefaultThreadPoolSize()
  {
    IDownloadConfig localIDownloadConfig = sRealConfig;
    if ((localIDownloadConfig != null) && (localIDownloadConfig.getDefaultThreadPoolSize() > 0)) {
      return sRealConfig.getDefaultThreadPoolSize();
    }
    return 2;
  }
  
  public static int getNetworkStackType()
  {
    IDownloadConfig localIDownloadConfig = sRealConfig;
    if (localIDownloadConfig != null) {
      return localIDownloadConfig.getNetworkStackType();
    }
    return 0;
  }
  
  public static int getOperator()
  {
    IDownloadConfig localIDownloadConfig = sRealConfig;
    if (localIDownloadConfig != null) {
      return localIDownloadConfig.getOperator();
    }
    return 0;
  }
  
  public static String getQUA()
  {
    IDownloadConfig localIDownloadConfig = sRealConfig;
    if (localIDownloadConfig != null) {
      return localIDownloadConfig.getQUA();
    }
    return "";
  }
  
  public static String getRefer()
  {
    IDownloadConfig localIDownloadConfig = sRealConfig;
    if (localIDownloadConfig != null) {
      return localIDownloadConfig.getRefer();
    }
    return "tencent";
  }
  
  public static int getReportPercent()
  {
    IDownloadConfig localIDownloadConfig = sRealConfig;
    if (localIDownloadConfig != null) {
      return localIDownloadConfig.getReportPercent();
    }
    return 5;
  }
  
  public static String getTerminal()
  {
    IDownloadConfig localIDownloadConfig = sRealConfig;
    if (localIDownloadConfig != null) {
      return localIDownloadConfig.getTerminal();
    }
    return "android";
  }
  
  public static String getUserAgent()
  {
    IDownloadConfig localIDownloadConfig = sRealConfig;
    if (localIDownloadConfig != null) {
      return localIDownloadConfig.getUserAgent();
    }
    return "android-tencent";
  }
  
  public static String getVersion()
  {
    IDownloadConfig localIDownloadConfig = sRealConfig;
    if (localIDownloadConfig != null) {
      return localIDownloadConfig.getVersion();
    }
    return "1.0";
  }
  
  public static boolean isFromQzoneAlbum(String paramString)
  {
    IDownloadConfig localIDownloadConfig = sRealConfig;
    if (localIDownloadConfig != null) {
      return localIDownloadConfig.isFromQzoneAlbum(paramString);
    }
    return false;
  }
  
  public static int photoDownloadKeepAliveConfig()
  {
    IDownloadConfig localIDownloadConfig = sRealConfig;
    if (localIDownloadConfig != null) {
      return localIDownloadConfig.photoDownloadKeepAliveConfig();
    }
    return -1;
  }
  
  public static int photoDownloadKeepAliveProxyConfig()
  {
    IDownloadConfig localIDownloadConfig = sRealConfig;
    if (localIDownloadConfig != null) {
      return localIDownloadConfig.photoDownloadKeepAliveProxyConfig();
    }
    return -1;
  }
  
  public static void reportToBeacon(String paramString, boolean paramBoolean, HashMap<String, String> paramHashMap, long paramLong)
  {
    IDownloadConfig localIDownloadConfig = sRealConfig;
    if (localIDownloadConfig != null) {
      localIDownloadConfig.reportToBeacon(paramString, paramBoolean, paramHashMap, paramLong);
    }
  }
  
  public static void reportToLp(int paramInt1, boolean paramBoolean, String paramString1, int paramInt2, String paramString2)
  {
    IDownloadConfig localIDownloadConfig = sRealConfig;
    if (localIDownloadConfig != null) {
      localIDownloadConfig.reportToLp(paramInt1, paramBoolean, paramString1, paramInt2, paramString2);
    }
  }
  
  public static void reportToMta(String paramString, Properties paramProperties)
  {
    IDownloadConfig localIDownloadConfig = sRealConfig;
    if (localIDownloadConfig != null) {
      localIDownloadConfig.reportToMta(paramString, paramProperties);
    }
  }
  
  public static void setConfig(IDownloadConfig paramIDownloadConfig)
  {
    sRealConfig = paramIDownloadConfig;
  }
  
  public static boolean shouldUseHttp2(String paramString)
  {
    IDownloadConfig localIDownloadConfig = sRealConfig;
    if (localIDownloadConfig != null) {
      return localIDownloadConfig.shouldUseHttp2(paramString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.module.base.Config
 * JD-Core Version:    0.7.0.1
 */