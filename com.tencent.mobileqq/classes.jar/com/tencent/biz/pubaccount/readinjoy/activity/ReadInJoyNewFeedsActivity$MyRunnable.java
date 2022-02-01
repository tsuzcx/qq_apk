package com.tencent.biz.pubaccount.readinjoy.activity;

import android.os.Build.VERSION;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJWebSearchUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;

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
    if (((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).isWebProcessExist()) {}
    for (;;)
    {
      return;
      IWebProcessManagerService localIWebProcessManagerService;
      int i;
      if ((this.a != null) && (this.a.get() != null))
      {
        localIWebProcessManagerService = (IWebProcessManagerService)((ReadInJoyNewFeedsActivity)this.a.get()).app.getRuntimeService(IWebProcessManagerService.class, "");
        if (localIWebProcessManagerService != null)
        {
          i = RIJWebSearchUtils.a();
          if (!RIJWebSearchUtils.a()) {}
        }
      }
      try
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("param_osVer", String.valueOf(Build.VERSION.SDK_INT));
        localHashMap.put("param_totalMem", String.valueOf(DeviceInfoUtil.a()));
        localHashMap.put("param_availableMem", String.valueOf(DeviceInfoUtil.e()));
        localHashMap.put("param_cpuNum", String.valueOf(DeviceInfoUtil.b()));
        localHashMap.put("param_cpuFreq", String.valueOf(DeviceInfoUtil.b()));
        localHashMap.put("param_preloadLevel", String.valueOf(i));
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyNewFeedsActivity", 2, "preloadToolProcessReport:" + localHashMap.toString());
        }
        StatisticCollector.getInstance(this.this$0).collectPerformance(this.this$0.app.getCurrentAccountUin(), "actReadInJoyToolPreload", true, 0L, 0L, localHashMap, "");
      }
      catch (Exception localException)
      {
        label218:
        break label218;
      }
      if (i == 1) {
        localIWebProcessManagerService.startWebProcess(200, null);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("ReadInJoyNewFeedsActivity", 2, "enter folder preload web process");
        return;
        if (i == 2) {
          localIWebProcessManagerService.startWebProcess(201, null);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity.MyRunnable
 * JD-Core Version:    0.7.0.1
 */