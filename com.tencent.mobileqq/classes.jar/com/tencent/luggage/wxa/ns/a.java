package com.tencent.luggage.wxa.ns;

import android.text.TextUtils;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rt.i;
import java.io.IOException;

public class a
{
  private static a.a a = new a.1();
  
  public static a.a a()
  {
    try
    {
      a.a locala = a;
      return locala;
    }
    finally {}
  }
  
  public static void a(a.a parama)
  {
    if (parama == null) {
      return;
    }
    try
    {
      a = parama;
      return;
    }
    finally {}
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if ("aac".equalsIgnoreCase(paramString)) {
      return true;
    }
    if ("mp3".equalsIgnoreCase(paramString)) {
      return true;
    }
    if ("wav".equalsIgnoreCase(paramString)) {
      return true;
    }
    return "pcm".equalsIgnoreCase(paramString);
  }
  
  public static short[] a(byte[] paramArrayOfByte, int paramInt)
  {
    short[] arrayOfShort = new short[paramInt / 2];
    paramInt = 0;
    while (paramInt < arrayOfShort.length)
    {
      int i = paramInt * 2;
      int j = paramArrayOfByte[i];
      arrayOfShort[paramInt] = ((short)((paramArrayOfByte[(i + 1)] & 0xFF) << 8 | j & 0xFF));
      paramInt += 1;
    }
    return arrayOfShort;
  }
  
  public static boolean b(String paramString)
  {
    paramString = new i(paramString);
    boolean bool;
    if (!paramString.j())
    {
      try
      {
        o.d("MicroMsg.Record.AudioRecordUtil", "new audio file");
        bool = paramString.v();
        return bool;
      }
      catch (Exception paramString) {}catch (IOException paramString)
      {
        break label52;
      }
      o.a("MicroMsg.Record.AudioRecordUtil", paramString, "prepareCacheFile", new Object[0]);
      return false;
      label52:
      o.a("MicroMsg.Record.AudioRecordUtil", paramString, "prepareCacheFile", new Object[0]);
      return false;
    }
    o.d("MicroMsg.Record.AudioRecordUtil", "delete audio file");
    paramString.w();
    try
    {
      bool = paramString.v();
      return bool;
    }
    catch (Exception paramString)
    {
      o.a("MicroMsg.Record.AudioRecordUtil", paramString, "prepareCacheFile", new Object[0]);
      return false;
    }
    catch (IOException paramString)
    {
      o.a("MicroMsg.Record.AudioRecordUtil", paramString, "prepareCacheFile", new Object[0]);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ns.a
 * JD-Core Version:    0.7.0.1
 */