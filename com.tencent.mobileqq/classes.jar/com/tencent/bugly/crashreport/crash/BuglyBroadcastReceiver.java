package com.tencent.bugly.crashreport.crash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;

public class BuglyBroadcastReceiver
  extends BroadcastReceiver
{
  private static BuglyBroadcastReceiver d;
  private IntentFilter a = new IntentFilter();
  private Context b;
  private String c;
  private boolean e = true;
  
  private boolean a(Context paramContext, Intent paramIntent)
  {
    if ((paramContext != null) && (paramIntent != null)) {
      try
      {
        if (paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
        {
          if (this.e)
          {
            this.e = false;
            return true;
          }
          paramIntent = com.tencent.bugly.crashreport.common.info.b.c(this.b);
          Object localObject1 = new StringBuilder("is Connect BC ");
          ((StringBuilder)localObject1).append(paramIntent);
          x.c(((StringBuilder)localObject1).toString(), new Object[0]);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(this.c);
          localObject1 = ((StringBuilder)localObject1).toString();
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramIntent);
          x.a("network %s changed to %s", new Object[] { localObject1, ((StringBuilder)localObject2).toString() });
          if (paramIntent == null)
          {
            this.c = null;
            return true;
          }
          localObject2 = this.c;
          this.c = paramIntent;
          long l = System.currentTimeMillis();
          com.tencent.bugly.crashreport.common.strategy.a locala = com.tencent.bugly.crashreport.common.strategy.a.a();
          localObject1 = u.a();
          paramContext = com.tencent.bugly.crashreport.common.info.a.a(paramContext);
          if ((locala != null) && (localObject1 != null) && (paramContext != null))
          {
            if (!paramIntent.equals(localObject2))
            {
              if (l - ((u)localObject1).a(c.a) > 30000L)
              {
                x.a("try to upload crash on network changed.", new Object[0]);
                paramContext = c.a();
                if (paramContext != null) {
                  paramContext.a(0L);
                }
              }
              if (l - ((u)localObject1).a(1001) > 30000L)
              {
                x.a("try to upload userinfo on network changed.", new Object[0]);
                com.tencent.bugly.crashreport.biz.b.b.b();
              }
            }
            return true;
          }
          x.d("not inited BC not work", new Object[0]);
          return true;
        }
      }
      finally {}
    }
    return false;
  }
  
  public static BuglyBroadcastReceiver getInstance()
  {
    try
    {
      if (d == null) {
        d = new BuglyBroadcastReceiver();
      }
      BuglyBroadcastReceiver localBuglyBroadcastReceiver = d;
      return localBuglyBroadcastReceiver;
    }
    finally {}
  }
  
  public void addFilter(String paramString)
  {
    try
    {
      if (!this.a.hasAction(paramString)) {
        this.a.addAction(paramString);
      }
      x.c("add action %s", new Object[] { paramString });
      return;
    }
    finally {}
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      a(paramContext, paramIntent);
      return;
    }
    catch (Throwable paramContext)
    {
      if (!x.a(paramContext)) {
        paramContext.printStackTrace();
      }
    }
  }
  
  public void register(Context paramContext)
  {
    try
    {
      this.b = paramContext;
      z.a(new BuglyBroadcastReceiver.1(this, this));
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  /* Error */
  public void unregister(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 177	java/lang/Object:getClass	()Ljava/lang/Class;
    //   6: ldc 179
    //   8: iconst_0
    //   9: anewarray 69	java/lang/Object
    //   12: invokestatic 182	com/tencent/bugly/proguard/x:a	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)Z
    //   15: pop
    //   16: aload_1
    //   17: aload_0
    //   18: invokevirtual 188	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   21: aload_0
    //   22: aload_1
    //   23: putfield 48	com/tencent/bugly/crashreport/crash/BuglyBroadcastReceiver:b	Landroid/content/Context;
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: astore_1
    //   30: goto +18 -> 48
    //   33: astore_1
    //   34: aload_1
    //   35: invokestatic 157	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   38: ifne +7 -> 45
    //   41: aload_1
    //   42: invokevirtual 160	java/lang/Throwable:printStackTrace	()V
    //   45: aload_0
    //   46: monitorexit
    //   47: return
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	BuglyBroadcastReceiver
    //   0	52	1	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   2	26	29	finally
    //   34	45	29	finally
    //   2	26	33	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */