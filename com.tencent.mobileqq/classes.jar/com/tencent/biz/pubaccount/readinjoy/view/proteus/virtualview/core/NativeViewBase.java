package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.view.View;

public class NativeViewBase
  extends ViewBase
{
  protected View __mNative;
  
  public NativeViewBase(VafContext paramVafContext)
  {
    super(paramVafContext);
  }
  
  public int getComMeasuredHeight()
  {
    if ((this.__mNative instanceof IView)) {
      return ((IView)this.__mNative).getComMeasuredHeight();
    }
    return this.__mNative.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    if ((this.__mNative instanceof IView)) {
      return ((IView)this.__mNative).getComMeasuredWidth();
    }
    return this.__mNative.getMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.__mNative;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.__mNative instanceof IView)) {
      ((IView)this.__mNative).onComLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    if ((this.mAutoDimDirection <= 0) || ((this.__mNative instanceof IView))) {
      ((IView)this.__mNative).onComMeasure(paramInt1, paramInt2);
    }
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
  }
  
  public void reset()
  {
    super.reset();
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.__mNative.setBackground(null);
      return;
    }
    this.__mNative.setBackgroundDrawable(null);
  }
  
  protected void setBackgroundColor(int paramInt)
  {
    this.__mNative.setBackgroundColor(paramInt);
  }
  
  protected void setBackgroundImage(Bitmap paramBitmap)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.__mNative.setBackground(new BitmapDrawable(this.mContext.getContext().getResources(), paramBitmap));
      return;
    }
    this.__mNative.setBackgroundDrawable(new BitmapDrawable(this.mContext.getContext().getResources(), paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.NativeViewBase
 * JD-Core Version:    0.7.0.1
 */