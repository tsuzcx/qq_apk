package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.wxa.jj.g;
import com.tencent.luggage.wxa.jj.o;
import com.tencent.luggage.wxa.qz.af;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appstorage/KVStorageUtil;", "", "()V", "INTERNAL_KEY_SEPARATOR", "", "MAX_STORAGE_ID", "", "NORMAL_KEY_SEPARATOR", "RET_GET_NO_SUCH_KEY", "", "[Ljava/lang/Object;", "TOTAL_DATA_SIZE_KEY", "TOTAL_STORAGE_ID_KEY", "addStorageId", "", "appId", "storageId", "getter", "Lkotlin/Function1;", "setter", "Lkotlin/Function2;", "calculateDataSize", "key", "data", "checkStorageIdInvalid", "", "generateInternalRecordKey", "generateRecordKey", "separator", "getAllStorageId", "", "getQuota", "removeStorageId", "removeStorageIdAll", "data-storage_release"}, k=1, mv={1, 1, 16})
public final class r
{
  @JvmField
  @NotNull
  public static final Object[] a = { m.a.d };
  public static final r b = new r();
  
  @JvmStatic
  public static final int a(int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "appId");
    if (Intrinsics.areEqual("wxGlobal", paramString)) {
      return g.b().i;
    }
    if ((paramInt != 0) && (paramInt != 2)) {
      return o.b(paramString);
    }
    return o.a(paramString);
  }
  
  @JvmStatic
  public static final int a(@Nullable String paramString1, @Nullable String paramString2)
  {
    if (paramString1 == null) {
      paramString1 = "";
    }
    int i = paramString1.length();
    if (paramString2 == null) {
      paramString2 = "";
    }
    return i + paramString2.length();
  }
  
  @JvmStatic
  @NotNull
  public static final String a(int paramInt, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "appId");
    Intrinsics.checkParameterIsNotNull(paramString2, "key");
    return a(paramInt, paramString1, paramString2, "++");
  }
  
  @JvmStatic
  @NotNull
  public static final String a(int paramInt, @NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "appId");
    Intrinsics.checkParameterIsNotNull(paramString2, "key");
    Intrinsics.checkParameterIsNotNull(paramString3, "separator");
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt > 0)
    {
      localStringBuilder.append(paramInt);
      localStringBuilder.append(paramString3);
    }
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString3);
    localStringBuilder.append(paramString2);
    paramString1 = localStringBuilder.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "sb.toString()");
    return paramString1;
  }
  
  @JvmStatic
  public static final void a(@NotNull String paramString, int paramInt, @NotNull Function1<? super String, String> paramFunction1, @NotNull Function2<? super String, ? super String, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "appId");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "getter");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "setter");
    paramFunction1 = a(paramString, paramFunction1, paramFunction2);
    if (ArraysKt.contains(paramFunction1, paramInt)) {
      return;
    }
    paramFunction1 = new JSONArray((Collection)ArraysKt.asList(paramFunction1));
    paramFunction1.put(paramInt);
    paramString = b(paramString, "@@@TOTAL@STORAGE@ID@@@");
    paramFunction1 = paramFunction1.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramFunction1, "json.toString()");
    paramFunction2.invoke(paramString, paramFunction1);
  }
  
  @JvmStatic
  public static final boolean a(int paramInt)
  {
    if (paramInt < 0) {
      return true;
    }
    return paramInt > 2;
  }
  
  @JvmStatic
  @NotNull
  public static final int[] a(@NotNull String paramString, @NotNull Function1<? super String, String> paramFunction1, @NotNull Function2<? super String, ? super String, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "appId");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "getter");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "setter");
    paramFunction2 = b(paramString, "@@@TOTAL@STORAGE@ID@@@");
    boolean bool = af.c(paramFunction2);
    int i = 0;
    paramString = Integer.valueOf(0);
    if (bool) {
      return new int[] { 0 };
    }
    paramFunction1 = (String)paramFunction1.invoke(paramFunction2);
    if (af.c(paramFunction1)) {
      return new int[] { 0 };
    }
    paramFunction1 = new JSONArray(paramFunction1);
    if (paramFunction1.length() <= 0) {
      return new int[] { 0 };
    }
    int j = paramFunction1.length();
    paramFunction2 = new ArrayList(j);
    while (i < j)
    {
      paramFunction2.add(Integer.valueOf(paramFunction1.getInt(i)));
      i += 1;
    }
    paramFunction1 = (List)paramFunction2;
    if (!paramFunction1.contains(paramString)) {
      paramFunction1.add(paramString);
    }
    return CollectionsKt.toIntArray((Collection)paramFunction1);
  }
  
  @JvmStatic
  @NotNull
  public static final String b(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "appId");
    Intrinsics.checkParameterIsNotNull(paramString2, "key");
    return a(0, paramString1, paramString2, "++");
  }
  
  @JvmStatic
  public static final void b(@NotNull String paramString, int paramInt, @NotNull Function1<? super String, String> paramFunction1, @NotNull Function2<? super String, ? super String, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "appId");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "getter");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "setter");
    paramFunction1 = ArraysKt.toMutableList(a(paramString, paramFunction1, paramFunction2));
    paramFunction1.remove(Integer.valueOf(paramInt));
    paramString = b(paramString, "@@@TOTAL@STORAGE@ID@@@");
    paramFunction1 = new JSONArray((Collection)paramFunction1).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramFunction1, "JSONArray(list).toString()");
    paramFunction2.invoke(paramString, paramFunction1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.r
 * JD-Core Version:    0.7.0.1
 */