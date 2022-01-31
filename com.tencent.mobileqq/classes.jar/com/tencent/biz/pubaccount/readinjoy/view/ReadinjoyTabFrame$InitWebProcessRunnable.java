package com.tencent.biz.pubaccount.readinjoy.view;

import android.os.Build.VERSION;
import azmz;
import bdcb;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import ors;

class ReadinjoyTabFrame$InitWebProcessRunnable
  implements Runnable
{
  private long jdField_a_of_type_Long;
  private WeakReference<ReadinjoyTabFrame> jdField_a_of_type_JavaLangRefWeakReference;
  
  public void a(ReadinjoyTabFrame paramReadinjoyTabFrame)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramReadinjoyTabFrame);
  }
  
  public void run()
  {
    if (WebProcessManager.c()) {}
    do
    {
      do
      {
        return;
      } while ((System.currentTimeMillis() - this.jdField_a_of_type_Long <= 1000L) || (this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null));
      ReadinjoyTabFrame localReadinjoyTabFrame = (ReadinjoyTabFrame)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      localWebProcessManager = (WebProcessManager)localReadinjoyTabFrame.a.getManager(13);
      if (localWebProcessManager != null)
      {
        i = ors.f();
        if (!ors.f()) {}
      }
      try
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("param_osVer", String.valueOf(Build.VERSION.SDK_INT));
        localHashMap.put("param_totalMem", String.valueOf(bdcb.d()));
        localHashMap.put("param_availableMem", String.valueOf(bdcb.e()));
        localHashMap.put("param_cpuNum", String.valueOf(bdcb.b()));
        localHashMap.put("param_cpuFreq", String.valueOf(bdcb.a()));
        localHashMap.put("param_preloadLevel", String.valueOf(i));
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.4tab", 2, "preloadToolProcessReport:" + localHashMap.toString());
        }
        azmz.a(localReadinjoyTabFrame.a()).a(localReadinjoyTabFrame.a.getCurrentAccountUin(), "actReadInJoyToolPreload", true, 0L, 0L, localHashMap, "");
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.d("Q.readinjoy.4tab", 2, "", localException);
          continue;
          if (i == 2) {
            localWebProcessManager.a(201);
          }
        }
      }
      if (i != 1) {
        break;
      }
      localWebProcessManager.a(200);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.4tab", 2, "enter folder preload web process");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.InitWebProcessRunnable
 * JD-Core Version:    0.7.0.1
 */