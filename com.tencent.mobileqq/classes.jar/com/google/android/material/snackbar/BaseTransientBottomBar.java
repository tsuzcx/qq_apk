package com.google.android.material.snackbar;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams;
import androidx.core.view.ViewCompat;
import com.google.android.material.R.attr;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.behavior.SwipeDismissBehavior;
import java.util.List;

public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>>
{
  @NonNull
  static final Handler a = new Handler(Looper.getMainLooper(), new BaseTransientBottomBar.1());
  private static final boolean d;
  private static final int[] e;
  private static final String f;
  @NonNull
  protected final BaseTransientBottomBar.SnackbarBaseLayout b;
  @NonNull
  SnackbarManager.Callback c;
  @NonNull
  private final ViewGroup g;
  private final Context h;
  @NonNull
  private final ContentViewCallback i;
  private boolean j;
  @Nullable
  private View k;
  private boolean l;
  @RequiresApi(29)
  private final Runnable m;
  @Nullable
  private Rect n;
  private int o;
  private int p;
  private int q;
  private int r;
  private int s;
  private List<BaseTransientBottomBar.BaseCallback<B>> t;
  private BaseTransientBottomBar.Behavior u;
  @Nullable
  private final AccessibilityManager v;
  
  static
  {
    boolean bool;
    if ((Build.VERSION.SDK_INT >= 16) && (Build.VERSION.SDK_INT <= 19)) {
      bool = true;
    } else {
      bool = false;
    }
    d = bool;
    e = new int[] { R.attr.R };
    f = BaseTransientBottomBar.class.getSimpleName();
  }
  
  private ValueAnimator a(float... paramVarArgs)
  {
    paramVarArgs = ValueAnimator.ofFloat(paramVarArgs);
    paramVarArgs.setInterpolator(AnimationUtils.a);
    paramVarArgs.addUpdateListener(new BaseTransientBottomBar.13(this));
    return paramVarArgs;
  }
  
  private void a(CoordinatorLayout.LayoutParams paramLayoutParams)
  {
    BaseTransientBottomBar.Behavior localBehavior = this.u;
    Object localObject = localBehavior;
    if (localBehavior == null) {
      localObject = c();
    }
    if ((localObject instanceof BaseTransientBottomBar.Behavior)) {
      BaseTransientBottomBar.Behavior.a((BaseTransientBottomBar.Behavior)localObject, this);
    }
    ((SwipeDismissBehavior)localObject).a(new BaseTransientBottomBar.9(this));
    paramLayoutParams.setBehavior((CoordinatorLayout.Behavior)localObject);
    if (this.k == null) {
      paramLayoutParams.insetEdge = 80;
    }
  }
  
  private ValueAnimator b(float... paramVarArgs)
  {
    paramVarArgs = ValueAnimator.ofFloat(paramVarArgs);
    paramVarArgs.setInterpolator(AnimationUtils.d);
    paramVarArgs.addUpdateListener(new BaseTransientBottomBar.14(this));
    return paramVarArgs;
  }
  
  private void d(int paramInt)
  {
    if (this.b.getAnimationMode() == 1)
    {
      e(paramInt);
      return;
    }
    f(paramInt);
  }
  
  private void e(int paramInt)
  {
    ValueAnimator localValueAnimator = a(new float[] { 1.0F, 0.0F });
    localValueAnimator.setDuration(75L);
    localValueAnimator.addListener(new BaseTransientBottomBar.12(this, paramInt));
    localValueAnimator.start();
  }
  
  private void f(int paramInt)
  {
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setIntValues(new int[] { 0, s() });
    localValueAnimator.setInterpolator(AnimationUtils.b);
    localValueAnimator.setDuration(250L);
    localValueAnimator.addListener(new BaseTransientBottomBar.17(this, paramInt));
    localValueAnimator.addUpdateListener(new BaseTransientBottomBar.18(this));
    localValueAnimator.start();
  }
  
  private void j()
  {
    Object localObject = this.b.getLayoutParams();
    if (((localObject instanceof ViewGroup.MarginLayoutParams)) && (this.n != null))
    {
      int i1;
      if (this.k != null) {
        i1 = this.s;
      } else {
        i1 = this.o;
      }
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = (this.n.bottom + i1);
      ((ViewGroup.MarginLayoutParams)localObject).leftMargin = (this.n.left + this.p);
      ((ViewGroup.MarginLayoutParams)localObject).rightMargin = (this.n.right + this.q);
      this.b.requestLayout();
      if ((Build.VERSION.SDK_INT >= 29) && (k()))
      {
        this.b.removeCallbacks(this.m);
        this.b.post(this.m);
      }
      return;
    }
    Log.w(f, "Unable to update margins because layout params are not MarginLayoutParams");
  }
  
  private boolean k()
  {
    return (this.r > 0) && (!this.j) && (l());
  }
  
  private boolean l()
  {
    ViewGroup.LayoutParams localLayoutParams = this.b.getLayoutParams();
    return ((localLayoutParams instanceof CoordinatorLayout.LayoutParams)) && ((((CoordinatorLayout.LayoutParams)localLayoutParams).getBehavior() instanceof SwipeDismissBehavior));
  }
  
  private void m()
  {
    if (g())
    {
      e();
      return;
    }
    if (this.b.getParent() != null) {
      this.b.setVisibility(0);
    }
    f();
  }
  
  private int n()
  {
    int[] arrayOfInt = new int[2];
    this.b.getLocationOnScreen(arrayOfInt);
    return arrayOfInt[1] + this.b.getHeight();
  }
  
  @RequiresApi(17)
  private int o()
  {
    WindowManager localWindowManager = (WindowManager)this.h.getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localWindowManager.getDefaultDisplay().getRealMetrics(localDisplayMetrics);
    return localDisplayMetrics.heightPixels;
  }
  
  private int p()
  {
    Object localObject = this.k;
    if (localObject == null) {
      return 0;
    }
    int[] arrayOfInt = new int[2];
    ((View)localObject).getLocationOnScreen(arrayOfInt);
    int i1 = arrayOfInt[1];
    localObject = new int[2];
    this.g.getLocationOnScreen((int[])localObject);
    return localObject[1] + this.g.getHeight() - i1;
  }
  
  private void q()
  {
    ValueAnimator localValueAnimator1 = a(new float[] { 0.0F, 1.0F });
    ValueAnimator localValueAnimator2 = b(new float[] { 0.8F, 1.0F });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localValueAnimator1, localValueAnimator2 });
    localAnimatorSet.setDuration(150L);
    localAnimatorSet.addListener(new BaseTransientBottomBar.11(this));
    localAnimatorSet.start();
  }
  
  private void r()
  {
    int i1 = s();
    if (d) {
      ViewCompat.offsetTopAndBottom(this.b, i1);
    } else {
      this.b.setTranslationY(i1);
    }
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setIntValues(new int[] { i1, 0 });
    localValueAnimator.setInterpolator(AnimationUtils.b);
    localValueAnimator.setDuration(250L);
    localValueAnimator.addListener(new BaseTransientBottomBar.15(this));
    localValueAnimator.addUpdateListener(new BaseTransientBottomBar.16(this, i1));
    localValueAnimator.start();
  }
  
  private int s()
  {
    int i2 = this.b.getHeight();
    ViewGroup.LayoutParams localLayoutParams = this.b.getLayoutParams();
    int i1 = i2;
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      i1 = i2 + ((ViewGroup.MarginLayoutParams)localLayoutParams).bottomMargin;
    }
    return i1;
  }
  
  public void a()
  {
    a(3);
  }
  
  protected void a(int paramInt)
  {
    SnackbarManager.a().a(this.c, paramInt);
  }
  
  final void b(int paramInt)
  {
    if ((g()) && (this.b.getVisibility() == 0))
    {
      d(paramInt);
      return;
    }
    c(paramInt);
  }
  
  public boolean b()
  {
    return SnackbarManager.a().e(this.c);
  }
  
  @NonNull
  protected SwipeDismissBehavior<? extends View> c()
  {
    return new BaseTransientBottomBar.Behavior();
  }
  
  void c(int paramInt)
  {
    SnackbarManager.a().a(this.c);
    Object localObject = this.t;
    if (localObject != null)
    {
      int i1 = ((List)localObject).size() - 1;
      while (i1 >= 0)
      {
        ((BaseTransientBottomBar.BaseCallback)this.t.get(i1)).a(this, paramInt);
        i1 -= 1;
      }
    }
    localObject = this.b.getParent();
    if ((localObject instanceof ViewGroup)) {
      ((ViewGroup)localObject).removeView(this.b);
    }
  }
  
  final void d()
  {
    this.b.setOnAttachStateChangeListener(new BaseTransientBottomBar.7(this));
    if (this.b.getParent() == null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.b.getLayoutParams();
      if ((localLayoutParams instanceof CoordinatorLayout.LayoutParams)) {
        a((CoordinatorLayout.LayoutParams)localLayoutParams);
      }
      this.s = p();
      j();
      this.b.setVisibility(4);
      this.g.addView(this.b);
    }
    if (ViewCompat.isLaidOut(this.b))
    {
      m();
      return;
    }
    this.b.setOnLayoutChangeListener(new BaseTransientBottomBar.8(this));
  }
  
  void e()
  {
    this.b.post(new BaseTransientBottomBar.10(this));
  }
  
  void f()
  {
    SnackbarManager.a().b(this.c);
    List localList = this.t;
    if (localList != null)
    {
      int i1 = localList.size() - 1;
      while (i1 >= 0)
      {
        ((BaseTransientBottomBar.BaseCallback)this.t.get(i1)).a(this);
        i1 -= 1;
      }
    }
  }
  
  boolean g()
  {
    Object localObject = this.v;
    if (localObject == null) {
      return true;
    }
    localObject = ((AccessibilityManager)localObject).getEnabledAccessibilityServiceList(1);
    return (localObject != null) && (((List)localObject).isEmpty());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.snackbar.BaseTransientBottomBar
 * JD-Core Version:    0.7.0.1
 */