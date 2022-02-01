package com.huawei.hms.framework.network.grs.b;

import android.content.Context;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.a.a;
import com.huawei.hms.framework.network.grs.c.d.a;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class h
{
  private ExecutorService a = ExecutorsUtils.newCachedThreadPool("GRS_RequestController-Task");
  private Map<String, com.huawei.hms.framework.network.grs.b.b.b> b = new ConcurrentHashMap(16);
  private final Object c = new Object();
  private a d;
  
  private void a(d paramd, com.huawei.hms.framework.network.grs.b paramb)
  {
    if (paramb != null)
    {
      if (paramd == null)
      {
        Logger.v("RequestController", "GrsResponse is null");
        paramb.a();
      }
    }
    else {
      return;
    }
    Logger.v("RequestController", "GrsResponse is not null");
    paramb.a(paramd);
  }
  
  public d a(GrsBaseInfo paramGrsBaseInfo, Context paramContext, String paramString)
  {
    Logger.d("RequestController", "request to server with service name is: " + paramString);
    String str = paramGrsBaseInfo.getGrsParasKey(false, true, paramContext);
    synchronized (this.c)
    {
      d.a locala = com.huawei.hms.framework.network.grs.c.d.a(str);
      com.huawei.hms.framework.network.grs.b.b.b localb = (com.huawei.hms.framework.network.grs.b.b.b)this.b.get(str);
      if ((localb == null) || (!localb.b())) {
        if ((locala == null) || (!locala.a()))
        {
          Logger.d("RequestController", "hitGrsRequestBean == null or request block is released.");
          paramGrsBaseInfo = this.a.submit(new h.1(this, paramGrsBaseInfo, paramContext, paramString));
          this.b.put(str, new com.huawei.hms.framework.network.grs.b.b.b(paramGrsBaseInfo));
        }
      }
      try
      {
        paramGrsBaseInfo = (d)paramGrsBaseInfo.get();
        return paramGrsBaseInfo;
      }
      catch (CancellationException paramGrsBaseInfo)
      {
        Logger.w("RequestController", "when check result, find CancellationException, check others", paramGrsBaseInfo);
        return null;
      }
      catch (ExecutionException paramGrsBaseInfo)
      {
        for (;;)
        {
          Logger.w("RequestController", "when check result, find ExecutionException, check others", paramGrsBaseInfo);
        }
      }
      catch (InterruptedException paramGrsBaseInfo)
      {
        for (;;)
        {
          Logger.w("RequestController", "when check result, find InterruptedException, check others", paramGrsBaseInfo);
        }
      }
      return null;
      paramGrsBaseInfo = localb.a();
    }
  }
  
  public void a(GrsBaseInfo paramGrsBaseInfo, Context paramContext, com.huawei.hms.framework.network.grs.b paramb, String paramString)
  {
    this.a.submit(new h.2(this, paramGrsBaseInfo, paramContext, paramString, paramb));
  }
  
  public void a(a parama)
  {
    this.d = parama;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.b.h
 * JD-Core Version:    0.7.0.1
 */