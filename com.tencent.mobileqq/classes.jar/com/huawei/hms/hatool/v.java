package com.huawei.hms.hatool;

import android.os.Build;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class v
{
  public static c1 a(String paramString1, String paramString2)
  {
    c1 localc1 = new c1();
    localc1.a(x0.a().a(paramString1, paramString2));
    return localc1;
  }
  
  public static d1 a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    d1 locald1 = new d1();
    locald1.a(paramString1);
    locald1.b(b.c());
    locald1.e(paramString2);
    locald1.c(paramString4);
    paramString1 = new StringBuffer("hmshi");
    paramString1.append(paramString3);
    paramString1.append("qrt");
    locald1.d(paramString1.toString());
    return locald1;
  }
  
  public static e1 a(String paramString1, String paramString2, String paramString3)
  {
    e1 locale1 = new e1();
    locale1.c(b.g());
    locale1.e(b.i());
    locale1.a(paramString3);
    locale1.b(x0.a().b(paramString2, paramString1));
    return locale1;
  }
  
  public static r a()
  {
    y.c("hmsSdk", "generate UploadData EventModelHandlerBase");
    x.f().d();
    if (TextUtils.isEmpty(x.f().a()))
    {
      y.f("hmsSdk", "event chifer is empty");
      return null;
    }
    return new r(x.f().c());
  }
  
  public static Map<String, String> b(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("App-Id", b.c());
    localHashMap.put("App-Ver", b.d());
    localHashMap.put("Sdk-Name", "hianalytics");
    localHashMap.put("Sdk-Ver", "2.2.0.308");
    localHashMap.put("Device-Type", Build.MODEL);
    localHashMap.put("servicetag", paramString1);
    y.a("hmsSdk", "sendData RequestId : %s", new Object[] { paramString2 });
    localHashMap.put("Request-Id", paramString2);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.hatool.v
 * JD-Core Version:    0.7.0.1
 */