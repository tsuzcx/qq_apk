package com.tencent.luggage.wxa.q;

import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.h.p;
import java.util.ArrayList;

final class j
  extends h
{
  private j.a a;
  private int b;
  private boolean c;
  private k.d d;
  private k.b e;
  
  static int a(byte paramByte, int paramInt1, int paramInt2)
  {
    return paramByte >> paramInt2 & 255 >>> 8 - paramInt1;
  }
  
  private static int a(byte paramByte, j.a parama)
  {
    int i = a(paramByte, parama.e, 1);
    if (!parama.d[i].a) {
      return parama.a.g;
    }
    return parama.a.h;
  }
  
  static void a(m paramm, long paramLong)
  {
    paramm.b(paramm.c() + 4);
    paramm.a[(paramm.c() - 4)] = ((byte)(int)(paramLong & 0xFF));
    paramm.a[(paramm.c() - 3)] = ((byte)(int)(paramLong >>> 8 & 0xFF));
    paramm.a[(paramm.c() - 2)] = ((byte)(int)(paramLong >>> 16 & 0xFF));
    paramm.a[(paramm.c() - 1)] = ((byte)(int)(paramLong >>> 24 & 0xFF));
  }
  
  public static boolean a(m paramm)
  {
    try
    {
      boolean bool = k.a(1, paramm, true);
      return bool;
    }
    catch (p paramm)
    {
      label9:
      break label9;
    }
    return false;
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (paramBoolean)
    {
      this.a = null;
      this.d = null;
      this.e = null;
    }
    this.b = 0;
    this.c = false;
  }
  
  protected boolean a(m paramm, long paramLong, h.a parama)
  {
    if (this.a != null) {
      return false;
    }
    this.a = c(paramm);
    if (this.a == null) {
      return true;
    }
    paramm = new ArrayList();
    paramm.add(this.a.a.j);
    paramm.add(this.a.c);
    parama.a = com.tencent.luggage.wxa.h.k.a(null, "audio/vorbis", null, this.a.a.e, -1, this.a.a.b, (int)this.a.a.c, paramm, null, 0, null);
    return true;
  }
  
  protected long b(m paramm)
  {
    byte[] arrayOfByte = paramm.a;
    int i = 0;
    if ((arrayOfByte[0] & 0x1) == 1) {
      return -1L;
    }
    int j = a(paramm.a[0], this.a);
    if (this.c) {
      i = (this.b + j) / 4;
    }
    long l = i;
    a(paramm, l);
    this.c = true;
    this.b = j;
    return l;
  }
  
  j.a c(m paramm)
  {
    if (this.d == null)
    {
      this.d = k.a(paramm);
      return null;
    }
    if (this.e == null)
    {
      this.e = k.b(paramm);
      return null;
    }
    byte[] arrayOfByte = new byte[paramm.c()];
    System.arraycopy(paramm.a, 0, arrayOfByte, 0, paramm.c());
    paramm = k.a(paramm, this.d.b);
    int i = k.a(paramm.length - 1);
    return new j.a(this.d, this.e, arrayOfByte, paramm, i);
  }
  
  protected void c(long paramLong)
  {
    super.c(paramLong);
    int i = 0;
    boolean bool;
    if (paramLong != 0L) {
      bool = true;
    } else {
      bool = false;
    }
    this.c = bool;
    k.d locald = this.d;
    if (locald != null) {
      i = locald.g;
    }
    this.b = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.q.j
 * JD-Core Version:    0.7.0.1
 */