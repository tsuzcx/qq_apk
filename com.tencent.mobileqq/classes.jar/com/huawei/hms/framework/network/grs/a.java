package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.b.d;
import com.huawei.hms.framework.network.grs.b.h;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  private static final String a = a.class.getSimpleName();
  private GrsBaseInfo b;
  private com.huawei.hms.framework.network.grs.a.a c;
  private h d;
  
  public a(GrsBaseInfo paramGrsBaseInfo, com.huawei.hms.framework.network.grs.a.a parama, h paramh)
  {
    this.b = paramGrsBaseInfo;
    this.c = parama;
    this.d = paramh;
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
      return paramb;
    }
    return com.huawei.hms.framework.network.grs.local.b.a(paramContext.getPackageName()).a(this.b, paramString1, paramString2);
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
    localHashMap = new HashMap(16);
    if (TextUtils.isEmpty(paramString)) {
      Logger.v(a, "isSpExpire jsonValue is null.");
    }
    for (;;)
    {
      return localHashMap;
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
    }
  }
  
  private Map<String, String> a(String paramString, com.huawei.hms.framework.network.grs.a.b paramb, Context paramContext)
  {
    paramb = this.c.a(this.b, paramString, paramb, paramContext);
    if ((paramb != null) && (!paramb.isEmpty())) {
      return paramb;
    }
    return com.huawei.hms.framework.network.grs.local.b.a(paramContext.getPackageName()).a(this.b, paramString);
  }
  
  public static Map<String, String> a(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    if (TextUtils.isEmpty(paramString1)) {
      Logger.v(a, "isSpExpire jsonValue is null.");
    }
    for (;;)
    {
      return localHashMap;
      try
      {
        paramString1 = new JSONObject(paramString1).getJSONObject(paramString2);
        if (paramString1 == null)
        {
          Logger.v(a, "getServiceNameUrls jsObject null.");
          return localHashMap;
        }
      }
      catch (JSONException paramString1)
      {
        Logger.w(a, "Method{getServiceNameUrls} query url from SP occur an JSONException", paramString1);
        return localHashMap;
      }
      paramString2 = paramString1.keys();
      while (paramString2.hasNext())
      {
        String str = paramString2.next().toString();
        localHashMap.put(str, paramString1.get(str).toString());
      }
    }
  }
  
  public static Map<String, String> a(JSONObject paramJSONObject)
  {
    localHashMap = new HashMap(16);
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
  }
  
  private void a(String paramString, Map<String, String> paramMap, IQueryUrlsCallBack paramIQueryUrlsCallBack, Context paramContext)
  {
    this.d.a(this.b, paramContext, new a.2(this, paramString, paramIQueryUrlsCallBack, paramMap), paramString);
  }
  
  public String a(Context paramContext, String paramString)
  {
    paramContext = this.d.a(this.b, paramContext, paramString);
    if (paramContext == null) {
      return "";
    }
    return paramContext.c();
  }
  
  public String a(String paramString1, String paramString2, Context paramContext)
  {
    com.huawei.hms.framework.network.grs.a.b localb = new com.huawei.hms.framework.network.grs.a.b();
    String str = a(paramString1, paramString2, localb, paramContext);
    if (localb.a()) {
      Logger.v(a, "get unexpired cache localUrl{%s}", new Object[] { str });
    }
    do
    {
      return str;
      paramString1 = a(a(paramContext, paramString1), paramString1, paramString2);
    } while (TextUtils.isEmpty(paramString1));
    Logger.i(a, "get url is from remote server");
    return paramString1;
  }
  
  public Map<String, String> a(String paramString, Context paramContext)
  {
    com.huawei.hms.framework.network.grs.a.b localb = new com.huawei.hms.framework.network.grs.a.b();
    Map localMap = a(paramString, localb, paramContext);
    if (localb.a()) {}
    do
    {
      return localMap;
      paramString = a(a(paramContext, paramString), paramString);
    } while ((paramString == null) || (paramString.isEmpty()));
    return paramString;
  }
  
  public void a(String paramString, IQueryUrlsCallBack paramIQueryUrlsCallBack, Context paramContext)
  {
    com.huawei.hms.framework.network.grs.a.b localb = new com.huawei.hms.framework.network.grs.a.b();
    Map localMap = a(paramString, localb, paramContext);
    if (localb.a())
    {
      if ((localMap == null) || (localMap.isEmpty()))
      {
        paramIQueryUrlsCallBack.onCallBackFail(-5);
        return;
      }
      paramIQueryUrlsCallBack.onCallBackSuccess(localMap);
      return;
    }
    a(paramString, localMap, paramIQueryUrlsCallBack, paramContext);
  }
  
  public void a(String paramString1, String paramString2, IQueryUrlCallBack paramIQueryUrlCallBack, Context paramContext)
  {
    com.huawei.hms.framework.network.grs.a.b localb = new com.huawei.hms.framework.network.grs.a.b();
    String str = a(paramString1, paramString2, localb, paramContext);
    if (localb.a())
    {
      if (TextUtils.isEmpty(str))
      {
        paramIQueryUrlCallBack.onCallBackFail(-5);
        return;
      }
      paramIQueryUrlCallBack.onCallBackSuccess(str);
      return;
    }
    this.d.a(this.b, paramContext, new a.1(this, paramString1, paramString2, paramIQueryUrlCallBack, str), paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.a
 * JD-Core Version:    0.7.0.1
 */