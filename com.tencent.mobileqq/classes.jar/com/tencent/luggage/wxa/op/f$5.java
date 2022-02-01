package com.tencent.luggage.wxa.op;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.bg;
import com.tencent.mm.plugin.appbrand.page.m;
import com.tencent.mm.plugin.appbrand.page.o.a;
import com.tencent.mm.plugin.appbrand.page.o.b;

class f$5
  implements o.b
{
  f$5(f paramf) {}
  
  private boolean a(String paramString, bg parambg)
  {
    if ((bg.b == parambg) && (!f.g(this.a)) && (f.h(this.a) != null) && (f.h(this.a).getCurrentUrl().equals(paramString)))
    {
      paramString = f.a(this.a);
      parambg = new StringBuilder();
      parambg.append("onCreatePage, reuse ");
      parambg.append(f.a(f.h(this.a)));
      o.d(paramString, parambg.toString());
      return true;
    }
    return false;
  }
  
  @NonNull
  public o.a a(@Nullable o.a parama)
  {
    Object localObject = parama;
    if (parama == null) {
      localObject = new f.5.1(this);
    }
    return new f.5.2(this, (o.a)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.op.f.5
 * JD-Core Version:    0.7.0.1
 */