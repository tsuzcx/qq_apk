package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.proguard.w;
import java.util.Map;

public final class d
{
  private static d a;
  private com.tencent.bugly.crashreport.common.strategy.a b;
  private com.tencent.bugly.crashreport.common.info.a c;
  private b d;
  private Context e;
  
  private d(Context paramContext)
  {
    c localc = c.a();
    if (localc == null) {
      return;
    }
    this.b = com.tencent.bugly.crashreport.common.strategy.a.a();
    this.c = com.tencent.bugly.crashreport.common.info.a.a(paramContext);
    this.d = localc.p;
    this.e = paramContext;
    w.a().a(new d.1(this));
  }
  
  public static d a(Context paramContext)
  {
    if (a == null) {
      a = new d(paramContext);
    }
    return a;
  }
  
  public static void a(Thread paramThread, int paramInt, String paramString1, String paramString2, String paramString3, Map<String, String> paramMap)
  {
    w.a().a(new d.2(paramThread, paramInt, paramString1, paramString2, paramString3, paramMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.bugly.crashreport.crash.d
 * JD-Core Version:    0.7.0.1
 */