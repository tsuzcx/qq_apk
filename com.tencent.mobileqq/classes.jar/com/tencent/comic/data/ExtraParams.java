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
  private static final HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private int jdField_a_of_type_Int = 0;
  public final ConcurrentHashMap<String, Pair<Integer, String>> a;
  public final ConcurrentHashMap<String, String> b = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap.put("obj_ownerid", Integer.valueOf(11));
    jdField_a_of_type_JavaUtilHashMap.put("obj_pos", Integer.valueOf(12));
    jdField_a_of_type_JavaUtilHashMap.put("mod", Integer.valueOf(16));
    jdField_a_of_type_JavaUtilHashMap.put("land_page", Integer.valueOf(42));
    jdField_a_of_type_JavaUtilHashMap.put("detailpage_from", Integer.valueOf(43));
    jdField_a_of_type_JavaUtilHashMap.put("algo_id", Integer.valueOf(44));
    jdField_a_of_type_JavaUtilHashMap.put("trace_scene_id", Integer.valueOf(45));
    jdField_a_of_type_JavaUtilHashMap.put("page_id", Integer.valueOf(46));
  }
  
  public ExtraParams()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public ExtraParams a()
  {
    ExtraParams localExtraParams = new ExtraParams();
    localExtraParams.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putAll(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap);
    localExtraParams.b.putAll(this.b);
    return localExtraParams;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = StringBuilderUtils.a();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
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
  
  public String a(String paramString1, String paramString2)
  {
    Integer localInteger = (Integer)jdField_a_of_type_JavaUtilHashMap.get(paramString1);
    if (localInteger != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, new Pair(localInteger, paramString2));
    }
    return paramString2;
  }
  
  public List<String> a(List<String> paramList)
  {
    if (paramList == null) {
      return null;
    }
    int i = paramList.size();
    int j = this.jdField_a_of_type_Int;
    if (i <= j + 1)
    {
      localObject = new ArrayList(j + 1);
      ((List)localObject).addAll(paramList);
      paramList = (List<String>)localObject;
    }
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      if (!jdField_a_of_type_JavaUtilHashMap.containsKey(localEntry.getKey())) {
        paramList.set(((Integer)((Pair)localEntry.getValue()).first).intValue(), ((Pair)localEntry.getValue()).second);
      }
    }
    return paramList;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_Int = 0;
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
              if (n > this.jdField_a_of_type_Int) {
                this.jdField_a_of_type_Int = n;
              }
              str2 = str2.substring(0, m);
              str1 = str1.substring(k + 1, str1.length());
              this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str2, new Pair(Integer.valueOf(n), str1));
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
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, new Pair(Integer.valueOf(paramInt), paramString2));
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
    VipComicDataHelper.d = a("land_page", paramJSONObject.optString("land_page_id", VipComicDataHelper.d));
    VipComicDataHelper.b = a("obj_ownerid", paramJSONObject.optString("obj_ownerid", VipComicDataHelper.b));
    VipComicDataHelper.g = a("algo_id", paramJSONObject.optString("algo_id", "0"));
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
    VipComicDataHelper.i = a("trace_scene_id", paramJSONObject);
  }
  
  public void b(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    VipComicDataHelper.a = a("mod", paramJSONObject.optString("mod_18", VipComicDataHelper.a));
    VipComicDataHelper.e = a("obj_pos", paramJSONObject.optString("obj_pos_14", VipComicDataHelper.e));
    VipComicDataHelper.f = a("detailpage_from", paramJSONObject.optString("detailpage_from_45", VipComicDataHelper.f));
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
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.comic.data.ExtraParams
 * JD-Core Version:    0.7.0.1
 */