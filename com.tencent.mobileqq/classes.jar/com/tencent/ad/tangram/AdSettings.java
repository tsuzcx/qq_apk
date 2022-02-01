package com.tencent.ad.tangram;

import android.support.annotation.Keep;

@Keep
public final class AdSettings
{
  private static boolean isTestMode = false;
  
  public static boolean isTestMode()
  {
    return isTestMode;
  }
  
  public static void setTestMode(boolean paramBoolean)
  {
    isTestMode = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.AdSettings
 * JD-Core Version:    0.7.0.1
 */