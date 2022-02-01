package com.tencent.luggage.wxa.am;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.ao.a;
import java.io.InputStream;

public final class i
  extends InputStream
{
  private final g a;
  private final j b;
  private final byte[] c;
  private boolean d = false;
  private boolean e = false;
  private long f;
  
  public i(g paramg, j paramj)
  {
    this.a = paramg;
    this.b = paramj;
    this.c = new byte[1];
  }
  
  private void c()
  {
    if (!this.d)
    {
      this.a.a(this.b);
      this.d = true;
    }
  }
  
  public long a()
  {
    return this.f;
  }
  
  public void b()
  {
    c();
  }
  
  public void close()
  {
    if (!this.e)
    {
      this.a.a();
      this.e = true;
    }
  }
  
  public int read()
  {
    if (read(this.c) == -1) {
      return -1;
    }
    return this.c[0] & 0xFF;
  }
  
  public int read(@NonNull byte[] paramArrayOfByte)
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    a.b(this.e ^ true);
    c();
    paramInt1 = this.a.a(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 == -1) {
      return -1;
    }
    this.f += paramInt1;
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.am.i
 * JD-Core Version:    0.7.0.1
 */