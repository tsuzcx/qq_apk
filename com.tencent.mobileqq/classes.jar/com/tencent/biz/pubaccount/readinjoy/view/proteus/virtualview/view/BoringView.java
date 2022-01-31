package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;

public class BoringView
  extends ViewBase
{
  private BoringView.BoringViewImpl mNative;
  
  public BoringView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.mNative = new BoringView.BoringViewImpl(paramVafContext.getContext());
  }
  
  public int getComMeasuredHeight()
  {
    return this.mNative.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.mNative.getMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.mNative;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mNative.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.mNative.measure(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.mNative.setBorderColor(this.mBorderColor);
    this.mNative.setBorderWidth(this.mBorderWidth);
    this.mNative.setBorderTopLeftRadius(this.mBorderTopLeftRadius);
    this.mNative.setBorderTopRightRadius(this.mBorderTopRightRadius);
    this.mNative.setBorderBottomLeftRadius(this.mBorderBottomLeftRadius);
    this.mNative.setBorderBottomRightRadius(this.mBorderBottomRightRadius);
    this.mNative.setBackgroundColor(this.mBackground);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.BoringView
 * JD-Core Version:    0.7.0.1
 */