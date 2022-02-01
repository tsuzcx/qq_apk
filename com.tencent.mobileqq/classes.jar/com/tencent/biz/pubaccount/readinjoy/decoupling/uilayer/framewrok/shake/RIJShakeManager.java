package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.shake;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager.Builder;
import com.tencent.biz.pubaccount.readinjoy.notecard.ReadInJoyNoteCardUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ShakeListener;
import com.tencent.qqperf.monitor.backgroundcpu.BackgroundCpuMonitor;
import mqq.app.AppRuntime;

public class RIJShakeManager
{
  private RIJDataManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager;
  private ShakeListener jdField_a_of_type_ComTencentMobileqqAppShakeListener = new RIJShakeManager.1(this);
  
  public RIJShakeManager(RIJDataManager paramRIJDataManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager = paramRIJDataManager;
  }
  
  public void a()
  {
    int i = 2;
    Object localObject = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    ShakeListener localShakeListener;
    Sensor localSensor;
    if ((ReadInJoyNoteCardUtil.a() == 2) && (ReadInJoyNoteCardUtil.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a(), (String)localObject) > 0))
    {
      localObject = (SensorManager)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a().getSystemService("sensor");
      localShakeListener = this.jdField_a_of_type_ComTencentMobileqqAppShakeListener;
      localSensor = ((SensorManager)localObject).getDefaultSensor(1);
      if (!BackgroundCpuMonitor.a().a()) {
        break label86;
      }
    }
    for (;;)
    {
      ((SensorManager)localObject).registerListener(localShakeListener, localSensor, i);
      return;
      label86:
      i = 0;
    }
  }
  
  public void b()
  {
    ((SensorManager)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a().getSystemService("sensor")).unregisterListener(this.jdField_a_of_type_ComTencentMobileqqAppShakeListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.shake.RIJShakeManager
 * JD-Core Version:    0.7.0.1
 */