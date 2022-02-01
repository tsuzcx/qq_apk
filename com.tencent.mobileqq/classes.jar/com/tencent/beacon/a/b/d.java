package com.tencent.beacon.a.b;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.beacon.a.c.f;
import java.util.LinkedHashMap;
import java.util.Map;

public class d
{
  private static volatile d a;
  private static final Map<String, String> b = new LinkedHashMap();
  private boolean c = false;
  private boolean d = false;
  
  public static d b()
  {
    try
    {
      if (a == null) {
        try
        {
          if (a == null) {
            a = new d();
          }
        }
        finally {}
      }
      d locald = a;
      return locald;
    }
    finally {}
  }
  
  private void d()
  {
    try
    {
      boolean bool = this.c;
      if (bool) {
        return;
      }
      b.put("attaid", "00400014144");
      b.put("token", "6478159937");
      b.put("error_code", "");
      b.put("platform", "Android");
      b.put("uin", f.p().e());
      Map localMap = b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(Build.BOARD);
      localStringBuilder.append(" ");
      localStringBuilder.append(Build.MODEL);
      localMap.put("model", localStringBuilder.toString());
      b.put("os", f.p().z());
      b.put("error_msg", "");
      b.put("error_stack_full", "");
      b.put("app_version", com.tencent.beacon.a.c.b.a());
      b.put("sdk_version", com.tencent.beacon.a.c.c.d().i());
      b.put("product_id", com.tencent.beacon.a.c.c.d().f());
      b.put("_dc", "");
      this.c = true;
      return;
    }
    finally {}
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      a(paramString1, paramString2, null);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    try
    {
      a(paramString1, paramString2, paramThrowable, new b(this));
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void a(String paramString1, String paramString2, Throwable paramThrowable, com.tencent.beacon.base.net.a.b<com.tencent.beacon.base.net.a> paramb)
  {
    try
    {
      boolean bool = c();
      if (!bool) {
        return;
      }
      if (!this.c) {
        d();
      }
      if (TextUtils.isEmpty(paramString1))
      {
        com.tencent.beacon.base.util.c.b("[atta] errorCode isn't valid value!", new Object[0]);
        return;
      }
      a.a().a(new c(this, paramString1, paramString2, paramThrowable, paramb));
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public boolean c()
  {
    if (this.d) {
      return true;
    }
    if (com.tencent.beacon.base.util.c.a()) {
      return false;
    }
    String str = f.p().e();
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    return Math.abs(str.hashCode() % 10000) < 100.0D;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.a.b.d
 * JD-Core Version:    0.7.0.1
 */