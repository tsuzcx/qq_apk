package com.tencent.biz.pubaccount.readinjoy.activity;

import android.os.Build.VERSION;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import prm;

class ReadInJoyNewFeedsActivity$MyRunnable
  implements Runnable
{
  private WeakReference<ReadInJoyNewFeedsActivity> a;
  
  public ReadInJoyNewFeedsActivity$MyRunnable(ReadInJoyNewFeedsActivity paramReadInJoyNewFeedsActivity1, ReadInJoyNewFeedsActivity paramReadInJoyNewFeedsActivity2)
  {
    this.a = new WeakReference(paramReadInJoyNewFeedsActivity2);
  }
  
  public void run()
  {
    if (WebProcessManager.c()) {}
    for (;;)
    {
      return;
      WebProcessManager localWebProcessManager;
      int i;
      if ((this.a != null) && (this.a.get() != null))
      {
        localWebProcessManager = (WebProcessManager)((ReadInJoyNewFeedsActivity)this.a.get()).app.getManager(QQManagerFactory.WEBPROCESS_MANAGER);
        if (localWebProcessManager != null)
        {
          i = prm.a();
          if (!prm.a()) {}
        }
      }
      try
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("param_osVer", String.valueOf(Build.VERSION.SDK_INT));
        localHashMap.put("param_totalMem", String.valueOf(DeviceInfoUtil.getSystemTotalMemory()));
        localHashMap.put("param_availableMem", String.valueOf(DeviceInfoUtil.getSystemAvaialbeMemory()));
        localHashMap.put("param_cpuNum", String.valueOf(DeviceInfoUtil.getCpuNumber()));
        localHashMap.put("param_cpuFreq", String.valueOf(DeviceInfoUtil.getCpuFrequency()));
        localHashMap.put("param_preloadLevel", String.valueOf(i));
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyNewFeedsActivity", 2, "preloadToolProcessReport:" + localHashMap.toString());
        }
        StatisticCollector.getInstance(this.this$0).collectPerformance(this.this$0.app.getCurrentAccountUin(), "actReadInJoyToolPreload", true, 0L, 0L, localHashMap, "");
      }
      catch (Exception localException)
      {
        label207:
        break label207;
      }
      if (i == 1) {
        localWebProcessManager.a(200);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("ReadInJoyNewFeedsActivity", 2, "enter folder preload web process");
        return;
        if (i == 2) {
          localWebProcessManager.a(201);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity.MyRunnable
 * JD-Core Version:    0.7.0.1
 */