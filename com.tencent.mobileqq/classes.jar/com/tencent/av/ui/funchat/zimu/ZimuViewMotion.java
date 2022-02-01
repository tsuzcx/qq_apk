package com.tencent.av.ui.funchat.zimu;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import com.tencent.av.app.VideoAppInterface;

public abstract class ZimuViewMotion
  extends ZimuView
{
  int j = 92;
  final int k = 4;
  long l;
  Handler m = new ZimuViewMotion.MyHandler(this);
  
  public ZimuViewMotion(long paramLong, VideoAppInterface paramVideoAppInterface, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramLong, paramVideoAppInterface, paramContext, paramAttributeSet);
  }
  
  protected int a(int paramInt1, int paramInt2)
  {
    int n = getViewHeight();
    int i = (this.j - paramInt2) / 2 + paramInt1;
    if (i < 0) {
      return 0;
    }
    if (paramInt1 + paramInt2 > n) {
      i = n - paramInt2;
    }
    return i;
  }
  
  public void b()
  {
    float f = this.g;
    this.j = ((int)(this.j * (f * 0.48F)));
    super.b();
  }
  
  void d()
  {
    e();
  }
  
  public int getViewHeight()
  {
    return this.j * 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuViewMotion
 * JD-Core Version:    0.7.0.1
 */