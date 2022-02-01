package com.tencent.av.utils;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

class SensorHelper$ProximitySensorEventListener
  implements SensorEventListener
{
  float jdField_a_of_type_Float = 3.1F;
  long jdField_a_of_type_Long = 0L;
  boolean jdField_a_of_type_Boolean = true;
  float jdField_b_of_type_Float = 0.0F;
  boolean jdField_b_of_type_Boolean = false;
  boolean c = false;
  boolean d = false;
  
  SensorHelper$ProximitySensorEventListener(SensorHelper paramSensorHelper) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() != 8) {
      return;
    }
    float f1 = this.jdField_b_of_type_Float;
    paramSensorEvent = paramSensorEvent.values;
    int k = 0;
    float f2 = paramSensorEvent[0];
    this.jdField_b_of_type_Float = f2;
    if (this.jdField_a_of_type_Float > this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b.getMaximumRange()) {
      this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b.getMaximumRange();
    }
    double d1 = f2;
    int m = 1;
    int i;
    if ((d1 >= 0.0D) && (f2 < this.jdField_a_of_type_Float)) {
      i = 1;
    } else {
      i = 0;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      if (i != 0)
      {
        paramSensorEvent = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper;
        paramSensorEvent.jdField_a_of_type_Int = 3;
        SensorHelper.a(paramSensorEvent, i ^ 0x1);
        this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_ComTencentAvUtilsSensorReport.d();
      }
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_ComTencentAvVideoController.a();
    if (localObject == null) {
      return;
    }
    long l = System.currentTimeMillis();
    boolean bool = SensorHelper.a(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper);
    SensorHelper.d(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper, i ^ 0x1);
    if (SensorHelper.f(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper) != SensorHelper.a(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper))
    {
      if (3 == this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_Int) {
        this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_ComTencentAvUtilsSensorReport.e();
      }
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_Int = 0;
    }
    if ((l - this.jdField_a_of_type_Long > 1000L) || (bool != SensorHelper.a(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper)) || (this.jdField_b_of_type_Boolean != ((SessionInfo)localObject).E) || (this.c != this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_Boolean) || (this.d != SensorHelper.b(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper)))
    {
      if (QLog.isDevelopLevel())
      {
        paramSensorEvent = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onSensorChanged distance[");
        localStringBuilder.append(f1);
        localStringBuilder.append("->");
        localStringBuilder.append(f2);
        localStringBuilder.append("], mlongDistense[");
        localStringBuilder.append(SensorHelper.a(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper));
        localStringBuilder.append("], lastlongDistense[");
        localStringBuilder.append(bool);
        localStringBuilder.append("], mIsMoving[");
        localStringBuilder.append(this.d);
        localStringBuilder.append("->");
        localStringBuilder.append(SensorHelper.b(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper));
        localStringBuilder.append("], mSensorSet[");
        localStringBuilder.append(this.c);
        localStringBuilder.append("->");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_Boolean);
        localStringBuilder.append("], isSpeakerOn[");
        localStringBuilder.append(this.jdField_b_of_type_Boolean);
        localStringBuilder.append("->");
        localStringBuilder.append(((SessionInfo)localObject).E);
        localStringBuilder.append("]");
        QLog.d(paramSensorEvent, 4, localStringBuilder.toString());
      }
      this.jdField_a_of_type_Long = l;
    }
    this.jdField_b_of_type_Boolean = ((SessionInfo)localObject).E;
    this.c = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_Boolean;
    this.d = SensorHelper.b(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper);
    int j;
    if ((i != 0) && (SensorHelper.b(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper)))
    {
      paramSensorEvent = ((SessionInfo)localObject).a;
      if ((((SessionInfo)localObject).E) && (paramSensorEvent != null))
      {
        i = 0;
        while (i < paramSensorEvent.length)
        {
          j = k;
          if (paramSensorEvent[i].equals("DEVICE_WIRED_HEADSET")) {
            break label678;
          }
          if (paramSensorEvent[i].equals("DEVICE_BLUETOOTH_HEADSET"))
          {
            j = k;
            break label678;
          }
          i += 1;
        }
        j = 1;
        label678:
        if (!SmallScreenUtils.f(BaseApplicationImpl.getApplication()))
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_JavaLangString, 2, "is App on background , Not execute sensor pressHandFreeBtn !!!");
          }
          return;
        }
        if ((j != 0) && (this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c))
        {
          if (QLog.isColorLevel())
          {
            paramSensorEvent = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_JavaLangString;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("1.setSensors pressHandFreeBtn, current mSensorSet = ");
            ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_Boolean);
            QLog.d(paramSensorEvent, 2, ((StringBuilder)localObject).toString());
          }
          if (this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null) {
            this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_ComTencentAvUtilsTraeHelper.d();
          }
          paramSensorEvent = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper;
          paramSensorEvent.jdField_a_of_type_Boolean = true;
          DataReport.j(paramSensorEvent.jdField_a_of_type_ComTencentAvVideoController);
        }
      }
    }
    else if ((this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_Boolean) && (i == 0))
    {
      paramSensorEvent = null;
      if (this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_ComTencentAvVideoController != null) {
        paramSensorEvent = ((SessionInfo)localObject).a;
      }
      if (paramSensorEvent != null)
      {
        i = 0;
        for (;;)
        {
          j = m;
          if (i >= paramSensorEvent.length) {
            break label904;
          }
          if ((paramSensorEvent[i].equals("DEVICE_WIRED_HEADSET")) || (paramSensorEvent[i].equals("DEVICE_BLUETOOTH_HEADSET"))) {
            break;
          }
          i += 1;
        }
        j = 0;
        label904:
        if ((j != 0) && (this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c))
        {
          if (QLog.isColorLevel())
          {
            paramSensorEvent = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_JavaLangString;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("2.setSensors pressHandFreeBtn, current mSensorSet = ");
            ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_Boolean);
            QLog.d(paramSensorEvent, 2, ((StringBuilder)localObject).toString());
          }
          if (this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null) {
            this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_ComTencentAvUtilsTraeHelper.d();
          }
          DataReport.j(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_ComTencentAvVideoController);
        }
      }
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.SensorHelper.ProximitySensorEventListener
 * JD-Core Version:    0.7.0.1
 */