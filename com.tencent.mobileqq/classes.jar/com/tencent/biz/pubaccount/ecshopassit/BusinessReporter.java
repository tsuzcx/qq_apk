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
import org.json.JSONArray;
import org.json.JSONObject;

public class BusinessReporter
{
  private static List<List<String>> a;
  private static List<Map<String, Integer>> b;
  
  public static void a(CustomWebView paramCustomWebView)
  {
    if ((paramCustomWebView != null) && (paramCustomWebView.getPluginEngine() != null))
    {
      String str = paramCustomWebView.getUrl();
      paramCustomWebView = paramCustomWebView.getPluginEngine();
      WebViewPlugin localWebViewPlugin = paramCustomWebView.b("JD_REPORT");
      if (localWebViewPlugin == null)
      {
        if (!a())
        {
          ThreadManager.post(new BusinessReporter.1(str, paramCustomWebView), 5, null, true);
          return;
        }
        if (a(str)) {
          paramCustomWebView.a(new String[] { "JD_REPORT" });
        }
      }
      else
      {
        ((BusinessReportPlugin)localWebViewPlugin).b(str);
      }
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    if (((paramAppInterface instanceof BrowserAppInterface)) && (!TextUtils.isEmpty(paramString1)))
    {
      if (b == null) {
        return;
      }
      String str = Uri.parse(paramString2).getHost();
      if (TextUtils.isEmpty(str)) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject1 = null;
      int i = 0;
      Object localObject2;
      for (;;)
      {
        localObject2 = localObject1;
        if (i >= a.size()) {
          break;
        }
        localObject2 = ((List)a.get(i)).iterator();
        while (((Iterator)localObject2).hasNext()) {
          if (str.contains((String)((Iterator)localObject2).next()))
          {
            localObject1 = (Map)b.get(i);
            j = 1;
            break label139;
          }
        }
        int j = 0;
        label139:
        if (j != 0)
        {
          localObject2 = localObject1;
          break;
        }
        i += 1;
      }
      if (localObject2 != null)
      {
        if (((Map)localObject2).isEmpty()) {
          return;
        }
        localObject1 = ((Map)localObject2).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          str = (String)((Map.Entry)localObject2).getKey();
          i = ((Integer)((Map.Entry)localObject2).getValue()).intValue();
          if (!TextUtils.isEmpty(str))
          {
            localStringBuilder.append("https://");
            localStringBuilder.append(str);
            if (paramString1.startsWith(localStringBuilder.toString()))
            {
              localObject2 = (EcshopReportHandler)paramAppInterface.getBusinessHandler(BrowserAppInterface.m);
              if (localObject2 != null) {
                ((EcshopReportHandler)localObject2).a(i, null, paramString2, null, null, 0L, false);
              }
            }
            else
            {
              localStringBuilder.setLength(0);
              localStringBuilder.append("https://");
              localStringBuilder.append(str);
              if (paramString1.startsWith(localStringBuilder.toString()))
              {
                localObject2 = (EcshopReportHandler)paramAppInterface.getBusinessHandler(BrowserAppInterface.m);
                if (localObject2 != null)
                {
                  ((EcshopReportHandler)localObject2).a(i, null, paramString2, null, null, 0L, false);
                  return;
                }
              }
            }
            localStringBuilder.setLength(0);
          }
        }
      }
    }
  }
  
  public static boolean a()
  {
    return a != null;
  }
  
  public static boolean a(String paramString)
  {
    Object localObject = a;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      paramString = Uri.parse(paramString).getHost();
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      Iterator localIterator;
      do
      {
        localObject = a.iterator();
        while (!localIterator.hasNext())
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localIterator = ((List)((Iterator)localObject).next()).iterator();
        }
      } while (!paramString.contains((String)localIterator.next()));
      return true;
    }
    return false;
  }
  
  public static void b()
  {
    if (b == null)
    {
      if (a != null) {
        return;
      }
      b = new ArrayList();
      a = new ArrayList();
      Object localObject1 = new File(EcShopAssistantManager.n);
      if ((((File)localObject1).exists()) && (((File)localObject1).isFile()))
      {
        localObject1 = FileUtils.readFileContent((File)localObject1);
        try
        {
          localObject1 = new JSONArray((String)localObject1);
          int i = 0;
          Object localObject2;
          while (i < ((JSONArray)localObject1).length())
          {
            Object localObject3 = ((JSONArray)localObject1).getJSONObject(0);
            if (((JSONObject)localObject3).getInt("repflag") != 0)
            {
              Object localObject4 = new ArrayList();
              localObject2 = new HashMap();
              JSONArray localJSONArray = ((JSONObject)localObject3).getJSONArray("entrance");
              int j = 0;
              while (j < localJSONArray.length())
              {
                ((List)localObject4).add(localJSONArray.getString(j));
                j += 1;
              }
              a.add(localObject4);
              localObject3 = ((JSONObject)localObject3).getJSONArray("report");
              j = 0;
              while (j < ((JSONArray)localObject3).length())
              {
                localObject4 = ((JSONArray)localObject3).getJSONObject(j);
                ((Map)localObject2).put(((JSONObject)localObject4).getString("urlprefix"), Integer.valueOf(((JSONObject)localObject4).getInt("tvalue")));
                j += 1;
              }
              b.add(localObject2);
            }
            i += 1;
          }
          return;
        }
        catch (Exception localException)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("parse report json error:");
          ((StringBuilder)localObject2).append(localException);
          QLog.e("BusinessReporter", 1, ((StringBuilder)localObject2).toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.BusinessReporter
 * JD-Core Version:    0.7.0.1
 */