package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.wxa.rt.i;
import com.tencent.luggage.wxa.rt.j;
import java.util.List;

class x$10$1
  implements j
{
  x$10$1(x.10 param10, String paramString, List paramList) {}
  
  public boolean a(i parami)
  {
    boolean bool = parami.d().endsWith(".nomedia") ^ true;
    if (bool)
    {
      h localh = new h();
      localh.a = k.a(parami.l().replaceFirst(this.a, ""));
      this.b.add(localh);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.x.10.1
 * JD-Core Version:    0.7.0.1
 */