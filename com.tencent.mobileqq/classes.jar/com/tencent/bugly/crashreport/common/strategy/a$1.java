package com.tencent.bugly.crashreport.common.strategy;

import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.Map;

final class a$1
  extends Thread
{
  a$1(a parama) {}
  
  public final void run()
  {
    try
    {
      Object localObject2 = p.a().a(a.a, null, true);
      if (localObject2 != null)
      {
        localObject1 = (byte[])((Map)localObject2).get("device");
        localObject2 = (byte[])((Map)localObject2).get("gateway");
        if (localObject1 != null) {
          com.tencent.bugly.crashreport.common.info.a.a(a.a(this.a)).e(new String((byte[])localObject1));
        }
        if (localObject2 != null) {
          com.tencent.bugly.crashreport.common.info.a.a(a.a(this.a)).d(new String((byte[])localObject2));
        }
      }
      Object localObject1 = this.a;
      localObject2 = this.a;
      a.a((a)localObject1, a.d());
      if (a.b(this.a) != null) {
        if ((!z.a(a.e())) && (z.c(a.e())))
        {
          a.b(this.a).q = a.e();
          a.b(this.a).r = a.e();
        }
        else
        {
          a.b(this.a).q = StrategyBean.b;
          a.b(this.a).r = StrategyBean.c;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      if (!x.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    a locala = this.a;
    locala.a(a.b(locala), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.bugly.crashreport.common.strategy.a.1
 * JD-Core Version:    0.7.0.1
 */