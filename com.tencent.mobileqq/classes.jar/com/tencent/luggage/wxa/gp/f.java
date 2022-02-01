package com.tencent.luggage.wxa.gp;

import com.tencent.luggage.wxa.gw.b;
import com.tencent.luggage.wxa.rt.k;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

public class f
  extends e
{
  private com.tencent.luggage.wxa.gm.d r;
  private OutputStream s;
  private InputStream t;
  
  public f(com.tencent.luggage.wxa.gm.d paramd, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    b.b("MicroMsg.Mix.AudioFixedConvertProcess", "AudioFixedConvertProcess src:%s, sample:%d, channels:%d, encodeBit:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    d.a();
    this.r = paramd;
    this.l = com.tencent.luggage.wxa.gw.a.a(paramString);
    b.b("MicroMsg.Mix.AudioFixedConvertProcess", "outFile:%s", new Object[] { this.l });
    k.i(this.l);
    com.tencent.luggage.wxa.gn.a.a().c(paramd.a);
    try
    {
      this.s = k.b(com.tencent.luggage.wxa.gw.a.b(this.l));
    }
    catch (Exception paramd)
    {
      b.a("MicroMsg.Mix.AudioFixedConvertProcess", paramd, "VFSFileOp.openWrite", new Object[0]);
    }
    catch (FileNotFoundException paramd)
    {
      b.a("MicroMsg.Mix.AudioFixedConvertProcess", paramd, "VFSFileOp.openWrite", new Object[0]);
    }
    try
    {
      this.t = k.a(com.tencent.luggage.wxa.gw.a.b(this.l));
    }
    catch (Exception paramd)
    {
      b.a("MicroMsg.Mix.AudioFixedConvertProcess", paramd, "VFSFileOp.openRead", new Object[0]);
    }
    catch (FileNotFoundException paramd)
    {
      b.a("MicroMsg.Mix.AudioFixedConvertProcess", paramd, "VFSFileOp.openRead", new Object[0]);
    }
    this.k = paramString;
    this.e = 44100;
    this.f = 2;
    this.g = 2;
    a(paramInt1, paramInt2, paramInt3);
  }
  
  public com.tencent.luggage.wxa.gm.e a(int paramInt)
  {
    Object localObject = this.t;
    if (localObject == null)
    {
      b.a("MicroMsg.Mix.AudioFixedConvertProcess", "readPcmDataTrack, inputStream is null");
      return null;
    }
    if (paramInt > 0)
    {
      byte[] arrayOfByte = new byte[paramInt];
      try
      {
        paramInt = ((InputStream)localObject).read(arrayOfByte, 0, paramInt);
        if (paramInt > 0)
        {
          localObject = com.tencent.luggage.wxa.gn.e.a().b();
          ((com.tencent.luggage.wxa.gm.e)localObject).f = arrayOfByte;
          return localObject;
        }
        b.a("MicroMsg.Mix.AudioFixedConvertProcess", "readPcmDataTrack readSize is 0");
        return null;
      }
      catch (Exception localException)
      {
        b.a("MicroMsg.Mix.AudioFixedConvertProcess", localException, "readPcmDataTrack", new Object[0]);
      }
    }
    return null;
  }
  
  public j a()
  {
    return c.a(1);
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return paramArrayOfByte;
    }
    paramArrayOfByte = super.a(paramArrayOfByte);
    OutputStream localOutputStream = this.s;
    if (localOutputStream == null) {
      return paramArrayOfByte;
    }
    if (paramArrayOfByte != null) {
      try
      {
        localOutputStream.write(paramArrayOfByte, 0, paramArrayOfByte.length);
        return paramArrayOfByte;
      }
      catch (Exception localException)
      {
        b.a("MicroMsg.Mix.AudioFixedConvertProcess", localException, "write", new Object[0]);
        return paramArrayOfByte;
      }
    }
    b.a("MicroMsg.Mix.AudioFixedConvertProcess", "desdata is null");
    return null;
  }
  
  public void b()
  {
    b.b("MicroMsg.Mix.AudioFixedConvertProcess", "finishProcess");
    try
    {
      if (this.s != null)
      {
        this.s.flush();
        this.s.close();
        this.s = null;
      }
    }
    catch (Exception localException)
    {
      b.a("MicroMsg.Mix.AudioFixedConvertProcess", localException, "finishProcess", new Object[0]);
    }
    Runtime.getRuntime().gc();
  }
  
  public void c()
  {
    b.b("MicroMsg.Mix.AudioFixedConvertProcess", "flushCache");
    if (this.t == null)
    {
      b.a("MicroMsg.Mix.AudioFixedConvertProcess", "flushCache, inputStream is null");
      return;
    }
    if (this.r.e())
    {
      b.a("MicroMsg.Mix.AudioFixedConvertProcess", "flushCache, cache is complete");
      return;
    }
    int i = 0;
    while (i != -1)
    {
      byte[] arrayOfByte = new byte[3536];
      int j;
      try
      {
        j = this.t.read(arrayOfByte, 0, 3536);
      }
      catch (Exception localException)
      {
        b.a("MicroMsg.Mix.AudioFixedConvertProcess", localException, "readPcmDataTrack", new Object[0]);
        j = i;
      }
      i = j;
      if (j > 0)
      {
        com.tencent.luggage.wxa.gm.e locale = com.tencent.luggage.wxa.gn.e.a().b();
        locale.f = arrayOfByte;
        this.r.a(locale);
        i = j;
      }
    }
    this.r.f();
  }
  
  public void d()
  {
    b.b("MicroMsg.Mix.AudioFixedConvertProcess", "release");
    super.d();
    try
    {
      if (this.s != null)
      {
        this.s.flush();
        this.s.close();
        this.s = null;
      }
    }
    catch (Exception localException1)
    {
      b.a("MicroMsg.Mix.AudioFixedConvertProcess", localException1, "outputStream close", new Object[0]);
    }
    try
    {
      if (this.t != null)
      {
        this.t.close();
        this.t = null;
        return;
      }
    }
    catch (Exception localException2)
    {
      b.a("MicroMsg.Mix.AudioFixedConvertProcess", localException2, "inputStream close", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gp.f
 * JD-Core Version:    0.7.0.1
 */