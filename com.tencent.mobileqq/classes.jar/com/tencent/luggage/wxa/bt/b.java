package com.tencent.luggage.wxa.bt;

import android.content.res.Configuration;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.oi.i;
import com.tencent.luggage.wxa.ok.c.b;
import com.tencent.mm.plugin.appbrand.page.u;

public class b
  implements com.tencent.luggage.wxa.oi.b, i
{
  private final a a;
  private final u b;
  
  public b(@NonNull u paramu)
  {
    this.a = new a(paramu);
    this.b = paramu;
  }
  
  public void a()
  {
    this.b.d(new b.1(this));
  }
  
  public void a(Configuration paramConfiguration) {}
  
  public void a(@NonNull com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb) {}
  
  public void b()
  {
    this.b.d(new b.2(this));
  }
  
  public void c()
  {
    this.a.c();
  }
  
  public void d()
  {
    this.a.d();
  }
  
  public void e() {}
  
  public boolean f()
  {
    return this.a.e() == c.b.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bt.b
 * JD-Core Version:    0.7.0.1
 */