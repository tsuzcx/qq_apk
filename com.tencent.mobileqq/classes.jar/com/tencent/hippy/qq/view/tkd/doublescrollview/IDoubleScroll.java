package com.tencent.hippy.qq.view.tkd.doublescrollview;

public abstract interface IDoubleScroll
{
  public abstract int getLayoutHeight();
  
  public abstract int getNestViewScrollY();
  
  public abstract int getRealHeight();
  
  public abstract void notifyNestViewToFling(int paramInt1, int paramInt2);
  
  public abstract void scrollNestViewBy(int paramInt1, int paramInt2);
  
  public abstract void scrollNestViewTo(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.doublescrollview.IDoubleScroll
 * JD-Core Version:    0.7.0.1
 */