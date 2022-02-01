package com.tencent.luggage.wxa.it;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.luggage.wxa.ir.c;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class b<T>
  extends a
  implements View.OnClickListener
{
  public d d = new d();
  private Context e;
  
  public b(Context paramContext)
  {
    super(paramContext);
    this.e = paramContext;
  }
  
  private void a(Context paramContext)
  {
    g();
    a();
    b();
    c();
    this.d.a(new WheelView(paramContext), this.b.i);
    if (this.b.d != null) {
      this.d.a(this.b.d);
    }
    this.d.a(this.b.e);
    this.d.a(this.b.g);
    this.d.a(this.b.h);
    this.d.a(this.b.V);
    b(this.b.T);
    this.d.c(this.b.P);
    this.d.a(this.b.W);
    this.d.a(this.b.R);
    this.d.b(this.b.U);
    this.d.b(this.b.X);
    this.d.c(this.b.P);
  }
  
  private void k()
  {
    d locald = this.d;
    if (locald != null) {
      locald.b(this.b.f);
    }
  }
  
  public void a(float paramFloat)
  {
    this.d.b(paramFloat);
  }
  
  public void a(com.tencent.luggage.wxa.iq.a parama)
  {
    this.b = parama;
    a(this.e);
  }
  
  public void a(c paramc)
  {
    this.b.d = paramc;
    this.d.a(this.b.d);
  }
  
  public void a(List<T> paramList)
  {
    this.d.a(paramList);
    k();
  }
  
  public void b(int paramInt)
  {
    this.d.d(paramInt);
  }
  
  public boolean h()
  {
    return this.b.S;
  }
  
  public void i()
  {
    if (this.b.a != null)
    {
      int[] arrayOfInt = this.d.b();
      this.b.a.onOptionsSelect(arrayOfInt[0]);
    }
  }
  
  public WheelView j()
  {
    if (this.d.a() == null) {
      this.d.a(new WheelView(this.e));
    }
    return this.d.a();
  }
  
  public void onClick(View paramView)
  {
    if (((String)paramView.getTag()).equals("submit")) {
      i();
    }
    e();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.it.b
 * JD-Core Version:    0.7.0.1
 */