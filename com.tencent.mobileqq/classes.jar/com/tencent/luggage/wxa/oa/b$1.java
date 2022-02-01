package com.tencent.luggage.wxa.oa;

import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.ot.c;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mars.cdn.CronetLogic;

class b$1
  extends com.tencent.luggage.wxa.sj.b
{
  b$1(b paramb) {}
  
  public String a()
  {
    return "AppBrandDownloadWorker#TimerTask";
  }
  
  public void run()
  {
    o.b("MicroMsg.AppBrandDownloadWorker", "call cronet time out taskid:%s,timeout:%d,url:%s", new Object[] { this.a.c(), Integer.valueOf(b.a(this.a)), this.a.a() });
    if (!b.b(this.a))
    {
      b.a(this.a, true);
      b.e(this.a).a(b.c(this.a), b.d(this.a), "socket timeout");
    }
    else
    {
      o.b("MicroMsg.AppBrandDownloadWorker", "call cronet time out already callback");
    }
    ((c)e.b(c.class)).a(1197L, 6L, 1L, false);
    if (!af.c(b.f(this.a))) {
      CronetLogic.cancelCronetTask(b.f(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.oa.b.1
 * JD-Core Version:    0.7.0.1
 */