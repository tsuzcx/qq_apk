package com.tencent.luggage.wxa.nl;

import com.tencent.luggage.wxa.jk.a;
import com.tencent.luggage.wxa.qz.h;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.rt.k;
import com.tencent.mm.plugin.appbrand.appcache.af;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/WxaEncryptPkgKeyInstaller;", "", "()V", "ensureKeyInstalled", "", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class p
{
  public static final p a = new p();
  
  public final boolean a()
  {
    String str = a.a(r.a());
    CharSequence localCharSequence = (CharSequence)str;
    int i;
    if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return false;
    }
    if ((k.h(str)) && (Intrinsics.areEqual("43bff1e72298b0ea0b73e2960d3c97b8", af.c(str)))) {
      return true;
    }
    return h.a(r.a(), "wasae.dat", str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nl.p
 * JD-Core Version:    0.7.0.1
 */