package com.tencent.mobileqq.armap.sensor.provider;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.armap.sensor.ARSensorManager.OnSensorChangeListener;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class TypeAccOrientationProvider
  extends OrientationProvider2
{
  private float[] a = new float[4];
  
  public TypeAccOrientationProvider(Context paramContext, int paramInt, SensorManager paramSensorManager, ARSensorManager.OnSensorChangeListener paramOnSensorChangeListener)
  {
    super(paramContext, paramInt, paramSensorManager, paramOnSensorChangeListener);
    if (paramInt == 5) {
      paramInt = 15;
    } else {
      paramInt = 11;
    }
    Sensor localSensor = paramSensorManager.getDefaultSensor(paramInt);
    paramContext = paramSensorManager.getDefaultSensor(1);
    paramSensorManager = paramSensorManager.getDefaultSensor(4);
    if ((paramSensorManager != null) && (localSensor != null) && (Build.VERSION.SDK_INT >= 9))
    {
      paramOnSensorChangeListener.onSensorSupport(4, true);
      this.d.add(localSensor);
      paramSensorManager = new StringBuilder();
      paramSensorManager.append("Gyroscope support,model:");
      paramSensorManager.append(Build.MODEL);
      paramSensorManager.append(", manufacture:");
      paramSensorManager.append(Build.MANUFACTURER);
      QLog.i("OrientationProvider2", 2, paramSensorManager.toString());
    }
    else
    {
      paramOnSensorChangeListener.onSensorSupport(4, false);
      if (paramSensorManager == null)
      {
        paramSensorManager = new StringBuilder();
        paramSensorManager.append("Gyroscope not support,model:");
        paramSensorManager.append(Build.MODEL);
        paramSensorManager.append(", manufacture:");
        paramSensorManager.append(Build.MANUFACTURER);
        QLog.i("OrientationProvider2", 2, paramSensorManager.toString());
      }
      else if (localSensor == null)
      {
        if (Build.VERSION.SDK_INT >= 9)
        {
          paramSensorManager = new StringBuilder();
          paramSensorManager.append("Gyroscope not support(rotationVectorSensor),model:");
          paramSensorManager.append(Build.MODEL);
          paramSensorManager.append(", manufacture:");
          paramSensorManager.append(Build.MANUFACTURER);
          QLog.i("OrientationProvider2", 2, paramSensorManager.toString());
        }
        else
        {
          paramSensorManager = new StringBuilder();
          paramSensorManager.append("Gyroscope not support(sdk < 9),model:");
          paramSensorManager.append(Build.MODEL);
          paramSensorManager.append(", manufacture:");
          paramSensorManager.append(Build.MANUFACTURER);
          QLog.i("OrientationProvider2", 2, paramSensorManager.toString());
        }
      }
    }
    if (paramContext != null)
    {
      paramOnSensorChangeListener.onSensorSupport(1, true);
      this.d.add(paramContext);
      return;
    }
    paramOnSensorChangeListener.onSensorSupport(1, false);
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    if (this.g == null) {
      return;
    }
    this.g.updateAccelerometer(paramFloat1, paramFloat2, paramFloat3, paramLong);
  }
  
  @TargetApi(9)
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if ((paramSensorEvent.sensor.getType() != 11) && (paramSensorEvent.sensor.getType() != 15))
    {
      if (paramSensorEvent.sensor.getType() == 1) {
        a(paramSensorEvent.values[0], paramSensorEvent.values[1], paramSensorEvent.values[2], paramSensorEvent.timestamp);
      }
    }
    else {
      try
      {
        SensorManager.getQuaternionFromVector(this.a, paramSensorEvent.values);
        this.g.onRotationUpdateQuaternion(this.a);
        return;
      }
      catch (Exception paramSensorEvent)
      {
        paramSensorEvent.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.sensor.provider.TypeAccOrientationProvider
 * JD-Core Version:    0.7.0.1
 */