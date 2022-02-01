package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R.attr;
import com.google.android.material.R.styleable;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleDrawableCompat;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
class MaterialButtonHelper
{
  private static final boolean jdField_a_of_type_Boolean;
  private int jdField_a_of_type_Int;
  @Nullable
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  @Nullable
  private PorterDuff.Mode jdField_a_of_type_AndroidGraphicsPorterDuff$Mode;
  @Nullable
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private LayerDrawable jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable;
  private final MaterialButton jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButton;
  @NonNull
  private ShapeAppearanceModel jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel;
  private int jdField_b_of_type_Int;
  @Nullable
  private ColorStateList jdField_b_of_type_AndroidContentResColorStateList;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  @Nullable
  private ColorStateList jdField_c_of_type_AndroidContentResColorStateList;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private int f;
  private int g;
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 21) {
      bool = true;
    } else {
      bool = false;
    }
    jdField_a_of_type_Boolean = bool;
  }
  
  MaterialButtonHelper(MaterialButton paramMaterialButton, @NonNull ShapeAppearanceModel paramShapeAppearanceModel)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButton = paramMaterialButton;
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel = paramShapeAppearanceModel;
  }
  
  private Drawable a()
  {
    MaterialShapeDrawable localMaterialShapeDrawable = new MaterialShapeDrawable(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel);
    localMaterialShapeDrawable.a(this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButton.getContext());
    DrawableCompat.setTintList(localMaterialShapeDrawable, this.jdField_a_of_type_AndroidContentResColorStateList);
    Object localObject = this.jdField_a_of_type_AndroidGraphicsPorterDuff$Mode;
    if (localObject != null) {
      DrawableCompat.setTintMode(localMaterialShapeDrawable, (PorterDuff.Mode)localObject);
    }
    localMaterialShapeDrawable.a(this.f, this.jdField_b_of_type_AndroidContentResColorStateList);
    localObject = new MaterialShapeDrawable(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel);
    ((MaterialShapeDrawable)localObject).setTint(0);
    float f1 = this.f;
    int i;
    if (this.jdField_b_of_type_Boolean) {
      i = MaterialColors.a(this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButton, R.attr.n);
    } else {
      i = 0;
    }
    ((MaterialShapeDrawable)localObject).a(f1, i);
    if (jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new MaterialShapeDrawable(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel);
      DrawableCompat.setTint(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, -1);
      this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable = new RippleDrawable(RippleUtils.b(this.jdField_c_of_type_AndroidContentResColorStateList), a(new LayerDrawable(new Drawable[] { localObject, localMaterialShapeDrawable })), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      return this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new RippleDrawableCompat(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel);
    DrawableCompat.setTintList(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, RippleUtils.b(this.jdField_c_of_type_AndroidContentResColorStateList));
    this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable = new LayerDrawable(new Drawable[] { localObject, localMaterialShapeDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable });
    return a(this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable);
  }
  
  @NonNull
  private InsetDrawable a(Drawable paramDrawable)
  {
    return new InsetDrawable(paramDrawable, this.jdField_a_of_type_Int, this.jdField_c_of_type_Int, this.jdField_b_of_type_Int, this.jdField_d_of_type_Int);
  }
  
  @Nullable
  private MaterialShapeDrawable a(boolean paramBoolean)
  {
    LayerDrawable localLayerDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable;
    if ((localLayerDrawable != null) && (localLayerDrawable.getNumberOfLayers() > 0))
    {
      if (jdField_a_of_type_Boolean) {
        return (MaterialShapeDrawable)((LayerDrawable)((InsetDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable.getDrawable(0)).getDrawable()).getDrawable(paramBoolean ^ true);
      }
      return (MaterialShapeDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable.getDrawable(paramBoolean ^ true);
    }
    return null;
  }
  
  @Nullable
  private MaterialShapeDrawable b()
  {
    return a(true);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButton.a(a());
    MaterialShapeDrawable localMaterialShapeDrawable = a();
    if (localMaterialShapeDrawable != null) {
      localMaterialShapeDrawable.r(this.g);
    }
  }
  
  private void b(@Dimension int paramInt1, @Dimension int paramInt2)
  {
    int i = ViewCompat.getPaddingStart(this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButton);
    int j = this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButton.getPaddingTop();
    int k = ViewCompat.getPaddingEnd(this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButton);
    int m = this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButton.getPaddingBottom();
    int n = this.jdField_c_of_type_Int;
    int i1 = this.jdField_d_of_type_Int;
    this.jdField_d_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = paramInt1;
    if (!this.jdField_c_of_type_Boolean) {
      b();
    }
    ViewCompat.setPaddingRelative(this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButton, i, j + paramInt1 - n, k, m + paramInt2 - i1);
  }
  
  private void b(@NonNull ShapeAppearanceModel paramShapeAppearanceModel)
  {
    if (a() != null) {
      a().setShapeAppearanceModel(paramShapeAppearanceModel);
    }
    if (b() != null) {
      b().setShapeAppearanceModel(paramShapeAppearanceModel);
    }
    if (a() != null) {
      a().setShapeAppearanceModel(paramShapeAppearanceModel);
    }
  }
  
  private void c()
  {
    MaterialShapeDrawable localMaterialShapeDrawable1 = a();
    MaterialShapeDrawable localMaterialShapeDrawable2 = b();
    if (localMaterialShapeDrawable1 != null)
    {
      localMaterialShapeDrawable1.a(this.f, this.jdField_b_of_type_AndroidContentResColorStateList);
      if (localMaterialShapeDrawable2 != null)
      {
        float f1 = this.f;
        int i;
        if (this.jdField_b_of_type_Boolean) {
          i = MaterialColors.a(this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButton, R.attr.n);
        } else {
          i = 0;
        }
        localMaterialShapeDrawable2.a(f1, i);
      }
    }
  }
  
  int a()
  {
    return this.f;
  }
  
  ColorStateList a()
  {
    return this.jdField_a_of_type_AndroidContentResColorStateList;
  }
  
  PorterDuff.Mode a()
  {
    return this.jdField_a_of_type_AndroidGraphicsPorterDuff$Mode;
  }
  
  @Nullable
  MaterialShapeDrawable a()
  {
    return a(false);
  }
  
  @NonNull
  ShapeAppearanceModel a()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel;
  }
  
  @Nullable
  public Shapeable a()
  {
    LayerDrawable localLayerDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable;
    if ((localLayerDrawable != null) && (localLayerDrawable.getNumberOfLayers() > 1))
    {
      if (this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable.getNumberOfLayers() > 2) {
        return (Shapeable)this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable.getDrawable(2);
      }
      return (Shapeable)this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable.getDrawable(1);
    }
    return null;
  }
  
  void a()
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButton.setSupportBackgroundTintList(this.jdField_a_of_type_AndroidContentResColorStateList);
    this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButton.setSupportBackgroundTintMode(this.jdField_a_of_type_AndroidGraphicsPorterDuff$Mode);
  }
  
  void a(int paramInt)
  {
    if (a() != null) {
      a().setTint(paramInt);
    }
  }
  
  void a(int paramInt1, int paramInt2)
  {
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localDrawable != null) {
      localDrawable.setBounds(this.jdField_a_of_type_Int, this.jdField_c_of_type_Int, paramInt2 - this.jdField_b_of_type_Int, paramInt1 - this.jdField_d_of_type_Int);
    }
  }
  
  void a(@Nullable ColorStateList paramColorStateList)
  {
    if (this.jdField_a_of_type_AndroidContentResColorStateList != paramColorStateList)
    {
      this.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList;
      if (a() != null) {
        DrawableCompat.setTintList(a(), this.jdField_a_of_type_AndroidContentResColorStateList);
      }
    }
  }
  
  void a(@NonNull TypedArray paramTypedArray)
  {
    this.jdField_a_of_type_Int = paramTypedArray.getDimensionPixelOffset(R.styleable.ci, 0);
    this.jdField_b_of_type_Int = paramTypedArray.getDimensionPixelOffset(R.styleable.cj, 0);
    this.jdField_c_of_type_Int = paramTypedArray.getDimensionPixelOffset(R.styleable.ck, 0);
    this.jdField_d_of_type_Int = paramTypedArray.getDimensionPixelOffset(R.styleable.cl, 0);
    if (paramTypedArray.hasValue(R.styleable.cp))
    {
      this.jdField_e_of_type_Int = paramTypedArray.getDimensionPixelSize(R.styleable.cp, -1);
      a(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel.a(this.jdField_e_of_type_Int));
      this.jdField_d_of_type_Boolean = true;
    }
    this.f = paramTypedArray.getDimensionPixelSize(R.styleable.cz, 0);
    this.jdField_a_of_type_AndroidGraphicsPorterDuff$Mode = ViewUtils.a(paramTypedArray.getInt(R.styleable.co, -1), PorterDuff.Mode.SRC_IN);
    this.jdField_a_of_type_AndroidContentResColorStateList = MaterialResources.a(this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButton.getContext(), paramTypedArray, R.styleable.cn);
    this.jdField_b_of_type_AndroidContentResColorStateList = MaterialResources.a(this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButton.getContext(), paramTypedArray, R.styleable.cy);
    this.jdField_c_of_type_AndroidContentResColorStateList = MaterialResources.a(this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButton.getContext(), paramTypedArray, R.styleable.cx);
    this.jdField_e_of_type_Boolean = paramTypedArray.getBoolean(R.styleable.cm, false);
    this.g = paramTypedArray.getDimensionPixelSize(R.styleable.cq, 0);
    int i = ViewCompat.getPaddingStart(this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButton);
    int j = this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButton.getPaddingTop();
    int k = ViewCompat.getPaddingEnd(this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButton);
    int m = this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButton.getPaddingBottom();
    if (paramTypedArray.hasValue(R.styleable.ch)) {
      a();
    } else {
      b();
    }
    ViewCompat.setPaddingRelative(this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButton, i + this.jdField_a_of_type_Int, j + this.jdField_c_of_type_Int, k + this.jdField_b_of_type_Int, m + this.jdField_d_of_type_Int);
  }
  
  void a(@Nullable PorterDuff.Mode paramMode)
  {
    if (this.jdField_a_of_type_AndroidGraphicsPorterDuff$Mode != paramMode)
    {
      this.jdField_a_of_type_AndroidGraphicsPorterDuff$Mode = paramMode;
      if ((a() != null) && (this.jdField_a_of_type_AndroidGraphicsPorterDuff$Mode != null)) {
        DrawableCompat.setTintMode(a(), this.jdField_a_of_type_AndroidGraphicsPorterDuff$Mode);
      }
    }
  }
  
  void a(@NonNull ShapeAppearanceModel paramShapeAppearanceModel)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel = paramShapeAppearanceModel;
    b(paramShapeAppearanceModel);
  }
  
  void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    c();
  }
  
  boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  void b(int paramInt)
  {
    if (this.f != paramInt)
    {
      this.f = paramInt;
      c();
    }
  }
  
  void b(@Nullable ColorStateList paramColorStateList)
  {
    if (this.jdField_c_of_type_AndroidContentResColorStateList != paramColorStateList)
    {
      this.jdField_c_of_type_AndroidContentResColorStateList = paramColorStateList;
      if ((jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButton.getBackground() instanceof RippleDrawable)))
      {
        ((RippleDrawable)this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButton.getBackground()).setColor(RippleUtils.b(paramColorStateList));
        return;
      }
      if ((!jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButton.getBackground() instanceof RippleDrawableCompat))) {
        ((RippleDrawableCompat)this.jdField_a_of_type_ComGoogleAndroidMaterialButtonMaterialButton.getBackground()).setTintList(RippleUtils.b(paramColorStateList));
      }
    }
  }
  
  void b(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  boolean b()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  void c(int paramInt)
  {
    if ((!this.jdField_d_of_type_Boolean) || (this.jdField_e_of_type_Int != paramInt))
    {
      this.jdField_e_of_type_Int = paramInt;
      this.jdField_d_of_type_Boolean = true;
      a(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel.a(paramInt));
    }
  }
  
  void c(@Nullable ColorStateList paramColorStateList)
  {
    if (this.jdField_b_of_type_AndroidContentResColorStateList != paramColorStateList)
    {
      this.jdField_b_of_type_AndroidContentResColorStateList = paramColorStateList;
      c();
    }
  }
  
  public void d(@Dimension int paramInt)
  {
    b(this.jdField_c_of_type_Int, paramInt);
  }
  
  public void e(@Dimension int paramInt)
  {
    b(paramInt, this.jdField_d_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.button.MaterialButtonHelper
 * JD-Core Version:    0.7.0.1
 */