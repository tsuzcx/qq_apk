package com.tencent.biz.pubaccount.readinjoy.view;

import android.os.Build.VERSION;
import com.tencent.biz.pubaccount.readinjoy.common.RIJTabFrameBase;
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
import mqq.app.AppRuntime;

public class ReadinjoyTabFrame$InitWebProcessRunnable
  implements Runnable
{
  private long jdField_a_of_type_Long = 0L;
  private WeakReference<RIJTabFrameBase> jdField_a_of_type_JavaLangRefWeakReference;
  
  public void a(RIJTabFrameBase paramRIJTabFrameBase)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramRIJTabFrameBase);
  }
  
  public void run()
  {
    if (((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).isWebProcessExist()) {}
    do
    {
      do
      {
        return;
      } while ((System.currentTimeMillis() - this.jdField_a_of_type_Long <= 1000L) || (this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null));
      RIJTabFrameBase localRIJTabFrameBase = (RIJTabFrameBase)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      localIWebProcessManagerService = (IWebProcessManagerService)localRIJTabFrameBase.a.getRuntimeService(IWebProcessManagerService.class, "multi");
      if (localIWebProcessManagerService != null)
      {
        i = RIJWebSearchUtils.a();
        if (!RIJWebSearchUtils.a()) {}
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
          QLog.d("Q.readinjoy.4tab", 2, "preloadToolProcessReport:" + localHashMap.toString());
        }
        StatisticCollector.getInstance(localRIJTabFrameBase.a()).collectPerformance(((QQAppInterface)localRIJTabFrameBase.a).getCurrentAccountUin(), "actReadInJoyToolPreload", true, 0L, 0L, localHashMap, "");
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.d("Q.readinjoy.4tab", 2, "", localException);
          continue;
          if (i == 2) {
            localIWebProcessManagerService.startWebProcess(201, null);
          }
        }
      }
      if (i != 1) {
        break;
      }
      localIWebProcessManagerService.startWebProcess(200, null);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.4tab", 2, "enter folder preload web process");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.InitWebProcessRunnable
 * JD-Core Version:    0.7.0.1
 */