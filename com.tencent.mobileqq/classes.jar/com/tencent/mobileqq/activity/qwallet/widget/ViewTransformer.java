package com.tencent.mobileqq.activity.qwallet.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import java.util.ArrayList;

public class ViewTransformer
  extends ViewGroup
  implements Animation.AnimationListener
{
  Animation anim;
  private ViewTransformer.ViewTransformerListener lisener;
  private Context mContext;
  private View mHeadView;
  private View mSubView;
  private ArrayList mViews;
  
  public ViewTransformer(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public ViewTransformer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public ViewTransformer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  protected ViewTransformer.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewTransformer.LayoutParams(-1, -2);
  }
  
  public ViewTransformer.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ViewTransformer.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewTransformer.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new ViewTransformer.LayoutParams(paramLayoutParams);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.mHeadView != null) {
      this.mHeadView.setVisibility(8);
    }
    paramAnimation = this.mHeadView;
    this.mHeadView = this.mSubView;
    this.mSubView = paramAnimation;
    if ((getChildCount() > 1) && (this.mHeadView != null) && (this.mSubView != null))
    {
      removeAllViews();
      addView(this.mHeadView, 0);
      addView(this.mSubView, 1);
      requestLayout();
      if (this.lisener != null) {
        this.lisener.OnTransferFinished();
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.mSubView.setVisibility(0);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = getChildCount();
    paramInt1 = 0;
    paramInt2 = 0;
    while (paramInt1 < paramInt3)
    {
      View localView = getChildAt(paramInt1);
      int j = localView.getMeasuredWidth();
      paramInt4 = localView.getMeasuredHeight();
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
      int i = localMarginLayoutParams.leftMargin + paramInt2;
      paramInt2 = i + j + localMarginLayoutParams.rightMargin;
      j = localMarginLayoutParams.topMargin;
      localView.layout(i, j, paramInt2, localMarginLayoutParams.bottomMargin + (paramInt4 + j));
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i1 = getChildCount();
    int m = 0;
    int i = 0;
    int j = 0;
    View localView;
    if (m < i1)
    {
      localView = getChildAt(m);
      if (localView.getVisibility() == 8) {
        break label121;
      }
    }
    for (;;)
    {
      try
      {
        measureChildWithMargins(localView, paramInt1, 0, paramInt2, 0);
        int i2 = localView.getMeasuredWidth();
        int n = localView.getMeasuredHeight();
        k = n;
        if (i > n) {
          k = i;
        }
        i = j + i2;
        m += 1;
        j = i;
        i = k;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      setMeasuredDimension(j, paramInt2);
      return;
      label121:
      int k = i;
      i = j;
    }
  }
  
  public void setLisenter(ViewTransformer.ViewTransformerListener paramViewTransformerListener)
  {
    this.lisener = paramViewTransformerListener;
  }
  
  public void startTransform()
  {
    double d = getWidth();
    int i = getChildCount();
    if (i == 1) {
      this.mHeadView = getChildAt(0);
    }
    if (i > 1)
    {
      this.mHeadView = getChildAt(0);
      this.mSubView = getChildAt(1);
    }
    this.anim = AnimationUtils.loadAnimation(this.mContext, 2131034297);
    this.anim.setAnimationListener(this);
    setAnimation(this.anim);
    startAnimation(this.anim);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.widget.ViewTransformer
 * JD-Core Version:    0.7.0.1
 */