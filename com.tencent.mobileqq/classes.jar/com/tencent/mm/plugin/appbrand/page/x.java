package com.tencent.mm.plugin.appbrand.page;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import com.tencent.luggage.wxa.qz.o;

public class x
  extends FrameLayout
{
  private View a;
  private FrameLayout b;
  private FrameLayout c;
  private int d;
  private boolean e = true;
  private boolean f = false;
  private boolean g = false;
  private boolean h = false;
  private boolean i = false;
  private int j;
  private int k;
  private int l;
  private boolean m = false;
  private ObjectAnimator n = null;
  
  public x(Context paramContext)
  {
    super(paramContext);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.d = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  private int b(int paramInt)
  {
    paramInt >>= 1;
    int i1 = getMaxOverScrollDistance();
    if (paramInt > i1) {
      return i1;
    }
    return paramInt;
  }
  
  private void c(int paramInt)
  {
    paramInt = Math.min(getMaxOverScrollDistance(), paramInt);
    this.c.setTranslationY(paramInt);
  }
  
  private void d(int paramInt)
  {
    int i1 = (int)this.c.getTranslationY();
    if (i1 == paramInt) {
      return;
    }
    o.d("MicroMsg.AppBrandPullDownView", "fastScrollTo from = %s, to = %s", new Object[] { Integer.valueOf(i1), Integer.valueOf(paramInt) });
    ObjectAnimator localObjectAnimator = this.n;
    if (localObjectAnimator != null) {
      localObjectAnimator.cancel();
    }
    long l1 = (Math.abs(i1 - paramInt) / getStayHeight() * 250.0F);
    localObjectAnimator = ObjectAnimator.ofFloat(this.c, "translationY", new float[] { i1, paramInt });
    localObjectAnimator.setDuration(Math.min(l1, 250L));
    localObjectAnimator.setInterpolator(new DecelerateInterpolator());
    localObjectAnimator.start();
    localObjectAnimator.addUpdateListener(new x.1(this));
    this.n = localObjectAnimator;
  }
  
  private int getMaxOverScrollDistance()
  {
    return getHeight();
  }
  
  protected void a(int paramInt) {}
  
  public void a(View paramView1, View paramView2)
  {
    this.a = paramView1;
    this.b = new FrameLayout(getContext());
    this.b.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.b.addView(paramView1);
    this.c = new FrameLayout(getContext());
    this.c.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.c.addView(paramView2);
    addView(this.b);
    addView(this.c);
  }
  
  public boolean a()
  {
    return this.e ^ true;
  }
  
  protected final void b()
  {
    d(getStayHeight());
    if (!this.g) {
      d();
    }
    this.h = true;
    this.g = true;
    this.i = true;
  }
  
  protected void c()
  {
    d(0);
    if (this.g) {
      e();
    }
    this.h = false;
    this.g = false;
    this.i = false;
  }
  
  protected void d() {}
  
  protected void e() {}
  
  protected boolean f()
  {
    return false;
  }
  
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
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.e) {
      return this.i;
    }
    int i1 = paramMotionEvent.getAction();
    if (i1 != 3)
    {
      boolean bool = true;
      if (i1 != 1)
      {
        if ((i1 == 2) && (this.h)) {
          return true;
        }
        if (i1 != 0)
        {
          if ((i1 == 2) && (f()))
          {
            if (!this.m)
            {
              this.j = ((int)paramMotionEvent.getX());
              this.k = ((int)paramMotionEvent.getY());
              this.l = ((int)paramMotionEvent.getY());
              this.h = false;
              this.m = true;
              return false;
            }
            i1 = (int)paramMotionEvent.getX();
            int i2 = (int)paramMotionEvent.getY();
            int i3 = this.j;
            int i4 = i2 - this.k;
            if ((Math.abs(i4) > this.d) && (Math.abs(i4) > Math.abs(i1 - i3)) && (i4 > 0))
            {
              this.j = i1;
              this.k = i2;
              this.h = true;
              this.m = false;
              return true;
            }
          }
        }
        else if (f())
        {
          this.j = ((int)paramMotionEvent.getX());
          this.k = ((int)paramMotionEvent.getY());
          this.l = ((int)paramMotionEvent.getY());
          this.h = false;
          this.m = true;
        }
        if (!this.h)
        {
          if (this.i) {
            return true;
          }
          bool = false;
        }
        return bool;
      }
    }
    this.h = false;
    this.m = false;
    return false;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.e)
    {
      if (this.i) {
        c();
      }
      return this.i;
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
          if ((!this.h) && (!this.i)) {
            break label270;
          }
          if (!this.m)
          {
            this.k = ((int)paramMotionEvent.getY());
            this.j = ((int)paramMotionEvent.getX());
            this.l = ((int)paramMotionEvent.getY());
            this.m = true;
            return true;
          }
          int i3 = (int)paramMotionEvent.getY() - this.l;
          int i2 = b(i3);
          i1 = i2;
          if (this.g) {
            i1 = i2 + getStayHeight();
          }
          i1 = Math.max(i1, 0);
          o.e("MicroMsg.AppBrandPullDownView", "real diff: %d, calc diff: %d", new Object[] { Integer.valueOf(i3), Integer.valueOf(i1) });
          c(i1);
          a(i1);
          return true;
        }
      }
      this.m = false;
      if ((this.c.getTranslationY() > getOpenHeight()) && (this.f))
      {
        b();
        return true;
      }
      if ((this.h) || (this.i))
      {
        c();
        return true;
      }
    }
    else
    {
      if ((f()) || (this.i)) {
        break label272;
      }
    }
    label270:
    return false;
    label272:
    this.k = ((int)paramMotionEvent.getY());
    this.j = ((int)paramMotionEvent.getX());
    this.l = ((int)paramMotionEvent.getY());
    this.m = true;
    return true;
  }
  
  public void setNeedStay(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void setPullDownBackgroundColor(int paramInt)
  {
    this.b.setBackgroundColor(paramInt);
  }
  
  public void setPullDownEnabled(boolean paramBoolean)
  {
    this.e = (paramBoolean ^ true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.x
 * JD-Core Version:    0.7.0.1
 */