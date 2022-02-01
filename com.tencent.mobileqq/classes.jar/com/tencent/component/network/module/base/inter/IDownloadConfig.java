package com.tencent.component.network.module.base.inter;

import java.util.HashMap;
import java.util.Properties;

public abstract interface IDownloadConfig
{
  public abstract boolean canRetCodeRetry(int paramInt);
  
  public abstract boolean enableDns114();
  
  public abstract long getConfig(String paramString1, String paramString2, long paramLong);
  
  public abstract long getCurrentUin();
  
  public abstract long getDefaultHttp2LiveTime();
  
  public abstract int getDefaultHttp2ThreadPoolSize();
  
  public abstract long getDefaultHttpLiveTime();
  
  public abstract int getDefaultThreadPoolSize();
  
  public abstract int getNetworkStackType();
  
  public abstract int getOperator();
  
  public abstract String getQUA();
  
  public abstract String getRefer();
  
  public abstract int getReportPercent();
  
  public abstract String getTerminal();
  
  public abstract String getUserAgent();
  
  public abstract String getVersion();
  
  public abstract boolean isFromQzoneAlbum(String paramString);
  
  public abstract int photoDownloadKeepAliveConfig();
  
  public abstract int photoDownloadKeepAliveProxyConfig();
  
  public abstract void reportToBeacon(String paramString, boolean paramBoolean, HashMap<String, String> paramHashMap, long paramLong);
  
  public abstract void reportToLp(int paramInt1, boolean paramBoolean, String paramString1, int paramInt2, String paramString2);
  
  public abstract void reportToMta(String paramString, Properties paramProperties);
  
  public abstract boolean shouldUseHttp2(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.network.module.base.inter.IDownloadConfig
 * JD-Core Version:    0.7.0.1
 */