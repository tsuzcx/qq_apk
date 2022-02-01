package com.tencent.luggage.wxa.nt;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.qz.o;

public class c
  implements d
{
  String c = "audio/mp4a-latm";
  String d = "audio/mpeg";
  d.a e = null;
  int f = 0;
  int g = 0;
  byte[] h;
  int i = 0;
  
  public void a() {}
  
  public void a(double paramDouble)
  {
    this.g = ((int)(1024.0D * paramDouble));
    o.d("MicroMsg.Record.AudioEncoder", "setEncodeBuffFrameSize frameKbSize:%b frameByteSize:%d", new Object[] { Double.valueOf(paramDouble), Integer.valueOf(this.g) });
    this.h = new byte[this.g];
  }
  
  public void a(int paramInt)
  {
    o.d("MicroMsg.Record.AudioEncoder", "mMinBufferSize:%d", new Object[] { Integer.valueOf(this.f) });
    this.f = paramInt;
  }
  
  public void a(d.a parama)
  {
    this.e = parama;
  }
  
  public void a(@NonNull byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    if (this.e == null)
    {
      o.b("MicroMsg.Record.AudioEncoder", "mEncodeListener is null, return");
      return;
    }
    int j = this.g;
    if (j == 0.0D) {
      return;
    }
    if (paramInt > j) {
      o.c("MicroMsg.Record.AudioEncoder", "buffSize:%d frameSize:%d, buffSize > frameSize ", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.g) });
    }
    o.e("MicroMsg.Record.AudioEncoder", "bufferedSize:%d, buffSize:%d", new Object[] { Integer.valueOf(this.i), Integer.valueOf(paramInt) });
    j = this.i + paramInt;
    if ((j >= this.g) && (paramArrayOfByte != null))
    {
      o.e("MicroMsg.Record.AudioEncoder", "flush all, currentBufferedSize:%d", new Object[] { Integer.valueOf(j) });
      if (j > this.h.length)
      {
        o.d("MicroMsg.Record.AudioEncoder", "expand the end codeBuffer:%d", new Object[] { Integer.valueOf(j) });
        byte[] arrayOfByte = this.h;
        this.h = new byte[j];
        System.arraycopy(arrayOfByte, 0, this.h, 0, this.i);
      }
      System.arraycopy(paramArrayOfByte, 0, this.h, this.i, paramInt);
      this.e.a(this.h, j, false);
      this.i = 0;
    }
    else if (paramArrayOfByte != null)
    {
      System.arraycopy(paramArrayOfByte, 0, this.h, this.i, paramInt);
      this.i = j;
      o.e("MicroMsg.Record.AudioEncoder", "append buff, currentBufferedSize:%d", new Object[] { Integer.valueOf(this.i) });
    }
    if (paramBoolean)
    {
      o.d("MicroMsg.Record.AudioEncoder", "isEnd is true, flush the buffer, bufferedSize:%d", new Object[] { Integer.valueOf(this.i) });
      this.e.a(this.h, this.i, paramBoolean);
      this.i = 0;
    }
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    return false;
  }
  
  public boolean a(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt)
  {
    return false;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nt.c
 * JD-Core Version:    0.7.0.1
 */