package com.qq.wx.voice.vad;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class TRSilkEncoder
{
  private static int a = 24000;
  private static int b = 16000;
  private static TRSilk c;
  
  public TRSilkEncoder()
  {
    c = new TRSilk();
  }
  
  private static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte != null) && (paramInt > 0))
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      int i = 0;
      for (;;)
      {
        if (i >= paramInt)
        {
          try
          {
            localByteArrayOutputStream.flush();
          }
          catch (IOException paramArrayOfByte)
          {
            paramArrayOfByte.printStackTrace();
          }
          return localByteArrayOutputStream.toByteArray();
        }
        byte[] arrayOfByte = c.silkEncode(paramArrayOfByte, i, Math.min(1024, paramInt - i));
        if (arrayOfByte != null) {
          try
          {
            localByteArrayOutputStream.write(arrayOfByte);
          }
          catch (IOException localIOException)
          {
            localIOException.printStackTrace();
          }
        }
        i += 1024;
      }
    }
    return null;
  }
  
  public static byte[] processPCMToSilk(byte[] paramArrayOfByte)
  {
    Object localObject = null;
    if (paramArrayOfByte == null) {
      return null;
    }
    c.silkInit(a, b);
    try
    {
      paramArrayOfByte = a(paramArrayOfByte, paramArrayOfByte.length);
    }
    catch (TRSilkException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      paramArrayOfByte = localObject;
    }
    c.silkRelease();
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.wx.voice.vad.TRSilkEncoder
 * JD-Core Version:    0.7.0.1
 */