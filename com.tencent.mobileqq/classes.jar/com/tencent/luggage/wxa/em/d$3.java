package com.tencent.luggage.wxa.em;

import com.tencent.luggage.wxa.cx.s;
import com.tencent.luggage.wxa.iu.d.b;
import com.tencent.luggage.wxa.oy.a;
import com.tencent.luggage.wxa.qz.o;
import java.util.concurrent.atomic.AtomicBoolean;

class d$3
  extends d.b
{
  private final AtomicBoolean b = new AtomicBoolean(false);
  
  d$3(d paramd) {}
  
  public void a()
  {
    o.b("Luggage.STANDALONE.Runtime", "ResourcePrepareProcess.interrupt() appId:%s, hash:%d", new Object[] { this.a.aa(), Integer.valueOf(hashCode()) });
    super.a();
    this.b.set(true);
  }
  
  public void b()
  {
    o.d("Luggage.STANDALONE.Runtime", "ResourcePrepareProcess.prepare() appId:%s, hash:%d", new Object[] { this.a.aa(), Integer.valueOf(hashCode()) });
    com.tencent.mm.plugin.appbrand.keylogger.d.a(this.a.aa(), a.k);
    com.tencent.mm.plugin.appbrand.keylogger.d.a(this.a.aa(), a.m);
    s.a(this.a, new d.3.1(this, this));
  }
  
  public String c()
  {
    return "WxaLaunchPrepareProcess";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.em.d.3
 * JD-Core Version:    0.7.0.1
 */