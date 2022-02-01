package com.tencent.beacon.a.b;

import com.tencent.beacon.base.net.HttpMethod;
import com.tencent.beacon.base.net.a.f;
import com.tencent.beacon.base.net.a.f.a;
import java.util.LinkedHashMap;
import java.util.Map;

class c
  implements Runnable
{
  c(d paramd, String paramString1, String paramString2, Throwable paramThrowable, com.tencent.beacon.base.net.a.b paramb) {}
  
  public void run()
  {
    synchronized (this.e)
    {
      Object localObject1 = new LinkedHashMap(d.a());
      ((Map)localObject1).put("error_code", this.a);
      ((Map)localObject1).put("error_msg", this.b);
      ((Map)localObject1).put("error_stack_full", com.tencent.beacon.base.util.b.a(this.c));
      ((Map)localObject1).put("_dc", String.valueOf(Math.random()));
      f.a locala = f.b();
      locala = locala.b("https://h.trace.qq.com/kv");
      localObject1 = locala.a("atta").a((Map)localObject1).a(HttpMethod.POST).a();
      com.tencent.beacon.base.net.d.c().a((f)localObject1).a(this.d);
      com.tencent.beacon.base.util.c.d("[atta] upload a new error, errorCode: %s, message: %s, stack: %s", new Object[] { this.a, this.b, com.tencent.beacon.base.util.b.a(this.c) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.a.b.c
 * JD-Core Version:    0.7.0.1
 */