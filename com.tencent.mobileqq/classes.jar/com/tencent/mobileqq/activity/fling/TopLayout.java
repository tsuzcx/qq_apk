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
  private TopBehindLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopBehindLayout;
  private TopContentLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopContentLayout;
  private TopLayout.OnDraggingListener jdField_a_of_type_ComTencentMobileqqActivityFlingTopLayout$OnDraggingListener;
  
  public TopLayout(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public TopLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TopLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopBehindLayout = new TopBehindLayout(paramContext);
    addView(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopBehindLayout, localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopContentLayout = new TopContentLayout(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopContentLayout.setOnOutScreenListener(this);
    addView(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopContentLayout, localLayoutParams);
  }
  
  private void a(View paramView, float paramFloat)
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
    return this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopLayout$OnDraggingListener;
  }
  
  public void onConfigChanged(Configuration paramConfiguration) {}
  
  public void outing(int paramInt1, int paramInt2, View paramView)
  {
    paramInt2 = getContext().getResources().getDisplayMetrics().widthPixels;
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopBehindLayout;
    if (paramView != null)
    {
      float f1 = Math.abs(paramInt1 / paramInt2);
      float f2 = 0.05000001F * f1 + 0.95F;
      if (f2 < 1.0F) {
        paramView.setForeground(new ColorDrawable((int)((1.0F - f1) * 128.0F) << 24));
      }
      a(paramView, f2);
    }
    if (Math.abs(paramInt1) >= paramInt2)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopLayout$OnDraggingListener;
      if (paramView != null) {
        paramView.endDrag();
      }
    }
    else if (paramInt1 == 0)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopLayout$OnDraggingListener;
      if (paramView != null) {
        paramView.cancelDrag();
      }
    }
  }
  
  public void setBehind(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopBehindLayout.setContent(paramView);
  }
  
  public void setContent(ContentWrapView paramContentWrapView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopContentLayout.setContent(paramContentWrapView);
  }
  
  public void setOnDraggingListener(TopLayout.OnDraggingListener paramOnDraggingListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopLayout$OnDraggingListener = paramOnDraggingListener;
  }
  
  public void startDrag()
  {
    TopLayout.OnDraggingListener localOnDraggingListener = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopLayout$OnDraggingListener;
    if (localOnDraggingListener != null) {
      localOnDraggingListener.startDrag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.TopLayout
 * JD-Core Version:    0.7.0.1
 */