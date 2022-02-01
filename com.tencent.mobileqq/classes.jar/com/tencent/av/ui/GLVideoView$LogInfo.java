package com.tencent.av.ui;

import com.tencent.qphone.base.util.QLog;

class GLVideoView$LogInfo
{
  boolean a = false;
  boolean b = false;
  boolean c = false;
  boolean d = false;
  int e = 0;
  int f = 0;
  int g = 0;
  int h = 0;
  int i = 0;
  int j = 0;
  int k = 0;
  int l = 0;
  int m = 0;
  int n = 0;
  int o;
  int p;
  int q = 0;
  int r = 0;
  int s = 0;
  
  void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, float paramFloat1, float paramFloat2, int paramInt11, int paramInt12, int paramInt13, int paramInt14, int paramInt15)
  {
    if (!QLog.isColorLevel()) {
      return;
    }
    if ((this.c == paramBoolean3) && (this.d == paramBoolean4) && (this.a == paramBoolean1) && (this.b == paramBoolean2) && (this.e == paramInt1) && (this.f == paramInt2) && (this.g == paramInt3) && (this.h == paramInt4) && (this.i == paramInt5) && (this.j == paramInt6) && (this.k == paramInt7) && (this.l == paramInt8) && (this.m == paramInt9) && (this.n == paramInt10) && (this.o == paramInt11) && (this.p == paramInt12) && (this.q == paramInt13)) {
      if (this.r == paramInt14) {
        return;
      }
    }
    this.a = paramBoolean1;
    this.b = paramBoolean2;
    this.c = paramBoolean3;
    this.d = paramBoolean4;
    this.e = paramInt1;
    this.f = paramInt2;
    this.g = paramInt3;
    this.h = paramInt4;
    this.i = paramInt5;
    this.j = paramInt6;
    this.k = paramInt7;
    this.l = paramInt8;
    this.m = paramInt9;
    this.n = paramInt10;
    this.o = paramInt11;
    this.p = paramInt12;
    this.q = paramInt13;
    this.r = paramInt14;
    this.s = paramInt15;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("rendView, self[");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append("], mirror[");
    localStringBuilder.append(paramBoolean2);
    localStringBuilder.append("], bForceGround[");
    localStringBuilder.append(paramBoolean3);
    localStringBuilder.append("], pt[");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("], dst[");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramInt4);
    localStringBuilder.append("], src[");
    localStringBuilder.append(paramInt5);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramInt6);
    localStringBuilder.append("], t1[");
    localStringBuilder.append(paramInt7);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramInt8);
    localStringBuilder.append("], t2[");
    localStringBuilder.append(paramInt9);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramInt10);
    localStringBuilder.append("], sR[");
    localStringBuilder.append(paramFloat1);
    localStringBuilder.append("], tR[");
    localStringBuilder.append(paramFloat2);
    localStringBuilder.append("], border[");
    localStringBuilder.append(paramBoolean4);
    localStringBuilder.append("], sAngle[");
    localStringBuilder.append(paramInt11);
    localStringBuilder.append("], yuvAngle[");
    localStringBuilder.append(paramInt12);
    localStringBuilder.append("], mRotation[");
    localStringBuilder.append(paramInt13);
    localStringBuilder.append("], rotation[");
    localStringBuilder.append(paramInt14);
    localStringBuilder.append("], scaleType[");
    localStringBuilder.append(paramInt15);
    localStringBuilder.append("]");
    QLog.w(paramString, 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.GLVideoView.LogInfo
 * JD-Core Version:    0.7.0.1
 */