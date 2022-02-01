package com.tencent.avcore.jni.codec;

public class HWCodecAbility
{
  public int codecType = 8;
  public boolean isHWCodec = false;
  public int maxH = 720;
  public int maxW = 1280;
  
  public HWCodecAbility() {}
  
  public HWCodecAbility(int paramInt, boolean paramBoolean)
  {
    this.codecType = paramInt;
    this.isHWCodec = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avcore.jni.codec.HWCodecAbility
 * JD-Core Version:    0.7.0.1
 */