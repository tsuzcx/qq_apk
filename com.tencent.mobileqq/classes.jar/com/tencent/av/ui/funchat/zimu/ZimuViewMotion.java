package com.tencent.av.ui.funchat.zimu;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import com.tencent.av.app.VideoAppInterface;

public abstract class ZimuViewMotion
  extends ZimuView
{
  Handler a;
  int jdField_c_of_type_Int;
  long jdField_c_of_type_Long;
  final int d = 4;
  
  public ZimuViewMotion(long paramLong, VideoAppInterface paramVideoAppInterface, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramLong, paramVideoAppInterface, paramContext, paramAttributeSet);
    this.c = 92;
    this.jdField_a_of_type_AndroidOsHandler = new ZimuViewMotion.MyHandler(this);
  }
  
  public int a()
  {
    return this.c * 4;
  }
  
  protected int a(int paramInt1, int paramInt2)
  {
    int j = a();
    int i = (this.c - paramInt2) / 2 + paramInt1;
    if (i < 0) {
      return 0;
    }
    if (paramInt1 + paramInt2 > j) {
      i = j - paramInt2;
    }
    return i;
  }
  
  public void b()
  {
    float f = this.jdField_a_of_type_Float;
    this.c = ((int)(this.c * (f * 0.48F)));
    super.b();
  }
  
  void d()
  {
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuViewMotion
 * JD-Core Version:    0.7.0.1
 */