package com.tencent.biz.game;

import android.content.Context;
import android.text.TextUtils;
import com.google.zxing.client.android.wifi.BizWifiConfigManager;
import com.tencent.biz.common.util.Util;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class SensorAPIJavaScript$11
  extends Thread
{
  SensorAPIJavaScript$11(SensorAPIJavaScript paramSensorAPIJavaScript, Context paramContext, String paramString) {}
  
  public void run()
  {
    int i = 15;
    localObject1 = "";
    for (;;)
    {
      Object localObject2 = localObject1;
      if (i > 0)
      {
        localObject2 = localObject1;
        if (this.this$0.c != null) {
          if (this.this$0.c.get() == null)
          {
            localObject2 = localObject1;
          }
          else
          {
            if (QLog.isDevelopLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("run check: ");
              ((StringBuilder)localObject1).append(i);
              QLog.d("SensorApi", 4, ((StringBuilder)localObject1).toString());
            }
            localObject1 = BizWifiConfigManager.a(this.a);
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              i = 0;
              break label120;
            }
          }
        }
      }
      try
      {
        Thread.sleep(2000L);
        i -= 1;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          int j;
          Object localObject3 = localObject1;
        }
      }
    }
    i = 2;
    localObject1 = localObject2;
    label120:
    this.this$0.t = false;
    if (QLog.isDevelopLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("run check end: ");
      ((StringBuilder)localObject2).append(i);
      QLog.d("SensorApi", 4, ((StringBuilder)localObject2).toString());
    }
    if (i == 0)
    {
      j = this.this$0.a();
      this.this$0.callJs(this.b, new String[] { Util.c(Integer.toString(i)), Util.c((String)localObject1), Util.c(Integer.toString(j)) });
      return;
    }
    this.this$0.callJs(this.b, new String[] { Util.c(Integer.toString(i)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.game.SensorAPIJavaScript.11
 * JD-Core Version:    0.7.0.1
 */