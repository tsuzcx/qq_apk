package com.tencent.mobileqq.avatar.dynamicavatar.videodrawable;

import ajyc;
import alzp;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class DrawableSeekbar
  extends LinearLayout
  implements View.OnTouchListener
{
  int jdField_a_of_type_Int;
  alzp jdField_a_of_type_Alzp;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  boolean jdField_a_of_type_Boolean = false;
  int b;
  int c;
  int d;
  int e;
  int f;
  int g;
  int h;
  
  public DrawableSeekbar(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public DrawableSeekbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.h = ((int)(2.0F * getResources().getDisplayMetrics().density));
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetImageView.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(ajyc.a(2131703527));
  }
  
  private void b()
  {
    if (this.g != 0)
    {
      int j = this.g;
      i = j;
      if (this.jdField_a_of_type_AndroidWidgetImageView.getWidth() + j > getWidth()) {
        i = getWidth() - this.jdField_a_of_type_AndroidWidgetImageView.getWidth();
      }
      this.jdField_a_of_type_AndroidWidgetImageView.layout(i, 0, this.jdField_a_of_type_AndroidWidgetImageView.getMeasuredWidth() + i, this.jdField_a_of_type_AndroidWidgetImageView.getMeasuredHeight());
      return;
    }
    if ((this.d == 0) || (this.c == 0)) {}
    for (int i = 0;; i = (int)(this.d * (getMeasuredWidth() - this.jdField_a_of_type_AndroidWidgetImageView.getMeasuredWidth()) / this.c))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.layout(i, 0, this.jdField_a_of_type_AndroidWidgetImageView.getMeasuredWidth() + i, this.jdField_a_of_type_AndroidWidgetImageView.getMeasuredHeight());
      return;
    }
  }
  
  public boolean a()
  {
    return this.c > 0;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getOrientation() == 1)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    b();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int j = 0;
    if (!a()) {
      return false;
    }
    int k;
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
      for (;;)
      {
        return true;
        getParent().requestDisallowInterceptTouchEvent(true);
        this.jdField_a_of_type_Int = ((int)paramMotionEvent.getRawX());
        this.b = ((int)paramMotionEvent.getRawY());
        if (this.jdField_a_of_type_Alzp != null) {
          this.jdField_a_of_type_Alzp.a();
        }
      }
    case 2: 
      k = (int)paramMotionEvent.getRawX() - this.jdField_a_of_type_Int;
      if (Math.abs(k) < this.h) {
        return true;
      }
      this.g = 0;
      i = paramView.getLeft() + k;
      k += paramView.getRight();
      if (i >= 0) {
        break;
      }
    }
    for (int i = paramView.getWidth() + 0;; i = k)
    {
      k = i;
      if (i > getWidth())
      {
        k = getWidth();
        j = k - paramView.getWidth();
      }
      if (this.jdField_a_of_type_Alzp != null)
      {
        i = this.d;
        this.d = ((int)(j / (getWidth() - paramView.getWidth()) * this.c));
        if (i != this.d) {
          this.jdField_a_of_type_Alzp.a(this.d);
        }
      }
      paramView.layout(j, paramView.getTop(), k, paramView.getBottom());
      paramView.invalidate();
      this.jdField_a_of_type_Int = ((int)paramMotionEvent.getRawX());
      this.b = ((int)paramMotionEvent.getRawY());
      break;
      getParent().requestDisallowInterceptTouchEvent(false);
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_Alzp == null) {
        break;
      }
      this.jdField_a_of_type_Alzp.b();
      break;
      j = i;
    }
  }
  
  public void setMax(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setOnProgressChangedListener(alzp paramalzp)
  {
    this.jdField_a_of_type_Alzp = paramalzp;
  }
  
  public void setProgress(int paramInt)
  {
    if (paramInt != this.d)
    {
      this.d = paramInt;
      requestLayout();
    }
  }
  
  public void setThumb(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
  }
  
  public void setThumbOffset(int paramInt)
  {
    this.d = 0;
    if (this.g != paramInt) {
      this.g = paramInt;
    }
    requestLayout();
  }
  
  public void setThumbSize(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != this.e) || (paramInt2 != this.f))
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.width = paramInt1;
      localLayoutParams.height = paramInt2;
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.DrawableSeekbar
 * JD-Core Version:    0.7.0.1
 */