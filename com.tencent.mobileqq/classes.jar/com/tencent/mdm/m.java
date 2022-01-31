package com.tencent.mdm;

import com.tencent.mobileqq.utils.SecUtil;
import java.util.concurrent.ConcurrentHashMap;

public class m
{
  private static ConcurrentHashMap a = new ConcurrentHashMap();
  
  public static String a(String paramString)
  {
    String str2 = (String)a.get(paramString);
    String str1 = str2;
    if (str2 == null)
    {
      str2 = SecUtil.getFileMd5(paramString);
      str1 = str2;
      if (str2 != null)
      {
        a.put(paramString, str2);
        str1 = str2;
      }
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.mdm.m
 * JD-Core Version:    0.7.0.1
 */