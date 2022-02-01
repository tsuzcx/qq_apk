package com.huawei.hms.hatool;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;

public class d0
{
  public static d0 c;
  public String a;
  public String b;
  
  public static d0 f()
  {
    if (c == null) {
      g();
    }
    return c;
  }
  
  public static void g()
  {
    try
    {
      if (c == null) {
        c = new d0();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String a()
  {
    if (TextUtils.isEmpty(this.a)) {
      this.a = c();
    }
    return this.a;
  }
  
  public final String a(String paramString)
  {
    String str2;
    if (e()) {
      str2 = AesGcmKS.decrypt("analytics_keystore", paramString);
    } else {
      str2 = "";
    }
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      y.c("hmsSdk", "deCrypt work key first");
      paramString = d.a(paramString, d());
      if (TextUtils.isEmpty(paramString))
      {
        paramString = EncryptUtil.generateSecureRandomStr(16);
        c(b(paramString));
        str1 = paramString;
        if (!e()) {}
      }
      else
      {
        for (;;)
        {
          c0.d();
          return paramString;
          str1 = paramString;
          if (!e()) {
            break;
          }
          c(b(paramString));
        }
      }
    }
    return str1;
  }
  
  public final String b(String paramString)
  {
    if (e()) {
      return AesGcmKS.encrypt("analytics_keystore", paramString);
    }
    return d.b(paramString, d());
  }
  
  public void b()
  {
    String str = EncryptUtil.generateSecureRandomStr(16);
    if (c(b(str))) {
      this.a = str;
    }
  }
  
  public final String c()
  {
    String str = g0.a(b.f(), "Privacy_MY", "PrivacyData", "");
    if (TextUtils.isEmpty(str))
    {
      str = EncryptUtil.generateSecureRandomStr(16);
      c(b(str));
      return str;
    }
    return a(str);
  }
  
  public final boolean c(String paramString)
  {
    y.c("hmsSdk", "refresh sp aes key");
    if (TextUtils.isEmpty(paramString))
    {
      y.c("hmsSdk", "refreshLocalKey(): encrypted key is empty");
      return false;
    }
    g0.b(b.f(), "Privacy_MY", "PrivacyData", paramString);
    g0.b(b.f(), "Privacy_MY", "flashKeyTime", System.currentTimeMillis());
    return true;
  }
  
  public final String d()
  {
    if (TextUtils.isEmpty(this.b)) {
      this.b = new c0().a();
    }
    return this.b;
  }
  
  public final boolean e()
  {
    return Build.VERSION.SDK_INT >= 23;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.hatool.d0
 * JD-Core Version:    0.7.0.1
 */