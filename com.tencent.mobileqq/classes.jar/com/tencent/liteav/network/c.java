package com.tencent.liteav.network;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.liteav.network.a;>;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class c
{
  public b a = null;
  public int b = 5;
  private final String c = "https://tcdns.myqcloud.com/queryip";
  private final String d = "https://tcdnsipv6.myqcloud.com/queryip";
  private final String e = "forward_stream";
  private final String f = "forward_num";
  private final String g = "request_type";
  private final String h = "sdk_version";
  private final String i = "51451748-d8f2-4629-9071-db2983aa7251";
  private final int j = 5;
  private final int k = 2;
  private Thread l = null;
  
  private a a(JSONObject paramJSONObject)
  {
    a locala = new a();
    try
    {
      locala.a = paramJSONObject.getString("ip");
      locala.b = paramJSONObject.getString("port");
      locala.e = 0;
      locala.c = false;
      locala.d = c(locala.a);
      if ((paramJSONObject.has("type")) && (paramJSONObject.getInt("type") == 2)) {
        locala.c = true;
      }
      return locala;
    }
    catch (JSONException paramJSONObject)
    {
      TXCLog.e("TXCIntelligentRoute", "get ip record from json object failed.", paramJSONObject);
    }
    return null;
  }
  
  private String a(String paramString1, int paramInt, String paramString2)
  {
    localStringBuffer = new StringBuffer("");
    try
    {
      paramString1 = b(paramString1, paramInt, paramString2);
      if (paramString1 == null) {
        return "";
      }
      paramString1 = new BufferedReader(new InputStreamReader(paramString1));
      for (;;)
      {
        paramString2 = paramString1.readLine();
        if (paramString2 == null) {
          break;
        }
        localStringBuffer.append(paramString2);
      }
      return localStringBuffer.toString();
    }
    catch (IOException paramString1)
    {
      TXCLog.e("TXCIntelligentRoute", "get json string from url failed.", paramString1);
    }
  }
  
  private ArrayList<a> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = localArrayList;
    int m;
    try
    {
      paramString = new JSONObject(paramString);
      localObject = localArrayList;
      if (paramString.getInt("state") != 0) {
        return null;
      }
      localObject = localArrayList;
      paramString = paramString.getJSONObject("content").getJSONArray("list");
      if (paramString != null) {
        break label334;
      }
      return null;
    }
    catch (JSONException paramString)
    {
      a locala;
      TXCLog.e("TXCIntelligentRoute", "get records from json string failed.", paramString);
      return localObject;
    }
    localObject = localArrayList;
    if (m < paramString.length())
    {
      localObject = localArrayList;
      locala = a((JSONObject)paramString.opt(m));
      if (locala != null)
      {
        localObject = localArrayList;
        if (locala.c)
        {
          localObject = localArrayList;
          localArrayList.add(locala);
        }
      }
    }
    for (;;)
    {
      localObject = localArrayList;
      if (m < paramString.length())
      {
        localObject = localArrayList;
        locala = a((JSONObject)paramString.opt(m));
        if (locala != null)
        {
          localObject = localArrayList;
          if (!locala.c)
          {
            localObject = localArrayList;
            localArrayList.add(locala);
          }
        }
      }
      else
      {
        localObject = localArrayList;
        if (com.tencent.liteav.basic.d.c.a().a("Network", "EnableRouteOptimize") == 1L)
        {
          localObject = localArrayList;
          if (i.a().c())
          {
            localObject = localArrayList;
            paramString = a(localArrayList, true);
            localObject = paramString;
            a(paramString);
            return paramString;
          }
        }
        localObject = localArrayList;
        long l1 = com.tencent.liteav.basic.d.c.a().a("Network", "RouteSamplingMaxCount");
        paramString = localArrayList;
        if (l1 >= 1L)
        {
          localObject = localArrayList;
          long l2 = i.a().a("51451748-d8f2-4629-9071-db2983aa7251");
          paramString = localArrayList;
          if (l2 <= l1)
          {
            localObject = localArrayList;
            paramString = a(localArrayList, false);
            localObject = paramString;
            i.a().a("51451748-d8f2-4629-9071-db2983aa7251", l2 + 1L);
          }
        }
        localObject = paramString;
        a(paramString);
        return paramString;
        label334:
        m = 0;
        break;
        m += 1;
        break;
        m = 0;
        continue;
      }
      m += 1;
    }
  }
  
  private ArrayList<a> a(ArrayList<a> paramArrayList, boolean paramBoolean)
  {
    Object localObject1 = null;
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return null;
      }
      Object localObject2 = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramArrayList.iterator();
      paramArrayList = (ArrayList<a>)localObject1;
      while (localIterator.hasNext())
      {
        localObject1 = (a)localIterator.next();
        if (((a)localObject1).c) {
          ((ArrayList)localObject2).add(localObject1);
        } else if (((a)localObject1).d) {
          paramArrayList = (ArrayList<a>)localObject1;
        } else {
          localArrayList.add(localObject1);
        }
      }
      localObject1 = new ArrayList();
      for (;;)
      {
        if ((((ArrayList)localObject2).size() <= 0) && (localArrayList.size() <= 0))
        {
          int m = ((ArrayList)localObject1).size();
          if (m > 0)
          {
            localObject2 = (a)((ArrayList)localObject1).get(m - 1);
            if ((localObject2 != null) && (!c(((a)localObject2).a)) && (paramArrayList != null)) {
              ((ArrayList)localObject1).add(paramArrayList);
            }
          }
          return localObject1;
        }
        if (paramBoolean)
        {
          if (paramArrayList != null) {
            ((ArrayList)localObject1).add(paramArrayList);
          }
          if (((ArrayList)localObject2).size() > 0)
          {
            ((ArrayList)localObject1).add(((ArrayList)localObject2).get(0));
            ((ArrayList)localObject2).remove(0);
          }
        }
        else
        {
          if (((ArrayList)localObject2).size() > 0)
          {
            ((ArrayList)localObject1).add(((ArrayList)localObject2).get(0));
            ((ArrayList)localObject2).remove(0);
          }
          if (paramArrayList != null) {
            ((ArrayList)localObject1).add(paramArrayList);
          }
        }
        if (localArrayList.size() > 0)
        {
          ((ArrayList)localObject1).add(localArrayList.get(0));
          localArrayList.remove(0);
        }
      }
    }
    return null;
  }
  
  private void a(ArrayList<a> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      Iterator localIterator = paramArrayList.iterator();
      StringBuilder localStringBuilder;
      for (paramArrayList = ""; localIterator.hasNext(); paramArrayList = localStringBuilder.toString())
      {
        a locala = (a)localIterator.next();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramArrayList);
        localStringBuilder.append(" \n Nearest IP: ");
        localStringBuilder.append(locala.a);
        localStringBuilder.append(" Port: ");
        localStringBuilder.append(locala.b);
        localStringBuilder.append(" Q Channel: ");
        localStringBuilder.append(locala.c);
      }
      TXCLog.e("TXCIntelligentRoute", paramArrayList);
    }
  }
  
  private InputStream b(String paramString1, int paramInt, String paramString2)
  {
    paramString2 = new URL(paramString2).openConnection();
    try
    {
      paramString2 = (HttpURLConnection)paramString2;
      paramString2.setRequestMethod("GET");
      paramString2.setRequestProperty("forward_stream", paramString1);
      paramString2.setRequestProperty("forward_num", "2");
      paramString2.setRequestProperty("sdk_version", TXCCommonUtil.getSDKVersionStr());
      if (paramInt == 1) {
        paramString2.setRequestProperty("request_type", "1");
      } else if (paramInt == 2) {
        paramString2.setRequestProperty("request_type", "2");
      } else {
        paramString2.setRequestProperty("request_type", "3");
      }
      if (this.b > 0)
      {
        paramString2.setConnectTimeout(this.b * 1000);
        paramString2.setReadTimeout(this.b * 1000);
      }
      paramString2.connect();
      if (paramString2.getResponseCode() == 200)
      {
        paramString1 = paramString2.getInputStream();
        return paramString1;
      }
    }
    catch (Exception paramString1)
    {
      TXCLog.e("TXCIntelligentRoute", "http failed.", paramString1);
    }
    return null;
  }
  
  private boolean b(String paramString)
  {
    return paramString.split(":").length > 1;
  }
  
  private boolean c(String paramString)
  {
    if (b(paramString)) {
      return false;
    }
    if (paramString != null)
    {
      paramString = paramString.split("[.]");
      int n = paramString.length;
      int m = 0;
      while (m < n)
      {
        if (!d(paramString[m])) {
          return true;
        }
        m += 1;
      }
    }
    return false;
  }
  
  private boolean d(String paramString)
  {
    return Pattern.compile("[0-9]*").matcher(paramString).matches();
  }
  
  public void a(String paramString, int paramInt)
  {
    this.l = new c.1(this, "TXCPushRoute", paramString, paramInt);
    this.l.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.network.c
 * JD-Core Version:    0.7.0.1
 */