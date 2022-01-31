package com.tencent.beacon.b.d;

import com.tencent.beacon.e.a;
import com.tencent.beacon.e.c;

public final class b
  extends c
  implements Cloneable
{
  private static byte[] n;
  public String a = "";
  public String b = "";
  public String c = "";
  public int d = 0;
  public long e = 0L;
  public long f = 0L;
  public String g = "";
  private long h = 0L;
  private long i = 0L;
  private long j = 0L;
  private int k = 0;
  private int l = 0;
  private byte[] m = null;
  
  public final void a(a parama)
  {
    this.a = parama.b(0, true);
    this.b = parama.b(1, true);
    this.c = parama.b(2, true);
    this.d = parama.a(this.d, 3, true);
    this.e = parama.a(this.e, 4, true);
    this.f = parama.a(this.f, 5, true);
    this.h = parama.a(this.h, 6, false);
    this.i = parama.a(this.i, 7, false);
    this.j = parama.a(this.j, 8, false);
    this.k = parama.a(this.k, 9, false);
    this.l = parama.a(this.l, 10, false);
    if (n == null)
    {
      arrayOfByte = new byte[1];
      n = arrayOfByte;
      arrayOfByte[0] = 0;
    }
    byte[] arrayOfByte = n;
    this.m = parama.c(11, false);
    this.g = parama.b(12, false);
  }
  
  public final void a(com.tencent.beacon.e.b paramb)
  {
    paramb.a(this.a, 0);
    paramb.a(this.b, 1);
    paramb.a(this.c, 2);
    paramb.a(this.d, 3);
    paramb.a(this.e, 4);
    paramb.a(this.f, 5);
    paramb.a(this.h, 6);
    paramb.a(this.i, 7);
    paramb.a(this.j, 8);
    paramb.a(this.k, 9);
    paramb.a(this.l, 10);
    if (this.m != null) {
      paramb.a(this.m, 11);
    }
    if (this.g != null) {
      paramb.a(this.g, 12);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.b.d.b
 * JD-Core Version:    0.7.0.1
 */