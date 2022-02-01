package com.tencent.av.config;

public class MediaCodecChipConfigInfo$ChipAbilityInfo
{
  public static final ChipAbilityInfo a;
  public int a;
  public long a;
  public boolean a;
  public int b = 720;
  
  static
  {
    jdField_a_of_type_ComTencentAvConfigMediaCodecChipConfigInfo$ChipAbilityInfo = new ChipAbilityInfo();
  }
  
  public MediaCodecChipConfigInfo$ChipAbilityInfo()
  {
    this.jdField_a_of_type_Int = 1280;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ChipAbilityInfo{");
    localStringBuffer.append("mChipPowerMark = '").append(MediaCodecChipConfigInfo.a(this.jdField_a_of_type_Long)).append('\'');
    localStringBuffer.append("mPowerSupport = '").append(this.jdField_a_of_type_Boolean).append('\'');
    localStringBuffer.append("mMaxWidth = '").append(this.jdField_a_of_type_Int).append('\'');
    localStringBuffer.append("mMaxHeight = '").append(this.b).append('\'');
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.config.MediaCodecChipConfigInfo.ChipAbilityInfo
 * JD-Core Version:    0.7.0.1
 */