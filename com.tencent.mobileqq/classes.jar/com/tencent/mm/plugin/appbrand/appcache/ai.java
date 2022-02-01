package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.ArrayMap;
import android.util.ArrayMap<Lcom.tencent.mm.plugin.appbrand.appcache.ai.c.b;Ljava.util.LinkedList<Lcom.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;>;>;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap;", "Landroid/os/Parcelable;", "p", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "isEmpty", "", "()Z", "mPrimaryMap", "Landroid/util/ArrayMap;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap$Namespace$MODULE;", "", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPluginPkgInfo;", "mSecondaryMap", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap$Namespace$PLUGIN;", "Ljava/util/LinkedList;", "size", "", "getSize", "()I", "describeContents", "getPluginList", "moduleName", "", "mergeUpdatedPlugin", "", "updated", "putPluginList", "list", "setupMapping", "writeToParcel", "dest", "flags", "addPluginInfoInstance", "plugin", "createModuleMappedPluginList", "writeModuleMappedPluginList", "Companion", "Namespace", "luggage-wxa-app_release"}, k=1, mv={1, 1, 16})
public final class ai
  implements Parcelable
{
  @JvmField
  @NotNull
  public static final Parcelable.Creator<ai> CREATOR = (Parcelable.Creator)new ai.b();
  public static final ai.a a = new ai.a(null);
  private final ArrayMap<ai.c.a, List<WxaPluginPkgInfo>> b;
  private ArrayMap<ai.c.b, LinkedList<WxaPluginPkgInfo>> c;
  
  public ai()
  {
    this.b = new ArrayMap();
  }
  
  public ai(@NotNull Parcel paramParcel)
  {
    int j = paramParcel.readInt();
    this.b = new ArrayMap(j);
    this.c = new ArrayMap();
    int i = 0;
    while (i < j)
    {
      String str = paramParcel.readString();
      if (str == null) {
        Intrinsics.throwNpe();
      }
      List localList = a(paramParcel);
      ((Map)this.b).put(new ai.c.a(str), localList);
      i += 1;
    }
  }
  
  private final List<WxaPluginPkgInfo> a(@NotNull Parcel paramParcel)
  {
    LinkedList localLinkedList = new LinkedList();
    int j = paramParcel.readInt();
    int i = 0;
    while (i < j)
    {
      WxaPluginPkgInfo localWxaPluginPkgInfo = (WxaPluginPkgInfo)WxaPluginPkgInfo.CREATOR.createFromParcel(paramParcel);
      ArrayMap localArrayMap = this.c;
      if (localArrayMap == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mSecondaryMap");
      }
      Intrinsics.checkExpressionValueIsNotNull(localWxaPluginPkgInfo, "p");
      a(localArrayMap, localWxaPluginPkgInfo);
      localLinkedList.add(localWxaPluginPkgInfo);
      i += 1;
    }
    return (List)localLinkedList;
  }
  
  private final void a(@NotNull Parcel paramParcel, List<? extends WxaPluginPkgInfo> paramList)
  {
    paramParcel.writeInt(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((WxaPluginPkgInfo)paramList.next()).writeToParcel(paramParcel, 0);
    }
  }
  
  private final void a(@NotNull ArrayMap<ai.c.b, LinkedList<WxaPluginPkgInfo>> paramArrayMap, WxaPluginPkgInfo paramWxaPluginPkgInfo)
  {
    Object localObject = paramWxaPluginPkgInfo.provider;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "plugin.provider");
    ai.c.b localb = new ai.c.b((String)localObject);
    localObject = (LinkedList)paramArrayMap.get(localb);
    if (localObject != null)
    {
      paramArrayMap = (ArrayMap<ai.c.b, LinkedList<WxaPluginPkgInfo>>)localObject;
    }
    else
    {
      localObject = new LinkedList();
      ((Map)paramArrayMap).put(localb, localObject);
      paramArrayMap = (ArrayMap<ai.c.b, LinkedList<WxaPluginPkgInfo>>)localObject;
    }
    Intrinsics.checkExpressionValueIsNotNull(paramArrayMap, "this[namespace] ?: Linke… { this[namespace] = it }");
    paramArrayMap.add(paramWxaPluginPkgInfo);
  }
  
  @Nullable
  public final List<WxaPluginPkgInfo> a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "moduleName");
    return (List)this.b.get(new ai.c.a(paramString));
  }
  
  public final void a(@NotNull WxaPluginPkgInfo paramWxaPluginPkgInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramWxaPluginPkgInfo, "updated");
    Object localObject1 = this.c;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSecondaryMap");
    }
    Object localObject2 = paramWxaPluginPkgInfo.provider;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "updated.provider");
    localObject1 = (LinkedList)((ArrayMap)localObject1).get(new ai.c.b((String)localObject2));
    if (localObject1 != null)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (WxaPluginPkgInfo)((Iterator)localObject1).next();
        if (paramWxaPluginPkgInfo.isAssignable((WxaPluginPkgInfo)localObject2))
        {
          ((WxaPluginPkgInfo)localObject2).pkgPath = paramWxaPluginPkgInfo.pkgPath;
          ((WxaPluginPkgInfo)localObject2).md5 = paramWxaPluginPkgInfo.md5;
          ((WxaPluginPkgInfo)localObject2).stringVersion = paramWxaPluginPkgInfo.stringVersion;
        }
      }
    }
  }
  
  public final void a(@NotNull String paramString, @Nullable List<? extends WxaPluginPkgInfo> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "moduleName");
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      ((Map)this.b).put(new ai.c.a(paramString), paramList);
    }
  }
  
  public final boolean a()
  {
    return b() <= 0;
  }
  
  public final int b()
  {
    return this.b.size();
  }
  
  public final void c()
  {
    if (((ai)this).c == null)
    {
      this.c = new ArrayMap();
      Object localObject1 = this.b.values();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "mPrimaryMap.values");
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (List)((Iterator)localObject1).next();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "list");
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          WxaPluginPkgInfo localWxaPluginPkgInfo = (WxaPluginPkgInfo)((Iterator)localObject2).next();
          ArrayMap localArrayMap = this.c;
          if (localArrayMap == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSecondaryMap");
          }
          a(localArrayMap, localWxaPluginPkgInfo);
        }
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "dest");
    paramParcel.writeInt(this.b.size());
    Iterator localIterator = ((Map)this.b).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      ai.c.a locala = (ai.c.a)((Map.Entry)localObject).getKey();
      localObject = (List)((Map.Entry)localObject).getValue();
      paramParcel.writeString(locala.a());
      Intrinsics.checkExpressionValueIsNotNull(localObject, "value");
      a(paramParcel, (List)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ai
 * JD-Core Version:    0.7.0.1
 */