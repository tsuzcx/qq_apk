package com.tencent.mobileqq.armap.sensor.provider;

import android.content.Context;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import com.tencent.mobileqq.armap.sensor.ARSensorManager.OnSensorChangeListener;
import com.tencent.mobileqq.armap.sensor.SensorUtil;
import java.util.List;

public class RotationVectorProvider
  extends OrientationProvider2
{
  private float[] a = new float[16];
  
  public RotationVectorProvider(Context paramContext, int paramInt, SensorManager paramSensorManager, ARSensorManager.OnSensorChangeListener paramOnSensorChangeListener)
  {
    super(paramContext, paramInt, paramSensorManager, paramOnSensorChangeListener);
    paramContext = paramSensorManager.getDefaultSensor(11);
    if ((Build.VERSION.SDK_INT >= 9) && (paramContext != null))
    {
      this.d.add(paramContext);
      return;
    }
    throw new OrientationProviderNotFound(String.valueOf(3));
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    SensorUtil.a(this.a, paramSensorEvent);
    super.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.sensor.provider.RotationVectorProvider
 * JD-Core Version:    0.7.0.1
 */