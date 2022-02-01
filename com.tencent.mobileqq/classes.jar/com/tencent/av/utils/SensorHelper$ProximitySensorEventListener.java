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
    if (paramSensorEvent.sensor.getType() != 8) {}
    label81:
    boolean bool1;
    label119:
    Object localObject;
    label199:
    do
    {
      float f1;
      float f2;
      do
      {
        do
        {
          return;
          f1 = this.jdField_b_of_type_Float;
          f2 = paramSensorEvent.values[0];
          this.jdField_b_of_type_Float = f2;
          if (this.jdField_a_of_type_Float > this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b.getMaximumRange()) {
            this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b.getMaximumRange();
          }
          if ((f2 < 0.0D) || (f2 >= this.jdField_a_of_type_Float)) {
            break;
          }
          i = 1;
          if (this.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_Boolean = false;
            if (i != 0)
            {
              this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_Int = 3;
              paramSensorEvent = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper;
              if (i != 0) {
                break label615;
              }
              bool1 = true;
              SensorHelper.a(paramSensorEvent, bool1);
              this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_ComTencentAvUtilsSensorReport.d();
            }
          }
        } while ((this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b == null) || (this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_ComTencentAvVideoController == null));
        paramSensorEvent = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_ComTencentAvVideoController.a();
      } while (paramSensorEvent == null);
      long l = System.currentTimeMillis();
      boolean bool2 = SensorHelper.a(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper);
      localObject = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper;
      if (i != 0) {
        break label621;
      }
      bool1 = true;
      SensorHelper.d((SensorHelper)localObject, bool1);
      if (SensorHelper.f(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper) != SensorHelper.a(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper))
      {
        if (3 == this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_Int) {
          this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_ComTencentAvUtilsSensorReport.e();
        }
        this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_Int = 0;
      }
      if ((l - this.jdField_a_of_type_Long > 1000L) || (bool2 != SensorHelper.a(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper)) || (this.jdField_b_of_type_Boolean != paramSensorEvent.P) || (this.c != this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_Boolean) || (this.d != SensorHelper.b(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper)))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_JavaLangString, 4, "onSensorChanged distance[" + f1 + "->" + f2 + "], mlongDistense[" + SensorHelper.a(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper) + "], lastlongDistense[" + bool2 + "], mIsMoving[" + this.d + "->" + SensorHelper.b(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper) + "], mSensorSet[" + this.c + "->" + this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_Boolean + "], isSpeakerOn[" + this.jdField_b_of_type_Boolean + "->" + paramSensorEvent.P + "]");
        }
        this.jdField_a_of_type_Long = l;
      }
      this.jdField_b_of_type_Boolean = paramSensorEvent.P;
      this.c = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_Boolean;
      this.d = SensorHelper.b(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper);
      if ((i == 0) || (!SensorHelper.b(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper))) {
        break label732;
      }
      localObject = paramSensorEvent.a;
    } while ((!paramSensorEvent.P) || (localObject == null));
    int i = 0;
    label543:
    if (i < localObject.length) {
      if ((!localObject[i].equals("DEVICE_WIREDHEADSET")) && (!localObject[i].equals("DEVICE_BLUETOOTHHEADSET"))) {}
    }
    for (i = 0;; i = 1)
    {
      if (!SmallScreenUtils.f(BaseApplicationImpl.getApplication()))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_JavaLangString, 2, "is App on background , Not execute sensor pressHandFreeBtn !!!");
        return;
        i = 0;
        break label81;
        label615:
        bool1 = false;
        break label119;
        label621:
        bool1 = false;
        break label199;
        i += 1;
        break label543;
      }
      if ((i == 0) || (!this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_JavaLangString, 2, "1.setSensors pressHandFreeBtn, current mSensorSet = " + this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_Boolean);
      }
      if (this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null) {
        this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_ComTencentAvUtilsTraeHelper.d();
      }
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_Boolean = true;
      DataReport.j(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_ComTencentAvVideoController);
      return;
      label732:
      if ((!this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_Boolean) || (i != 0)) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_ComTencentAvVideoController != null) {}
      for (paramSensorEvent = paramSensorEvent.a;; paramSensorEvent = null)
      {
        if (paramSensorEvent != null)
        {
          i = 0;
          if (i >= paramSensorEvent.length) {
            break label908;
          }
          if ((!paramSensorEvent[i].equals("DEVICE_WIREDHEADSET")) && (!paramSensorEvent[i].equals("DEVICE_BLUETOOTHHEADSET"))) {
            break label899;
          }
        }
        label899:
        label908:
        for (i = 0;; i = 1)
        {
          if ((i != 0) && (this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c))
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_JavaLangString, 2, "2.setSensors pressHandFreeBtn, current mSensorSet = " + this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_Boolean);
            }
            if (this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null) {
              this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_ComTencentAvUtilsTraeHelper.d();
            }
            DataReport.j(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_ComTencentAvVideoController);
          }
          this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_Boolean = false;
          return;
          i += 1;
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.utils.SensorHelper.ProximitySensorEventListener
 * JD-Core Version:    0.7.0.1
 */