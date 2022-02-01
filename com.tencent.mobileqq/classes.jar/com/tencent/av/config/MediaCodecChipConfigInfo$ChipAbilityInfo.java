package com.tencent.av.config;

public class MediaCodecChipConfigInfo$ChipAbilityInfo
{
  public static final ChipAbilityInfo a = new ChipAbilityInfo();
  public long b;
  public boolean c;
  public int d = 1280;
  public int e = 720;
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ChipAbilityInfo{");
    localStringBuffer.append("mChipPowerMark = '");
    localStringBuffer.append(MediaCodecChipConfigInfo.a(this.b));
    localStringBuffer.append('\'');
    localStringBuffer.append("mPowerSupport = '");
    localStringBuffer.append(this.c);
    localStringBuffer.append('\'');
    localStringBuffer.append("mMaxWidth = '");
    localStringBuffer.append(this.d);
    localStringBuffer.append('\'');
    localStringBuffer.append("mMaxHeight = '");
    localStringBuffer.append(this.e);
    localStringBuffer.append('\'');
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.config.MediaCodecChipConfigInfo.ChipAbilityInfo
 * JD-Core Version:    0.7.0.1
 */