package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback;
import com.google.android.material.R.attr;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.Arrays;

public abstract class BaseProgressIndicator<S extends BaseProgressIndicatorSpec>
  extends ProgressBar
{
  static final int a = R.style.H;
  S b;
  AnimatorDurationScaleProvider c;
  private int d;
  private boolean e;
  private boolean f;
  private final int g;
  private final int h;
  private long i = -1L;
  private boolean j = false;
  private int k = 4;
  private final Runnable l = new BaseProgressIndicator.1(this);
  private final Runnable m = new BaseProgressIndicator.2(this);
  private final Animatable2Compat.AnimationCallback n = new BaseProgressIndicator.3(this);
  private final Animatable2Compat.AnimationCallback o = new BaseProgressIndicator.4(this);
  
  protected BaseProgressIndicator(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt1, @StyleRes int paramInt2)
  {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt1, a), paramAttributeSet, paramInt1);
    paramContext = getContext();
    this.b = a(paramContext, paramAttributeSet);
    paramContext = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.K, paramInt1, paramInt2, new int[0]);
    this.g = paramContext.getInt(R.styleable.P, -1);
    this.h = Math.min(paramContext.getInt(R.styleable.N, -1), 1000);
    paramContext.recycle();
    this.c = new AnimatorDurationScaleProvider();
    this.f = true;
  }
  
  private void c()
  {
    if ((getProgressDrawable() != null) && (getIndeterminateDrawable() != null)) {
      getIndeterminateDrawable().a().a(this.n);
    }
    if (getProgressDrawable() != null) {
      getProgressDrawable().registerAnimationCallback(this.o);
    }
    if (getIndeterminateDrawable() != null) {
      getIndeterminateDrawable().registerAnimationCallback(this.o);
    }
  }
  
  private void d()
  {
    if (getIndeterminateDrawable() != null)
    {
      getIndeterminateDrawable().unregisterAnimationCallback(this.o);
      getIndeterminateDrawable().a().e();
    }
    if (getProgressDrawable() != null) {
      getProgressDrawable().unregisterAnimationCallback(this.o);
    }
  }
  
  private void e()
  {
    if (this.h > 0) {
      this.i = SystemClock.uptimeMillis();
    }
    setVisibility(0);
  }
  
  private void f()
  {
    ((DrawableWithAnimatedVisibilityChange)getCurrentDrawable()).b(false, false, true);
    if (g()) {
      setVisibility(4);
    }
  }
  
  private boolean g()
  {
    return ((getProgressDrawable() == null) || (!getProgressDrawable().isVisible())) && ((getIndeterminateDrawable() == null) || (!getIndeterminateDrawable().isVisible()));
  }
  
  @Nullable
  private DrawingDelegate<S> getCurrentDrawingDelegate()
  {
    if (isIndeterminate())
    {
      if (getIndeterminateDrawable() == null) {
        return null;
      }
      return getIndeterminateDrawable().f();
    }
    if (getProgressDrawable() == null) {
      return null;
    }
    return getProgressDrawable().a();
  }
  
  abstract S a(@NonNull Context paramContext, @NonNull AttributeSet paramAttributeSet);
  
  protected void a(boolean paramBoolean)
  {
    if (!this.f) {
      return;
    }
    ((DrawableWithAnimatedVisibilityChange)getCurrentDrawable()).b(a(), false, paramBoolean);
  }
  
  boolean a()
  {
    return (ViewCompat.isAttachedToWindow(this)) && (getWindowVisibility() == 0) && (b());
  }
  
  boolean b()
  {
    for (Object localObject = this;; localObject = (View)localObject)
    {
      if (((View)localObject).getVisibility() != 0) {
        return false;
      }
      localObject = ((View)localObject).getParent();
      if (localObject == null) {
        return getWindowVisibility() == 0;
      }
      if (!(localObject instanceof View)) {
        return true;
      }
    }
  }
  
  @Nullable
  public Drawable getCurrentDrawable()
  {
    if (isIndeterminate()) {
      return getIndeterminateDrawable();
    }
    return getProgressDrawable();
  }
  
  public int getHideAnimationBehavior()
  {
    return this.b.f;
  }
  
  @Nullable
  public IndeterminateDrawable<S> getIndeterminateDrawable()
  {
    return (IndeterminateDrawable)super.getIndeterminateDrawable();
  }
  
  @NonNull
  public int[] getIndicatorColor()
  {
    return this.b.c;
  }
  
  @Nullable
  public DeterminateDrawable<S> getProgressDrawable()
  {
    return (DeterminateDrawable)super.getProgressDrawable();
  }
  
  public int getShowAnimationBehavior()
  {
    return this.b.e;
  }
  
  @ColorInt
  public int getTrackColor()
  {
    return this.b.d;
  }
  
  @Px
  public int getTrackCornerRadius()
  {
    return this.b.b;
  }
  
  @Px
  public int getTrackThickness()
  {
    return this.b.a;
  }
  
  public void invalidate()
  {
    super.invalidate();
    if (getCurrentDrawable() != null) {
      getCurrentDrawable().invalidateSelf();
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    c();
    if (a()) {
      e();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.m);
    removeCallbacks(this.l);
    ((DrawableWithAnimatedVisibilityChange)getCurrentDrawable()).b();
    d();
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(@NonNull Canvas paramCanvas)
  {
    try
    {
      int i1 = paramCanvas.save();
      if ((getPaddingLeft() != 0) || (getPaddingTop() != 0)) {
        paramCanvas.translate(getPaddingLeft(), getPaddingTop());
      }
      if ((getPaddingRight() != 0) || (getPaddingBottom() != 0)) {
        paramCanvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
      }
      getCurrentDrawable().draw(paramCanvas);
      paramCanvas.restoreToCount(i1);
      return;
    }
    finally {}
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      DrawingDelegate localDrawingDelegate = getCurrentDrawingDelegate();
      if (localDrawingDelegate == null) {
        return;
      }
      paramInt1 = localDrawingDelegate.a();
      paramInt2 = localDrawingDelegate.b();
      if (paramInt1 < 0) {
        paramInt1 = getMeasuredWidth();
      } else {
        paramInt1 = paramInt1 + getPaddingLeft() + getPaddingRight();
      }
      if (paramInt2 < 0) {
        paramInt2 = getMeasuredHeight();
      } else {
        paramInt2 = paramInt2 + getPaddingTop() + getPaddingBottom();
      }
      setMeasuredDimension(paramInt1, paramInt2);
      return;
    }
    finally {}
  }
  
  protected void onVisibilityChanged(@NonNull View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    a(bool);
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    a(false);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  @VisibleForTesting
  public void setAnimatorDurationScaleProvider(@NonNull AnimatorDurationScaleProvider paramAnimatorDurationScaleProvider)
  {
    this.c = paramAnimatorDurationScaleProvider;
    if (getProgressDrawable() != null) {
      getProgressDrawable().c = paramAnimatorDurationScaleProvider;
    }
    if (getIndeterminateDrawable() != null) {
      getIndeterminateDrawable().c = paramAnimatorDurationScaleProvider;
    }
  }
  
  public void setHideAnimationBehavior(int paramInt)
  {
    this.b.f = paramInt;
    invalidate();
  }
  
  public void setIndeterminate(boolean paramBoolean)
  {
    try
    {
      boolean bool = isIndeterminate();
      if (paramBoolean == bool) {
        return;
      }
      if ((a()) && (paramBoolean)) {
        throw new IllegalStateException("Cannot switch to indeterminate mode while the progress indicator is visible.");
      }
      DrawableWithAnimatedVisibilityChange localDrawableWithAnimatedVisibilityChange = (DrawableWithAnimatedVisibilityChange)getCurrentDrawable();
      if (localDrawableWithAnimatedVisibilityChange != null) {
        localDrawableWithAnimatedVisibilityChange.b();
      }
      super.setIndeterminate(paramBoolean);
      localDrawableWithAnimatedVisibilityChange = (DrawableWithAnimatedVisibilityChange)getCurrentDrawable();
      if (localDrawableWithAnimatedVisibilityChange != null) {
        localDrawableWithAnimatedVisibilityChange.b(a(), false, false);
      }
      this.j = false;
      return;
    }
    finally {}
  }
  
  public void setIndeterminateDrawable(@Nullable Drawable paramDrawable)
  {
    if (paramDrawable == null)
    {
      super.setIndeterminateDrawable(null);
      return;
    }
    if ((paramDrawable instanceof IndeterminateDrawable))
    {
      ((DrawableWithAnimatedVisibilityChange)paramDrawable).b();
      super.setIndeterminateDrawable(paramDrawable);
      return;
    }
    throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
  }
  
  public void setIndicatorColor(@ColorInt int... paramVarArgs)
  {
    int[] arrayOfInt = paramVarArgs;
    if (paramVarArgs.length == 0)
    {
      arrayOfInt = new int[1];
      arrayOfInt[0] = MaterialColors.a(getContext(), R.attr.r, -1);
    }
    if (!Arrays.equals(getIndicatorColor(), arrayOfInt))
    {
      this.b.c = arrayOfInt;
      getIndeterminateDrawable().a().d();
      invalidate();
    }
  }
  
  public void setProgress(int paramInt)
  {
    try
    {
      boolean bool = isIndeterminate();
      if (bool) {
        return;
      }
      setProgressCompat(paramInt, false);
      return;
    }
    finally {}
  }
  
  public void setProgressCompat(int paramInt, boolean paramBoolean)
  {
    if (isIndeterminate())
    {
      if (getProgressDrawable() != null)
      {
        this.d = paramInt;
        this.e = paramBoolean;
        this.j = true;
        if ((getIndeterminateDrawable().isVisible()) && (this.c.a(getContext().getContentResolver()) != 0.0F))
        {
          getIndeterminateDrawable().a().c();
          return;
        }
        this.n.onAnimationEnd(getIndeterminateDrawable());
      }
    }
    else
    {
      super.setProgress(paramInt);
      if ((getProgressDrawable() != null) && (!paramBoolean)) {
        getProgressDrawable().jumpToCurrentState();
      }
    }
  }
  
  public void setProgressDrawable(@Nullable Drawable paramDrawable)
  {
    if (paramDrawable == null)
    {
      super.setProgressDrawable(null);
      return;
    }
    if ((paramDrawable instanceof DeterminateDrawable))
    {
      paramDrawable = (DeterminateDrawable)paramDrawable;
      paramDrawable.b();
      super.setProgressDrawable(paramDrawable);
      paramDrawable.a(getProgress() / getMax());
      return;
    }
    throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
  }
  
  public void setShowAnimationBehavior(int paramInt)
  {
    this.b.e = paramInt;
    invalidate();
  }
  
  public void setTrackColor(@ColorInt int paramInt)
  {
    if (this.b.d != paramInt)
    {
      this.b.d = paramInt;
      invalidate();
    }
  }
  
  public void setTrackCornerRadius(@Px int paramInt)
  {
    if (this.b.b != paramInt)
    {
      BaseProgressIndicatorSpec localBaseProgressIndicatorSpec = this.b;
      localBaseProgressIndicatorSpec.b = Math.min(paramInt, localBaseProgressIndicatorSpec.a / 2);
    }
  }
  
  public void setTrackThickness(@Px int paramInt)
  {
    if (this.b.a != paramInt)
    {
      this.b.a = paramInt;
      requestLayout();
    }
  }
  
  public void setVisibilityAfterHide(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 4) && (paramInt != 8)) {
      throw new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
    }
    this.k = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.progressindicator.BaseProgressIndicator
 * JD-Core Version:    0.7.0.1
 */