package com.tencent.map.geolocation.internal;

import org.eclipse.jdt.annotation.NonNull;

public abstract interface TencentLog
{
  public static final String LOGNAME = "txwatchdog";
  public static final String PREFIX = "txwatchdog_";
  
  public abstract String getDirString();
  
  public abstract void println(String paramString1, int paramInt, @NonNull String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.geolocation.internal.TencentLog
 * JD-Core Version:    0.7.0.1
 */