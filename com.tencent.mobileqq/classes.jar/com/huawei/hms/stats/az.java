package com.huawei.hms.stats;

import android.text.TextUtils;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class az
{
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (TextUtils.isEmpty(paramString2)) {
      af.c("hmsSdk", "checkStrParameter() Parameter verification failure! Parameter:" + paramString1);
    }
    while (!a(paramString1, paramString2, paramString3)) {
      return paramString4;
    }
    return paramString2;
  }
  
  public static boolean a(String paramString)
  {
    return !a("eventId", paramString, 256);
  }
  
  public static boolean a(String paramString1, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      af.c("hmsSdk", "checkString() Parameter is empty : " + paramString1);
      return false;
    }
    if (paramString2.length() > paramInt)
    {
      af.c("hmsSdk", "checkString() Failure of parameter length check! Parameter:" + paramString1);
      return false;
    }
    return true;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      af.c("hmsSdk", "checkString() Parameter is null! Parameter:" + paramString1);
      return false;
    }
    if (Pattern.compile(paramString3).matcher(paramString2).matches()) {
      return true;
    }
    af.c("hmsSdk", "checkString() Parameter verification failure! Parameter:" + paramString1);
    return false;
  }
  
  public static boolean a(Map<String, String> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() == 0))
    {
      af.c("hmsSdk", "onEvent() mapValue has not data.so,The data will be empty");
      return false;
    }
    if ((paramMap.size() == 1) && ((paramMap.get("constants") != null) || (paramMap.get("_constants") != null)))
    {
      af.c("hmsSdk", "checkMap() the key can't be constants or _constants");
      return false;
    }
    if ((paramMap.size() > 2048) || (paramMap.toString().length() > 204800))
    {
      af.c("hmsSdk", "checkMap Map data is too big! size: " + paramMap.size() + " length: " + paramMap.toString().length());
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.stats.az
 * JD-Core Version:    0.7.0.1
 */