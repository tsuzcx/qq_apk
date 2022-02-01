package com.tencent.magicbrush.handler.glfont;

import android.graphics.Rect;
import java.util.ArrayList;

class l
  implements d
{
  private ArrayList<d.b> a = new ArrayList();
  private d.a b = new d.a();
  private int c;
  private int d;
  private int e;
  private d.c f = new d.c();
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    d.b localb = (d.b)this.a.get(paramInt1);
    int i = localb.a;
    int j = localb.b;
    if (i + paramInt2 > this.d - 1) {
      return -1;
    }
    for (i = localb.b; paramInt2 > 0; i = j)
    {
      localb = (d.b)this.a.get(paramInt1);
      j = i;
      if (localb.b > i) {
        j = localb.b;
      }
      if (j + paramInt3 > this.e - 1) {
        return -1;
      }
      paramInt2 -= localb.c;
      paramInt1 += 1;
    }
    return i;
  }
  
  private d.c b(int paramInt1, int paramInt2)
  {
    d.c localc = this.f.a(0, 0, paramInt1, paramInt2);
    int i = 0;
    int j = -1;
    int n = 2147483647;
    int m;
    for (int k = 2147483647; i < this.a.size(); k = m)
    {
      int i4 = a(i, paramInt1, paramInt2);
      int i2 = j;
      int i1 = n;
      m = k;
      if (i4 >= 0)
      {
        localb1 = (d.b)this.a.get(i);
        int i3 = i4 + paramInt2;
        if (i3 >= n)
        {
          i2 = j;
          i1 = n;
          m = k;
          if (i3 == n)
          {
            i2 = j;
            i1 = n;
            m = k;
            if (localb1.c > 0)
            {
              i2 = j;
              i1 = n;
              m = k;
              if (localb1.c >= k) {}
            }
          }
        }
        else
        {
          m = localb1.c;
          localc.a = localb1.a;
          localc.b = i4;
          i1 = i3;
          i2 = i;
        }
      }
      i += 1;
      j = i2;
      n = i1;
    }
    if (j == -1)
    {
      localc.a = -1;
      localc.b = -1;
      localc.c = 0;
      localc.d = 0;
      return localc;
    }
    d.b localb1 = this.b.a();
    localb1.a = localc.a;
    localb1.b = (localc.b + paramInt2);
    localb1.c = paramInt1;
    this.a.add(j, localb1);
    for (;;)
    {
      i = j + 1;
      if (i >= this.a.size()) {
        break;
      }
      localb1 = (d.b)this.a.get(i);
      d.b localb2 = (d.b)this.a.get(i - 1);
      if (localb1.a >= localb2.a + localb2.c) {
        break;
      }
      j = localb2.a + localb2.c - localb1.a;
      localb1.a += j;
      localb1.c -= j;
      if (localb1.c > 0) {
        break;
      }
      localb1 = (d.b)this.a.remove(i);
      this.b.a(localb1);
      j = i - 1;
    }
    b();
    this.c += paramInt1 * paramInt2;
    return localc;
  }
  
  private void b()
  {
    int j;
    for (int i = 0; i < this.a.size() - 1; i = j + 1)
    {
      d.b localb = (d.b)this.a.get(i);
      Object localObject = this.a;
      int k = i + 1;
      localObject = (d.b)((ArrayList)localObject).get(k);
      j = i;
      if (localb.b == ((d.b)localObject).b)
      {
        localb.c += ((d.b)localObject).c;
        localb = (d.b)this.a.remove(k);
        this.b.a(localb);
        j = i - 1;
      }
    }
  }
  
  public void a()
  {
    this.c = 0;
    this.b.a(this.a);
    d.b localb = this.b.a();
    localb.a(1, 1, this.d - 2);
    this.a.add(localb);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.d = paramInt1;
    this.e = paramInt2;
    a();
  }
  
  public void a(int paramInt1, int paramInt2, Rect paramRect)
  {
    if (paramRect == null) {
      return;
    }
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      d.c localc = b(paramInt1, paramInt2);
      if ((localc.a >= 0) && (localc.b >= 0))
      {
        paramRect.set(localc.a, localc.b, localc.a + paramInt1 - 1, localc.b + paramInt2 - 1);
        return;
      }
      paramRect.setEmpty();
      return;
    }
    paramRect.setEmpty();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.l
 * JD-Core Version:    0.7.0.1
 */