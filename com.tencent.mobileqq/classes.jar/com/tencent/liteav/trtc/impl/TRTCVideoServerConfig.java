package com.tencent.liteav.trtc.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class TRTCVideoServerConfig
{
  private static final String KEY_ENABLE_DEC_VUI = "enable_hw_vui";
  private static final String VIDEO_SERVER_CONFIG = "trtc_video_server_config";
  public boolean enableHWVUI = true;
  
  public static TRTCVideoServerConfig loadFromSharedPreferences(Context paramContext)
  {
    try
    {
      TRTCVideoServerConfig localTRTCVideoServerConfig = new TRTCVideoServerConfig();
      localTRTCVideoServerConfig.enableHWVUI = paramContext.getSharedPreferences("trtc_video_server_config", 0).getBoolean("enable_hw_vui", true);
      return localTRTCVideoServerConfig;
    }
    finally {}
  }
  
  public static void saveToSharedPreferences(Context paramContext, TRTCVideoServerConfig paramTRTCVideoServerConfig)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("trtc_video_server_config", 0).edit();
      paramContext.putBoolean("enable_hw_vui", paramTRTCVideoServerConfig.enableHWVUI);
      paramContext.apply();
      return;
    }
    finally {}
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enableHWVUI: ");
    localStringBuilder.append(this.enableHWVUI);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCVideoServerConfig
 * JD-Core Version:    0.7.0.1
 */