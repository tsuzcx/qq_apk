package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.helper.nativelayout;

import android.graphics.Canvas;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.RelativeLayout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtils;

public class NativeRelativeLayout
  extends RelativeLayout
{
  private static final String TAG = "NativeRelativeLayout";
  protected NativeLayoutImpl mNative;
  
  public NativeRelativeLayout(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.mNative = new NativeLayoutImpl(paramVafContext.getContext());
    this.mNative.setVirtualView(this);
  }
  
  public void addView(ViewBase paramViewBase)
  {
    if (LogUtils.shouldLog())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[addView] for ");
      localStringBuilder.append(this.mName);
      LogUtils.d("NativeRelativeLayout", localStringBuilder.toString());
    }
    super.addView(paramViewBase);
    this.mNative.attachViews(paramViewBase);
    if (LogUtils.shouldLog())
    {
      paramViewBase = new StringBuilder();
      paramViewBase.append("[addView] native child count: ");
      paramViewBase.append(this.mNative.getChildCount());
      LogUtils.d("NativeRelativeLayout", paramViewBase.toString());
    }
  }
  
  public RelativeLayout.Params generateParams()
  {
    return new RelativeLayout.Params();
  }
  
  public View getNativeView()
  {
    return this.mNative;
  }
  
  protected void onComDraw(Canvas paramCanvas)
  {
    if (this.mGradientColorBg != null) {
      setBackgroundColor(this.mGradientColorBg);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.helper.nativelayout.NativeRelativeLayout
 * JD-Core Version:    0.7.0.1
 */