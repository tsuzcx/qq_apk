package com.tencent.biz.pubaccount;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.widget.BounceScrollView;

public class AccountDetailBounceScrollView
  extends BounceScrollView
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean = true;
  
  public AccountDetailBounceScrollView(Context paramContext)
  {
    super(paramContext);
    AccessibilityUtil.a(this, false);
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Int = ((int)(320.0F * this.jdField_a_of_type_Float));
    this.jdField_b_of_type_Int = 0;
  }
  
  public AccountDetailBounceScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Int = ((int)(320.0F * this.jdField_a_of_type_Float));
    this.jdField_b_of_type_Int = 0;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void fling(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    super.fling(paramInt);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      this.jdField_a_of_type_Boolean = false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean) {
      return super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, this.jdField_b_of_type_Int, paramInt7, this.jdField_a_of_type_Int, paramBoolean);
    }
    return super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, 0, paramBoolean);
  }
  
  public void setMaxOverScrollY(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setUseBounce(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetailBounceScrollView
 * JD-Core Version:    0.7.0.1
 */