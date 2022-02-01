package com.tencent.mobileqq.Doraemon.monitor;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.mobileqq.Doraemon.DoraemonBridge;
import com.tencent.qphone.base.util.BaseApplication;

public class DoraemonAPIReporterProxy
  implements DoraemonAPIReporter
{
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  DoraemonAPIReporter.OnFrequenceDataUpdateListener jdField_a_of_type_ComTencentMobileqqDoraemonMonitorDoraemonAPIReporter$OnFrequenceDataUpdateListener;
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
      try
      {
        if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
        {
          IntentFilter localIntentFilter = new IntentFilter();
          localIntentFilter.addAction("com.tencent.mobileqq.Doraemon.monitor.update");
          localIntentFilter.addAction("com.tencent.mobileqq.Doraemon.monitor.update_batch");
          DoraemonAPIReporterProxy.1 local1 = new DoraemonAPIReporterProxy.1(this);
          BaseApplication.getContext().registerReceiver(local1, localIntentFilter, "com.tencent.msg.permission.pushnotify", null);
          this.jdField_a_of_type_AndroidContentBroadcastReceiver = local1;
        }
        return;
      }
      finally {}
    }
  }
  
  public void a(DoraemonAPIReporter.OnFrequenceDataUpdateListener paramOnFrequenceDataUpdateListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqDoraemonMonitorDoraemonAPIReporter$OnFrequenceDataUpdateListener = paramOnFrequenceDataUpdateListener;
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    a();
    Bundle localBundle = new Bundle();
    localBundle.putString("key", paramString1);
    localBundle.putInt("type", paramInt);
    localBundle.putString("appid", paramString2);
    DoraemonBridge.a(2, localBundle, null);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    a();
    Bundle localBundle = new Bundle();
    localBundle.putString("key", paramString1);
    localBundle.putInt("type", paramInt);
    localBundle.putString("appid", paramString2);
    localBundle.putString("api", paramString3);
    DoraemonBridge.a(3, localBundle, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.monitor.DoraemonAPIReporterProxy
 * JD-Core Version:    0.7.0.1
 */