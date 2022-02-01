package com.tencent.luggage.wxa.na;

import com.tencent.luggage.wxa.qz.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/live/DirMetaData$Companion;", "", "()V", "create", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/live/DirMetaData;", "unzipDir", "Lcom/tencent/mm/vfs/VFSFile;", "fromJson", "json", "Lorg/json/JSONObject;", "luggage-xweb-ext_release"}, k=1, mv={1, 1, 16})
public final class h$a
{
  @Nullable
  public final h a(@NotNull com.tencent.luggage.wxa.rt.i parami)
  {
    Intrinsics.checkParameterIsNotNull(parami, "unzipDir");
    if (parami.n()) {
      return new h(parami);
    }
    return null;
  }
  
  @Nullable
  public final h a(@NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "json");
    try
    {
      localObject1 = paramJSONObject.getJSONArray("subMetas");
      Object localObject3 = (Iterable)RangesKt.until(0, ((JSONArray)localObject1).length());
      Object localObject2 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject2).add(((JSONArray)localObject1).getJSONObject(((IntIterator)localObject3).nextInt()));
      }
      localObject2 = (Iterable)localObject2;
      localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (JSONObject)((Iterator)localObject2).next();
        i.a locala = i.b;
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "it");
        localObject3 = locala.a((JSONObject)localObject3);
        if (localObject3 == null) {
          Intrinsics.throwNpe();
        }
        ((Collection)localObject1).add(localObject3);
      }
      localObject1 = (List)localObject1;
      localObject2 = paramJSONObject.getString("name");
      long l = paramJSONObject.getLong("lastModified");
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "name");
      paramJSONObject = new h((String)localObject2, l, (List)localObject1, null);
      return paramJSONObject;
    }
    catch (Exception paramJSONObject)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("DirMetaData#fromJsonFile, fail since ");
      ((StringBuilder)localObject1).append(paramJSONObject);
      o.c("MicroMsg.AppBrand.AppBrandResCacheChecker", ((StringBuilder)localObject1).toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.na.h.a
 * JD-Core Version:    0.7.0.1
 */