package com.tencent.featuretoggle.strategy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.featuretoggle.ToggleSetting;
import com.tencent.featuretoggle.utils.AppUtils;
import com.tencent.featuretoggle.utils.DeviceUtils;
import com.tencent.featuretoggle.utils.LogUtils;

public class NetworkChangeReceiver
  extends BroadcastReceiver
{
  private String a = null;
  
  public static NetworkChangeReceiver a()
  {
    try
    {
      NetworkChangeReceiver localNetworkChangeReceiver = NetworkChangeReceiver.NetworkStateHolder.a;
      return localNetworkChangeReceiver;
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
    //   2: ldc 26
    //   4: iconst_0
    //   5: anewarray 28	java/lang/Object
    //   8: invokestatic 34	com/tencent/featuretoggle/utils/LogUtils:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   11: new 36	android/content/IntentFilter
    //   14: dup
    //   15: ldc 38
    //   17: invokespecial 41	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   20: astore_2
    //   21: aload_1
    //   22: invokestatic 43	com/tencent/featuretoggle/strategy/NetworkChangeReceiver:a	()Lcom/tencent/featuretoggle/strategy/NetworkChangeReceiver;
    //   25: aload_2
    //   26: invokevirtual 49	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   29: pop
    //   30: goto +19 -> 49
    //   33: astore_1
    //   34: goto +18 -> 52
    //   37: astore_1
    //   38: aload_1
    //   39: invokestatic 52	com/tencent/featuretoggle/utils/LogUtils:a	(Ljava/lang/Throwable;)Z
    //   42: ifne +7 -> 49
    //   45: aload_1
    //   46: invokevirtual 55	java/lang/Throwable:printStackTrace	()V
    //   49: aload_0
    //   50: monitorexit
    //   51: return
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	NetworkChangeReceiver
    //   0	56	1	paramContext	Context
    //   20	6	2	localIntentFilter	android.content.IntentFilter
    // Exception table:
    //   from	to	target	type
    //   2	30	33	finally
    //   38	49	33	finally
    //   2	30	37	java/lang/Throwable
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramContext != null) && (paramIntent != null) && (paramIntent.getAction() != null))
    {
      if (!paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
        return;
      }
      paramIntent = DeviceUtils.a(paramContext);
      LogUtils.e("[Strategy] network changed %s to %s", new Object[] { this.a, paramIntent });
      if (paramIntent != null)
      {
        if (paramIntent.equals(this.a)) {
          return;
        }
        if (ToggleSetting.D()) {
          ReportController.a().a(2004);
        }
        AppUtils.e(paramContext);
        this.a = paramIntent;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.strategy.NetworkChangeReceiver
 * JD-Core Version:    0.7.0.1
 */