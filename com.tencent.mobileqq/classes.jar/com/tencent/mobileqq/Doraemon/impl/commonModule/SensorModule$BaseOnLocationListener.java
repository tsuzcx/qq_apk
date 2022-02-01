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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onConsecutiveFailure: errCode=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", failCount=");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("DoraemonOpenAPI.sensor.location", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt2 * 2000 >= this.b)
    {
      if (!this.jdField_a_of_type_Boolean) {
        return;
      }
      this.jdField_a_of_type_Boolean = false;
      localObject = this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("error ");
      localStringBuilder.append(paramInt1);
      DoraemonUtil.a((APICallback)localObject, paramInt1, localStringBuilder.toString());
      Long.toString(System.currentTimeMillis() - this.jdField_a_of_type_Long);
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).removeOnLocationListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.commonModule.SensorModule.BaseOnLocationListener
 * JD-Core Version:    0.7.0.1
 */