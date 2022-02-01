package com.tencent.luggage.wxa.r;

import com.tencent.luggage.wxa.ao.k.a;
import com.tencent.luggage.wxa.ao.k.b;
import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.l.f;
import com.tencent.luggage.wxa.l.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class j
  implements h
{
  private final s a;
  private final boolean b;
  private final boolean c;
  private final n d;
  private final n e;
  private final n f;
  private long g;
  private final boolean[] h;
  private String i;
  private l j;
  private j.a k;
  private boolean l;
  private long m;
  private final m n;
  
  public j(s params, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = params;
    this.b = paramBoolean1;
    this.c = paramBoolean2;
    this.h = new boolean[3];
    this.d = new n(7, 128);
    this.e = new n(8, 128);
    this.f = new n(6, 128);
    this.n = new m();
  }
  
  private void a(long paramLong1, int paramInt1, int paramInt2, long paramLong2)
  {
    if ((!this.l) || (this.k.a()))
    {
      this.d.b(paramInt2);
      this.e.b(paramInt2);
      Object localObject;
      if (!this.l)
      {
        if ((this.d.b()) && (this.e.b()))
        {
          localObject = new ArrayList();
          ((List)localObject).add(Arrays.copyOf(this.d.a, this.d.b));
          ((List)localObject).add(Arrays.copyOf(this.e.a, this.e.b));
          k.b localb = com.tencent.luggage.wxa.ao.k.a(this.d.a, 3, this.d.b);
          k.a locala = com.tencent.luggage.wxa.ao.k.b(this.e.a, 3, this.e.b);
          this.j.a(com.tencent.luggage.wxa.h.k.a(this.i, "video/avc", null, -1, -1, localb.b, localb.c, -1.0F, (List)localObject, -1, localb.d, null));
          this.l = true;
          this.k.a(localb);
          this.k.a(locala);
          this.d.a();
          this.e.a();
        }
      }
      else if (this.d.b())
      {
        localObject = com.tencent.luggage.wxa.ao.k.a(this.d.a, 3, this.d.b);
        this.k.a((k.b)localObject);
        this.d.a();
      }
      else if (this.e.b())
      {
        localObject = com.tencent.luggage.wxa.ao.k.b(this.e.a, 3, this.e.b);
        this.k.a((k.a)localObject);
        this.e.a();
      }
    }
    if (this.f.b(paramInt2))
    {
      paramInt2 = com.tencent.luggage.wxa.ao.k.a(this.f.a, this.f.b);
      this.n.a(this.f.a, paramInt2);
      this.n.c(4);
      this.a.a(paramLong2, this.n);
    }
    this.k.a(paramLong1, paramInt1);
  }
  
  private void a(long paramLong1, int paramInt, long paramLong2)
  {
    if ((!this.l) || (this.k.a()))
    {
      this.d.a(paramInt);
      this.e.a(paramInt);
    }
    this.f.a(paramInt);
    this.k.a(paramLong1, paramInt, paramLong2);
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((!this.l) || (this.k.a()))
    {
      this.d.a(paramArrayOfByte, paramInt1, paramInt2);
      this.e.a(paramArrayOfByte, paramInt1, paramInt2);
    }
    this.f.a(paramArrayOfByte, paramInt1, paramInt2);
    this.k.a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void a()
  {
    com.tencent.luggage.wxa.ao.k.a(this.h);
    this.d.a();
    this.e.a();
    this.f.a();
    this.k.b();
    this.g = 0L;
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    this.m = paramLong;
  }
  
  public void a(m paramm)
  {
    int i1 = paramm.d();
    int i2 = paramm.c();
    byte[] arrayOfByte = paramm.a;
    this.g += paramm.b();
    this.j.a(paramm, paramm.b());
    for (;;)
    {
      int i3 = com.tencent.luggage.wxa.ao.k.a(arrayOfByte, i1, i2, this.h);
      if (i3 == i2)
      {
        a(arrayOfByte, i1, i2);
        return;
      }
      int i4 = com.tencent.luggage.wxa.ao.k.b(arrayOfByte, i3);
      int i6 = i3 - i1;
      if (i6 > 0) {
        a(arrayOfByte, i1, i3);
      }
      int i5 = i2 - i3;
      long l1 = this.g - i5;
      if (i6 < 0) {
        i1 = -i6;
      } else {
        i1 = 0;
      }
      a(l1, i5, i1, this.m);
      a(l1, i4, this.m);
      i1 = i3 + 3;
    }
  }
  
  public void a(f paramf, v.d paramd)
  {
    paramd.a();
    this.i = paramd.c();
    this.j = paramf.a(paramd.b(), 2);
    this.k = new j.a(this.j, this.b, this.c);
    this.a.a(paramf, paramd);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.r.j
 * JD-Core Version:    0.7.0.1
 */