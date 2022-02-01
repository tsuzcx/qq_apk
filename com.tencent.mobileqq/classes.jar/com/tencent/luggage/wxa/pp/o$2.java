package com.tencent.luggage.wxa.pp;

import androidx.collection.ArrayMap;
import com.tencent.mm.plugin.appbrand.page.u;

final class o$2
  implements Runnable
{
  o$2(u paramu, String paramString, Integer paramInteger) {}
  
  public void run()
  {
    Object localObject = (ac)o.a().get(this.a);
    if (localObject != null)
    {
      localObject = o.a(this.a, ((ac)localObject).getInputId());
      if (localObject != null) {
        ((ab)localObject).a(this.b, this.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.o.2
 * JD-Core Version:    0.7.0.1
 */