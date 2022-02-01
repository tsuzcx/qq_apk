package com.tencent.mobileqq.armap.sensor.provider;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import com.tencent.mobileqq.armap.sensor.ARSensorManager.OnSensorChangeListener;
import com.tencent.mobileqq.armap.sensor.SensorUtil;
import java.util.List;

public class AccelMagnetGyroProvider
  extends OrientationProvider2
{
  private float A = -1.0F;
  boolean a = false;
  boolean b = false;
  boolean c = false;
  private final float[] n = new float[4];
  private float o;
  private float[] p = new float[3];
  private float[] q = new float[3];
  private float[] r = new float[3];
  private float[] s = new float[3];
  private float[] t = new float[3];
  private float[] u = new float[9];
  private float[] v = new float[3];
  private float[] w = new float[9];
  private float[] x = new float[16];
  private float y = -1.0F;
  private float z = -1.0F;
  
  public AccelMagnetGyroProvider(Context paramContext, int paramInt, SensorManager paramSensorManager, ARSensorManager.OnSensorChangeListener paramOnSensorChangeListener)
  {
    super(paramContext, paramInt, paramSensorManager, paramOnSensorChangeListener);
    paramContext = paramSensorManager.getDefaultSensor(4);
    paramOnSensorChangeListener = paramSensorManager.getDefaultSensor(1);
    paramSensorManager = paramSensorManager.getDefaultSensor(2);
    if ((paramContext != null) && (paramOnSensorChangeListener != null) && (paramSensorManager != null))
    {
      this.d.add(paramContext);
      this.d.add(paramOnSensorChangeListener);
      this.d.add(paramSensorManager);
      a();
      return;
    }
    throw new OrientationProviderNotFound("4,1,2");
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (this.g == null) {
      return;
    }
    if (Math.abs(paramFloat1 - this.y) > 1.0F)
    {
      this.y = paramFloat1;
      this.g.updateAzimuth(paramFloat1);
    }
    if (Math.abs(paramFloat2 - this.z) > 1.0F)
    {
      this.z = paramFloat2;
      this.g.updatePitch(paramFloat2);
    }
    if (Math.abs(paramFloat3 - this.A) > 1.0F)
    {
      this.A = paramFloat3;
      this.g.updateRoll(paramFloat3);
    }
    this.g.updateSensor(paramFloat1, paramFloat2, paramFloat3);
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    if (this.g == null) {
      return;
    }
    this.g.updateAccelerometer(paramFloat1, paramFloat2, paramFloat3, paramLong);
  }
  
  private void a(SensorEvent paramSensorEvent)
  {
    if (!this.a) {
      return;
    }
    float[] arrayOfFloat1;
    if (!this.c)
    {
      arrayOfFloat1 = new float[9];
      arrayOfFloat1 = SensorUtil.a(this.v);
      SensorManager.getOrientation(arrayOfFloat1, new float[3]);
      this.w = SensorUtil.b(this.w, arrayOfFloat1);
      this.c = true;
    }
    if ((this.o != 0.0F) && (this.c))
    {
      float f7 = (float)paramSensorEvent.timestamp;
      float f8 = this.o;
      System.arraycopy(paramSensorEvent.values, 0, this.t, 0, 3);
      arrayOfFloat1 = this.t;
      float f6 = arrayOfFloat1[0];
      float f5 = arrayOfFloat1[1];
      float f4 = arrayOfFloat1[2];
      float f9 = (float)Math.sqrt(f6 * f6 + f5 * f5 + f4 * f4);
      float f3 = f4;
      float f2 = f6;
      float f1 = f5;
      if (f9 > 1.0E-009F)
      {
        f2 = f6 / f9;
        f1 = f5 / f9;
        f3 = f4 / f9;
      }
      double d = f9 * ((f7 - f8) * 1.0E-009F) / 2.0F;
      f4 = (float)Math.sin(d);
      f5 = (float)Math.cos(d);
      arrayOfFloat1 = this.n;
      arrayOfFloat1[0] = (f2 * f4);
      arrayOfFloat1[1] = (f1 * f4);
      arrayOfFloat1[2] = (f4 * f3);
      arrayOfFloat1[3] = f5;
      float[] arrayOfFloat2 = new float[9];
      SensorUtil.d(arrayOfFloat2, arrayOfFloat1);
      this.w = SensorUtil.b(this.w, arrayOfFloat2);
      SensorManager.getOrientation(this.w, this.p);
      f();
      if ((this.m == 1) && (this.g != null))
      {
        f1 = (float)(Math.toDegrees(this.p[0] + d()) + 360.0D);
        arrayOfFloat1 = this.p;
        d = arrayOfFloat1[1] * 180.0F;
        Double.isNaN(d);
        f2 = (float)(d / 3.141592653589793D);
        d = arrayOfFloat1[2] * 180.0F;
        Double.isNaN(d);
        a(f1 % 360.0F, f2, (float)(d / 3.141592653589793D));
      }
    }
    this.o = ((float)paramSensorEvent.timestamp);
  }
  
  private void b(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    if (this.g == null) {
      return;
    }
    this.g.updateGyroscope(paramFloat1, paramFloat2, paramFloat3, paramLong);
  }
  
  private void e()
  {
    if (SensorManager.getRotationMatrix(this.u, null, this.s, this.r))
    {
      SensorManager.getOrientation(this.u, this.v);
      this.a = true;
    }
  }
  
  private void f()
  {
    float[] arrayOfFloat1 = this.p;
    float[] arrayOfFloat2;
    float[] arrayOfFloat3;
    double d1;
    double d2;
    if (arrayOfFloat1[0] < -1.570796326794897D)
    {
      arrayOfFloat2 = this.v;
      if (arrayOfFloat2[0] > 0.0D)
      {
        arrayOfFloat3 = this.q;
        d1 = arrayOfFloat1[0];
        Double.isNaN(d1);
        d2 = arrayOfFloat2[0] * 0.001999974F;
        Double.isNaN(d2);
        arrayOfFloat3[0] = ((float)((d1 + 6.283185307179586D) * 0.9980000257492065D + d2));
        d2 = arrayOfFloat3[0];
        if (arrayOfFloat3[0] > 3.141592653589793D) {
          d1 = 6.283185307179586D;
        } else {
          d1 = 0.0D;
        }
        Double.isNaN(d2);
        arrayOfFloat3[0] = ((float)(d2 - d1));
        break label283;
      }
    }
    arrayOfFloat1 = this.v;
    double d3;
    if (arrayOfFloat1[0] < -1.570796326794897D)
    {
      arrayOfFloat2 = this.p;
      if (arrayOfFloat2[0] > 0.0D)
      {
        arrayOfFloat3 = this.q;
        d1 = arrayOfFloat2[0] * 0.998F;
        d2 = 0.001999974F;
        d3 = arrayOfFloat1[0];
        Double.isNaN(d3);
        Double.isNaN(d2);
        Double.isNaN(d1);
        arrayOfFloat3[0] = ((float)(d1 + d2 * (d3 + 6.283185307179586D)));
        d2 = arrayOfFloat3[0];
        if (arrayOfFloat3[0] > 3.141592653589793D) {
          d1 = 6.283185307179586D;
        } else {
          d1 = 0.0D;
        }
        Double.isNaN(d2);
        arrayOfFloat3[0] = ((float)(d2 - d1));
        break label283;
      }
    }
    this.q[0] = (this.p[0] * 0.998F + this.v[0] * 0.001999974F);
    label283:
    arrayOfFloat1 = this.p;
    if (arrayOfFloat1[1] < -1.570796326794897D)
    {
      arrayOfFloat2 = this.v;
      if (arrayOfFloat2[1] > 0.0D)
      {
        arrayOfFloat3 = this.q;
        d1 = arrayOfFloat1[1];
        Double.isNaN(d1);
        d2 = arrayOfFloat2[1] * 0.001999974F;
        Double.isNaN(d2);
        arrayOfFloat3[1] = ((float)((d1 + 6.283185307179586D) * 0.9980000257492065D + d2));
        d2 = arrayOfFloat3[1];
        if (arrayOfFloat3[1] > 3.141592653589793D) {
          d1 = 6.283185307179586D;
        } else {
          d1 = 0.0D;
        }
        Double.isNaN(d2);
        arrayOfFloat3[1] = ((float)(d2 - d1));
        break label566;
      }
    }
    arrayOfFloat1 = this.v;
    if (arrayOfFloat1[1] < -1.570796326794897D)
    {
      arrayOfFloat2 = this.p;
      if (arrayOfFloat2[1] > 0.0D)
      {
        arrayOfFloat3 = this.q;
        d1 = arrayOfFloat2[1] * 0.998F;
        d2 = 0.001999974F;
        d3 = arrayOfFloat1[1];
        Double.isNaN(d3);
        Double.isNaN(d2);
        Double.isNaN(d1);
        arrayOfFloat3[1] = ((float)(d1 + d2 * (d3 + 6.283185307179586D)));
        d2 = arrayOfFloat3[1];
        if (arrayOfFloat3[1] > 3.141592653589793D) {
          d1 = 6.283185307179586D;
        } else {
          d1 = 0.0D;
        }
        Double.isNaN(d2);
        arrayOfFloat3[1] = ((float)(d2 - d1));
        break label566;
      }
    }
    this.q[1] = (this.p[1] * 0.998F + this.v[1] * 0.001999974F);
    label566:
    arrayOfFloat1 = this.p;
    if (arrayOfFloat1[2] < -1.570796326794897D)
    {
      arrayOfFloat2 = this.v;
      if (arrayOfFloat2[2] > 0.0D)
      {
        arrayOfFloat3 = this.q;
        d1 = arrayOfFloat1[2];
        Double.isNaN(d1);
        d2 = 0.001999974F * arrayOfFloat2[2];
        Double.isNaN(d2);
        arrayOfFloat3[2] = ((float)((d1 + 6.283185307179586D) * 0.9980000257492065D + d2));
        d2 = arrayOfFloat3[2];
        if (arrayOfFloat3[2] > 3.141592653589793D) {
          d1 = 6.283185307179586D;
        } else {
          d1 = 0.0D;
        }
        Double.isNaN(d2);
        arrayOfFloat3[2] = ((float)(d2 - d1));
        break label849;
      }
    }
    arrayOfFloat1 = this.v;
    if (arrayOfFloat1[2] < -1.570796326794897D)
    {
      arrayOfFloat2 = this.p;
      if (arrayOfFloat2[2] > 0.0D)
      {
        arrayOfFloat3 = this.q;
        d1 = arrayOfFloat2[2] * 0.998F;
        d2 = 0.001999974F;
        d3 = arrayOfFloat1[2];
        Double.isNaN(d3);
        Double.isNaN(d2);
        Double.isNaN(d1);
        arrayOfFloat3[2] = ((float)(d1 + d2 * (d3 + 6.283185307179586D)));
        d2 = arrayOfFloat3[2];
        if (arrayOfFloat3[2] > 3.141592653589793D) {
          d1 = 6.283185307179586D;
        } else {
          d1 = 0.0D;
        }
        Double.isNaN(d2);
        arrayOfFloat3[2] = ((float)(d2 - d1));
        break label849;
      }
    }
    this.q[2] = (this.p[2] * 0.998F + 0.001999974F * this.v[2]);
    label849:
    this.w = SensorUtil.a(this.q);
    SensorUtil.a(this.w, this.x);
    if (this.m != 1) {
      super.a(this.x);
    }
    System.arraycopy(this.q, 0, this.p, 0, 3);
  }
  
  void a()
  {
    float[] arrayOfFloat = this.p;
    arrayOfFloat[0] = 0.0F;
    arrayOfFloat[1] = 0.0F;
    arrayOfFloat[2] = 0.0F;
    arrayOfFloat = this.w;
    arrayOfFloat[0] = 1.0F;
    arrayOfFloat[1] = 0.0F;
    arrayOfFloat[2] = 0.0F;
    arrayOfFloat[3] = 0.0F;
    arrayOfFloat[4] = 1.0F;
    arrayOfFloat[5] = 0.0F;
    arrayOfFloat[6] = 0.0F;
    arrayOfFloat[7] = 0.0F;
    arrayOfFloat[8] = 1.0F;
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() == 4)
    {
      a(paramSensorEvent);
      b(paramSensorEvent.values[0], paramSensorEvent.values[1], paramSensorEvent.values[2], paramSensorEvent.timestamp);
      return;
    }
    if (paramSensorEvent.sensor.getType() == 2)
    {
      System.arraycopy(paramSensorEvent.values, 0, this.r, 0, 3);
      this.b = true;
      return;
    }
    if (paramSensorEvent.sensor.getType() == 1)
    {
      System.arraycopy(paramSensorEvent.values, 0, this.s, 0, 3);
      e();
      a(paramSensorEvent.values[0], paramSensorEvent.values[1], paramSensorEvent.values[2], paramSensorEvent.timestamp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.sensor.provider.AccelMagnetGyroProvider
 * JD-Core Version:    0.7.0.1
 */