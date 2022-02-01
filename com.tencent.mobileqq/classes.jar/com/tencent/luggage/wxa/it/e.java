package com.tencent.luggage.wxa.it;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.luggage.wxa.il.c;
import com.tencent.luggage.wxa.il.d;
import com.tencent.luggage.wxa.ir.a;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mm.picker.base.view.WheelView.b;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class e
{
  public static DateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
  private a A;
  private String[] B = { "1", "3", "5", "7", "8", "10", "12" };
  private String[] C = { "4", "6", "9", "11" };
  private final List<String> D = Arrays.asList(this.B);
  private final List<String> E = Arrays.asList(this.C);
  private Context F;
  private View b;
  private WheelView c;
  private WheelView d;
  private WheelView e;
  private WheelView f;
  private WheelView g;
  private WheelView h;
  private int i;
  private d j;
  private boolean[] k;
  private int l = 1900;
  private int m = 2100;
  private int n = 1;
  private int o = 12;
  private int p = 1;
  private int q = 31;
  private int r = 0;
  private int s = 0;
  private int t = 23;
  private int u = 59;
  private int v;
  private int w;
  private boolean x = false;
  private float y;
  private WheelView.b z;
  
  public e(Context paramContext)
  {
    this.F = paramContext;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = paramInt1;
    if (this.x) {
      i1 = paramInt1 - 1;
    }
    if ((this.l == this.m) && (this.n == this.o))
    {
      localList = this.D;
      paramInt1 = paramInt2 + 1;
      if (localList.contains(String.valueOf(paramInt1)))
      {
        if (this.q > 31) {
          this.q = 31;
        }
        this.e.setAdapter(new c(this.p, this.q));
      }
      else if (this.E.contains(String.valueOf(paramInt1)))
      {
        if (this.q > 30) {
          this.q = 30;
        }
        this.e.setAdapter(new c(this.p, this.q));
      }
      else if (((i1 % 4 == 0) && (i1 % 100 != 0)) || (i1 % 400 == 0))
      {
        if (this.q > 29) {
          this.q = 29;
        }
        this.e.setAdapter(new c(this.p, this.q));
      }
      else
      {
        if (this.q > 28) {
          this.q = 28;
        }
        this.e.setAdapter(new c(this.p, this.q));
      }
      this.e.setCurrentItem(paramInt3 - this.p);
      return;
    }
    if (i1 == this.l)
    {
      paramInt1 = paramInt2 + 1;
      if (paramInt1 == this.n)
      {
        if (this.D.contains(String.valueOf(paramInt1))) {
          this.e.setAdapter(new c(this.p, 31));
        } else if (this.E.contains(String.valueOf(paramInt1))) {
          this.e.setAdapter(new c(this.p, 30));
        } else if (((i1 % 4 == 0) && (i1 % 100 != 0)) || (i1 % 400 == 0)) {
          this.e.setAdapter(new c(this.p, 29));
        } else {
          this.e.setAdapter(new c(this.p, 28));
        }
        this.e.setCurrentItem(paramInt3 - this.p);
        return;
      }
    }
    if (i1 == this.m)
    {
      paramInt1 = paramInt2 + 1;
      if (paramInt1 == this.o)
      {
        if (this.D.contains(String.valueOf(paramInt1)))
        {
          if (this.q > 31) {
            this.q = 31;
          }
          this.e.setAdapter(new c(1, this.q));
        }
        else if (this.E.contains(String.valueOf(paramInt1)))
        {
          if (this.q > 30) {
            this.q = 30;
          }
          this.e.setAdapter(new c(1, this.q));
        }
        else if (((i1 % 4 == 0) && (i1 % 100 != 0)) || (i1 % 400 == 0))
        {
          if (this.q > 29) {
            this.q = 29;
          }
          this.e.setAdapter(new c(1, this.q));
        }
        else
        {
          if (this.q > 28) {
            this.q = 28;
          }
          this.e.setAdapter(new c(1, this.q));
        }
        this.e.setCurrentItem(paramInt3 - 1);
        return;
      }
    }
    List localList = this.D;
    paramInt1 = paramInt2 + 1;
    if (localList.contains(String.valueOf(paramInt1))) {
      this.e.setAdapter(new c(1, 31));
    } else if (this.E.contains(String.valueOf(paramInt1))) {
      this.e.setAdapter(new c(1, 30));
    } else if (((i1 % 4 == 0) && (i1 % 100 != 0)) || (i1 % 400 == 0)) {
      this.e.setAdapter(new c(1, 29));
    } else {
      this.e.setAdapter(new c(1, 28));
    }
    this.e.setCurrentItem(paramInt3 - 1);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, List<String> paramList1, List<String> paramList2)
  {
    int i1 = a(this.e);
    int i2 = this.e.getCurrentItem();
    if (paramList1.contains(String.valueOf(paramInt2)))
    {
      paramInt1 = 31;
      if (paramInt4 > 31) {
        paramInt4 = paramInt1;
      }
      this.e.setAdapter(new c(paramInt3, paramInt4));
    }
    else if (paramList2.contains(String.valueOf(paramInt2)))
    {
      paramInt1 = 30;
      if (paramInt4 > 30) {
        paramInt4 = paramInt1;
      }
      this.e.setAdapter(new c(paramInt3, paramInt4));
    }
    else if (((paramInt1 % 4 == 0) && (paramInt1 % 100 != 0)) || (paramInt1 % 400 == 0))
    {
      paramInt1 = 29;
      if (paramInt4 > 29) {
        paramInt4 = paramInt1;
      }
      this.e.setAdapter(new c(paramInt3, paramInt4));
    }
    else
    {
      paramInt1 = 28;
      if (paramInt4 > 28) {
        paramInt4 = paramInt1;
      }
      this.e.setAdapter(new c(paramInt3, paramInt4));
    }
    if (i2 > this.e.getAdapter().a() - 1)
    {
      paramInt1 = this.e.getAdapter().a();
      this.e.setCurrentItem(paramInt1 - 1);
    }
    if (a(this.e) != i1)
    {
      paramInt1 = ((c)this.e.getAdapter()).c();
      paramInt2 = ((c)this.e.getAdapter()).b();
      if (i1 <= paramInt2)
      {
        this.e.setCurrentItem(0);
        return;
      }
      if (i1 >= paramInt1)
      {
        paramList1 = this.e;
        paramList1.setCurrentItem(paramList1.getAdapter().a() - 1);
        return;
      }
      this.e.setCurrentItem(i1 - paramInt2);
    }
  }
  
  private void a(List<WheelView> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((WheelView)paramList.next()).setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0F));
    }
  }
  
  private void b(WheelView paramWheelView)
  {
    if (this.A != null) {
      paramWheelView.setOnItemSelectedListener(new e.4(this));
    }
  }
  
  private void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.v = paramInt1;
    this.c = ((WheelView)this.b.findViewById(2131450356));
    this.d = ((WheelView)this.b.findViewById(2131438820));
    this.e = ((WheelView)this.b.findViewById(2131431631));
    this.j = new d(this.l, this.m, this.F);
    this.c.setAdapter(this.j);
    this.c.setCurrentItem(paramInt1 - this.l);
    this.c.setGravity(this.i);
    int i1 = this.l;
    int i2 = this.m;
    if (i1 == i2)
    {
      this.d.setAdapter(new c(this.n, this.o, new com.tencent.luggage.wxa.il.b(this.F)));
      this.d.setCurrentItem(paramInt2 + 1 - this.n);
    }
    else if (paramInt1 == i1)
    {
      this.d.setAdapter(new c(this.n, 12, new com.tencent.luggage.wxa.il.b(this.F)));
      this.d.setCurrentItem(paramInt2 + 1 - this.n);
    }
    else if (paramInt1 == i2)
    {
      this.d.setAdapter(new c(1, this.o, new com.tencent.luggage.wxa.il.b(this.F)));
      this.d.setCurrentItem(paramInt2);
    }
    else if ((this.x) && (paramInt1 - 1 == i1))
    {
      this.d.setAdapter(new c(this.n, 12, new com.tencent.luggage.wxa.il.b(this.F)));
      this.d.setCurrentItem(paramInt2 + 1 - this.n);
    }
    else
    {
      this.d.setAdapter(new c(1, 12, new com.tencent.luggage.wxa.il.b(this.F)));
      this.d.setCurrentItem(paramInt2);
    }
    this.d.setGravity(this.i);
    a(paramInt1, paramInt2, paramInt3);
    this.e.setGravity(this.i);
    this.f = ((WheelView)this.b.findViewById(2131435187));
    this.f.setAdapter(new c(this.r, this.t));
    this.f.setCurrentItem(paramInt4 - this.r);
    this.f.setGravity(this.i);
    this.g = ((WheelView)this.b.findViewById(2131438377));
    paramInt2 = this.r;
    if ((paramInt4 == paramInt2) && (paramInt2 == this.t))
    {
      this.g.setAdapter(new c(this.s, this.u));
      if (paramInt5 < this.s)
      {
        this.g.setCurrentItem(0);
      }
      else
      {
        paramInt2 = this.u;
        if (paramInt5 > paramInt2) {
          this.g.setCurrentItem(paramInt2);
        } else {
          this.g.setCurrentItem(paramInt5);
        }
      }
    }
    else if (paramInt4 == this.r)
    {
      this.g.setAdapter(new c(this.s, 59));
      paramInt2 = this.s;
      if (paramInt5 < paramInt2) {
        this.g.setCurrentItem(0);
      } else {
        this.g.setCurrentItem(paramInt5 - paramInt2);
      }
    }
    else if (paramInt4 == this.t)
    {
      this.g.setAdapter(new c(0, this.u));
      paramInt2 = this.u;
      if (paramInt5 >= paramInt2) {
        this.g.setCurrentItem(paramInt2);
      } else {
        this.g.setCurrentItem(paramInt5);
      }
    }
    else
    {
      this.g.setAdapter(new c(0, 59));
      this.g.setCurrentItem(paramInt5);
    }
    this.g.setGravity(this.i);
    this.h = ((WheelView)this.b.findViewById(2131445463));
    this.h.setAdapter(new c(0, 59));
    this.h.setCurrentItem(paramInt6);
    this.h.setGravity(this.i);
    f();
    e();
    d();
    b(this.e);
    b(this.f);
    b(this.g);
    b(this.h);
    if (this.k.length == 6)
    {
      a(a());
      if ((this.x) && (paramInt1 == 2))
      {
        this.d.b(0);
        this.e.b(0);
        this.d.invalidate();
        this.e.invalidate();
      }
      return;
    }
    throw new IllegalArgumentException("type[] length is not 6");
  }
  
  private void d()
  {
    this.d.setOnItemSelectedListener(new e.1(this));
  }
  
  private void e()
  {
    this.c.setOnItemSelectedListener(new e.2(this));
  }
  
  private void f()
  {
    this.f.setOnItemSelectedListener(new e.3(this));
  }
  
  private void g()
  {
    this.e.setDividerColor(this.w);
    this.d.setDividerColor(this.w);
    this.c.setDividerColor(this.w);
    this.f.setDividerColor(this.w);
    this.g.setDividerColor(this.w);
    this.h.setDividerColor(this.w);
  }
  
  @Deprecated
  private void h() {}
  
  @Deprecated
  private void i() {}
  
  public int a(WheelView paramWheelView)
  {
    if ((paramWheelView.getAdapter() instanceof c))
    {
      paramWheelView = paramWheelView.getAdapter().a(paramWheelView.getCurrentItem());
      if (paramWheelView != null) {
        return ((Integer)paramWheelView).intValue();
      }
    }
    return 0;
  }
  
  public List<WheelView> a()
  {
    ArrayList localArrayList = new ArrayList();
    int i2 = 0;
    while (i2 < 6)
    {
      int i1 = 8;
      WheelView localWheelView;
      if (i2 != 0)
      {
        if (i2 != 1)
        {
          if (i2 != 2)
          {
            if (i2 != 3)
            {
              if (i2 != 4)
              {
                if (i2 == 5)
                {
                  localWheelView = this.h;
                  if (this.k[i2] != 0) {
                    i1 = 0;
                  }
                  localWheelView.setVisibility(i1);
                  if (this.k[i2] != 0) {
                    localArrayList.add(this.h);
                  }
                }
              }
              else
              {
                localWheelView = this.g;
                if (this.k[i2] != 0) {
                  i1 = 0;
                }
                localWheelView.setVisibility(i1);
                if (this.k[i2] != 0) {
                  localArrayList.add(this.g);
                }
              }
            }
            else
            {
              localWheelView = this.f;
              if (this.k[i2] != 0) {
                i1 = 0;
              }
              localWheelView.setVisibility(i1);
              if (this.k[i2] != 0) {
                localArrayList.add(this.f);
              }
            }
          }
          else
          {
            localWheelView = this.e;
            if (this.k[i2] != 0) {
              i1 = 0;
            }
            localWheelView.setVisibility(i1);
            if (this.k[i2] != 0) {
              localArrayList.add(this.e);
            }
          }
        }
        else
        {
          localWheelView = this.d;
          if (this.k[i2] != 0) {
            i1 = 0;
          }
          localWheelView.setVisibility(i1);
          if (this.k[i2] != 0) {
            localArrayList.add(this.d);
          }
        }
      }
      else
      {
        localWheelView = this.c;
        if (this.k[i2] != 0) {
          i1 = 0;
        }
        localWheelView.setVisibility(i1);
        if (this.k[i2] != 0) {
          localArrayList.add(this.c);
        }
      }
      i2 += 1;
    }
    return localArrayList;
  }
  
  public void a(float paramFloat)
  {
    this.y = paramFloat;
    i();
  }
  
  public void a(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.e.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    this.f.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    this.g.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    this.c.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    this.d.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    this.h.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  public void a(View paramView)
  {
    this.b = paramView;
  }
  
  public void a(View paramView, boolean[] paramArrayOfBoolean, int paramInt)
  {
    if (this.b == null) {
      this.b = paramView;
    }
    this.k = paramArrayOfBoolean;
    this.i = paramInt;
  }
  
  public void a(a parama)
  {
    this.A = parama;
  }
  
  public void a(WheelView.b paramb)
  {
    this.z = paramb;
    h();
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if (paramString1 != null) {
      this.c.setLabel(paramString1);
    } else {
      this.c.setLabel(this.b.getContext().getString(2131892622));
    }
    if (paramString2 != null) {
      this.d.setLabel(paramString2);
    } else {
      this.d.setLabel(this.b.getContext().getString(2131892619));
    }
    if (paramString3 != null) {
      this.e.setLabel(paramString3);
    } else {
      this.e.setLabel(this.b.getContext().getString(2131892616));
    }
    if (paramString4 != null) {
      this.f.setLabel(paramString4);
    } else {
      this.f.setLabel(this.b.getContext().getString(2131892617));
    }
    if (paramString5 != null) {
      this.g.setLabel(paramString5);
    } else {
      this.g.setLabel(this.b.getContext().getString(2131892618));
    }
    if (paramString6 != null)
    {
      this.h.setLabel(paramString6);
      return;
    }
    this.h.setLabel(this.b.getContext().getString(2131892620));
  }
  
  public void a(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    int i1;
    int i2;
    int i3;
    int i4;
    if ((paramCalendar1 == null) && (paramCalendar2 != null))
    {
      i1 = paramCalendar2.get(1);
      i2 = paramCalendar2.get(2) + 1;
      i3 = paramCalendar2.get(5);
      i4 = this.l;
      if (i1 > i4)
      {
        this.m = i1;
        this.o = i2;
        this.q = i3;
        return;
      }
      if (i1 == i4)
      {
        i4 = this.n;
        if (i2 > i4)
        {
          this.m = i1;
          this.o = i2;
          this.q = i3;
          return;
        }
        if ((i2 == i4) && (i3 > this.p))
        {
          this.m = i1;
          this.o = i2;
          this.q = i3;
        }
      }
    }
    else if ((paramCalendar1 != null) && (paramCalendar2 == null))
    {
      i1 = paramCalendar1.get(1);
      i2 = paramCalendar1.get(2) + 1;
      i3 = paramCalendar1.get(5);
      i4 = this.m;
      if (i1 < i4)
      {
        this.n = i2;
        this.p = i3;
        this.l = i1;
        return;
      }
      if (i1 == i4)
      {
        i4 = this.o;
        if (i2 < i4)
        {
          this.n = i2;
          this.p = i3;
          this.l = i1;
          return;
        }
        if ((i2 == i4) && (i3 < this.q))
        {
          this.n = i2;
          this.p = i3;
          this.l = i1;
        }
      }
    }
    else if ((paramCalendar1 != null) && (paramCalendar2 != null))
    {
      this.l = paramCalendar1.get(1);
      this.m = paramCalendar2.get(1);
      this.n = (paramCalendar1.get(2) + 1);
      this.o = (paramCalendar2.get(2) + 1);
      this.p = paramCalendar1.get(5);
      this.q = paramCalendar2.get(5);
      this.r = paramCalendar1.get(11);
      this.s = paramCalendar1.get(12);
      this.t = paramCalendar2.get(11);
      this.u = paramCalendar2.get(12);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.x = paramBoolean;
  }
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(this.c));
    localStringBuilder.append("-");
    localStringBuilder.append(a(this.d));
    localStringBuilder.append("-");
    localStringBuilder.append(a(this.e));
    localStringBuilder.append(" ");
    localStringBuilder.append(a(this.f));
    localStringBuilder.append(":");
    localStringBuilder.append(a(this.g));
    localStringBuilder.append(":");
    localStringBuilder.append(a(this.h));
    return String.valueOf(localStringBuilder.toString());
  }
  
  public void b(float paramFloat)
  {
    this.e.setDividerHeight(paramFloat);
    this.f.setDividerHeight(paramFloat);
    this.g.setDividerHeight(paramFloat);
    this.c.setDividerHeight(paramFloat);
    this.d.setDividerHeight(paramFloat);
    this.h.setDividerHeight(paramFloat);
  }
  
  public void b(int paramInt)
  {
    this.m = paramInt;
  }
  
  @Deprecated
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {}
  
  public void b(boolean paramBoolean)
  {
    this.x = paramBoolean;
    this.j.a(paramBoolean);
    this.c.setLongTermYear(paramBoolean);
    this.d.setLongTermMonthDay(paramBoolean);
    this.e.setLongTermMonthDay(paramBoolean);
  }
  
  public View c()
  {
    return this.b;
  }
  
  public void c(int paramInt)
  {
    this.w = paramInt;
    g();
  }
  
  public void c(boolean paramBoolean)
  {
    this.c.setCyclic(paramBoolean);
    this.d.setCyclic(paramBoolean);
    this.e.setCyclic(paramBoolean);
    this.f.setCyclic(paramBoolean);
    this.g.setCyclic(paramBoolean);
    this.h.setCyclic(paramBoolean);
  }
  
  @Deprecated
  public void d(int paramInt) {}
  
  public void d(boolean paramBoolean)
  {
    this.e.a(paramBoolean);
    this.d.a(paramBoolean);
    this.c.a(paramBoolean);
    this.f.a(paramBoolean);
    this.g.a(paramBoolean);
    this.h.a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.it.e
 * JD-Core Version:    0.7.0.1
 */