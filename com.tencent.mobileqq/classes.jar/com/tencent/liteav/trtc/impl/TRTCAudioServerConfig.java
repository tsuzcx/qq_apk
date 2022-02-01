package com.tencent.liteav.trtc.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.concurrent.TimeUnit;

public class TRTCAudioServerConfig
{
  private static final String AUDIO_SERVER_CONFIG = "trtc_audio_server_config";
  public static final int DEFAULT_16K_PACKAGE_STRATEGY = 0;
  public static final int DEFAULT_DEVICE_AUTO_RESTART_MIN_INTERVAL = 5000;
  public static final boolean DEFAULT_ENABLE_AUTO_RESTART_DEVICE = false;
  public static final boolean DEFAULT_ENABLE_OPENSL = false;
  private static final boolean DEFAULT_IS_LOW_LATENCY_SAMPLERATE_SUPPORTED = false;
  private static final long DEFAULT_LOW_LATENCY_SAMPLERATE_BLOCK_TIME = TimeUnit.DAYS.toMillis(7L);
  public static final int DEFAULT_MAX_SELECTED_PLAY_STREAMS = 0;
  private static final String KEY_16K_PACKAGE_STRATEGY = "16k_package_strategy";
  private static final String KEY_DEVICE_AUTO_RESTART_MIN_INTERVAL = "device_auto_restart_interval";
  private static final String KEY_ENABLE_AUTO_RESTART_DEVICE = "enable_auto_restart_device";
  private static final String KEY_ENABLE_OPENSL = "enable_opensl";
  private static final String KEY_IS_LOW_LATENCY_SAMPLERATE_SUPPORTED = "is_low_latency_samplerate_supported";
  private static final String KEY_LOW_LATENCY_SAMPLERATE_BLOCK_TIME = "low_latency_samplerate_block_time";
  private static final String KEY_MAX_SELECTED_PLAY_STREAMS = "max_selected_play_streams";
  public int audio16KPackageStrategy = 0;
  public int deviceAutoRestartMinInterval = 5000;
  public boolean enableAutoRestartDevice = false;
  public boolean enableOpenSL = false;
  public boolean isLowLatencySampleRateSupported = false;
  public long lowLatencySampleRateBlockTime = DEFAULT_LOW_LATENCY_SAMPLERATE_BLOCK_TIME;
  public int maxSelectedPlayStreams = 0;
  
  public static TRTCAudioServerConfig loadFromSharedPreferences(Context paramContext)
  {
    try
    {
      TRTCAudioServerConfig localTRTCAudioServerConfig = new TRTCAudioServerConfig();
      paramContext = paramContext.getSharedPreferences("trtc_audio_server_config", 0);
      localTRTCAudioServerConfig.enableOpenSL = paramContext.getBoolean("enable_opensl", false);
      localTRTCAudioServerConfig.enableAutoRestartDevice = paramContext.getBoolean("enable_auto_restart_device", false);
      localTRTCAudioServerConfig.deviceAutoRestartMinInterval = paramContext.getInt("device_auto_restart_interval", 5000);
      localTRTCAudioServerConfig.audio16KPackageStrategy = paramContext.getInt("16k_package_strategy", 0);
      localTRTCAudioServerConfig.maxSelectedPlayStreams = paramContext.getInt("max_selected_play_streams", 0);
      localTRTCAudioServerConfig.isLowLatencySampleRateSupported = paramContext.getBoolean("is_low_latency_samplerate_supported", false);
      localTRTCAudioServerConfig.lowLatencySampleRateBlockTime = paramContext.getLong("low_latency_samplerate_block_time", DEFAULT_LOW_LATENCY_SAMPLERATE_BLOCK_TIME);
      return localTRTCAudioServerConfig;
    }
    finally {}
  }
  
  public static void saveToSharedPreferences(Context paramContext, TRTCAudioServerConfig paramTRTCAudioServerConfig)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("trtc_audio_server_config", 0).edit();
      paramContext.putBoolean("enable_opensl", paramTRTCAudioServerConfig.enableOpenSL);
      paramContext.putBoolean("enable_auto_restart_device", paramTRTCAudioServerConfig.enableAutoRestartDevice);
      paramContext.putInt("device_auto_restart_interval", paramTRTCAudioServerConfig.deviceAutoRestartMinInterval);
      paramContext.putInt("16k_package_strategy", paramTRTCAudioServerConfig.audio16KPackageStrategy);
      paramContext.putInt("max_selected_play_streams", paramTRTCAudioServerConfig.maxSelectedPlayStreams);
      paramContext.putBoolean("is_low_latency_samplerate_supported", paramTRTCAudioServerConfig.isLowLatencySampleRateSupported);
      paramContext.putLong("low_latency_samplerate_block_time", paramTRTCAudioServerConfig.lowLatencySampleRateBlockTime);
      paramContext.apply();
      return;
    }
    finally {}
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enableOpenSL: ");
    localStringBuilder.append(this.enableOpenSL);
    localStringBuilder.append(", enableAutoRestartDevice: ");
    localStringBuilder.append(this.enableAutoRestartDevice);
    localStringBuilder.append(", deviceAutoRestartMinInterval: ");
    localStringBuilder.append(this.deviceAutoRestartMinInterval);
    localStringBuilder.append(", audio16KPackageStrategy: ");
    localStringBuilder.append(this.audio16KPackageStrategy);
    localStringBuilder.append(", isLowLatencySampleRateSupported: ");
    localStringBuilder.append(this.isLowLatencySampleRateSupported);
    localStringBuilder.append(", lowLatencySampleRateBlockTime: ");
    localStringBuilder.append(this.lowLatencySampleRateBlockTime);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCAudioServerConfig
 * JD-Core Version:    0.7.0.1
 */