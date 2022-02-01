package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.support.log.HMSLog;

public class p
  extends Thread
{
  public Context a;
  public k b;
  
  public p(Context paramContext, k paramk)
  {
    this.a = paramContext;
    this.b = paramk;
  }
  
  public static Intent a(Context paramContext, k paramk)
  {
    if (paramk == null) {
      return null;
    }
    Intent localIntent1 = q.b(paramContext, paramk.d());
    Intent localIntent2;
    Object localObject;
    if (paramk.n() != null)
    {
      try
      {
        localIntent2 = Intent.parseUri(paramk.n(), 0);
        localIntent2.setSelector(null);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Intent.parseUri(msg.intentUri, 0), action:");
        ((StringBuilder)localObject).append(localIntent2.getAction());
        HMSLog.d("PushSelfShowLog", ((StringBuilder)localObject).toString());
        boolean bool = q.a(paramContext, paramk.d(), localIntent2).booleanValue();
        localObject = localIntent1;
        if (!bool) {
          return localObject;
        }
        return localIntent2;
      }
      catch (Exception paramContext)
      {
        paramk = new StringBuilder();
        paramk.append("intentUri error,");
        paramk.append(paramContext.toString());
        HMSLog.w("PushSelfShowLog", paramk.toString());
        return localIntent1;
      }
    }
    else
    {
      localObject = localIntent1;
      if (paramk.a() != null)
      {
        localIntent2 = new Intent(paramk.a());
        localObject = localIntent1;
        if (q.a(paramContext, paramk.d(), localIntent2).booleanValue()) {
          localObject = localIntent2;
        }
      }
      ((Intent)localObject).setPackage(paramk.d());
    }
    return localObject;
  }
  
  public final boolean a(Context paramContext)
  {
    return q.c(paramContext, this.b.d());
  }
  
  public final boolean b(Context paramContext)
  {
    if ("cosa".equals(this.b.i())) {
      return a(paramContext);
    }
    return true;
  }
  
  public final boolean b(Context paramContext, k paramk)
  {
    if (("cosa".equals(paramk.i())) && (a(paramContext, paramk) == null))
    {
      HMSLog.d("PushSelfShowLog", "launchCosaApp,intent == null");
      return true;
    }
    return false;
  }
  
  public void run()
  {
    HMSLog.i("PushSelfShowLog", "enter run()");
    try
    {
      if (b(this.a))
      {
        if (b(this.a, this.b)) {
          return;
        }
        o.a(this.a, this.b);
        return;
      }
    }
    catch (Exception localException)
    {
      HMSLog.e("PushSelfShowLog", localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.push.p
 * JD-Core Version:    0.7.0.1
 */