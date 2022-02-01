package com.tencent.luggage.wxa.na;

import com.tencent.luggage.wxa.qz.o;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/live/DirMetaData;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/live/FileMetaData;", "unzipDir", "Lcom/tencent/mm/vfs/VFSFile;", "(Lcom/tencent/mm/vfs/VFSFile;)V", "name", "", "lastModified", "", "subMetas", "", "(Ljava/lang/String;JLjava/util/List;)V", "getSubMetas", "()Ljava/util/List;", "toJson", "Lorg/json/JSONObject;", "Companion", "luggage-xweb-ext_release"}, k=1, mv={1, 1, 16})
final class h
  extends i
{
  public static final h.a a = new h.a(null);
  @NotNull
  private final List<i> c;
  
  public h(@NotNull com.tencent.luggage.wxa.rt.i parami)
  {
    this(str, l, (List)localCollection);
  }
  
  private h(String paramString, long paramLong, List<? extends i> paramList)
  {
    super(paramString, paramLong);
    this.c = paramList;
  }
  
  @Nullable
  public JSONObject a()
  {
    try
    {
      JSONObject localJSONObject = super.a();
      if (localJSONObject != null)
      {
        localObject = new JSONArray();
        Iterator localIterator = ((Iterable)this.c).iterator();
        while (localIterator.hasNext()) {
          ((JSONArray)localObject).put(((i)localIterator.next()).a());
        }
        localJSONObject.put("subMetas", localObject);
        return localJSONObject;
      }
    }
    catch (Exception localException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("DirMetaData#toJson, fail since ");
      ((StringBuilder)localObject).append(localException);
      o.c("MicroMsg.AppBrand.AppBrandResCacheChecker", ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  @NotNull
  public final List<i> b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.na.h
 * JD-Core Version:    0.7.0.1
 */