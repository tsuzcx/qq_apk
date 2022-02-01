package com.tencent.mobileqq.armap.sensor.rotation;

import java.io.Serializable;

public class Matrix4
  implements Serializable
{
  public static final int M00 = 0;
  public static final int M01 = 4;
  public static final int M02 = 8;
  public static final int M03 = 12;
  public static final int M10 = 1;
  public static final int M11 = 5;
  public static final int M12 = 9;
  public static final int M13 = 13;
  public static final int M20 = 2;
  public static final int M21 = 6;
  public static final int M22 = 10;
  public static final int M23 = 14;
  public static final int M30 = 3;
  public static final int M31 = 7;
  public static final int M32 = 11;
  public static final int M33 = 15;
  static Vector3 l_vex = new Vector3();
  static Vector3 l_vey = new Vector3();
  static Vector3 l_vez;
  static Quaternion quat = new Quaternion();
  private static final long serialVersionUID = -2717655254359579617L;
  public final float[] tmp = new float[16];
  public final float[] val = new float[16];
  
  static
  {
    l_vez = new Vector3();
  }
  
  public Matrix4()
  {
    float[] arrayOfFloat = this.val;
    arrayOfFloat[0] = 1.0F;
    arrayOfFloat[5] = 1.0F;
    arrayOfFloat[10] = 1.0F;
    arrayOfFloat[15] = 1.0F;
  }
  
  public Matrix4(Matrix4 paramMatrix4)
  {
    set(paramMatrix4);
  }
  
  public Matrix4(Quaternion paramQuaternion)
  {
    set(paramQuaternion);
  }
  
  public Matrix4(float[] paramArrayOfFloat)
  {
    set(paramArrayOfFloat);
  }
  
  public void getRotation(Quaternion paramQuaternion)
  {
    paramQuaternion.setFromMatrix(this);
  }
  
  public void getTranslation(Vector3 paramVector3)
  {
    float[] arrayOfFloat = this.val;
    paramVector3.x = arrayOfFloat[12];
    paramVector3.y = arrayOfFloat[13];
    paramVector3.z = arrayOfFloat[14];
  }
  
  public float[] getValues()
  {
    return this.val;
  }
  
  public Matrix4 idt()
  {
    float[] arrayOfFloat = this.val;
    arrayOfFloat[0] = 1.0F;
    arrayOfFloat[4] = 0.0F;
    arrayOfFloat[8] = 0.0F;
    arrayOfFloat[12] = 0.0F;
    arrayOfFloat[1] = 0.0F;
    arrayOfFloat[5] = 1.0F;
    arrayOfFloat[9] = 0.0F;
    arrayOfFloat[13] = 0.0F;
    arrayOfFloat[2] = 0.0F;
    arrayOfFloat[6] = 0.0F;
    arrayOfFloat[10] = 1.0F;
    arrayOfFloat[14] = 0.0F;
    arrayOfFloat[3] = 0.0F;
    arrayOfFloat[7] = 0.0F;
    arrayOfFloat[11] = 0.0F;
    arrayOfFloat[15] = 1.0F;
    return this;
  }
  
  public Matrix4 inv()
  {
    float[] arrayOfFloat1 = this.val;
    float f = arrayOfFloat1[3] * arrayOfFloat1[6] * arrayOfFloat1[9] * arrayOfFloat1[12] - arrayOfFloat1[2] * arrayOfFloat1[7] * arrayOfFloat1[9] * arrayOfFloat1[12] - arrayOfFloat1[3] * arrayOfFloat1[5] * arrayOfFloat1[10] * arrayOfFloat1[12] + arrayOfFloat1[1] * arrayOfFloat1[7] * arrayOfFloat1[10] * arrayOfFloat1[12] + arrayOfFloat1[2] * arrayOfFloat1[5] * arrayOfFloat1[11] * arrayOfFloat1[12] - arrayOfFloat1[1] * arrayOfFloat1[6] * arrayOfFloat1[11] * arrayOfFloat1[12] - arrayOfFloat1[3] * arrayOfFloat1[6] * arrayOfFloat1[8] * arrayOfFloat1[13] + arrayOfFloat1[2] * arrayOfFloat1[7] * arrayOfFloat1[8] * arrayOfFloat1[13] + arrayOfFloat1[3] * arrayOfFloat1[4] * arrayOfFloat1[10] * arrayOfFloat1[13] - arrayOfFloat1[0] * arrayOfFloat1[7] * arrayOfFloat1[10] * arrayOfFloat1[13] - arrayOfFloat1[2] * arrayOfFloat1[4] * arrayOfFloat1[11] * arrayOfFloat1[13] + arrayOfFloat1[0] * arrayOfFloat1[6] * arrayOfFloat1[11] * arrayOfFloat1[13] + arrayOfFloat1[3] * arrayOfFloat1[5] * arrayOfFloat1[8] * arrayOfFloat1[14] - arrayOfFloat1[1] * arrayOfFloat1[7] * arrayOfFloat1[8] * arrayOfFloat1[14] - arrayOfFloat1[3] * arrayOfFloat1[4] * arrayOfFloat1[9] * arrayOfFloat1[14] + arrayOfFloat1[0] * arrayOfFloat1[7] * arrayOfFloat1[9] * arrayOfFloat1[14] + arrayOfFloat1[1] * arrayOfFloat1[4] * arrayOfFloat1[11] * arrayOfFloat1[14] - arrayOfFloat1[0] * arrayOfFloat1[5] * arrayOfFloat1[11] * arrayOfFloat1[14] - arrayOfFloat1[2] * arrayOfFloat1[5] * arrayOfFloat1[8] * arrayOfFloat1[15] + arrayOfFloat1[1] * arrayOfFloat1[6] * arrayOfFloat1[8] * arrayOfFloat1[15] + arrayOfFloat1[2] * arrayOfFloat1[4] * arrayOfFloat1[9] * arrayOfFloat1[15] - arrayOfFloat1[0] * arrayOfFloat1[6] * arrayOfFloat1[9] * arrayOfFloat1[15] - arrayOfFloat1[1] * arrayOfFloat1[4] * arrayOfFloat1[10] * arrayOfFloat1[15] + arrayOfFloat1[0] * arrayOfFloat1[5] * arrayOfFloat1[10] * arrayOfFloat1[15];
    if (f != 0.0F)
    {
      f = 1.0F / f;
      float[] arrayOfFloat2 = this.tmp;
      arrayOfFloat2[0] = (arrayOfFloat1[9] * arrayOfFloat1[14] * arrayOfFloat1[7] - arrayOfFloat1[13] * arrayOfFloat1[10] * arrayOfFloat1[7] + arrayOfFloat1[13] * arrayOfFloat1[6] * arrayOfFloat1[11] - arrayOfFloat1[5] * arrayOfFloat1[14] * arrayOfFloat1[11] - arrayOfFloat1[9] * arrayOfFloat1[6] * arrayOfFloat1[15] + arrayOfFloat1[5] * arrayOfFloat1[10] * arrayOfFloat1[15]);
      arrayOfFloat2[4] = (arrayOfFloat1[12] * arrayOfFloat1[10] * arrayOfFloat1[7] - arrayOfFloat1[8] * arrayOfFloat1[14] * arrayOfFloat1[7] - arrayOfFloat1[12] * arrayOfFloat1[6] * arrayOfFloat1[11] + arrayOfFloat1[4] * arrayOfFloat1[14] * arrayOfFloat1[11] + arrayOfFloat1[8] * arrayOfFloat1[6] * arrayOfFloat1[15] - arrayOfFloat1[4] * arrayOfFloat1[10] * arrayOfFloat1[15]);
      arrayOfFloat2[8] = (arrayOfFloat1[8] * arrayOfFloat1[13] * arrayOfFloat1[7] - arrayOfFloat1[12] * arrayOfFloat1[9] * arrayOfFloat1[7] + arrayOfFloat1[12] * arrayOfFloat1[5] * arrayOfFloat1[11] - arrayOfFloat1[4] * arrayOfFloat1[13] * arrayOfFloat1[11] - arrayOfFloat1[8] * arrayOfFloat1[5] * arrayOfFloat1[15] + arrayOfFloat1[4] * arrayOfFloat1[9] * arrayOfFloat1[15]);
      arrayOfFloat2[12] = (arrayOfFloat1[12] * arrayOfFloat1[9] * arrayOfFloat1[6] - arrayOfFloat1[8] * arrayOfFloat1[13] * arrayOfFloat1[6] - arrayOfFloat1[12] * arrayOfFloat1[5] * arrayOfFloat1[10] + arrayOfFloat1[4] * arrayOfFloat1[13] * arrayOfFloat1[10] + arrayOfFloat1[8] * arrayOfFloat1[5] * arrayOfFloat1[14] - arrayOfFloat1[4] * arrayOfFloat1[9] * arrayOfFloat1[14]);
      arrayOfFloat2[1] = (arrayOfFloat1[13] * arrayOfFloat1[10] * arrayOfFloat1[3] - arrayOfFloat1[9] * arrayOfFloat1[14] * arrayOfFloat1[3] - arrayOfFloat1[13] * arrayOfFloat1[2] * arrayOfFloat1[11] + arrayOfFloat1[1] * arrayOfFloat1[14] * arrayOfFloat1[11] + arrayOfFloat1[9] * arrayOfFloat1[2] * arrayOfFloat1[15] - arrayOfFloat1[1] * arrayOfFloat1[10] * arrayOfFloat1[15]);
      arrayOfFloat2[5] = (arrayOfFloat1[8] * arrayOfFloat1[14] * arrayOfFloat1[3] - arrayOfFloat1[12] * arrayOfFloat1[10] * arrayOfFloat1[3] + arrayOfFloat1[12] * arrayOfFloat1[2] * arrayOfFloat1[11] - arrayOfFloat1[0] * arrayOfFloat1[14] * arrayOfFloat1[11] - arrayOfFloat1[8] * arrayOfFloat1[2] * arrayOfFloat1[15] + arrayOfFloat1[0] * arrayOfFloat1[10] * arrayOfFloat1[15]);
      arrayOfFloat2[9] = (arrayOfFloat1[12] * arrayOfFloat1[9] * arrayOfFloat1[3] - arrayOfFloat1[8] * arrayOfFloat1[13] * arrayOfFloat1[3] - arrayOfFloat1[12] * arrayOfFloat1[1] * arrayOfFloat1[11] + arrayOfFloat1[0] * arrayOfFloat1[13] * arrayOfFloat1[11] + arrayOfFloat1[8] * arrayOfFloat1[1] * arrayOfFloat1[15] - arrayOfFloat1[0] * arrayOfFloat1[9] * arrayOfFloat1[15]);
      arrayOfFloat2[13] = (arrayOfFloat1[8] * arrayOfFloat1[13] * arrayOfFloat1[2] - arrayOfFloat1[12] * arrayOfFloat1[9] * arrayOfFloat1[2] + arrayOfFloat1[12] * arrayOfFloat1[1] * arrayOfFloat1[10] - arrayOfFloat1[0] * arrayOfFloat1[13] * arrayOfFloat1[10] - arrayOfFloat1[8] * arrayOfFloat1[1] * arrayOfFloat1[14] + arrayOfFloat1[0] * arrayOfFloat1[9] * arrayOfFloat1[14]);
      arrayOfFloat2[2] = (arrayOfFloat1[5] * arrayOfFloat1[14] * arrayOfFloat1[3] - arrayOfFloat1[13] * arrayOfFloat1[6] * arrayOfFloat1[3] + arrayOfFloat1[13] * arrayOfFloat1[2] * arrayOfFloat1[7] - arrayOfFloat1[1] * arrayOfFloat1[14] * arrayOfFloat1[7] - arrayOfFloat1[5] * arrayOfFloat1[2] * arrayOfFloat1[15] + arrayOfFloat1[1] * arrayOfFloat1[6] * arrayOfFloat1[15]);
      arrayOfFloat2[6] = (arrayOfFloat1[12] * arrayOfFloat1[6] * arrayOfFloat1[3] - arrayOfFloat1[4] * arrayOfFloat1[14] * arrayOfFloat1[3] - arrayOfFloat1[12] * arrayOfFloat1[2] * arrayOfFloat1[7] + arrayOfFloat1[0] * arrayOfFloat1[14] * arrayOfFloat1[7] + arrayOfFloat1[4] * arrayOfFloat1[2] * arrayOfFloat1[15] - arrayOfFloat1[0] * arrayOfFloat1[6] * arrayOfFloat1[15]);
      arrayOfFloat2[10] = (arrayOfFloat1[4] * arrayOfFloat1[13] * arrayOfFloat1[3] - arrayOfFloat1[12] * arrayOfFloat1[5] * arrayOfFloat1[3] + arrayOfFloat1[12] * arrayOfFloat1[1] * arrayOfFloat1[7] - arrayOfFloat1[0] * arrayOfFloat1[13] * arrayOfFloat1[7] - arrayOfFloat1[4] * arrayOfFloat1[1] * arrayOfFloat1[15] + arrayOfFloat1[0] * arrayOfFloat1[5] * arrayOfFloat1[15]);
      arrayOfFloat2[14] = (arrayOfFloat1[12] * arrayOfFloat1[5] * arrayOfFloat1[2] - arrayOfFloat1[4] * arrayOfFloat1[13] * arrayOfFloat1[2] - arrayOfFloat1[12] * arrayOfFloat1[1] * arrayOfFloat1[6] + arrayOfFloat1[0] * arrayOfFloat1[13] * arrayOfFloat1[6] + arrayOfFloat1[4] * arrayOfFloat1[1] * arrayOfFloat1[14] - arrayOfFloat1[0] * arrayOfFloat1[5] * arrayOfFloat1[14]);
      arrayOfFloat2[3] = (arrayOfFloat1[9] * arrayOfFloat1[6] * arrayOfFloat1[3] - arrayOfFloat1[5] * arrayOfFloat1[10] * arrayOfFloat1[3] - arrayOfFloat1[9] * arrayOfFloat1[2] * arrayOfFloat1[7] + arrayOfFloat1[1] * arrayOfFloat1[10] * arrayOfFloat1[7] + arrayOfFloat1[5] * arrayOfFloat1[2] * arrayOfFloat1[11] - arrayOfFloat1[1] * arrayOfFloat1[6] * arrayOfFloat1[11]);
      arrayOfFloat2[7] = (arrayOfFloat1[4] * arrayOfFloat1[10] * arrayOfFloat1[3] - arrayOfFloat1[8] * arrayOfFloat1[6] * arrayOfFloat1[3] + arrayOfFloat1[8] * arrayOfFloat1[2] * arrayOfFloat1[7] - arrayOfFloat1[0] * arrayOfFloat1[10] * arrayOfFloat1[7] - arrayOfFloat1[4] * arrayOfFloat1[2] * arrayOfFloat1[11] + arrayOfFloat1[0] * arrayOfFloat1[6] * arrayOfFloat1[11]);
      arrayOfFloat2[11] = (arrayOfFloat1[8] * arrayOfFloat1[5] * arrayOfFloat1[3] - arrayOfFloat1[4] * arrayOfFloat1[9] * arrayOfFloat1[3] - arrayOfFloat1[8] * arrayOfFloat1[1] * arrayOfFloat1[7] + arrayOfFloat1[0] * arrayOfFloat1[9] * arrayOfFloat1[7] + arrayOfFloat1[4] * arrayOfFloat1[1] * arrayOfFloat1[11] - arrayOfFloat1[0] * arrayOfFloat1[5] * arrayOfFloat1[11]);
      arrayOfFloat2[15] = (arrayOfFloat1[4] * arrayOfFloat1[9] * arrayOfFloat1[2] - arrayOfFloat1[8] * arrayOfFloat1[5] * arrayOfFloat1[2] + arrayOfFloat1[8] * arrayOfFloat1[1] * arrayOfFloat1[6] - arrayOfFloat1[0] * arrayOfFloat1[9] * arrayOfFloat1[6] - arrayOfFloat1[4] * arrayOfFloat1[1] * arrayOfFloat1[10] + arrayOfFloat1[0] * arrayOfFloat1[5] * arrayOfFloat1[10]);
      arrayOfFloat2[0] *= f;
      arrayOfFloat2[4] *= f;
      arrayOfFloat2[8] *= f;
      arrayOfFloat2[12] *= f;
      arrayOfFloat2[1] *= f;
      arrayOfFloat2[5] *= f;
      arrayOfFloat2[9] *= f;
      arrayOfFloat2[13] *= f;
      arrayOfFloat2[2] *= f;
      arrayOfFloat2[6] *= f;
      arrayOfFloat2[10] *= f;
      arrayOfFloat2[14] *= f;
      arrayOfFloat2[3] *= f;
      arrayOfFloat2[7] *= f;
      arrayOfFloat2[11] *= f;
      arrayOfFloat2[15] *= f;
      return this;
    }
    throw new RuntimeException("non-invertible matrix");
  }
  
  public void lerp(Matrix4 paramMatrix4, float paramFloat)
  {
    int i = 0;
    while (i < 16)
    {
      float[] arrayOfFloat = this.val;
      arrayOfFloat[i] = (arrayOfFloat[i] * (1.0F - paramFloat) + paramMatrix4.val[i] * paramFloat);
      i += 1;
    }
  }
  
  public Matrix4 mul(Matrix4 paramMatrix4)
  {
    return mul_java(paramMatrix4);
  }
  
  public Matrix4 mul_java(Matrix4 paramMatrix4)
  {
    float[] arrayOfFloat1 = this.tmp;
    float[] arrayOfFloat2 = this.val;
    float f = arrayOfFloat2[0];
    paramMatrix4 = paramMatrix4.val;
    arrayOfFloat1[0] = (f * paramMatrix4[0] + arrayOfFloat2[4] * paramMatrix4[1] + arrayOfFloat2[8] * paramMatrix4[2] + arrayOfFloat2[12] * paramMatrix4[3]);
    arrayOfFloat1[4] = (arrayOfFloat2[0] * paramMatrix4[4] + arrayOfFloat2[4] * paramMatrix4[5] + arrayOfFloat2[8] * paramMatrix4[6] + arrayOfFloat2[12] * paramMatrix4[7]);
    arrayOfFloat1[8] = (arrayOfFloat2[0] * paramMatrix4[8] + arrayOfFloat2[4] * paramMatrix4[9] + arrayOfFloat2[8] * paramMatrix4[10] + arrayOfFloat2[12] * paramMatrix4[11]);
    arrayOfFloat1[12] = (arrayOfFloat2[0] * paramMatrix4[12] + arrayOfFloat2[4] * paramMatrix4[13] + arrayOfFloat2[8] * paramMatrix4[14] + arrayOfFloat2[12] * paramMatrix4[15]);
    arrayOfFloat1[1] = (arrayOfFloat2[1] * paramMatrix4[0] + arrayOfFloat2[5] * paramMatrix4[1] + arrayOfFloat2[9] * paramMatrix4[2] + arrayOfFloat2[13] * paramMatrix4[3]);
    arrayOfFloat1[5] = (arrayOfFloat2[1] * paramMatrix4[4] + arrayOfFloat2[5] * paramMatrix4[5] + arrayOfFloat2[9] * paramMatrix4[6] + arrayOfFloat2[13] * paramMatrix4[7]);
    arrayOfFloat1[9] = (arrayOfFloat2[1] * paramMatrix4[8] + arrayOfFloat2[5] * paramMatrix4[9] + arrayOfFloat2[9] * paramMatrix4[10] + arrayOfFloat2[13] * paramMatrix4[11]);
    arrayOfFloat1[13] = (arrayOfFloat2[1] * paramMatrix4[12] + arrayOfFloat2[5] * paramMatrix4[13] + arrayOfFloat2[9] * paramMatrix4[14] + arrayOfFloat2[13] * paramMatrix4[15]);
    arrayOfFloat1[2] = (arrayOfFloat2[2] * paramMatrix4[0] + arrayOfFloat2[6] * paramMatrix4[1] + arrayOfFloat2[10] * paramMatrix4[2] + arrayOfFloat2[14] * paramMatrix4[3]);
    arrayOfFloat1[6] = (arrayOfFloat2[2] * paramMatrix4[4] + arrayOfFloat2[6] * paramMatrix4[5] + arrayOfFloat2[10] * paramMatrix4[6] + arrayOfFloat2[14] * paramMatrix4[7]);
    arrayOfFloat1[10] = (arrayOfFloat2[2] * paramMatrix4[8] + arrayOfFloat2[6] * paramMatrix4[9] + arrayOfFloat2[10] * paramMatrix4[10] + arrayOfFloat2[14] * paramMatrix4[11]);
    arrayOfFloat1[14] = (arrayOfFloat2[2] * paramMatrix4[12] + arrayOfFloat2[6] * paramMatrix4[13] + arrayOfFloat2[10] * paramMatrix4[14] + arrayOfFloat2[14] * paramMatrix4[15]);
    arrayOfFloat1[3] = (arrayOfFloat2[3] * paramMatrix4[0] + arrayOfFloat2[7] * paramMatrix4[1] + arrayOfFloat2[11] * paramMatrix4[2] + arrayOfFloat2[15] * paramMatrix4[3]);
    arrayOfFloat1[7] = (arrayOfFloat2[3] * paramMatrix4[4] + arrayOfFloat2[7] * paramMatrix4[5] + arrayOfFloat2[11] * paramMatrix4[6] + arrayOfFloat2[15] * paramMatrix4[7]);
    arrayOfFloat1[11] = (arrayOfFloat2[3] * paramMatrix4[8] + arrayOfFloat2[7] * paramMatrix4[9] + arrayOfFloat2[11] * paramMatrix4[10] + arrayOfFloat2[15] * paramMatrix4[11]);
    arrayOfFloat1[15] = (arrayOfFloat2[3] * paramMatrix4[12] + arrayOfFloat2[7] * paramMatrix4[13] + arrayOfFloat2[11] * paramMatrix4[14] + arrayOfFloat2[15] * paramMatrix4[15]);
    return set(arrayOfFloat1);
  }
  
  public Matrix4 set(Matrix3 paramMatrix3)
  {
    this.val[0] = paramMatrix3.val[0];
    this.val[1] = paramMatrix3.val[1];
    this.val[2] = paramMatrix3.val[2];
    float[] arrayOfFloat = this.val;
    arrayOfFloat[3] = 0.0F;
    arrayOfFloat[4] = paramMatrix3.val[3];
    this.val[5] = paramMatrix3.val[4];
    this.val[6] = paramMatrix3.val[5];
    arrayOfFloat = this.val;
    arrayOfFloat[7] = 0.0F;
    arrayOfFloat[8] = 0.0F;
    arrayOfFloat[9] = 0.0F;
    arrayOfFloat[10] = 1.0F;
    arrayOfFloat[11] = 0.0F;
    arrayOfFloat[12] = paramMatrix3.val[6];
    this.val[13] = paramMatrix3.val[7];
    arrayOfFloat = this.val;
    arrayOfFloat[14] = 0.0F;
    arrayOfFloat[15] = paramMatrix3.val[8];
    return this;
  }
  
  public Matrix4 set(Matrix4 paramMatrix4)
  {
    return set(paramMatrix4.val);
  }
  
  public Matrix4 set(Quaternion paramQuaternion)
  {
    float f1 = paramQuaternion.x * paramQuaternion.x;
    float f2 = paramQuaternion.x * paramQuaternion.y;
    float f3 = paramQuaternion.x * paramQuaternion.z;
    float f4 = paramQuaternion.x * paramQuaternion.w;
    float f5 = paramQuaternion.y * paramQuaternion.y;
    float f6 = paramQuaternion.y * paramQuaternion.z;
    float f7 = paramQuaternion.y * paramQuaternion.w;
    float f8 = paramQuaternion.z * paramQuaternion.z;
    float f9 = paramQuaternion.z * paramQuaternion.w;
    paramQuaternion = this.val;
    paramQuaternion[0] = (1.0F - (f5 + f8) * 2.0F);
    paramQuaternion[4] = ((f2 - f9) * 2.0F);
    paramQuaternion[8] = ((f3 + f7) * 2.0F);
    paramQuaternion[12] = 0.0F;
    paramQuaternion[1] = ((f2 + f9) * 2.0F);
    paramQuaternion[5] = (1.0F - (f8 + f1) * 2.0F);
    paramQuaternion[9] = ((f6 - f4) * 2.0F);
    paramQuaternion[13] = 0.0F;
    paramQuaternion[2] = ((f3 - f7) * 2.0F);
    paramQuaternion[6] = ((f6 + f4) * 2.0F);
    paramQuaternion[10] = (1.0F - (f1 + f5) * 2.0F);
    paramQuaternion[14] = 0.0F;
    paramQuaternion[3] = 0.0F;
    paramQuaternion[7] = 0.0F;
    paramQuaternion[11] = 0.0F;
    paramQuaternion[15] = 1.0F;
    return this;
  }
  
  public Matrix4 set(Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33, Vector3 paramVector34)
  {
    this.val[0] = paramVector31.x;
    this.val[4] = paramVector31.y;
    this.val[8] = paramVector31.z;
    this.val[1] = paramVector32.x;
    this.val[5] = paramVector32.y;
    this.val[9] = paramVector32.z;
    this.val[2] = (-paramVector33.x);
    this.val[6] = (-paramVector33.y);
    this.val[10] = (-paramVector33.z);
    this.val[12] = paramVector34.x;
    this.val[13] = paramVector34.y;
    this.val[14] = paramVector34.z;
    paramVector31 = this.val;
    paramVector31[3] = 0.0F;
    paramVector31[7] = 0.0F;
    paramVector31[11] = 0.0F;
    paramVector31[15] = 1.0F;
    return this;
  }
  
  public Matrix4 set(float[] paramArrayOfFloat)
  {
    float[] arrayOfFloat = this.val;
    System.arraycopy(paramArrayOfFloat, 0, arrayOfFloat, 0, arrayOfFloat.length);
    return this;
  }
  
  public Matrix4 setToLookAt(Vector3 paramVector31, Vector3 paramVector32)
  {
    l_vez.set(paramVector31).nor();
    l_vex.set(paramVector31).nor();
    l_vex.crs(paramVector32).nor();
    l_vey.set(l_vex).crs(l_vez).nor();
    idt();
    this.val[0] = l_vex.x;
    this.val[4] = l_vex.y;
    this.val[8] = l_vex.z;
    this.val[1] = l_vey.x;
    this.val[5] = l_vey.y;
    this.val[9] = l_vey.z;
    this.val[2] = (-l_vez.x);
    this.val[6] = (-l_vez.y);
    this.val[10] = (-l_vez.z);
    return this;
  }
  
  public Matrix4 setToOrtho(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    idt();
    float f6 = paramFloat2 - paramFloat1;
    float f1 = 2.0F / f6;
    float f5 = paramFloat4 - paramFloat3;
    float f2 = 2.0F / f5;
    float f4 = paramFloat6 - paramFloat5;
    float f3 = -2.0F / f4;
    paramFloat1 = -(paramFloat2 + paramFloat1) / f6;
    paramFloat2 = -(paramFloat4 + paramFloat3) / f5;
    paramFloat3 = -(paramFloat6 + paramFloat5) / f4;
    float[] arrayOfFloat = this.val;
    arrayOfFloat[0] = f1;
    arrayOfFloat[1] = 0.0F;
    arrayOfFloat[2] = 0.0F;
    arrayOfFloat[3] = 0.0F;
    arrayOfFloat[4] = 0.0F;
    arrayOfFloat[5] = f2;
    arrayOfFloat[6] = 0.0F;
    arrayOfFloat[7] = 0.0F;
    arrayOfFloat[8] = 0.0F;
    arrayOfFloat[9] = 0.0F;
    arrayOfFloat[10] = f3;
    arrayOfFloat[11] = 0.0F;
    arrayOfFloat[12] = paramFloat1;
    arrayOfFloat[13] = paramFloat2;
    arrayOfFloat[14] = paramFloat3;
    arrayOfFloat[15] = 1.0F;
    return this;
  }
  
  public Matrix4 setToOrtho2D(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    setToOrtho(paramFloat1, paramFloat1 + paramFloat3, paramFloat2, paramFloat2 + paramFloat4, 0.0F, 1.0F);
    return this;
  }
  
  public Matrix4 setToRotation(Vector3 paramVector3, float paramFloat)
  {
    if (paramFloat == 0.0F)
    {
      idt();
      return this;
    }
    return set(quat.set(paramVector3, paramFloat));
  }
  
  public Matrix4 setToTranslation(Vector3 paramVector3)
  {
    idt();
    this.val[12] = paramVector3.x;
    this.val[13] = paramVector3.y;
    this.val[14] = paramVector3.z;
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.val[0]);
    localStringBuilder.append("|");
    localStringBuilder.append(this.val[4]);
    localStringBuilder.append("|");
    localStringBuilder.append(this.val[8]);
    localStringBuilder.append("|");
    localStringBuilder.append(this.val[12]);
    localStringBuilder.append("]\n[");
    localStringBuilder.append(this.val[1]);
    localStringBuilder.append("|");
    localStringBuilder.append(this.val[5]);
    localStringBuilder.append("|");
    localStringBuilder.append(this.val[9]);
    localStringBuilder.append("|");
    localStringBuilder.append(this.val[13]);
    localStringBuilder.append("]\n[");
    localStringBuilder.append(this.val[2]);
    localStringBuilder.append("|");
    localStringBuilder.append(this.val[6]);
    localStringBuilder.append("|");
    localStringBuilder.append(this.val[10]);
    localStringBuilder.append("|");
    localStringBuilder.append(this.val[14]);
    localStringBuilder.append("]\n[");
    localStringBuilder.append(this.val[3]);
    localStringBuilder.append("|");
    localStringBuilder.append(this.val[7]);
    localStringBuilder.append("|");
    localStringBuilder.append(this.val[11]);
    localStringBuilder.append("|");
    localStringBuilder.append(this.val[15]);
    localStringBuilder.append("]\n");
    return localStringBuilder.toString();
  }
  
  public Matrix4 tra()
  {
    float[] arrayOfFloat1 = this.tmp;
    float[] arrayOfFloat2 = this.val;
    arrayOfFloat1[0] = arrayOfFloat2[0];
    arrayOfFloat1[4] = arrayOfFloat2[1];
    arrayOfFloat1[8] = arrayOfFloat2[2];
    arrayOfFloat1[12] = arrayOfFloat2[3];
    arrayOfFloat1[1] = arrayOfFloat2[4];
    arrayOfFloat1[5] = arrayOfFloat2[5];
    arrayOfFloat1[9] = arrayOfFloat2[6];
    arrayOfFloat1[13] = arrayOfFloat2[7];
    arrayOfFloat1[2] = arrayOfFloat2[8];
    arrayOfFloat1[6] = arrayOfFloat2[9];
    arrayOfFloat1[10] = arrayOfFloat2[10];
    arrayOfFloat1[14] = arrayOfFloat2[11];
    arrayOfFloat1[3] = arrayOfFloat2[12];
    arrayOfFloat1[7] = arrayOfFloat2[13];
    arrayOfFloat1[11] = arrayOfFloat2[14];
    arrayOfFloat1[15] = arrayOfFloat2[15];
    return set(arrayOfFloat1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.sensor.rotation.Matrix4
 * JD-Core Version:    0.7.0.1
 */