package com.tencent.beacon.b.a;

import com.tencent.beacon.e.a;
import com.tencent.beacon.e.b;

public final class c
  extends com.tencent.beacon.e.c
{
  private static byte[] j;
  public byte a = 0;
  public int b = 0;
  public byte[] c = null;
  public String d = "";
  public long e = 0L;
  public String f = "";
  private byte g = 0;
  private byte h = 0;
  private String i = "";
  
  public final void a(a parama)
  {
    this.a = parama.a(this.a, 0, true);
    this.b = parama.a(this.b, 1, true);
    if (j == null)
    {
      arrayOfByte = new byte[1];
      j = arrayOfByte;
      arrayOfByte[0] = 0;
    }
    byte[] arrayOfByte = j;
    this.c = parama.c(2, true);
    this.d = parama.b(3, true);
    this.g = parama.a(this.g, 4, true);
    this.h = parama.a(this.h, 5, true);
    this.e = parama.a(this.e, 6, true);
    this.f = parama.b(7, false);
    this.i = parama.b(8, false);
  }
  
  public final void a(b paramb)
  {
    paramb.a(this.a, 0);
    paramb.a(this.b, 1);
    paramb.a(this.c, 2);
    paramb.a(this.d, 3);
    paramb.a(this.g, 4);
    paramb.a(this.h, 5);
    paramb.a(this.e, 6);
    if (this.f != null) {
      paramb.a(this.f, 7);
    }
    if (this.i != null) {
      paramb.a(this.i, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.b.a.c
 * JD-Core Version:    0.7.0.1
 */