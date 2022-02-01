package com.huawei.hms.stats;

import android.os.Build;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class ac
{
  protected static bl a(String paramString1, String paramString2)
  {
    bl localbl = new bl();
    localbl.a(bg.a().d(paramString1, paramString2));
    return localbl;
  }
  
  protected static bm a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    bm localbm = new bm();
    localbm.f(paramString1);
    localbm.a(b.e());
    localbm.c(paramString2);
    localbm.e(paramString4);
    paramString1 = new StringBuffer("hmshi");
    paramString1.append(paramString3).append("qrt");
    localbm.d(paramString1.toString());
    return localbm;
  }
  
  protected static bn a(String paramString1, String paramString2, String paramString3)
  {
    bn localbn = new bn();
    localbn.a(b.b());
    localbn.b(b.d());
    localbn.c(paramString3);
    localbn.d(bg.a().e(paramString2, paramString1));
    return localbn;
  }
  
  protected static x a()
  {
    af.b("hmsSdk", "generate UploadData");
    ae.a().b();
    if (TextUtils.isEmpty(ae.a().d()))
    {
      af.c("hmsSdk", "event chifer is empty");
      return null;
    }
    return new x(ae.a().c());
  }
  
  protected static Map<String, String> b(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("App-Id", b.e());
    localHashMap.put("App-Ver", b.f());
    localHashMap.put("Sdk-Name", "hianalytics");
    localHashMap.put("Sdk-Ver", "2.2.0.305");
    localHashMap.put("Device-Type", Build.MODEL);
    localHashMap.put("servicetag", paramString1);
    af.a("hmsSdk", "sendData RequestId : %s", new Object[] { paramString2 });
    localHashMap.put("Request-Id", paramString2);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.stats.ac
 * JD-Core Version:    0.7.0.1
 */