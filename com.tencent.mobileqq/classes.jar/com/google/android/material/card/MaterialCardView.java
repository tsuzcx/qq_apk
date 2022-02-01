package com.google.android.material.card;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import com.google.android.material.R.attr;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class MaterialCardView
  extends CardView
  implements Checkable, Shapeable
{
  private static final int[] a = { 16842911 };
  private static final int[] b = { 16842912 };
  private static final int[] c = { R.attr.V };
  private static final int d = R.style.w;
  @NonNull
  private final MaterialCardViewHelper e;
  private boolean f = true;
  private boolean g = false;
  private boolean h = false;
  private MaterialCardView.OnCheckedChangeListener i;
  
  public MaterialCardView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MaterialCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.H);
  }
  
  public MaterialCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, d), paramAttributeSet, paramInt);
    paramContext = ThemeEnforcement.a(getContext(), paramAttributeSet, R.styleable.ev, paramInt, d, new int[0]);
    this.e = new MaterialCardViewHelper(this, paramAttributeSet, paramInt, d);
    this.e.b(super.getCardBackgroundColor());
    this.e.a(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
    this.e.a(paramContext);
    paramContext.recycle();
  }
  
  private void c()
  {
    if (Build.VERSION.SDK_INT > 26) {
      this.e.v();
    }
  }
  
  @NonNull
  private RectF getBoundsAsRectF()
  {
    RectF localRectF = new RectF();
    localRectF.set(this.e.e().getBounds());
    return localRectF;
  }
  
  public boolean G_()
  {
    return this.h;
  }
  
  public boolean H_()
  {
    MaterialCardViewHelper localMaterialCardViewHelper = this.e;
    return (localMaterialCardViewHelper != null) && (localMaterialCardViewHelper.p());
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setContentPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  @NonNull
  public ColorStateList getCardBackgroundColor()
  {
    return this.e.f();
  }
  
  @NonNull
  public ColorStateList getCardForegroundColor()
  {
    return this.e.g();
  }
  
  float getCardViewRadius()
  {
    return a(this);
  }
  
  @Nullable
  public Drawable getCheckedIcon()
  {
    return this.e.s();
  }
  
  @Dimension
  public int getCheckedIconMargin()
  {
    return this.e.u();
  }
  
  @Dimension
  public int getCheckedIconSize()
  {
    return this.e.t();
  }
  
  @Nullable
  public ColorStateList getCheckedIconTint()
  {
    return this.e.q();
  }
  
  public int getContentPaddingBottom()
  {
    return this.e.h().bottom;
  }
  
  public int getContentPaddingLeft()
  {
    return this.e.h().left;
  }
  
  public int getContentPaddingRight()
  {
    return this.e.h().right;
  }
  
  public int getContentPaddingTop()
  {
    return this.e.h().top;
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  public float getProgress()
  {
    return this.e.k();
  }
  
  public float getRadius()
  {
    return this.e.j();
  }
  
  public ColorStateList getRippleColor()
  {
    return this.e.r();
  }
  
  @NonNull
  public ShapeAppearanceModel getShapeAppearanceModel()
  {
    return this.e.w();
  }
  
  @Deprecated
  @ColorInt
  public int getStrokeColor()
  {
    return this.e.b();
  }
  
  @Nullable
  public ColorStateList getStrokeColorStateList()
  {
    return this.e.c();
  }
  
  @Dimension
  public int getStrokeWidth()
  {
    return this.e.d();
  }
  
  public boolean isChecked()
  {
    return this.g;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    MaterialShapeUtils.a(this, this.e.e());
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 3);
    if (H_()) {
      mergeDrawableStates(arrayOfInt, a);
    }
    if (isChecked()) {
      mergeDrawableStates(arrayOfInt, b);
    }
    if (G_()) {
      mergeDrawableStates(arrayOfInt, c);
    }
    return arrayOfInt;
  }
  
  public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName("androidx.cardview.widget.CardView");
    paramAccessibilityEvent.setChecked(isChecked());
  }
  
  public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
    paramAccessibilityNodeInfo.setCheckable(H_());
    paramAccessibilityNodeInfo.setClickable(isClickable());
    paramAccessibilityNodeInfo.setChecked(isChecked());
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.e.a(getMeasuredWidth(), getMeasuredHeight());
  }
  
  public void setBackground(Drawable paramDrawable)
  {
    setBackgroundDrawable(paramDrawable);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    if (this.f)
    {
      if (!this.e.a())
      {
        Log.i("MaterialCardView", "Setting a custom background is not supported.");
        this.e.a(true);
      }
      super.setBackgroundDrawable(paramDrawable);
    }
  }
  
  void setBackgroundInternal(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
  }
  
  public void setCardBackgroundColor(@ColorInt int paramInt)
  {
    this.e.b(ColorStateList.valueOf(paramInt));
  }
  
  public void setCardBackgroundColor(@Nullable ColorStateList paramColorStateList)
  {
    this.e.b(paramColorStateList);
  }
  
  public void setCardElevation(float paramFloat)
  {
    super.setCardElevation(paramFloat);
    this.e.l();
  }
  
  public void setCardForegroundColor(@Nullable ColorStateList paramColorStateList)
  {
    this.e.c(paramColorStateList);
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    this.e.b(paramBoolean);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.g != paramBoolean) {
      toggle();
    }
  }
  
  public void setCheckedIcon(@Nullable Drawable paramDrawable)
  {
    this.e.a(paramDrawable);
  }
  
  public void setCheckedIconMargin(@Dimension int paramInt)
  {
    this.e.c(paramInt);
  }
  
  public void setCheckedIconMarginResource(@DimenRes int paramInt)
  {
    if (paramInt != -1) {
      this.e.c(getResources().getDimensionPixelSize(paramInt));
    }
  }
  
  public void setCheckedIconResource(@DrawableRes int paramInt)
  {
    this.e.a(AppCompatResources.getDrawable(getContext(), paramInt));
  }
  
  public void setCheckedIconSize(@Dimension int paramInt)
  {
    this.e.b(paramInt);
  }
  
  public void setCheckedIconSizeResource(@DimenRes int paramInt)
  {
    if (paramInt != 0) {
      this.e.b(getResources().getDimensionPixelSize(paramInt));
    }
  }
  
  public void setCheckedIconTint(@Nullable ColorStateList paramColorStateList)
  {
    this.e.e(paramColorStateList);
  }
  
  public void setClickable(boolean paramBoolean)
  {
    super.setClickable(paramBoolean);
    MaterialCardViewHelper localMaterialCardViewHelper = this.e;
    if (localMaterialCardViewHelper != null) {
      localMaterialCardViewHelper.i();
    }
  }
  
  public void setContentPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.e.a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setDragged(boolean paramBoolean)
  {
    if (this.h != paramBoolean)
    {
      this.h = paramBoolean;
      refreshDrawableState();
      c();
      invalidate();
    }
  }
  
  public void setMaxCardElevation(float paramFloat)
  {
    super.setMaxCardElevation(paramFloat);
    this.e.m();
  }
  
  public void setOnCheckedChangeListener(@Nullable MaterialCardView.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.i = paramOnCheckedChangeListener;
  }
  
  public void setPreventCornerOverlap(boolean paramBoolean)
  {
    super.setPreventCornerOverlap(paramBoolean);
    this.e.m();
    this.e.o();
  }
  
  public void setProgress(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    this.e.b(paramFloat);
  }
  
  public void setRadius(float paramFloat)
  {
    super.setRadius(paramFloat);
    this.e.a(paramFloat);
  }
  
  public void setRippleColor(@Nullable ColorStateList paramColorStateList)
  {
    this.e.d(paramColorStateList);
  }
  
  public void setRippleColorResource(@ColorRes int paramInt)
  {
    this.e.d(AppCompatResources.getColorStateList(getContext(), paramInt));
  }
  
  public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel paramShapeAppearanceModel)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      setClipToOutline(paramShapeAppearanceModel.a(getBoundsAsRectF()));
    }
    this.e.a(paramShapeAppearanceModel);
  }
  
  public void setStrokeColor(@ColorInt int paramInt)
  {
    this.e.a(ColorStateList.valueOf(paramInt));
  }
  
  public void setStrokeColor(ColorStateList paramColorStateList)
  {
    this.e.a(paramColorStateList);
  }
  
  public void setStrokeWidth(@Dimension int paramInt)
  {
    this.e.a(paramInt);
  }
  
  public void setUseCompatPadding(boolean paramBoolean)
  {
    super.setUseCompatPadding(paramBoolean);
    this.e.m();
    this.e.o();
  }
  
  public void toggle()
  {
    if ((H_()) && (isEnabled()))
    {
      this.g ^= true;
      refreshDrawableState();
      c();
      MaterialCardView.OnCheckedChangeListener localOnCheckedChangeListener = this.i;
      if (localOnCheckedChangeListener != null) {
        localOnCheckedChangeListener.a(this, this.g);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.card.MaterialCardView
 * JD-Core Version:    0.7.0.1
 */