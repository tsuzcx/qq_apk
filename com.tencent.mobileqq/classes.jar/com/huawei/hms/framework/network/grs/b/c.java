package com.huawei.hms.framework.network.grs.b;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.c.d.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;

public class c
  implements a
{
  private static final String a = c.class.getSimpleName();
  private GrsBaseInfo b;
  private Context c;
  private com.huawei.hms.framework.network.grs.a.a d;
  private d e;
  private ArrayList<Future<d>> f = new ArrayList();
  private ArrayList<d> g = new ArrayList();
  private JSONArray h = new JSONArray();
  private ArrayList<String> i = new ArrayList();
  private ArrayList<String> j = new ArrayList();
  private com.huawei.hms.framework.network.grs.b.b.c k;
  private long l = 1L;
  
  public c(GrsBaseInfo paramGrsBaseInfo, Context paramContext, com.huawei.hms.framework.network.grs.a.a parama)
  {
    this.b = paramGrsBaseInfo;
    this.c = paramContext;
    this.d = parama;
    b();
  }
  
  private d a(ExecutorService paramExecutorService, ArrayList<String> paramArrayList, String paramString)
  {
    int n = 0;
    Object localObject1 = null;
    Object localObject4;
    int m;
    if (n < paramArrayList.size())
    {
      localObject4 = (String)paramArrayList.get(n);
      if (!TextUtils.isEmpty((CharSequence)localObject4))
      {
        localObject4 = paramExecutorService.submit(new b((String)localObject4, n, this, this.c, paramString).f());
        this.f.add(localObject4);
        for (;;)
        {
          try
          {
            localObject4 = (d)((Future)localObject4).get(this.l, TimeUnit.SECONDS);
            localObject1 = localObject4;
            if (localObject4 == null) {
              continue;
            }
            localObject1 = localObject4;
          }
          catch (TimeoutException localTimeoutException2)
          {
            continue;
          }
          catch (InterruptedException localInterruptedException1)
          {
            continue;
          }
          catch (ExecutionException localExecutionException1)
          {
            continue;
          }
          catch (CancellationException localCancellationException2)
          {
            label127:
            continue;
          }
          try
          {
            if (!((d)localObject4).h()) {
              continue;
            }
            Logger.i(a, "grs request return body is not null and is OK.");
            m = 1;
            localObject1 = localObject4;
          }
          catch (CancellationException localCancellationException1)
          {
            localObject2 = localObject4;
            Logger.i(a, "{requestServer} the computation was cancelled");
            m = 1;
          }
          catch (ExecutionException localExecutionException2)
          {
            localObject2 = localObject4;
            localObject4 = localExecutionException2;
            Logger.w(a, "the computation threw an ExecutionException", (Throwable)localObject4);
            m = 0;
          }
          catch (InterruptedException localInterruptedException2)
          {
            localObject2 = localObject4;
            localObject4 = localInterruptedException2;
            Logger.w(a, "the current thread was interrupted while waiting", (Throwable)localObject4);
            m = 1;
          }
          catch (TimeoutException localTimeoutException1)
          {
            localObject3 = localObject4;
          }
        }
        if (m != 0) {
          Logger.v(a, "needBreak is true so need break current circulation");
        }
      }
    }
    for (;;)
    {
      return b(localObject1);
      Object localObject2;
      Object localObject3;
      Logger.w(a, "the wait timed out");
      m = 0;
      break label127;
      n += 1;
      break;
      m = 0;
      break label127;
    }
  }
  
  private d b(d paramd)
  {
    int n = this.f.size();
    int m = 0;
    for (;;)
    {
      if ((m >= n) || ((paramd != null) && (paramd.h()))) {
        return paramd;
      }
      try
      {
        d locald = (d)((Future)this.f.get(m)).get(40000L, TimeUnit.MILLISECONDS);
        paramd = locald;
      }
      catch (CancellationException localCancellationException)
      {
        for (;;)
        {
          Logger.i(a, "{checkResponse} when check result, find CancellationException, check others");
        }
      }
      catch (ExecutionException localExecutionException)
      {
        for (;;)
        {
          Logger.w(a, "{checkResponse} when check result, find ExecutionException, check others", localExecutionException);
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          Logger.w(a, "{checkResponse} when check result, find InterruptedException, check others", localInterruptedException);
        }
      }
      catch (TimeoutException localTimeoutException)
      {
        for (;;)
        {
          Logger.w(a, "{checkResponse} when check result, find TimeoutException, cancel current request task");
          if (!((Future)this.f.get(m)).isCancelled()) {
            ((Future)this.f.get(m)).cancel(true);
          }
        }
      }
      m += 1;
    }
    return paramd;
  }
  
  private d b(ExecutorService paramExecutorService, String paramString)
  {
    long l1 = SystemClock.elapsedRealtime();
    d locald = a(paramExecutorService, this.j, paramString);
    if (locald == null) {}
    for (int m = 0;; m = locald.l())
    {
      Logger.v(a, "use 2.0 interface return http's code is：{%s}", new Object[] { Integer.valueOf(m) });
      if ((m != 404) && (m != 401)) {
        break label152;
      }
      if ((!TextUtils.isEmpty(c())) || (!TextUtils.isEmpty(this.b.getAppName()))) {
        break;
      }
      Logger.i(a, "request grs server use 1.0 API must set appName,please check.");
      return null;
    }
    this.f.clear();
    Logger.i(a, "this env has not deploy new interface,so use old interface.");
    label152:
    for (paramExecutorService = a(paramExecutorService, this.i, paramString);; paramExecutorService = locald)
    {
      long l2 = SystemClock.elapsedRealtime();
      e.a(this.g, l2 - l1, this.h, this.c);
      return paramExecutorService;
    }
  }
  
  private void b()
  {
    Object localObject2 = com.huawei.hms.framework.network.grs.b.a.a.a(this.c);
    if (localObject2 == null)
    {
      Logger.w(a, "g*s***_se****er_conf*** maybe has a big error");
      return;
    }
    a((com.huawei.hms.framework.network.grs.b.b.c)localObject2);
    Object localObject1 = ((com.huawei.hms.framework.network.grs.b.b.c)localObject2).c();
    if ((localObject1 == null) || (((List)localObject1).size() <= 0))
    {
      Logger.v(a, "maybe grs_base_url config with [],please check.");
      return;
    }
    if (((List)localObject1).size() > 10) {
      throw new IllegalArgumentException("grs_base_url's count is larger than MAX value 10");
    }
    String str1 = ((com.huawei.hms.framework.network.grs.b.b.c)localObject2).a();
    localObject2 = ((com.huawei.hms.framework.network.grs.b.b.c)localObject2).b();
    if (((List)localObject1).size() > 0)
    {
      Iterator localIterator = ((List)localObject1).iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        if (!str2.startsWith("https://"))
        {
          Logger.w(a, "grs server just support https scheme url,please check.");
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(str2);
          Locale localLocale = Locale.ROOT;
          if (TextUtils.isEmpty(c())) {}
          for (localObject1 = this.b.getAppName();; localObject1 = c())
          {
            localStringBuilder.append(String.format(localLocale, str1, new Object[] { localObject1 }));
            localObject1 = this.b.getGrsReqParamJoint(false, false, "1.0", this.c);
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              localStringBuilder.append("?");
              localStringBuilder.append((String)localObject1);
            }
            localObject1 = localStringBuilder.toString();
            this.i.add(localObject1);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(str2);
            ((StringBuilder)localObject1).append((String)localObject2);
            str2 = this.b.getGrsReqParamJoint(false, false, c(), this.c);
            if (!TextUtils.isEmpty(str2))
            {
              ((StringBuilder)localObject1).append("?");
              ((StringBuilder)localObject1).append(str2);
            }
            this.j.add(((StringBuilder)localObject1).toString());
            break;
          }
        }
      }
    }
    Logger.v(a, "request to GRS server url is{%s} and {%s}", new Object[] { this.i, this.j });
  }
  
  private String c()
  {
    com.huawei.hms.framework.network.grs.local.model.a locala = com.huawei.hms.framework.network.grs.local.b.a(this.c.getPackageName()).a();
    String str = "";
    if (locala != null)
    {
      str = locala.a();
      Logger.v(a, "get appName from local assets is{%s}", new Object[] { str });
    }
    return str;
  }
  
  public com.huawei.hms.framework.network.grs.b.b.c a()
  {
    return this.k;
  }
  
  public d a(ExecutorService paramExecutorService, String paramString)
  {
    if ((this.i == null) || (this.j == null)) {
      return null;
    }
    try
    {
      com.huawei.hms.framework.network.grs.b.b.c localc = a();
      if (localc != null) {}
      for (int m = localc.d();; m = 10)
      {
        paramExecutorService = (d)paramExecutorService.submit(new c.1(this, paramExecutorService, paramString)).get(m, TimeUnit.SECONDS);
        return paramExecutorService;
      }
      return null;
    }
    catch (CancellationException paramExecutorService)
    {
      Logger.i(a, "{submitExcutorTaskWithTimeout} the computation was cancelled");
      return null;
    }
    catch (ExecutionException paramExecutorService)
    {
      Logger.w(a, "{submitExcutorTaskWithTimeout} the computation threw an ExecutionException", paramExecutorService);
      return null;
    }
    catch (InterruptedException paramExecutorService)
    {
      Logger.w(a, "{submitExcutorTaskWithTimeout} the current thread was interrupted while waiting", paramExecutorService);
      return null;
    }
    catch (TimeoutException paramExecutorService)
    {
      Logger.w(a, "{submitExcutorTaskWithTimeout} the wait timed out");
      return null;
    }
    catch (Exception paramExecutorService)
    {
      Logger.w(a, "{submitExcutorTaskWithTimeout} catch Exception", paramExecutorService);
    }
  }
  
  public void a(com.huawei.hms.framework.network.grs.b.b.c paramc)
  {
    this.k = paramc;
  }
  
  public void a(d paramd)
  {
    for (;;)
    {
      try
      {
        this.g.add(paramd);
        if ((this.e != null) && (this.e.h()))
        {
          Logger.v(a, "grsResponseResult is ok");
          return;
        }
        if (paramd.i())
        {
          Logger.i(a, "GRS server open 503 limiting strategy.");
          com.huawei.hms.framework.network.grs.c.d.a(this.b.getGrsParasKey(false, true, this.c), new d.a(paramd.e(), SystemClock.elapsedRealtime()));
          continue;
        }
        if (paramd.h()) {
          break label113;
        }
      }
      finally {}
      Logger.v(a, "grsResponseResult has exception so need return");
      continue;
      label113:
      this.e = paramd;
      this.d.a(this.b, this.e, this.c);
      int m = 0;
      while (m < this.f.size())
      {
        if ((!((String)this.i.get(m)).equals(paramd.k())) && (!((String)this.j.get(m)).equals(paramd.k())) && (!((Future)this.f.get(m)).isCancelled()))
        {
          Logger.i(a, "future cancel");
          ((Future)this.f.get(m)).cancel(true);
        }
        m += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.b.c
 * JD-Core Version:    0.7.0.1
 */