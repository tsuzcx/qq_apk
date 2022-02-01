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
  static final int jdField_a_of_type_Int = R.style.F;
  private long jdField_a_of_type_Long = -1L;
  private final Animatable2Compat.AnimationCallback jdField_a_of_type_AndroidxVectordrawableGraphicsDrawableAnimatable2Compat$AnimationCallback = new BaseProgressIndicator.3(this);
  AnimatorDurationScaleProvider jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorAnimatorDurationScaleProvider;
  S jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec;
  private final Runnable jdField_a_of_type_JavaLangRunnable = new BaseProgressIndicator.1(this);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private final Animatable2Compat.AnimationCallback jdField_b_of_type_AndroidxVectordrawableGraphicsDrawableAnimatable2Compat$AnimationCallback = new BaseProgressIndicator.4(this);
  private final Runnable jdField_b_of_type_JavaLangRunnable = new BaseProgressIndicator.2(this);
  private boolean jdField_b_of_type_Boolean;
  private final int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean = false;
  private final int d;
  private int e = 4;
  
  protected BaseProgressIndicator(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt1, @StyleRes int paramInt2)
  {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt1, jdField_a_of_type_Int), paramAttributeSet, paramInt1);
    paramContext = getContext();
    this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec = a(paramContext, paramAttributeSet);
    paramContext = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.e, paramInt1, paramInt2, new int[0]);
    this.jdField_c_of_type_Int = paramContext.getInt(R.styleable.o, -1);
    this.d = Math.min(paramContext.getInt(R.styleable.m, -1), 1000);
    paramContext.recycle();
    this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorAnimatorDurationScaleProvider = new AnimatorDurationScaleProvider();
    this.jdField_b_of_type_Boolean = true;
  }
  
  @Nullable
  private DrawingDelegate<S> a()
  {
    if (isIndeterminate())
    {
      if (a() == null) {
        return null;
      }
      return a().a();
    }
    if (a() == null) {
      return null;
    }
    return a().a();
  }
  
  private void a()
  {
    if ((a() != null) && (a() != null)) {
      a().a().a(this.jdField_a_of_type_AndroidxVectordrawableGraphicsDrawableAnimatable2Compat$AnimationCallback);
    }
    if (a() != null) {
      a().registerAnimationCallback(this.jdField_b_of_type_AndroidxVectordrawableGraphicsDrawableAnimatable2Compat$AnimationCallback);
    }
    if (a() != null) {
      a().registerAnimationCallback(this.jdField_b_of_type_AndroidxVectordrawableGraphicsDrawableAnimatable2Compat$AnimationCallback);
    }
  }
  
  private void b()
  {
    if (a() != null)
    {
      a().unregisterAnimationCallback(this.jdField_b_of_type_AndroidxVectordrawableGraphicsDrawableAnimatable2Compat$AnimationCallback);
      a().a().e();
    }
    if (a() != null) {
      a().unregisterAnimationCallback(this.jdField_b_of_type_AndroidxVectordrawableGraphicsDrawableAnimatable2Compat$AnimationCallback);
    }
  }
  
  private void c()
  {
    if (this.d > 0) {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    }
    setVisibility(0);
  }
  
  private boolean c()
  {
    return ((a() == null) || (!a().isVisible())) && ((a() == null) || (!a().isVisible()));
  }
  
  private void d()
  {
    ((DrawableWithAnimatedVisibilityChange)a()).b(false, false, true);
    if (c()) {
      setVisibility(4);
    }
  }
  
  @Nullable
  public Drawable a()
  {
    if (isIndeterminate()) {
      return a();
    }
    return a();
  }
  
  abstract S a(@NonNull Context paramContext, @NonNull AttributeSet paramAttributeSet);
  
  @Nullable
  public DeterminateDrawable<S> a()
  {
    return (DeterminateDrawable)super.getProgressDrawable();
  }
  
  @Nullable
  public IndeterminateDrawable<S> a()
  {
    return (IndeterminateDrawable)super.getIndeterminateDrawable();
  }
  
  protected void a(boolean paramBoolean)
  {
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    ((DrawableWithAnimatedVisibilityChange)a()).b(a(), false, paramBoolean);
  }
  
  boolean a()
  {
    return (ViewCompat.isAttachedToWindow(this)) && (getWindowVisibility() == 0) && (b());
  }
  
  @NonNull
  public int[] a()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec.jdField_a_of_type_ArrayOfInt;
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
  
  public void invalidate()
  {
    super.invalidate();
    if (a() != null) {
      a().invalidateSelf();
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    a();
    if (a()) {
      c();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    ((DrawableWithAnimatedVisibilityChange)a()).a();
    b();
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(@NonNull Canvas paramCanvas)
  {
    try
    {
      int i = paramCanvas.save();
      if ((getPaddingLeft() != 0) || (getPaddingTop() != 0)) {
        paramCanvas.translate(getPaddingLeft(), getPaddingTop());
      }
      if ((getPaddingRight() != 0) || (getPaddingBottom() != 0)) {
        paramCanvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
      }
      a().draw(paramCanvas);
      paramCanvas.restoreToCount(i);
      return;
    }
    finally {}
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      DrawingDelegate localDrawingDelegate = a();
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
    this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorAnimatorDurationScaleProvider = paramAnimatorDurationScaleProvider;
    if (a() != null) {
      a().jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorAnimatorDurationScaleProvider = paramAnimatorDurationScaleProvider;
    }
    if (a() != null) {
      a().jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorAnimatorDurationScaleProvider = paramAnimatorDurationScaleProvider;
    }
  }
  
  public void setHideAnimationBehavior(int paramInt)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec.e = paramInt;
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
      DrawableWithAnimatedVisibilityChange localDrawableWithAnimatedVisibilityChange = (DrawableWithAnimatedVisibilityChange)a();
      if (localDrawableWithAnimatedVisibilityChange != null) {
        localDrawableWithAnimatedVisibilityChange.a();
      }
      super.setIndeterminate(paramBoolean);
      localDrawableWithAnimatedVisibilityChange = (DrawableWithAnimatedVisibilityChange)a();
      if (localDrawableWithAnimatedVisibilityChange != null) {
        localDrawableWithAnimatedVisibilityChange.b(a(), false, false);
      }
      this.jdField_c_of_type_Boolean = false;
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
      ((DrawableWithAnimatedVisibilityChange)paramDrawable).a();
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
      arrayOfInt[0] = MaterialColors.a(getContext(), R.attr.colorPrimary, -1);
    }
    if (!Arrays.equals(a(), arrayOfInt))
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec.jdField_a_of_type_ArrayOfInt = arrayOfInt;
      a().a().d();
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
      if (a() != null)
      {
        this.jdField_b_of_type_Int = paramInt;
        this.jdField_a_of_type_Boolean = paramBoolean;
        this.jdField_c_of_type_Boolean = true;
        if ((a().isVisible()) && (this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorAnimatorDurationScaleProvider.a(getContext().getContentResolver()) != 0.0F))
        {
          a().a().c();
          return;
        }
        this.jdField_a_of_type_AndroidxVectordrawableGraphicsDrawableAnimatable2Compat$AnimationCallback.onAnimationEnd(a());
      }
    }
    else
    {
      super.setProgress(paramInt);
      if ((a() != null) && (!paramBoolean)) {
        a().jumpToCurrentState();
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
      paramDrawable.a();
      super.setProgressDrawable(paramDrawable);
      paramDrawable.a(getProgress() / getMax());
      return;
    }
    throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
  }
  
  public void setShowAnimationBehavior(int paramInt)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec.d = paramInt;
    invalidate();
  }
  
  public void setTrackColor(@ColorInt int paramInt)
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec.jdField_c_of_type_Int != paramInt)
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec.jdField_c_of_type_Int = paramInt;
      invalidate();
    }
  }
  
  public void setTrackCornerRadius(@Px int paramInt)
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec.jdField_b_of_type_Int != paramInt)
    {
      BaseProgressIndicatorSpec localBaseProgressIndicatorSpec = this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec;
      localBaseProgressIndicatorSpec.jdField_b_of_type_Int = Math.min(paramInt, localBaseProgressIndicatorSpec.jdField_a_of_type_Int / 2);
    }
  }
  
  public void setTrackThickness(@Px int paramInt)
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec.jdField_a_of_type_Int != paramInt)
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec.jdField_a_of_type_Int = paramInt;
      requestLayout();
    }
  }
  
  public void setVisibilityAfterHide(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 4) && (paramInt != 8)) {
      throw new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
    }
    this.e = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.progressindicator.BaseProgressIndicator
 * JD-Core Version:    0.7.0.1
 */