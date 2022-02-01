package com.tencent.luggage.wxa.nz;

import android.text.TextUtils;
import com.tencent.luggage.wxa.pd.p;
import com.tencent.luggage.wxa.pd.q;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.qz.x;
import com.tencent.mars.cdn.CronetLogic;
import com.tencent.mars.cdn.CronetLogic.CronetDownloadProgress;
import com.tencent.mars.cdn.CronetLogic.CronetTaskCallback;
import com.tencent.mars.cdn.CronetLogic.CronetTaskResult;
import com.tencent.mars.cdn.CronetLogic.ResponseHeader;
import com.tencent.mars.cdn.CronetLogic.WebPageProfile;
import java.lang.ref.WeakReference;
import java.util.Set;
import org.json.JSONObject;

class d$1
  implements CronetLogic.CronetTaskCallback
{
  d$1(d paramd, e parame, d.a parama, long paramLong) {}
  
  public int onCronetReceiveHeader(CronetLogic.ResponseHeader paramResponseHeader, int paramInt)
  {
    return 0;
  }
  
  public void onCronetTaskCompleted(String paramString, CronetLogic.CronetTaskResult paramCronetTaskResult)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandNetworkRequest", "cronet onCronetTaskCompleted errorCode:%d,errorMsg:%s,statusCode:%d,totalReceiveByte:%d,taskid:%s,CronetRequestId:%s,fileKey:%s", new Object[] { Integer.valueOf(paramCronetTaskResult.errorCode), paramCronetTaskResult.errorMsg, Integer.valueOf(paramCronetTaskResult.statusCode), Long.valueOf(paramCronetTaskResult.totalReceiveByte), this.a.i(), this.a.j(), paramString });
    if (paramCronetTaskResult.webPageProfile != null) {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandNetworkRequest", "cronet onCronetTaskCompleted profile, protocol:%s, ip:%s, port:%d", new Object[] { paramCronetTaskResult.webPageProfile.protocol, paramCronetTaskResult.webPageProfile.peerIP, Integer.valueOf(paramCronetTaskResult.webPageProfile.port) });
    } else {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandNetworkRequest", "cronet profile is empty");
    }
    d.a(this.d, this.a);
    Object localObject;
    int i;
    if (paramCronetTaskResult.errorCode == 0)
    {
      localObject = j.a(paramCronetTaskResult.getHeaderMapList(), 2);
      this.b.a((JSONObject)localObject);
      i = paramCronetTaskResult.statusCode;
      if (i != 200)
      {
        com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandNetworkRequest", "cronet failed code: %d,url is %s", new Object[] { Integer.valueOf(i), this.a.a() });
        if (j.b(i))
        {
          paramString = paramCronetTaskResult.newLocation;
          int j = this.a.h();
          if (!TextUtils.isEmpty(paramString))
          {
            if (j <= 0)
            {
              com.tencent.luggage.wxa.qz.o.c("MicroMsg.AppBrandNetworkRequest", "cronet reach the max redirect count(%d)", new Object[] { Integer.valueOf(15) });
              if (!this.a.q())
              {
                this.a.a(true);
                if (this.a.u()) {
                  d.a(this.d, this.b, "ok", "reach the max redirect count 15", i, (JSONObject)localObject, this.a.i(), null, j.a(paramCronetTaskResult.webPageProfile));
                } else {
                  d.a(this.d, this.b, "ok", "reach the max redirect count 15", i, (JSONObject)localObject, this.a.i(), null, null);
                }
              }
              else
              {
                com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandNetworkRequest", "cronet onC2CDownloadCompleted max redirect already callback");
              }
              ((com.tencent.luggage.wxa.ot.c)com.tencent.luggage.wxa.ba.e.b(com.tencent.luggage.wxa.ot.c.class)).a(1095L, 1L, 1L, false);
              return;
            }
            com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandNetworkRequest", "cronet redirect(%d) URL(%s) to URL(%s)", new Object[] { Integer.valueOf(j), this.a.a(), paramString });
            this.a.a(paramString);
            this.a.a(j - 1);
            com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandNetworkRequest", "cronet now redirect count = %d", new Object[] { Integer.valueOf(this.a.h()) });
            d.b(this.d, this.a);
            return;
          }
        }
        ((com.tencent.luggage.wxa.ot.c)com.tencent.luggage.wxa.ba.e.b(com.tencent.luggage.wxa.ot.c.class)).a(1095L, 3L, 1L, false);
      }
      if ("arraybuffer".equals(this.a.o())) {
        paramString = p.a(paramCronetTaskResult.data);
      } else {
        paramString = q.a(paramCronetTaskResult.getDataString());
      }
      if (!this.a.q())
      {
        this.a.a(true);
        if (this.a.u()) {
          d.a(this.d, this.b, "ok", paramString, paramCronetTaskResult.statusCode, (JSONObject)localObject, this.a.i(), null, j.a(paramCronetTaskResult.webPageProfile));
        } else {
          d.a(this.d, this.b, "ok", paramString, paramCronetTaskResult.statusCode, (JSONObject)localObject, this.a.i(), null, null);
        }
      }
      else
      {
        com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandNetworkRequest", "cronet onC2CDownloadCompleted if already callback");
      }
      long l = System.currentTimeMillis() - this.c;
      paramString = new StringBuilder();
      paramString.append("request time is ");
      paramString.append(l);
      com.tencent.luggage.wxa.qz.o.e("cronet request time", paramString.toString());
      ((com.tencent.luggage.wxa.ot.c)com.tencent.luggage.wxa.ba.e.b(com.tencent.luggage.wxa.ot.c.class)).a(1098L, 99L, l, false);
      ((com.tencent.luggage.wxa.ot.c)com.tencent.luggage.wxa.ba.e.b(com.tencent.luggage.wxa.ot.c.class)).a(1095L, 8L, 1L, false);
      ((o)com.tencent.luggage.wxa.ba.e.b(o.class)).a(d.a(this.d), this.a.l(), this.a.f(), this.a.a(), this.a.n(), paramCronetTaskResult.totalReceiveByte, i, 1, this.a.m(), "", "");
    }
    else
    {
      if (!this.a.q())
      {
        this.a.a(true);
        paramString = this.d;
        localObject = this.b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramCronetTaskResult.errorCode);
        localStringBuilder.append(":");
        localStringBuilder.append(paramCronetTaskResult.errorMsg);
        d.a(paramString, (d.a)localObject, "fail", localStringBuilder.toString(), this.a.i(), null);
      }
      else
      {
        com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandNetworkRequest", "onC2CDownloadCompleted else already callback");
      }
      ((o)com.tencent.luggage.wxa.ba.e.b(o.class)).a(d.a(this.d), this.a.l(), this.a.f(), this.a.a(), this.a.n(), 0L, 0, 2, this.a.m(), "", "");
      ((com.tencent.luggage.wxa.ot.c)com.tencent.luggage.wxa.ba.e.b(com.tencent.luggage.wxa.ot.c.class)).a(1095L, 5L, 1L, false);
      i = x.d(r.a());
      if (i == -1) {
        ((com.tencent.luggage.wxa.ot.c)com.tencent.luggage.wxa.ba.e.b(com.tencent.luggage.wxa.ot.c.class)).a(1095L, 4L, 1L, false);
      }
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d,url:%s", new Object[] { Integer.valueOf(i), this.a.a() });
    }
    d.b(this.d).remove(this.a.i());
  }
  
  public void onDownloadProgressChanged(String paramString, CronetLogic.CronetDownloadProgress paramCronetDownloadProgress)
  {
    paramCronetDownloadProgress = (com.tencent.luggage.wxa.jx.c)d.c(this.d).get();
    if ((paramCronetDownloadProgress != null) && (!j.a(paramCronetDownloadProgress))) {
      return;
    }
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandNetworkRequest", "onDownloadProgressChanged shouldStopTask fileKey:%s,taskid is %s,cronettaskid is %s", new Object[] { paramString, this.a.i(), this.a.j() });
    CronetLogic.cancelCronetTask(this.a.j());
    if (!this.a.q())
    {
      this.a.a(true);
      d.a(this.d, this.b, "fail", "interrupted", this.a.i(), null);
    }
    else
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandNetworkRequest", "onDownloadProgressChanged already callback");
    }
    d.a(this.d, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nz.d.1
 * JD-Core Version:    0.7.0.1
 */