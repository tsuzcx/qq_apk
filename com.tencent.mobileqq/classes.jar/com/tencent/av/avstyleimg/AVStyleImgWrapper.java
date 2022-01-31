package com.tencent.av.avstyleimg;

public class AVStyleImgWrapper
{
  public static native void init(int paramInt1, int paramInt2);
  
  public static native void makeStyledImg(byte[] paramArrayOfByte);
  
  public static native boolean setFilePath(String paramString1, String paramString2);
  
  public static native void setTemplateImg(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public static native void uninit();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.avstyleimg.AVStyleImgWrapper
 * JD-Core Version:    0.7.0.1
 */