package com.huawei.hms.framework.network.grs.c;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class n
{
  public static String a(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (!paramString1.equals(paramString2)) {
      str = b(paramString1, paramString2);
    }
    return str;
  }
  
  private static String b(String paramString1, String paramString2)
  {
    Object localObject = new HashSet();
    boolean bool = TextUtils.isEmpty(paramString1);
    int j = 0;
    int i;
    if (!bool)
    {
      paramString1 = new JSONObject(paramString1).getJSONArray("services");
      i = 0;
      while (i < paramString1.length())
      {
        ((Set)localObject).add(paramString1.getString(i));
        i += 1;
      }
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = new JSONObject(paramString2).getJSONArray("services");
      i = j;
      while (i < paramString1.length())
      {
        ((Set)localObject).add(paramString1.getString(i));
        i += 1;
      }
    }
    if (((Set)localObject).isEmpty()) {
      return "";
    }
    paramString1 = new JSONObject();
    paramString2 = new JSONArray();
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramString2.put((String)((Iterator)localObject).next());
    }
    paramString1.put("services", paramString2);
    return paramString1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.c.n
 * JD-Core Version:    0.7.0.1
 */