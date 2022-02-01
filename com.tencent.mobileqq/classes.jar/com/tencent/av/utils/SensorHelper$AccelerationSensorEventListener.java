package com.tencent.av.utils;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.qphone.base.util.QLog;

class SensorHelper$AccelerationSensorEventListener
  implements SensorEventListener
{
  long jdField_a_of_type_Long = 0L;
  long b = 0L;
  
  SensorHelper$AccelerationSensorEventListener(SensorHelper paramSensorHelper) {}
  
  String a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" x[");
    localStringBuilder.append(paramFloat1);
    localStringBuilder.append("], y[");
    localStringBuilder.append(paramFloat2);
    localStringBuilder.append("], z[");
    localStringBuilder.append(paramFloat3);
    localStringBuilder.append("], acc[");
    localStringBuilder.append(paramFloat4);
    localStringBuilder.append("], mIsMoving[");
    localStringBuilder.append(SensorHelper.b(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper));
    localStringBuilder.append("], mEnbaleProximiy[");
    localStringBuilder.append(SensorHelper.c(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper));
    localStringBuilder.append("], mIsAppOnForeground[");
    localStringBuilder.append(SensorHelper.d(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper));
    localStringBuilder.append("], mIsStarted[");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.d);
    localStringBuilder.append("], mPowerkeyStatu[");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_Int);
    localStringBuilder.append("], mlongDistense[");
    localStringBuilder.append(SensorHelper.a(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper));
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() != 1) {
      return;
    }
    long l = System.currentTimeMillis();
    boolean bool4 = SensorHelper.b(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper);
    float f1 = paramSensorEvent.values[0];
    float f2 = paramSensorEvent.values[1];
    float f3 = paramSensorEvent.values[2];
    float f4 = f1 * f1 + f2 * f2 + f3 * f3;
    if ((f4 >= 77.0F) && (f4 <= 106.0F))
    {
      if (l - this.b > 300L) {
        SensorHelper.b(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper, false);
      }
    }
    else
    {
      this.b = l;
      SensorHelper.b(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper, true);
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      paramSensorEvent = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_ComTencentAvVideoController.a();
      if (paramSensorEvent != null)
      {
        if (paramSensorEvent.d == 3) {}
        while (paramSensorEvent.H)
        {
          bool2 = true;
          break;
        }
      }
    }
    boolean bool2 = false;
    if ((bool2) && (SensorHelper.c(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper)) && (SensorHelper.d(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper)) && (!SensorHelper.a(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper)) && (this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_Int != 3))
    {
      if (SensorHelper.b(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper))
      {
        bool1 = true;
        break label271;
      }
    }
    else if (this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_Int != 2)
    {
      bool1 = false;
      bool3 = true;
      break label274;
    }
    boolean bool1 = false;
    label271:
    boolean bool3 = false;
    label274:
    StringBuilder localStringBuilder;
    if ((QLog.isDevelopLevel()) && ((bool4 != SensorHelper.b(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper)) || (l - this.jdField_a_of_type_Long > 1000L)))
    {
      paramSensorEvent = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSensorChanged, bAudio[");
      localStringBuilder.append(SensorHelper.e(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper));
      localStringBuilder.append("->");
      localStringBuilder.append(bool2);
      localStringBuilder.append("], IsMoving[");
      localStringBuilder.append(bool4);
      localStringBuilder.append("->");
      localStringBuilder.append(SensorHelper.b(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper));
      localStringBuilder.append("], bOnScreen[");
      localStringBuilder.append(bool3);
      localStringBuilder.append("], bOffScreen[");
      localStringBuilder.append(bool1);
      localStringBuilder.append("],");
      localStringBuilder.append(a(f1, f2, f3, f4));
      QLog.d(paramSensorEvent, 4, localStringBuilder.toString());
      this.jdField_a_of_type_Long = l;
    }
    SensorHelper.c(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper, bool2);
    if (bool3)
    {
      if (this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.d)
      {
        paramSensorEvent = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("toggleProximityWakeLock[false], when[AccelerationSensorEventListener],");
        localStringBuilder.append(a(f1, f2, f3, f4));
        QLog.d(paramSensorEvent, 1, localStringBuilder.toString());
        this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.a(false, false);
      }
    }
    else if ((bool1) && (!this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.d))
    {
      paramSensorEvent = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("toggleProximityWakeLock[true], when[AccelerationSensorEventListener]");
      localStringBuilder.append(a(f1, f2, f3, f4));
      QLog.d(paramSensorEvent, 1, localStringBuilder.toString());
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.a(true, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.SensorHelper.AccelerationSensorEventListener
 * JD-Core Version:    0.7.0.1
 */