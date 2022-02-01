package com.tencent.mobileqq.armap.sensor.provider;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import com.tencent.mobileqq.armap.sensor.ARSensorManager.OnSensorChangeListener;
import com.tencent.mobileqq.armap.sensor.SensorSmoother;
import java.util.List;

public class AccelMagnetProvider
  extends OrientationProvider2
{
  boolean a = false;
  private float[] b = new float[3];
  private float[] c = new float[3];
  private float[] n = new float[3];
  private float[] o = new float[3];
  private float[] p = new float[16];
  private float[] q = new float[3];
  private float r = -1.0F;
  private float s = -1.0F;
  private float t = -1.0F;
  
  public AccelMagnetProvider(Context paramContext, int paramInt, SensorManager paramSensorManager, ARSensorManager.OnSensorChangeListener paramOnSensorChangeListener)
  {
    super(paramContext, paramInt, paramSensorManager, paramOnSensorChangeListener);
    paramContext = paramSensorManager.getDefaultSensor(1);
    paramSensorManager = paramSensorManager.getDefaultSensor(2);
    if ((paramContext != null) && (paramSensorManager != null))
    {
      this.d.add(paramContext);
      this.d.add(paramSensorManager);
      return;
    }
    throw new OrientationProviderNotFound("1,2");
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (this.g == null) {
      return;
    }
    if (Math.abs(paramFloat1 - this.r) > 2.0F)
    {
      this.r = paramFloat1;
      this.g.updateAzimuth(paramFloat1);
    }
    if (Math.abs(paramFloat2 - this.s) > 2.0F)
    {
      this.s = paramFloat2;
      this.g.updatePitch(paramFloat2);
    }
    if (Math.abs(paramFloat3 - this.t) > 2.0F)
    {
      this.t = paramFloat3;
      this.g.updateRoll(paramFloat3);
    }
    this.g.updateSensor(paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() == 2)
    {
      System.arraycopy(paramSensorEvent.values, 0, this.b, 0, 3);
      SensorSmoother.a(this.b, this.o);
      System.arraycopy(this.b, 0, this.o, 0, 3);
      this.a = true;
    }
    else if (paramSensorEvent.sensor.getType() == 1)
    {
      System.arraycopy(paramSensorEvent.values, 0, this.c, 0, 3);
      SensorSmoother.a(this.c, this.n);
      System.arraycopy(this.c, 0, this.n, 0, 3);
    }
    if ((this.a) && (SensorManager.getRotationMatrix(this.p, null, this.c, this.b)))
    {
      SensorManager.getOrientation(this.p, this.q);
      if (this.m != 1)
      {
        super.a(this.p);
        return;
      }
      float f1 = (float)(Math.toDegrees(this.q[0] + d()) + 360.0D);
      paramSensorEvent = this.q;
      double d = paramSensorEvent[1] * 180.0F;
      Double.isNaN(d);
      float f2 = (float)(d / 3.141592653589793D);
      d = paramSensorEvent[2] * 180.0F;
      Double.isNaN(d);
      a(f1 % 360.0F, f2, (float)(d / 3.141592653589793D));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.sensor.provider.AccelMagnetProvider
 * JD-Core Version:    0.7.0.1
 */