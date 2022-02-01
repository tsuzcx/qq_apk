package com.tencent.avcore.util;

import android.content.Context;

public abstract interface AVSoProxy
{
  public abstract String getAndroidCodecInfo();
  
  public abstract Context getContext();
  
  public abstract String getHardwareDetectSoDir();
  
  public abstract String getHevcDecSoDir();
  
  public abstract String getHevcEncSoDir();
  
  public abstract void updateHevcCodecSoDir();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avcore.util.AVSoProxy
 * JD-Core Version:    0.7.0.1
 */