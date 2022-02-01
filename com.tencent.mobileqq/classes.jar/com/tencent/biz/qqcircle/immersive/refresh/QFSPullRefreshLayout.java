package com.tencent.biz.qqcircle.immersive.refresh;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;

public class QFSPullRefreshLayout
  extends FrameLayout
{
  private boolean A;
  private View a;
  private QFSPullRefreshLayout.OnRefreshListener b;
  private FrameLayout c;
  private IQFSRefreshView d;
  private int e = 2;
  private boolean f = true;
  private float g = 0.0F;
  private int h = 3;
  private int i;
  private FrameLayout j;
  private IQFSRefreshView k;
  private int l = 2;
  private boolean m = true;
  private float n = 0.0F;
  private boolean o = false;
  private boolean p = true;
  private int q = 3;
  private boolean r = false;
  private float s;
  private float t;
  private float u;
  private float v = 2.0F;
  private QFSDefaultHeaderView w;
  private DefaultFooterView x;
  private ValueAnimator y;
  private ValueAnimator z;
  
  public QFSPullRefreshLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QFSPullRefreshLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (isInEditMode()) {
      return;
    }
    this.c = new FrameLayout(paramContext);
    this.j = new FrameLayout(paramContext);
  }
  
  private void a(float paramFloat1, float paramFloat2, Animator.AnimatorListener paramAnimatorListener)
  {
    int i1 = this.l;
    View[] arrayOfView;
    if (i1 == 1)
    {
      arrayOfView = new View[1];
      arrayOfView[0] = this.a;
    }
    else if (i1 == 3)
    {
      arrayOfView = new View[1];
      arrayOfView[0] = this.j;
    }
    else
    {
      arrayOfView = new View[2];
      arrayOfView[0] = this.a;
      arrayOfView[1] = this.j;
    }
    if (this.z == null) {
      this.z = new ValueAnimator();
    }
    this.z.setFloatValues(new float[] { paramFloat1, paramFloat2 });
    this.z.setDuration(300L);
    this.z.removeAllListeners();
    this.z.removeAllUpdateListeners();
    if (paramAnimatorListener != null) {
      this.z.addListener(paramAnimatorListener);
    }
    this.z.addUpdateListener(new QFSPullRefreshLayout.3(this, arrayOfView));
    this.z.start();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.j.getLayoutParams();
    int i1 = this.j.getMeasuredWidth();
    int i2 = this.j.getMeasuredHeight();
    if (this.l == 1)
    {
      paramInt1 += localLayoutParams.leftMargin;
      paramInt2 = paramInt2 - localLayoutParams.bottomMargin - i2;
    }
    else
    {
      paramInt1 += localLayoutParams.leftMargin;
      paramInt2 -= localLayoutParams.bottomMargin;
    }
    this.j.layout(paramInt1, paramInt2, i1 + paramInt1, i2 + paramInt2);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if (this.r) {
      a(paramMotionEvent, 0.0F);
    }
    float f1;
    float f2;
    if (k())
    {
      f1 = getHeaderTransY();
      f2 = this.g;
      if (f1 >= f2)
      {
        b(f1, f2, new QFSPullRefreshLayout.1(this));
        return;
      }
      b(f1, 0.0F, null);
      return;
    }
    if (l())
    {
      f1 = getFooterTransY();
      f2 = -f1;
      float f3 = this.n;
      if (f2 >= f3)
      {
        a(f1, -f3, new QFSPullRefreshLayout.2(this));
        return;
      }
      a(f1, 0.0F, null);
    }
  }
  
  private void a(MotionEvent paramMotionEvent, float paramFloat)
  {
    if (this.r)
    {
      this.a.dispatchTouchEvent(paramMotionEvent);
      return;
    }
    if (paramFloat > 0.0F) {
      paramMotionEvent.setLocation(paramMotionEvent.getX(), paramMotionEvent.getY() - ViewConfiguration.get(getContext()).getScaledTouchSlop() - paramFloat);
    } else if (paramFloat < 0.0F) {
      paramMotionEvent.setLocation(paramMotionEvent.getX(), paramMotionEvent.getY() + ViewConfiguration.get(getContext()).getScaledTouchSlop() - paramFloat);
    }
    paramMotionEvent.setAction(0);
    this.a.dispatchTouchEvent(paramMotionEvent);
    paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
    paramMotionEvent.setAction(2);
    this.a.dispatchTouchEvent(paramMotionEvent);
    paramMotionEvent.recycle();
    this.r = true;
  }
  
  private void b(float paramFloat1, float paramFloat2, Animator.AnimatorListener paramAnimatorListener)
  {
    int i1 = this.e;
    View[] arrayOfView;
    if (i1 == 1)
    {
      arrayOfView = new View[1];
      arrayOfView[0] = this.a;
    }
    else if (i1 == 3)
    {
      arrayOfView = new View[1];
      arrayOfView[0] = this.c;
    }
    else
    {
      arrayOfView = new View[2];
      arrayOfView[0] = this.a;
      arrayOfView[1] = this.c;
    }
    if (this.y == null) {
      this.y = new ValueAnimator();
    }
    this.y.setFloatValues(new float[] { paramFloat1, paramFloat2 });
    this.y.setDuration(300L);
    this.y.removeAllListeners();
    this.y.removeAllUpdateListeners();
    if (paramAnimatorListener != null) {
      this.y.addListener(paramAnimatorListener);
    }
    this.y.addUpdateListener(new QFSPullRefreshLayout.4(this, arrayOfView));
    this.y.start();
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.c.getLayoutParams();
    int i1 = this.c.getMeasuredWidth();
    int i2 = this.c.getMeasuredHeight();
    if (this.e == 1)
    {
      paramInt1 += localLayoutParams.leftMargin;
      paramInt2 += localLayoutParams.topMargin;
    }
    else
    {
      paramInt1 += localLayoutParams.leftMargin;
      paramInt2 = paramInt2 + localLayoutParams.topMargin - i2;
    }
    this.c.layout(paramInt1, paramInt2, i1 + paramInt1, i2 + paramInt2);
  }
  
  private void c(float paramFloat, MotionEvent paramMotionEvent)
  {
    if (k())
    {
      a(getHeaderTransY() + paramFloat, paramMotionEvent);
      return;
    }
    if (l())
    {
      b(getFooterTransY() + paramFloat, paramMotionEvent);
      return;
    }
    if (paramFloat < 0.0F)
    {
      if ((!p()) && (this.m))
      {
        if (this.o) {
          n();
        }
        b(getFooterTransY() + paramFloat, paramMotionEvent);
        return;
      }
      a(paramMotionEvent, paramFloat);
      return;
    }
    if (paramFloat > 0.0F)
    {
      if ((!o()) && (this.f))
      {
        a(getHeaderTransY() + paramFloat, paramMotionEvent);
        return;
      }
      a(paramMotionEvent, paramFloat);
    }
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.a.getLayoutParams();
    int i1 = this.a.getMeasuredWidth();
    int i2 = this.a.getMeasuredHeight();
    paramInt1 += localLayoutParams.leftMargin;
    paramInt2 += localLayoutParams.topMargin;
    this.a.layout(paramInt1, paramInt2, i1 + paramInt1, i2 + paramInt2);
  }
  
  private float getFooterTransY()
  {
    int i1 = this.l;
    if (i1 == 1) {
      return this.a.getTranslationY();
    }
    if (i1 == 3) {
      return this.j.getTranslationY();
    }
    return this.j.getTranslationY();
  }
  
  private float getHeaderTransY()
  {
    int i1 = this.e;
    if (i1 == 1) {
      return this.a.getTranslationY();
    }
    if (i1 == 3) {
      return this.c.getTranslationY();
    }
    return this.c.getTranslationY();
  }
  
  private void h()
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.a.getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    localLayoutParams.topMargin = this.i;
    if (this.e == 1) {
      addView(this.c, 0, localLayoutParams);
    } else {
      addView(this.c, localLayoutParams);
    }
    localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    if (this.l == 1)
    {
      addView(this.j, 0, localLayoutParams);
      return;
    }
    addView(this.j, localLayoutParams);
  }
  
  private void i()
  {
    if ((this.f) && (this.d == null))
    {
      if (this.w == null) {
        this.w = new QFSDefaultHeaderView(getContext());
      }
      setHeaderView(this.w, this.e);
    }
    if ((this.m) && (this.k == null))
    {
      if (this.x == null) {
        this.x = new DefaultFooterView(getContext());
      }
      setFooterView(this.x, this.l);
    }
  }
  
  private void j()
  {
    if (this.h == 3)
    {
      this.h = 1;
      this.d.a(this);
    }
    if (this.q == 3)
    {
      this.q = 1;
      IQFSRefreshView localIQFSRefreshView = this.k;
      if (localIQFSRefreshView != null) {
        localIQFSRefreshView.a(this);
      }
    }
  }
  
  private boolean k()
  {
    return getHeaderTransY() > 0.0F;
  }
  
  private boolean l()
  {
    return getFooterTransY() < 0.0F;
  }
  
  private void m()
  {
    if (this.h != 2)
    {
      this.h = 2;
      Object localObject = this.d;
      if (localObject != null) {
        ((IQFSRefreshView)localObject).b(this);
      }
      localObject = this.b;
      if (localObject != null) {
        ((QFSPullRefreshLayout.OnRefreshListener)localObject).a(this);
      }
    }
  }
  
  private void n()
  {
    if (this.q != 2)
    {
      this.q = 2;
      Object localObject = this.k;
      if (localObject != null) {
        ((IQFSRefreshView)localObject).b(this);
      }
      localObject = this.b;
      if (localObject != null) {
        ((QFSPullRefreshLayout.OnRefreshListener)localObject).b(this);
      }
    }
  }
  
  private boolean o()
  {
    Object localObject = this.a;
    boolean bool1 = false;
    boolean bool2 = false;
    if (localObject == null) {
      return false;
    }
    if ((localObject instanceof AbsListView))
    {
      localObject = (AbsListView)localObject;
      bool1 = bool2;
      if (((AbsListView)localObject).getChildCount() > 0) {
        if (((AbsListView)localObject).getFirstVisiblePosition() <= 0)
        {
          bool1 = bool2;
          if (((AbsListView)localObject).getChildAt(0).getTop() >= ((AbsListView)localObject).getPaddingTop()) {}
        }
        else
        {
          bool1 = true;
        }
      }
      return bool1;
    }
    if ((((View)localObject).canScrollVertically(-1)) || (this.a.getScrollY() > 0)) {
      bool1 = true;
    }
    return bool1;
  }
  
  private boolean p()
  {
    View localView = this.a;
    if (localView == null) {
      return false;
    }
    return localView.canScrollVertically(1);
  }
  
  protected void a(float paramFloat, MotionEvent paramMotionEvent)
  {
    if (this.r)
    {
      paramMotionEvent.setAction(3);
      this.a.dispatchTouchEvent(paramMotionEvent);
      this.r = false;
    }
    float f2 = paramFloat / this.g;
    if (f2 > 2.0F) {
      return;
    }
    float f1 = paramFloat;
    if (paramFloat < 0.0F)
    {
      a(paramMotionEvent, paramFloat);
      f1 = 0.0F;
    }
    paramMotionEvent = this.d;
    if ((paramMotionEvent != null) && (this.h == 1)) {
      paramMotionEvent.a(this, f2);
    }
    int i1 = this.e;
    if (i1 == 1)
    {
      this.a.setTranslationY(f1);
      return;
    }
    if (i1 == 3)
    {
      this.c.setTranslationY(f1);
      return;
    }
    this.c.setTranslationY(f1);
    this.a.setTranslationY(f1);
  }
  
  public void a(long paramLong)
  {
    if (this.h != 2)
    {
      if (getHeaderTransY() > 0.0F) {
        return;
      }
      postDelayed(new QFSPullRefreshLayout.5(this), paramLong);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.p = paramBoolean;
    if ((this.a != null) && (this.q == 2))
    {
      IQFSRefreshView localIQFSRefreshView = this.k;
      if (localIQFSRefreshView != null) {
        localIQFSRefreshView.a(this, paramBoolean);
      }
      RFThreadManager.getUIHandler().postDelayed(new QFSPullRefreshLayout.6(this), 200L);
    }
  }
  
  public boolean a()
  {
    return this.m;
  }
  
  protected void b(float paramFloat, MotionEvent paramMotionEvent)
  {
    if (this.r)
    {
      MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
      localMotionEvent.setAction(3);
      this.a.dispatchTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
      this.r = false;
    }
    float f2 = -paramFloat / this.n;
    if (f2 > 2.0F) {
      return;
    }
    float f1 = paramFloat;
    if (paramFloat > 0.0F)
    {
      a(paramMotionEvent, paramFloat);
      f1 = 0.0F;
    }
    paramMotionEvent = this.k;
    if ((paramMotionEvent != null) && (this.q == 1)) {
      paramMotionEvent.a(this, f2);
    }
    int i1 = this.l;
    if (i1 == 1)
    {
      this.a.setTranslationY(f1);
      return;
    }
    if (i1 == 3)
    {
      this.j.setTranslationY(f1);
      return;
    }
    this.j.setTranslationY(f1);
    this.a.setTranslationY(f1);
  }
  
  public void b(boolean paramBoolean)
  {
    this.p = paramBoolean;
    if ((this.a != null) && (this.h == 2))
    {
      IQFSRefreshView localIQFSRefreshView = this.d;
      if (localIQFSRefreshView != null) {
        localIQFSRefreshView.a(this, true);
      }
      RFThreadManager.getUIHandler().postDelayed(new QFSPullRefreshLayout.7(this), 200L);
    }
  }
  
  public boolean b()
  {
    return this.h == 2;
  }
  
  public void c(boolean paramBoolean)
  {
    this.A = paramBoolean;
  }
  
  public boolean c()
  {
    return this.q == 2;
  }
  
  public boolean d()
  {
    return this.p;
  }
  
  public void e()
  {
    a(0L);
  }
  
  public void f()
  {
    IQFSRefreshView localIQFSRefreshView = this.k;
    if ((localIQFSRefreshView != null) && (localIQFSRefreshView.getRefreshView() != null)) {
      this.k.getRefreshView().setVisibility(8);
    }
  }
  
  public void g()
  {
    IQFSRefreshView localIQFSRefreshView = this.k;
    if ((localIQFSRefreshView != null) && (localIQFSRefreshView.getRefreshView() != null) && (a())) {
      this.k.getRefreshView().setVisibility(0);
    }
  }
  
  public DefaultFooterView getDefaultFooterView()
  {
    return this.x;
  }
  
  public QFSDefaultHeaderView getDefaultHeaderView()
  {
    return this.w;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (getChildCount() == 1)
    {
      this.a = getChildAt(0);
      h();
      i();
      return;
    }
    throw new RuntimeException("can only have one child widget");
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeView(this.c);
    removeView(this.j);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.A) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    if (b()) {
      return true;
    }
    int i1 = paramMotionEvent.getActionMasked();
    if (i1 != 0)
    {
      if (i1 == 2)
      {
        if (this.a == null) {
          return false;
        }
        i1 = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        if (Math.abs(paramMotionEvent.getY() - this.u) < i1) {
          return false;
        }
        this.s = paramMotionEvent.getX();
        this.t = paramMotionEvent.getY();
        return true;
      }
    }
    else
    {
      this.r = false;
      this.u = paramMotionEvent.getY();
      j();
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = getPaddingLeft();
    paramInt3 = getPaddingTop();
    int i1 = getPaddingBottom();
    c(paramInt1, paramInt3);
    b(paramInt1, paramInt3);
    a(paramInt1, paramInt4 - paramInt2 - i1);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.g <= 0.0F) {
      this.g = this.c.getMeasuredHeight();
    }
    if (this.n <= 0.0F) {
      this.n = this.j.getMeasuredHeight();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (b()) {
      return true;
    }
    int i1 = paramMotionEvent.getActionMasked();
    if (i1 != 0)
    {
      if (i1 != 1) {
        if (i1 != 2)
        {
          if ((i1 != 3) && (i1 != 6)) {
            return super.onTouchEvent(paramMotionEvent);
          }
        }
        else
        {
          float f1 = paramMotionEvent.getX();
          float f2 = paramMotionEvent.getY();
          float f3 = this.t;
          this.s = f1;
          this.t = f2;
          f1 = (float)Math.rint((f2 - f3) / this.v);
          if (f1 == 0.0F) {
            return true;
          }
          c(f1, paramMotionEvent);
          return true;
        }
      }
      a(paramMotionEvent);
      return true;
    }
    this.s = paramMotionEvent.getX();
    this.t = paramMotionEvent.getY();
    return true;
  }
  
  public void setAutoLoadEnable(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  public void setFooterPosition(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void setFooterView(IQFSRefreshView paramIQFSRefreshView)
  {
    setFooterView(paramIQFSRefreshView, 2, null);
  }
  
  public void setFooterView(IQFSRefreshView paramIQFSRefreshView, int paramInt)
  {
    setFooterView(paramIQFSRefreshView, paramInt, null);
  }
  
  public void setFooterView(IQFSRefreshView paramIQFSRefreshView, int paramInt, FrameLayout.LayoutParams paramLayoutParams)
  {
    if (paramIQFSRefreshView != null)
    {
      if (paramIQFSRefreshView.getRefreshView() == null) {
        return;
      }
      this.l = paramInt;
      this.k = paramIQFSRefreshView;
      this.n = paramIQFSRefreshView.getStartRefreshDistance();
      this.j.removeAllViews();
      if (paramLayoutParams != null)
      {
        this.j.addView(paramIQFSRefreshView.getRefreshView(), paramLayoutParams);
        return;
      }
      this.j.addView(paramIQFSRefreshView.getRefreshView());
    }
  }
  
  public void setHeaderPosition(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setHeaderView(IQFSRefreshView paramIQFSRefreshView)
  {
    setHeaderView(paramIQFSRefreshView, 2, null);
  }
  
  public void setHeaderView(IQFSRefreshView paramIQFSRefreshView, int paramInt)
  {
    setHeaderView(paramIQFSRefreshView, paramInt, null);
  }
  
  public void setHeaderView(IQFSRefreshView paramIQFSRefreshView, int paramInt, FrameLayout.LayoutParams paramLayoutParams)
  {
    if (paramIQFSRefreshView != null)
    {
      if (paramIQFSRefreshView.getRefreshView() == null) {
        return;
      }
      this.d = paramIQFSRefreshView;
      this.e = paramInt;
      this.g = paramIQFSRefreshView.getStartRefreshDistance();
      this.c.removeAllViews();
      if (paramLayoutParams != null)
      {
        this.c.addView(paramIQFSRefreshView.getRefreshView(), paramLayoutParams);
        return;
      }
      this.c.addView(paramIQFSRefreshView.getRefreshView());
    }
  }
  
  public void setHeaderViewMarginTop(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void setLoadMoreEnable(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public void setOffsetRadio(float paramFloat)
  {
    this.v = paramFloat;
  }
  
  public void setOnRefreshListener(QFSPullRefreshLayout.OnRefreshListener paramOnRefreshListener)
  {
    this.b = paramOnRefreshListener;
  }
  
  public void setRefreshEnable(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void setStartLoadMoreDistance(float paramFloat)
  {
    this.n = paramFloat;
  }
  
  public void setStartRefreshDistance(float paramFloat)
  {
    this.g = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.refresh.QFSPullRefreshLayout
 * JD-Core Version:    0.7.0.1
 */