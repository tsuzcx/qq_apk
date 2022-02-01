package com.tencent.luggage.wxa.it;

import android.graphics.Typeface;
import com.tencent.luggage.wxa.il.a;
import com.tencent.luggage.wxa.ir.c;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mm.picker.base.view.WheelView.b;
import java.util.List;

public class d<T>
{
  private WheelView a;
  private WheelView b;
  private List<T> c;
  private boolean d = true;
  private boolean e;
  private c f;
  private int g;
  private WheelView.b h;
  private float i;
  
  @Deprecated
  private void d()
  {
    this.b.setDividerColor(this.g);
  }
  
  @Deprecated
  private void e() {}
  
  private void e(int paramInt)
  {
    if (this.c != null) {
      this.b.setCurrentItem(paramInt);
    }
  }
  
  @Deprecated
  private void f() {}
  
  public WheelView a()
  {
    return this.a;
  }
  
  public void a(float paramFloat)
  {
    this.i = paramFloat;
    f();
  }
  
  @Deprecated
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.b.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  @Deprecated
  public void a(Typeface paramTypeface) {}
  
  public void a(c paramc)
  {
    this.f = paramc;
  }
  
  public void a(WheelView.b paramb)
  {
    this.h = paramb;
    e();
  }
  
  public void a(WheelView paramWheelView)
  {
    this.a = paramWheelView;
  }
  
  public void a(WheelView paramWheelView, boolean paramBoolean)
  {
    this.e = paramBoolean;
    if (this.a == null) {
      this.a = paramWheelView;
    }
    this.b = this.a;
  }
  
  public void a(String paramString)
  {
    if (paramString != null) {
      this.b.setLabel(paramString);
    }
  }
  
  public void a(List<T> paramList)
  {
    this.c = paramList;
    this.b.setAdapter(new a(this.c));
    this.b.setCurrentItem(0);
    this.b.setIsOptions(true);
    d.1 local1 = new d.1(this);
    if ((paramList != null) && (this.d)) {
      this.b.setOnItemSelectedListener(local1);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.b.setCyclic(paramBoolean);
  }
  
  public void b(float paramFloat)
  {
    this.b.setDividerHeight(paramFloat);
  }
  
  public void b(int paramInt)
  {
    if (this.d)
    {
      e(paramInt);
      return;
    }
    this.b.setCurrentItem(paramInt);
  }
  
  public void b(boolean paramBoolean)
  {
    this.b.a(paramBoolean);
  }
  
  public int[] b()
  {
    int[] arrayOfInt = new int[3];
    arrayOfInt[0] = this.b.getCurrentItem();
    return arrayOfInt;
  }
  
  public WheelView c()
  {
    return this.b;
  }
  
  public void c(int paramInt)
  {
    this.g = paramInt;
    d();
  }
  
  @Deprecated
  public void d(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.it.d
 * JD-Core Version:    0.7.0.1
 */