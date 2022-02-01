package com.tencent.mobileqq.avatar.dynamicavatar.videodrawable;

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
import com.tencent.mobileqq.app.HardCodeUtil;

public class DrawableSeekbar
  extends LinearLayout
  implements View.OnTouchListener
{
  int jdField_a_of_type_Int;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  DrawableSeekbar.OnProgressChangedListener jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableDrawableSeekbar$OnProgressChangedListener;
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
    this.h = ((int)(getResources().getDisplayMetrics().density * 2.0F));
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetImageView.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131703691));
  }
  
  private void b()
  {
    int j = this.g;
    if (j != 0)
    {
      i = j;
      if (this.jdField_a_of_type_AndroidWidgetImageView.getWidth() + j > getWidth()) {
        i = getWidth() - this.jdField_a_of_type_AndroidWidgetImageView.getWidth();
      }
      localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
      localImageView.layout(i, 0, localImageView.getMeasuredWidth() + i, this.jdField_a_of_type_AndroidWidgetImageView.getMeasuredHeight());
      return;
    }
    int i = this.d;
    if ((i != 0) && (this.c != 0)) {
      i = (int)(i * (getMeasuredWidth() - this.jdField_a_of_type_AndroidWidgetImageView.getMeasuredWidth()) / this.c);
    } else {
      i = 0;
    }
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    localImageView.layout(i, 0, localImageView.getMeasuredWidth() + i, this.jdField_a_of_type_AndroidWidgetImageView.getMeasuredHeight());
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
    boolean bool = a();
    int j = 0;
    if (!bool) {
      return false;
    }
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            return true;
          }
        }
        else
        {
          int k = (int)paramMotionEvent.getRawX() - this.jdField_a_of_type_Int;
          if (Math.abs(k) < this.h) {
            return true;
          }
          this.g = 0;
          i = paramView.getLeft() + k;
          k = paramView.getRight() + k;
          if (i < 0)
          {
            i = paramView.getWidth() + 0;
          }
          else
          {
            j = i;
            i = k;
          }
          k = j;
          j = i;
          if (i > getWidth())
          {
            j = getWidth();
            k = j - paramView.getWidth();
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableDrawableSeekbar$OnProgressChangedListener != null)
          {
            i = this.d;
            this.d = ((int)(k / (getWidth() - paramView.getWidth()) * this.c));
            int m = this.d;
            if (i != m) {
              this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableDrawableSeekbar$OnProgressChangedListener.a(m);
            }
          }
          paramView.layout(k, paramView.getTop(), j, paramView.getBottom());
          paramView.invalidate();
          this.jdField_a_of_type_Int = ((int)paramMotionEvent.getRawX());
          this.b = ((int)paramMotionEvent.getRawY());
          return true;
        }
      }
      getParent().requestDisallowInterceptTouchEvent(false);
      this.jdField_a_of_type_Boolean = false;
      paramView = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableDrawableSeekbar$OnProgressChangedListener;
      if (paramView != null)
      {
        paramView.b();
        return true;
      }
    }
    else
    {
      getParent().requestDisallowInterceptTouchEvent(true);
      this.jdField_a_of_type_Int = ((int)paramMotionEvent.getRawX());
      this.b = ((int)paramMotionEvent.getRawY());
      paramView = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableDrawableSeekbar$OnProgressChangedListener;
      if (paramView != null) {
        paramView.a();
      }
    }
    return true;
  }
  
  public void setMax(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setOnProgressChangedListener(DrawableSeekbar.OnProgressChangedListener paramOnProgressChangedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableDrawableSeekbar$OnProgressChangedListener = paramOnProgressChangedListener;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.DrawableSeekbar
 * JD-Core Version:    0.7.0.1
 */