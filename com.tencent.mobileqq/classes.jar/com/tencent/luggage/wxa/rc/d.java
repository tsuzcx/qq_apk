package com.tencent.luggage.wxa.rc;

import android.text.TextUtils;
import android.util.Pair;
import android.webkit.MimeTypeMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class d
{
  private static final Map<String, String> a;
  private static final Map<String, String> b;
  
  static
  {
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(new Pair("silk", "audio/silk"));
    ((ArrayList)localObject).add(new Pair("jpg", "image/jpeg"));
    ((ArrayList)localObject).add(new Pair("json", "application/json"));
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Pair localPair = (Pair)((Iterator)localObject).next();
      localHashMap1.put(localPair.first, localPair.second);
      localHashMap2.put(localPair.second, localPair.first);
    }
    a = Collections.unmodifiableMap(localHashMap1);
    b = Collections.unmodifiableMap(localHashMap2);
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String str2 = (String)a.get(paramString.toLowerCase());
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (!TextUtils.isEmpty(paramString)) {
        str1 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramString);
      }
    }
    if ((TextUtils.isEmpty(str1)) && ("mp3".equals(paramString))) {
      return "audio/mpeg";
    }
    return str1;
  }
  
  public static String b(String paramString)
  {
    return a(c(paramString));
  }
  
  public static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int i = paramString.lastIndexOf('.');
    if (i >= 0)
    {
      if (i >= paramString.length() - 1) {
        return null;
      }
      return paramString.substring(i + 1);
    }
    return null;
  }
  
  public static String d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String str3 = paramString.toLowerCase();
    String str2 = (String)b.get(str3);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = MimeTypeMap.getSingleton().getExtensionFromMimeType(paramString);
    }
    if (TextUtils.isEmpty(str1))
    {
      if ("audio/mpeg".equals(str3)) {
        return "mp3";
      }
      if ("audio/mp3".equals(str3)) {
        return "mp3";
      }
      if ("audio/mp4".equals(str3)) {
        return "mp4";
      }
      if ("application/pdf".equals(str3)) {
        return "pdf";
      }
      if ("image/jpeg".equals(str3)) {
        return "jpg";
      }
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rc.d
 * JD-Core Version:    0.7.0.1
 */