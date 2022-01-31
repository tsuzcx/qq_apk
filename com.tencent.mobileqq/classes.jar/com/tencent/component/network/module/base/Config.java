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
  private static IDownloadConfig sRealConfig = null;
  
  public static boolean canRetCodeRetry(int paramInt)
  {
    if (sRealConfig != null) {
      return sRealConfig.canRetCodeRetry(paramInt);
    }
    return false;
  }
  
  public static boolean enableDns114()
  {
    if (sRealConfig != null) {
      return sRealConfig.enableDns114();
    }
    return true;
  }
  
  public static long getConfig(String paramString1, String paramString2, long paramLong)
  {
    long l = paramLong;
    if (sRealConfig != null) {
      l = sRealConfig.getConfig(paramString1, paramString2, paramLong);
    }
    return l;
  }
  
  public static long getCurrentUin()
  {
    if (sRealConfig != null) {
      return sRealConfig.getCurrentUin();
    }
    return 0L;
  }
  
  public static long getDefaultHttp2LiveTime()
  {
    if ((sRealConfig != null) && (sRealConfig.getDefaultHttp2LiveTime() > 0L)) {
      return sRealConfig.getDefaultHttp2LiveTime();
    }
    return 120L;
  }
  
  public static int getDefaultHttp2ThreadPoolSize()
  {
    if ((sRealConfig != null) && (sRealConfig.getDefaultHttp2ThreadPoolSize() > 0)) {
      return sRealConfig.getDefaultHttp2ThreadPoolSize();
    }
    return 2;
  }
  
  public static long getDefaultHttpLiveTime()
  {
    if ((sRealConfig != null) && (sRealConfig.getDefaultHttpLiveTime() > 0L)) {
      return sRealConfig.getDefaultHttpLiveTime();
    }
    return 120L;
  }
  
  public static int getDefaultThreadPoolSize()
  {
    if ((sRealConfig != null) && (sRealConfig.getDefaultThreadPoolSize() > 0)) {
      return sRealConfig.getDefaultThreadPoolSize();
    }
    return 2;
  }
  
  public static int getNetworkStackType()
  {
    if (sRealConfig != null) {
      return sRealConfig.getNetworkStackType();
    }
    return 0;
  }
  
  public static int getOperator()
  {
    if (sRealConfig != null) {
      return sRealConfig.getOperator();
    }
    return 0;
  }
  
  public static String getQUA()
  {
    if (sRealConfig != null) {
      return sRealConfig.getQUA();
    }
    return "";
  }
  
  public static String getRefer()
  {
    if (sRealConfig != null) {
      return sRealConfig.getRefer();
    }
    return "tencent";
  }
  
  public static int getReportPercent()
  {
    if (sRealConfig != null) {
      return sRealConfig.getReportPercent();
    }
    return 5;
  }
  
  public static String getTerminal()
  {
    if (sRealConfig != null) {
      return sRealConfig.getTerminal();
    }
    return "android";
  }
  
  public static String getUserAgent()
  {
    if (sRealConfig != null) {
      return sRealConfig.getUserAgent();
    }
    return "android-tencent";
  }
  
  public static String getVersion()
  {
    if (sRealConfig != null) {
      return sRealConfig.getVersion();
    }
    return "1.0";
  }
  
  public static boolean isFromQzoneAlbum(String paramString)
  {
    if (sRealConfig != null) {
      return sRealConfig.isFromQzoneAlbum(paramString);
    }
    return false;
  }
  
  public static int photoDownloadKeepAliveConfig()
  {
    if (sRealConfig != null) {
      return sRealConfig.photoDownloadKeepAliveConfig();
    }
    return -1;
  }
  
  public static int photoDownloadKeepAliveProxyConfig()
  {
    if (sRealConfig != null) {
      return sRealConfig.photoDownloadKeepAliveProxyConfig();
    }
    return -1;
  }
  
  public static void reportToBeacon(String paramString, boolean paramBoolean, HashMap<String, String> paramHashMap, long paramLong)
  {
    if (sRealConfig != null) {
      sRealConfig.reportToBeacon(paramString, paramBoolean, paramHashMap, paramLong);
    }
  }
  
  public static void reportToLp(int paramInt1, boolean paramBoolean, String paramString1, int paramInt2, String paramString2)
  {
    if (sRealConfig != null) {
      sRealConfig.reportToLp(paramInt1, paramBoolean, paramString1, paramInt2, paramString2);
    }
  }
  
  public static void reportToMta(String paramString, Properties paramProperties)
  {
    if (sRealConfig != null) {
      sRealConfig.reportToMta(paramString, paramProperties);
    }
  }
  
  public static void setConfig(IDownloadConfig paramIDownloadConfig)
  {
    sRealConfig = paramIDownloadConfig;
  }
  
  public static boolean shouldUseHttp2(String paramString)
  {
    if (sRealConfig != null) {
      return sRealConfig.shouldUseHttp2(paramString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.module.base.Config
 * JD-Core Version:    0.7.0.1
 */