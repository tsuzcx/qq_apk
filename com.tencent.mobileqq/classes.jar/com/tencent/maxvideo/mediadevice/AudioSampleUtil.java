package com.tencent.maxvideo.mediadevice;

public class AudioSampleUtil
{
  public static int bytesInMillisecond(int paramInt1, int paramInt2, int paramInt3)
  {
    return bytesInSecond(paramInt1, paramInt2, paramInt3) / 1000;
  }
  
  public static int bytesInSecond(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 1;
    if (paramInt2 != 12) {
      paramInt2 = 1;
    } else {
      paramInt2 = 2;
    }
    if (paramInt3 != 2) {
      paramInt3 = i;
    } else {
      paramInt3 = 2;
    }
    return paramInt1 * paramInt3 * paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.maxvideo.mediadevice.AudioSampleUtil
 * JD-Core Version:    0.7.0.1
 */