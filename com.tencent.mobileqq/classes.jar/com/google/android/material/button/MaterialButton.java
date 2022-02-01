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
  private static final int jdField_a_of_type_Int = R.style.t;
  private static final int[] jdField_a_of_type_ArrayOfInt = { 16842911 };
  private static final int[] jdField_b_of_type_ArrayOfInt = { 16842912 };
  @Nullable
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  @Nullable
  private PorterDuff.Mode jdField_a_of_type_AndroidGraphicsPorterDuff$Mode;
  @Nullable
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  @Nullable
  private MaterialButton.OnPressedChangeListener jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButton$OnPressedChangeListener;
  @NonNull
  private final MaterialButtonHelper jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButtonHelper;
  @NonNull
  private final LinkedHashSet<MaterialButton.OnCheckedChangeListener> jdField_a_of_type_JavaUtilLinkedHashSet = new LinkedHashSet();
  private boolean jdField_a_of_type_Boolean;
  @Px
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  @Px
  private int c;
  @Px
  private int d;
  @Px
  private int e;
  private int f;
  
  public MaterialButton(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MaterialButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.v);
  }
  
  public MaterialButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, jdField_a_of_type_Int), paramAttributeSet, paramInt);
    boolean bool = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    paramContext = getContext();
    TypedArray localTypedArray = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.P, paramInt, jdField_a_of_type_Int, new int[0]);
    this.e = localTypedArray.getDimensionPixelSize(R.styleable.ct, 0);
    this.jdField_a_of_type_AndroidGraphicsPorterDuff$Mode = ViewUtils.a(localTypedArray.getInt(R.styleable.cw, -1), PorterDuff.Mode.SRC_IN);
    this.jdField_a_of_type_AndroidContentResColorStateList = MaterialResources.a(getContext(), localTypedArray, R.styleable.cv);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = MaterialResources.a(getContext(), localTypedArray, R.styleable.cr);
    this.f = localTypedArray.getInteger(R.styleable.cs, 1);
    this.jdField_b_of_type_Int = localTypedArray.getDimensionPixelSize(R.styleable.cu, 0);
    this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButtonHelper = new MaterialButtonHelper(this, ShapeAppearanceModel.a(paramContext, paramAttributeSet, paramInt, jdField_a_of_type_Int).a());
    this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButtonHelper.a(localTypedArray);
    localTypedArray.recycle();
    setCompoundDrawablePadding(this.e);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      bool = true;
    }
    b(bool);
  }
  
  @NonNull
  private String a()
  {
    Object localObject;
    if (a()) {
      localObject = CompoundButton.class;
    } else {
      localObject = Button.class;
    }
    return ((Class)localObject).getName();
  }
  
  private void a()
  {
    if (c())
    {
      TextViewCompat.setCompoundDrawablesRelative(this, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
      return;
    }
    if (d())
    {
      TextViewCompat.setCompoundDrawablesRelative(this, null, null, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null);
      return;
    }
    if (e()) {
      TextViewCompat.setCompoundDrawablesRelative(this, null, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null);
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      if (getLayout() == null) {
        return;
      }
      int i;
      if ((!c()) && (!d()))
      {
        if (e())
        {
          this.c = 0;
          if (this.f == 16)
          {
            this.d = 0;
            b(false);
            return;
          }
          i = this.jdField_b_of_type_Int;
          paramInt1 = i;
          if (i == 0) {
            paramInt1 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
          }
          paramInt1 = (paramInt2 - d() - getPaddingTop() - paramInt1 - this.e - getPaddingBottom()) / 2;
          if (this.d != paramInt1)
          {
            this.d = paramInt1;
            b(false);
          }
        }
      }
      else
      {
        this.d = 0;
        paramInt2 = this.f;
        boolean bool1 = true;
        if ((paramInt2 == 1) || (paramInt2 == 3)) {
          break label250;
        }
        i = this.jdField_b_of_type_Int;
        paramInt2 = i;
        if (i == 0) {
          paramInt2 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
        }
        paramInt2 = (paramInt1 - c() - ViewCompat.getPaddingEnd(this) - paramInt2 - this.e - ViewCompat.getPaddingStart(this)) / 2;
        boolean bool2 = b();
        if (this.f != 4) {
          bool1 = false;
        }
        paramInt1 = paramInt2;
        if (bool2 != bool1) {
          paramInt1 = -paramInt2;
        }
        if (this.c != paramInt1)
        {
          this.c = paramInt1;
          b(false);
        }
      }
      return;
      label250:
      this.c = 0;
      b(false);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    int i;
    if (localObject1 != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = DrawableCompat.wrap((Drawable)localObject1).mutate();
      DrawableCompat.setTintList(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidContentResColorStateList);
      localObject1 = this.jdField_a_of_type_AndroidGraphicsPorterDuff$Mode;
      if (localObject1 != null) {
        DrawableCompat.setTintMode(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, (PorterDuff.Mode)localObject1);
      }
      i = this.jdField_b_of_type_Int;
      if (i == 0) {
        i = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
      }
      j = this.jdField_b_of_type_Int;
      if (j == 0) {
        j = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
      }
      localObject1 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      int k = this.c;
      int m = this.d;
      ((Drawable)localObject1).setBounds(k, m, i + k, j + m);
    }
    if (paramBoolean)
    {
      a();
      return;
    }
    Object localObject3 = TextViewCompat.getCompoundDrawablesRelative(this);
    int j = 0;
    localObject1 = localObject3[0];
    Object localObject2 = localObject3[1];
    localObject3 = localObject3[2];
    if (((!c()) || (localObject1 == this.jdField_a_of_type_AndroidGraphicsDrawableDrawable)) && ((!d()) || (localObject3 == this.jdField_a_of_type_AndroidGraphicsDrawableDrawable)))
    {
      i = j;
      if (e())
      {
        i = j;
        if (localObject2 == this.jdField_a_of_type_AndroidGraphicsDrawableDrawable) {}
      }
    }
    else
    {
      i = 1;
    }
    if (i != 0) {
      a();
    }
  }
  
  private boolean b()
  {
    return ViewCompat.getLayoutDirection(this) == 1;
  }
  
  private int c()
  {
    TextPaint localTextPaint = getPaint();
    String str2 = getText().toString();
    String str1 = str2;
    if (getTransformationMethod() != null) {
      str1 = getTransformationMethod().getTransformation(str2, this).toString();
    }
    return Math.min((int)localTextPaint.measureText(str1), getLayout().getEllipsizedWidth());
  }
  
  private boolean c()
  {
    int i = this.f;
    boolean bool = true;
    if (i != 1)
    {
      if (i == 2) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private int d()
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
  
  private boolean d()
  {
    int i = this.f;
    return (i == 3) || (i == 4);
  }
  
  private boolean e()
  {
    int i = this.f;
    return (i == 16) || (i == 32);
  }
  
  private boolean f()
  {
    MaterialButtonHelper localMaterialButtonHelper = this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButtonHelper;
    return (localMaterialButtonHelper != null) && (!localMaterialButtonHelper.a());
  }
  
  @Px
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public Drawable a()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  @NonNull
  public ShapeAppearanceModel a()
  {
    if (f()) {
      return this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButtonHelper.a();
    }
    throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
  }
  
  void a(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
  }
  
  public void a(@NonNull MaterialButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.jdField_a_of_type_JavaUtilLinkedHashSet.add(paramOnCheckedChangeListener);
  }
  
  void a(@Nullable MaterialButton.OnPressedChangeListener paramOnPressedChangeListener)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButton$OnPressedChangeListener = paramOnPressedChangeListener;
  }
  
  void a(boolean paramBoolean)
  {
    if (f()) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButtonHelper.a(paramBoolean);
    }
  }
  
  public boolean a()
  {
    MaterialButtonHelper localMaterialButtonHelper = this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButtonHelper;
    return (localMaterialButtonHelper != null) && (localMaterialButtonHelper.b());
  }
  
  @Px
  public int b()
  {
    if (f()) {
      return this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButtonHelper.a();
    }
    return 0;
  }
  
  @Nullable
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public ColorStateList getSupportBackgroundTintList()
  {
    if (f()) {
      return this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButtonHelper.a();
    }
    return super.getSupportBackgroundTintList();
  }
  
  @Nullable
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    if (f()) {
      return this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButtonHelper.a();
    }
    return super.getSupportBackgroundTintMode();
  }
  
  public boolean isChecked()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (f()) {
      MaterialShapeUtils.a(this, this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButtonHelper.a());
    }
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 2);
    if (a()) {
      mergeDrawableStates(arrayOfInt, jdField_a_of_type_ArrayOfInt);
    }
    if (isChecked()) {
      mergeDrawableStates(arrayOfInt, jdField_b_of_type_ArrayOfInt);
    }
    return arrayOfInt;
  }
  
  public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(a());
    paramAccessibilityEvent.setChecked(isChecked());
  }
  
  public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(a());
    paramAccessibilityNodeInfo.setCheckable(a());
    paramAccessibilityNodeInfo.setChecked(isChecked());
    paramAccessibilityNodeInfo.setClickable(isClickable());
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (Build.VERSION.SDK_INT == 21)
    {
      MaterialButtonHelper localMaterialButtonHelper = this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButtonHelper;
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
    setChecked(paramParcelable.jdField_a_of_type_Boolean);
  }
  
  @NonNull
  public Parcelable onSaveInstanceState()
  {
    MaterialButton.SavedState localSavedState = new MaterialButton.SavedState(super.onSaveInstanceState());
    localSavedState.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
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
    if (f())
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButtonHelper.a(paramInt);
      return;
    }
    super.setBackgroundColor(paramInt);
  }
  
  public void setBackgroundDrawable(@NonNull Drawable paramDrawable)
  {
    if (f())
    {
      if (paramDrawable != getBackground())
      {
        Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
        this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButtonHelper.a();
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
    if (f()) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButtonHelper.b(paramBoolean);
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if ((a()) && (isEnabled()) && (this.jdField_a_of_type_Boolean != paramBoolean))
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      refreshDrawableState();
      if (this.jdField_b_of_type_Boolean) {
        return;
      }
      this.jdField_b_of_type_Boolean = true;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashSet.iterator();
      while (localIterator.hasNext()) {
        ((MaterialButton.OnCheckedChangeListener)localIterator.next()).a(this, this.jdField_a_of_type_Boolean);
      }
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public void setCornerRadius(@Px int paramInt)
  {
    if (f()) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButtonHelper.c(paramInt);
    }
  }
  
  public void setCornerRadiusResource(@DimenRes int paramInt)
  {
    if (f()) {
      setCornerRadius(getResources().getDimensionPixelSize(paramInt));
    }
  }
  
  @RequiresApi(21)
  public void setElevation(float paramFloat)
  {
    super.setElevation(paramFloat);
    if (f()) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButtonHelper.a().r(paramFloat);
    }
  }
  
  public void setIcon(@Nullable Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != paramDrawable)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      b(true);
      a(getMeasuredWidth(), getMeasuredHeight());
    }
  }
  
  public void setIconGravity(int paramInt)
  {
    if (this.f != paramInt)
    {
      this.f = paramInt;
      a(getMeasuredWidth(), getMeasuredHeight());
    }
  }
  
  public void setIconPadding(@Px int paramInt)
  {
    if (this.e != paramInt)
    {
      this.e = paramInt;
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
      if (this.jdField_b_of_type_Int != paramInt)
      {
        this.jdField_b_of_type_Int = paramInt;
        b(true);
      }
      return;
    }
    throw new IllegalArgumentException("iconSize cannot be less than 0");
  }
  
  public void setIconTint(@Nullable ColorStateList paramColorStateList)
  {
    if (this.jdField_a_of_type_AndroidContentResColorStateList != paramColorStateList)
    {
      this.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList;
      b(false);
    }
  }
  
  public void setIconTintMode(PorterDuff.Mode paramMode)
  {
    if (this.jdField_a_of_type_AndroidGraphicsPorterDuff$Mode != paramMode)
    {
      this.jdField_a_of_type_AndroidGraphicsPorterDuff$Mode = paramMode;
      b(false);
    }
  }
  
  public void setIconTintResource(@ColorRes int paramInt)
  {
    setIconTint(AppCompatResources.getColorStateList(getContext(), paramInt));
  }
  
  public void setInsetBottom(@Dimension int paramInt)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButtonHelper.d(paramInt);
  }
  
  public void setInsetTop(@Dimension int paramInt)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButtonHelper.e(paramInt);
  }
  
  public void setPressed(boolean paramBoolean)
  {
    MaterialButton.OnPressedChangeListener localOnPressedChangeListener = this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButton$OnPressedChangeListener;
    if (localOnPressedChangeListener != null) {
      localOnPressedChangeListener.a(this, paramBoolean);
    }
    super.setPressed(paramBoolean);
  }
  
  public void setRippleColor(@Nullable ColorStateList paramColorStateList)
  {
    if (f()) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButtonHelper.b(paramColorStateList);
    }
  }
  
  public void setRippleColorResource(@ColorRes int paramInt)
  {
    if (f()) {
      setRippleColor(AppCompatResources.getColorStateList(getContext(), paramInt));
    }
  }
  
  public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel paramShapeAppearanceModel)
  {
    if (f())
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButtonHelper.a(paramShapeAppearanceModel);
      return;
    }
    throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
  }
  
  public void setStrokeColor(@Nullable ColorStateList paramColorStateList)
  {
    if (f()) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButtonHelper.c(paramColorStateList);
    }
  }
  
  public void setStrokeColorResource(@ColorRes int paramInt)
  {
    if (f()) {
      setStrokeColor(AppCompatResources.getColorStateList(getContext(), paramInt));
    }
  }
  
  public void setStrokeWidth(@Px int paramInt)
  {
    if (f()) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButtonHelper.b(paramInt);
    }
  }
  
  public void setStrokeWidthResource(@DimenRes int paramInt)
  {
    if (f()) {
      setStrokeWidth(getResources().getDimensionPixelSize(paramInt));
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void setSupportBackgroundTintList(@Nullable ColorStateList paramColorStateList)
  {
    if (f())
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButtonHelper.a(paramColorStateList);
      return;
    }
    super.setSupportBackgroundTintList(paramColorStateList);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    if (f())
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButtonHelper.a(paramMode);
      return;
    }
    super.setSupportBackgroundTintMode(paramMode);
  }
  
  public void toggle()
  {
    setChecked(this.jdField_a_of_type_Boolean ^ true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.button.MaterialButton
 * JD-Core Version:    0.7.0.1
 */