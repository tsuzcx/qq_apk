package com.huawei.hms.framework.network.grs.b;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.a.a;
import com.huawei.hms.framework.network.grs.c.c;
import java.util.Collections;
import java.util.Set;

public class f
{
  private static final String a = "f";
  public static final Set<String> b = Collections.unmodifiableSet(new e(16));
  
  public static String a(Context paramContext, a parama, String paramString, GrsBaseInfo paramGrsBaseInfo, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      Logger.w(a, "routeBy must be not empty string or null.");
      return null;
    }
    if ((!"no_route".equals(paramString)) && (!"unconditional".equals(paramString))) {
      return b(paramContext, parama, paramString, paramGrsBaseInfo, paramBoolean);
    }
    Logger.v(a, "routeBy equals NO_ROUTE_POLICY");
    return "no_route_country";
  }
  
  private static String b(Context paramContext, a parama, String paramString, GrsBaseInfo paramGrsBaseInfo, boolean paramBoolean)
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
      if (b.contains(localObject.trim()))
      {
        if (("ser_country".equals(localObject.trim())) && (!TextUtils.isEmpty(str1)) && (!"UNKNOWN".equals(str1)))
        {
          parama = a;
          paramString = new StringBuilder();
          paramGrsBaseInfo = "current route_by is serCountry and routerCountry is:";
          paramContext = str1;
        }
        for (;;)
        {
          paramString.append(paramGrsBaseInfo);
          paramString.append(paramContext);
          Logger.i(parama, paramString.toString());
          return paramContext;
          if (("reg_country".equals(localObject.trim())) && (!TextUtils.isEmpty(str2)) && (!"UNKNOWN".equals(str2)))
          {
            paramContext = a;
            parama = new StringBuilder();
            parama.append("current route_by is regCountry and routerCountry is:");
            parama.append(str2);
            Logger.i(paramContext, parama.toString());
            return str2;
          }
          if (("issue_country".equals(localObject.trim())) && (!TextUtils.isEmpty(paramGrsBaseInfo)) && (!"UNKNOWN".equals(paramGrsBaseInfo)))
          {
            paramContext = a;
            parama = new StringBuilder();
            parama.append("current route_by is issueCountry and routerCountry is:");
            parama.append(paramGrsBaseInfo);
            Logger.i(paramContext, parama.toString());
            return paramGrsBaseInfo;
          }
          if (!"geo_ip".equals(localObject.trim())) {
            break;
          }
          paramContext = new c(paramContext, parama, new GrsBaseInfo()).a(paramBoolean);
          parama = a;
          paramString = new StringBuilder();
          paramGrsBaseInfo = "current route_by is geo_ip and routerCountry is: ";
        }
      }
      i += 1;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.b.f
 * JD-Core Version:    0.7.0.1
 */