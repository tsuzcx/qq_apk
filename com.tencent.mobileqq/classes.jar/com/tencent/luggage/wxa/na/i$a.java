package com.tencent.luggage.wxa.na;

import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/live/FileMetaData$Companion;", "", "()V", "create", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/live/FileMetaData;", "unzipFile", "Lcom/tencent/mm/vfs/VFSFile;", "fromJson", "json", "Lorg/json/JSONObject;", "fromJsonFile", "luggage-xweb-ext_release"}, k=1, mv={1, 1, 16})
public final class i$a
{
  private final i b(JSONObject paramJSONObject)
  {
    try
    {
      localObject = paramJSONObject.getString("name");
      long l = paramJSONObject.getLong("lastModified");
      Intrinsics.checkExpressionValueIsNotNull(localObject, "name");
      paramJSONObject = new i((String)localObject, l);
      return paramJSONObject;
    }
    catch (Exception paramJSONObject)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("FileMetaData#fromJsonFile, fail since ");
      ((StringBuilder)localObject).append(paramJSONObject);
      o.c("MicroMsg.AppBrand.AppBrandResCacheChecker", ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  @NotNull
  public final i a(@NotNull com.tencent.luggage.wxa.rt.i parami)
  {
    Intrinsics.checkParameterIsNotNull(parami, "unzipFile");
    if (parami.n())
    {
      parami = h.a.a(parami);
      if (parami == null) {
        Intrinsics.throwNpe();
      }
      return (i)parami;
    }
    return new i(parami);
  }
  
  @Nullable
  public final i a(@NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "json");
    if (paramJSONObject.has("subMetas")) {
      return (i)h.a.a(paramJSONObject);
    }
    return ((a)this).b(paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.na.i.a
 * JD-Core Version:    0.7.0.1
 */