package com.tencent.mfsdk.config;

import acxp;
import com.tencent.mfsdk.MagnifierSDK;

public class Config
{
  public static int MAX_REPORT_NUM = 100;
  public static final int PLUGIN_BATTERY = 16;
  public static final int PLUGIN_CEILING = 9;
  public static final int PLUGIN_DB = 14;
  public static final int PLUGIN_DROPFRAME = 1;
  public static final int PLUGIN_FILE_DESCRIPTOR = 137;
  public static final int PLUGIN_FPS = 4;
  public static final int PLUGIN_IO = 6;
  public static final int PLUGIN_MEMORY = 7;
  public static final int PLUGIN_MEMORY_CACHE = 22;
  public static final int PLUGIN_NEWFLOW = 17;
  public static final int PLUGIN_QCLOUD_AUDIO_STACK = 119;
  public static final int PLUGIN_QCLOUD_CPU_TRACE = 126;
  public static final int PLUGIN_QCLOUD_CT_STACK = 103;
  public static final int PLUGIN_QCLOUD_DB_IO = 105;
  public static final int PLUGIN_QCLOUD_DROPFRAME = 101;
  public static final int PLUGIN_QCLOUD_FILE_IO = 106;
  public static final int PLUGIN_QCLOUD_HELD_THREAD = 123;
  public static final int PLUGIN_QCLOUD_MEMORY_CACHE = 129;
  public static final int PLUGIN_QCLOUD_TRAFFIC = 104;
  public static final int[] Plugins = { 103, 104, 105, 106, 119, 123, 126, 129 };
  
  public APMConfig loadLocalConfigs()
  {
    acxp.a();
    return MagnifierSDK.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mfsdk.config.Config
 * JD-Core Version:    0.7.0.1
 */