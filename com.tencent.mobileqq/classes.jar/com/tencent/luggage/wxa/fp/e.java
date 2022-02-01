package com.tencent.luggage.wxa.fp;

import com.tencent.luggage.wxa.qw.id;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/storage/collection/OperationRemove;", "", "()V", "doRemove", "", "parcel", "Lcom/tencent/luggage/wxa/storage/collection/ModCollectionParcel;", "storage", "Lcom/tencent/luggage/wxa/storage/collection/WxaCollectionStorageContentResolver;", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
final class e
{
  public static final e a = new e();
  
  public final boolean a(@Nullable c paramc, @NotNull j paramj)
  {
    Intrinsics.checkParameterIsNotNull(paramj, "storage");
    if (paramc != null)
    {
      String str = paramc.a();
      int i = paramc.b();
      if (str != null)
      {
        if (!((Boolean)paramj.b().invoke(str, Integer.valueOf(i))).booleanValue()) {
          return false;
        }
        paramc = a.a;
        paramj = new id();
        paramj.a = str;
        paramj.b = i;
        paramc.a(a.a(paramj));
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fp.e
 * JD-Core Version:    0.7.0.1
 */