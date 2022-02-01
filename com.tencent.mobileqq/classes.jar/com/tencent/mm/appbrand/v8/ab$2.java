package com.tencent.mm.appbrand.v8;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import com.tencent.luggage.wxa.qz.o;

class ab$2
  implements ComponentCallbacks2
{
  ab$2(ab paramab) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onLowMemory()
  {
    o.d(ab.c(), "onLowMemory");
    this.a.a(2);
    o.d(ab.c(), "onLowMemory notification with CRITICAL end");
  }
  
  public void onTrimMemory(int paramInt)
  {
    o.d(ab.c(), "onTrimMemory level = [%d]", new Object[] { Integer.valueOf(paramInt) });
    Integer localInteger = ab.b(paramInt);
    if (localInteger != null) {
      this.a.a(localInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.ab.2
 * JD-Core Version:    0.7.0.1
 */