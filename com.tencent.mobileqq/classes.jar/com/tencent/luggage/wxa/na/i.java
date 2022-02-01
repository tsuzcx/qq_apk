package com.tencent.luggage.wxa.na;

import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/live/FileMetaData;", "", "unzipFile", "Lcom/tencent/mm/vfs/VFSFile;", "(Lcom/tencent/mm/vfs/VFSFile;)V", "name", "", "lastModified", "", "(Ljava/lang/String;J)V", "getLastModified", "()J", "getName", "()Ljava/lang/String;", "toJson", "Lorg/json/JSONObject;", "Companion", "luggage-xweb-ext_release"}, k=1, mv={1, 1, 16})
class i
{
  public static final i.a b = new i.a(null);
  @NotNull
  private final String a;
  private final long c;
  
  public i(@NotNull com.tencent.luggage.wxa.rt.i parami)
  {
    this(str, parami.p());
  }
  
  public i(@NotNull String paramString, long paramLong)
  {
    this.a = paramString;
    this.c = paramLong;
  }
  
  @Nullable
  public JSONObject a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("name", this.a);
      localJSONObject.put("lastModified", this.c);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("FileMetaData#toJson, fail since ");
      localStringBuilder.append(localException);
      o.c("MicroMsg.AppBrand.AppBrandResCacheChecker", localStringBuilder.toString());
    }
    return null;
  }
  
  @NotNull
  public final String c()
  {
    return this.a;
  }
  
  public final long d()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.na.i
 * JD-Core Version:    0.7.0.1
 */