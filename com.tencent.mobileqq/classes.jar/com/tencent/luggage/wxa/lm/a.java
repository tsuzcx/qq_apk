package com.tencent.luggage.wxa.lm;

import android.nfc.NfcAdapter;
import com.tencent.luggage.wxa.qz.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"myNfcAdapter", "Landroid/nfc/NfcAdapter;", "getMyNfcAdapter", "()Landroid/nfc/NfcAdapter;", "map", "", "R", "Lorg/json/JSONArray;", "transform", "Lkotlin/Function1;", "", "mapRecursive", "mapTo", "C", "", "destination", "(Lorg/json/JSONArray;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "mapToRecursive", "", "toMap", "", "", "Lorg/json/JSONObject;", "toMapRecursive", "luggage-commons-jsapi-nfc-ext_release"}, k=2, mv={1, 1, 16})
public final class a
{
  @Nullable
  public static final NfcAdapter a()
  {
    return NfcAdapter.getDefaultAdapter(r.a());
  }
  
  @NotNull
  public static final List<Object> a(@NotNull JSONArray paramJSONArray, @NotNull List<Object> paramList, @NotNull Function1<Object, ? extends Object> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONArray, "$this$mapToRecursive");
    Intrinsics.checkParameterIsNotNull(paramList, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    int j = paramJSONArray.length();
    int i = 0;
    while (i < j)
    {
      Object localObject1 = paramJSONArray.get(i);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "get(index)");
      Object localObject2 = paramFunction1.invoke(localObject1);
      if ((localObject2 instanceof JSONObject))
      {
        localObject1 = a((JSONObject)localObject2, paramFunction1);
      }
      else
      {
        localObject1 = localObject2;
        if ((localObject2 instanceof JSONArray)) {
          localObject1 = a((JSONArray)localObject2, paramFunction1);
        }
      }
      paramList.add(localObject1);
      i += 1;
    }
    return paramList;
  }
  
  @NotNull
  public static final List<Object> a(@NotNull JSONArray paramJSONArray, @NotNull Function1<Object, ? extends Object> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONArray, "$this$mapRecursive");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    return a(paramJSONArray, (List)new ArrayList(paramJSONArray.length()), paramFunction1);
  }
  
  @NotNull
  public static final Map<String, Object> a(@NotNull JSONObject paramJSONObject, @NotNull Function1<Object, ? extends Object> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "$this$toMapRecursive");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramJSONObject.keys();
    Intrinsics.checkExpressionValueIsNotNull(localIterator, "keys()");
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject1 = paramJSONObject.get(str);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "get(it)");
      Object localObject2 = paramFunction1.invoke(localObject1);
      Map localMap = (Map)localHashMap;
      Intrinsics.checkExpressionValueIsNotNull(str, "it");
      if ((localObject2 instanceof JSONObject))
      {
        localObject1 = a((JSONObject)localObject2, paramFunction1);
      }
      else
      {
        localObject1 = localObject2;
        if ((localObject2 instanceof JSONArray)) {
          localObject1 = a((JSONArray)localObject2, paramFunction1);
        }
      }
      localMap.put(str, localObject1);
    }
    return (Map)localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lm.a
 * JD-Core Version:    0.7.0.1
 */