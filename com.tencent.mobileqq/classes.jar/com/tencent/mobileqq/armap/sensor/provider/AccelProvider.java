package com.tencent.mobileqq.armap.sensor.provider;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import com.tencent.mobileqq.armap.sensor.ARSensorManager.OnSensorChangeListener;
import com.tencent.mobileqq.armap.sensor.SensorSmoother;
import com.tencent.mobileqq.armap.sensor.SensorUtil;
import java.util.List;

public class AccelProvider
  extends OrientationProvider2
{
  boolean a = false;
  private float[] b = new float[3];
  private float[] c = new float[3];
  private float[] n = new float[16];
  private float o = -1.0F;
  private float p = -1.0F;
  private float q = -1.0F;
  
  public AccelProvider(Context paramContext, int paramInt, SensorManager paramSensorManager, ARSensorManager.OnSensorChangeListener paramOnSensorChangeListener)
  {
    super(paramContext, paramInt, paramSensorManager, paramOnSensorChangeListener);
    paramContext = paramSensorManager.getDefaultSensor(1);
    if (paramContext != null)
    {
      this.d.add(paramContext);
      return;
    }
    throw new OrientationProviderNotFound(String.valueOf(1));
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (this.g == null) {
      return;
    }
    if (Math.abs(paramFloat1 - this.o) > 1.0F)
    {
      this.o = paramFloat1;
      this.g.updateAzimuth(paramFloat1);
    }
    if (Math.abs(paramFloat2 - this.p) > 1.0F)
    {
      this.p = paramFloat2;
      this.g.updatePitch(paramFloat2);
    }
    if (Math.abs(paramFloat3 - this.q) > 1.0F)
    {
      this.q = paramFloat3;
      this.g.updateRoll(paramFloat3);
    }
    this.g.updateSensor(paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() == 1)
    {
      System.arraycopy(paramSensorEvent.values, 0, this.e, 0, 3);
      float f1 = this.e[0];
      float f2 = this.e[1];
      float f3 = this.e[2];
      this.b[1] = (-(float)Math.atan2(f2, f3));
      this.b[2] = ((float)Math.atan2(-f1, Math.sqrt(f2 * f2 + f3 * f3)));
      if (this.a) {
        this.b = SensorSmoother.a(this.b, this.c);
      }
      System.arraycopy(this.b, 0, this.c, 0, 3);
      this.a = true;
      SensorUtil.a(SensorUtil.a(this.b), this.n);
      if (this.m != 1)
      {
        super.a(this.n);
        return;
      }
      paramSensorEvent = this.b;
      double d = paramSensorEvent[1] * 180.0F;
      Double.isNaN(d);
      f1 = (float)(d / 3.141592653589793D);
      d = paramSensorEvent[2] * 180.0F;
      Double.isNaN(d);
      a(0.0F, f1, (float)(d / 3.141592653589793D));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.sensor.provider.AccelProvider
 * JD-Core Version:    0.7.0.1
 */