package com.huawei.hms.hatool;

import android.text.TextUtils;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class q0
{
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      paramString2 = new StringBuilder();
      paramString2.append("checkStrParameter() Parameter verification failure! Parameter:");
      paramString2.append(paramString1);
      y.f("hmsSdk", paramString2.toString());
      return paramString4;
    }
    if (a(paramString1, paramString2, paramString3)) {
      return paramString2;
    }
    return paramString4;
  }
  
  public static boolean a(String paramString)
  {
    return a("eventId", paramString, 256) ^ true;
  }
  
  public static boolean a(String paramString1, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString2)) {
      paramString2 = new StringBuilder();
    }
    for (String str = "checkString() Parameter is empty : ";; str = "checkString() Failure of parameter length check! Parameter:")
    {
      paramString2.append(str);
      paramString2.append(paramString1);
      y.f("hmsSdk", paramString2.toString());
      return false;
      if (paramString2.length() <= paramInt) {
        break;
      }
      paramString2 = new StringBuilder();
    }
    return true;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString2)) {
      paramString2 = new StringBuilder();
    }
    for (paramString3 = "checkString() Parameter is null! Parameter:";; paramString3 = "checkString() Parameter verification failure! Parameter:")
    {
      paramString2.append(paramString3);
      paramString2.append(paramString1);
      y.f("hmsSdk", paramString2.toString());
      return false;
      if (Pattern.compile(paramString3).matcher(paramString2).matches()) {
        return true;
      }
      paramString2 = new StringBuilder();
    }
  }
  
  public static boolean a(Map<String, String> paramMap)
  {
    if ((paramMap != null) && (paramMap.size() != 0)) {
      if ((paramMap.size() == 1) && ((paramMap.get("constants") != null) || (paramMap.get("_constants") != null))) {
        paramMap = "checkMap() the key can't be constants or _constants";
      }
    }
    for (;;)
    {
      y.f("hmsSdk", paramMap);
      return false;
      if ((paramMap.size() <= 2048) && (paramMap.toString().length() <= 204800)) {
        return true;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkMap Map data is too big! size: ");
      localStringBuilder.append(paramMap.size());
      localStringBuilder.append(" length: ");
      localStringBuilder.append(paramMap.toString().length());
      paramMap = localStringBuilder.toString();
      continue;
      paramMap = "onEvent() mapValue has not data.so,The data will be empty";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.hatool.q0
 * JD-Core Version:    0.7.0.1
 */