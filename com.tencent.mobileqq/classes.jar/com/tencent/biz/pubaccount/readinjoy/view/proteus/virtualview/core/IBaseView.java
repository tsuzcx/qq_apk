package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core;

public abstract interface IBaseView
{
  public abstract int getComMeasuredHeight();
  
  public abstract int getComMeasuredWidth();
  
  public abstract void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void onComMeasure(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IBaseView
 * JD-Core Version:    0.7.0.1
 */