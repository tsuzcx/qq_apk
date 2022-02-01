package com.tencent.av.opengl.effects;

import com.tencent.qphone.base.util.QLog;

public class ProcessFrameInfo
{
  int a = 0;
  int b = 0;
  int c = 0;
  int d = 0;
  long e = 0L;
  boolean f = false;
  
  void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, boolean paramBoolean, long paramLong2)
  {
    if (paramArrayOfByte != null)
    {
      int i = this.a;
      if (i != 0)
      {
        int j = this.b;
        if ((j != 0) && (i == paramInt1) && (j == paramInt2) && (this.c == paramInt3) && (this.d == paramInt4) && (this.e == paramLong1) && (this.f == paramBoolean)) {
          return;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onProcessFrame, data[");
      boolean bool;
      if (paramArrayOfByte != null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      localStringBuilder.append("], frameIndex[");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append("], width[");
      localStringBuilder.append(this.a);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("], height[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("], format[");
      localStringBuilder.append(this.c);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append("], angle[");
      localStringBuilder.append(this.d);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt4);
      localStringBuilder.append("], FPS[");
      localStringBuilder.append(this.e);
      localStringBuilder.append("->");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("], isFront[");
      localStringBuilder.append(this.f);
      localStringBuilder.append("->");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.d("ProcessFrameInfo", 1, localStringBuilder.toString());
    }
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramLong1;
    this.f = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.ProcessFrameInfo
 * JD-Core Version:    0.7.0.1
 */