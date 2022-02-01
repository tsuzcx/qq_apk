package com.tencent.biz.subscribe.part.block.base;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

public class RefreshHeaderView
  extends LinearLayout
{
  private LinearLayout a;
  private ImageView b;
  private TextView c;
  private ProgressBar d;
  private RotateAnimation e;
  private RotateAnimation f;
  private int g;
  private int h;
  private float i;
  private float j;
  private RefreshHeaderView.OnRefreshListener k;
  private boolean l;
  private Handler m;
  private final String n = getResources().getString(2131916805);
  private final String o = getResources().getString(2131916801);
  private final String p = getResources().getString(2131916804);
  private final String q = getResources().getString(2131916802);
  private Drawable r;
  private long s;
  private RefreshHeaderView.ICanRefreshDelegate t;
  private boolean u;
  private boolean v;
  
  public RefreshHeaderView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RefreshHeaderView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RefreshHeaderView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    i();
  }
  
  private void a(int paramInt)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { getVisibleHeight(), paramInt });
    localValueAnimator.setDuration(200L).start();
    localValueAnimator.addUpdateListener(new RefreshHeaderView.2(this, paramInt));
    localValueAnimator.start();
  }
  
  private void a(boolean paramBoolean)
  {
    this.d.setIndeterminate(paramBoolean);
    ProgressBar localProgressBar = this.d;
    int i1;
    if ((!paramBoolean) && (!this.u)) {
      i1 = 8;
    } else {
      i1 = 0;
    }
    localProgressBar.setVisibility(i1);
  }
  
  private boolean a(float paramFloat, boolean paramBoolean)
  {
    if ((paramFloat > 0.0F) && (!paramBoolean)) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    this.v = paramBoolean;
    return paramBoolean;
  }
  
  private void i()
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.setMargins(0, 0, 0, 0);
    setLayoutParams(localLayoutParams);
    setPadding(0, 0, 0, 0);
    this.a = ((LinearLayout)LayoutInflater.from(getContext()).inflate(2131626856, null));
    addView(this.a, new LinearLayout.LayoutParams(-1, 0));
    this.b = ((ImageView)findViewById(2131436405));
    this.c = ((TextView)findViewById(2131448699));
    this.d = ((ProgressBar)findViewById(2131439918));
    this.e = new RotateAnimation(0.0F, 180.0F, 1, 0.5F, 1, 0.5F);
    this.e.setDuration(100L);
    this.e.setFillAfter(true);
    this.f = new RotateAnimation(-180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    this.f.setDuration(100L);
    this.f.setFillAfter(true);
    measure(-2, -2);
    this.g = getMeasuredHeight();
    this.r = getResources().getDrawable(2130839590);
  }
  
  private boolean j()
  {
    RefreshHeaderView.ICanRefreshDelegate localICanRefreshDelegate = this.t;
    if (localICanRefreshDelegate != null) {
      return localICanRefreshDelegate.a();
    }
    return getParent() != null;
  }
  
  public void a()
  {
    setState(0);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if ((getVisibleHeight() > 0) || (paramFloat1 > 0.0F))
    {
      setVisibleHeight((int)paramFloat1 + getVisibleHeight());
      if (this.h <= 1)
      {
        if (getVisibleHeight() > this.g)
        {
          b();
          return;
        }
        a();
      }
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (this.i == -1.0F) {
      this.i = paramMotionEvent.getRawY();
    }
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if (i1 != 2)
      {
        this.i = -1.0F;
        if ((j()) && (!this.l)) {
          c();
        }
      }
      else
      {
        float f2 = paramMotionEvent.getRawY();
        float f1 = this.i;
        f2 = (f2 - f1) / 2.0F;
        boolean bool;
        if (f1 == 0.0F) {
          bool = true;
        } else {
          bool = false;
        }
        this.i = paramMotionEvent.getRawY();
        this.j += f2;
        a(f2, bool);
        if ((j()) && (this.v) && (!this.l))
        {
          a(f2, this.j);
          if (getVisibleHeight() > 0) {
            return false;
          }
        }
      }
    }
    else
    {
      this.i = paramMotionEvent.getRawY();
      this.j = 0.0F;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void b()
  {
    setState(1);
  }
  
  public boolean c()
  {
    int i1 = getVisibleHeight();
    boolean bool;
    if ((getVisibleHeight() > this.g) && (this.h < 2))
    {
      setState(2);
      bool = true;
    }
    else
    {
      bool = false;
    }
    if (this.h == 2)
    {
      int i2 = this.g;
      if (i1 > i2) {
        a(i2);
      }
    }
    if (this.h != 2) {
      a(0);
    }
    if (this.h == 2) {
      a(this.g);
    }
    return bool;
  }
  
  public void d()
  {
    QLog.d("RefreshHeaderView", 1, "refreshComplete");
    long l1 = 1000L - this.s;
    if (l1 > 0L)
    {
      getMainHandler().postDelayed(new RefreshHeaderView.1(this), l1);
      return;
    }
    setState(3);
  }
  
  public boolean e()
  {
    return this.v;
  }
  
  public boolean f()
  {
    return this.l;
  }
  
  public void g()
  {
    setVisibleHeight(this.g);
  }
  
  public View getHeaderView()
  {
    return this;
  }
  
  public Handler getMainHandler()
  {
    if (this.m == null) {
      this.m = new Handler(Looper.getMainLooper());
    }
    return this.m;
  }
  
  public int getVisibleHeight()
  {
    return ((LinearLayout.LayoutParams)this.a.getLayoutParams()).height;
  }
  
  public void h()
  {
    if (getMainHandler() != null) {
      getMainHandler().removeCallbacksAndMessages(null);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.h == 1) {
      setState(2);
    }
  }
  
  public void setAlwaysShowProgressBar(boolean paramBoolean)
  {
    this.u = paramBoolean;
    ProgressBar localProgressBar = this.d;
    if ((localProgressBar != null) && (paramBoolean)) {
      localProgressBar.setVisibility(0);
    }
  }
  
  public void setCanRefreshDelegate(RefreshHeaderView.ICanRefreshDelegate paramICanRefreshDelegate)
  {
    this.t = paramICanRefreshDelegate;
  }
  
  public void setMeasuredHeight(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setOnRefreshListener(RefreshHeaderView.OnRefreshListener paramOnRefreshListener)
  {
    this.k = paramOnRefreshListener;
  }
  
  public void setRefreshing(boolean paramBoolean)
  {
    this.l = paramBoolean;
    if (!paramBoolean) {
      d();
    }
  }
  
  public void setState(int paramInt)
  {
    int i1 = this.h;
    if (paramInt == i1) {
      return;
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt == 4)
            {
              QLog.d("RefreshHeaderView", 4, "STATE_JUST_SHOW_REFRESH_ANIMATION");
              this.s = System.currentTimeMillis();
              this.b.clearAnimation();
              this.b.setVisibility(8);
              a(true);
              a(this.g);
              this.c.setText(this.o);
              setRefreshing(true);
            }
          }
          else
          {
            this.b.setVisibility(8);
            a(false);
            this.c.setText(this.n);
            a(0);
          }
        }
        else
        {
          this.s = System.currentTimeMillis();
          this.b.clearAnimation();
          this.b.setVisibility(8);
          a(true);
          a(this.g);
          this.c.setText(this.o);
          localObject = this.k;
          if (localObject != null) {
            ((RefreshHeaderView.OnRefreshListener)localObject).a();
          }
        }
      }
      else
      {
        this.b.setVisibility(0);
        a(false);
        if (this.h != 1)
        {
          this.b.clearAnimation();
          this.b.startAnimation(this.e);
          this.c.setText(this.p);
        }
      }
    }
    else
    {
      if (i1 == 1) {
        this.b.startAnimation(this.f);
      }
      if (this.h == 2) {
        this.b.clearAnimation();
      }
      this.c.setText(this.q);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("state:");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("RefreshHeaderView", 1, ((StringBuilder)localObject).toString());
    this.h = paramInt;
  }
  
  public void setVisibleHeight(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt < 0) {
      i1 = 0;
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.a.getLayoutParams();
    localLayoutParams.height = i1;
    this.a.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.part.block.base.RefreshHeaderView
 * JD-Core Version:    0.7.0.1
 */