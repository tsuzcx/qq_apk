package com.tencent.luggage.wxa.nt;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rt.i;
import com.tencent.luggage.wxa.rt.k;
import java.io.IOException;
import java.io.RandomAccessFile;

public class g
  extends f
{
  private int b;
  private int j;
  
  private byte[] a(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, byte paramByte)
  {
    return new byte[] { 82, 73, 70, 70, (byte)(int)(paramLong2 & 0xFF), (byte)(int)(paramLong2 >> 8 & 0xFF), (byte)(int)(paramLong2 >> 16 & 0xFF), (byte)(int)(paramLong2 >> 24 & 0xFF), 87, 65, 86, 69, 102, 109, 116, 32, 16, 0, 0, 0, 1, 0, (byte)paramInt, 0, (byte)(int)(paramLong3 & 0xFF), (byte)(int)(paramLong3 >> 8 & 0xFF), (byte)(int)(paramLong3 >> 16 & 0xFF), (byte)(int)(paramLong3 >> 24 & 0xFF), (byte)(int)(paramLong4 & 0xFF), (byte)(int)(paramLong4 >> 8 & 0xFF), (byte)(int)(paramLong4 >> 16 & 0xFF), (byte)(int)(paramLong4 >> 24 & 0xFF), (byte)(paramInt * (paramByte / 8)), 0, paramByte, 0, 100, 97, 116, 97, (byte)(int)(paramLong1 & 0xFF), (byte)(int)(paramLong1 >> 8 & 0xFF), (byte)(int)(paramLong1 >> 16 & 0xFF), (byte)(int)(paramLong1 >> 24 & 0xFF) };
  }
  
  private void c()
  {
    RandomAccessFile localRandomAccessFile = k.b(this.a.l(), true);
    localRandomAccessFile.seek(0L);
    localRandomAccessFile.write(a(this.b, this.j, this.a.q()));
    localRandomAccessFile.close();
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.b = paramInt1;
    this.j = paramInt2;
    return super.a(paramString, paramInt1, paramInt2, paramInt3);
  }
  
  public byte[] a(int paramInt1, int paramInt2, long paramLong)
  {
    return a(paramLong, paramLong + 36L, paramInt1, paramInt2, paramInt1 * 16 * paramInt2 / 8, (byte)16);
  }
  
  public void b()
  {
    super.b();
    try
    {
      c();
      return;
    }
    catch (IOException localIOException)
    {
      o.h("Luggage.PCMAudioEncoder", "", new Object[] { localIOException });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nt.g
 * JD-Core Version:    0.7.0.1
 */