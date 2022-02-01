package com.tencent.luggage.wxa.ku;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.jx.m;
import com.tencent.luggage.wxa.qz.af;
import org.json.JSONObject;

abstract class d
  implements f
{
  private m a;
  
  static {}
  
  @NonNull
  abstract f.a a(c paramc, String paramString, JSONObject paramJSONObject);
  
  @NonNull
  public final f.a a(c paramc, JSONObject paramJSONObject)
  {
    String str = a(paramJSONObject);
    if (af.c(str)) {
      return new f.a("fail invalid path", new Object[0]);
    }
    if ((!paramc.e()) && (!paramc.d())) {
      return new f.a("fail:interrupted", new Object[0]);
    }
    return a(paramc, str, paramJSONObject);
  }
  
  protected String a(@NonNull JSONObject paramJSONObject)
  {
    Object localObject2 = paramJSONObject.optString("filePath", null);
    Object localObject1 = localObject2;
    if (af.c((String)localObject2)) {
      localObject1 = paramJSONObject.optString("dirPath", null);
    }
    localObject2 = localObject1;
    if (af.c((String)localObject1)) {
      localObject2 = paramJSONObject.optString("path", null);
    }
    return localObject2;
  }
  
  void a(m paramm)
  {
    this.a = paramm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ku.d
 * JD-Core Version:    0.7.0.1
 */