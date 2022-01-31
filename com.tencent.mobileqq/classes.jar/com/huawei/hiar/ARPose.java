package com.huawei.hiar;

import com.huawei.hiar.annotations.UsedByNative;
import java.util.Locale;

public class ARPose
{
  public static final ARPose IDENTITY;
  private final ARQuaternion quaternion;
  private final float[] translation;
  
  static
  {
    ARQuaternion localARQuaternion = ARQuaternion.IDENTITY;
    IDENTITY = new ARPose(new float[] { 0.0F, 0.0F, 0.0F }, localARQuaternion);
  }
  
  @UsedByNative("hiar_helper.cpp")
  private ARPose(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7)
  {
    this.quaternion = new ARQuaternion(paramFloat4, paramFloat5, paramFloat6, paramFloat7);
    this.translation = new float[] { paramFloat1, paramFloat2, paramFloat3 };
  }
  
  private ARPose(float[] paramArrayOfFloat, ARQuaternion paramARQuaternion)
  {
    this.translation = paramArrayOfFloat;
    this.quaternion = paramARQuaternion;
    paramARQuaternion.getValues(new float[4], 0);
  }
  
  public ARPose(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if ((paramArrayOfFloat1 == null) || (paramArrayOfFloat1.length < 3) || (paramArrayOfFloat2 == null) || (paramArrayOfFloat2.length < 4)) {
      throw new IllegalArgumentException();
    }
    this.quaternion = new ARQuaternion(paramArrayOfFloat2[0], paramArrayOfFloat2[1], paramArrayOfFloat2[2], paramArrayOfFloat2[3]);
    this.translation = new float[] { paramArrayOfFloat1[0], paramArrayOfFloat1[1], paramArrayOfFloat1[2] };
  }
  
  public static ARPose makeInterpolated(ARPose paramARPose1, ARPose paramARPose2, float paramFloat)
  {
    if ((paramFloat > 1.0F) || (paramFloat < 0.0F)) {
      throw new IllegalArgumentException();
    }
    if (paramFloat == 0.0F) {
      return paramARPose1;
    }
    if (paramFloat == 1.0F) {
      return paramARPose2;
    }
    float[] arrayOfFloat = new float[3];
    int i = 0;
    while (i < 3)
    {
      arrayOfFloat[i] = (paramARPose1.translation[i] * (1.0F - paramFloat) + paramARPose2.translation[i] * paramFloat);
      i += 1;
    }
    return new ARPose(arrayOfFloat, ARQuaternion.makeInterpolated(paramARPose1.quaternion, paramARPose2.quaternion, paramFloat));
  }
  
  public static ARPose makeRotation(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return new ARPose(IDENTITY.translation, new ARQuaternion(paramFloat1, paramFloat2, paramFloat3, paramFloat4));
  }
  
