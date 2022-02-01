package com.tencent.luggage.opensdk;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.hz.a;
import com.tencent.luggage.wxa.jx.h;
import com.tencent.luggage.wxa.rt.i;
import com.tencent.luggage.wxa.rt.k;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import java.io.File;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class OpenSDKApiContentProvider
  extends c
{
  private static final String[] a = new String[1];
  
  private static String a()
  {
    try
    {
      if (a[0] != null)
      {
        localObject1 = a[0];
        return localObject1;
      }
      a[0] = a.g();
      Object localObject1 = new i(a[0]);
      k.g(a[0]);
      k.m(a[0]);
      String str = ((i)localObject1).l();
      localObject1 = str;
      if (!str.endsWith("/"))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(str);
        ((StringBuilder)localObject1).append("/");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      a[0] = localObject1;
      return localObject1;
    }
    finally {}
  }
  
  private static String a(h paramh, String paramString)
  {
    Object localObject2 = paramh.getFileSystem().g(paramString);
    if (localObject2 != null)
    {
      Object localObject1 = ((i)localObject2).l();
      paramString = (String)localObject1;
      if (!c((String)localObject1))
      {
        paramString = a((String)localObject1);
        k.b(((i)localObject2).l(), paramString);
      }
      localObject1 = paramh.getContext();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramh.getContext().getPackageName());
      ((StringBuilder)localObject2).append(".openapidata");
      paramString = c.a((Context)localObject1, ((StringBuilder)localObject2).toString(), new File(paramString));
      paramh.getContext().grantUriPermission("com.tencent.mm", paramString, 1);
      return paramString.toString();
    }
    com.tencent.luggage.wxa.qz.o.b("MicroMsg.OpenSDKApiContentProvider", "wxFilePath:%s is null", new Object[] { paramString });
    return paramString;
  }
  
  public static String a(String paramString)
  {
    String str = com.tencent.luggage.wxa.gl.c.a(paramString.getBytes());
    Object localObject = b(paramString);
    paramString = (String)localObject;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramString = (String)localObject;
      if (!((String)localObject).startsWith("."))
      {
        paramString = new StringBuilder();
        paramString.append(".");
        paramString.append((String)localObject);
        paramString = paramString.toString();
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(a());
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(paramString);
    return ((StringBuilder)localObject).toString();
  }
  
  public static void a(h paramh, JSONObject paramJSONObject)
  {
    Iterator localIterator = paramJSONObject.keys();
    for (;;)
    {
      int i;
      try
      {
        if (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          Object localObject1 = paramJSONObject.get(str1);
          boolean bool = localObject1 instanceof String;
          if (bool)
          {
            localObject1 = (String)localObject1;
            if ((!d((String)localObject1)) && ((!ad.d(paramh.q(), (String)localObject1)) || (((String)localObject1).endsWith(".html")))) {
              continue;
            }
            paramJSONObject.put(str1, a(paramh, (String)localObject1));
            continue;
          }
          if (!(localObject1 instanceof JSONArray)) {
            continue;
          }
          localObject1 = (JSONArray)localObject1;
          JSONArray localJSONArray = new JSONArray();
          i = 0;
          if (i < ((JSONArray)localObject1).length())
          {
            Object localObject2 = ((JSONArray)localObject1).opt(i);
            if ((localObject2 instanceof String))
            {
              String str2 = (String)localObject2;
              if ((!d(str2)) && ((!ad.d(paramh.q(), str2)) || (str2.endsWith(".html")))) {
                localJSONArray.put(localObject2);
              } else {
                localJSONArray.put(i, a(paramh, str2));
              }
            }
            else
            {
              localJSONArray.put(localObject2);
            }
          }
          else
          {
            paramJSONObject.put(str1, localJSONArray.toString());
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramh)
      {
        com.tencent.luggage.wxa.qz.o.a("MicroMsg.OpenSDKApiContentProvider", paramh, "", new Object[0]);
      }
      i += 1;
    }
  }
  
  @NonNull
  private static String b(String paramString)
  {
    int i = paramString.lastIndexOf('.');
    if (i != -1) {
      return paramString.substring(i);
    }
    return "";
  }
  
  private static boolean c(String paramString)
  {
    return (paramString != null) && (paramString.startsWith(a()));
  }
  
  private static boolean d(String paramString)
  {
    return (paramString != null) && (paramString.startsWith("wxfile://"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.OpenSDKApiContentProvider
 * JD-Core Version:    0.7.0.1
 */