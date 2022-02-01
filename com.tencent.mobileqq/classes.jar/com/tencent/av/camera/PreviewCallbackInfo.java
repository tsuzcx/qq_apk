package com.tencent.av.camera;

import com.tencent.qphone.base.util.QLog;

public class PreviewCallbackInfo
{
  int jdField_a_of_type_Int = -99;
  boolean jdField_a_of_type_Boolean = false;
  int b = -99;
  int c = -99;
  int d = -99;
  int e = -99;
  int f = -99;
  int g = -99;
  int h = -99;
  int i = -99;
  int j = -99;
  
  void a()
  {
    a(-101, this.b, this.c, this.jdField_a_of_type_Boolean, -101, -101, -101, -101, -101, -101);
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    int k = this.j;
    long l = k;
    if (paramInt1 <= -99) {
      this.j = 0;
    } else {
      this.j = (k + 1);
    }
    if ((this.jdField_a_of_type_Int != paramInt1) || (this.b != paramInt2) || (this.c != paramInt3) || (this.jdField_a_of_type_Boolean != paramBoolean) || (this.d != paramInt4) || (this.e != paramInt5) || (this.f != paramInt6) || (this.g != paramInt7) || (this.h != paramInt8) || (this.i != paramInt9))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PREVIEW_CALLBACK, Index[");
      localStringBuilder.append(l);
      localStringBuilder.append("->");
      localStringBuilder.append(this.j);
      localStringBuilder.append("], degree[");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("], mCurCamera[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("], nInFPS[");
      localStringBuilder.append(this.c);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append("], mSupportLandscape[");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      localStringBuilder.append("->");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], cameraImageOrientation[");
      localStringBuilder.append(this.d);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt4);
      localStringBuilder.append("], displayRotation[");
      localStringBuilder.append(this.e);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt5);
      localStringBuilder.append("], mobileRotation[");
      localStringBuilder.append(this.f);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt6);
      localStringBuilder.append("], dataLength[");
      localStringBuilder.append(this.g);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt7);
      localStringBuilder.append("], w[");
      localStringBuilder.append(this.h);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt8);
      localStringBuilder.append("], h[");
      localStringBuilder.append(this.i);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt9);
      localStringBuilder.append("]");
      QLog.w("PreviewCallbackInfo", 1, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.d = paramInt4;
    this.e = paramInt5;
    this.f = paramInt6;
    this.g = paramInt7;
    this.h = paramInt8;
    this.i = paramInt9;
  }
  
  void b()
  {
    a(-100, this.b, this.c, this.jdField_a_of_type_Boolean, -100, -100, -100, -100, -100, -100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.camera.PreviewCallbackInfo
 * JD-Core Version:    0.7.0.1
 */