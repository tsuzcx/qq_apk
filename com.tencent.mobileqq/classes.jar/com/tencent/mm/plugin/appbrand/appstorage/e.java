package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.wxa.dx.a;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage;", "Lcom/tencent/mm/plugin/appbrand/appstorage/IAppBrandKVStorage;", "uin", "Lcom/tencent/luggage/sdk/login/MMUserId;", "(Lcom/tencent/luggage/sdk/login/MMUserId;)V", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getter", "Lkotlin/Function1;", "", "setter", "Lkotlin/Function2;", "", "appendTotalDataSize", "", "storageId", "appId", "size", "clear", "clearAll", "generateValue", "data", "dataType", "get", "", "", "key", "(ILjava/lang/String;Ljava/lang/String;)[Ljava/lang/Object;", "getAllStorageId", "", "getDataSize", "recordKey", "getQuota", "getTotalDataSize", "getTotalDataSizeAll", "info", "(ILjava/lang/String;)[Ljava/lang/Object;", "keys", "block", "keysSize", "remove", "Lcom/tencent/mm/plugin/appbrand/appstorage/IAppBrandKVStorage$ErrorType;", "reset", "set", "setTotalDataSize", "splitValue", "Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage$StorageInfo;", "str", "willReachQuota", "", "Companion", "StorageInfo", "data-storage_release"}, k=1, mv={1, 1, 16})
public final class e
  implements m
{
  public static final e.a a = new e.a(null);
  private static final Map<a, e> e = (Map)new LinkedHashMap();
  private w b;
  private final Function1<String, String> c;
  private final Function2<String, String, Unit> d;
  
  private e(a parama)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getMMKV uin:");
    localStringBuilder.append(parama);
    o.d("AppBrandMMKVStorage", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("AppBrandMMKVStorage");
    localStringBuilder.append(parama);
    parama = w.a(localStringBuilder.toString(), parama.toString());
    Intrinsics.checkExpressionValueIsNotNull(parama, "MultiProcessMMKV.getCryp…ME + uin, uin.toString())");
    this.b = parama;
    this.c = ((Function1)new e.c(this));
    this.d = ((Function2)new e.d(this));
  }
  
  private final String a(String paramString1, String paramString2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("#");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("#");
    localStringBuilder.append(paramString1);
    return localStringBuilder.toString();
  }
  
  private final void a(int paramInt1, String paramString, int paramInt2)
  {
    paramString = r.a(paramInt1, paramString, "@@@TOTAL@DATA@SIZE@@@", "++");
    this.b.putString(paramString, String.valueOf(paramInt2));
  }
  
  private final int b(int paramInt1, String paramString, int paramInt2)
  {
    paramInt2 = Math.max(0, c(paramInt1, paramString) + paramInt2);
    a(paramInt1, paramString, paramInt2);
    return paramInt2;
  }
  
  private final int b(String paramString)
  {
    paramString = this.b.getString(paramString, "");
    if (paramString == null) {
      paramString = "";
    }
    try
    {
      int i = Integer.parseInt(c(paramString).d());
      return i;
    }
    catch (NumberFormatException paramString)
    {
      label35:
      break label35;
    }
    return 0;
  }
  
  private final int c(int paramInt, String paramString)
  {
    paramString = r.a(paramInt, paramString, "@@@TOTAL@DATA@SIZE@@@", "++");
    return af.a(this.b.getString(paramString, ""), 0);
  }
  
  private final e.b c(String paramString)
  {
    paramString = (CharSequence)paramString;
    paramString = ((Collection)new Regex("#").split(paramString, 3)).toArray(new String[0]);
    if (paramString != null)
    {
      paramString = (String[])paramString;
      if (paramString.length == 3) {
        return new e.b(paramString[2], paramString[0], paramString[1]);
      }
      return new e.b("", "", "");
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
  }
  
  private final boolean c(int paramInt1, String paramString, int paramInt2)
  {
    return c(paramInt1, paramString) + paramInt2 >= d(paramInt1, paramString);
  }
  
  private final int d(int paramInt, String paramString)
  {
    return r.a(paramInt, paramString);
  }
  
  public int a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "appId");
    int[] arrayOfInt = r.a(paramString, this.c, this.d);
    int k = arrayOfInt.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += c(arrayOfInt[i], paramString);
      i += 1;
    }
    return j;
  }
  
  @Nullable
  public m.a a(int paramInt, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @NotNull String paramString4)
  {
    Intrinsics.checkParameterIsNotNull(paramString4, "dataType");
    if ((!af.c(paramString1)) && (!af.c(paramString2)))
    {
      if (paramString1 == null) {
        Intrinsics.throwNpe();
      }
      if (paramString2 == null) {
        Intrinsics.throwNpe();
      }
      String str = r.a(paramInt, paramString1, paramString2, "__");
      int j = b(str);
      int i = r.a(paramString2, paramString3);
      j = i - j;
      if (c(paramInt, paramString1, j)) {
        return m.a.e;
      }
      this.b.putString(str, a(paramString3, paramString4, i));
      b(paramInt, paramString1, j);
      r.a(paramString1, paramInt, this.c, this.d);
      return m.a.a;
    }
    return m.a.c;
  }
  
  public final void a()
  {
    w localw = this.b;
    if (localw != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reset ");
      localStringBuilder.append(this.b);
      o.d("AppBrandMMKVStorage", localStringBuilder.toString());
      localw.d();
    }
  }
  
  public void a(int paramInt, @Nullable String paramString)
  {
    if (af.c(paramString)) {
      return;
    }
    Object localObject;
    if (paramInt == 0)
    {
      localObject = Intrinsics.stringPlus(paramString, "__");
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(String.valueOf(paramInt));
      ((StringBuilder)localObject).append("__");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("__");
      localObject = ((StringBuilder)localObject).toString();
    }
    String[] arrayOfString = this.b.f();
    if (arrayOfString == null) {
      arrayOfString = new String[0];
    }
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      Intrinsics.checkExpressionValueIsNotNull(str, "key");
      if (StringsKt.startsWith$default(str, (String)localObject, false, 2, null)) {
        this.b.remove(str);
      }
      i += 1;
    }
    if (paramString == null) {
      Intrinsics.throwNpe();
    }
    a(paramInt, paramString, 0);
    r.b(paramString, paramInt, this.c, this.d);
  }
  
  @Nullable
  public Object[] a(int paramInt, @Nullable String paramString1, @Nullable String paramString2)
  {
    if ((!af.c(paramString1)) && (!af.c(paramString2)))
    {
      if (paramString1 == null) {
        Intrinsics.throwNpe();
      }
      if (paramString2 == null) {
        Intrinsics.throwNpe();
      }
      paramString1 = r.a(paramInt, paramString1, paramString2, "__");
      paramString1 = this.b.getString(paramString1, "");
      if (paramString1 == null) {
        paramString1 = "";
      }
      paramString1 = c(paramString1);
      if (!paramString1.a()) {
        return new Object[] { m.a.a, paramString1.b(), paramString1.c() };
      }
      return r.a;
    }
    return new Object[] { m.a.c };
  }
  
  @NotNull
  public m.a b(int paramInt, @Nullable String paramString1, @Nullable String paramString2)
  {
    if ((!af.c(paramString1)) && (!af.c(paramString2)))
    {
      if (paramString1 == null) {
        Intrinsics.throwNpe();
      }
      if (paramString2 == null) {
        Intrinsics.throwNpe();
      }
      paramString2 = r.a(paramInt, paramString1, paramString2, "__");
      int i = b(paramInt, paramString1, -b(paramString2));
      this.b.remove(paramString2);
      if (i <= 0) {
        r.b(paramString1, paramInt, this.c, this.d);
      }
      return m.a.a;
    }
    return m.a.c;
  }
  
  @NotNull
  public Object[] b(int paramInt, @Nullable String paramString)
  {
    Object localObject = Integer.valueOf(0);
    if (paramString == null) {
      return new Object[] { CollectionsKt.emptyList(), localObject, localObject };
    }
    List localList = (List)new ArrayList();
    if (paramInt == 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("__");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(String.valueOf(paramInt));
      ((StringBuilder)localObject).append("__");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("__");
      localObject = ((StringBuilder)localObject).toString();
    }
    String[] arrayOfString = this.b.f();
    if (arrayOfString == null) {
      arrayOfString = new String[0];
    }
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      Intrinsics.checkExpressionValueIsNotNull(str, "key");
      if (StringsKt.startsWith$default(str, (String)localObject, false, 2, null)) {
        localList.add(StringsKt.replace$default(str, (String)localObject, "", false, 4, null));
      }
      i += 1;
    }
    return new Object[] { localList, Integer.valueOf(c(paramInt, paramString)), Integer.valueOf(d(paramInt, paramString)) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.e
 * JD-Core Version:    0.7.0.1
 */