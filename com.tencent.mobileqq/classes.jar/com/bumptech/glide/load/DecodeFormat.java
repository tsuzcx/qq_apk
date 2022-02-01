package com.bumptech.glide.load;

public enum DecodeFormat
{
  public static final DecodeFormat DEFAULT;
  
  static
  {
    DecodeFormat localDecodeFormat1 = PREFER_ARGB_8888;
    DecodeFormat localDecodeFormat2 = PREFER_ARGB_8888_DISALLOW_HARDWARE;
    $VALUES = new DecodeFormat[] { localDecodeFormat1, localDecodeFormat2, PREFER_RGB_565 };
    DEFAULT = localDecodeFormat2;
  }
  
  private DecodeFormat() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.DecodeFormat
 * JD-Core Version:    0.7.0.1
 */