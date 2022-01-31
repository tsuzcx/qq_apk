package com.tencent.beacon.a.d.a;

import com.tencent.beacon.a.h.a;
import com.tencent.beacon.a.h.b;

public final class c
  extends com.tencent.beacon.a.h.c
{
  private static byte[] j;
  public byte a = 0;
  public int b = 0;
  public byte[] c = null;
  public String d = "";
  public long e = 0L;
  private byte f = 0;
  private byte g = 0;
  private String h = "";
  private String i = "";
  
  public final void a(a parama)
  {
    this.a = parama.a(this.a, 0, true);
    this.b = parama.a(this.b, 1, true);
    if (j == null)
    {
      byte[] arrayOfByte = (byte[])new byte[1];
      j = arrayOfByte;
      ((byte[])arrayOfByte)[0] = 0;
    }
    this.c = ((byte[])parama.c(2, true));
    this.d = parama.b(3, true);
    this.f = parama.a(this.f, 4, true);
    this.g = parama.a(this.g, 5, true);
    this.e = parama.a(this.e, 6, true);
    this.h = parama.b(7, false);
    this.i = parama.b(8, false);
  }
  
  public final void a(b paramb)
  {
    paramb.a(this.a, 0);
    paramb.a(this.b, 1);
    paramb.a(this.c, 2);
    paramb.a(this.d, 3);
    paramb.a(this.f, 4);
    paramb.a(this.g, 5);
    paramb.a(this.e, 6);
    if (this.h != null) {
      paramb.a(this.h, 7);
    }
    if (this.i != null) {
      paramb.a(this.i, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.d.a.c
 * JD-Core Version:    0.7.0.1
 */