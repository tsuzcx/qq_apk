package com.tencent.featuretoggle.strategy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.featuretoggle.utils.DeviceUtils;
import com.tencent.featuretoggle.utils.LogUtils;

public class TimeChangeReceiver
  extends BroadcastReceiver
{
  public static TimeChangeReceiver a()
  {
    try
    {
      TimeChangeReceiver localTimeChangeReceiver = TimeChangeReceiver.TimeChangeHolder.a;
      return localTimeChangeReceiver;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 23
    //   4: iconst_0
    //   5: anewarray 25	java/lang/Object
    //   8: invokestatic 31	com/tencent/featuretoggle/utils/LogUtils:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   11: new 33	android/content/IntentFilter
    //   14: dup
    //   15: invokespecial 34	android/content/IntentFilter:<init>	()V
    //   18: astore_2
    //   19: aload_2
    //   20: ldc 36
    //   22: invokevirtual 40	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   25: aload_2
    //   26: ldc 42
    //   28: invokevirtual 40	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   31: aload_1
    //   32: invokestatic 44	com/tencent/featuretoggle/strategy/TimeChangeReceiver:a	()Lcom/tencent/featuretoggle/strategy/TimeChangeReceiver;
    //   35: aload_2
    //   36: invokevirtual 50	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   39: pop
    //   40: goto +19 -> 59
    //   43: astore_1
    //   44: goto +18 -> 62
    //   47: astore_1
    //   48: aload_1
    //   49: invokestatic 53	com/tencent/featuretoggle/utils/LogUtils:a	(Ljava/lang/Throwable;)Z
    //   52: ifne +7 -> 59
    //   55: aload_1
    //   56: invokevirtual 56	java/lang/Throwable:printStackTrace	()V
    //   59: aload_0
    //   60: monitorexit
    //   61: return
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	TimeChangeReceiver
    //   0	66	1	paramContext	Context
    //   18	18	2	localIntentFilter	android.content.IntentFilter
    // Exception table:
    //   from	to	target	type
    //   2	40	43	finally
    //   48	59	43	finally
    //   2	40	47	java/lang/Throwable
  }
  
  public void b(Context paramContext)
  {
    if (DeviceUtils.a(paramContext) == null) {
      return;
    }
    ReportController.a().a(2007);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramContext != null) && (paramIntent != null))
    {
      if (paramIntent.getAction() == null) {
        return;
      }
      paramIntent = paramIntent.getAction();
      int i = -1;
      int j = paramIntent.hashCode();
      if (j != 502473491)
      {
        if ((j == 505380757) && (paramIntent.equals("android.intent.action.TIME_SET"))) {
          i = 0;
        }
      }
      else if (paramIntent.equals("android.intent.action.TIMEZONE_CHANGED")) {
        i = 1;
      }
      if (i != 0)
      {
        if (i != 1) {
          return;
        }
        b(paramContext);
        LogUtils.e("system time zone changed", new Object[0]);
        return;
      }
      b(paramContext);
      LogUtils.e("system time changed", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.strategy.TimeChangeReceiver
 * JD-Core Version:    0.7.0.1
 */