package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.c.m;
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

public class d
{
  private static final String a = "d";
  private static ExecutorService b = ExecutorsUtils.newCachedThreadPool("GRS_GrsClient-Init");
  private GrsBaseInfo c;
  private boolean d = false;
  private final Object e = new Object();
  private Context f;
  private m g;
  private com.huawei.hms.framework.network.grs.a.a h;
  private com.huawei.hms.framework.network.grs.a.c i;
  private com.huawei.hms.framework.network.grs.a.c j;
  private a k;
  private Future<Boolean> l;
  
  d(Context paramContext, GrsBaseInfo arg2)
  {
    this.f = paramContext.getApplicationContext();
    a(???);
    if (!this.d) {
      synchronized (this.e)
      {
        if (!this.d)
        {
          GrsBaseInfo localGrsBaseInfo = this.c;
          Context localContext = this.f;
          this.l = b.submit(new c(this, localContext, localGrsBaseInfo, paramContext));
        }
        return;
      }
    }
  }
  
  d(GrsBaseInfo paramGrsBaseInfo)
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
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      paramMap = paramMap.keySet().iterator();
      while (paramMap.hasNext())
      {
        String str1 = (String)paramMap.next();
        if (str1.endsWith("time"))
        {
          String str2 = this.i.a(str1, "");
          boolean bool = TextUtils.isEmpty(str2);
          long l2 = 0L;
          long l1 = l2;
          if (!bool)
          {
            l1 = l2;
            if (str2.matches("\\d+")) {
              try
              {
                l1 = Long.parseLong(str2);
              }
              catch (NumberFormatException localNumberFormatException)
              {
                Logger.w(a, "convert expire time from String to Long catch NumberFormatException.", localNumberFormatException);
                l1 = l2;
              }
            }
          }
          if (!a(l1))
          {
            Logger.i(a, "init interface auto clear some invalid sp's data.");
            String str3 = str1.substring(0, str1.length() - 4);
            this.i.a(str3);
            this.i.a(str1);
          }
        }
      }
      return;
    }
    Logger.v(a, "sp's content is empty.");
  }
  
  private boolean a(long paramLong)
  {
    return System.currentTimeMillis() - paramLong <= 604800000L;
  }
  
  private boolean d()
  {
    boolean bool = false;
    try
    {
      if (this.l != null) {
        bool = ((Boolean)this.l.get(10L, TimeUnit.SECONDS)).booleanValue();
      }
      return bool;
    }
    catch (Exception localException)
    {
      Logger.w(a, "init compute task occur unknown Exception", localException);
      return false;
      Logger.w(a, "init compute task timed out");
      return false;
    }
    catch (InterruptedException localInterruptedException)
    {
      Logger.w(a, "init compute task interrupted.", localInterruptedException);
      return false;
    }
    catch (ExecutionException localExecutionException)
    {
      Logger.w(a, "init compute task failed.", localExecutionException);
      return false;
      Logger.i(a, "init compute task canceled.");
      return false;
    }
    catch (CancellationException localCancellationException)
    {
      break label79;
    }
    catch (TimeoutException localTimeoutException)
    {
      label45:
      label79:
      break label45;
    }
  }
  
  String a(String paramString1, String paramString2)
  {
    if ((this.c != null) && (paramString1 != null) && (paramString2 != null))
    {
      if (d()) {
        return this.k.a(paramString1, paramString2, this.f);
      }
      return null;
    }
    Logger.w(a, "invalid para!");
    return null;
  }
  
  Map<String, String> a(String paramString)
  {
    if ((this.c != null) && (paramString != null))
    {
      if (d()) {
        return this.k.a(paramString, this.f);
      }
      return new HashMap();
    }
    Logger.w(a, "invalid para!");
    return new HashMap();
  }
  
  void a(String paramString, IQueryUrlsCallBack paramIQueryUrlsCallBack)
  {
    if (paramIQueryUrlsCallBack == null)
    {
      Logger.w(a, "IQueryUrlsCallBack is must not null for process continue.");
      return;
    }
    if ((this.c != null) && (paramString != null))
    {
      if (d()) {
        this.k.a(paramString, paramIQueryUrlsCallBack, this.f);
      }
      return;
    }
    paramIQueryUrlsCallBack.onCallBackFail(-6);
  }
  
  void a(String paramString1, String paramString2, IQueryUrlCallBack paramIQueryUrlCallBack)
  {
    if (paramIQueryUrlCallBack == null)
    {
      Logger.w(a, "IQueryUrlCallBack is must not null for process continue.");
      return;
    }
    if ((this.c != null) && (paramString1 != null) && (paramString2 != null))
    {
      if (d()) {
        this.k.a(paramString1, paramString2, paramIQueryUrlCallBack, this.f);
      }
      return;
    }
    paramIQueryUrlCallBack.onCallBackFail(-6);
  }
  
  boolean a(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (d.class != paramObject.getClass()) {
        return false;
      }
      if ((paramObject instanceof d))
      {
        paramObject = (d)paramObject;
        return this.c.compare(paramObject.c);
      }
    }
    return false;
  }
  
  void b()
  {
    if (!d()) {
      return;
    }
    String str = this.c.getGrsParasKey(false, true, this.f);
    this.i.a(str);
    com.huawei.hms.framework.network.grs.a.c localc = this.i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("time");
    localc.a(localStringBuilder.toString());
    this.g.a(str);
  }
  
  boolean c()
  {
    if (!d()) {
      return false;
    }
    GrsBaseInfo localGrsBaseInfo = this.c;
    if (localGrsBaseInfo != null)
    {
      Context localContext = this.f;
      if (localContext == null) {
        return false;
      }
      this.h.a(localGrsBaseInfo, localContext);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.d
 * JD-Core Version:    0.7.0.1
 */