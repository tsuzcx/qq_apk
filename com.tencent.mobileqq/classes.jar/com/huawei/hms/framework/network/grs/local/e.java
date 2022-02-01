package com.huawei.hms.framework.network.grs.local;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.Collections;
import java.util.Set;

public class e
{
  public static final Set<String> a = Collections.unmodifiableSet(new e.1(16));
  private static final String b = e.class.getSimpleName();
  
  public static String a(String paramString, GrsBaseInfo paramGrsBaseInfo)
  {
    if (TextUtils.isEmpty(paramString))
    {
      Logger.w(b, "routeBy must be not empty string or null.");
      return null;
    }
    if (("no_route".equals(paramString)) || ("unconditional".equals(paramString)))
    {
      Logger.v(b, "routeBy equals NO_ROUTE_POLICY");
      return "no_route_country";
    }
    return b(paramString, paramGrsBaseInfo);
  }
  
  private static String b(String paramString, GrsBaseInfo paramGrsBaseInfo)
  {
    String str1 = paramGrsBaseInfo.getSerCountry();
    String str2 = paramGrsBaseInfo.getRegCountry();
    paramGrsBaseInfo = paramGrsBaseInfo.getIssueCountry();
    paramString = paramString.split(">");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramString[i];
      if (a.contains(localObject.trim()))
      {
        if (("ser_country".equals(localObject.trim())) && (!TextUtils.isEmpty(str1))) {
          return str1;
        }
        if (("reg_country".equals(localObject.trim())) && (!TextUtils.isEmpty(str2))) {
          return str2;
        }
        if (("issue_country".equals(localObject.trim())) && (!TextUtils.isEmpty(paramGrsBaseInfo))) {
          return paramGrsBaseInfo;
        }
      }
      i += 1;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.local.e
 * JD-Core Version:    0.7.0.1
 */