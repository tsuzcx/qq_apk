package com.tencent.luggage.wxa.if;

import android.text.TextUtils;
import java.nio.ByteBuffer;

public class b
{
  public boolean A = false;
  public boolean B = false;
  public ByteBuffer C;
  public String a = "";
  public String b = "";
  public String c = "";
  public int d = 0;
  public int e = 0;
  public int f = 0;
  public boolean g = false;
  public boolean h = false;
  public int i = 0;
  public long j = 0L;
  public String k = "";
  public double l = 1.0D;
  public double m = 1.0D;
  public String n = "";
  public long o = 0L;
  public long p = 0L;
  public long q = 0L;
  public long r = 0L;
  public long s = 0L;
  public long t = 0L;
  public long u = 0L;
  public String v = null;
  public String w = null;
  public long x = 0L;
  public e y;
  public boolean z = true;
  
  public boolean a(b paramb)
  {
    if (paramb == null) {
      return false;
    }
    String str = this.a;
    if ((str != null) && (str.equalsIgnoreCase(paramb.a)))
    {
      str = this.b;
      if ((str != null) && (str.equalsIgnoreCase(paramb.b))) {
        return true;
      }
    }
    return false;
  }
  
  public void b(b paramb)
  {
    this.a = paramb.a;
    this.b = paramb.b;
    if (!TextUtils.isEmpty(paramb.c)) {
      this.c = paramb.c;
    }
    this.d = paramb.d;
    this.e = paramb.e;
    this.g = paramb.g;
    this.h = paramb.h;
    this.i = paramb.i;
    this.k = paramb.k;
    this.l = paramb.l;
    this.n = paramb.n;
    e locale = paramb.y;
    if (locale != null) {
      this.y = locale;
    }
    this.x = paramb.x;
    this.m = paramb.m;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.if.b
 * JD-Core Version:    0.7.0.1
 */