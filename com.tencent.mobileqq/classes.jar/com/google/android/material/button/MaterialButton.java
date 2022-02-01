package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R.attr;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearanceModel.Builder;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class MaterialButton
  extends AppCompatButton
  implements Checkable, Shapeable
{
  private static final int[] a = { 16842911 };
  private static final int[] b = { 16842912 };
  private static final int c = R.style.v;
  @NonNull
  private final MaterialButtonHelper d;
  @NonNull
  private final LinkedHashSet<MaterialButton.OnCheckedChangeListener> e = new LinkedHashSet();
  @Nullable
  private MaterialButton.OnPressedChangeListener f;
  @Nullable
  private PorterDuff.Mode g;
  @Nullable
  private ColorStateList h;
  @Nullable
  private Drawable i;
  @Px
  private int j;
  @Px
  private int k;
  @Px
  private int l;
  @Px
  private int m;
  private boolean n;
  private boolean o;
  private int p;
  
  public MaterialButton(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MaterialButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.C);
  }
  
  public MaterialButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, c), paramAttributeSet, paramInt);
    boolean bool = false;
    this.n = false;
    this.o = false;
    paramContext = getContext();
    TypedArray localTypedArray = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.dD, paramInt, c, new int[0]);
    this.m = localTypedArray.getDimensionPixelSize(R.styleable.dQ, 0);
    this.g = ViewUtils.a(localTypedArray.getInt(R.styleable.dT, -1), PorterDuff.Mode.SRC_IN);
    this.h = MaterialResources.a(getContext(), localTypedArray, R.styleable.dS);
    this.i = MaterialResources.b(getContext(), localTypedArray, R.styleable.dO);
    this.p = localTypedArray.getInteger(R.styleable.dP, 1);
    this.j = localTypedArray.getDimensionPixelSize(R.styleable.dR, 0);
    this.d = new MaterialButtonHelper(this, ShapeAppearanceModel.a(paramContext, paramAttributeSet, paramInt, c).a());
    this.d.a(localTypedArray);
    localTypedArray.recycle();
    setCompoundDrawablePadding(this.m);
    if (this.i != null) {
      bool = true;
    }
    a(bool);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.i != null)
    {
      if (getLayout() == null) {
        return;
      }
      int i1;
      if ((!d()) && (!e()))
      {
        if (f())
        {
          this.k = 0;
          if (this.p == 16)
          {
            this.l = 0;
            a(false);
            return;
          }
          i1 = this.j;
          paramInt1 = i1;
          if (i1 == 0) {
            paramInt1 = this.i.getIntrinsicHeight();
          }
          paramInt1 = (paramInt2 - getTextHeight() - getPaddingTop() - paramInt1 - this.m - getPaddingBottom()) / 2;
          if (this.l != paramInt1)
          {
            this.l = paramInt1;
            a(false);
          }
        }
      }
      else
      {
        this.l = 0;
        paramInt2 = this.p;
        boolean bool1 = true;
        if ((paramInt2 == 1) || (paramInt2 == 3)) {
          break label250;
        }
        i1 = this.j;
        paramInt2 = i1;
        if (i1 == 0) {
          paramInt2 = this.i.getIntrinsicWidth();
        }
        paramInt2 = (paramInt1 - getTextWidth() - ViewCompat.getPaddingEnd(this) - paramInt2 - this.m - ViewCompat.getPaddingStart(this)) / 2;
        boolean bool2 = b();
        if (this.p != 4) {
          bool1 = false;
        }
        paramInt1 = paramInt2;
        if (bool2 != bool1) {
          paramInt1 = -paramInt2;
        }
        if (this.k != paramInt1)
        {
          this.k = paramInt1;
          a(false);
        }
      }
      return;
      label250:
      this.k = 0;
      a(false);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject1 = this.i;
    int i1;
    if (localObject1 != null)
    {
      this.i = DrawableCompat.wrap((Drawable)localObject1).mutate();
      DrawableCompat.setTintList(this.i, this.h);
      localObject1 = this.g;
      if (localObject1 != null) {
        DrawableCompat.setTintMode(this.i, (PorterDuff.Mode)localObject1);
      }
      i1 = this.j;
      if (i1 == 0) {
        i1 = this.i.getIntrinsicWidth();
      }
      i2 = this.j;
      if (i2 == 0) {
        i2 = this.i.getIntrinsicHeight();
      }
      localObject1 = this.i;
      int i3 = this.k;
      int i4 = this.l;
      ((Drawable)localObject1).setBounds(i3, i4, i1 + i3, i2 + i4);
    }
    if (paramBoolean)
    {
      c();
      return;
    }
    Object localObject3 = TextViewCompat.getCompoundDrawablesRelative(this);
    int i2 = 0;
    localObject1 = localObject3[0];
    Object localObject2 = localObject3[1];
    localObject3 = localObject3[2];
    if (((!d()) || (localObject1 == this.i)) && ((!e()) || (localObject3 == this.i)))
    {
      i1 = i2;
      if (f())
      {
        i1 = i2;
        if (localObject2 == this.i) {}
      }
    }
    else
    {
      i1 = 1;
    }
    if (i1 != 0) {
      c();
    }
  }
  
  private boolean b()
  {
    return ViewCompat.getLayoutDirection(this) == 1;
  }
  
  private void c()
  {
    if (d())
    {
      TextViewCompat.setCompoundDrawablesRelative(this, this.i, null, null, null);
      return;
    }
    if (e())
    {
      TextViewCompat.setCompoundDrawablesRelative(this, null, null, this.i, null);
      return;
    }
    if (f()) {
      TextViewCompat.setCompoundDrawablesRelative(this, null, this.i, null, null);
    }
  }
  
  private boolean d()
  {
    int i1 = this.p;
    boolean bool = true;
    if (i1 != 1)
    {
      if (i1 == 2) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private boolean e()
  {
    int i1 = this.p;
    return (i1 == 3) || (i1 == 4);
  }
  
  private boolean f()
  {
    int i1 = this.p;
    return (i1 == 16) || (i1 == 32);
  }
  
  private boolean g()
  {
    MaterialButtonHelper localMaterialButtonHelper = this.d;
    return (localMaterialButtonHelper != null) && (!localMaterialButtonHelper.b());
  }
  
  @NonNull
  private String getA11yClassName()
  {
    Object localObject;
    if (a()) {
      localObject = CompoundButton.class;
    } else {
      localObject = Button.class;
    }
    return ((Class)localObject).getName();
  }
  
  private int getTextHeight()
  {
    TextPaint localTextPaint = getPaint();
    Object localObject2 = getText().toString();
    Object localObject1 = localObject2;
    if (getTransformationMethod() != null) {
      localObject1 = getTransformationMethod().getTransformation((CharSequence)localObject2, this).toString();
    }
    localObject2 = new Rect();
    localTextPaint.getTextBounds((String)localObject1, 0, ((String)localObject1).length(), (Rect)localObject2);
    return Math.min(((Rect)localObject2).height(), getLayout().getHeight());
  }
  
  private int getTextWidth()
  {
    TextPaint localTextPaint = getPaint();
    String str2 = getText().toString();
    String str1 = str2;
    if (getTransformationMethod() != null) {
      str1 = getTransformationMethod().getTransformation(str2, this).toString();
    }
    return Math.min((int)localTextPaint.measureText(str1), getLayout().getEllipsizedWidth());
  }
  
  public void a(@NonNull MaterialButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.e.add(paramOnCheckedChangeListener);
  }
  
  public boolean a()
  {
    MaterialButtonHelper localMaterialButtonHelper = this.d;
    return (localMaterialButtonHelper != null) && (localMaterialButtonHelper.j());
  }
  
  @Nullable
  public ColorStateList getBackgroundTintList()
  {
    return getSupportBackgroundTintList();
  }
  
  @Nullable
  public PorterDuff.Mode getBackgroundTintMode()
  {
    return getSupportBackgroundTintMode();
  }
  
  @Px
  public int getCornerRadius()
  {
    if (g()) {
      return this.d.h();
    }
    return 0;
  }
  
  public Drawable getIcon()
  {
    return this.i;
  }
  
  public int getIconGravity()
  {
    return this.p;
  }
  
  @Px
  public int getIconPadding()
  {
    return this.m;
  }
  
  @Px
  public int getIconSize()
  {
    return this.j;
  }
  
  public ColorStateList getIconTint()
  {
    return this.h;
  }
  
  public PorterDuff.Mode getIconTintMode()
  {
    return this.g;
  }
  
  @Dimension
  public int getInsetBottom()
  {
    return this.d.m();
  }
  
  @Dimension
  public int getInsetTop()
  {
    return this.d.n();
  }
  
  @Nullable
  public ColorStateList getRippleColor()
  {
    if (g()) {
      return this.d.e();
    }
    return null;
  }
  
  @NonNull
  public ShapeAppearanceModel getShapeAppearanceModel()
  {
    if (g()) {
      return this.d.l();
    }
    throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
  }
  
  public ColorStateList getStrokeColor()
  {
    if (g()) {
      return this.d.f();
    }
    return null;
  }
  
  @Px
  public int getStrokeWidth()
  {
    if (g()) {
      return this.d.g();
    }
    return 0;
  }
  
  @Nullable
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public ColorStateList getSupportBackgroundTintList()
  {
    if (g()) {
      return this.d.c();
    }
    return super.getSupportBackgroundTintList();
  }
  
  @Nullable
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    if (g()) {
      return this.d.d();
    }
    return super.getSupportBackgroundTintMode();
  }
  
  public boolean isChecked()
  {
    return this.n;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (g()) {
      MaterialShapeUtils.a(this, this.d.i());
    }
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 2);
    if (a()) {
      mergeDrawableStates(arrayOfInt, a);
    }
    if (isChecked()) {
      mergeDrawableStates(arrayOfInt, b);
    }
    return arrayOfInt;
  }
  
  public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(getA11yClassName());
    paramAccessibilityEvent.setChecked(isChecked());
  }
  
  public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(getA11yClassName());
    paramAccessibilityNodeInfo.setCheckable(a());
    paramAccessibilityNodeInfo.setChecked(isChecked());
    paramAccessibilityNodeInfo.setClickable(isClickable());
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (Build.VERSION.SDK_INT == 21)
    {
      MaterialButtonHelper localMaterialButtonHelper = this.d;
      if (localMaterialButtonHelper != null) {
        localMaterialButtonHelper.a(paramInt4 - paramInt2, paramInt3 - paramInt1);
      }
    }
  }
  
  public void onRestoreInstanceState(@Nullable Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof MaterialButton.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (MaterialButton.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    setChecked(paramParcelable.a);
  }
  
  @NonNull
  public Parcelable onSaveInstanceState()
  {
    MaterialButton.SavedState localSavedState = new MaterialButton.SavedState(super.onSaveInstanceState());
    localSavedState.a = this.n;
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    a(paramInt1, paramInt2);
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    a(getMeasuredWidth(), getMeasuredHeight());
  }
  
  public boolean performClick()
  {
    toggle();
    return super.performClick();
  }
  
  public void setBackground(@NonNull Drawable paramDrawable)
  {
    setBackgroundDrawable(paramDrawable);
  }
  
  public void setBackgroundColor(@ColorInt int paramInt)
  {
    if (g())
    {
      this.d.a(paramInt);
      return;
    }
    super.setBackgroundColor(paramInt);
  }
  
  public void setBackgroundDrawable(@NonNull Drawable paramDrawable)
  {
    if (g())
    {
      if (paramDrawable != getBackground())
      {
        Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
        this.d.a();
        super.setBackgroundDrawable(paramDrawable);
        return;
      }
      getBackground().setState(paramDrawable.getState());
      return;
    }
    super.setBackgroundDrawable(paramDrawable);
  }
  
  public void setBackgroundResource(@DrawableRes int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = AppCompatResources.getDrawable(getContext(), paramInt);
    } else {
      localDrawable = null;
    }
    setBackgroundDrawable(localDrawable);
  }
  
  public void setBackgroundTintList(@Nullable ColorStateList paramColorStateList)
  {
    setSupportBackgroundTintList(paramColorStateList);
  }
  
  public void setBackgroundTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    setSupportBackgroundTintMode(paramMode);
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    if (g()) {
      this.d.b(paramBoolean);
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if ((a()) && (isEnabled()) && (this.n != paramBoolean))
    {
      this.n = paramBoolean;
      refreshDrawableState();
      if (this.o) {
        return;
      }
      this.o = true;
      Iterator localIterator = this.e.iterator();
      while (localIterator.hasNext()) {
        ((MaterialButton.OnCheckedChangeListener)localIterator.next()).a(this, this.n);
      }
      this.o = false;
    }
  }
  
  public void setCornerRadius(@Px int paramInt)
  {
    if (g()) {
      this.d.c(paramInt);
    }
  }
  
  public void setCornerRadiusResource(@DimenRes int paramInt)
  {
    if (g()) {
      setCornerRadius(getResources().getDimensionPixelSize(paramInt));
    }
  }
  
  @RequiresApi(21)
  public void setElevation(float paramFloat)
  {
    super.setElevation(paramFloat);
    if (g()) {
      this.d.i().r(paramFloat);
    }
  }
  
  public void setIcon(@Nullable Drawable paramDrawable)
  {
    if (this.i != paramDrawable)
    {
      this.i = paramDrawable;
      a(true);
      a(getMeasuredWidth(), getMeasuredHeight());
    }
  }
  
  public void setIconGravity(int paramInt)
  {
    if (this.p != paramInt)
    {
      this.p = paramInt;
      a(getMeasuredWidth(), getMeasuredHeight());
    }
  }
  
  public void setIconPadding(@Px int paramInt)
  {
    if (this.m != paramInt)
    {
      this.m = paramInt;
      setCompoundDrawablePadding(paramInt);
    }
  }
  
  public void setIconResource(@DrawableRes int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = AppCompatResources.getDrawable(getContext(), paramInt);
    } else {
      localDrawable = null;
    }
    setIcon(localDrawable);
  }
  
  public void setIconSize(@Px int paramInt)
  {
    if (paramInt >= 0)
    {
      if (this.j != paramInt)
      {
        this.j = paramInt;
        a(true);
      }
      return;
    }
    throw new IllegalArgumentException("iconSize cannot be less than 0");
  }
  
  public void setIconTint(@Nullable ColorStateList paramColorStateList)
  {
    if (this.h != paramColorStateList)
    {
      this.h = paramColorStateList;
      a(false);
    }
  }
  
  public void setIconTintMode(PorterDuff.Mode paramMode)
  {
    if (this.g != paramMode)
    {
      this.g = paramMode;
      a(false);
    }
  }
  
  public void setIconTintResource(@ColorRes int paramInt)
  {
    setIconTint(AppCompatResources.getColorStateList(getContext(), paramInt));
  }
  
  public void setInsetBottom(@Dimension int paramInt)
  {
    this.d.d(paramInt);
  }
  
  public void setInsetTop(@Dimension int paramInt)
  {
    this.d.e(paramInt);
  }
  
  void setInternalBackground(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
  }
  
  void setOnPressedChangeListenerInternal(@Nullable MaterialButton.OnPressedChangeListener paramOnPressedChangeListener)
  {
    this.f = paramOnPressedChangeListener;
  }
  
  public void setPressed(boolean paramBoolean)
  {
    MaterialButton.OnPressedChangeListener localOnPressedChangeListener = this.f;
    if (localOnPressedChangeListener != null) {
      localOnPressedChangeListener.a(this, paramBoolean);
    }
    super.setPressed(paramBoolean);
  }
  
  public void setRippleColor(@Nullable ColorStateList paramColorStateList)
  {
    if (g()) {
      this.d.b(paramColorStateList);
    }
  }
  
  public void setRippleColorResource(@ColorRes int paramInt)
  {
    if (g()) {
      setRippleColor(AppCompatResources.getColorStateList(getContext(), paramInt));
    }
  }
  
  public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel paramShapeAppearanceModel)
  {
    if (g())
    {
      this.d.a(paramShapeAppearanceModel);
      return;
    }
    throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
  }
  
  void setShouldDrawSurfaceColorStroke(boolean paramBoolean)
  {
    if (g()) {
      this.d.a(paramBoolean);
    }
  }
  
  public void setStrokeColor(@Nullable ColorStateList paramColorStateList)
  {
    if (g()) {
      this.d.c(paramColorStateList);
    }
  }
  
  public void setStrokeColorResource(@ColorRes int paramInt)
  {
    if (g()) {
      setStrokeColor(AppCompatResources.getColorStateList(getContext(), paramInt));
    }
  }
  
  public void setStrokeWidth(@Px int paramInt)
  {
    if (g()) {
      this.d.b(paramInt);
    }
  }
  
  public void setStrokeWidthResource(@DimenRes int paramInt)
  {
    if (g()) {
      setStrokeWidth(getResources().getDimensionPixelSize(paramInt));
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void setSupportBackgroundTintList(@Nullable ColorStateList paramColorStateList)
  {
    if (g())
    {
      this.d.a(paramColorStateList);
      return;
    }
    super.setSupportBackgroundTintList(paramColorStateList);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    if (g())
    {
      this.d.a(paramMode);
      return;
    }
    super.setSupportBackgroundTintMode(paramMode);
  }
  
  public void toggle()
  {
    setChecked(this.n ^ true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.button.MaterialButton
 * JD-Core Version:    0.7.0.1
 */