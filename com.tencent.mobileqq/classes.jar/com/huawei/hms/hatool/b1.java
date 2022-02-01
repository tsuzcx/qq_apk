package com.huawei.hms.hatool;

import android.util.Pair;
import com.huawei.secure.android.common.encrypt.hash.SHA;
import java.util.List;
import java.util.Map;

public class b1
  extends v
{
  public static c1 a(String paramString1, String paramString2)
  {
    c1 localc1 = v.a(paramString1, paramString2);
    v0 localv0 = x0.a().c(paramString1, paramString2);
    localc1.g(x0.a().a(c.c(paramString1, paramString2)));
    localc1.f(c.o(paramString1, paramString2));
    localc1.c(x0.a().f(paramString1, paramString2));
    paramString1 = localv0.a();
    int i = b1.a.a[paramString1.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return localc1;
        }
        localc1.e(localv0.b());
        return localc1;
      }
      localc1.b(localv0.b());
      return localc1;
    }
    localc1.d(localv0.b());
    return localc1;
  }
  
  public static d1 a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString1 = v.a(paramString1, paramString2, paramString3, paramString4);
    paramString2 = x0.a().a(c.c(paramString2, paramString3));
    long l = System.currentTimeMillis();
    paramString3 = new StringBuilder();
    paramString3.append(b.c());
    paramString3.append(paramString2);
    paramString3.append(l);
    paramString2 = SHA.sha256Encrypt(paramString3.toString());
    paramString1.f(String.valueOf(l));
    paramString1.g(paramString2);
    return paramString1;
  }
  
  public static e1 a(String paramString1, String paramString2, String paramString3)
  {
    paramString3 = v.a(paramString1, paramString2, paramString3);
    Pair localPair = x0.a().e(paramString2, paramString1);
    paramString3.f((String)localPair.first);
    paramString3.g((String)localPair.second);
    paramString3.h(f.b());
    paramString3.d(x0.a().d(paramString2, paramString1));
    return paramString3;
  }
  
  public static r a(List<q> paramList, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    y.c("hmsSdk", "generate UploadData");
    r localr = v.a();
    if (localr == null) {
      return null;
    }
    localr.a(a(x.f().a(), paramString1, paramString2, paramString3));
    localr.a(a(paramString1, paramString2));
    localr.a(a(paramString2, paramString1, paramString4));
    localr.a(c.g(paramString1, paramString2));
    localr.a(paramList);
    return localr;
  }
  
  public static Map<String, String> b(String paramString1, String paramString2, String paramString3)
  {
    paramString3 = v.b(paramString1, paramString3);
    paramString1 = c.i(paramString1, paramString2);
    if (paramString1 == null) {
      return paramString3;
    }
    paramString3.putAll(paramString1);
    return paramString3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.hatool.b1
 * JD-Core Version:    0.7.0.1
 */