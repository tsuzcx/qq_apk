package com.tencent.mobileqq.Doraemon.monitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.os.MqqHandler;

class DoraemonAPIReporterProxy$1
  extends BroadcastReceiver
{
  DoraemonAPIReporterProxy$1(DoraemonAPIReporterProxy paramDoraemonAPIReporterProxy) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = this.a.a;
    if (paramContext == null) {
      return;
    }
    String str1 = paramIntent.getAction();
    Object localObject;
    if ("com.tencent.mobileqq.Doraemon.monitor.update".equals(str1))
    {
      str1 = paramIntent.getStringExtra("key");
      int i = paramIntent.getIntExtra("type", 0);
      localObject = paramIntent.getStringExtra("appid");
      String str2 = paramIntent.getStringExtra("api");
      long l1 = paramIntent.getLongExtra("remain", 0L);
      long l2 = paramIntent.getLongExtra("time", 0L);
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("receive update key=");
        paramIntent.append(str1);
        paramIntent.append(", api=");
        paramIntent.append(str2);
        paramIntent.append(", remain=");
        paramIntent.append(l1);
        paramIntent.append(", exp=");
        paramIntent.append(l2);
        QLog.d("DoraemonOpenAPI.report", 2, paramIntent.toString());
      }
      ThreadManager.getUIHandler().post(new DoraemonAPIReporterProxy.1.1(this, paramContext, str1, i, (String)localObject, str2, l1, l2));
      return;
    }
    if ("com.tencent.mobileqq.Doraemon.monitor.update_batch".equals(str1))
    {
      str1 = paramIntent.getStringExtra("key");
      paramIntent.getIntExtra("type", 0);
      paramIntent.getStringExtra("appid");
    }
    try
    {
      paramIntent = (HashMap)paramIntent.getSerializableExtra("map");
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("receive update all key=");
        ((StringBuilder)localObject).append(str1);
        QLog.d("DoraemonOpenAPI.report", 2, ((StringBuilder)localObject).toString());
      }
      ThreadManager.getUIHandler().post(new DoraemonAPIReporterProxy.1.2(this, paramContext, str1, paramIntent));
      return;
    }
    catch (ClassCastException paramContext)
    {
      label292:
      break label292;
    }
    QLog.e("DoraemonOpenAPI.report", 1, "illegal data");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.monitor.DoraemonAPIReporterProxy.1
 * JD-Core Version:    0.7.0.1
 */