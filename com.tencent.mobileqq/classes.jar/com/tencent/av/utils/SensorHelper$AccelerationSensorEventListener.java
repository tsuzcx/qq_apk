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
  long a = 0L;
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
    localStringBuilder.append(SensorHelper.b(this.c));
    localStringBuilder.append("], mEnbaleProximiy[");
    localStringBuilder.append(SensorHelper.c(this.c));
    localStringBuilder.append("], mIsAppOnForeground[");
    localStringBuilder.append(SensorHelper.d(this.c));
    localStringBuilder.append("], mIsStarted[");
    localStringBuilder.append(this.c.r);
    localStringBuilder.append("], mPowerkeyStatu[");
    localStringBuilder.append(this.c.k);
    localStringBuilder.append("], mlongDistense[");
    localStringBuilder.append(SensorHelper.a(this.c));
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
    boolean bool4 = SensorHelper.b(this.c);
    float f1 = paramSensorEvent.values[0];
    float f2 = paramSensorEvent.values[1];
    float f3 = paramSensorEvent.values[2];
    float f4 = f1 * f1 + f2 * f2 + f3 * f3;
    if ((f4 >= 77.0F) && (f4 <= 106.0F))
    {
      if (l - this.b > 300L) {
        SensorHelper.b(this.c, false);
      }
    }
    else
    {
      this.b = l;
      SensorHelper.b(this.c, true);
    }
    if (this.c.l != null)
    {
      paramSensorEvent = this.c.l.k();
      if (paramSensorEvent != null)
      {
        if (paramSensorEvent.g == 3) {}
        while (paramSensorEvent.aK)
        {
          bool2 = true;
          break;
        }
      }
    }
    boolean bool2 = false;
    if ((bool2) && (SensorHelper.c(this.c)) && (SensorHelper.d(this.c)) && (!SensorHelper.a(this.c)) && (this.c.k != 1) && (this.c.k != 3))
    {
      if (SensorHelper.b(this.c))
      {
        bool1 = true;
        break label271;
      }
    }
    else if (this.c.k != 2)
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
    if ((QLog.isDevelopLevel()) && ((bool4 != SensorHelper.b(this.c)) || (l - this.a > 1000L)))
    {
      paramSensorEvent = this.c.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSensorChanged, bAudio[");
      localStringBuilder.append(SensorHelper.e(this.c));
      localStringBuilder.append("->");
      localStringBuilder.append(bool2);
      localStringBuilder.append("], IsMoving[");
      localStringBuilder.append(bool4);
      localStringBuilder.append("->");
      localStringBuilder.append(SensorHelper.b(this.c));
      localStringBuilder.append("], bOnScreen[");
      localStringBuilder.append(bool3);
      localStringBuilder.append("], bOffScreen[");
      localStringBuilder.append(bool1);
      localStringBuilder.append("],");
      localStringBuilder.append(a(f1, f2, f3, f4));
      QLog.d(paramSensorEvent, 4, localStringBuilder.toString());
      this.a = l;
    }
    SensorHelper.c(this.c, bool2);
    if (bool3)
    {
      if (this.c.r)
      {
        paramSensorEvent = this.c.a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("toggleProximityWakeLock[false], when[AccelerationSensorEventListener],");
        localStringBuilder.append(a(f1, f2, f3, f4));
        QLog.d(paramSensorEvent, 1, localStringBuilder.toString());
        this.c.a(false, false);
      }
    }
    else if ((bool1) && (!this.c.r))
    {
      paramSensorEvent = this.c.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("toggleProximityWakeLock[true], when[AccelerationSensorEventListener]");
      localStringBuilder.append(a(f1, f2, f3, f4));
      QLog.d(paramSensorEvent, 1, localStringBuilder.toString());
      this.c.a(true, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.SensorHelper.AccelerationSensorEventListener
 * JD-Core Version:    0.7.0.1
 */