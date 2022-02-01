package com.tencent.imcore.message;

import com.tencent.qphone.base.util.MD5;
import java.util.concurrent.ConcurrentHashMap;

public class UinMD5Cache
{
  private static ConcurrentHashMap<String, String> a = new ConcurrentHashMap();
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "0";
    }
    if (a.containsKey(str)) {
      return (String)a.get(str);
    }
    paramString = MD5.toMD5(str);
    if (a.size() > 3000) {
      a.clear();
    }
    a.put(str, paramString);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.UinMD5Cache
 * JD-Core Version:    0.7.0.1
 */