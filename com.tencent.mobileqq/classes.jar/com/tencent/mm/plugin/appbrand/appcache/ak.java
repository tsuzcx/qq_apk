package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.luggage.wxa.iu.d;

public class ak
{
  private static ak.a a;
  
  static h a(d paramd, ad paramad)
  {
    ak.a locala = a;
    if (locala != null)
    {
      paramad = locala.a(paramd, paramad);
      if (paramad != null) {
        return paramad;
      }
    }
    return new l(paramd.aa(), paramd.A().S);
  }
  
  public static void a(ak.a parama)
  {
    a = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ak
 * JD-Core Version:    0.7.0.1
 */