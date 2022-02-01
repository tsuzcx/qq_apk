package com.qq.wx.voice.vad;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class TRSilkDecoder
{
  private static int a = 24000;
  private static int b = 16000;
  private static TRSilk c;
  
  public TRSilkDecoder()
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
        byte[] arrayOfByte = c.silkDecode(paramArrayOfByte, i, Math.min(64, paramInt - i));
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
        i += 64;
      }
    }
    return null;
  }
  
  public static byte[] processSilkToPCM(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte.length > 0)
    {
      TRSilk localTRSilk = c;
      arrayOfByte = paramArrayOfByte;
      if (localTRSilk != null)
      {
        arrayOfByte = paramArrayOfByte;
        try
        {
          localTRSilk.silkDecodeInit(a, b);
          arrayOfByte = paramArrayOfByte;
          paramArrayOfByte = a(paramArrayOfByte, paramArrayOfByte.length);
          arrayOfByte = paramArrayOfByte;
          c.silkDecodeRelease();
          return paramArrayOfByte;
        }
        catch (TRSilkException paramArrayOfByte)
        {
          paramArrayOfByte.printStackTrace();
        }
      }
    }
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.wx.voice.vad.TRSilkDecoder
 * JD-Core Version:    0.7.0.1
 */