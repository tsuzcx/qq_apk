package com.tencent.luggage.wxa.r;

import android.util.SparseArray;
import com.tencent.luggage.wxa.ao.u;
import com.tencent.luggage.wxa.l.d;
import com.tencent.luggage.wxa.l.e;
import com.tencent.luggage.wxa.l.f;
import com.tencent.luggage.wxa.l.g;
import com.tencent.luggage.wxa.l.j;
import com.tencent.luggage.wxa.l.k.a;

public final class p
  implements d
{
  public static final g a = new p.1();
  private final u b;
  private final SparseArray<p.a> c;
  private final com.tencent.luggage.wxa.ao.m d;
  private boolean e;
  private boolean f;
  private boolean g;
  private f h;
  
  public p()
  {
    this(new u(0L));
  }
  
  public p(u paramu)
  {
    this.b = paramu;
    this.d = new com.tencent.luggage.wxa.ao.m(4096);
    this.c = new SparseArray();
  }
  
  public int a(e parame, j paramj)
  {
    if (!parame.b(this.d.a, 0, 4, true)) {
      return -1;
    }
    this.d.c(0);
    int i = this.d.n();
    if (i == 441) {
      return -1;
    }
    if (i == 442)
    {
      parame.c(this.d.a, 0, 10);
      this.d.c(9);
      parame.b((this.d.g() & 0x7) + 14);
      return 0;
    }
    if (i == 443)
    {
      parame.c(this.d.a, 0, 2);
      this.d.c(0);
      parame.b(this.d.h() + 6);
      return 0;
    }
    if ((i & 0xFFFFFF00) >> 8 != 1)
    {
      parame.b(1);
      return 0;
    }
    i &= 0xFF;
    p.a locala = (p.a)this.c.get(i);
    paramj = locala;
    if (!this.e)
    {
      Object localObject = locala;
      if (locala == null)
      {
        localObject = null;
        if ((!this.f) && (i == 189))
        {
          paramj = new b();
          this.f = true;
        }
        else if ((!this.f) && ((i & 0xE0) == 192))
        {
          paramj = new m();
          this.f = true;
        }
        else
        {
          paramj = (j)localObject;
          if (!this.g)
          {
            paramj = (j)localObject;
            if ((i & 0xF0) == 224)
            {
              paramj = new i();
              this.g = true;
            }
          }
        }
        localObject = locala;
        if (paramj != null)
        {
          localObject = new v.d(i, 256);
          paramj.a(this.h, (v.d)localObject);
          localObject = new p.a(paramj, this.b);
          this.c.put(i, localObject);
        }
      }
      if ((!this.f) || (!this.g))
      {
        paramj = (j)localObject;
        if (parame.c() <= 1048576L) {}
      }
      else
      {
        this.e = true;
        this.h.a();
        paramj = (j)localObject;
      }
    }
    parame.c(this.d.a, 0, 2);
    this.d.c(0);
    i = this.d.h() + 6;
    if (paramj == null)
    {
      parame.b(i);
      return 0;
    }
    this.d.a(i);
    parame.b(this.d.a, 0, i);
    this.d.c(6);
    paramj.a(this.d);
    parame = this.d;
    parame.b(parame.e());
    return 0;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.b.d();
    int i = 0;
    while (i < this.c.size())
    {
      ((p.a)this.c.valueAt(i)).a();
      i += 1;
    }
  }
  
  public void a(f paramf)
  {
    this.h = paramf;
    paramf.a(new k.a(-9223372036854775807L));
  }
  
  public boolean a(e parame)
  {
    byte[] arrayOfByte = new byte[14];
    boolean bool = false;
    parame.c(arrayOfByte, 0, 14);
    if (442 != ((arrayOfByte[0] & 0xFF) << 24 | (arrayOfByte[1] & 0xFF) << 16 | (arrayOfByte[2] & 0xFF) << 8 | arrayOfByte[3] & 0xFF)) {
      return false;
    }
    if ((arrayOfByte[4] & 0xC4) != 68) {
      return false;
    }
    if ((arrayOfByte[6] & 0x4) != 4) {
      return false;
    }
    if ((arrayOfByte[8] & 0x4) != 4) {
      return false;
    }
    if ((arrayOfByte[9] & 0x1) != 1) {
      return false;
    }
    if ((arrayOfByte[12] & 0x3) != 3) {
      return false;
    }
    parame.c(arrayOfByte[13] & 0x7);
    parame.c(arrayOfByte, 0, 3);
    if (1 == ((arrayOfByte[0] & 0xFF) << 16 | (arrayOfByte[1] & 0xFF) << 8 | arrayOfByte[2] & 0xFF)) {
      bool = true;
    }
    return bool;
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.r.p
 * JD-Core Version:    0.7.0.1
 */