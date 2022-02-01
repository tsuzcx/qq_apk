package com.tencent.luggage.wxa.ok;

import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import com.tencent.mm.plugin.appbrand.page.u;
import java.lang.reflect.Proxy;

public class c$a
{
  public static c a()
  {
    c.a.1 local1 = new c.a.1();
    return (c)Proxy.newProxyInstance(c.class.getClassLoader(), new Class[] { c.class }, local1);
  }
  
  public static c a(@NonNull u paramu)
  {
    if (paramu.y().getStatusBar() == null) {
      return a();
    }
    if ((Build.VERSION.SDK_INT >= 21) && (!((com.tencent.luggage.wxa.do.a)paramu.b(com.tencent.luggage.wxa.do.a.class)).b)) {
      return new a(paramu);
    }
    return new b(paramu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ok.c.a
 * JD-Core Version:    0.7.0.1
 */