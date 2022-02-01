package com.qq.wx.voice.vad;

import android.util.Log;

public class TRSilkException
  extends Exception
{
  private int a;
  private String b = "";
  
  TRSilkException(int paramInt)
  {
    this.a = paramInt;
    String str;
    switch (paramInt)
    {
    default: 
      str = "unknown error";
    }
    for (;;)
    {
      this.b = str;
      Log.e("TRSilkException", "errorCode: " + this.a + "\t msg: " + this.b);
      return;
      str = "silk engine error";
      continue;
      str = "out of memory";
      continue;
      str = "should init at first";
      continue;
      str = "already init";
      continue;
      str = "null param or 0 length";
      continue;
      str = "bit rate must between 0 and 48000";
      continue;
      str = "sample rate must between 0 and 16000";
      continue;
      str = "the input size is too long";
    }
  }
  
  public int getErrorCode()
  {
    return this.a;
  }
  
  public String getErrorMsg()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.wx.voice.vad.TRSilkException
 * JD-Core Version:    0.7.0.1
 */