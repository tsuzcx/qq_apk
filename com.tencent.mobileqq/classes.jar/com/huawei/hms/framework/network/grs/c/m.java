package com.huawei.hms.framework.network.grs.c;

import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.a.a;
import com.huawei.hms.framework.network.grs.d.d;
import com.huawei.hms.framework.network.grs.d.d.a;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class m
{
  private ExecutorService a = ExecutorsUtils.newCachedThreadPool("GRS_RequestController-Task");
  private Map<String, com.huawei.hms.framework.network.grs.c.b.b> b = new ConcurrentHashMap(16);
  private final Object c = new Object();
  private a d;
  
  private void a(f paramf, com.huawei.hms.framework.network.grs.b paramb)
  {
    if (paramb != null)
    {
      if (paramf == null)
      {
        Logger.v("RequestController", "GrsResponse is null");
        paramb.a();
        return;
      }
      Logger.v("RequestController", "GrsResponse is not null");
      paramb.a(paramf);
    }
  }
  
  public f a(com.huawei.hms.framework.network.grs.c.b.c paramc, String paramString, com.huawei.hms.framework.network.grs.a.c paramc1)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("request to server with service name is: ");
    ((StringBuilder)???).append(paramString);
    Logger.d("RequestController", ((StringBuilder)???).toString());
    String str = paramc.b().getGrsParasTag(false, true, paramc.a());
    ??? = new StringBuilder();
    ((StringBuilder)???).append("request spUrlKey: ");
    ((StringBuilder)???).append(str);
    Logger.v("RequestController", ((StringBuilder)???).toString());
    synchronized (this.c)
    {
      if (!NetworkUtil.isNetworkAvailable(paramc.a())) {
        return null;
      }
      d.a locala = d.a(str);
      com.huawei.hms.framework.network.grs.c.b.b localb = (com.huawei.hms.framework.network.grs.c.b.b)this.b.get(str);
      if ((localb != null) && (localb.b()))
      {
        paramc = localb.a();
      }
      else
      {
        if ((locala != null) && (locala.a())) {
          return null;
        }
        Logger.d("RequestController", "hitGrsRequestBean == null or request block is released.");
        paramc = this.a.submit(new k(this, paramc, paramString, paramc1));
        this.b.put(str, new com.huawei.hms.framework.network.grs.c.b.b(paramc));
      }
      try
      {
        paramc = (f)paramc.get();
        return paramc;
      }
      catch (InterruptedException paramc)
      {
        paramString = "when check result, find InterruptedException, check others";
      }
      catch (ExecutionException paramc)
      {
        paramString = "when check result, find ExecutionException, check others";
      }
      catch (CancellationException paramc)
      {
        paramString = "when check result, find CancellationException, check others";
      }
      Logger.w("RequestController", paramString, paramc);
      return null;
    }
  }
  
  public void a(a parama)
  {
    this.d = parama;
  }
  
  public void a(com.huawei.hms.framework.network.grs.c.b.c paramc, com.huawei.hms.framework.network.grs.b paramb, String paramString, com.huawei.hms.framework.network.grs.a.c paramc1)
  {
    this.a.execute(new l(this, paramc, paramString, paramc1, paramb));
  }
  
  public void a(String paramString)
  {
    synchronized (this.c)
    {
      this.b.remove(paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.c.m
 * JD-Core Version:    0.7.0.1
 */