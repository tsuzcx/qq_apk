package com.tencent.luggage.wxa.nt;

import com.tencent.luggage.wxa.ns.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rt.k;
import com.tencent.mm.plugin.appbrand.media.encode.Mp3EncodeJni;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

public class e
  extends c
{
  private String a = "";
  private byte[] b;
  private OutputStream j;
  private int k = 2;
  
  public void a()
  {
    o.d("MicroMsg.Record.MP3AudioEncoder", "flush");
    if (this.j != null)
    {
      byte[] arrayOfByte = this.b;
      if (arrayOfByte != null)
      {
        int i = Mp3EncodeJni.flush(arrayOfByte);
        if (i > 0) {
          try
          {
            this.j.write(this.b, 0, i);
            a(this.b, i, true);
            return;
          }
          catch (IOException localIOException)
          {
            o.a("MicroMsg.Record.MP3AudioEncoder", localIOException, "flush write", new Object[0]);
            com.tencent.luggage.wxa.ns.c.a(20);
            return;
          }
        }
        o.b("MicroMsg.Record.MP3AudioEncoder", "flush fail, flushResult:%d", new Object[] { Integer.valueOf(i) });
        return;
      }
    }
    o.b("MicroMsg.Record.MP3AudioEncoder", "flush, mFileOutputStream or mMp3Buffer is null");
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    o.d("MicroMsg.Record.MP3AudioEncoder", "init, filePath:%s, sampleRate:%d, channelCount:%d, bitRate:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.a = paramString;
    this.k = paramInt2;
    paramInt1 = Mp3EncodeJni.init(paramInt1, paramInt2, paramInt1, paramInt3 / 1000, 5);
    o.d("MicroMsg.Record.MP3AudioEncoder", "Mp3EncodeJni.init ret :%d", new Object[] { Integer.valueOf(paramInt1) });
    if (paramInt1 == -1)
    {
      com.tencent.luggage.wxa.ns.c.a(17);
      return false;
    }
    o.d("MicroMsg.Record.MP3AudioEncoder", "lame MPEG version:%d", new Object[] { Integer.valueOf(Mp3EncodeJni.getVersion()) });
    try
    {
      this.j = k.b(paramString);
      return true;
    }
    catch (FileNotFoundException paramString)
    {
      o.a("MicroMsg.Record.MP3AudioEncoder", paramString, "init", new Object[0]);
      com.tencent.luggage.wxa.ns.c.a(18);
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt)
  {
    if (this.f <= 0)
    {
      o.b("MicroMsg.Record.MP3AudioEncoder", "mMinBufferSize %d is invalid", new Object[] { Integer.valueOf(this.f) });
      return false;
    }
    if (this.j == null)
    {
      o.b("MicroMsg.Record.MP3AudioEncoder", "mFileOutputStream is null");
      return false;
    }
    if (this.b == null)
    {
      int m = this.f;
      i = this.k;
      double d = m * i;
      Double.isNaN(d);
      m = (int)(d * 1.25D + 7200.0D);
      o.d("MicroMsg.Record.MP3AudioEncoder", "channelCnt:%d, mMinBufferSize:%d, size:%d, ", new Object[] { Integer.valueOf(i), Integer.valueOf(this.f), Integer.valueOf(m) });
      this.b = new byte[m];
    }
    paramArrayOfByte = a.a(paramArrayOfByte, paramInt);
    int i = Mp3EncodeJni.encode(paramArrayOfByte, paramArrayOfByte, paramInt / 2, this.b);
    o.e("MicroMsg.Record.MP3AudioEncoder", "len:%d, shorts.len:%d, encodedSize:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(i) });
    if (i > 0)
    {
      o.e("MicroMsg.Record.MP3AudioEncoder", "encodeSize:%d, len:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      try
      {
        this.j.write(this.b, 0, i);
        a(this.b, i, false);
        return true;
      }
      catch (IOException paramArrayOfByte)
      {
        o.a("MicroMsg.Record.MP3AudioEncoder", paramArrayOfByte, "encode write", new Object[0]);
        com.tencent.luggage.wxa.ns.c.a(20);
      }
    }
    else
    {
      o.b("MicroMsg.Record.MP3AudioEncoder", "Mp3EncodeJni encode fail, encodedSize:%d", new Object[] { Integer.valueOf(i) });
    }
    return false;
  }
  
  public void b()
  {
    o.d("MicroMsg.Record.MP3AudioEncoder", "close");
    Mp3EncodeJni.close();
    OutputStream localOutputStream = this.j;
    if (localOutputStream != null)
    {
      try
      {
        localOutputStream.close();
      }
      catch (IOException localIOException)
      {
        o.a("MicroMsg.Record.MP3AudioEncoder", localIOException, "close", new Object[0]);
        com.tencent.luggage.wxa.ns.c.a(20);
      }
      this.j = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nt.e
 * JD-Core Version:    0.7.0.1
 */