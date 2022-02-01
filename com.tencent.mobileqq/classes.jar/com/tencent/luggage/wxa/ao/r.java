package com.tencent.luggage.wxa.ao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class r
{
  private static final Comparator<r.a> a = new r.1();
  private static final Comparator<r.a> b = new r.2();
  private final int c;
  private final ArrayList<r.a> d;
  private final r.a[] e;
  private int f;
  private int g;
  private int h;
  private int i;
  
  public r(int paramInt)
  {
    this.c = paramInt;
    this.e = new r.a[5];
    this.d = new ArrayList();
    this.f = -1;
  }
  
  private void a()
  {
    if (this.f != 1)
    {
      Collections.sort(this.d, a);
      this.f = 1;
    }
  }
  
  private void b()
  {
    if (this.f != 0)
    {
      Collections.sort(this.d, b);
      this.f = 0;
    }
  }
  
  public float a(float paramFloat)
  {
    b();
    float f1 = this.h;
    int j = 0;
    int k = 0;
    while (j < this.d.size())
    {
      localObject = (r.a)this.d.get(j);
      k += ((r.a)localObject).b;
      if (k >= paramFloat * f1) {
        return ((r.a)localObject).c;
      }
      j += 1;
    }
    if (this.d.isEmpty()) {
      return (0.0F / 0.0F);
    }
    Object localObject = this.d;
    return ((r.a)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1)).c;
  }
  
  public void a(int paramInt, float paramFloat)
  {
    a();
    int j = this.i;
    Object localObject;
    if (j > 0)
    {
      localObject = this.e;
      j -= 1;
      this.i = j;
      localObject = localObject[j];
    }
    else
    {
      localObject = new r.a(null);
    }
    j = this.g;
    this.g = (j + 1);
    ((r.a)localObject).a = j;
    ((r.a)localObject).b = paramInt;
    ((r.a)localObject).c = paramFloat;
    this.d.add(localObject);
    this.h += paramInt;
    for (;;)
    {
      paramInt = this.h;
      j = this.c;
      if (paramInt <= j) {
        break;
      }
      paramInt -= j;
      localObject = (r.a)this.d.get(0);
      if (((r.a)localObject).b <= paramInt)
      {
        this.h -= ((r.a)localObject).b;
        this.d.remove(0);
        paramInt = this.i;
        if (paramInt < 5)
        {
          r.a[] arrayOfa = this.e;
          this.i = (paramInt + 1);
          arrayOfa[paramInt] = localObject;
        }
      }
      else
      {
        ((r.a)localObject).b -= paramInt;
        this.h -= paramInt;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ao.r
 * JD-Core Version:    0.7.0.1
 */