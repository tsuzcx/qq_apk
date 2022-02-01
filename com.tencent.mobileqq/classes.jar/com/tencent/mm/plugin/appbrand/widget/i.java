package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.qz.s;
import com.tencent.luggage.wxa.qz.x;

public class i
  extends ProgressBar
{
  private boolean a = false;
  private float b = 0.0F;
  private float c;
  private float d;
  private float e;
  private float f;
  private boolean g = true;
  private s h = new i.1(this, Looper.getMainLooper());
  
  public i(Context paramContext)
  {
    this(paramContext, null);
    g();
  }
  
  public i(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public i(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setMax(1000);
    g();
  }
  
  private void c()
  {
    float f1 = this.b;
    if (f1 < 600.0F)
    {
      this.b = (f1 + this.c);
    }
    else if ((f1 >= 600.0F) && (f1 < 800.0F))
    {
      this.b = (f1 + this.d);
    }
    else
    {
      f1 = this.b;
      if ((f1 >= 800.0F) && (f1 < 920.0F)) {
        this.b = (f1 + this.e);
      }
    }
    s locals = this.h;
    if (locals != null) {
      if (this.b < 920.0F) {
        locals.a(1001, 10L);
      } else {
        locals.b(1001);
      }
    }
    setProgress((int)this.b);
  }
  
  private void d()
  {
    if (!this.a) {
      return;
    }
    float f1 = this.b;
    Float localFloat;
    if (f1 < 950.0F)
    {
      this.b = (f1 + this.f);
      f1 = this.b;
      if (f1 > 950.0F) {
        f1 = 950.0F;
      }
      this.b = f1;
      localFloat = Float.valueOf(1.0F);
    }
    else
    {
      this.b = (f1 + 1.0F);
      localFloat = Float.valueOf((1000.0F - this.b) * 0.01F + 0.3F);
    }
    s locals = this.h;
    if (locals != null) {
      if (this.b < 1000.0F)
      {
        locals.a(1002, 10L);
      }
      else
      {
        this.b = 1000.0F;
        locals.b(1002);
        this.h.a(1003, 10L);
      }
    }
    setAlpha(localFloat.floatValue());
    setProgress((int)this.b);
  }
  
  private void e()
  {
    setVisibility(0);
    setAlpha(1.0F);
  }
  
  private void f()
  {
    this.b = 0.0F;
    this.a = false;
    postInvalidateDelayed(200L);
    setVisibility(8);
  }
  
  private void g()
  {
    if (x.l(r.a()))
    {
      this.c = 4.0F;
      this.d = 1.0F;
      this.e = 0.3F;
      this.f = 50.0F;
      return;
    }
    this.c = 2.0F;
    this.d = 0.5F;
    this.e = 0.15F;
    this.f = 50.0F;
  }
  
  public void a()
  {
    o.e("MicroMsg.MMFalseProgressBar", "[cpan] start");
    if (!this.g) {
      return;
    }
    if (this.a) {
      return;
    }
    this.a = true;
    g();
    s locals = this.h;
    if (locals != null)
    {
      locals.a(1000);
      this.h.a(1001);
    }
  }
  
  public void b()
  {
    o.e("MicroMsg.MMFalseProgressBar", "[cpan] finish");
    s locals = this.h;
    if (locals != null) {
      locals.a(1002);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.i
 * JD-Core Version:    0.7.0.1
 */