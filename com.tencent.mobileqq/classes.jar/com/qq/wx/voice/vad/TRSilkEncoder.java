package com.qq.wx.voice.vad;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class TRSilkEncoder
{
  private static int a = 24000;
  private static int b = 16000;
  private static TRSilk c = null;
  
  public TRSilkEncoder()
  {
    c = new TRSilk();
  }
  
  private static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = null;
    Object localObject = arrayOfByte;
    int i;
    if (paramArrayOfByte != null)
    {
      localObject = arrayOfByte;
      if (paramInt > 0)
      {
        localObject = new ByteArrayOutputStream();
        i = 0;
      }
    }
    for (;;)
    {
      if (i >= paramInt) {}
      try
      {
        ((ByteArrayOutputStream)localObject).flush();
        localObject = ((ByteArrayOutputStream)localObject).toByteArray();
        return localObject;
        arrayOfByte = c.silkEncode(paramArrayOfByte, i, Math.min(1024, paramInt - i));
        if (arrayOfByte != null) {}
        try
        {
          ((ByteArrayOutputStream)localObject).write(arrayOfByte);
          i += 1024;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            localIOException.printStackTrace();
          }
        }
      }
      catch (IOException paramArrayOfByte)
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
        }
      }
    }
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
      c.silkRelease();
      return paramArrayOfByte;
    }
    catch (TRSilkException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.qq.wx.voice.vad.TRSilkEncoder
 * JD-Core Version:    0.7.0.1
 */