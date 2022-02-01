package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.rt.i;
import com.tencent.luggage.wxa.rt.j;

final class AppBrandLocalMediaObjectManager$1
  implements j
{
  public boolean a(i parami)
  {
    return (parami.j()) && (!parami.n()) && (!af.c(parami.d())) && (parami.d().startsWith("store_"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager.1
 * JD-Core Version:    0.7.0.1
 */