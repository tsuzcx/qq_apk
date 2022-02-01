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
  long a = 0L;
  float b = 3.1F;
  boolean c = true;
  float d = 0.0F;
  boolean e = false;
  boolean f = false;
  boolean g = false;
  
  SensorHelper$ProximitySensorEventListener(SensorHelper paramSensorHelper) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() != 8) {
      return;
    }
    float f1 = this.d;
    paramSensorEvent = paramSensorEvent.values;
    int k = 0;
    float f2 = paramSensorEvent[0];
    this.d = f2;
    if (this.b > this.h.e.getMaximumRange()) {
      this.b = this.h.e.getMaximumRange();
    }
    double d1 = f2;
    int m = 1;
    int i;
    if ((d1 >= 0.0D) && (f2 < this.b)) {
      i = 1;
    } else {
      i = 0;
    }
    if (this.c)
    {
      this.c = false;
      if (i != 0)
      {
        paramSensorEvent = this.h;
        paramSensorEvent.k = 3;
        SensorHelper.a(paramSensorEvent, i ^ 0x1);
        this.h.j.d();
      }
    }
    if (this.h.e == null) {
      return;
    }
    if (this.h.l == null) {
      return;
    }
    Object localObject = this.h.l.k();
    if (localObject == null) {
      return;
    }
    long l = System.currentTimeMillis();
    boolean bool = SensorHelper.a(this.h);
    SensorHelper.d(this.h, i ^ 0x1);
    if (SensorHelper.f(this.h) != SensorHelper.a(this.h))
    {
      if (3 == this.h.k) {
        this.h.j.e();
      }
      this.h.k = 0;
    }
    if ((l - this.a > 1000L) || (bool != SensorHelper.a(this.h)) || (this.e != ((SessionInfo)localObject).aG) || (this.f != this.h.b) || (this.g != SensorHelper.b(this.h)))
    {
      if (QLog.isDevelopLevel())
      {
        paramSensorEvent = this.h.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onSensorChanged distance[");
        localStringBuilder.append(f1);
        localStringBuilder.append("->");
        localStringBuilder.append(f2);
        localStringBuilder.append("], mlongDistense[");
        localStringBuilder.append(SensorHelper.a(this.h));
        localStringBuilder.append("], lastlongDistense[");
        localStringBuilder.append(bool);
        localStringBuilder.append("], mIsMoving[");
        localStringBuilder.append(this.g);
        localStringBuilder.append("->");
        localStringBuilder.append(SensorHelper.b(this.h));
        localStringBuilder.append("], mSensorSet[");
        localStringBuilder.append(this.f);
        localStringBuilder.append("->");
        localStringBuilder.append(this.h.b);
        localStringBuilder.append("], isSpeakerOn[");
        localStringBuilder.append(this.e);
        localStringBuilder.append("->");
        localStringBuilder.append(((SessionInfo)localObject).aG);
        localStringBuilder.append("]");
        QLog.d(paramSensorEvent, 4, localStringBuilder.toString());
      }
      this.a = l;
    }
    this.e = ((SessionInfo)localObject).aG;
    this.f = this.h.b;
    this.g = SensorHelper.b(this.h);
    int j;
    if ((i != 0) && (SensorHelper.b(this.h)))
    {
      paramSensorEvent = ((SessionInfo)localObject).aF;
      if ((((SessionInfo)localObject).aG) && (paramSensorEvent != null))
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
            QLog.d(this.h.a, 2, "is App on background , Not execute sensor pressHandFreeBtn !!!");
          }
          return;
        }
        if ((j != 0) && (this.h.o))
        {
          if (QLog.isColorLevel())
          {
            paramSensorEvent = this.h.a;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("1.setSensors pressHandFreeBtn, current mSensorSet = ");
            ((StringBuilder)localObject).append(this.h.b);
            QLog.d(paramSensorEvent, 2, ((StringBuilder)localObject).toString());
          }
          if (this.h.n != null) {
            this.h.n.g();
          }
          paramSensorEvent = this.h;
          paramSensorEvent.b = true;
          DataReport.j(paramSensorEvent.l);
        }
      }
    }
    else if ((this.h.b) && (i == 0))
    {
      paramSensorEvent = null;
      if (this.h.l != null) {
        paramSensorEvent = ((SessionInfo)localObject).aF;
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
        if ((j != 0) && (this.h.o))
        {
          if (QLog.isColorLevel())
          {
            paramSensorEvent = this.h.a;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("2.setSensors pressHandFreeBtn, current mSensorSet = ");
            ((StringBuilder)localObject).append(this.h.b);
            QLog.d(paramSensorEvent, 2, ((StringBuilder)localObject).toString());
          }
          if (this.h.n != null) {
            this.h.n.g();
          }
          DataReport.j(this.h.l);
        }
      }
      this.h.b = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.SensorHelper.ProximitySensorEventListener
 * JD-Core Version:    0.7.0.1
 */