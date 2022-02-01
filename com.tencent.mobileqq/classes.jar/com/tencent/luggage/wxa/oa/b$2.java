package com.tencent.luggage.wxa.oa;

import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.nz.j;
import com.tencent.luggage.wxa.ot.c;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.rz.g;
import com.tencent.mars.cdn.CronetLogic;
import com.tencent.mars.cdn.CronetLogic.CronetDownloadProgress;
import com.tencent.mars.cdn.CronetLogic.CronetTaskCallback;
import com.tencent.mars.cdn.CronetLogic.CronetTaskResult;
import com.tencent.mars.cdn.CronetLogic.ResponseHeader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

class b$2
  implements CronetLogic.CronetTaskCallback
{
  b$2(b paramb, com.tencent.luggage.wxa.sj.b paramb1, b.a parama, long paramLong) {}
  
  public int onCronetReceiveHeader(CronetLogic.ResponseHeader paramResponseHeader, int paramInt)
  {
    o.d("MicroMsg.AppBrandDownloadWorker", "cronet file download onCronetReceiveHeader status %d,taskid:%s,CronetRequestId:%s", new Object[] { Integer.valueOf(paramInt), b.g(this.d), b.f(this.d) });
    paramResponseHeader = CronetLogic.getHeaderList(paramResponseHeader);
    Object localObject1 = j.a(paramResponseHeader, 2);
    b.e(this.d).a((JSONObject)localObject1);
    paramResponseHeader = paramResponseHeader.entrySet().iterator();
    while (paramResponseHeader.hasNext())
    {
      Object localObject2 = (Map.Entry)paramResponseHeader.next();
      localObject1 = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (List)((Map.Entry)localObject2).getValue();
      if ((!af.c((String)localObject1)) && (localObject2 != null) && (!((List)localObject2).isEmpty()))
      {
        if (((String)localObject1).equals("Content-Length"))
        {
          o.d("MicroMsg.AppBrandDownloadWorker", "onCronetReceiveHeader Content-Length:%s", new Object[] { ((List)localObject2).get(0) });
          paramInt = Integer.parseInt((String)((List)localObject2).get(0));
          break label242;
        }
        if (((String)localObject1).equals("content-length"))
        {
          o.d("MicroMsg.AppBrandDownloadWorker", "onCronetReceiveHeader content-length:%s", new Object[] { ((List)localObject2).get(0) });
          paramInt = Integer.parseInt((String)((List)localObject2).get(0));
          break label242;
        }
      }
    }
    paramInt = 0;
    label242:
    if (paramInt > 0) {
      ((c)e.b(c.class)).a(1197L, 16L, paramInt, false);
    } else {
      o.b("MicroMsg.AppBrandDownloadWorker", "cronet onCronetReceiveHeader contentLength fail");
    }
    if ((paramInt > 0) && (b.h(this.d) > 0) && (paramInt >= b.h(this.d) * 1048576))
    {
      o.d("MicroMsg.AppBrandDownloadWorker", "onCronetReceiveHeader before actually read stream, contentLength %d exceed limit", new Object[] { Integer.valueOf(paramInt) });
      if (!b.b(this.d))
      {
        b.a(this.d, true);
        b.e(this.d).a(b.c(this.d), b.d(this.d), "exceed max file size");
      }
      else
      {
        o.b("MicroMsg.AppBrandDownloadWorker", "cronet onCronetReceiveHeader max file size already callback");
      }
      paramResponseHeader = this.a;
      if (paramResponseHeader != null)
      {
        paramResponseHeader.b();
        o.d("MicroMsg.AppBrandDownloadWorker", "cronet onCronetReceiveHeader exceed max file size TimerTask cancel");
      }
      return -1;
    }
    return 0;
  }
  
  public void onCronetTaskCompleted(String paramString, CronetLogic.CronetTaskResult paramCronetTaskResult)
  {
    o.d("MicroMsg.AppBrandDownloadWorker", "onCronetTaskCompleted errorCode:%d,errorMsg:%s,statusCode:%d,totalReceiveByte:%d,taskid:%s,CronetRequestId:%s,fileKey:%s", new Object[] { Integer.valueOf(paramCronetTaskResult.errorCode), paramCronetTaskResult.errorMsg, Integer.valueOf(paramCronetTaskResult.statusCode), Long.valueOf(paramCronetTaskResult.totalReceiveByte), b.g(this.d), b.f(this.d), paramString });
    paramString = this.a;
    if (paramString != null) {
      paramString.b();
    }
    f.a.c(new b.2.1(this, paramCronetTaskResult));
  }
  
  public void onDownloadProgressChanged(String paramString, CronetLogic.CronetDownloadProgress paramCronetDownloadProgress)
  {
    if (j.a(this.d.a))
    {
      o.c("MicroMsg.AppBrandDownloadWorker", "onDownloadProgressChanged shouldStopTask fileKey:%s,taskid %s,CronetRequestId:%s", new Object[] { paramString, b.g(this.d), b.f(this.d) });
      if (!b.b(this.d))
      {
        b.a(this.d, true);
        CronetLogic.cancelCronetTask(b.f(this.d));
        b.e(this.d).a(b.c(this.d), b.d(this.d), "interrupted");
      }
      else
      {
        o.b("MicroMsg.AppBrandDownloadWorker", "onDownloadProgressChanged already callback");
      }
      paramString = this.a;
      if (paramString != null)
      {
        paramString.b();
        o.d("MicroMsg.AppBrandDownloadWorker", "cronet onDownloadProgressChanged shouldStopTask TimerTask cancel");
      }
      return;
    }
    if ((paramCronetDownloadProgress.currentWriteByte > 0L) && (b.h(this.d) > 0) && (paramCronetDownloadProgress.currentWriteByte >= b.h(this.d) * 1048576))
    {
      if (!b.b(this.d))
      {
        o.d("MicroMsg.AppBrandDownloadWorker", "onDownloadProgressChanged currentWriteByte %d exceed limit,fileKey:%s,taskid %s,CronetRequestId:%s", new Object[] { Long.valueOf(paramCronetDownloadProgress.currentWriteByte), paramString, b.g(this.d), b.f(this.d) });
        b.a(this.d, true);
        CronetLogic.cancelCronetTask(b.f(this.d));
        b.e(this.d).a(b.c(this.d), b.d(this.d), "exceed max file size");
        paramString = this.a;
        if (paramString != null)
        {
          paramString.b();
          o.d("MicroMsg.AppBrandDownloadWorker", "cronet onDownloadProgressChanged exceed max file size TimerTask cancel");
        }
        return;
      }
      o.b("MicroMsg.AppBrandDownloadWorker", "cronet onDownloadProgressChanged max file size already callback");
      return;
    }
    if ((paramCronetDownloadProgress.totalByte > 0L) && (b.i(this.d)))
    {
      this.b.b = ((int)(paramCronetDownloadProgress.currentWriteByte * 100L / paramCronetDownloadProgress.totalByte));
      if (this.b.c != this.b.b)
      {
        b.e(this.d).a(b.c(this.d), b.d(this.d), this.b.b, paramCronetDownloadProgress.currentWriteByte, paramCronetDownloadProgress.totalByte);
        paramString = this.b;
        paramString.c = paramString.b;
      }
      if (this.b.b == 100) {
        o.d("MicroMsg.AppBrandDownloadWorker", "cronet download size %d, totalSize %d, percent = %d", new Object[] { Long.valueOf(paramCronetDownloadProgress.currentWriteByte), Long.valueOf(paramCronetDownloadProgress.totalByte), Integer.valueOf(this.b.b) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.oa.b.2
 * JD-Core Version:    0.7.0.1
 */