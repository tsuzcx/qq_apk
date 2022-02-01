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
    if (a())
    {
      int i = c(paramLong);
      this.h -= i;
      return i;
    }
    return 0;
  }
  
  public boolean a()
  {
    return this.h + h() > 0;
  }
  
  public void b(long paramLong)
  {
    super.b(paramLong);
    int i = c(paramLong);
    this.h += i;
  }
  
  protected int c(long paramLong)
  {
    return (int)(a(this.l.b.length()) * paramLong / 1000L);
  }
  
  public void e()
  {
    if ((this.e) && (this.h + h() < 0)) {
      this.h = this.j;
    }
  }
  
  public boolean j()
  {
    return (this.h + h() > 0) && (this.h < this.j) && (this.i + i() > 0) && (this.i < this.k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuItemViewMotion
 * JD-Core Version:    0.7.0.1
 */