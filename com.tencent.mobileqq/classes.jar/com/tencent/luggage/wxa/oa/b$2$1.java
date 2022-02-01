package com.tencent.luggage.wxa.oa;

import android.text.TextUtils;
import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.nz.j;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.qz.x;
import com.tencent.mars.cdn.CronetLogic.CronetTaskResult;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class b$2$1
  implements Runnable
{
  b$2$1(b.2 param2, CronetLogic.CronetTaskResult paramCronetTaskResult) {}
  
  public void run()
  {
    int i = (int)this.a.totalReceiveByte;
    int j = this.a.statusCode;
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandDownloadWorker", "appbrand_cronetdownload_callback_thread run taskid:%s,CronetRequestId:%s", new Object[] { b.g(this.b.d), b.f(this.b.d) });
    int k = this.a.errorCode;
    Object localObject1 = "";
    Object localObject2;
    Object localObject3;
    String str;
    if (k == 0)
    {
      b.a(this.b.d, j);
      localObject2 = this.a.getHeaderMap().entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        str = (String)((Map.Entry)localObject3).getKey();
        localObject3 = (String)((Map.Entry)localObject3).getValue();
        if ((str.equalsIgnoreCase("Content-Type")) || (str.equalsIgnoreCase("content-type"))) {
          localObject1 = b.a(this.b.d, (String)localObject3, b.d(this.b.d));
        }
      }
      if (j != 200)
      {
        com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandDownloadWorker", "failed code: %d,url is %s,filename is %s ", new Object[] { Integer.valueOf(j), b.d(this.b.d), b.c(this.b.d) });
        if (j.b(j))
        {
          localObject2 = this.a.newLocation;
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            if (b.j(this.b.d) <= 0)
            {
              com.tencent.luggage.wxa.qz.o.c("MicroMsg.AppBrandDownloadWorker", "reach the max redirect count(%d)", new Object[] { Integer.valueOf(15) });
              if (!b.b(this.b.d))
              {
                b.a(this.b.d, true);
                if (b.k(this.b.d)) {
                  b.e(this.b.d).a(b.c(this.b.d), (String)localObject1, b.d(this.b.d), j, 0L, j.a(this.a.webPageProfile));
                } else {
                  b.e(this.b.d).a(b.c(this.b.d), (String)localObject1, b.d(this.b.d), j, 0L, null);
                }
                ((com.tencent.luggage.wxa.nz.o)e.b(com.tencent.luggage.wxa.nz.o.class)).a(this.b.d.a.getAppId(), this.b.d.d(), "GET", this.b.d.a(), 0L, i, j, 1, this.b.d.e(), b.c(this.b.d), (String)localObject1);
                ((com.tencent.luggage.wxa.ot.c)e.b(com.tencent.luggage.wxa.ot.c.class)).a(1197L, 10L, 1L, false);
                ((com.tencent.luggage.wxa.ot.c)e.b(com.tencent.luggage.wxa.ot.c.class)).a(1197L, 12L, System.currentTimeMillis() - b.l(this.b.d), false);
                return;
              }
              com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandDownloadWorker", "cronet onCronetTaskCompleted max redirect already callback");
              return;
            }
            com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandDownloadWorker", "redirect(%d) URL(%s) to URL(%s)", new Object[] { Integer.valueOf(b.m(this.b.d)), b.d(this.b.d), localObject2 });
            b.a(this.b.d, (String)localObject2);
            this.b.d.run();
            return;
          }
        }
      }
      if (!b.b(this.b.d))
      {
        b.a(this.b.d, true);
        if (b.i(this.b.d))
        {
          if (b.k(this.b.d)) {
            b.e(this.b.d).a(b.c(this.b.d), (String)localObject1, b.d(this.b.d), j, i, j.a(this.a.webPageProfile));
          } else {
            b.e(this.b.d).a(b.c(this.b.d), (String)localObject1, b.d(this.b.d), j, i, null);
          }
          b.a(this.b.d, this.a.totalReceiveByte, System.currentTimeMillis() - b.l(this.b.d));
          this.b.b.a = true;
        }
        else
        {
          b.e(this.b.d).a(b.c(this.b.d), b.d(this.b.d), "force stop");
        }
        com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandDownloadWorker", "cronet download file finished taskid:%s,CronetRequestId:%s,contentType:%s,filename: %s, url:%s ", new Object[] { b.g(this.b.d), b.f(this.b.d), localObject1, b.c(this.b.d), b.d(this.b.d) });
        b.e(this.b.d).a(this.b.d.c());
        ((com.tencent.luggage.wxa.nz.o)e.b(com.tencent.luggage.wxa.nz.o.class)).a(this.b.d.a.getAppId(), this.b.d.d(), "GET", this.b.d.a(), 0L, i, j, 1, this.b.d.e(), b.c(this.b.d), (String)localObject1);
        ((com.tencent.luggage.wxa.ot.c)e.b(com.tencent.luggage.wxa.ot.c.class)).a(1197L, 10L, 1L, false);
        ((com.tencent.luggage.wxa.ot.c)e.b(com.tencent.luggage.wxa.ot.c.class)).a(1197L, 12L, System.currentTimeMillis() - b.l(this.b.d), false);
        long l = System.currentTimeMillis() - this.b.c;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("request time is ");
        ((StringBuilder)localObject1).append(l);
        com.tencent.luggage.wxa.qz.o.d("cronet download time", ((StringBuilder)localObject1).toString());
        ((com.tencent.luggage.wxa.ot.c)e.b(com.tencent.luggage.wxa.ot.c.class)).a(1199L, 99L, l, false);
        ((com.tencent.luggage.wxa.ot.c)e.b(com.tencent.luggage.wxa.ot.c.class)).a(1199L, 97L, 1L, false);
        return;
      }
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandDownloadWorker", "cronet onCronetTaskCompleted already callback");
      return;
    }
    if (!b.b(this.b.d))
    {
      b.a(this.b.d, true);
      localObject1 = b.e(this.b.d);
      localObject2 = b.c(this.b.d);
      str = b.d(this.b.d);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("download fail:");
      ((StringBuilder)localObject3).append(this.a.errorCode);
      ((StringBuilder)localObject3).append(":");
      ((StringBuilder)localObject3).append(this.a.errorMsg);
      ((a)localObject1).a((String)localObject2, str, ((StringBuilder)localObject3).toString());
      ((com.tencent.luggage.wxa.nz.o)e.b(com.tencent.luggage.wxa.nz.o.class)).a(this.b.d.a.getAppId(), this.b.d.d(), "GET", this.b.d.a(), 0L, i, j, 2, this.b.d.e(), b.c(this.b.d), "");
      ((com.tencent.luggage.wxa.ot.c)e.b(com.tencent.luggage.wxa.ot.c.class)).a(1197L, 11L, 1L, false);
      ((com.tencent.luggage.wxa.ot.c)e.b(com.tencent.luggage.wxa.ot.c.class)).a(1197L, 13L, System.currentTimeMillis() - b.l(this.b.d), false);
      i = x.d(r.a());
      if (i == -1) {
        ((com.tencent.luggage.wxa.ot.c)e.b(com.tencent.luggage.wxa.ot.c.class)).a(1197L, 7L, 1L, false);
      }
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandDownloadWorker", "cronet downloadFile fail ret:%d", new Object[] { Integer.valueOf(i) });
      return;
    }
    com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandDownloadWorker", "cronet onCronetTaskCompleted downloadFile fail already callback");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.oa.b.2.1
 * JD-Core Version:    0.7.0.1
 */