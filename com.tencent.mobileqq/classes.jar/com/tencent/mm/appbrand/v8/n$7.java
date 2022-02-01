package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.V8Context;
import com.eclipsesource.mmv8.V8Object;
import com.tencent.luggage.wxa.qz.o;
import java.util.LinkedList;

class n$7
  implements Runnable
{
  n$7(n paramn) {}
  
  public void run()
  {
    if (this.a.b() != null) {
      try
      {
        V8Object localV8Object = this.a.b().getGlobalObject();
        n.a(this.a, localV8Object.getObject("console"));
      }
      catch (Throwable localThrowable)
      {
        o.b("MicroMsg.J2V8.V8ContextEngine", "get OriginConsole ex: %s", new Object[] { localThrowable.getMessage() });
      }
    }
    n.a(this.a).add(new r().a(this.a));
    n.a(this.a).add(new u().a(this.a));
    n.a(this.a).add(new t().a(this.a));
    o.e("MicroMsg.J2V8.V8ContextEngine", "hy: config is %s", new Object[] { n.b(this.a).a() });
    if (n.c(this.a).b())
    {
      o.d("MicroMsg.J2V8.V8ContextEngine", "[v8] [dl: ] [nativebuffer] use NativeBufferJNI");
      n.c(this.a).a(n.b(this.a).l(), this.a.c());
    }
    else
    {
      o.d("MicroMsg.J2V8.V8ContextEngine", "[v8] [dl: ] [nativebuffer] use V8DirectApi");
      n.a(this.a).add(new q(n.c(this.a)).a(this.a));
    }
    n.a(this.a).add(new s(n.d(this.a)).a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.n.7
 * JD-Core Version:    0.7.0.1
 */