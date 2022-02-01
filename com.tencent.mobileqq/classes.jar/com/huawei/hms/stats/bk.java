package com.huawei.hms.stats;

import android.util.Pair;
import java.util.List;
import java.util.Map;

public class bk
  extends ac
{
  public static x a(List<w> paramList, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    af.b("hmsSdk", "generate UploadData");
    x localx = ac.a();
    if (localx == null) {
      return null;
    }
    localx.a(b(ae.a().d(), paramString1, paramString2, paramString3));
    localx.a(c(paramString1, paramString2));
    localx.a(b(paramString2, paramString1, paramString4));
    localx.a(c.f(paramString1, paramString2));
    localx.a(paramList);
    return localx;
  }
  
  protected static bm b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString1 = ac.a(paramString1, paramString2, paramString3, paramString4);
    paramString2 = bg.a().a(c.k(paramString2, paramString3));
    long l = System.currentTimeMillis();
    paramString2 = b.e() + paramString2 + l;
    paramString2 = e.a().a(paramString2);
    paramString1.b(String.valueOf(l));
    paramString1.g(paramString2);
    return paramString1;
  }
  
  protected static bn b(String paramString1, String paramString2, String paramString3)
  {
    paramString3 = ac.a(paramString1, paramString2, paramString3);
    Pair localPair = bg.a().b(paramString2, paramString1);
    paramString3.f((String)localPair.first);
    paramString3.g((String)localPair.second);
    paramString3.h(bi.b());
    paramString3.e(bg.a().f(paramString2, paramString1));
    return paramString3;
  }
  
  protected static bl c(String paramString1, String paramString2)
  {
    bl localbl = ac.a(paramString1, paramString2);
    be localbe = bg.a().a(paramString1, paramString2);
    localbl.f(bg.a().a(c.k(paramString1, paramString2)));
    localbl.d(c.a(paramString1, paramString2));
    localbl.g(bg.a().c(paramString1, paramString2));
    paramString1 = localbe.a();
    switch (bk.1.a[paramString1.ordinal()])
    {
    default: 
      return localbl;
    case 1: 
      localbl.c(localbe.b());
      return localbl;
    case 2: 
      localbl.b(localbe.b());
      return localbl;
    }
    localbl.e(localbe.b());
    return localbl;
  }
  
  public static Map<String, String> c(String paramString1, String paramString2, String paramString3)
  {
    paramString3 = b(paramString1, paramString3);
    paramString1 = c.l(paramString1, paramString2);
    if (paramString1 == null) {
      return paramString3;
    }
    paramString3.putAll(paramString1);
    return paramString3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.stats.bk
 * JD-Core Version:    0.7.0.1
 */