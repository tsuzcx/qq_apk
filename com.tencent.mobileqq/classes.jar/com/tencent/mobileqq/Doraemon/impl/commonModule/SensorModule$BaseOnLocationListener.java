package com.tencent.mobileqq.Doraemon.impl.commonModule;

import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.qphone.base.util.QLog;

abstract class SensorModule$BaseOnLocationListener
  extends SosoInterfaceOnLocationListener
{
  long jdField_a_of_type_Long;
  APICallback jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback;
  boolean jdField_a_of_type_Boolean;
  long b;
  
  public SensorModule$BaseOnLocationListener(APICallback paramAPICallback, int paramInt, long paramLong)
  {
    super(paramInt, true, true, paramLong, true, false, "Doraemon");
    this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback = paramAPICallback;
    this.b = 10000L;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onConsecutiveFailure(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoraemonOpenAPI.sensor.location", 2, "onConsecutiveFailure: errCode=" + paramInt1 + ", failCount=" + paramInt2);
    }
    if ((paramInt2 * 2000 < this.b) || (!this.jdField_a_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, paramInt1, "error " + paramInt1);
    Long.toString(System.currentTimeMillis() - this.jdField_a_of_type_Long);
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).removeOnLocationListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.commonModule.SensorModule.BaseOnLocationListener
 * JD-Core Version:    0.7.0.1
 */