  public static ARPose makeRotation(float[] paramArrayOfFloat)
  {
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length < 4)) {
      throw new IllegalArgumentException();
    }
    return makeRotation(paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[2], paramArrayOfFloat[3]);
  }
  
  public static ARPose makeTranslation(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    ARQuaternion localARQuaternion = IDENTITY.quaternion;
    return new ARPose(new float[] { paramFloat1, paramFloat2, paramFloat3 }, localARQuaternion);
  }
  
  public static ARPose makeTranslation(float[] paramArrayOfFloat)
  {
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length < 3)) {
      throw new IllegalArgumentException();
    }
    return makeTranslation(paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[2]);
  }
  
  public ARPose compose(ARPose paramARPose)
  {
    float[] arrayOfFloat = new float[3];
    ARQuaternion.rotateVector(this.quaternion, paramARPose.translation, 0, arrayOfFloat, 0);
    arrayOfFloat[0] += this.translation[0];
    arrayOfFloat[1] += this.translation[1];
    arrayOfFloat[2] += this.translation[2];
    return new ARPose(arrayOfFloat, this.quaternion.compose(paramARPose.quaternion));
  }
  
  public ARPose extractRotation()
  {
    return new ARPose(IDENTITY.translation, this.quaternion);
  }
  
  public ARPose extractTranslation()
  {
    return new ARPose(this.translation, IDENTITY.quaternion);
  }
  
  ARQuaternion getQuaternion()
  {
    return this.quaternion;
  }
  
  public void getRotationQuaternion(float[] paramArrayOfFloat, int paramInt)
  {
    if ((paramArrayOfFloat == null) || (paramInt < 0) || (paramArrayOfFloat.length < paramInt + 4)) {
      throw new IllegalArgumentException();
    }
    this.quaternion.getValues(paramArrayOfFloat, paramInt);
  }
  
  public void getTransformedAxis(int paramInt1, float paramFloat, float[] paramArrayOfFloat, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 > 2) || (paramArrayOfFloat == null) || (paramInt2 < 0) || (paramArrayOfFloat.length < paramInt2 + 3)) {
      throw new IllegalArgumentException();
    }
    this.quaternion.getTransformedAxis(paramInt1, paramFloat, paramArrayOfFloat, paramInt2);
  }
  
  public float[] getTransformedAxis(int paramInt, float paramFloat)
  {
    float[] arrayOfFloat = new float[3];
    getTransformedAxis(paramInt, paramFloat, arrayOfFloat, 0);
    return arrayOfFloat;
  }
  
  public void getTranslation(float[] paramArrayOfFloat, int paramInt)
  {
    if ((paramArrayOfFloat == null) || (paramInt < 0) || (paramArrayOfFloat.length < paramInt + 3)) {
      throw new IllegalArgumentException();
    }
    System.arraycopy(this.translation, 0, paramArrayOfFloat, paramInt, 3);
  }
  
  public float[] getXAxis()
  {
    return getTransformedAxis(0, 1.0F);
  }
  
  public float[] getYAxis()
  {
    return getTransformedAxis(1, 1.0F);
  }
  
  public float[] getZAxis()
  {
    return getTransformedAxis(2, 1.0F);
  }
  
  public ARPose inverse()
  {
    float[] arrayOfFloat = new float[3];
    ARQuaternion localARQuaternion = this.quaternion.inverse();
    ARQuaternion.rotateVector(localARQuaternion, this.translation, 0, arrayOfFloat, 0);
    arrayOfFloat[0] = (-arrayOfFloat[0]);
    arrayOfFloat[1] = (-arrayOfFloat[1]);
    arrayOfFloat[2] = (-arrayOfFloat[2]);
    return new ARPose(arrayOfFloat, localARQuaternion);
  }
  
  public float qw()
  {
    return this.quaternion.w();
  }
  
  public float qx()
  {
    return this.quaternion.x();
  }
  
  public float qy()
  {
    return this.quaternion.y();
  }
  
  public float qz()
  {
    return this.quaternion.z();
  }
  
  public void rotateVector(float[] paramArrayOfFloat1, int paramInt1, float[] paramArrayOfFloat2, int paramInt2)
  {
    if ((paramArrayOfFloat1 == null) || (paramInt1 < 0) || (paramArrayOfFloat1.length < paramInt1 + 3) || (paramArrayOfFloat2 == null) || (paramInt2 < 0) || (paramArrayOfFloat2.length < paramInt2 + 3)) {
      throw new IllegalArgumentException();
    }
    ARQuaternion.rotateVector(this.quaternion, paramArrayOfFloat1, paramInt1, paramArrayOfFloat2, paramInt2);
  }
  
  public void toMatrix(float[] paramArrayOfFloat, int paramInt)
  {
    if ((paramArrayOfFloat == null) || (paramInt < 0) || (paramArrayOfFloat.length < paramInt + 16)) {
      throw new IllegalArgumentException();
    }
    this.quaternion.toMatrix(paramArrayOfFloat, paramInt, 4);
    paramArrayOfFloat[(paramInt + 0 + 12)] = this.translation[0];
    paramArrayOfFloat[(paramInt + 1 + 12)] = this.translation[1];
    paramArrayOfFloat[(paramInt + 2 + 12)] = this.translation[2];
    paramArrayOfFloat[(paramInt + 3)] = 0.0F;
    paramArrayOfFloat[(paramInt + 7)] = 0.0F;
    paramArrayOfFloat[(paramInt + 11)] = 0.0F;
    paramArrayOfFloat[(paramInt + 15)] = 1.0F;
  }
  
  public String toString()
  {
    return String.format(Locale.ENGLISH, "t:[x:%.3f, y:%.3f, z:%.3f], q:[x:%.2f, y:%.2f, z:%.2f, w:%.2f]", new Object[] { Float.valueOf(this.translation[0]), Float.valueOf(this.translation[1]), Float.valueOf(this.translation[2]), Float.valueOf(this.quaternion.x()), Float.valueOf(this.quaternion.y()), Float.valueOf(this.quaternion.z()), Float.valueOf(this.quaternion.w()) });
  }
  
  public void transformPoint(float[] paramArrayOfFloat1, int paramInt1, float[] paramArrayOfFloat2, int paramInt2)
  {
    rotateVector(paramArrayOfFloat1, paramInt1, paramArrayOfFloat2, paramInt2);
    paramInt1 = 0;
    while (paramInt1 < 3)
    {
      int i = paramInt1 + paramInt2;
      paramArrayOfFloat2[i] += this.translation[paramInt1];
      paramInt1 += 1;
    }
  }
  
  public float[] transformPoint(float[] paramArrayOfFloat)
  {
    float[] arrayOfFloat = new float[3];
    transformPoint(paramArrayOfFloat, 0, arrayOfFloat, 0);
    return arrayOfFloat;
  }
  
  public float tx()
  {
    return this.translation[0];
  }
  
  public float ty()
  {
    return this.translation[1];
  }
  
  public float tz()
  {
    return this.translation[2];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.huawei.hiar.ARPose
 * JD-Core Version:    0.7.0.1
 */