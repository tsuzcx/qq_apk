package com.tencent.luggage.wxa.ef;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/sdk/wxa_ktx/JSONUtils;", "", "()V", "copy", "Lorg/json/JSONObject;", "toMap", "", "", "luggage-wxa-app_release"}, k=1, mv={1, 1, 16})
public final class c
{
  public static final c a = new c();
  
  @JvmStatic
  @NotNull
  public static final JSONObject a(@NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "$this$copy");
    String[] arrayOfString = new String[paramJSONObject.length()];
    Iterator localIterator = paramJSONObject.keys();
    Intrinsics.checkExpressionValueIsNotNull(localIterator, "this.keys()");
    localIterator = CollectionsKt.withIndex(localIterator);
    while (localIterator.hasNext())
    {
      IndexedValue localIndexedValue = (IndexedValue)localIterator.next();
      arrayOfString[localIndexedValue.component1()] = ((String)localIndexedValue.component2());
    }
    return new JSONObject(paramJSONObject, arrayOfString);
  }
  
  @JvmStatic
  @NotNull
  public static final Map<String, Object> b(@NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "$this$toMap");
    HashMap localHashMap = new HashMap(paramJSONObject.length());
    Iterator localIterator = paramJSONObject.keys();
    Intrinsics.checkExpressionValueIsNotNull(localIterator, "this.keys()");
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramJSONObject.get(str);
      Map localMap;
      if ((localObject instanceof JSONObject))
      {
        localMap = (Map)localHashMap;
        Intrinsics.checkExpressionValueIsNotNull(str, "it");
        localMap.put(str, b((JSONObject)localObject));
      }
      else
      {
        localMap = (Map)localHashMap;
        Intrinsics.checkExpressionValueIsNotNull(str, "it");
        localMap.put(str, localObject);
      }
    }
    return (Map)localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ef.c
 * JD-Core Version:    0.7.0.1
 */