package com.tencent.luggage.wxa.fp;

import com.tencent.luggage.wxa.iy.a;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/storage/collection/WxaCollectionStorageContentResolver;", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage;", "addCollectionToStorage", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "username", "", "versionType", "", "getAddCollectionToStorage", "()Lkotlin/jvm/functions/Function2;", "setAddCollectionToStorage", "(Lkotlin/jvm/functions/Function2;)V", "deleteCollectionFromStorage", "getDeleteCollectionFromStorage", "setDeleteCollectionFromStorage", "getCurrentCollectionCount", "Lkotlin/Function0;", "getGetCurrentCollectionCount", "()Lkotlin/jvm/functions/Function0;", "setGetCurrentCollectionCount", "(Lkotlin/jvm/functions/Function0;)V", "setCurrentCollectionCountToStorage", "Lkotlin/Function1;", "count", "", "getSetCurrentCollectionCountToStorage", "()Lkotlin/jvm/functions/Function1;", "setSetCurrentCollectionCountToStorage", "(Lkotlin/jvm/functions/Function1;)V", "Companion", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public abstract interface j
  extends a
{
  public static final j.a b = j.a.a;
  
  @NotNull
  public abstract Function2<String, Integer, Boolean> a();
  
  @NotNull
  public abstract Function2<String, Integer, Boolean> b();
  
  @NotNull
  public abstract Function0<Integer> c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fp.j
 * JD-Core Version:    0.7.0.1
 */