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
  ImageView a;
  int b;
  int c;
  int d;
  int e;
  int f;
  int g;
  int h;
  int i;
  boolean j = false;
  DrawableSeekbar.OnProgressChangedListener k;
  
  public DrawableSeekbar(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public DrawableSeekbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  private void b()
  {
    this.i = ((int)(getResources().getDisplayMetrics().density * 2.0F));
    this.a = new ImageView(getContext());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    addView(this.a, localLayoutParams);
    this.a.setClickable(true);
    this.a.setOnTouchListener(this);
    this.a.setScaleType(ImageView.ScaleType.FIT_XY);
    this.a.setContentDescription(HardCodeUtil.a(2131901640));
  }
  
  private void c()
  {
    int n = this.h;
    if (n != 0)
    {
      m = n;
      if (this.a.getWidth() + n > getWidth()) {
        m = getWidth() - this.a.getWidth();
      }
      localImageView = this.a;
      localImageView.layout(m, 0, localImageView.getMeasuredWidth() + m, this.a.getMeasuredHeight());
      return;
    }
    int m = this.e;
    if ((m != 0) && (this.d != 0)) {
      m = (int)(m * (getMeasuredWidth() - this.a.getMeasuredWidth()) / this.d);
    } else {
      m = 0;
    }
    ImageView localImageView = this.a;
    localImageView.layout(m, 0, localImageView.getMeasuredWidth() + m, this.a.getMeasuredHeight());
  }
  
  public boolean a()
  {
    return this.d > 0;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getOrientation() == 1)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    c();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = a();
    int n = 0;
    if (!bool) {
      return false;
    }
    int m = paramMotionEvent.getAction();
    if (m != 0)
    {
      if (m != 1) {
        if (m != 2)
        {
          if (m != 3) {
            return true;
          }
        }
        else
        {
          int i1 = (int)paramMotionEvent.getRawX() - this.b;
          if (Math.abs(i1) < this.i) {
            return true;
          }
          this.h = 0;
          m = paramView.getLeft() + i1;
          i1 = paramView.getRight() + i1;
          if (m < 0)
          {
            m = paramView.getWidth() + 0;
          }
          else
          {
            n = m;
            m = i1;
          }
          i1 = n;
          n = m;
          if (m > getWidth())
          {
            n = getWidth();
            i1 = n - paramView.getWidth();
          }
          if (this.k != null)
          {
            m = this.e;
            this.e = ((int)(i1 / (getWidth() - paramView.getWidth()) * this.d));
            int i2 = this.e;
            if (m != i2) {
              this.k.a(i2);
            }
          }
          paramView.layout(i1, paramView.getTop(), n, paramView.getBottom());
          paramView.invalidate();
          this.b = ((int)paramMotionEvent.getRawX());
          this.c = ((int)paramMotionEvent.getRawY());
          return true;
        }
      }
      getParent().requestDisallowInterceptTouchEvent(false);
      this.j = false;
      paramView = this.k;
      if (paramView != null)
      {
        paramView.c();
        return true;
      }
    }
    else
    {
      getParent().requestDisallowInterceptTouchEvent(true);
      this.b = ((int)paramMotionEvent.getRawX());
      this.c = ((int)paramMotionEvent.getRawY());
      paramView = this.k;
      if (paramView != null) {
        paramView.b();
      }
    }
    return true;
  }
  
  public void setMax(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setOnProgressChangedListener(DrawableSeekbar.OnProgressChangedListener paramOnProgressChangedListener)
  {
    this.k = paramOnProgressChangedListener;
  }
  
  public void setProgress(int paramInt)
  {
    if (paramInt != this.e)
    {
      this.e = paramInt;
      requestLayout();
    }
  }
  
  public void setThumb(Drawable paramDrawable)
  {
    this.a.setImageDrawable(paramDrawable);
  }
  
  public void setThumbOffset(int paramInt)
  {
    this.e = 0;
    if (this.h != paramInt) {
      this.h = paramInt;
    }
    requestLayout();
  }
  
  public void setThumbSize(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != this.f) || (paramInt2 != this.g))
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.a.getLayoutParams();
      localLayoutParams.width = paramInt1;
      localLayoutParams.height = paramInt2;
      this.a.setLayoutParams(localLayoutParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.DrawableSeekbar
 * JD-Core Version:    0.7.0.1
 */