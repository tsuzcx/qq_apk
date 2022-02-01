package com.tencent.comic.data;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.tencent.util.StringBuilderUtils;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class ExtraParams
{
  private static final HashMap<String, Integer> c = new HashMap();
  public final ConcurrentHashMap<String, Pair<Integer, String>> a = new ConcurrentHashMap();
  public final ConcurrentHashMap<String, String> b = new ConcurrentHashMap();
  private int d = 0;
  
  static
  {
    c.put("obj_ownerid", Integer.valueOf(11));
    c.put("obj_pos", Integer.valueOf(12));
    c.put("mod", Integer.valueOf(16));
    c.put("land_page", Integer.valueOf(42));
    c.put("detailpage_from", Integer.valueOf(43));
    c.put("algo_id", Integer.valueOf(44));
    c.put("trace_scene_id", Integer.valueOf(45));
    c.put("page_id", Integer.valueOf(46));
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = StringBuilderUtils.a();
    Iterator localIterator = this.a.entrySet().iterator();
    int i = 0;
    Map.Entry localEntry;
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      if (!TextUtils.isEmpty((CharSequence)((Pair)localEntry.getValue()).second))
      {
        if (i > 0) {
          localStringBuilder.append('&');
        }
        localStringBuilder.append((String)localEntry.getKey());
        localStringBuilder.append('=');
        localStringBuilder.append((String)((Pair)localEntry.getValue()).second);
        i += 1;
      }
    }
    localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      if (i > 0) {
        localStringBuilder.append('&');
      }
      localStringBuilder.append((String)localEntry.getKey());
      localStringBuilder.append('=');
      localStringBuilder.append((String)localEntry.getValue());
      i += 1;
    }
    return URLEncoder.encode(localStringBuilder.toString());
  }
  
  public List<String> a(List<String> paramList)
  {
    if (paramList == null) {
      return null;
    }
    int i = paramList.size();
    int j = this.d;
    if (i <= j + 1)
    {
      localObject = new ArrayList(j + 1);
      ((List)localObject).addAll(paramList);
      paramList = (List<String>)localObject;
    }
    Object localObject = this.a.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      if (!c.containsKey(localEntry.getKey())) {
        paramList.set(((Integer)((Pair)localEntry.getValue()).first).intValue(), ((Pair)localEntry.getValue()).second);
      }
    }
    return paramList;
  }
  
  public void a(String paramString)
  {
    this.a.clear();
    this.d = 0;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = URLDecoder.decode(paramString).split("&");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String str1 = paramString[i];
      int k = str1.indexOf("=");
      if (k > 0)
      {
        String str2 = str1.substring(0, k);
        int m = str2.lastIndexOf("_");
        if (m > 0)
        {
          String str3 = str2.substring(m + 1, str2.length());
          if (TextUtils.isDigitsOnly(str3))
          {
            int n = Integer.parseInt(str3) - 2;
            if (n > 8)
            {
              if (n > this.d) {
                this.d = n;
              }
              str2 = str2.substring(0, m);
              str1 = str1.substring(k + 1, str1.length());
              this.a.put(str2, new Pair(Integer.valueOf(n), str1));
            }
          }
        }
      }
      i += 1;
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (paramInt <= 8) {
        return;
      }
      this.a.put(paramString1, new Pair(Integer.valueOf(paramInt), paramString2));
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      this.b.put(paramString1, paramString2);
    }
  }
  
  @Deprecated
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    VipComicDataHelper.d = b("land_page", paramJSONObject.optString("land_page_id", VipComicDataHelper.d));
    VipComicDataHelper.b = b("obj_ownerid", paramJSONObject.optString("obj_ownerid", VipComicDataHelper.b));
    VipComicDataHelper.g = b("algo_id", paramJSONObject.optString("algo_id", "0"));
    String[] arrayOfString = paramJSONObject.optString("read_params", "0").split("&");
    int j = arrayOfString.length;
    int i = 0;
    JSONObject localJSONObject;
    for (paramJSONObject = ""; i < j; paramJSONObject = localJSONObject)
    {
      Object localObject = arrayOfString[i];
      localJSONObject = paramJSONObject;
      if (((String)localObject).trim().contains("trace_scene_id="))
      {
        localObject = ((String)localObject).trim().split("=");
        localJSONObject = paramJSONObject;
        if (localObject.length == 2) {
          localJSONObject = localObject[1];
        }
      }
      i += 1;
    }
    VipComicDataHelper.i = b("trace_scene_id", paramJSONObject);
  }
  
  public ExtraParams b()
  {
    ExtraParams localExtraParams = new ExtraParams();
    localExtraParams.a.putAll(this.a);
    localExtraParams.b.putAll(this.b);
    return localExtraParams;
  }
  
  public String b(String paramString1, String paramString2)
  {
    Integer localInteger = (Integer)c.get(paramString1);
    if (localInteger != null) {
      this.a.put(paramString1, new Pair(localInteger, paramString2));
    }
    return paramString2;
  }
  
  public void b(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    VipComicDataHelper.a = b("mod", paramJSONObject.optString("mod_18", VipComicDataHelper.a));
    VipComicDataHelper.e = b("obj_pos", paramJSONObject.optString("obj_pos_14", VipComicDataHelper.e));
    VipComicDataHelper.f = b("detailpage_from", paramJSONObject.optString("detailpage_from_45", VipComicDataHelper.f));
    if (paramJSONObject.has("mod")) {
      VipComicDataHelper.k = paramJSONObject.optString("mod");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateSetContainerInfoParams: mod=");
    localStringBuilder.append(paramJSONObject);
    Log.i("ExtraParams", localStringBuilder.toString());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = StringBuilderUtils.a();
    Iterator localIterator = this.a.entrySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (!TextUtils.isEmpty((CharSequence)((Pair)localEntry.getValue()).second))
      {
        if (i > 0) {
          localStringBuilder.append('&');
        }
        localStringBuilder.append((String)localEntry.getKey());
        localStringBuilder.append('_');
        localStringBuilder.append(((Integer)((Pair)localEntry.getValue()).first).intValue() + 2);
        localStringBuilder.append('=');
        localStringBuilder.append((String)((Pair)localEntry.getValue()).second);
        i += 1;
      }
    }
    return URLEncoder.encode(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.comic.data.ExtraParams
 * JD-Core Version:    0.7.0.1
 */