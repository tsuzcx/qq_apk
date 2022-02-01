package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.wxa.rt.i;
import com.tencent.luggage.wxa.rt.j;
import java.util.List;

class x$2$1
  implements j
{
  x$2$1(x.2 param2, String paramString, List paramList) {}
  
  public boolean a(i parami)
  {
    boolean bool = parami.d().endsWith(".nomedia") ^ true;
    if ((bool) && (!parami.n()))
    {
      v localv = new v(k.a(parami.l().replaceFirst(this.a, "")));
      FileStat.a(parami.l(), localv);
      this.b.add(localv);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.x.2.1
 * JD-Core Version:    0.7.0.1
 */