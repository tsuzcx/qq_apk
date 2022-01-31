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
  private float jdField_a_of_type_Float = -1.0F;
  boolean jdField_a_of_type_Boolean = false;
  private float b = -1.0F;
  private float c = -1.0F;
  private float[] d = new float[3];
  private float[] e = new float[3];
  private float[] f = new float[16];
  
  public AccelProvider(Context paramContext, int paramInt, SensorManager paramSensorManager, ARSensorManager.OnSensorChangeListener paramOnSensorChangeListener)
  {
    super(paramContext, paramInt, paramSensorManager, paramOnSensorChangeListener);
    paramContext = paramSensorManager.getDefaultSensor(1);
    if (paramContext != null)
    {
      this.jdField_a_of_type_JavaUtilList.add(paramContext);
      return;
    }
    throw new OrientationProviderNotFound(String.valueOf(1));
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArmapSensorARSensorManager$OnSensorChangeListener == null) {
      return;
    }
    if (Math.abs(paramFloat1 - this.jdField_a_of_type_Float) > 1.0F)
    {
      this.jdField_a_of_type_Float = paramFloat1;
      this.jdField_a_of_type_ComTencentMobileqqArmapSensorARSensorManager$OnSensorChangeListener.updateAzimuth(paramFloat1);
    }
    if (Math.abs(paramFloat2 - this.b) > 1.0F)
    {
      this.b = paramFloat2;
      this.jdField_a_of_type_ComTencentMobileqqArmapSensorARSensorManager$OnSensorChangeListener.updatePitch(paramFloat2);
    }
    if (Math.abs(paramFloat3 - this.c) > 1.0F)
    {
      this.c = paramFloat3;
      this.jdField_a_of_type_ComTencentMobileqqArmapSensorARSensorManager$OnSensorChangeListener.updateRoll(paramFloat3);
    }
    this.jdField_a_of_type_ComTencentMobileqqArmapSensorARSensorManager$OnSensorChangeListener.updateSensor(paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() == 1)
    {
      System.arraycopy(paramSensorEvent.values, 0, this.jdField_a_of_type_ArrayOfFloat, 0, 3);
      float f1 = this.jdField_a_of_type_ArrayOfFloat[0];
      float f2 = this.jdField_a_of_type_ArrayOfFloat[1];
      float f3 = this.jdField_a_of_type_ArrayOfFloat[2];
      this.d[1] = (-(float)Math.atan2(f2, f3));
      this.d[2] = ((float)Math.atan2(-f1, Math.sqrt(f2 * f2 + f3 * f3)));
      if (this.jdField_a_of_type_Boolean) {
        this.d = SensorSmoother.a(this.d, this.e);
      }
      System.arraycopy(this.d, 0, this.e, 0, 3);
      this.jdField_a_of_type_Boolean = true;
      SensorUtil.a(SensorUtil.a(this.d), this.f);
      if (this.jdField_a_of_type_Int != 1) {
        super.a(this.f);
      }
    }
    else
    {
      return;
    }
    a(0.0F, (float)(this.d[1] * 180.0F / 3.141592653589793D), (float)(this.d[2] * 180.0F / 3.141592653589793D));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.sensor.provider.AccelProvider
 * JD-Core Version:    0.7.0.1
 */