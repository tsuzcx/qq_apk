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
  private static final int jdField_a_of_type_Int = R.style.u;
  private static final int[] jdField_a_of_type_ArrayOfInt = { 16842911 };
  private static final int[] jdField_b_of_type_ArrayOfInt = { 16842912 };
  private static final int[] jdField_c_of_type_ArrayOfInt = { R.attr.N };
  private MaterialCardView.OnCheckedChangeListener jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardView$OnCheckedChangeListener;
  @NonNull
  private final MaterialCardViewHelper jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardViewHelper;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean jdField_c_of_type_Boolean = false;
  
  public MaterialCardView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MaterialCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.A);
  }
  
  public MaterialCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, jdField_a_of_type_Int), paramAttributeSet, paramInt);
    paramContext = ThemeEnforcement.a(getContext(), paramAttributeSet, R.styleable.T, paramInt, jdField_a_of_type_Int, new int[0]);
    this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardViewHelper = new MaterialCardViewHelper(this, paramAttributeSet, paramInt, jdField_a_of_type_Int);
    this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardViewHelper.b(super.getCardBackgroundColor());
    this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardViewHelper.a(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
    this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardViewHelper.a(paramContext);
    paramContext.recycle();
  }
  
  @NonNull
  private RectF a()
  {
    RectF localRectF = new RectF();
    localRectF.set(this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardViewHelper.a().getBounds());
    return localRectF;
  }
  
  private void a()
  {
    if (Build.VERSION.SDK_INT > 26) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardViewHelper.f();
    }
  }
  
  float a()
  {
    return a(this);
  }
  
  @NonNull
  public ShapeAppearanceModel a()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardViewHelper.a();
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setContentPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  void a(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
  }
  
  public boolean a_()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public boolean b()
  {
    MaterialCardViewHelper localMaterialCardViewHelper = this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardViewHelper;
    return (localMaterialCardViewHelper != null) && (localMaterialCardViewHelper.b());
  }
  
  @NonNull
  public ColorStateList getCardBackgroundColor()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardViewHelper.a();
  }
  
  public int getContentPaddingBottom()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardViewHelper.a().bottom;
  }
  
  public int getContentPaddingLeft()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardViewHelper.a().left;
  }
  
  public int getContentPaddingRight()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardViewHelper.a().right;
  }
  
  public int getContentPaddingTop()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardViewHelper.a().top;
  }
  
  public float getRadius()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardViewHelper.a();
  }
  
  public boolean isChecked()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    MaterialShapeUtils.a(this, this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardViewHelper.a());
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 3);
    if (b()) {
      mergeDrawableStates(arrayOfInt, jdField_a_of_type_ArrayOfInt);
    }
    if (isChecked()) {
      mergeDrawableStates(arrayOfInt, jdField_b_of_type_ArrayOfInt);
    }
    if (a_()) {
      mergeDrawableStates(arrayOfInt, jdField_c_of_type_ArrayOfInt);
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
    paramAccessibilityNodeInfo.setCheckable(b());
    paramAccessibilityNodeInfo.setClickable(isClickable());
    paramAccessibilityNodeInfo.setChecked(isChecked());
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardViewHelper.a(getMeasuredWidth(), getMeasuredHeight());
  }
  
  public void setBackground(Drawable paramDrawable)
  {
    setBackgroundDrawable(paramDrawable);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (!this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardViewHelper.a())
      {
        Log.i("MaterialCardView", "Setting a custom background is not supported.");
        this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardViewHelper.a(true);
      }
      super.setBackgroundDrawable(paramDrawable);
    }
  }
  
  public void setCardBackgroundColor(@ColorInt int paramInt)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardViewHelper.b(ColorStateList.valueOf(paramInt));
  }
  
  public void setCardBackgroundColor(@Nullable ColorStateList paramColorStateList)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardViewHelper.b(paramColorStateList);
  }
  
  public void setCardElevation(float paramFloat)
  {
    super.setCardElevation(paramFloat);
    this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardViewHelper.b();
  }
  
  public void setCardForegroundColor(@Nullable ColorStateList paramColorStateList)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardViewHelper.c(paramColorStateList);
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardViewHelper.b(paramBoolean);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean != paramBoolean) {
      toggle();
    }
  }
  
  public void setCheckedIcon(@Nullable Drawable paramDrawable)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardViewHelper.a(paramDrawable);
  }
  
  public void setCheckedIconMargin(@Dimension int paramInt)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardViewHelper.c(paramInt);
  }
  
  public void setCheckedIconMarginResource(@DimenRes int paramInt)
  {
    if (paramInt != -1) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardViewHelper.c(getResources().getDimensionPixelSize(paramInt));
    }
  }
  
  public void setCheckedIconResource(@DrawableRes int paramInt)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardViewHelper.a(AppCompatResources.getDrawable(getContext(), paramInt));
  }
  
  public void setCheckedIconSize(@Dimension int paramInt)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardViewHelper.b(paramInt);
  }
  
  public void setCheckedIconSizeResource(@DimenRes int paramInt)
  {
    if (paramInt != 0) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardViewHelper.b(getResources().getDimensionPixelSize(paramInt));
    }
  }
  
  public void setCheckedIconTint(@Nullable ColorStateList paramColorStateList)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardViewHelper.e(paramColorStateList);
  }
  
  public void setClickable(boolean paramBoolean)
  {
    super.setClickable(paramBoolean);
    MaterialCardViewHelper localMaterialCardViewHelper = this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardViewHelper;
    if (localMaterialCardViewHelper != null) {
      localMaterialCardViewHelper.a();
    }
  }
  
  public void setContentPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardViewHelper.a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setDragged(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_Boolean != paramBoolean)
    {
      this.jdField_c_of_type_Boolean = paramBoolean;
      refreshDrawableState();
      a();
      invalidate();
    }
  }
  
  public void setMaxCardElevation(float paramFloat)
  {
    super.setMaxCardElevation(paramFloat);
    this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardViewHelper.c();
  }
  
  public void setOnCheckedChangeListener(@Nullable MaterialCardView.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardView$OnCheckedChangeListener = paramOnCheckedChangeListener;
  }
  
  public void setPreventCornerOverlap(boolean paramBoolean)
  {
    super.setPreventCornerOverlap(paramBoolean);
    this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardViewHelper.c();
    this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardViewHelper.e();
  }
  
  public void setProgress(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardViewHelper.b(paramFloat);
  }
  
  public void setRadius(float paramFloat)
  {
    super.setRadius(paramFloat);
    this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardViewHelper.a(paramFloat);
  }
  
  public void setRippleColor(@Nullable ColorStateList paramColorStateList)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardViewHelper.d(paramColorStateList);
  }
  
  public void setRippleColorResource(@ColorRes int paramInt)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardViewHelper.d(AppCompatResources.getColorStateList(getContext(), paramInt));
  }
  
  public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel paramShapeAppearanceModel)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      setClipToOutline(paramShapeAppearanceModel.a(a()));
    }
    this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardViewHelper.a(paramShapeAppearanceModel);
  }
  
  public void setStrokeColor(@ColorInt int paramInt)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardViewHelper.a(ColorStateList.valueOf(paramInt));
  }
  
  public void setStrokeColor(ColorStateList paramColorStateList)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardViewHelper.a(paramColorStateList);
  }
  
  public void setStrokeWidth(@Dimension int paramInt)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardViewHelper.a(paramInt);
  }
  
  public void setUseCompatPadding(boolean paramBoolean)
  {
    super.setUseCompatPadding(paramBoolean);
    this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardViewHelper.c();
    this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardViewHelper.e();
  }
  
  public void toggle()
  {
    if ((b()) && (isEnabled()))
    {
      this.jdField_b_of_type_Boolean ^= true;
      refreshDrawableState();
      a();
      MaterialCardView.OnCheckedChangeListener localOnCheckedChangeListener = this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardView$OnCheckedChangeListener;
      if (localOnCheckedChangeListener != null) {
        localOnCheckedChangeListener.a(this, this.jdField_b_of_type_Boolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.card.MaterialCardView
 * JD-Core Version:    0.7.0.1
 */