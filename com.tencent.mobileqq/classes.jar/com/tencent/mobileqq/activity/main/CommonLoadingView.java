package com.tencent.mobileqq.activity.main;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class CommonLoadingView
  extends FrameLayout
{
  private CommonLoadingView.OnFirstDrawListener jdField_a_of_type_ComTencentMobileqqActivityMainCommonLoadingView$OnFirstDrawListener;
  private boolean jdField_a_of_type_Boolean = true;
  
  public CommonLoadingView(Context paramContext)
  {
    super(paramContext);
  }
  
  public CommonLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CommonLoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityMainCommonLoadingView$OnFirstDrawListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityMainCommonLoadingView$OnFirstDrawListener.d();
      }
    }
  }
  
  public void setOnFirstDrawListener(CommonLoadingView.OnFirstDrawListener paramOnFirstDrawListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityMainCommonLoadingView$OnFirstDrawListener = paramOnFirstDrawListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.CommonLoadingView
 * JD-Core Version:    0.7.0.1
 */