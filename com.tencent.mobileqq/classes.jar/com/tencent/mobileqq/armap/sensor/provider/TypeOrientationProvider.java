package com.tencent.mobileqq.armap.sensor.provider;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import com.tencent.mobileqq.armap.sensor.ARSensorManager.OnSensorChangeListener;
import com.tencent.mobileqq.armap.sensor.SensorUtil;
import java.util.List;

public class TypeOrientationProvider
  extends OrientationProvider2
{
  float[] a = new float[3];
  private float[] b = new float[16];
  private float c = -1.0F;
  private float n = -1.0F;
  private float o = -1.0F;
  
  public TypeOrientationProvider(Context paramContext, int paramInt, SensorManager paramSensorManager, ARSensorManager.OnSensorChangeListener paramOnSensorChangeListener)
  {
    super(paramContext, paramInt, paramSensorManager, paramOnSensorChangeListener);
    if (paramSensorManager.getDefaultSensor(3) != null)
    {
      this.d.add(paramSensorManager.getDefaultSensor(3));
      return;
    }
    throw new OrientationProviderNotFound(String.valueOf(3));
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (this.g == null) {
      return;
    }
    if (Math.abs(paramFloat1 - this.c) > 1.0F)
    {
      this.c = paramFloat1;
      this.g.updateAzimuth(paramFloat1);
    }
    if (Math.abs(paramFloat2 - this.n) > 1.0F)
    {
      this.n = paramFloat2;
      this.g.updatePitch(paramFloat2);
    }
    if (Math.abs(paramFloat3 - this.o) > 1.0F)
    {
      this.o = paramFloat3;
      this.g.updateRoll(paramFloat3);
    }
    this.g.updateSensor(paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() == 3)
    {
      System.arraycopy(paramSensorEvent.values, 0, this.e, 0, 3);
      if (this.m != 1)
      {
        this.a[0] = ((float)Math.toRadians(this.e[0]));
        this.a[1] = ((float)Math.toRadians(this.e[1]));
        this.a[2] = ((float)Math.toRadians(this.e[2]));
        SensorUtil.a(SensorUtil.a(this.a), this.b);
        super.a(this.b);
        return;
      }
      a(this.e[0], this.e[1], this.e[2]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.sensor.provider.TypeOrientationProvider
 * JD-Core Version:    0.7.0.1
 */