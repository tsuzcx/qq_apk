package com.tencent.biz.pubaccount.ecshopassit;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewplugin.BusinessReportPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import lai;
import org.json.JSONArray;
import org.json.JSONObject;

public class BusinessReporter
{
  private static List a;
  private static List b;
  
  public static void a()
  {
    if ((b != null) || (a != null)) {}
    do
    {
      return;
      b = new ArrayList();
      a = new ArrayList();
      localObject1 = new File(EcShopAssistantManager.f);
    } while ((!((File)localObject1).exists()) || (!((File)localObject1).isFile()));
    Object localObject1 = FileUtils.a((File)localObject1);
    for (;;)
    {
      int i;
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        i = 0;
        if (i >= ((JSONArray)localObject1).length()) {
          break;
        }
        Object localObject2 = ((JSONArray)localObject1).getJSONObject(0);
        if (((JSONObject)localObject2).getInt("repflag") != 0)
        {
          Object localObject3 = new ArrayList();
          HashMap localHashMap = new HashMap();
          JSONArray localJSONArray = ((JSONObject)localObject2).getJSONArray("entrance");
          int j = 0;
          if (j < localJSONArray.length())
          {
            ((List)localObject3).add(localJSONArray.getString(j));
            j += 1;
            continue;
          }
          a.add(localObject3);
          localObject2 = ((JSONObject)localObject2).getJSONArray("report");
          j = 0;
          if (j < ((JSONArray)localObject2).length())
          {
            localObject3 = ((JSONArray)localObject2).getJSONObject(j);
            localHashMap.put(((JSONObject)localObject3).getString("urlprefix"), Integer.valueOf(((JSONObject)localObject3).getInt("tvalue")));
            j += 1;
            continue;
          }
          b.add(localHashMap);
        }
      }
      catch (Exception localException)
      {
        QLog.e("BusinessReporter", 1, "parse report json error:" + localException);
        return;
      }
      i += 1;
    }
  }
  
  public static void a(CustomWebView paramCustomWebView)
  {
    String str;
    WebViewPlugin localWebViewPlugin;
    if ((paramCustomWebView != null) && (paramCustomWebView.a() != null))
    {
      str = paramCustomWebView.getUrl();
      paramCustomWebView = paramCustomWebView.a();
      localWebViewPlugin = paramCustomWebView.a("JD_REPORT");
      if (localWebViewPlugin != null) {
        break label75;
      }
      if (a()) {
        break label54;
      }
      ThreadManager.post(new lai(str, paramCustomWebView), 5, null, true);
    }
    label54:
    while (!a(str)) {
      return;
    }
    paramCustomWebView.a(new String[] { "JD_REPORT" });
    return;
    label75:
    ((BusinessReportPlugin)localWebViewPlugin).b(str);
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    if ((!(paramAppInterface instanceof BrowserAppInterface)) || (TextUtils.isEmpty(paramString1)) || (b == null)) {}
    String str;
    do
    {
      return;
      str = Uri.parse(paramString2).getHost();
    } while (TextUtils.isEmpty(str));
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    Object localObject1 = null;
    Object localObject2 = localObject1;
    if (i < a.size())
    {
      localObject2 = ((List)a.get(i)).iterator();
      while (((Iterator)localObject2).hasNext()) {
        if (str.contains((String)((Iterator)localObject2).next())) {
          localObject1 = (Map)b.get(i);
        }
      }
    }
    for (int j = 1;; j = 0)
    {
      if (j != 0)
      {
        localObject2 = localObject1;
        if ((localObject2 == null) || (((Map)localObject2).isEmpty())) {
          break;
        }
        localObject1 = ((Map)localObject2).entrySet().iterator();
      }
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label346;
        }
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        str = (String)((Map.Entry)localObject2).getKey();
        i = ((Integer)((Map.Entry)localObject2).getValue()).intValue();
        if (!TextUtils.isEmpty(str))
        {
          if (paramString1.startsWith("https://" + str))
          {
            localObject2 = (EcshopReportHandler)paramAppInterface.getBusinessHandler(0);
            if (localObject2 == null) {
              break label339;
            }
            ((EcshopReportHandler)localObject2).a(i, null, paramString2, null, null, 0L, false);
            return;
            i += 1;
            break;
          }
          localStringBuilder.setLength(0);
          if (paramString1.startsWith("http://" + str))
          {
            localObject2 = (EcshopReportHandler)paramAppInterface.getBusinessHandler(0);
            if (localObject2 != null)
            {
              ((EcshopReportHandler)localObject2).a(i, null, paramString2, null, null, 0L, false);
              return;
            }
          }
          label339:
          localStringBuilder.setLength(0);
        }
      }
      label346:
      break;
    }
  }
  
  public static boolean a()
  {
    return a != null;
  }
  
  public static boolean a(String paramString)
  {
    if ((a == null) || (a.isEmpty()) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    paramString = Uri.parse(paramString).getHost();
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Iterator localIterator2;
    do
    {
      Iterator localIterator1 = a.iterator();
      while (!localIterator2.hasNext())
      {
        if (!localIterator1.hasNext()) {
          break;
        }
        localIterator2 = ((List)localIterator1.next()).iterator();
      }
    } while (!paramString.contains((String)localIterator2.next()));
    return true;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.BusinessReporter
 * JD-Core Version:    0.7.0.1
 */