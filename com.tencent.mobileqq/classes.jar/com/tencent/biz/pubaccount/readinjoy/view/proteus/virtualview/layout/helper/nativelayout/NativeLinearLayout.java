package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.helper.nativelayout;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.LinearLayout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtils;

public class NativeLinearLayout
  extends LinearLayout
{
  private static final String TAG = "NativeLinearLayout";
  protected NativeLayoutImpl mNative;
  
  public NativeLinearLayout(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.mNative = new NativeLayoutImpl(paramVafContext.getContext());
    this.mNative.setVirtualView(this);
  }
  
  public void addView(ViewBase paramViewBase)
  {
    if (LogUtils.shouldLog()) {
      LogUtils.d("NativeLinearLayout", "[addView] for " + this.mName);
    }
    super.addView(paramViewBase);
    this.mNative.attachViews(paramViewBase);
    if (LogUtils.shouldLog()) {
      LogUtils.d("NativeLinearLayout", "[addView] native child count: " + this.mNative.getChildCount());
    }
  }
  
  public LinearLayout.Params generateParams()
  {
    return new LinearLayout.Params();
  }
  
  public View getNativeView()
  {
    return this.mNative;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onComLayout(paramBoolean, 0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
    this.mNative.comLayout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    super.onComMeasure(paramInt1, paramInt2);
    this.mNative.measureComponent(this.mMeasuredWidth, this.mMeasuredHeight);
  }
  
  public void onParseValueFinished()
  {
    this.mNative.setBorderColor(this.mBorderColor);
    this.mNative.setBorderWidth(this.mBorderWidth);
    this.mNative.setBorderTopLeftRadius(this.mBorderTopLeftRadius);
    this.mNative.setBorderTopRightRadius(this.mBorderTopRightRadius);
    this.mNative.setBorderBottomLeftRadius(this.mBorderBottomLeftRadius);
    this.mNative.setBorderBottomRightRadius(this.mBorderBottomRightRadius);
    this.mNative.setBackgroundColor(this.mBackground);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.helper.nativelayout.NativeLinearLayout
 * JD-Core Version:    0.7.0.1
 */