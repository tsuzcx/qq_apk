package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.c.f;
import com.huawei.hms.framework.network.grs.c.m;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  private static final String a = "a";
  private GrsBaseInfo b;
  private com.huawei.hms.framework.network.grs.a.a c;
  private m d;
  private com.huawei.hms.framework.network.grs.a.c e;
  
  public a(GrsBaseInfo paramGrsBaseInfo, com.huawei.hms.framework.network.grs.a.a parama, m paramm, com.huawei.hms.framework.network.grs.a.c paramc)
  {
    this.b = paramGrsBaseInfo;
    this.c = parama;
    this.d = paramm;
    this.e = paramc;
  }
  
  public static CountryCodeBean a(Context paramContext, boolean paramBoolean)
  {
    return new CountryCodeBean(paramContext, paramBoolean);
  }
  
  private String a(String paramString1, String paramString2, com.huawei.hms.framework.network.grs.a.b paramb, Context paramContext)
  {
    paramb = this.c.a(this.b, paramString1, paramString2, paramb, paramContext);
    if (!TextUtils.isEmpty(paramb))
    {
      Logger.i(a, "get url from sp is not empty.");
      com.huawei.hms.framework.network.grs.b.b.a(paramContext, this.b);
      return paramb;
    }
    return com.huawei.hms.framework.network.grs.b.b.a(paramContext.getPackageName(), this.b).a(paramContext, this.c, this.b, paramString1, paramString2, false);
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return "";
    }
    try
    {
      paramString1 = new JSONObject(paramString1).getJSONObject(paramString2).getString(paramString3);
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      Logger.w(a, "Method{getServiceNameUrl} query url from SP occur an JSONException", paramString1);
    }
    return "";
  }
  
  public static Map<String, Map<String, String>> a(String paramString)
  {
    HashMap localHashMap = new HashMap(16);
    if (TextUtils.isEmpty(paramString))
    {
      Logger.v(a, "isSpExpire jsonValue is null.");
      return localHashMap;
    }
    try
    {
      paramString = new JSONObject(paramString);
      Iterator localIterator = paramString.keys();
      while (localIterator.hasNext())
      {
        String str = localIterator.next().toString();
        localHashMap.put(str, a(paramString.getJSONObject(str)));
      }
      return localHashMap;
    }
    catch (JSONException paramString)
    {
      Logger.w(a, "getServicesUrlsMap occur a JSONException", paramString);
    }
    return localHashMap;
  }
  
  private Map<String, String> a(String paramString, com.huawei.hms.framework.network.grs.a.b paramb, Context paramContext)
  {
    paramb = this.c.a(this.b, paramString, paramb, paramContext);
    if ((paramb != null) && (!paramb.isEmpty()))
    {
      Logger.i(a, "get url from sp is not empty.");
      com.huawei.hms.framework.network.grs.b.b.a(paramContext, this.b);
      return paramb;
    }
    return com.huawei.hms.framework.network.grs.b.b.a(paramContext.getPackageName(), this.b).a(paramContext, this.c, this.b, paramString, false);
  }
  
  public static Map<String, String> a(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    if (TextUtils.isEmpty(paramString1))
    {
      Logger.v(a, "isSpExpire jsonValue is null.");
      return localHashMap;
    }
    try
    {
      paramString1 = new JSONObject(paramString1).getJSONObject(paramString2);
      if (paramString1 == null)
      {
        paramString1 = a;
        Logger.v(paramString1, "getServiceNameUrls jsObject null.");
        return localHashMap;
      }
      paramString2 = paramString1.keys();
      while (paramString2.hasNext())
      {
        String str = paramString2.next().toString();
        localHashMap.put(str, paramString1.get(str).toString());
      }
      return localHashMap;
    }
    catch (JSONException paramString1)
    {
      Logger.w(a, "Method{getServiceNameUrls} query url from SP occur an JSONException", paramString1);
    }
    return localHashMap;
  }
  
  public static Map<String, String> a(JSONObject paramJSONObject)
  {
    HashMap localHashMap = new HashMap(16);
    try
    {
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = localIterator.next().toString();
        localHashMap.put(str, paramJSONObject.get(str).toString());
      }
      return localHashMap;
    }
    catch (JSONException paramJSONObject)
    {
      Logger.w(a, "getServiceUrls occur a JSONException", paramJSONObject);
    }
    return localHashMap;
  }
  
  private void a(String paramString, Map<String, String> paramMap, IQueryUrlsCallBack paramIQueryUrlsCallBack, Context paramContext)
  {
    com.huawei.hms.framework.network.grs.c.b.c localc = new com.huawei.hms.framework.network.grs.c.b.c(this.b, paramContext);
    this.d.a(localc, new a.a(paramString, paramMap, paramIQueryUrlsCallBack, paramContext, this.b, this.c), paramString, this.e);
  }
  
  public String a(Context paramContext, String paramString)
  {
    paramContext = this.d.a(new com.huawei.hms.framework.network.grs.c.b.c(this.b, paramContext), paramString, this.e);
    if (paramContext == null) {
      return "";
    }
    return paramContext.i();
  }
  
  public String a(String paramString1, String paramString2, Context paramContext)
  {
    Object localObject = new com.huawei.hms.framework.network.grs.a.b();
    String str = a(paramString1, paramString2, (com.huawei.hms.framework.network.grs.a.b)localObject, paramContext);
    if ((((com.huawei.hms.framework.network.grs.a.b)localObject).a()) && (!TextUtils.isEmpty(str)))
    {
      Logger.v(a, "get unexpired cache localUrl{%s}", new Object[] { str });
      com.huawei.hms.framework.network.grs.b.b.a(paramContext, this.b);
      return str;
    }
    localObject = a(a(paramContext, paramString1), paramString1, paramString2);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      Logger.i(a, "get url is from remote server");
      com.huawei.hms.framework.network.grs.b.b.a(paramContext, this.b);
      return localObject;
    }
    localObject = str;
    if (TextUtils.isEmpty(str))
    {
      Logger.i(a, "access local config for return a domain.");
      localObject = com.huawei.hms.framework.network.grs.b.b.a(paramContext.getPackageName(), this.b).a(paramContext, this.c, this.b, paramString1, paramString2, true);
    }
    return localObject;
  }
  
  public Map<String, String> a(String paramString, Context paramContext)
  {
    Object localObject = new com.huawei.hms.framework.network.grs.a.b();
    Map localMap = a(paramString, (com.huawei.hms.framework.network.grs.a.b)localObject, paramContext);
    if ((((com.huawei.hms.framework.network.grs.a.b)localObject).a()) && (localMap != null) && (!localMap.isEmpty()))
    {
      com.huawei.hms.framework.network.grs.b.b.a(paramContext, this.b);
      return localMap;
    }
    localObject = a(a(paramContext, paramString), paramString);
    if (!((Map)localObject).isEmpty())
    {
      com.huawei.hms.framework.network.grs.b.b.a(paramContext, this.b);
      return localObject;
    }
    localObject = localMap;
    if (localMap != null)
    {
      localObject = localMap;
      if (localMap.isEmpty())
      {
        Logger.i(a, "access local config for return a domain.");
        localObject = com.huawei.hms.framework.network.grs.b.b.a(paramContext.getPackageName(), this.b).a(paramContext, this.c, this.b, paramString, true);
      }
    }
    return localObject;
  }
  
  public void a(String paramString, IQueryUrlsCallBack paramIQueryUrlsCallBack, Context paramContext)
  {
    com.huawei.hms.framework.network.grs.a.b localb = new com.huawei.hms.framework.network.grs.a.b();
    Map localMap = a(paramString, localb, paramContext);
    if (localb.a())
    {
      if ((localMap != null) && (!localMap.isEmpty()))
      {
        com.huawei.hms.framework.network.grs.b.b.a(paramContext, this.b);
        paramIQueryUrlsCallBack.onCallBackSuccess(localMap);
        return;
      }
      paramIQueryUrlsCallBack.onCallBackFail(-5);
      return;
    }
    a(paramString, localMap, paramIQueryUrlsCallBack, paramContext);
  }
  
  public void a(String paramString1, String paramString2, IQueryUrlCallBack paramIQueryUrlCallBack, Context paramContext)
  {
    Object localObject = new com.huawei.hms.framework.network.grs.a.b();
    String str = a(paramString1, paramString2, (com.huawei.hms.framework.network.grs.a.b)localObject, paramContext);
    if (((com.huawei.hms.framework.network.grs.a.b)localObject).a())
    {
      if (TextUtils.isEmpty(str))
      {
        paramIQueryUrlCallBack.onCallBackFail(-5);
        return;
      }
      com.huawei.hms.framework.network.grs.b.b.a(paramContext, this.b);
      paramIQueryUrlCallBack.onCallBackSuccess(str);
      return;
    }
    localObject = new com.huawei.hms.framework.network.grs.c.b.c(this.b, paramContext);
    this.d.a((com.huawei.hms.framework.network.grs.c.b.c)localObject, new a.b(paramString1, paramString2, paramIQueryUrlCallBack, str, paramContext, this.b, this.c), paramString1, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.a
 * JD-Core Version:    0.7.0.1
 */