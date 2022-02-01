package com.tencent.magicbrush.handler;

import androidx.annotation.Keep;
import com.tencent.luggage.wxa.gi.c.c;
import java.io.UnsupportedEncodingException;

@Keep
public class MBCharsetHandler
{
  private static final String TAG = "MicroMsg.MBCharsetHandler";
  
  @Keep
  static String decode(byte[] paramArrayOfByte, String paramString)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return null;
      }
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte, paramString);
        return paramArrayOfByte;
      }
      catch (UnsupportedEncodingException paramArrayOfByte)
      {
        c.c.c("MicroMsg.MBCharsetHandler", "UnsupportedDecoding [%s] [%s]", new Object[] { paramString, paramArrayOfByte });
      }
    }
    return null;
  }
  
  @Keep
  public static byte[] encode(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return null;
    }
    try
    {
      paramString1 = paramString1.getBytes(paramString2);
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      c.c.c("MicroMsg.MBCharsetHandler", "MBCharsetHandler encode failed. [%s]", new Object[] { paramString1 });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.handler.MBCharsetHandler
 * JD-Core Version:    0.7.0.1
 */