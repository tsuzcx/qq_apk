package com.tencent.luggage.wxa.a;

import java.util.ArrayList;
import java.util.List;

class i$a
  implements h.x
{
  private List<i.b> b = new ArrayList();
  private float c;
  private float d;
  private i.b e = null;
  private boolean f = false;
  private boolean g = true;
  private int h = -1;
  private boolean i;
  
  i$a(i parami, h.w paramw)
  {
    if (paramw == null) {
      return;
    }
    paramw.a(this);
    if (this.i)
    {
      this.e.a((i.b)this.b.get(this.h));
      this.b.set(this.h, this.e);
      this.i = false;
    }
    parami = this.e;
    if (parami != null) {
      this.b.add(parami);
    }
  }
  
  List<i.b> a()
  {
    return this.b;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (this.i)
    {
      this.e.a((i.b)this.b.get(this.h));
      this.b.set(this.h, this.e);
      this.i = false;
    }
    i.b localb = this.e;
    if (localb != null) {
      this.b.add(localb);
    }
    this.c = paramFloat1;
    this.d = paramFloat2;
    this.e = new i.b(this.a, paramFloat1, paramFloat2, 0.0F, 0.0F);
    this.h = this.b.size();
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.e.a(paramFloat1, paramFloat2);
    this.b.add(this.e);
    this.e = new i.b(this.a, paramFloat3, paramFloat4, paramFloat3 - paramFloat1, paramFloat4 - paramFloat2);
    this.i = false;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    if ((this.g) || (this.f))
    {
      this.e.a(paramFloat1, paramFloat2);
      this.b.add(this.e);
      this.f = false;
    }
    this.e = new i.b(this.a, paramFloat5, paramFloat6, paramFloat5 - paramFloat3, paramFloat6 - paramFloat4);
    this.i = false;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean1, boolean paramBoolean2, float paramFloat4, float paramFloat5)
  {
    this.f = true;
    this.g = false;
    i.a(this.e.a, this.e.b, paramFloat1, paramFloat2, paramFloat3, paramBoolean1, paramBoolean2, paramFloat4, paramFloat5, this);
    this.g = true;
    this.i = false;
  }
  
  public void b()
  {
    this.b.add(this.e);
    b(this.c, this.d);
    this.i = true;
  }
  
  public void b(float paramFloat1, float paramFloat2)
  {
    this.e.a(paramFloat1, paramFloat2);
    this.b.add(this.e);
    this.e = new i.b(this.a, paramFloat1, paramFloat2, paramFloat1 - this.e.a, paramFloat2 - this.e.b);
    this.i = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.a.i.a
 * JD-Core Version:    0.7.0.1
 */