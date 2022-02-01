package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.b.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class c
{
  private static final String a = c.class.getSimpleName();
  private static ExecutorService b = ExecutorsUtils.newCachedThreadPool("GRS_GrsClient-Init");
  private GrsBaseInfo c;
  private boolean d = false;
  private final Object e = new Object();
  private Context f;
  private h g;
  private com.huawei.hms.framework.network.grs.a.a h;
  private com.huawei.hms.framework.network.grs.a.c i;
  private a j;
  private Future<Boolean> k;
  
  c(Context arg1, GrsBaseInfo paramGrsBaseInfo)
  {
    this.f = ???.getApplicationContext();
    this.g = new h();
    this.i = new com.huawei.hms.framework.network.grs.a.c(this.f);
    this.h = new com.huawei.hms.framework.network.grs.a.a(this.i, this.g);
    a(paramGrsBaseInfo);
    this.j = new a(this.c, this.h, this.g);
    if (!this.d) {
      synchronized (this.e)
      {
        if (!this.d)
        {
          paramGrsBaseInfo = this.c;
          Context localContext = this.f;
          this.k = b.submit(new c.1(this, localContext, paramGrsBaseInfo));
        }
        return;
      }
    }
  }
  
  c(GrsBaseInfo paramGrsBaseInfo)
  {
    a(paramGrsBaseInfo);
  }
  
  private void a(GrsBaseInfo paramGrsBaseInfo)
  {
    try
    {
      this.c = paramGrsBaseInfo.clone();
      return;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      Logger.w(a, "GrsClient catch CloneNotSupportedException", localCloneNotSupportedException);
      this.c = paramGrsBaseInfo.copy();
    }
  }
  
  private void a(Map<String, ?> paramMap)
  {
    if ((paramMap == null) || (paramMap.isEmpty())) {
      Logger.v(a, "sp's content is empty.");
    }
    String str1;
    do
    {
      return;
      while (!paramMap.hasNext()) {
        paramMap = paramMap.keySet().iterator();
      }
      str1 = (String)paramMap.next();
    } while (!str1.endsWith("time"));
    String str2 = this.i.a(str1, "");
    if ((!TextUtils.isEmpty(str2)) && (str2.matches("\\d+"))) {}
    for (;;)
    {
      try
      {
        l = Long.parseLong(str2);
        if (a(l)) {
          break;
        }
        Logger.i(a, "init interface auto clear some invalid sp's data.");
        str2 = str1.substring(0, str1.length() - "time".length());
        this.i.a(str2);
        this.i.a(str1);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        Logger.w(a, "convert expire time from String to Long catch NumberFormatException.", localNumberFormatException);
        l = 0L;
        continue;
      }
      long l = 0L;
    }
  }
  
  private boolean a(long paramLong)
  {
    return System.currentTimeMillis() - paramLong <= 604800000L;
  }
  
  private boolean c()
  {
    for (;;)
    {
      try
      {
        if (this.k != null)
        {
          bool = ((Boolean)this.k.get(10L, TimeUnit.SECONDS)).booleanValue();
          return bool;
        }
      }
      catch (CancellationException localCancellationException)
      {
        Logger.i(a, "init compute task canceled.");
        return false;
      }
      catch (ExecutionException localExecutionException)
      {
        Logger.w(a, "init compute task failed.", localExecutionException);
        return false;
      }
      catch (InterruptedException localInterruptedException)
      {
        Logger.w(a, "init compute task interrupted.", localInterruptedException);
        return false;
      }
      catch (TimeoutException localTimeoutException)
      {
        Logger.w(a, "init compute task timed out");
        return false;
      }
      catch (Exception localException)
      {
        Logger.w(a, "init compute task occur unknown Exception", localException);
        return false;
      }
      boolean bool = false;
    }
  }
  
  String a(String paramString1, String paramString2)
  {
    if ((this.c == null) || (paramString1 == null) || (paramString2 == null)) {
      Logger.w(a, "invalid para!");
    }
    while (!c()) {
      return null;
    }
    return this.j.a(paramString1, paramString2, this.f);
  }
  
  Map<String, String> a(String paramString)
  {
    if ((this.c == null) || (paramString == null))
    {
      Logger.w(a, "invalid para!");
      return new HashMap();
    }
    if (c()) {
      return this.j.a(paramString, this.f);
    }
    return new HashMap();
  }
  
  void a(String paramString, IQueryUrlsCallBack paramIQueryUrlsCallBack)
  {
    if (paramIQueryUrlsCallBack == null) {
      Logger.w(a, "IQueryUrlsCallBack is must not null for process continue.");
    }
    do
    {
      return;
      if ((this.c == null) || (paramString == null))
      {
        paramIQueryUrlsCallBack.onCallBackFail(-6);
        return;
      }
    } while (!c());
    this.j.a(paramString, paramIQueryUrlsCallBack, this.f);
  }
  
  void a(String paramString1, String paramString2, IQueryUrlCallBack paramIQueryUrlCallBack)
  {
    if (paramIQueryUrlCallBack == null) {
      Logger.w(a, "IQueryUrlCallBack is must not null for process continue.");
    }
    do
    {
      return;
      if ((this.c == null) || (paramString1 == null) || (paramString2 == null))
      {
        paramIQueryUrlCallBack.onCallBackFail(-6);
        return;
      }
    } while (!c());
    this.j.a(paramString1, paramString2, paramIQueryUrlCallBack, this.f);
  }
  
  boolean a()
  {
    if (!c()) {}
    while ((this.c == null) || (this.f == null)) {
      return false;
    }
    this.h.b(this.c, this.f);
    return true;
  }
  
  boolean a(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (paramObject == null);
        bool1 = bool2;
      } while (getClass() != paramObject.getClass());
      bool1 = bool2;
    } while (!(paramObject instanceof c));
    paramObject = (c)paramObject;
    return this.c.compare(paramObject.c);
  }
  
  void b()
  {
    if (!c()) {
      return;
    }
    String str = this.c.getGrsParasKey(false, true, this.f);
    this.i.a(str);
    this.i.a(str + "time");
    this.g.a(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.c
 * JD-Core Version:    0.7.0.1
 */