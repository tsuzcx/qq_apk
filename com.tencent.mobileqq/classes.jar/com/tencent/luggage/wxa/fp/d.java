package com.tencent.luggage.wxa.fp;

import com.tencent.luggage.wxa.jj.s;
import com.tencent.luggage.wxa.jj.s.a;
import com.tencent.luggage.wxa.jj.u;
import com.tencent.luggage.wxa.qw.id;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.mm.plugin.appbrand.appcache.d.a;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/storage/collection/OperationAdd;", "", "()V", "checkIsBan", "", "username", "", "doAdd", "", "parcel", "Lcom/tencent/luggage/wxa/storage/collection/ModCollectionParcel;", "storage", "Lcom/tencent/luggage/wxa/storage/collection/WxaCollectionStorageContentResolver;", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
final class d
{
  public static final d a = new d();
  
  private final boolean a(String paramString)
  {
    s locals = u.a().a(paramString, new String[] { "appInfo" });
    if (locals != null) {
      paramString = locals.n;
    } else {
      paramString = null;
    }
    paramString = (CharSequence)paramString;
    int i;
    if ((paramString != null) && (paramString.length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return false;
    }
    Intrinsics.checkExpressionValueIsNotNull(locals, "attrs");
    long l = locals.c().c;
    return af.a() < l;
  }
  
  public final int a(@Nullable c paramc, @NotNull j paramj)
  {
    Intrinsics.checkParameterIsNotNull(paramj, "storage");
    if (paramc != null)
    {
      String str = paramc.a();
      int j = paramc.b();
      paramc = (CharSequence)str;
      if ((paramc != null) && (paramc.length() != 0)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0) {
        return -1;
      }
      if ((d.a.a(j)) && (a(str))) {
        return -3;
      }
      int i = ((Number)paramj.c().invoke()).intValue();
      if (i == -1) {
        return -1;
      }
      if (i == 50) {
        return -2;
      }
      paramj.a().invoke(str, Integer.valueOf(j));
      paramc = a.a;
      paramj = new id();
      paramj.a = str;
      paramj.b = j;
      paramc.a(a.a(paramj, null, null, 6, null));
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fp.d
 * JD-Core Version:    0.7.0.1
 */