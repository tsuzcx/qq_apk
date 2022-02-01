package com.tencent.luggage.wxa.ny;

import com.tencent.luggage.wxa.jj.s.g;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.List<+TM;>;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/modularizing/WxaRuntimeModularizingUtils;", "", "()V", "TAG", "", "moduleAliases", "", "getModuleAliases", "(Ljava/lang/Object;)[Ljava/lang/String;", "moduleName", "getModuleName", "(Ljava/lang/Object;)Ljava/lang/String;", "findModule", "M", "", "pathOrModule", "message", "print", "", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/Object;", "matchModule", "pathOrModuleName", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)Z", "sortModuleList", "splitPathPartsArray", "(Ljava/lang/String;)[Ljava/lang/String;", "startsWith", "prefixArr", "([Ljava/lang/String;[Ljava/lang/String;)Z", "WxaPkgModuleListMatcherIMPL", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class h
{
  public static final h a = new h();
  
  @JvmStatic
  @JvmOverloads
  @Nullable
  public static final <M> M a(@NotNull List<? extends M> paramList, @NotNull String paramString1, @Nullable String paramString2)
  {
    return a(paramList, paramString1, paramString2, false, 4, null);
  }
  
  @JvmStatic
  @JvmOverloads
  @Nullable
  public static final <M> M a(@NotNull List<? extends M> paramList, @NotNull String paramString1, @Nullable String paramString2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$findModule");
    Intrinsics.checkParameterIsNotNull(paramString1, "pathOrModule");
    Object localObject3 = a.a(paramString1);
    Iterator localIterator = ((Iterable)a(paramList)).iterator();
    for (;;)
    {
      paramBoolean = localIterator.hasNext();
      Object localObject1 = null;
      if (!paramBoolean) {
        break;
      }
      Object localObject2 = localIterator.next();
      if (localObject2 != null)
      {
        paramList = a.a(localObject2);
        if (paramList != null)
        {
          paramList = a.a(paramList);
          if (paramList != null) {
            break label97;
          }
        }
      }
      paramList = new String[0];
      label97:
      if (a.a((String[])localObject3, paramList))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("findModule, hit module by name:");
        paramList = (List<? extends M>)localObject1;
        if (localObject2 != null) {
          paramList = a.a(localObject2);
        }
        ((StringBuilder)localObject3).append(paramList);
        ((StringBuilder)localObject3).append(", path:");
        ((StringBuilder)localObject3).append(paramString1);
        ((StringBuilder)localObject3).append(", message[ ");
        ((StringBuilder)localObject3).append(paramString2);
        ((StringBuilder)localObject3).append(" ]");
        o.d("Luggage.FULL.WxaRuntimeModularizingUtils", ((StringBuilder)localObject3).toString());
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        return localObject2;
      }
      if (localObject2 != null)
      {
        localObject1 = a.b(localObject2);
        if (localObject1 != null)
        {
          int k = localObject1.length;
          int i = 0;
          while (i < k)
          {
            paramList = localObject1[i];
            CharSequence localCharSequence = (CharSequence)paramList;
            int j;
            if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
              j = 0;
            } else {
              j = 1;
            }
            if ((j == 0) && (StringsKt.startsWith$default(paramString1, paramList, false, 2, null)))
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("findModule, hit module by alias:");
              ((StringBuilder)localObject1).append(paramList);
              ((StringBuilder)localObject1).append(", path:");
              ((StringBuilder)localObject1).append(paramString1);
              ((StringBuilder)localObject1).append(", message[ ");
              ((StringBuilder)localObject1).append(paramString2);
              ((StringBuilder)localObject1).append(" ]");
              o.d("Luggage.FULL.WxaRuntimeModularizingUtils", ((StringBuilder)localObject1).toString());
              return localObject2;
            }
            i += 1;
          }
        }
      }
    }
    paramList = new StringBuilder();
    paramList.append("findModule, return null with path:");
    paramList.append(paramString1);
    paramList.append(", message[ ");
    paramList.append(paramString2);
    paramList.append(" ]");
    o.d("Luggage.FULL.WxaRuntimeModularizingUtils", paramList.toString());
    return null;
  }
  
  private final String a(@NotNull Object paramObject)
  {
    if ((paramObject instanceof s.g)) {
      return ((s.g)paramObject).a;
    }
    if ((paramObject instanceof ModulePkgInfo)) {
      return ((ModulePkgInfo)paramObject).name;
    }
    throw ((Throwable)new IllegalStateException("Only WxaAttributes.WxaVersionModuleInfo or ModulePkgInfo supported here.".toString()));
  }
  
  @JvmStatic
  @NotNull
  public static final <M> List<M> a(@NotNull List<? extends M> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$sortModuleList");
    return CollectionsKt.sortedWith((Iterable)paramList, (Comparator)new h.b());
  }
  
  @JvmStatic
  public static final <M> boolean a(M paramM, @NotNull String paramString1, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "pathOrModuleName");
    return Intrinsics.areEqual(a(CollectionsKt.listOf(paramM), paramString1, paramString2, false, 4, null), paramM);
  }
  
  private final boolean a(@NotNull String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    if (paramArrayOfString1.length < paramArrayOfString2.length) {
      return false;
    }
    int j = paramArrayOfString2.length;
    int i = 0;
    while (i < j)
    {
      if ((true ^ Intrinsics.areEqual(paramArrayOfString1[i], paramArrayOfString2[i]))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private final String[] a(@NotNull String paramString)
  {
    int j = ((CharSequence)paramString).length();
    int i = 0;
    while (i < j)
    {
      if (paramString.charAt(i) != '/') {
        break label39;
      }
      i += 1;
    }
    i = 0;
    label39:
    int k = paramString.length();
    j = paramString.length() - 1;
    while ((j >= 0) && (paramString.charAt(j) == '/'))
    {
      k -= 1;
      j -= 1;
    }
    if (paramString != null)
    {
      paramString = paramString.substring(i, k);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      paramString = ((Collection)StringsKt.split$default((CharSequence)paramString, new String[] { "/" }, false, 0, 6, null)).toArray(new String[0]);
      if (paramString != null) {
        return (String[])paramString;
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }
    paramString = new TypeCastException("null cannot be cast to non-null type java.lang.String");
    for (;;)
    {
      throw paramString;
    }
  }
  
  private final String[] b(@NotNull Object paramObject)
  {
    if ((paramObject instanceof s.g)) {
      return ((s.g)paramObject).e;
    }
    if ((paramObject instanceof ModulePkgInfo)) {
      return ((ModulePkgInfo)paramObject).aliases;
    }
    throw ((Throwable)new IllegalStateException("Only WxaAttributes.WxaVersionModuleInfo or ModulePkgInfo supported here.".toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ny.h
 * JD-Core Version:    0.7.0.1
 */