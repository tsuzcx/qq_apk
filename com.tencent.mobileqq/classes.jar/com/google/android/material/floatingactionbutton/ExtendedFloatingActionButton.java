package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.core.view.ViewCompat;
import com.google.android.material.R.attr;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearanceModel.Builder;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.Iterator;
import java.util.List;

public class ExtendedFloatingActionButton
  extends MaterialButton
  implements CoordinatorLayout.AttachedBehavior
{
  static final Property<View, Float> b = new ExtendedFloatingActionButton.4(Float.class, "width");
  static final Property<View, Float> c = new ExtendedFloatingActionButton.5(Float.class, "height");
  static final Property<View, Float> d = new ExtendedFloatingActionButton.6(Float.class, "paddingStart");
  static final Property<View, Float> e = new ExtendedFloatingActionButton.7(Float.class, "paddingEnd");
  private static final int f = R.style.D;
  @NonNull
  protected ColorStateList a;
  private int g = 0;
  private final AnimatorTracker h = new AnimatorTracker();
  @NonNull
  private final MotionStrategy i;
  @NonNull
  private final MotionStrategy j;
  private final MotionStrategy k = new ExtendedFloatingActionButton.ShowStrategy(this, this.h);
  private final MotionStrategy l = new ExtendedFloatingActionButton.HideStrategy(this, this.h);
  private final int m;
  private int n;
  private int o;
  @NonNull
  private final CoordinatorLayout.Behavior<ExtendedFloatingActionButton> p;
  private boolean q = true;
  private boolean r = false;
  private boolean s = false;
  
  public ExtendedFloatingActionButton(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ExtendedFloatingActionButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.x);
  }
  
  public ExtendedFloatingActionButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, f), paramAttributeSet, paramInt);
    paramContext = getContext();
    this.p = new ExtendedFloatingActionButton.ExtendedFloatingActionButtonBehavior(paramContext, paramAttributeSet);
    TypedArray localTypedArray = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.cw, paramInt, f, new int[0]);
    MotionSpec localMotionSpec1 = MotionSpec.a(paramContext, localTypedArray, R.styleable.cA);
    MotionSpec localMotionSpec2 = MotionSpec.a(paramContext, localTypedArray, R.styleable.cz);
    MotionSpec localMotionSpec3 = MotionSpec.a(paramContext, localTypedArray, R.styleable.cy);
    MotionSpec localMotionSpec4 = MotionSpec.a(paramContext, localTypedArray, R.styleable.cB);
    this.m = localTypedArray.getDimensionPixelSize(R.styleable.cx, -1);
    this.n = ViewCompat.getPaddingStart(this);
    this.o = ViewCompat.getPaddingEnd(this);
    AnimatorTracker localAnimatorTracker = new AnimatorTracker();
    this.j = new ExtendedFloatingActionButton.ChangeSizeStrategy(this, localAnimatorTracker, new ExtendedFloatingActionButton.1(this), true);
    this.i = new ExtendedFloatingActionButton.ChangeSizeStrategy(this, localAnimatorTracker, new ExtendedFloatingActionButton.2(this), false);
    this.k.a(localMotionSpec1);
    this.l.a(localMotionSpec2);
    this.j.a(localMotionSpec3);
    this.i.a(localMotionSpec4);
    localTypedArray.recycle();
    setShapeAppearanceModel(ShapeAppearanceModel.a(paramContext, paramAttributeSet, paramInt, f, ShapeAppearanceModel.a).a());
    b();
  }
  
  private void a(@NonNull MotionStrategy paramMotionStrategy, @Nullable ExtendedFloatingActionButton.OnChangedCallback paramOnChangedCallback)
  {
    if (paramMotionStrategy.i()) {
      return;
    }
    if (!e())
    {
      paramMotionStrategy.g();
      paramMotionStrategy.a(paramOnChangedCallback);
      return;
    }
    measure(0, 0);
    AnimatorSet localAnimatorSet = paramMotionStrategy.f();
    localAnimatorSet.addListener(new ExtendedFloatingActionButton.3(this, paramMotionStrategy, paramOnChangedCallback));
    paramMotionStrategy = paramMotionStrategy.b().iterator();
    while (paramMotionStrategy.hasNext()) {
      localAnimatorSet.addListener((Animator.AnimatorListener)paramMotionStrategy.next());
    }
    localAnimatorSet.start();
  }
  
  private void b()
  {
    this.a = getTextColors();
  }
  
  private boolean c()
  {
    int i1 = getVisibility();
    boolean bool2 = false;
    boolean bool1 = false;
    if (i1 != 0)
    {
      if (this.g == 2) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool2;
    if (this.g != 1) {
      bool1 = true;
    }
    return bool1;
  }
  
  private boolean d()
  {
    int i1 = getVisibility();
    boolean bool2 = false;
    boolean bool1 = false;
    if (i1 == 0)
    {
      if (this.g == 1) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool2;
    if (this.g != 2) {
      bool1 = true;
    }
    return bool1;
  }
  
  private boolean e()
  {
    return ((ViewCompat.isLaidOut(this)) || ((!c()) && (this.s))) && (!isInEditMode());
  }
  
  protected void a(@NonNull ColorStateList paramColorStateList)
  {
    super.setTextColor(paramColorStateList);
  }
  
  @NonNull
  public CoordinatorLayout.Behavior<ExtendedFloatingActionButton> getBehavior()
  {
    return this.p;
  }
  
  int getCollapsedPadding()
  {
    return (getCollapsedSize() - getIconSize()) / 2;
  }
  
  @VisibleForTesting
  int getCollapsedSize()
  {
    int i2 = this.m;
    int i1 = i2;
    if (i2 < 0) {
      i1 = Math.min(ViewCompat.getPaddingStart(this), ViewCompat.getPaddingEnd(this)) * 2 + getIconSize();
    }
    return i1;
  }
  
  @Nullable
  public MotionSpec getExtendMotionSpec()
  {
    return this.j.c();
  }
  
  @Nullable
  public MotionSpec getHideMotionSpec()
  {
    return this.l.c();
  }
  
  @Nullable
  public MotionSpec getShowMotionSpec()
  {
    return this.k.c();
  }
  
  @Nullable
  public MotionSpec getShrinkMotionSpec()
  {
    return this.i.c();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.q) && (TextUtils.isEmpty(getText())) && (getIcon() != null))
    {
      this.q = false;
      this.i.g();
    }
  }
  
  public void setAnimateShowBeforeLayout(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }
  
  public void setExtendMotionSpec(@Nullable MotionSpec paramMotionSpec)
  {
    this.j.a(paramMotionSpec);
  }
  
  public void setExtendMotionSpecResource(@AnimatorRes int paramInt)
  {
    setExtendMotionSpec(MotionSpec.a(getContext(), paramInt));
  }
  
  public void setExtended(boolean paramBoolean)
  {
    if (this.q == paramBoolean) {
      return;
    }
    MotionStrategy localMotionStrategy;
    if (paramBoolean) {
      localMotionStrategy = this.j;
    } else {
      localMotionStrategy = this.i;
    }
    if (localMotionStrategy.i()) {
      return;
    }
    localMotionStrategy.g();
  }
  
  public void setHideMotionSpec(@Nullable MotionSpec paramMotionSpec)
  {
    this.l.a(paramMotionSpec);
  }
  
  public void setHideMotionSpecResource(@AnimatorRes int paramInt)
  {
    setHideMotionSpec(MotionSpec.a(getContext(), paramInt));
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.q) && (!this.r))
    {
      this.n = ViewCompat.getPaddingStart(this);
      this.o = ViewCompat.getPaddingEnd(this);
    }
  }
  
  public void setPaddingRelative(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setPaddingRelative(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.q) && (!this.r))
    {
      this.n = paramInt1;
      this.o = paramInt3;
    }
  }
  
  public void setShowMotionSpec(@Nullable MotionSpec paramMotionSpec)
  {
    this.k.a(paramMotionSpec);
  }
  
  public void setShowMotionSpecResource(@AnimatorRes int paramInt)
  {
    setShowMotionSpec(MotionSpec.a(getContext(), paramInt));
  }
  
  public void setShrinkMotionSpec(@Nullable MotionSpec paramMotionSpec)
  {
    this.i.a(paramMotionSpec);
  }
  
  public void setShrinkMotionSpecResource(@AnimatorRes int paramInt)
  {
    setShrinkMotionSpec(MotionSpec.a(getContext(), paramInt));
  }
  
  public void setTextColor(int paramInt)
  {
    super.setTextColor(paramInt);
    b();
  }
  
  public void setTextColor(@NonNull ColorStateList paramColorStateList)
  {
    super.setTextColor(paramColorStateList);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
 * JD-Core Version:    0.7.0.1
 */