package com.tencent.biz.qqcircle.transition;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;

public class QCircleTransitionLayout
  extends FrameLayout
{
  private boolean a = QCircleConfigHelper.p();
  private boolean b = true;
  private boolean c = true;
  private int d;
  private int e;
  private float f;
  private int g;
  private int h;
  private float i = 1.0F;
  private float j = 0.5F;
  private float k = 0.8F;
  private int l = 255;
  private QCircleTransitionInnerLayout m;
  private Drawable n;
  private float o;
  private float p;
  private QCircleTransitionLayout.TransitionListner q;
  private float r;
  private float s;
  private boolean t = true;
  
  public QCircleTransitionLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public QCircleTransitionLayout(@NonNull Context paramContext, @NonNull AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public QCircleTransitionLayout(@NonNull Context paramContext, @NonNull AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 = Math.abs(paramFloat1 - paramFloat3);
    paramFloat2 = Math.abs(paramFloat2 - paramFloat4);
    return (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if (!getEnableTransitionTotal()) {
      return;
    }
    float f1 = paramMotionEvent.getRawY();
    float f2 = paramMotionEvent.getRawX();
    int i1 = paramMotionEvent.getAction();
    if (i1 != 1) {
      if (i1 != 2)
      {
        if (i1 == 3) {}
      }
      else
      {
        if (getBackground() == null) {
          if (Build.VERSION.SDK_INT >= 16) {
            setBackground(this.n);
          } else {
            setBackgroundDrawable(this.n);
          }
        }
        if (this.t)
        {
          this.t = false;
          paramMotionEvent = this.q;
          if (paramMotionEvent != null) {
            paramMotionEvent.a();
          }
          this.n.setAlpha(255);
        }
        float f3 = this.p;
        this.r = (f2 - f3);
        float f4 = this.o;
        this.s = (f1 - f4);
        f1 = a(f2, f1, f3, f4) / this.f;
        f2 = this.i;
        if ((f2 >= this.j) && (f2 <= 1.0F)) {
          this.i = (1.0F - f1);
        }
        f1 = this.i;
        f2 = this.j;
        if (f1 < f2) {
          this.i = f2;
        } else if (f1 > 1.0F) {
          this.i = 1.0F;
        }
        this.l = ((int)(this.i * 255.0F));
        i1 = this.l;
        if (i1 > 255) {
          this.l = 255;
        } else if (i1 < 0) {
          this.l = 0;
        }
        paramMotionEvent = this.m;
        if (paramMotionEvent == null) {
          return;
        }
        paramMotionEvent.setTranslationX(this.r);
        this.m.setTranslationY(this.s);
        this.m.setPivotX(this.d / 2.0F);
        this.m.setPivotY(this.e / 2.0F);
        this.m.setScaleX(this.i);
        this.m.setScaleY(this.i);
        this.n.setAlpha(this.l);
        return;
      }
    }
    if (this.i < this.k)
    {
      if (this.q != null)
      {
        this.n.setAlpha(0);
        this.q.a(this.r, this.s);
      }
    }
    else
    {
      paramMotionEvent = this.m;
      if (paramMotionEvent != null)
      {
        paramMotionEvent.animate().translationX(0.0F).setDuration(300L).setInterpolator(new DecelerateInterpolator());
        this.m.animate().translationY(0.0F).setDuration(300L).setInterpolator(new DecelerateInterpolator());
        this.m.animate().scaleX(1.0F).setDuration(300L).setInterpolator(new DecelerateInterpolator());
        this.m.animate().scaleY(1.0F).setDuration(300L).setInterpolator(new DecelerateInterpolator()).setListener(new QCircleTransitionLayout.1(this));
      }
    }
  }
  
  private void b()
  {
    this.d = ImmersiveUtils.b();
    this.e = ImmersiveUtils.c();
    this.n = getBackground();
    if (this.n == null) {
      this.n = new ColorDrawable(-16777216);
    }
    this.g = this.d;
    this.h = this.e;
    int i1 = this.g;
    int i2 = this.h;
    this.f = ((float)Math.sqrt(i1 * i1 + i2 * i2) / 2.0F);
  }
  
  private boolean getEnableTransitionTotal()
  {
    return (this.b) && (this.c) && (this.a);
  }
  
  public void a()
  {
    this.c = false;
  }
  
  public void a(QCircleTransitionInnerLayout paramQCircleTransitionInnerLayout, QCircleTransitionLayout.TransitionListner paramTransitionListner)
  {
    this.m = paramQCircleTransitionInnerLayout;
    this.q = paramTransitionListner;
  }
  
  public void a(boolean paramBoolean)
  {
    QCircleTransitionInnerLayout localQCircleTransitionInnerLayout = this.m;
    if (localQCircleTransitionInnerLayout != null) {
      localQCircleTransitionInnerLayout.a(paramBoolean);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      StringBuilder localStringBuilder;
      if (i1 != 1)
      {
        if (i1 == 2)
        {
          this.o = paramMotionEvent.getRawY();
          this.p = paramMotionEvent.getRawX();
          this.t = true;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onInterceptTouchEvent: MotionEvent.ACTION_MOVE StarX:");
          localStringBuilder.append(this.p);
          localStringBuilder.append(",mStarY:");
          localStringBuilder.append(this.o);
          localStringBuilder.append(",mAlpha:");
          localStringBuilder.append(this.l);
          QLog.d("QCircleTransitionLayout", 4, localStringBuilder.toString());
        }
      }
      else
      {
        float f1 = paramMotionEvent.getRawX();
        float f2 = paramMotionEvent.getRawY();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onInterceptTouchEvent: MotionEvent.ACTION_UP x:");
        localStringBuilder.append(f1);
        localStringBuilder.append(",y:");
        localStringBuilder.append(f2);
        QLog.d("QCircleTransitionLayout", 4, localStringBuilder.toString());
      }
    }
    else
    {
      QLog.d("QCircleTransitionLayout", 4, "onInterceptTouchEvent: MotionEvent.ACTION_DOWN ");
    }
    if (paramMotionEvent.getAction() == 0) {
      return false;
    }
    return getEnableTransitionTotal();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    a(paramMotionEvent);
    return getEnableTransitionTotal();
  }
  
  public void setInnerViewVisiable(int paramInt)
  {
    QCircleTransitionInnerLayout localQCircleTransitionInnerLayout = this.m;
    if (localQCircleTransitionInnerLayout != null) {
      localQCircleTransitionInnerLayout.setVisibility(paramInt);
    }
  }
  
  public void setTransitionBackgroundColor(int paramInt)
  {
    this.n = new ColorDrawable(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.transition.QCircleTransitionLayout
 * JD-Core Version:    0.7.0.1
 */