package com.tencent.mobileqq.armap.sensor.provider;

import android.content.Context;
import android.hardware.SensorManager;
import com.tencent.mobileqq.armap.sensor.ARSensorManager.OnSensorChangeListener;
import com.tencent.mobileqq.armap.sensor.rotation.Matrix4;
import com.tencent.mobileqq.armap.sensor.rotation.OrientationCalculator;

public abstract class OrientationProvider2
  extends OrientationProvider
{
  public int a;
  protected Context a;
  public Matrix4 a;
  protected OrientationCalculator a;
  public float[] b = new float[3];
  public float[] c = new float[3];
  
  public OrientationProvider2(Context paramContext, int paramInt, SensorManager paramSensorManager, ARSensorManager.OnSensorChangeListener paramOnSensorChangeListener)
  {
    super(paramSensorManager, paramOnSensorChangeListener);
    this.jdField_a_of_type_ComTencentMobileqqArmapSensorRotationMatrix4 = new Matrix4();
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapSensorRotationMatrix4 = new Matrix4();
    this.jdField_a_of_type_ComTencentMobileqqArmapSensorRotationOrientationCalculator = new OrientationCalculator();
  }
  
  protected void a(float[] paramArrayOfFloat)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArmapSensorARSensorManager$OnSensorChangeListener != null)
    {
      if (paramArrayOfFloat == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqArmapSensorRotationMatrix4.set(paramArrayOfFloat);
      this.jdField_a_of_type_ComTencentMobileqqArmapSensorRotationOrientationCalculator.a(this.jdField_a_of_type_ComTencentMobileqqArmapSensorRotationMatrix4, 0, this.c);
      int i = this.jdField_a_of_type_Int;
      if (i == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqArmapSensorARSensorManager$OnSensorChangeListener.updateAzimuth(this.c[0]);
        return;
      }
      Object localObject = this.b;
      float[] arrayOfFloat = this.c;
      localObject[0] = arrayOfFloat[1];
      localObject[1] = (-arrayOfFloat[0]);
      localObject[2] = (-arrayOfFloat[2]);
      if (i == 0)
      {
        paramArrayOfFloat = this.jdField_a_of_type_ComTencentMobileqqArmapSensorARSensorManager$OnSensorChangeListener;
        localObject = this.b;
        paramArrayOfFloat.updateRotation(localObject[0], localObject[1], localObject[2]);
        return;
      }
      if ((i != 2) && (i != 3)) {
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqArmapSensorARSensorManager$OnSensorChangeListener;
      arrayOfFloat = this.b;
      ((ARSensorManager.OnSensorChangeListener)localObject).updateRotation(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2]);
      if ((this.jdField_a_of_type_Int == 3) && (paramArrayOfFloat.length == 16)) {
        this.jdField_a_of_type_ComTencentMobileqqArmapSensorARSensorManager$OnSensorChangeListener.onRotationUpdateOriginal(paramArrayOfFloat);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.armap.sensor.provider.OrientationProvider2
 * JD-Core Version:    0.7.0.1
 */