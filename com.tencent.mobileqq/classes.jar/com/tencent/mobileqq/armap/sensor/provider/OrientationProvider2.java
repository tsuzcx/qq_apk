package com.tencent.mobileqq.armap.sensor.provider;

import android.content.Context;
import android.hardware.SensorManager;
import com.tencent.mobileqq.armap.sensor.ARSensorManager.OnSensorChangeListener;
import com.tencent.mobileqq.armap.sensor.rotation.Matrix4;
import com.tencent.mobileqq.armap.sensor.rotation.OrientationCalculator;

public abstract class OrientationProvider2
  extends OrientationProvider
{
  protected OrientationCalculator h;
  public Matrix4 i = new Matrix4();
  protected Context j;
  public float[] k = new float[3];
  public float[] l = new float[3];
  public int m = 2;
  
  public OrientationProvider2(Context paramContext, int paramInt, SensorManager paramSensorManager, ARSensorManager.OnSensorChangeListener paramOnSensorChangeListener)
  {
    super(paramSensorManager, paramOnSensorChangeListener);
    this.m = paramInt;
    this.j = paramContext;
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.i = new Matrix4();
    this.h = new OrientationCalculator();
  }
  
  protected void a(float[] paramArrayOfFloat)
  {
    if (this.g != null)
    {
      if (paramArrayOfFloat == null) {
        return;
      }
      this.i.set(paramArrayOfFloat);
      this.h.a(this.i, 0, this.l);
      int n = this.m;
      if (n == 1)
      {
        this.g.updateAzimuth(this.l[0]);
        return;
      }
      Object localObject = this.k;
      float[] arrayOfFloat = this.l;
      localObject[0] = arrayOfFloat[1];
      localObject[1] = (-arrayOfFloat[0]);
      localObject[2] = (-arrayOfFloat[2]);
      if (n == 0)
      {
        paramArrayOfFloat = this.g;
        localObject = this.k;
        paramArrayOfFloat.updateRotation(localObject[0], localObject[1], localObject[2]);
        return;
      }
      if ((n != 2) && (n != 3)) {
        return;
      }
      localObject = this.g;
      arrayOfFloat = this.k;
      ((ARSensorManager.OnSensorChangeListener)localObject).updateRotation(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2]);
      if ((this.m == 3) && (paramArrayOfFloat.length == 16)) {
        this.g.onRotationUpdateOriginal(paramArrayOfFloat);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.sensor.provider.OrientationProvider2
 * JD-Core Version:    0.7.0.1
 */