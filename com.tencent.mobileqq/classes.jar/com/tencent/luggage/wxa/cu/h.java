package com.tencent.luggage.wxa.cu;

import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.jx.m;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/jsapi/webview/jsapi/HTMLWebViewJsApiPool;", "", "()V", "collectApis", "", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class h
{
  public static final h a = new h();
  
  @NotNull
  public final Map<String, m> a()
  {
    Object localObject = SetsKt.setOf(new a[] { (a)new g(), (a)new j(), (a)new b(), (a)new i(), (a)new c(), (a)new e(), (a)new d() });
    h.a locala = new h.a();
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala1 = (a)((Iterator)localObject).next();
      Map localMap = (Map)locala;
      String str = locala1.d();
      Intrinsics.checkExpressionValueIsNotNull(str, "it.name");
      Locale localLocale = Locale.ENGLISH;
      Intrinsics.checkExpressionValueIsNotNull(localLocale, "Locale.ENGLISH");
      if (str != null)
      {
        str = str.toLowerCase(localLocale);
        Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.String).toLowerCase(locale)");
        localMap.put(str, locala1);
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
    }
    return (Map)locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cu.h
 * JD-Core Version:    0.7.0.1
 */