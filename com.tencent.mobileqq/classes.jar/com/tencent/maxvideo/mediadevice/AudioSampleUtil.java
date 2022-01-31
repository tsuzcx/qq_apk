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
    switch (paramInt2)
    {
    default: 
      paramInt2 = i;
      i = 1;
      switch (paramInt3)
      {
      default: 
        paramInt3 = i;
      }
      break;
    }
    for (;;)
    {
      return paramInt1 * paramInt3 * paramInt2;
      paramInt2 = 1;
      break;
      paramInt2 = 2;
      break;
      paramInt3 = 2;
      continue;
      paramInt3 = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.maxvideo.mediadevice.AudioSampleUtil
 * JD-Core Version:    0.7.0.1
 */