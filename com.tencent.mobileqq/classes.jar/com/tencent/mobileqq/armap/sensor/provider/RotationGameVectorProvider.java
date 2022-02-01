package com.tencent.mobileqq.armap.sensor.provider;

import android.content.Context;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import com.tencent.mobileqq.armap.sensor.ARSensorManager.OnSensorChangeListener;
import com.tencent.mobileqq.armap.sensor.SensorUtil;
import java.util.List;

public class RotationGameVectorProvider
  extends OrientationProvider2
{
  private float[] d = new float[16];
  
  public RotationGameVectorProvider(Context paramContext, int paramInt, SensorManager paramSensorManager, ARSensorManager.OnSensorChangeListener paramOnSensorChangeListener)
  {
    super(paramContext, paramInt, paramSensorManager, paramOnSensorChangeListener);
    paramContext = paramSensorManager.getDefaultSensor(15);
    if ((Build.VERSION.SDK_INT >= 18) && (paramContext != null))
    {
      this.a.add(paramContext);
      return;
    }
    throw new OrientationProviderNotFound(String.valueOf(15));
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    SensorUtil.a(this.d, paramSensorEvent);
    super.a(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.armap.sensor.provider.RotationGameVectorProvider
 * JD-Core Version:    0.7.0.1
 */