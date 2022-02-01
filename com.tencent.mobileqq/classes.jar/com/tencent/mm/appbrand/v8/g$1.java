package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.ILoadLibraryDelegate;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.c;
import com.tencent.luggage.wxa.qz.o;

final class g$1
  implements ILoadLibraryDelegate
{
  public void loadLibrary(String paramString)
  {
    try
    {
      af.d();
      g.b();
    }
    catch (Exception paramString)
    {
      o.a("MicroMsg.JSRuntimeCreator", paramString, "", new Object[0]);
      if (c.a) {
        break label43;
      }
    }
    if (!c.b)
    {
      o.d("MicroMsg.JSRuntimeCreator", "load so done");
      return;
    }
    label43:
    throw paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.g.1
 * JD-Core Version:    0.7.0.1
 */