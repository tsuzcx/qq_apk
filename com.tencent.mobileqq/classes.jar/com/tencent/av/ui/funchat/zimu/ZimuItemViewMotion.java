package com.tencent.av.ui.funchat.zimu;

import android.content.Context;
import com.tencent.av.business.handler.SentenceInfo;
import java.lang.ref.WeakReference;

public abstract class ZimuItemViewMotion
  extends ZimuItemView
{
  public ZimuItemViewMotion(Context paramContext, WeakReference<ZimuView> paramWeakReference, int paramInt1, int paramInt2, float paramFloat)
  {
    super(paramContext, paramWeakReference, paramInt1, paramInt2, paramFloat);
  }
  
  protected abstract int a(int paramInt);
  
  public int a(long paramLong)
  {
    int i = 0;
    if (a())
    {
      i = b(paramLong);
      this.e -= i;
    }
    return i;
  }
  
  public void a(long paramLong)
  {
    super.a(paramLong);
    this.e = (b(paramLong) + this.e);
  }
  
  public boolean a()
  {
    return this.e + c() > 0;
  }
  
  protected int b(long paramLong)
  {
    return (int)(a(this.jdField_a_of_type_ComTencentAvBusinessHandlerSentenceInfo.a.length()) * paramLong / 1000L);
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.e + c() < 0)) {
      this.e = this.g;
    }
  }
  
  public boolean c()
  {
    return (this.e + c() > 0) && (this.e < this.g) && (this.f + d() > 0) && (this.f < this.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuItemViewMotion
 * JD-Core Version:    0.7.0.1
 */