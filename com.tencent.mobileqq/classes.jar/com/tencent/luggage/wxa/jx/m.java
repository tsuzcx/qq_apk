package com.tencent.luggage.wxa.jx;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.util.g;
import com.tencent.luggage.wxa.pd.p;
import com.tencent.luggage.wxa.pd.p.a;
import com.tencent.luggage.wxa.pd.p.b;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.jsruntime.k;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public abstract class m
  extends b
{
  private boolean a = false;
  
  protected String a()
  {
    return "errMsg";
  }
  
  public final String a(c paramc, String paramString, Map<String, ? extends Object> paramMap)
  {
    if (p.a(paramc.getJsRuntime(), paramMap, (p.a)paramc.b(p.a.class)) == p.b.b) {
      return b("fail:convert native buffer parameter fail. native buffer exceed size limit.");
    }
    return a(paramString, paramMap);
  }
  
  public String a(@NonNull String paramString, @Nullable Map<String, ? extends Object> paramMap)
  {
    String str = paramString;
    if ("cancel".equals(paramString)) {
      str = "fail cancel";
    }
    if ((!str.startsWith("fail")) && (!str.startsWith("ok")))
    {
      paramString = String.format(Locale.ENGLISH, "api[%s] assert, argument [reason] must start with special prefix", new Object[] { d() });
      if (!this.a) {
        o.b("MicroMsg.AppBrandJsApi", paramString);
      } else {
        throw new IllegalArgumentException(paramString);
      }
    }
    if ((paramMap instanceof HashMap)) {
      paramString = paramMap;
    } else {
      paramString = new HashMap();
    }
    if ((paramMap != null) && (paramMap.containsKey(a())))
    {
      paramMap = new StringBuilder();
      paramMap.append("api ");
      paramMap.append(d());
      paramMap.append(": Cant put errMsg in res!!!");
      paramMap = paramMap.toString();
      if (!this.a) {
        o.b("MicroMsg.AppBrandJsApi", paramMap);
      } else {
        throw new IllegalArgumentException(paramMap);
      }
    }
    paramMap = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(d());
    localStringBuilder.append(":");
    localStringBuilder.append(str);
    paramString.put(paramMap, localStringBuilder.toString());
    g.a(paramString);
    return new JSONObject(paramString).toString();
  }
  
  public String a(@NonNull String paramString, @Nullable JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    if (localJSONObject.has(a()))
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("api ");
      paramJSONObject.append(d());
      paramJSONObject.append(": Cant put errMsg in res!!!");
      paramJSONObject = paramJSONObject.toString();
      if (!this.a) {
        o.b("MicroMsg.AppBrandJsApi", paramJSONObject);
      } else {
        throw new IllegalArgumentException(paramJSONObject);
      }
    }
    try
    {
      paramJSONObject = a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(d());
      localStringBuilder.append(":");
      localStringBuilder.append(paramString);
      localJSONObject.put(paramJSONObject, localStringBuilder.toString());
    }
    catch (Exception paramString)
    {
      o.b("MicroMsg.AppBrandJsApi", "makeReturnJson with JSONObject, put errMsg, e=%s", new Object[] { paramString });
    }
    return localJSONObject.toString();
  }
  
  public ByteBuffer a(String paramString, k paramk, int paramInt)
  {
    return paramk.a(paramInt, false);
  }
  
  public final String b(@NonNull String paramString)
  {
    return a(paramString, (JSONObject)null);
  }
  
  public boolean e()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.m
 * JD-Core Version:    0.7.0.1
 */