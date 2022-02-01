package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.animation.AnimatorProxy;
import com.tencent.mobileqq.util.DisplayUtil;

public class DragFrameLayout
  extends FrameLayout
{
  public int a;
  protected boolean b;
  protected boolean c = true;
  private View d;
  private float e = 0.0F;
  private float f = 0.0F;
  private float g = 0.0F;
  private float h = 0.0F;
  private int i = 0;
  private int j = 0;
  private DragFrameLayout.OnDraggingListener k;
  private int l = 0;
  private TranslateAnimation m;
  private ScaleAnimation n;
  private AnimationSet o;
  
  public DragFrameLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public DragFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  @Deprecated
  public void a() {}
  
  public void a(int paramInt)
  {
    a(paramInt, new LinearInterpolator(), null);
  }
  
  public void a(int paramInt, Interpolator paramInterpolator)
  {
    a(paramInt, paramInterpolator, null);
  }
  
  public void a(int paramInt, Interpolator paramInterpolator, Animation.AnimationListener paramAnimationListener)
  {
    float f1 = ViewHelper.getScaleX(this.d);
    float f2 = ViewHelper.getScaleY(this.d);
    TranslateAnimation localTranslateAnimation = this.m;
    if (localTranslateAnimation != null) {
      localTranslateAnimation.cancel();
    }
    this.m = new TranslateAnimation(0, ViewHelper.getX(this.d), 0, 0.0F, 0, ViewHelper.getY(this.d), 0, 0.0F);
    localTranslateAnimation = this.m;
    long l1 = paramInt;
    localTranslateAnimation.setDuration(l1);
    this.m.setFillAfter(true);
    if (paramAnimationListener != null) {
      this.m.setAnimationListener(paramAnimationListener);
    }
    paramAnimationListener = this.n;
    if (paramAnimationListener != null) {
      paramAnimationListener.cancel();
    }
    this.n = new ScaleAnimation(f1, 1.0F, f2, 1.0F, 0.0F, 0.0F);
    this.n.setDuration(l1);
    this.n.setFillAfter(true);
    paramAnimationListener = this.o;
    if (paramAnimationListener != null) {
      paramAnimationListener.cancel();
    }
    this.o = new AnimationSet(true);
    this.o.addAnimation(this.n);
    this.o.addAnimation(this.m);
    this.o.setInterpolator(paramInterpolator);
    this.d.startAnimation(this.o);
    this.b = false;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Object localObject = this.m;
    if (localObject != null)
    {
      ((TranslateAnimation)localObject).cancel();
      this.m = null;
    }
    localObject = this.n;
    if (localObject != null)
    {
      ((ScaleAnimation)localObject).cancel();
      this.n = null;
    }
    localObject = this.o;
    if (localObject != null)
    {
      ((AnimationSet)localObject).cancel();
      this.o = null;
    }
    localObject = this.d;
    if (localObject != null)
    {
      ((View)localObject).clearAnimation();
      AnimatorProxy.wrap(this.d).reset();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.c) && (this.d != null))
    {
      if (paramMotionEvent.getPointerCount() > 1) {
        return super.onInterceptTouchEvent(paramMotionEvent);
      }
      if (this.b) {
        return true;
      }
      int i1 = paramMotionEvent.getAction();
      this.g = paramMotionEvent.getX();
      this.h = paramMotionEvent.getY();
      if (i1 == 0)
      {
        this.e = this.g;
        this.f = this.h;
        if (this.i == 0)
        {
          this.i = super.getWidth();
          this.j = super.getHeight();
        }
        this.d.clearAnimation();
        return super.onInterceptTouchEvent(paramMotionEvent);
      }
      if (i1 == 2)
      {
        float f1 = Math.abs(this.g - this.e);
        float f2 = Math.abs(this.h - this.f);
        if ((this.l == 0) && (f1 + f2 < DisplayUtil.a(getContext(), 10.0F))) {
          return false;
        }
        f1 = this.g - this.e;
        f2 = this.h - this.f;
        if ((f2 < 0.0F) && (Math.abs(f2) > Math.abs(f1)) && (this.l == 0))
        {
          this.e = this.g;
          this.f = this.h;
          return false;
        }
        double d1 = Math.abs(f2);
        double d2 = Math.abs(f1);
        Double.isNaN(d2);
        if (d1 > d2 * 1.2D)
        {
          if (this.l == 0)
          {
            if ((this.c) && (this.k.a()))
            {
              this.e = this.g;
              this.f = this.h;
              this.l = 1;
              return true;
            }
            this.e = this.g;
            this.f = this.h;
            return false;
          }
        }
        else if (f1 < 0.0F)
        {
          if (this.l == 0)
          {
            if ((this.c) && (this.k.b()))
            {
              this.e = this.g;
              this.f = this.h;
              this.l = 2;
              return true;
            }
            this.e = this.g;
            this.f = this.h;
            return false;
          }
        }
        else if (f1 > 0.0F)
        {
          if (this.l == 0)
          {
            if (this.c)
            {
              paramMotionEvent = this.k;
              if ((paramMotionEvent != null) && (paramMotionEvent.c()))
              {
                this.e = this.g;
                this.f = this.h;
                this.l = 4;
                return true;
              }
            }
            this.e = this.g;
            this.f = this.h;
            return false;
          }
        }
        else
        {
          this.e = this.g;
          this.f = this.h;
        }
      }
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.c) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    if (this.b) {
      return true;
    }
    int i1 = paramMotionEvent.getAction();
    this.g = paramMotionEvent.getX();
    this.h = paramMotionEvent.getY();
    if (i1 == 0)
    {
      this.e = this.g;
      this.f = this.h;
      return true;
    }
    float f2;
    float f1;
    if (i1 == 2)
    {
      float f3 = this.g - this.e;
      float f5 = this.h - this.f;
      i1 = this.l;
      double d1;
      double d2;
      if (i1 == 1)
      {
        if (f5 > 0.0F)
        {
          d1 = this.j;
          d2 = f5;
          Double.isNaN(d2);
          Double.isNaN(d1);
          i1 = (int)(d1 - d2 * 1.1D);
        }
        else
        {
          i1 = this.j;
        }
        f2 = i1;
        f1 = this.i * f2 / this.j;
      }
      else
      {
        if (i1 == 2)
        {
          if (f3 < 0.0F)
          {
            d1 = this.i;
            d2 = f3;
            Double.isNaN(d2);
            Double.isNaN(d1);
            i1 = (int)(d1 + d2 * 1.1D);
          }
          else
          {
            i1 = this.i;
          }
          f1 = i1;
          f2 = this.j * f1;
        }
        for (i1 = this.i;; i1 = this.i)
        {
          f2 /= i1;
          break label352;
          if (i1 != 4) {
            break;
          }
          if (f3 > 0.0F)
          {
            d1 = this.i;
            d2 = f3;
            Double.isNaN(d2);
            Double.isNaN(d1);
            i1 = (int)(d1 - d2 * 1.1D);
          }
          else
          {
            i1 = this.i;
          }
          f1 = i1;
          f2 = this.j * f1;
        }
        f1 = 0.0F;
        f2 = 0.0F;
      }
      label352:
      i1 = this.a;
      float f4 = f1;
      if (f1 <= i1)
      {
        f4 = i1;
        f2 = this.j * f4 / this.i;
      }
      i1 = this.l;
      if (i1 == 1)
      {
        i1 = this.i;
        f2 = f4 / i1;
        f1 = this.e;
        i1 = (int)(f3 + f1 - f4 * f1 / i1);
        if (f5 > 0.0F) {
          f1 = f5;
        } else {
          f1 = f5 / 2.0F;
        }
        setSizeAndPosition(f2, i1, (int)f1);
        return true;
      }
      if (i1 == 2)
      {
        i1 = this.i;
        f1 = f4 / i1;
        float f6 = i1;
        if (f3 >= 0.0F) {
          f3 /= 2.0F;
        }
        i1 = (int)(f6 - f4 + f3);
        f3 = this.f;
        setSizeAndPosition(f1, i1, (int)(f5 + f3 - f2 * f3 / this.j));
        return true;
      }
      if (i1 == 4)
      {
        f1 = f4 / this.i;
        if (f3 <= 0.0F) {
          f3 /= 2.0F;
        }
        i1 = (int)f3;
        f3 = this.f;
        setSizeAndPosition(f1, i1, (int)(f5 + f3 - f2 * f3 / this.j));
      }
      return true;
    }
    if ((i1 == 1) || (i1 == 3))
    {
      if (this.l != 0)
      {
        this.b = true;
        if (this.k != null)
        {
          f1 = ViewHelper.getScaleX(this.d);
          f2 = ViewHelper.getScaleY(this.d);
          if ((f1 > 0.0F) && (f2 > 0.0F))
          {
            paramMotionEvent = this.k;
            View localView = this.d;
            i1 = this.i;
            int i2 = this.j;
            paramMotionEvent.a(localView, i1, i2, (int)(i1 * f1), (int)(i2 * f2), (int)ViewHelper.getX(localView), (int)ViewHelper.getY(this.d));
          }
        }
      }
      this.l = 0;
    }
    return true;
  }
  
  public void setDraggableView(View paramView)
  {
    this.d = paramView;
  }
  
  public void setDraggableView(View paramView, int paramInt1, int paramInt2)
  {
    this.d = paramView;
    this.i = paramInt1;
    this.j = paramInt2;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void setOnDraggingListener(DragFrameLayout.OnDraggingListener paramOnDraggingListener)
  {
    this.k = paramOnDraggingListener;
  }
  
  public void setSizeAndPosition(float paramFloat, int paramInt1, int paramInt2)
  {
    float f1 = paramFloat;
    if (paramFloat > 1.0F) {
      f1 = 1.0F;
    }
    ViewHelper.setPivotX(this.d, 0.0F);
    ViewHelper.setPivotY(this.d, 0.0F);
    ViewHelper.setScaleX(this.d, f1);
    ViewHelper.setScaleY(this.d, f1);
    ViewHelper.setX(this.d, paramInt1);
    ViewHelper.setY(this.d, paramInt2);
    DragFrameLayout.OnDraggingListener localOnDraggingListener = this.k;
    if (localOnDraggingListener != null)
    {
      int i1 = this.i;
      int i2 = this.j;
      localOnDraggingListener.a(paramInt1, paramInt2, i1, i2, (int)(i1 * f1), (int)(i2 * f1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.DragFrameLayout
 * JD-Core Version:    0.7.0.1
 */