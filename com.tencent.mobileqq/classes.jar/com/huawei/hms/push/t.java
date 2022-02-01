package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.support.log.HMSLog;

public class t
  extends Thread
{
  private Context a;
  private o b;
  
  public t(Context paramContext, o paramo)
  {
    this.a = paramContext;
    this.b = paramo;
  }
  
  private static Intent a(Context paramContext, o paramo)
  {
    if (paramo == null) {
      return null;
    }
    Intent localIntent1 = u.b(paramContext, paramo.m());
    if (paramo.g() != null) {}
    for (;;)
    {
      try
      {
        localObject = Intent.parseUri(paramo.g(), 0);
        HMSLog.d("PushSelfShowLog", "Intent.parseUri(msg.intentUri, 0)，" + ((Intent)localObject).getAction());
        boolean bool = u.a(paramContext, paramo.m(), (Intent)localObject).booleanValue();
        if (!bool) {
          break label172;
        }
        paramContext = (Context)localObject;
        return paramContext;
      }
      catch (Exception paramContext)
      {
        HMSLog.w("PushSelfShowLog", "intentUri error" + paramContext.toString());
        return localIntent1;
      }
      Object localObject = localIntent1;
      if (paramo.n() != null)
      {
        Intent localIntent2 = new Intent(paramo.n());
        localObject = localIntent1;
        if (u.a(paramContext, paramo.m(), localIntent2).booleanValue()) {
          localObject = localIntent2;
        }
      }
      ((Intent)localObject).setPackage(paramo.m());
      return localObject;
      label172:
      paramContext = localIntent1;
    }
  }
  
  private boolean a(Context paramContext)
  {
    if ("cosa".equals(this.b.j())) {
      return b(paramContext);
    }
    return true;
  }
  
  private boolean b(Context paramContext)
  {
    return u.c(paramContext, this.b.m());
  }
  
  private boolean b(Context paramContext, o paramo)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if ("cosa".equals(paramo.j()))
    {
      paramo = a(paramContext, paramo);
      bool1 = bool2;
      if (paramo == null)
      {
        HMSLog.d("PushSelfShowLog", "launchCosaApp,intent == null");
        bool1 = true;
      }
      if (!u.a(paramContext, paramo))
      {
        HMSLog.i("PushSelfShowLog", "no permission to start activity");
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void run()
  {
    HMSLog.i("PushSelfShowLog", "enter run()");
    try
    {
      if (a(this.a))
      {
        if (b(this.a, this.b)) {
          return;
        }
        s.a(this.a, this.b);
        return;
      }
    }
    catch (Exception localException)
    {
      HMSLog.e("PushSelfShowLog", localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.t
 * JD-Core Version:    0.7.0.1
 */