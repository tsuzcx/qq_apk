package com.tencent.mobileqq.activity.contacts.view;

import ahqq;
import ahqr;
import ahqs;
import ahqt;
import ahqz;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler.Callback;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import bhoe;

public class SimpleCheckableSlidingIndicator
  extends SimpleSlidingIndicator
{
  public static int a;
  public static int b = 1;
  public static int c = 2;
  public static int d = 1;
  private ahqs jdField_a_of_type_Ahqs;
  ahqt jdField_a_of_type_Ahqt;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new ahqr(this);
  private bhoe jdField_a_of_type_Bhoe;
  private int i = -9999999;
  private int j = jdField_a_of_type_Int;
  
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
        ((ValueAnimator)localObject).addUpdateListener(new ahqq(this));
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
        if ((this.jdField_a_of_type_Ahqz != null) && (paramInt >= 0)) {
          this.jdField_a_of_type_Ahqz.a(paramInt, paramBoolean2);
        }
      }
    }
    while ((this.e != paramInt) || (this.jdField_a_of_type_Ahqt == null) || (paramInt < 0)) {
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
    this.jdField_a_of_type_Ahqt.a(paramInt);
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
      if (this.jdField_a_of_type_Ahqs != null) {
        this.jdField_a_of_type_Ahqs.a(this.j);
      }
      if (this.jdField_a_of_type_Bhoe != null)
      {
        this.jdField_a_of_type_Bhoe.removeMessages(d);
        continue;
        if (this.jdField_a_of_type_Bhoe != null) {
          this.jdField_a_of_type_Bhoe.sendEmptyMessage(d);
        }
      }
    }
  }
  
  public void setOnRepeatClickListener(ahqt paramahqt)
  {
    this.jdField_a_of_type_Ahqt = paramahqt;
  }
  
  public void setScrollViewListener(ahqs paramahqs)
  {
    if (this.jdField_a_of_type_Bhoe == null) {
      this.jdField_a_of_type_Bhoe = new bhoe(this.jdField_a_of_type_AndroidOsHandler$Callback);
    }
    this.jdField_a_of_type_Ahqs = paramahqs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.view.SimpleCheckableSlidingIndicator
 * JD-Core Version:    0.7.0.1
 */