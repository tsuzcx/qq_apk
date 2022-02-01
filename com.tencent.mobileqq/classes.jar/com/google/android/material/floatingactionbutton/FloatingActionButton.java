package com.google.android.material.floatingactionbutton;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.widget.ImageView.ScaleType;
import androidx.annotation.AnimatorRes;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatImageHelper;
import androidx.collection.SimpleArrayMap;
import androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TintableImageSourceView;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.TransformationCallback;
import com.google.android.material.expandable.ExpandableTransformationWidget;
import com.google.android.material.expandable.ExpandableWidgetHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearanceModel.Builder;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.stateful.ExtendableSavedState;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class FloatingActionButton
  extends VisibilityAwareImageButton
  implements CoordinatorLayout.AttachedBehavior, TintableBackgroundView, TintableImageSourceView, ExpandableTransformationWidget, Shapeable
{
  private static final int jdField_a_of_type_Int = R.style.l;
  @Nullable
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  @Nullable
  private PorterDuff.Mode jdField_a_of_type_AndroidGraphicsPorterDuff$Mode;
  final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  @NonNull
  private final AppCompatImageHelper jdField_a_of_type_AndroidxAppcompatWidgetAppCompatImageHelper;
  @NonNull
  private final ExpandableWidgetHelper jdField_a_of_type_ComGoogleAndroidMaterialExpandableExpandableWidgetHelper;
  private FloatingActionButtonImpl jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButtonImpl;
  boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  @Nullable
  private ColorStateList jdField_b_of_type_AndroidContentResColorStateList;
  @Nullable
  private PorterDuff.Mode jdField_b_of_type_AndroidGraphicsPorterDuff$Mode;
  private final Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  private int jdField_c_of_type_Int;
  @Nullable
  private ColorStateList jdField_c_of_type_AndroidContentResColorStateList;
  private int d;
  private int e;
  private int f;
  
  public FloatingActionButton(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FloatingActionButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.r);
  }
  
  public FloatingActionButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, jdField_a_of_type_Int), paramAttributeSet, paramInt);
    Object localObject = getContext();
    paramContext = ThemeEnforcement.a((Context)localObject, paramAttributeSet, R.styleable.z, paramInt, jdField_a_of_type_Int, new int[0]);
    this.jdField_a_of_type_AndroidContentResColorStateList = MaterialResources.a((Context)localObject, paramContext, R.styleable.bH);
    this.jdField_a_of_type_AndroidGraphicsPorterDuff$Mode = ViewUtils.a(paramContext.getInt(R.styleable.bI, -1), null);
    this.jdField_c_of_type_AndroidContentResColorStateList = MaterialResources.a((Context)localObject, paramContext, R.styleable.bS);
    this.jdField_c_of_type_Int = paramContext.getInt(R.styleable.bN, -1);
    this.d = paramContext.getDimensionPixelSize(R.styleable.bM, 0);
    this.jdField_b_of_type_Int = paramContext.getDimensionPixelSize(R.styleable.bJ, 0);
    float f1 = paramContext.getDimension(R.styleable.bK, 0.0F);
    float f2 = paramContext.getDimension(R.styleable.bP, 0.0F);
    float f3 = paramContext.getDimension(R.styleable.bR, 0.0F);
    this.jdField_a_of_type_Boolean = paramContext.getBoolean(R.styleable.bU, false);
    int i = getResources().getDimensionPixelSize(R.dimen.ae);
    this.f = paramContext.getDimensionPixelSize(R.styleable.bQ, 0);
    MotionSpec localMotionSpec1 = MotionSpec.a((Context)localObject, paramContext, R.styleable.bT);
    MotionSpec localMotionSpec2 = MotionSpec.a((Context)localObject, paramContext, R.styleable.bO);
    localObject = ShapeAppearanceModel.a((Context)localObject, paramAttributeSet, paramInt, jdField_a_of_type_Int, ShapeAppearanceModel.a).a();
    boolean bool = paramContext.getBoolean(R.styleable.bL, false);
    setEnabled(paramContext.getBoolean(R.styleable.bG, true));
    paramContext.recycle();
    this.jdField_a_of_type_AndroidxAppcompatWidgetAppCompatImageHelper = new AppCompatImageHelper(this);
    this.jdField_a_of_type_AndroidxAppcompatWidgetAppCompatImageHelper.loadFromAttributes(paramAttributeSet, paramInt);
    this.jdField_a_of_type_ComGoogleAndroidMaterialExpandableExpandableWidgetHelper = new ExpandableWidgetHelper(this);
    a().a((ShapeAppearanceModel)localObject);
    a().a(this.jdField_a_of_type_AndroidContentResColorStateList, this.jdField_a_of_type_AndroidGraphicsPorterDuff$Mode, this.jdField_c_of_type_AndroidContentResColorStateList, this.jdField_b_of_type_Int);
    a().a(i);
    a().a(f1);
    a().b(f2);
    a().c(f3);
    a().b(this.f);
    a().a(localMotionSpec1);
    a().b(localMotionSpec2);
    a().a(bool);
    setScaleType(ImageView.ScaleType.MATRIX);
  }
  
  private int a(int paramInt)
  {
    int i = this.d;
    if (i != 0) {
      return i;
    }
    Resources localResources = getResources();
    if (paramInt != -1)
    {
      if (paramInt != 1) {
        return localResources.getDimensionPixelSize(R.dimen.l);
      }
      return localResources.getDimensionPixelSize(R.dimen.k);
    }
    if (Math.max(localResources.getConfiguration().screenWidthDp, localResources.getConfiguration().screenHeightDp) < 470) {
      return a(1);
    }
    return a(0);
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (i != -2147483648)
    {
      if (i != 0)
      {
        if (i == 1073741824) {
          return paramInt2;
        }
        throw new IllegalArgumentException();
      }
    }
    else {
      paramInt1 = Math.min(paramInt1, paramInt2);
    }
    return paramInt1;
  }
  
  @Nullable
  private FloatingActionButtonImpl.InternalVisibilityChangedListener a(@Nullable FloatingActionButton.OnVisibilityChangedListener paramOnVisibilityChangedListener)
  {
    if (paramOnVisibilityChangedListener == null) {
      return null;
    }
    return new FloatingActionButton.1(this, paramOnVisibilityChangedListener);
  }
  
  private FloatingActionButtonImpl a()
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButtonImpl == null) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButtonImpl = b();
    }
    return this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButtonImpl;
  }
  
  private void a()
  {
    Drawable localDrawable = getDrawable();
    if (localDrawable == null) {
      return;
    }
    Object localObject = this.jdField_b_of_type_AndroidContentResColorStateList;
    if (localObject == null)
    {
      DrawableCompat.clearColorFilter(localDrawable);
      return;
    }
    int i = ((ColorStateList)localObject).getColorForState(getDrawableState(), 0);
    PorterDuff.Mode localMode = this.jdField_b_of_type_AndroidGraphicsPorterDuff$Mode;
    localObject = localMode;
    if (localMode == null) {
      localObject = PorterDuff.Mode.SRC_IN;
    }
    localDrawable.mutate().setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(i, (PorterDuff.Mode)localObject));
  }
  
  @NonNull
  private FloatingActionButtonImpl b()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return new FloatingActionButtonImplLollipop(this, new FloatingActionButton.ShadowDelegateImpl(this));
    }
    return new FloatingActionButtonImpl(this, new FloatingActionButton.ShadowDelegateImpl(this));
  }
  
  private void b(@NonNull Rect paramRect)
  {
    paramRect.left += this.jdField_a_of_type_AndroidGraphicsRect.left;
    paramRect.top += this.jdField_a_of_type_AndroidGraphicsRect.top;
    paramRect.right -= this.jdField_a_of_type_AndroidGraphicsRect.right;
    paramRect.bottom -= this.jdField_a_of_type_AndroidGraphicsRect.bottom;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialExpandableExpandableWidgetHelper.a();
  }
  
  @Nullable
  public ColorStateList a()
  {
    return this.jdField_a_of_type_AndroidContentResColorStateList;
  }
  
  @Nullable
  public PorterDuff.Mode a()
  {
    return this.jdField_a_of_type_AndroidGraphicsPorterDuff$Mode;
  }
  
  @NonNull
  public ShapeAppearanceModel a()
  {
    return (ShapeAppearanceModel)Preconditions.checkNotNull(a().a());
  }
  
  public void a(@NonNull Animator.AnimatorListener paramAnimatorListener)
  {
    a().a(paramAnimatorListener);
  }
  
  public void a(@NonNull Rect paramRect)
  {
    paramRect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
    b(paramRect);
  }
  
  public void a(@NonNull TransformationCallback<? extends FloatingActionButton> paramTransformationCallback)
  {
    a().a(new FloatingActionButton.TransformationCallbackWrapper(this, paramTransformationCallback));
  }
  
  public void a(@Nullable FloatingActionButton.OnVisibilityChangedListener paramOnVisibilityChangedListener)
  {
    a(paramOnVisibilityChangedListener, true);
  }
  
  void a(@Nullable FloatingActionButton.OnVisibilityChangedListener paramOnVisibilityChangedListener, boolean paramBoolean)
  {
    a().b(a(paramOnVisibilityChangedListener), paramBoolean);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialExpandableExpandableWidgetHelper.a();
  }
  
  @Deprecated
  public boolean a(@NonNull Rect paramRect)
  {
    if (ViewCompat.isLaidOut(this))
    {
      paramRect.set(0, 0, getWidth(), getHeight());
      b(paramRect);
      return true;
    }
    return false;
  }
  
  int b()
  {
    return a(this.jdField_c_of_type_Int);
  }
  
  public void b(@NonNull Animator.AnimatorListener paramAnimatorListener)
  {
    a().b(paramAnimatorListener);
  }
  
  public void b(@Nullable FloatingActionButton.OnVisibilityChangedListener paramOnVisibilityChangedListener)
  {
    b(paramOnVisibilityChangedListener, true);
  }
  
  void b(@Nullable FloatingActionButton.OnVisibilityChangedListener paramOnVisibilityChangedListener, boolean paramBoolean)
  {
    a().a(a(paramOnVisibilityChangedListener), paramBoolean);
  }
  
  public boolean b()
  {
    return a().f();
  }
  
  public boolean c()
  {
    return a().e();
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    a().a(getDrawableState());
  }
  
  @NonNull
  public CoordinatorLayout.Behavior<FloatingActionButton> getBehavior()
  {
    return new FloatingActionButton.Behavior();
  }
  
  @Nullable
  public ColorStateList getSupportBackgroundTintList()
  {
    return a();
  }
  
  @Nullable
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    return a();
  }
  
  @Nullable
  public ColorStateList getSupportImageTintList()
  {
    return this.jdField_b_of_type_AndroidContentResColorStateList;
  }
  
  @Nullable
  public PorterDuff.Mode getSupportImageTintMode()
  {
    return this.jdField_b_of_type_AndroidGraphicsPorterDuff$Mode;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    a().b();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    a().g();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    a().h();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = b();
    this.e = ((i - this.f) / 2);
    a().f();
    paramInt1 = Math.min(a(i, paramInt1), a(i, paramInt2));
    setMeasuredDimension(this.jdField_a_of_type_AndroidGraphicsRect.left + paramInt1 + this.jdField_a_of_type_AndroidGraphicsRect.right, paramInt1 + this.jdField_a_of_type_AndroidGraphicsRect.top + this.jdField_a_of_type_AndroidGraphicsRect.bottom);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof ExtendableSavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (ExtendableSavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.jdField_a_of_type_ComGoogleAndroidMaterialExpandableExpandableWidgetHelper.a((Bundle)Preconditions.checkNotNull(paramParcelable.a.get("expandableWidgetHelper")));
  }
  
  protected Parcelable onSaveInstanceState()
  {
    Parcelable localParcelable = super.onSaveInstanceState();
    Object localObject = localParcelable;
    if (localParcelable == null) {
      localObject = new Bundle();
    }
    localObject = new ExtendableSavedState((Parcelable)localObject);
    ((ExtendableSavedState)localObject).a.put("expandableWidgetHelper", this.jdField_a_of_type_ComGoogleAndroidMaterialExpandableExpandableWidgetHelper.a());
    return localObject;
  }
  
  public boolean onTouchEvent(@NonNull MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) && (a(this.jdField_b_of_type_AndroidGraphicsRect)) && (!this.jdField_b_of_type_AndroidGraphicsRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))) {
      return false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    Log.i("FloatingActionButton", "Setting a custom background is not supported.");
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    Log.i("FloatingActionButton", "Setting a custom background is not supported.");
  }
  
  public void setBackgroundResource(int paramInt)
  {
    Log.i("FloatingActionButton", "Setting a custom background is not supported.");
  }
  
  public void setBackgroundTintList(@Nullable ColorStateList paramColorStateList)
  {
    if (this.jdField_a_of_type_AndroidContentResColorStateList != paramColorStateList)
    {
      this.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList;
      a().a(paramColorStateList);
    }
  }
  
  public void setBackgroundTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    if (this.jdField_a_of_type_AndroidGraphicsPorterDuff$Mode != paramMode)
    {
      this.jdField_a_of_type_AndroidGraphicsPorterDuff$Mode = paramMode;
      a().a(paramMode);
    }
  }
  
  public void setCompatElevation(float paramFloat)
  {
    a().a(paramFloat);
  }
  
  public void setCompatElevationResource(@DimenRes int paramInt)
  {
    setCompatElevation(getResources().getDimension(paramInt));
  }
  
  public void setCompatHoveredFocusedTranslationZ(float paramFloat)
  {
    a().b(paramFloat);
  }
  
  public void setCompatHoveredFocusedTranslationZResource(@DimenRes int paramInt)
  {
    setCompatHoveredFocusedTranslationZ(getResources().getDimension(paramInt));
  }
  
  public void setCompatPressedTranslationZ(float paramFloat)
  {
    a().c(paramFloat);
  }
  
  public void setCompatPressedTranslationZResource(@DimenRes int paramInt)
  {
    setCompatPressedTranslationZ(getResources().getDimension(paramInt));
  }
  
  public void setCustomSize(@Px int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt != this.d)
      {
        this.d = paramInt;
        requestLayout();
      }
      return;
    }
    throw new IllegalArgumentException("Custom size must be non-negative");
  }
  
  @RequiresApi(21)
  public void setElevation(float paramFloat)
  {
    super.setElevation(paramFloat);
    a().e(paramFloat);
  }
  
  public void setEnsureMinTouchTargetSize(boolean paramBoolean)
  {
    if (paramBoolean != a().b())
    {
      a().a(paramBoolean);
      requestLayout();
    }
  }
  
  public void setExpandedComponentIdHint(@IdRes int paramInt)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialExpandableExpandableWidgetHelper.a(paramInt);
  }
  
  public void setHideMotionSpec(@Nullable MotionSpec paramMotionSpec)
  {
    a().b(paramMotionSpec);
  }
  
  public void setHideMotionSpecResource(@AnimatorRes int paramInt)
  {
    setHideMotionSpec(MotionSpec.a(getContext(), paramInt));
  }
  
  public void setImageDrawable(@Nullable Drawable paramDrawable)
  {
    if (getDrawable() != paramDrawable)
    {
      super.setImageDrawable(paramDrawable);
      a().a();
      if (this.jdField_b_of_type_AndroidContentResColorStateList != null) {
        a();
      }
    }
  }
  
  public void setImageResource(@DrawableRes int paramInt)
  {
    this.jdField_a_of_type_AndroidxAppcompatWidgetAppCompatImageHelper.setImageResource(paramInt);
    a();
  }
  
  public void setRippleColor(@ColorInt int paramInt)
  {
    setRippleColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setRippleColor(@Nullable ColorStateList paramColorStateList)
  {
    if (this.jdField_c_of_type_AndroidContentResColorStateList != paramColorStateList)
    {
      this.jdField_c_of_type_AndroidContentResColorStateList = paramColorStateList;
      a().b(this.jdField_c_of_type_AndroidContentResColorStateList);
    }
  }
  
  public void setScaleX(float paramFloat)
  {
    super.setScaleX(paramFloat);
    a().d();
  }
  
  public void setScaleY(float paramFloat)
  {
    super.setScaleY(paramFloat);
    a().d();
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  @VisibleForTesting
  public void setShadowPaddingEnabled(boolean paramBoolean)
  {
    a().b(paramBoolean);
  }
  
  public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel paramShapeAppearanceModel)
  {
    a().a(paramShapeAppearanceModel);
  }
  
  public void setShowMotionSpec(@Nullable MotionSpec paramMotionSpec)
  {
    a().a(paramMotionSpec);
  }
  
  public void setShowMotionSpecResource(@AnimatorRes int paramInt)
  {
    setShowMotionSpec(MotionSpec.a(getContext(), paramInt));
  }
  
  public void setSize(int paramInt)
  {
    this.d = 0;
    if (paramInt != this.jdField_c_of_type_Int)
    {
      this.jdField_c_of_type_Int = paramInt;
      requestLayout();
    }
  }
  
  public void setSupportBackgroundTintList(@Nullable ColorStateList paramColorStateList)
  {
    setBackgroundTintList(paramColorStateList);
  }
  
  public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    setBackgroundTintMode(paramMode);
  }
  
  public void setSupportImageTintList(@Nullable ColorStateList paramColorStateList)
  {
    if (this.jdField_b_of_type_AndroidContentResColorStateList != paramColorStateList)
    {
      this.jdField_b_of_type_AndroidContentResColorStateList = paramColorStateList;
      a();
    }
  }
  
  public void setSupportImageTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    if (this.jdField_b_of_type_AndroidGraphicsPorterDuff$Mode != paramMode)
    {
      this.jdField_b_of_type_AndroidGraphicsPorterDuff$Mode = paramMode;
      a();
    }
  }
  
  public void setTranslationX(float paramFloat)
  {
    super.setTranslationX(paramFloat);
    a().c();
  }
  
  public void setTranslationY(float paramFloat)
  {
    super.setTranslationY(paramFloat);
    a().c();
  }
  
  public void setTranslationZ(float paramFloat)
  {
    super.setTranslationZ(paramFloat);
    a().c();
  }
  
  public void setUseCompatPadding(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      a().e();
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.FloatingActionButton
 * JD-Core Version:    0.7.0.1
 */