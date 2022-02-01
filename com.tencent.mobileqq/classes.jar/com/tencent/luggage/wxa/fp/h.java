package com.tencent.luggage.wxa.fp;

import android.os.Parcelable;
import com.tencent.luggage.wxa.hu.a;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.qz.w;
import com.tencent.luggage.wxa.rb.e;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.time.ExperimentalTime;
import kotlin.time.TimeSource;
import kotlin.time.TimeSource.Monotonic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/storage/collection/WxaCollectionResolverImpl;", "Lcom/tencent/mm/sdk/storage/MStorage;", "Lcom/tencent/luggage/wxa/storage/collection/WxaCollectionStorageContentResolver;", "()V", "KEY_CURRENT_COLLECTION_COUNT", "", "TAG", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "addCollectionToStorage", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "username", "", "versionType", "", "getAddCollectionToStorage", "()Lkotlin/jvm/functions/Function2;", "setAddCollectionToStorage", "(Lkotlin/jvm/functions/Function2;)V", "collectionConfig", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getCollectionConfig", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "collectionConfig$delegate", "Lkotlin/Lazy;", "deleteCollectionFromStorage", "getDeleteCollectionFromStorage", "setDeleteCollectionFromStorage", "getCurrentCollectionCount", "Lkotlin/Function0;", "getGetCurrentCollectionCount", "()Lkotlin/jvm/functions/Function0;", "setGetCurrentCollectionCount", "(Lkotlin/jvm/functions/Function0;)V", "setCurrentCollectionCountToStorage", "Lkotlin/Function1;", "count", "", "getSetCurrentCollectionCountToStorage", "()Lkotlin/jvm/functions/Function1;", "setSetCurrentCollectionCountToStorage", "(Lkotlin/jvm/functions/Function1;)V", "addCollection", "getCount", "getCountLimit", "isCollection", "query", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "order", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage$ORDER;", "refreshOnPullDownOpen", "refreshOnPullDownOpenAnimationEnd", "removeCollection", "reorder", "reorderList", "reason", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class h
  extends e
  implements j
{
  public static final h a = new h();
  @NotNull
  private static String c = "Luggage.WxaCollectionStorageContentResolver";
  private static final Lazy d = LazyKt.lazy((Function0)h.c.a);
  @NotNull
  private static Function2<? super String, ? super Integer, Boolean> e = (Function2)h.b.a;
  @NotNull
  private static Function2<? super String, ? super Integer, Boolean> f = (Function2)h.d.a;
  @NotNull
  private static Function0<Integer> g = (Function0)h.e.a;
  @NotNull
  private static Function1<? super Integer, Unit> h = (Function1)h.g.a;
  
  private final w g()
  {
    return (w)d.getValue();
  }
  
  @NotNull
  public Function2<String, Integer, Boolean> a()
  {
    return e;
  }
  
  @ExperimentalTime
  public boolean a(@Nullable String paramString, int paramInt)
  {
    ((TimeSource)TimeSource.Monotonic.INSTANCE).markNow();
    if ((paramString != null) && (r.a(r.i()))) {
      return ((a)com.tencent.luggage.wxa.hj.h.a(r.i(), (Parcelable)new b.a(paramString, paramInt), b.class)).a;
    }
    return false;
  }
  
  public int b(@Nullable String paramString, int paramInt)
  {
    CharSequence localCharSequence = (CharSequence)paramString;
    int i;
    if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    int j = -1;
    if (i != 0) {
      return -1;
    }
    try
    {
      paramString = (com.tencent.luggage.wxa.hu.b)com.tencent.luggage.wxa.hj.h.a(r.i(), (Parcelable)new c(paramString, paramInt), h.a.a.getClass());
      paramInt = j;
      if (paramString != null) {
        paramInt = paramString.a;
      }
      return paramInt;
    }
    catch (Throwable paramString) {}
    return -1;
  }
  
  @NotNull
  public Function2<String, Integer, Boolean> b()
  {
    return f;
  }
  
  @NotNull
  public Function0<Integer> c()
  {
    return g;
  }
  
  public boolean c(@Nullable String paramString, int paramInt)
  {
    CharSequence localCharSequence = (CharSequence)paramString;
    boolean bool = false;
    int i;
    if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return false;
    }
    try
    {
      paramString = (a)com.tencent.luggage.wxa.hj.h.a(r.i(), (Parcelable)new c(paramString, paramInt), h.f.a.getClass());
      if (paramString != null) {
        bool = paramString.a;
      }
      return bool;
    }
    catch (Throwable paramString) {}
    return false;
  }
  
  @NotNull
  public Function1<Integer, Unit> d()
  {
    return h;
  }
  
  public int e()
  {
    return 50;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fp.h
 * JD-Core Version:    0.7.0.1
 */