package com.tencent.biz.pubaccount.readinjoy.common;

import android.os.Build.VERSION;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJWebSearchUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class ReadInJoyWebProcessManager$InitWebProcessRunnable
  implements Runnable
{
  private QQAppInterface a;
  
  public ReadInJoyWebProcessManager$InitWebProcessRunnable(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private void a(int paramInt)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_osVer", String.valueOf(Build.VERSION.SDK_INT));
      localHashMap.put("param_totalMem", String.valueOf(DeviceInfoUtil.a()));
      localHashMap.put("param_availableMem", String.valueOf(DeviceInfoUtil.e()));
      localHashMap.put("param_cpuNum", String.valueOf(DeviceInfoUtil.b()));
      localHashMap.put("param_cpuFreq", String.valueOf(DeviceInfoUtil.b()));
      localHashMap.put("param_preloadLevel", String.valueOf(paramInt));
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.ReadInJoyWebProcessManager", 2, "preloadToolProcessReport:" + localHashMap.toString());
      }
      StatisticCollector.getInstance(this.a.getApp()).collectPerformance(this.a.getCurrentAccountUin(), "actReadInJoyToolPreload", true, 0L, 0L, localHashMap, "");
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.readinjoy.ReadInJoyWebProcessManager", 2, "Exception: " + localException);
    }
  }
  
  public void run()
  {
    if ((((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).isWebProcessExist()) || (this.a == null)) {}
    for (;;)
    {
      return;
      IWebProcessManagerService localIWebProcessManagerService = (IWebProcessManagerService)this.a.getRuntimeService(IWebProcessManagerService.class, "");
      if (localIWebProcessManagerService != null)
      {
        int i = RIJWebSearchUtils.a();
        if (RIJWebSearchUtils.a()) {
          a(i);
        }
        if (i == 1) {
          localIWebProcessManagerService.startWebProcess(200, null);
        }
        while (QLog.isColorLevel())
        {
          QLog.d("Q.readinjoy.ReadInJoyWebProcessManager", 2, "enter folder preload web process");
          return;
          if (i == 2) {
            localIWebProcessManagerService.startWebProcess(201, null);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyWebProcessManager.InitWebProcessRunnable
 * JD-Core Version:    0.7.0.1
 */