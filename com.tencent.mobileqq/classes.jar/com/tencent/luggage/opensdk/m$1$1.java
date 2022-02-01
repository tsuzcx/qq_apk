package com.tencent.luggage.opensdk;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.ro.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.i;

class m$1$1
  implements n.b
{
  m$1$1(m.1 param1, i parami, b paramb) {}
  
  public void a()
  {
    ((k)this.a).a();
  }
  
  public void a(@NonNull Exception paramException)
  {
    ((k)this.a).c();
    this.b.a("fail cancel");
  }
  
  public void a(@NonNull String paramString)
  {
    this.b.a(new Object[] { paramString });
    this.a.dismiss();
  }
  
  public void b()
  {
    ((k)this.a).b();
    this.b.a("fail cancel");
  }
  
  public void c()
  {
    this.b.a("fail cancel");
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.m.1.1
 * JD-Core Version:    0.7.0.1
 */