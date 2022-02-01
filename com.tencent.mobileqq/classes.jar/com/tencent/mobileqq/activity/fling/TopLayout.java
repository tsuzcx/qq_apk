package com.tencent.mobileqq.activity.fling;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class TopLayout
  extends RelativeLayout
  implements TopContentLayout.OnOutScreenListener
{
  private static final String TAG = "TopLayout";
  private TopBehindLayout mBehindView;
  private boolean mConfigChanged;
  private TopContentLayout mContentView;
  private TopLayout.OnDraggingListener mListener;
  
  public TopLayout(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public TopLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TopLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.mBehindView = new TopBehindLayout(paramContext);
    addView(this.mBehindView, localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.mContentView = new TopContentLayout(paramContext);
    this.mContentView.setOnOutScreenListener(this);
    addView(this.mContentView, localLayoutParams);
  }
  
  private void scaleView(View paramView, float paramFloat)
  {
    int i = getWidth();
    int j = getHeight();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.width = ((int)(i * paramFloat));
    localLayoutParams.height = ((int)(j * paramFloat));
    localLayoutParams.leftMargin = ((i - localLayoutParams.width) / 2);
    localLayoutParams.topMargin = ((j - localLayoutParams.height) / 2);
    paramView.setLayoutParams(localLayoutParams);
  }
  
  public TopLayout.OnDraggingListener getOnDraggingListener()
  {
    return this.mListener;
  }
  
  public void onConfigChanged(Configuration paramConfiguration) {}
  
  public void outing(int paramInt1, int paramInt2, View paramView)
  {
    paramInt2 = getContext().getResources().getDisplayMetrics().widthPixels;
    paramView = this.mBehindView;
    if (paramView != null)
    {
      float f1 = Math.abs(paramInt1 / paramInt2);
      float f2 = 0.05000001F * f1 + 0.95F;
      if (f2 < 1.0F) {
        paramView.setForeground(new ColorDrawable((int)((1.0F - f1) * 128.0F) << 24));
      }
      scaleView(paramView, f2);
    }
    if (Math.abs(paramInt1) >= paramInt2)
    {
      paramView = this.mListener;
      if (paramView != null) {
        paramView.endDrag();
      }
    }
    else if (paramInt1 == 0)
    {
      paramView = this.mListener;
      if (paramView != null) {
        paramView.cancelDrag();
      }
    }
  }
  
  public void setBehind(View paramView)
  {
    this.mBehindView.setContent(paramView);
  }
  
  public void setContent(ContentWrapView paramContentWrapView)
  {
    this.mContentView.setContent(paramContentWrapView);
  }
  
  public void setOnDraggingListener(TopLayout.OnDraggingListener paramOnDraggingListener)
  {
    this.mListener = paramOnDraggingListener;
  }
  
  public void startDrag()
  {
    TopLayout.OnDraggingListener localOnDraggingListener = this.mListener;
    if (localOnDraggingListener != null) {
      localOnDraggingListener.startDrag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.TopLayout
 * JD-Core Version:    0.7.0.1
 */