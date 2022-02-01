package com.tencent.luggage.wxaapi;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract interface DebugApi
{
  public static final String DEFAULT_DEBUG_IP = "180.163.26.93";
  public static final int TYPE_CHECK_UPDATE = 2;
  public static final int TYPE_CLEAR_VERSION = 4;
  public static final int TYPE_DEBUG_XWEB = 6;
  public static final int TYPE_DISABLE_LOCAL_DEBUG = 7;
  public static final int TYPE_ENABLE_LOCAL_DEBUG = 0;
  public static final int TYPE_INSPECTOR = 3;
  public static final int TYPE_SHOW_VERSION = 1;
  public static final int TYPE_UPDATE_CONFIG = 5;
  
  public abstract void debugXWeb(Context paramContext, int paramInt);
  
  public abstract void deleteLibFile();
  
  @NonNull
  public abstract String getDebugIP();
  
  public abstract boolean getIsDebugIP();
  
  public abstract boolean isMultiTaskModeEnabledForWxaApp();
  
  public abstract long launchByQRRawData(@Nullable Context paramContext, @NonNull String paramString, @Nullable LaunchWxaAppResultListener paramLaunchWxaAppResultListener);
  
  public abstract void setDebugIP(@NonNull String paramString);
  
  public abstract void setIsDebugIP(boolean paramBoolean);
  
  public abstract void setMultiTaskModeEnabledForWxaApp(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxaapi.DebugApi
 * JD-Core Version:    0.7.0.1
 */