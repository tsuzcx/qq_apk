package com.tencent.map.sdk.a;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class br
  extends bj
{
  private static br d = new br();
  
  public static String a(String paramString, boolean paramBoolean, Map<String, String> paramMap)
  {
    Object localObject = ao.d();
    paramMap.put("A23", ac.d);
    bt localbt = new bt();
    localbt.a(String.valueOf(paramString));
    localbt.a = System.currentTimeMillis();
    localbt.b = bq.a;
    localbt.c = ((String)localObject);
    if (!TextUtils.isEmpty(ac.c)) {
      paramMap.put("A1", ac.c);
    }
    paramMap.put("A2", dg.a());
    paramMap.put("A4", dg.b());
    paramMap.put("A6", dg.c());
    paramMap.put("A7", dg.e());
    paramMap.put("A23", ac.d);
    paramMap.put("A33", ao.f());
    paramMap.put("A10", bq.d);
    paramMap.put("A9", bq.c);
    paramMap.put("A19", localObject);
    localbt.a(paramMap);
    localObject = new StringBuilder();
    paramString = new StringBuilder();
    paramString.append(dg.a(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss.SSS"));
    paramString.append("|");
    ((StringBuilder)localObject).append(paramString.toString());
    ((StringBuilder)localObject).append("INFO|");
    paramString = new StringBuilder();
    paramString.append(as.b);
    paramString.append("|");
    ((StringBuilder)localObject).append(paramString.toString());
    paramString = new StringBuilder();
    paramString.append(bq.b);
    paramString.append("|");
    ((StringBuilder)localObject).append(paramString.toString());
    ((StringBuilder)localObject).append("beacon|");
    ((StringBuilder)localObject).append("1.8.1|");
    paramString = localbt.b;
    try
    {
      paramMap = URLEncoder.encode(localbt.b, "utf-8");
      paramString = paramMap;
    }
    catch (UnsupportedEncodingException paramMap)
    {
      paramMap.printStackTrace();
    }
    paramMap = new StringBuilder();
    paramMap.append(paramString);
    paramMap.append("|");
    ((StringBuilder)localObject).append(paramMap.toString());
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append("upload_ip|");
    ((StringBuilder)localObject).append("|");
    paramString = new StringBuilder();
    paramString.append(localbt.c);
    paramString.append("|");
    ((StringBuilder)localObject).append(paramString.toString());
    paramString = new StringBuilder();
    paramString.append(localbt.a());
    paramString.append("|");
    ((StringBuilder)localObject).append(paramString.toString());
    paramString = new StringBuilder();
    paramString.append(paramBoolean);
    paramString.append("|");
    ((StringBuilder)localObject).append(paramString.toString());
    ((StringBuilder)localObject).append("0|");
    ((StringBuilder)localObject).append("0|");
    paramString = a(localbt.b());
    paramMap = new StringBuilder();
    paramMap.append(paramString);
    paramMap.append("|");
    ((StringBuilder)localObject).append(paramMap.toString());
    paramString = new StringBuilder();
    paramString.append(dg.a(localbt.a, "yyyy-MM-dd HH:mm:ss"));
    paramString.append("|");
    ((StringBuilder)localObject).append(paramString.toString());
    ((StringBuilder)localObject).append("upload_time");
    return ((StringBuilder)localObject).toString();
  }
  
  private static String a(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return "";
    }
    Object localObject = paramMap.keySet();
    if (localObject == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localStringBuilder.append("&");
      localStringBuilder.append(str);
      localStringBuilder.append("=");
      localStringBuilder.append((String)paramMap.get(str));
    }
    paramMap = localStringBuilder.substring(1);
    localStringBuilder.setLength(0);
    return paramMap;
  }
  
  public static br e()
  {
    return d;
  }
  
  public final int a()
  {
    return as.a("report_insert_new_record_num_limit", 5, 100, 100);
  }
  
  public final String b()
  {
    return "beacon";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.br
 * JD-Core Version:    0.7.0.1
 */