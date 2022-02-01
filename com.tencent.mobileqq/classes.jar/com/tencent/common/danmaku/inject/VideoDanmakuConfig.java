package com.tencent.common.danmaku.inject;

import com.tencent.common.danmaku.util.Logger;

public class VideoDanmakuConfig
{
  private static EnableHardwareAccelerateChecker a;
  private static boolean b;
  
  public static void a(VideoDanmakuConfig.ILogger paramILogger)
  {
    if (paramILogger != null) {
      Logger.a(paramILogger);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    b = paramBoolean;
  }
  
  public static boolean a()
  {
    return (b) && (b());
  }
  
  private static boolean b()
  {
    EnableHardwareAccelerateChecker localEnableHardwareAccelerateChecker = a;
    if (localEnableHardwareAccelerateChecker != null) {
      return localEnableHardwareAccelerateChecker.a();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.inject.VideoDanmakuConfig
 * JD-Core Version:    0.7.0.1
 */