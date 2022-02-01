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
  private static final int c = R.style.n;
  boolean a;
  final Rect b = new Rect();
  @Nullable
  private ColorStateList d;
  @Nullable
  private PorterDuff.Mode e;
  @Nullable
  private ColorStateList f;
  @Nullable
  private PorterDuff.Mode g;
  @Nullable
  private ColorStateList h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private final Rect n = new Rect();
  @NonNull
  private final AppCompatImageHelper o;
  @NonNull
  private final ExpandableWidgetHelper p;
  private FloatingActionButtonImpl q;
  
  public FloatingActionButton(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FloatingActionButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.y);
  }
  
  public FloatingActionButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, c), paramAttributeSet, paramInt);
    Object localObject = getContext();
    paramContext = ThemeEnforcement.a((Context)localObject, paramAttributeSet, R.styleable.cF, paramInt, c, new int[0]);
    this.d = MaterialResources.a((Context)localObject, paramContext, R.styleable.cH);
    this.e = ViewUtils.a(paramContext.getInt(R.styleable.cI, -1), null);
    this.h = MaterialResources.a((Context)localObject, paramContext, R.styleable.cS);
    this.j = paramContext.getInt(R.styleable.cN, -1);
    this.k = paramContext.getDimensionPixelSize(R.styleable.cM, 0);
    this.i = paramContext.getDimensionPixelSize(R.styleable.cJ, 0);
    float f1 = paramContext.getDimension(R.styleable.cK, 0.0F);
    float f2 = paramContext.getDimension(R.styleable.cP, 0.0F);
    float f3 = paramContext.getDimension(R.styleable.cR, 0.0F);
    this.a = paramContext.getBoolean(R.styleable.cU, false);
    int i1 = getResources().getDimensionPixelSize(R.dimen.ae);
    this.m = paramContext.getDimensionPixelSize(R.styleable.cQ, 0);
    MotionSpec localMotionSpec1 = MotionSpec.a((Context)localObject, paramContext, R.styleable.cT);
    MotionSpec localMotionSpec2 = MotionSpec.a((Context)localObject, paramContext, R.styleable.cO);
    localObject = ShapeAppearanceModel.a((Context)localObject, paramAttributeSet, paramInt, c, ShapeAppearanceModel.a).a();
    boolean bool = paramContext.getBoolean(R.styleable.cL, false);
    setEnabled(paramContext.getBoolean(R.styleable.cG, true));
    paramContext.recycle();
    this.o = new AppCompatImageHelper(this);
    this.o.loadFromAttributes(paramAttributeSet, paramInt);
    this.p = new ExpandableWidgetHelper(this);
    getImpl().a((ShapeAppearanceModel)localObject);
    getImpl().a(this.d, this.e, this.h, this.i);
    getImpl().a(i1);
    getImpl().a(f1);
    getImpl().b(f2);
    getImpl().c(f3);
    getImpl().b(this.m);
    getImpl().a(localMotionSpec1);
    getImpl().b(localMotionSpec2);
    getImpl().a(bool);
    setScaleType(ImageView.ScaleType.MATRIX);
  }
  
  private int a(int paramInt)
  {
    int i1 = this.k;
    if (i1 != 0) {
      return i1;
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
    int i1 = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (i1 != -2147483648)
    {
      if (i1 != 0)
      {
        if (i1 == 1073741824) {
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
  private FloatingActionButtonImpl.InternalVisibilityChangedListener c(@Nullable FloatingActionButton.OnVisibilityChangedListener paramOnVisibilityChangedListener)
  {
    if (paramOnVisibilityChangedListener == null) {
      return null;
    }
    return new FloatingActionButton.1(this, paramOnVisibilityChangedListener);
  }
  
  private void c(@NonNull Rect paramRect)
  {
    paramRect.left += this.b.left;
    paramRect.top += this.b.top;
    paramRect.right -= this.b.right;
    paramRect.bottom -= this.b.bottom;
  }
  
  private void d()
  {
    Drawable localDrawable = getDrawable();
    if (localDrawable == null) {
      return;
    }
    Object localObject = this.f;
    if (localObject == null)
    {
      DrawableCompat.clearColorFilter(localDrawable);
      return;
    }
    int i1 = ((ColorStateList)localObject).getColorForState(getDrawableState(), 0);
    PorterDuff.Mode localMode = this.g;
    localObject = localMode;
    if (localMode == null) {
      localObject = PorterDuff.Mode.SRC_IN;
    }
    localDrawable.mutate().setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(i1, (PorterDuff.Mode)localObject));
  }
  
  @NonNull
  private FloatingActionButtonImpl e()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return new FloatingActionButtonImplLollipop(this, new FloatingActionButton.ShadowDelegateImpl(this));
    }
    return new FloatingActionButtonImpl(this, new FloatingActionButton.ShadowDelegateImpl(this));
  }
  
  private FloatingActionButtonImpl getImpl()
  {
    if (this.q == null) {
      this.q = e();
    }
    return this.q;
  }
  
  public void a(@NonNull Animator.AnimatorListener paramAnimatorListener)
  {
    getImpl().a(paramAnimatorListener);
  }
  
  public void a(@NonNull TransformationCallback<? extends FloatingActionButton> paramTransformationCallback)
  {
    getImpl().a(new FloatingActionButton.TransformationCallbackWrapper(this, paramTransformationCallback));
  }
  
  public void a(@Nullable FloatingActionButton.OnVisibilityChangedListener paramOnVisibilityChangedListener)
  {
    a(paramOnVisibilityChangedListener, true);
  }
  
  void a(@Nullable FloatingActionButton.OnVisibilityChangedListener paramOnVisibilityChangedListener, boolean paramBoolean)
  {
    getImpl().b(c(paramOnVisibilityChangedListener), paramBoolean);
  }
  
  public boolean a()
  {
    return this.p.a();
  }
  
  @Deprecated
  public boolean a(@NonNull Rect paramRect)
  {
    if (ViewCompat.isLaidOut(this))
    {
      paramRect.set(0, 0, getWidth(), getHeight());
      c(paramRect);
      return true;
    }
    return false;
  }
  
  public void b(@NonNull Animator.AnimatorListener paramAnimatorListener)
  {
    getImpl().b(paramAnimatorListener);
  }
  
  public void b(@NonNull Rect paramRect)
  {
    paramRect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
    c(paramRect);
  }
  
  public void b(@Nullable FloatingActionButton.OnVisibilityChangedListener paramOnVisibilityChangedListener)
  {
    b(paramOnVisibilityChangedListener, true);
  }
  
  void b(@Nullable FloatingActionButton.OnVisibilityChangedListener paramOnVisibilityChangedListener, boolean paramBoolean)
  {
    getImpl().a(c(paramOnVisibilityChangedListener), paramBoolean);
  }
  
  public boolean b()
  {
    return getImpl().w();
  }
  
  public boolean c()
  {
    return getImpl().v();
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    getImpl().a(getDrawableState());
  }
  
  @Nullable
  public ColorStateList getBackgroundTintList()
  {
    return this.d;
  }
  
  @Nullable
  public PorterDuff.Mode getBackgroundTintMode()
  {
    return this.e;
  }
  
  @NonNull
  public CoordinatorLayout.Behavior<FloatingActionButton> getBehavior()
  {
    return new FloatingActionButton.Behavior();
  }
  
  public float getCompatElevation()
  {
    return getImpl().a();
  }
  
  public float getCompatHoveredFocusedTranslationZ()
  {
    return getImpl().b();
  }
  
  public float getCompatPressedTranslationZ()
  {
    return getImpl().c();
  }
  
  @Nullable
  public Drawable getContentBackground()
  {
    return getImpl().m();
  }
  
  @Px
  public int getCustomSize()
  {
    return this.k;
  }
  
  public int getExpandedComponentIdHint()
  {
    return this.p.c();
  }
  
  @Nullable
  public MotionSpec getHideMotionSpec()
  {
    return getImpl().g();
  }
  
  @Deprecated
  @ColorInt
  public int getRippleColor()
  {
    ColorStateList localColorStateList = this.h;
    if (localColorStateList != null) {
      return localColorStateList.getDefaultColor();
    }
    return 0;
  }
  
  @Nullable
  public ColorStateList getRippleColorStateList()
  {
    return this.h;
  }
  
  @NonNull
  public ShapeAppearanceModel getShapeAppearanceModel()
  {
    return (ShapeAppearanceModel)Preconditions.checkNotNull(getImpl().e());
  }
  
  @Nullable
  public MotionSpec getShowMotionSpec()
  {
    return getImpl().f();
  }
  
  public int getSize()
  {
    return this.j;
  }
  
  int getSizeDimension()
  {
    return a(this.j);
  }
  
  @Nullable
  public ColorStateList getSupportBackgroundTintList()
  {
    return getBackgroundTintList();
  }
  
  @Nullable
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    return getBackgroundTintMode();
  }
  
  @Nullable
  public ColorStateList getSupportImageTintList()
  {
    return this.f;
  }
  
  @Nullable
  public PorterDuff.Mode getSupportImageTintMode()
  {
    return this.g;
  }
  
  public boolean getUseCompatPadding()
  {
    return this.a;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    getImpl().j();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    getImpl().q();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    getImpl().r();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = getSizeDimension();
    this.l = ((i1 - this.m) / 2);
    getImpl().o();
    paramInt1 = Math.min(a(i1, paramInt1), a(i1, paramInt2));
    setMeasuredDimension(this.b.left + paramInt1 + this.b.right, paramInt1 + this.b.top + this.b.bottom);
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
    this.p.a((Bundle)Preconditions.checkNotNull(paramParcelable.a.get("expandableWidgetHelper")));
  }
  
  protected Parcelable onSaveInstanceState()
  {
    Parcelable localParcelable = super.onSaveInstanceState();
    Object localObject = localParcelable;
    if (localParcelable == null) {
      localObject = new Bundle();
    }
    localObject = new ExtendableSavedState((Parcelable)localObject);
    ((ExtendableSavedState)localObject).a.put("expandableWidgetHelper", this.p.b());
    return localObject;
  }
  
  public boolean onTouchEvent(@NonNull MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) && (a(this.n)) && (!this.n.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))) {
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
    if (this.d != paramColorStateList)
    {
      this.d = paramColorStateList;
      getImpl().a(paramColorStateList);
    }
  }
  
  public void setBackgroundTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    if (this.e != paramMode)
    {
      this.e = paramMode;
      getImpl().a(paramMode);
    }
  }
  
  public void setCompatElevation(float paramFloat)
  {
    getImpl().a(paramFloat);
  }
  
  public void setCompatElevationResource(@DimenRes int paramInt)
  {
    setCompatElevation(getResources().getDimension(paramInt));
  }
  
  public void setCompatHoveredFocusedTranslationZ(float paramFloat)
  {
    getImpl().b(paramFloat);
  }
  
  public void setCompatHoveredFocusedTranslationZResource(@DimenRes int paramInt)
  {
    setCompatHoveredFocusedTranslationZ(getResources().getDimension(paramInt));
  }
  
  public void setCompatPressedTranslationZ(float paramFloat)
  {
    getImpl().c(paramFloat);
  }
  
  public void setCompatPressedTranslationZResource(@DimenRes int paramInt)
  {
    setCompatPressedTranslationZ(getResources().getDimension(paramInt));
  }
  
  public void setCustomSize(@Px int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt != this.k)
      {
        this.k = paramInt;
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
    getImpl().e(paramFloat);
  }
  
  public void setEnsureMinTouchTargetSize(boolean paramBoolean)
  {
    if (paramBoolean != getImpl().i())
    {
      getImpl().a(paramBoolean);
      requestLayout();
    }
  }
  
  public void setExpandedComponentIdHint(@IdRes int paramInt)
  {
    this.p.a(paramInt);
  }
  
  public void setHideMotionSpec(@Nullable MotionSpec paramMotionSpec)
  {
    getImpl().b(paramMotionSpec);
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
      getImpl().d();
      if (this.f != null) {
        d();
      }
    }
  }
  
  public void setImageResource(@DrawableRes int paramInt)
  {
    this.o.setImageResource(paramInt);
    d();
  }
  
  public void setRippleColor(@ColorInt int paramInt)
  {
    setRippleColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setRippleColor(@Nullable ColorStateList paramColorStateList)
  {
    if (this.h != paramColorStateList)
    {
      this.h = paramColorStateList;
      getImpl().b(this.h);
    }
  }
  
  public void setScaleX(float paramFloat)
  {
    super.setScaleX(paramFloat);
    getImpl().l();
  }
  
  public void setScaleY(float paramFloat)
  {
    super.setScaleY(paramFloat);
    getImpl().l();
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  @VisibleForTesting
  public void setShadowPaddingEnabled(boolean paramBoolean)
  {
    getImpl().b(paramBoolean);
  }
  
  public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel paramShapeAppearanceModel)
  {
    getImpl().a(paramShapeAppearanceModel);
  }
  
  public void setShowMotionSpec(@Nullable MotionSpec paramMotionSpec)
  {
    getImpl().a(paramMotionSpec);
  }
  
  public void setShowMotionSpecResource(@AnimatorRes int paramInt)
  {
    setShowMotionSpec(MotionSpec.a(getContext(), paramInt));
  }
  
  public void setSize(int paramInt)
  {
    this.k = 0;
    if (paramInt != this.j)
    {
      this.j = paramInt;
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
    if (this.f != paramColorStateList)
    {
      this.f = paramColorStateList;
      d();
    }
  }
  
  public void setSupportImageTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    if (this.g != paramMode)
    {
      this.g = paramMode;
      d();
    }
  }
  
  public void setTranslationX(float paramFloat)
  {
    super.setTranslationX(paramFloat);
    getImpl().k();
  }
  
  public void setTranslationY(float paramFloat)
  {
    super.setTranslationY(paramFloat);
    getImpl().k();
  }
  
  public void setTranslationZ(float paramFloat)
  {
    super.setTranslationZ(paramFloat);
    getImpl().k();
  }
  
  public void setUseCompatPadding(boolean paramBoolean)
  {
    if (this.a != paramBoolean)
    {
      this.a = paramBoolean;
      getImpl().n();
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.FloatingActionButton
 * JD-Core Version:    0.7.0.1
 */