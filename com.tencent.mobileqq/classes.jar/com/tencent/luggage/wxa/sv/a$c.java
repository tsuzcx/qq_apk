package com.tencent.luggage.wxa.sv;

import android.graphics.drawable.Drawable;
import android.view.View;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class a$c
  extends c.a
{
  private boolean b;
  
  private a$c(a parama) {}
  
  public int a(View paramView)
  {
    return a.a(this.a) & 0x3;
  }
  
  public int a(View paramView, int paramInt1, int paramInt2)
  {
    int i = a.d(this.a);
    paramInt2 = 0;
    if ((i & 0x1) != 0) {
      return Math.min(paramView.getWidth(), Math.max(paramInt1, 0));
    }
    if ((a.d(this.a) & 0x2) != 0) {
      paramInt2 = Math.min(0, Math.max(paramInt1, -paramView.getWidth()));
    }
    return paramInt2;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if ((a.c(this.a) != null) && (!a.c(this.a).isEmpty()))
    {
      Iterator localIterator = a.c(this.a).iterator();
      while (localIterator.hasNext()) {
        ((a.a)localIterator.next()).a(paramInt, a.j(this.a));
      }
    }
  }
  
  public void a(View paramView, float paramFloat1, float paramFloat2)
  {
    int i = paramView.getWidth();
    int j = paramView.getHeight();
    if ((a.d(this.a) & 0x1) != 0)
    {
      if ((paramFloat1 <= 0.0F) && ((paramFloat1 != 0.0F) || (a.j(this.a) <= a.k(this.a)))) {
        i = 0;
      } else {
        i = i + a.g(this.a).getIntrinsicWidth() + 10;
      }
    }
    else
    {
      if ((a.d(this.a) & 0x2) != 0)
      {
        if ((paramFloat1 < 0.0F) || ((paramFloat1 == 0.0F) && (a.j(this.a) > a.k(this.a))))
        {
          i = -(i + a.g(this.a).getIntrinsicWidth() + 10);
          break label232;
        }
      }
      else if ((a.d(this.a) & 0x8) != 0)
      {
        if ((paramFloat2 >= 0.0F) && ((paramFloat2 != 0.0F) || (a.j(this.a) <= a.k(this.a)))) {
          i = 0;
        } else {
          i = -(j + a.i(this.a).getIntrinsicHeight() + 10);
        }
        j = i;
        i = 0;
        break label235;
      }
      i = 0;
    }
    label232:
    j = 0;
    label235:
    int k = i;
    if (a.c(this.a) != null)
    {
      k = i;
      if (!a.c(this.a).isEmpty())
      {
        paramView = a.c(this.a).iterator();
        do
        {
          for (;;)
          {
            k = i;
            if (!paramView.hasNext()) {
              break label345;
            }
            a.a locala = (a.a)paramView.next();
            boolean bool;
            if (i != 0) {
              bool = true;
            } else {
              bool = false;
            }
            k = locala.a(bool);
            if (k != 2) {
              break;
            }
            i = 0;
          }
        } while (k != 3);
        return;
      }
    }
    label345:
    a.b(this.a).a(k, j);
    this.a.invalidate();
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.a(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((a.d(this.a) & 0x1) != 0)
    {
      paramView = this.a;
      a.a(paramView, Math.abs(paramInt1 / (a.f(paramView).getWidth() + a.g(this.a).getIntrinsicWidth())));
    }
    else if ((a.d(this.a) & 0x2) != 0)
    {
      paramView = this.a;
      a.a(paramView, Math.abs(paramInt1 / (a.f(paramView).getWidth() + a.h(this.a).getIntrinsicWidth())));
    }
    else if ((a.d(this.a) & 0x8) != 0)
    {
      paramView = this.a;
      a.a(paramView, Math.abs(paramInt2 / (a.f(paramView).getHeight() + a.i(this.a).getIntrinsicHeight())));
    }
    a.b(this.a, paramInt1);
    a.c(this.a, paramInt2);
    this.a.invalidate();
    if ((a.j(this.a) < a.k(this.a)) && (!this.b)) {
      this.b = true;
    }
    if ((a.c(this.a) != null) && (!a.c(this.a).isEmpty()))
    {
      paramView = a.c(this.a).iterator();
      while (paramView.hasNext()) {
        ((a.a)paramView.next()).a(a.b(this.a).a(), a.j(this.a));
      }
    }
    if ((a.c(this.a) != null) && (!a.c(this.a).isEmpty()) && (a.b(this.a).a() == 1) && (a.j(this.a) >= a.k(this.a)) && (this.b))
    {
      this.b = false;
      paramView = a.c(this.a).iterator();
      while (paramView.hasNext()) {
        ((a.a)paramView.next()).a();
      }
    }
    if ((a.j(this.a) >= 1.0F) && (a.c(this.a) != null) && (!a.c(this.a).isEmpty()))
    {
      paramView = a.c(this.a).iterator();
      while (paramView.hasNext())
      {
        a.a locala = (a.a)paramView.next();
        if ((locala instanceof a.b)) {
          ((a.b)locala).b();
        }
      }
    }
  }
  
  public boolean a(View paramView, int paramInt)
  {
    int j = a.b(this.a).c(a.a(this.a), paramInt);
    int i = 1;
    if (j != 0)
    {
      if (a.b(this.a).c(1, paramInt)) {
        a.a(this.a, 1);
      } else if (a.b(this.a).c(2, paramInt)) {
        a.a(this.a, 2);
      } else if (a.b(this.a).c(8, paramInt)) {
        a.a(this.a, 8);
      }
      if ((a.c(this.a) != null) && (!a.c(this.a).isEmpty()))
      {
        paramView = a.c(this.a).iterator();
        while (paramView.hasNext()) {
          ((a.a)paramView.next()).a(a.d(this.a));
        }
      }
      this.b = true;
    }
    boolean bool;
    if ((a.a(this.a) != 1) && (a.a(this.a) != 2))
    {
      if (a.a(this.a) == 8)
      {
        bool = a.b(this.a).b(1, paramInt);
      }
      else
      {
        if (a.a(this.a) == 11)
        {
          paramInt = i;
          break label274;
        }
        paramInt = 0;
        break label274;
      }
    }
    else {
      bool = a.b(this.a).b(2, paramInt);
    }
    paramInt = true ^ bool;
    label274:
    return j & paramInt & a.e(this.a);
  }
  
  public int b(View paramView)
  {
    return a.a(this.a) & 0x8;
  }
  
  public int b(View paramView, int paramInt1, int paramInt2)
  {
    int i = a.d(this.a);
    paramInt2 = 0;
    if ((i & 0x8) != 0) {
      paramInt2 = Math.min(0, Math.max(paramInt1, -paramView.getHeight()));
    }
    return paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sv.a.c
 * JD-Core Version:    0.7.0.1
 */