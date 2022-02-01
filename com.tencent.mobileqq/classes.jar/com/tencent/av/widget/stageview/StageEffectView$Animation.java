package com.tencent.av.widget.stageview;

import android.os.SystemClock;

class StageEffectView$Animation
{
  final int jdField_a_of_type_Int;
  final long jdField_a_of_type_Long;
  final boolean jdField_a_of_type_Boolean;
  int[] jdField_a_of_type_ArrayOfInt;
  final int b;
  final int c;
  int d;
  int e;
  
  private StageEffectView$Animation(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.b = MathUtils.a(paramInt1, 20000);
    this.c = paramInt2;
    this.jdField_a_of_type_Long = (SystemClock.uptimeMillis() + paramInt4);
    this.e = paramInt1;
    paramInt1 = MathUtils.a(paramInt1, this.c, 20000, true);
    if (paramInt1 > 10000) {
      this.d = (20000 - paramInt1);
    }
    for (this.jdField_a_of_type_Boolean = false; paramInt3 == -1; this.jdField_a_of_type_Boolean = true)
    {
      this.jdField_a_of_type_Int = ((int)(0.1F * this.d));
      return;
      this.d = paramInt1;
    }
    this.jdField_a_of_type_Int = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.widget.stageview.StageEffectView.Animation
 * JD-Core Version:    0.7.0.1
 */