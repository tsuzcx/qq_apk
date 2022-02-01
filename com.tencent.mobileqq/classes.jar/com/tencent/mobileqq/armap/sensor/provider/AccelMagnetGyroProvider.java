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
  private float jdField_a_of_type_Float;
  boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float = -1.0F;
  boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float = -1.0F;
  boolean jdField_c_of_type_Boolean = false;
  private float jdField_d_of_type_Float = -1.0F;
  private final float[] jdField_d_of_type_ArrayOfFloat = new float[4];
  private float[] e = new float[3];
  private float[] f = new float[3];
  private float[] g = new float[3];
  private float[] h = new float[3];
  private float[] i = new float[3];
  private float[] j = new float[9];
  private float[] k = new float[3];
  private float[] l = new float[9];
  private float[] m = new float[16];
  
  public AccelMagnetGyroProvider(Context paramContext, int paramInt, SensorManager paramSensorManager, ARSensorManager.OnSensorChangeListener paramOnSensorChangeListener)
  {
    super(paramContext, paramInt, paramSensorManager, paramOnSensorChangeListener);
    paramContext = paramSensorManager.getDefaultSensor(4);
    paramOnSensorChangeListener = paramSensorManager.getDefaultSensor(1);
    paramSensorManager = paramSensorManager.getDefaultSensor(2);
    if ((paramContext != null) && (paramOnSensorChangeListener != null) && (paramSensorManager != null))
    {
      this.jdField_a_of_type_JavaUtilList.add(paramContext);
      this.jdField_a_of_type_JavaUtilList.add(paramOnSensorChangeListener);
      this.jdField_a_of_type_JavaUtilList.add(paramSensorManager);
      a();
      return;
    }
    throw new OrientationProviderNotFound("4,1,2");
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArmapSensorARSensorManager$OnSensorChangeListener == null) {
      return;
    }
    if (Math.abs(paramFloat1 - this.jdField_b_of_type_Float) > 1.0F)
    {
      this.jdField_b_of_type_Float = paramFloat1;
      this.jdField_a_of_type_ComTencentMobileqqArmapSensorARSensorManager$OnSensorChangeListener.updateAzimuth(paramFloat1);
    }
    if (Math.abs(paramFloat2 - this.jdField_c_of_type_Float) > 1.0F)
    {
      this.jdField_c_of_type_Float = paramFloat2;
      this.jdField_a_of_type_ComTencentMobileqqArmapSensorARSensorManager$OnSensorChangeListener.updatePitch(paramFloat2);
    }
    if (Math.abs(paramFloat3 - this.jdField_d_of_type_Float) > 1.0F)
    {
      this.jdField_d_of_type_Float = paramFloat3;
      this.jdField_a_of_type_ComTencentMobileqqArmapSensorARSensorManager$OnSensorChangeListener.updateRoll(paramFloat3);
    }
    this.jdField_a_of_type_ComTencentMobileqqArmapSensorARSensorManager$OnSensorChangeListener.updateSensor(paramFloat1, paramFloat2, paramFloat3);
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArmapSensorARSensorManager$OnSensorChangeListener == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArmapSensorARSensorManager$OnSensorChangeListener.updateAccelerometer(paramFloat1, paramFloat2, paramFloat3, paramLong);
  }
  
  private void a(SensorEvent paramSensorEvent)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    float[] arrayOfFloat1;
    if (!this.jdField_c_of_type_Boolean)
    {
      arrayOfFloat1 = new float[9];
      arrayOfFloat1 = SensorUtil.a(this.k);
      SensorManager.getOrientation(arrayOfFloat1, new float[3]);
      this.l = SensorUtil.a(this.l, arrayOfFloat1);
      this.jdField_c_of_type_Boolean = true;
    }
    if ((this.jdField_a_of_type_Float != 0.0F) && (this.jdField_c_of_type_Boolean))
    {
      float f7 = (float)paramSensorEvent.timestamp;
      float f8 = this.jdField_a_of_type_Float;
      System.arraycopy(paramSensorEvent.values, 0, this.i, 0, 3);
      arrayOfFloat1 = this.i;
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
      double d1 = f9 * ((f7 - f8) * 1.0E-009F) / 2.0F;
      f4 = (float)Math.sin(d1);
      f5 = (float)Math.cos(d1);
      arrayOfFloat1 = this.jdField_d_of_type_ArrayOfFloat;
      arrayOfFloat1[0] = (f2 * f4);
      arrayOfFloat1[1] = (f1 * f4);
      arrayOfFloat1[2] = (f4 * f3);
      arrayOfFloat1[3] = f5;
      float[] arrayOfFloat2 = new float[9];
      SensorUtil.c(arrayOfFloat2, arrayOfFloat1);
      this.l = SensorUtil.a(this.l, arrayOfFloat2);
      SensorManager.getOrientation(this.l, this.e);
      e();
      if ((this.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqArmapSensorARSensorManager$OnSensorChangeListener != null))
      {
        f1 = (float)(Math.toDegrees(this.e[0] + a()) + 360.0D);
        arrayOfFloat1 = this.e;
        d1 = arrayOfFloat1[1] * 180.0F;
        Double.isNaN(d1);
        f2 = (float)(d1 / 3.141592653589793D);
        d1 = arrayOfFloat1[2] * 180.0F;
        Double.isNaN(d1);
        a(f1 % 360.0F, f2, (float)(d1 / 3.141592653589793D));
      }
    }
    this.jdField_a_of_type_Float = ((float)paramSensorEvent.timestamp);
  }
  
  private void b(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArmapSensorARSensorManager$OnSensorChangeListener == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArmapSensorARSensorManager$OnSensorChangeListener.updateGyroscope(paramFloat1, paramFloat2, paramFloat3, paramLong);
  }
  
  private void d()
  {
    if (SensorManager.getRotationMatrix(this.j, null, this.h, this.g))
    {
      SensorManager.getOrientation(this.j, this.k);
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  private void e()
  {
    float[] arrayOfFloat1 = this.e;
    float[] arrayOfFloat2;
    float[] arrayOfFloat3;
    double d1;
    double d2;
    if (arrayOfFloat1[0] < -1.570796326794897D)
    {
      arrayOfFloat2 = this.k;
      if (arrayOfFloat2[0] > 0.0D)
      {
        arrayOfFloat3 = this.f;
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
    arrayOfFloat1 = this.k;
    double d3;
    if (arrayOfFloat1[0] < -1.570796326794897D)
    {
      arrayOfFloat2 = this.e;
      if (arrayOfFloat2[0] > 0.0D)
      {
        arrayOfFloat3 = this.f;
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
    this.f[0] = (this.e[0] * 0.998F + this.k[0] * 0.001999974F);
    label283:
    arrayOfFloat1 = this.e;
    if (arrayOfFloat1[1] < -1.570796326794897D)
    {
      arrayOfFloat2 = this.k;
      if (arrayOfFloat2[1] > 0.0D)
      {
        arrayOfFloat3 = this.f;
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
    arrayOfFloat1 = this.k;
    if (arrayOfFloat1[1] < -1.570796326794897D)
    {
      arrayOfFloat2 = this.e;
      if (arrayOfFloat2[1] > 0.0D)
      {
        arrayOfFloat3 = this.f;
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
    this.f[1] = (this.e[1] * 0.998F + this.k[1] * 0.001999974F);
    label566:
    arrayOfFloat1 = this.e;
    if (arrayOfFloat1[2] < -1.570796326794897D)
    {
      arrayOfFloat2 = this.k;
      if (arrayOfFloat2[2] > 0.0D)
      {
        arrayOfFloat3 = this.f;
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
    arrayOfFloat1 = this.k;
    if (arrayOfFloat1[2] < -1.570796326794897D)
    {
      arrayOfFloat2 = this.e;
      if (arrayOfFloat2[2] > 0.0D)
      {
        arrayOfFloat3 = this.f;
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
    this.f[2] = (this.e[2] * 0.998F + 0.001999974F * this.k[2]);
    label849:
    this.l = SensorUtil.a(this.f);
    SensorUtil.a(this.l, this.m);
    if (this.jdField_a_of_type_Int != 1) {
      super.a(this.m);
    }
    System.arraycopy(this.f, 0, this.e, 0, 3);
  }
  
  void a()
  {
    float[] arrayOfFloat = this.e;
    arrayOfFloat[0] = 0.0F;
    arrayOfFloat[1] = 0.0F;
    arrayOfFloat[2] = 0.0F;
    arrayOfFloat = this.l;
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
      System.arraycopy(paramSensorEvent.values, 0, this.g, 0, 3);
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    if (paramSensorEvent.sensor.getType() == 1)
    {
      System.arraycopy(paramSensorEvent.values, 0, this.h, 0, 3);
      d();
      a(paramSensorEvent.values[0], paramSensorEvent.values[1], paramSensorEvent.values[2], paramSensorEvent.timestamp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.armap.sensor.provider.AccelMagnetGyroProvider
 * JD-Core Version:    0.7.0.1
 */