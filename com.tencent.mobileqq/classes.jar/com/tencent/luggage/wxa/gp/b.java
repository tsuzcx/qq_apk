package com.tencent.luggage.wxa.gp;

import com.tencent.luggage.wxa.gw.a;
import com.tencent.luggage.wxa.rt.k;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class b
{
  protected String a;
  protected String b;
  private InputStream c;
  
  public b(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (paramBoolean) {
      this.b = a.a(paramString2, paramString1);
    } else {
      this.b = a.a(paramString1);
    }
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioConvertCacheReader", "cacheFile:%s", new Object[] { this.b });
    try
    {
      this.c = k.a(a.b(this.b));
    }
    catch (Exception paramString2)
    {
      com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioConvertCacheReader", paramString2, "VFSFileOp.openRead", new Object[0]);
    }
    catch (FileNotFoundException paramString2)
    {
      com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioConvertCacheReader", paramString2, "VFSFileOp.openRead", new Object[0]);
    }
    this.a = paramString1;
  }
  
  public void a()
  {
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioConvertCacheReader", "release");
    try
    {
      if (this.c != null)
      {
        this.c.close();
        this.c = null;
        return;
      }
    }
    catch (Exception localException)
    {
      com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioConvertCacheReader", localException, "inputStream close", new Object[0]);
    }
  }
  
  public byte[] a(int paramInt)
  {
    InputStream localInputStream = this.c;
    if (localInputStream == null)
    {
      com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioConvertCacheReader", "readPcmDataTrack, inputStream is null");
      return null;
    }
    if (paramInt > 0)
    {
      byte[] arrayOfByte = new byte[paramInt];
      try
      {
        paramInt = localInputStream.read(arrayOfByte, 0, paramInt);
        if (paramInt > 0) {
          return arrayOfByte;
        }
      }
      catch (Exception localException)
      {
        com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioConvertCacheReader", localException, "readPcmDataTrack", new Object[0]);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gp.b
 * JD-Core Version:    0.7.0.1
 */