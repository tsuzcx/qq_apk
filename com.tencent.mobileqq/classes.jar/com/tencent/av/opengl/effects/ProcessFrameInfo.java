package com.tencent.av.opengl.effects;

import com.tencent.qphone.base.util.QLog;

public class ProcessFrameInfo
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  boolean jdField_a_of_type_Boolean = false;
  int b = 0;
  int c = 0;
  int d = 0;
  
  void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, boolean paramBoolean, long paramLong2)
  {
    if (paramArrayOfByte != null)
    {
      int i = this.jdField_a_of_type_Int;
      if (i != 0)
      {
        int j = this.b;
        if ((j != 0) && (i == paramInt1) && (j == paramInt2) && (this.c == paramInt3) && (this.d == paramInt4) && (this.jdField_a_of_type_Long == paramLong1) && (this.jdField_a_of_type_Boolean == paramBoolean)) {
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
      localStringBuilder.append(this.jdField_a_of_type_Int);
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
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append("->");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("], isFront[");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      localStringBuilder.append("->");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.d("ProcessFrameInfo", 1, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.ProcessFrameInfo
 * JD-Core Version:    0.7.0.1
 */