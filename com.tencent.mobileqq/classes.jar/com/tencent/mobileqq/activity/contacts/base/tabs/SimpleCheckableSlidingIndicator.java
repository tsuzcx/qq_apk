package com.tencent.mobileqq.activity.contacts.base.tabs;

import ajtm;
import ajtn;
import ajto;
import ajtp;
import ajtv;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler.Callback;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import blha;

public class SimpleCheckableSlidingIndicator
  extends SimpleSlidingIndicator
{
  public static int a;
  public static int b = 1;
  public static int c = 2;
  public static int d = 1;
  ajto jdField_a_of_type_Ajto;
  private ajtp jdField_a_of_type_Ajtp;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new ajtn(this);
  private blha jdField_a_of_type_Blha;
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
        ((ValueAnimator)localObject).addUpdateListener(new ajtm(this));
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
        if ((this.jdField_a_of_type_Ajtv != null) && (paramInt >= 0)) {
          this.jdField_a_of_type_Ajtv.a(paramInt, paramBoolean2);
        }
      }
    }
    while ((this.e != paramInt) || (this.jdField_a_of_type_Ajto == null) || (paramInt < 0)) {
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
    this.jdField_a_of_type_Ajto.a(paramInt);
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
      if (this.jdField_a_of_type_Ajtp != null) {
        this.jdField_a_of_type_Ajtp.a(this.j);
      }
      if (this.jdField_a_of_type_Blha != null)
      {
        this.jdField_a_of_type_Blha.removeMessages(d);
        continue;
        if (this.jdField_a_of_type_Blha != null) {
          this.jdField_a_of_type_Blha.sendEmptyMessage(d);
        }
      }
    }
  }
  
  public void setOnRepeatClickListener(ajto paramajto)
  {
    this.jdField_a_of_type_Ajto = paramajto;
  }
  
  public void setScrollViewListener(ajtp paramajtp)
  {
    if (this.jdField_a_of_type_Blha == null) {
      this.jdField_a_of_type_Blha = new blha(this.jdField_a_of_type_AndroidOsHandler$Callback);
    }
    this.jdField_a_of_type_Ajtp = paramajtp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.tabs.SimpleCheckableSlidingIndicator
 * JD-Core Version:    0.7.0.1
 */