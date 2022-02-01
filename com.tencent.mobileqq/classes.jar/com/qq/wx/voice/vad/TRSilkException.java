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
    switch (paramInt)
    {
    default: 
      localObject = "unknown error";
      break;
    case -100: 
      localObject = "out of memory";
      break;
    case -101: 
      localObject = "silk engine error";
      break;
    case -102: 
      localObject = "should init at first";
      break;
    case -103: 
      localObject = "already init";
      break;
    case -104: 
      localObject = "null param or 0 length";
      break;
    case -105: 
      localObject = "bit rate must between 0 and 48000";
      break;
    case -106: 
      localObject = "sample rate must between 0 and 16000";
      break;
    case -107: 
      localObject = "the input size is too long";
    }
    this.b = ((String)localObject);
    Object localObject = new StringBuilder("errorCode: ");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append("\t msg: ");
    ((StringBuilder)localObject).append(this.b);
    Log.e("TRSilkException", ((StringBuilder)localObject).toString());
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