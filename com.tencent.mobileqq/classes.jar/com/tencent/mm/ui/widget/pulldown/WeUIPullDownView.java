package com.tencent.mm.ui.widget.pulldown;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import com.tencent.mm.ui.g;

public class WeUIPullDownView
  extends FrameLayout
{
  private View a;
  private FrameLayout b;
  private View c;
  private FrameLayout d;
  private WeUIPullDownView.IsAtBottomCallBack e;
  private WeUIPullDownView.IsAtTopCallBack f;
  private int g;
  private boolean h = false;
  private boolean i = false;
  private boolean j = false;
  private boolean k = false;
  private boolean l = false;
  private int m;
  private int n;
  private int o;
  private boolean p = false;
  private boolean q = false;
  private boolean r = false;
  private ObjectAnimator s = null;
  
  public WeUIPullDownView(@NonNull Context paramContext)
  {
    super(paramContext);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.g = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  private int b(int paramInt)
  {
    paramInt >>= 1;
    int i3 = getMaxOverScrollDistance();
    int i1 = (int)Math.sqrt(Math.abs(paramInt) * g.a(getContext(), 150));
    int i2;
    if (paramInt < 0)
    {
      i1 = -i1;
      i2 = paramInt * 2;
      paramInt = i1;
      if (i1 < i2) {
        paramInt = i2;
      }
    }
    else
    {
      i2 = paramInt * 2;
      paramInt = i1;
      if (i1 > i2) {
        paramInt = i2;
      }
    }
    if (paramInt > i3) {
      return i3;
    }
    return paramInt;
  }
  
  private void c(int paramInt)
  {
    paramInt = Math.min(getMaxOverScrollDistance(), paramInt);
    this.d.setTranslationY(paramInt);
  }
  
  private void d(int paramInt)
  {
    int i1 = (int)this.d.getTranslationY();
    if (i1 == paramInt) {
      return;
    }
    ObjectAnimator localObjectAnimator = this.s;
    if (localObjectAnimator != null) {
      localObjectAnimator.cancel();
    }
    Math.abs(i1 - paramInt);
    getStayHeight();
    localObjectAnimator = ObjectAnimator.ofFloat(this.d, "translationY", new float[] { i1, paramInt });
    localObjectAnimator.setDuration(250L);
    localObjectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    localObjectAnimator.start();
    localObjectAnimator.addUpdateListener(new WeUIPullDownView.1(this));
    this.s = localObjectAnimator;
  }
  
  private int getMaxOverScrollDistance()
  {
    return getHeight();
  }
  
  protected final void a()
  {
    d(getStayHeight());
    if (!this.j) {
      c();
    }
    this.k = true;
    this.j = true;
    this.l = true;
  }
  
  protected void a(int paramInt) {}
  
  protected void b()
  {
    d(0);
    if (this.j) {
      d();
    }
    this.k = false;
    this.j = false;
    this.l = false;
  }
  
  protected void c() {}
  
  protected void d() {}
  
  protected int getOpenHeight()
  {
    return this.a.getHeight();
  }
  
  @ColorInt
  public int getPullDownBackgroundColor()
  {
    Drawable localDrawable = this.b.getBackground();
    if ((localDrawable instanceof ColorDrawable)) {
      return ((ColorDrawable)localDrawable).getColor();
    }
    return 0;
  }
  
  protected int getStayHeight()
  {
    return this.a.getHeight();
  }
  
  public boolean isPullDownEnabled()
  {
    return this.h ^ true;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.h) {
      return this.l;
    }
    Object localObject = this.f;
    if (localObject != null) {
      this.p = ((WeUIPullDownView.IsAtTopCallBack)localObject).isAtTop();
    }
    localObject = this.e;
    if (localObject != null) {
      this.q = ((WeUIPullDownView.IsAtBottomCallBack)localObject).isAtBottom();
    }
    int i1 = paramMotionEvent.getAction();
    if (i1 != 3)
    {
      boolean bool = true;
      if (i1 != 1)
      {
        if ((i1 == 2) && (this.k)) {
          return true;
        }
        if (i1 != 0)
        {
          if ((i1 == 2) && ((this.p) || (this.q)))
          {
            if (!this.r)
            {
              this.m = ((int)paramMotionEvent.getX());
              this.n = ((int)paramMotionEvent.getY());
              this.o = ((int)paramMotionEvent.getY());
              this.k = false;
              this.r = true;
              return false;
            }
            i1 = (int)paramMotionEvent.getX();
            int i2 = (int)paramMotionEvent.getY();
            int i3 = i1 - this.m;
            int i4 = i2 - this.n;
            if (((this.p) && (Math.abs(i4) > this.g) && (Math.abs(i4) > Math.abs(i3)) && (i4 > 0)) || ((this.q) && (Math.abs(i4) > this.g) && (Math.abs(i4) > Math.abs(i3)) && (i4 < 0)))
            {
              this.m = i1;
              this.n = i2;
              this.k = true;
              this.r = false;
              return true;
            }
          }
        }
        else if ((this.p) || (this.q))
        {
          this.m = ((int)paramMotionEvent.getX());
          this.n = ((int)paramMotionEvent.getY());
          this.o = ((int)paramMotionEvent.getY());
          this.k = false;
          this.r = true;
        }
        if (!this.k)
        {
          if (this.l) {
            return true;
          }
          bool = false;
        }
        return bool;
      }
    }
    this.k = false;
    this.r = false;
    return false;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.h)
    {
      if (this.l) {
        b();
      }
      return this.l;
    }
    if ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0)) {
      return false;
    }
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if (i1 != 1) {
        if (i1 != 2)
        {
          if (i1 != 3) {
            return false;
          }
        }
        else
        {
          if ((!this.k) && (!this.l)) {
            break label241;
          }
          if (!this.r)
          {
            this.n = ((int)paramMotionEvent.getY());
            this.m = ((int)paramMotionEvent.getX());
            this.o = ((int)paramMotionEvent.getY());
            this.r = true;
            return true;
          }
          int i2 = b((int)paramMotionEvent.getY() - this.o);
          i1 = i2;
          if (this.j) {
            i1 = i2 + getStayHeight();
          }
          c(i1);
          a(i1);
          return true;
        }
      }
      this.r = false;
      if ((this.d.getTranslationY() > getOpenHeight()) && (this.i))
      {
        a();
        return true;
      }
      if ((this.k) || (this.l))
      {
        b();
        return true;
      }
    }
    else
    {
      if ((this.p) || (this.q) || (this.l)) {
        break label243;
      }
    }
    label241:
    return false;
    label243:
    this.n = ((int)paramMotionEvent.getY());
    this.m = ((int)paramMotionEvent.getX());
    this.o = ((int)paramMotionEvent.getY());
    this.r = true;
    return true;
  }
  
  public void setAtBottomCallBack(WeUIPullDownView.IsAtBottomCallBack paramIsAtBottomCallBack)
  {
    this.e = paramIsAtBottomCallBack;
  }
  
  public void setAtTopCallBack(WeUIPullDownView.IsAtTopCallBack paramIsAtTopCallBack)
  {
    this.f = paramIsAtTopCallBack;
  }
  
  public void setNeedStay(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void setPullDownBackgroundColor(int paramInt)
  {
    View localView = this.a;
    if (localView != null) {
      localView.setBackgroundColor(paramInt);
    }
  }
  
  public void setPullDownEnabled(boolean paramBoolean)
  {
    this.h = (paramBoolean ^ true);
  }
  
  public void setView(View paramView1, View paramView2)
  {
    this.a = paramView1;
    this.b = new FrameLayout(getContext());
    this.b.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.b.addView(paramView1);
    this.c = paramView2;
    this.d = new FrameLayout(getContext());
    this.d.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.d.addView(paramView2);
    addView(this.b);
    addView(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.pulldown.WeUIPullDownView
 * JD-Core Version:    0.7.0.1
 */