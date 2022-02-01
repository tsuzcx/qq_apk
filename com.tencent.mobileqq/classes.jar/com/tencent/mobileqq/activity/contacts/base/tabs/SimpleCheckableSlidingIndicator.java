package com.tencent.mobileqq.activity.contacts.base.tabs;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler.Callback;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.util.MqqWeakReferenceHandler;

public class SimpleCheckableSlidingIndicator
  extends SimpleSlidingIndicator
{
  public static int a;
  public static int b = 1;
  public static int c = 2;
  static int d = 1;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new SimpleCheckableSlidingIndicator.2(this);
  SimpleCheckableSlidingIndicator.OnRepeatClickListener jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleCheckableSlidingIndicator$OnRepeatClickListener;
  private SimpleCheckableSlidingIndicator.ScrollViewListener jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleCheckableSlidingIndicator$ScrollViewListener;
  private MqqWeakReferenceHandler jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler;
  private int i = -9999999;
  private int j = jdField_a_of_type_Int;
  
  static
  {
    jdField_a_of_type_Int = 0;
  }
  
  public SimpleCheckableSlidingIndicator(Context paramContext)
  {
    super(paramContext);
  }
  
  public SimpleCheckableSlidingIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SimpleCheckableSlidingIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void a()
  {
    if (this.f != this.e)
    {
      Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.f);
      View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.e);
      if ((localObject != null) && (localView != null))
      {
        localObject = ValueAnimator.ofInt(new int[] { ((View)localObject).getLeft(), localView.getLeft() });
        ((ValueAnimator)localObject).setDuration(200L);
        ((ValueAnimator)localObject).addUpdateListener(new SimpleCheckableSlidingIndicator.1(this));
        ((ValueAnimator)localObject).start();
      }
      while (localView == null) {
        return;
      }
      this.h = localView.getLeft();
      invalidate();
      return;
    }
    this.h = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.e).getLeft();
    invalidate();
  }
  
  protected void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.e != paramInt)
    {
      this.f = this.e;
      this.e = paramInt;
      b(paramInt);
      c(this.e);
      if (paramBoolean1)
      {
        a();
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator$OnTabListener != null) && (paramInt >= 0)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator$OnTabListener.a(paramInt, paramBoolean2);
        }
      }
    }
    while ((this.e != paramInt) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleCheckableSlidingIndicator$OnRepeatClickListener == null) || (paramInt < 0)) {
      for (;;)
      {
        return;
        View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.e);
        if (localView != null) {
          this.h = localView.getLeft();
        }
        invalidate();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleCheckableSlidingIndicator$OnRepeatClickListener.a(paramInt);
  }
  
  public int[] a()
  {
    return this.jdField_a_of_type_ArrayOfInt;
  }
  
  public String[] a()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.j = b;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleCheckableSlidingIndicator$ScrollViewListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleCheckableSlidingIndicator$ScrollViewListener.a(this.j);
      }
      if (this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler != null)
      {
        this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(d);
        continue;
        if (this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler != null) {
          this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessage(d);
        }
      }
    }
  }
  
  public void setOnRepeatClickListener(SimpleCheckableSlidingIndicator.OnRepeatClickListener paramOnRepeatClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleCheckableSlidingIndicator$OnRepeatClickListener = paramOnRepeatClickListener;
  }
  
  public void setScrollViewListener(SimpleCheckableSlidingIndicator.ScrollViewListener paramScrollViewListener)
  {
    if (this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler == null) {
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(this.jdField_a_of_type_AndroidOsHandler$Callback);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleCheckableSlidingIndicator$ScrollViewListener = paramScrollViewListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.tabs.SimpleCheckableSlidingIndicator
 * JD-Core Version:    0.7.0.1
 */