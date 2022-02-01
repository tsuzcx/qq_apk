package com.tencent.luggage.storage;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.luggage.wxa.fo.c;
import com.tencent.luggage.wxa.fq.a;
import java.util.Iterator;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/storage/StandaloneCriticalDataProvider;", "Lcom/tencent/luggage/wxa/storage/WxaCriticalDataProvider;", "()V", "provideDatabase", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class StandaloneCriticalDataProvider
  extends c
{
  @SuppressLint({"LongLogTag"})
  @Nullable
  protected com.tencent.luggage.wxa.rb.b a()
  {
    Object localObject = getContext();
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    if (!a.a((Context)localObject)) {
      return null;
    }
    localObject = b.a();
    Iterator localIterator = b.c();
    Intrinsics.checkExpressionValueIsNotNull(localIterator, "WxaDBRegistry.traverseAllStorages()");
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      a((Class)localEntry.getKey(), localEntry.getValue());
    }
    return (com.tencent.luggage.wxa.rb.b)localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.storage.StandaloneCriticalDataProvider
 * JD-Core Version:    0.7.0.1
 */