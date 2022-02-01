package com.google.android.material.card;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R.attr;
import com.google.android.material.R.id;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.CornerTreatment;
import com.google.android.material.shape.CutCornerTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RoundedCornerTreatment;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearanceModel.Builder;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
class MaterialCardViewHelper
{
  private static final double jdField_a_of_type_Double = Math.cos(Math.toRadians(45.0D));
  private static final int[] jdField_a_of_type_ArrayOfInt = { 16842912 };
  @Dimension
  private int jdField_a_of_type_Int;
  @Nullable
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  @NonNull
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  @Nullable
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  @Nullable
  private LayerDrawable jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable;
  @NonNull
  private final MaterialCardView jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardView;
  @NonNull
  private final MaterialShapeDrawable jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable;
  @Nullable
  private ShapeAppearanceModel jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel;
  private boolean jdField_a_of_type_Boolean = false;
  @Dimension
  private int jdField_b_of_type_Int;
  @Nullable
  private ColorStateList jdField_b_of_type_AndroidContentResColorStateList;
  @Nullable
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  @NonNull
  private final MaterialShapeDrawable jdField_b_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable;
  private boolean jdField_b_of_type_Boolean;
  @Dimension
  private int jdField_c_of_type_Int;
  @Nullable
  private ColorStateList jdField_c_of_type_AndroidContentResColorStateList;
  @Nullable
  private Drawable jdField_c_of_type_AndroidGraphicsDrawableDrawable;
  @Nullable
  private MaterialShapeDrawable jdField_c_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable;
  @Nullable
  private MaterialShapeDrawable d;
  
  public MaterialCardViewHelper(@NonNull MaterialCardView paramMaterialCardView, AttributeSet paramAttributeSet, int paramInt1, @StyleRes int paramInt2)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardView = paramMaterialCardView;
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable = new MaterialShapeDrawable(paramMaterialCardView.getContext(), paramAttributeSet, paramInt1, paramInt2);
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.a(paramMaterialCardView.getContext());
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.G(-12303292);
    ShapeAppearanceModel.Builder localBuilder = this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.a().b();
    paramMaterialCardView = paramMaterialCardView.getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.i, paramInt1, R.style.jdField_a_of_type_Int);
    if (paramMaterialCardView.hasValue(R.styleable.ab)) {
      localBuilder.a(paramMaterialCardView.getDimension(R.styleable.ab, 0.0F));
    }
    this.jdField_b_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable = new MaterialShapeDrawable();
    a(localBuilder.a());
    paramMaterialCardView.recycle();
  }
  
  private float a(CornerTreatment paramCornerTreatment, float paramFloat)
  {
    if ((paramCornerTreatment instanceof RoundedCornerTreatment))
    {
      double d1 = jdField_a_of_type_Double;
      double d2 = paramFloat;
      Double.isNaN(d2);
      return (float)((1.0D - d1) * d2);
    }
    if ((paramCornerTreatment instanceof CutCornerTreatment)) {
      return paramFloat / 2.0F;
    }
    return 0.0F;
  }
  
  @NonNull
  private Drawable a()
  {
    if (this.jdField_c_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = b();
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable == null)
    {
      Drawable localDrawable = d();
      this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable = new LayerDrawable(new Drawable[] { this.jdField_c_of_type_AndroidGraphicsDrawableDrawable, this.jdField_b_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable, localDrawable });
      this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable.setId(2, R.id.O);
    }
    return this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable;
  }
  
  @NonNull
  private Drawable a(Drawable paramDrawable)
  {
    int i;
    if (Build.VERSION.SDK_INT < 21) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if ((i == 0) && (!this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardView.getUseCompatPadding()))
    {
      i = 0;
      j = 0;
    }
    else
    {
      j = (int)Math.ceil(b());
      i = (int)Math.ceil(c());
    }
    return new MaterialCardViewHelper.1(this, paramDrawable, i, j, i, j);
  }
  
  private float b()
  {
    float f2 = this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardView.getMaxCardElevation();
    float f1;
    if (e()) {
      f1 = e();
    } else {
      f1 = 0.0F;
    }
    return f2 * 1.5F + f1;
  }
  
  @NonNull
  private Drawable b()
  {
    if (RippleUtils.jdField_a_of_type_Boolean)
    {
      this.d = b();
      return new RippleDrawable(this.jdField_a_of_type_AndroidContentResColorStateList, null, this.d);
    }
    return c();
  }
  
  @NonNull
  private MaterialShapeDrawable b()
  {
    return new MaterialShapeDrawable(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel);
  }
  
  private void b(Drawable paramDrawable)
  {
    if ((Build.VERSION.SDK_INT >= 23) && ((this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardView.getForeground() instanceof InsetDrawable)))
    {
      ((InsetDrawable)this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardView.getForeground()).setDrawable(paramDrawable);
      return;
    }
    this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardView.setForeground(a(paramDrawable));
  }
  
  private float c()
  {
    float f2 = this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardView.getMaxCardElevation();
    float f1;
    if (e()) {
      f1 = e();
    } else {
      f1 = 0.0F;
    }
    return f2 + f1;
  }
  
  @NonNull
  private Drawable c()
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    this.jdField_c_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable = b();
    this.jdField_c_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.g(this.jdField_a_of_type_AndroidContentResColorStateList);
    MaterialShapeDrawable localMaterialShapeDrawable = this.jdField_c_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable;
    localStateListDrawable.addState(new int[] { 16842919 }, localMaterialShapeDrawable);
    return localStateListDrawable;
  }
  
  private boolean c()
  {
    return (Build.VERSION.SDK_INT >= 21) && (this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.h());
  }
  
  private float d()
  {
    if ((this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardView.getPreventCornerOverlap()) && ((Build.VERSION.SDK_INT < 21) || (this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardView.getUseCompatPadding())))
    {
      double d1 = jdField_a_of_type_Double;
      double d2 = this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardView.a();
      Double.isNaN(d2);
      return (float)((1.0D - d1) * d2);
    }
    return 0.0F;
  }
  
  @NonNull
  private Drawable d()
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    Drawable localDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
    if (localDrawable != null) {
      localStateListDrawable.addState(jdField_a_of_type_ArrayOfInt, localDrawable);
    }
    return localStateListDrawable;
  }
  
  private boolean d()
  {
    return (this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardView.getPreventCornerOverlap()) && (!c());
  }
  
  private float e()
  {
    return Math.max(Math.max(a(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel.a(), this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.n()), a(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel.b(), this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.o())), Math.max(a(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel.c(), this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.q()), a(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel.d(), this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.p())));
  }
  
  private boolean e()
  {
    return (this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardView.getPreventCornerOverlap()) && (c()) && (this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardView.getUseCompatPadding());
  }
  
  private void g()
  {
    if (RippleUtils.jdField_a_of_type_Boolean)
    {
      localObject = this.jdField_c_of_type_AndroidGraphicsDrawableDrawable;
      if (localObject != null)
      {
        ((RippleDrawable)localObject).setColor(this.jdField_a_of_type_AndroidContentResColorStateList);
        return;
      }
    }
    Object localObject = this.jdField_c_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable;
    if (localObject != null) {
      ((MaterialShapeDrawable)localObject).g(this.jdField_a_of_type_AndroidContentResColorStateList);
    }
  }
  
  float a()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.n();
  }
  
  ColorStateList a()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.b();
  }
  
  @NonNull
  Rect a()
  {
    return this.jdField_a_of_type_AndroidGraphicsRect;
  }
  
  @NonNull
  MaterialShapeDrawable a()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable;
  }
  
  ShapeAppearanceModel a()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel;
  }
  
  void a()
  {
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardView.isClickable()) {
      localObject = a();
    } else {
      localObject = this.jdField_b_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)localObject);
    Object localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localDrawable != localObject) {
      b((Drawable)localObject);
    }
  }
  
  void a(float paramFloat)
  {
    a(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel.a(paramFloat));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.invalidateSelf();
    if ((e()) || (d())) {
      e();
    }
    if (e()) {
      c();
    }
  }
  
  void a(@Dimension int paramInt)
  {
    if (paramInt == this.jdField_c_of_type_Int) {
      return;
    }
    this.jdField_c_of_type_Int = paramInt;
    d();
  }
  
  void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable != null)
    {
      int j = this.jdField_a_of_type_Int;
      int k = this.jdField_b_of_type_Int;
      int i = paramInt1 - j - k;
      j = paramInt2 - j - k;
      if (Build.VERSION.SDK_INT < 21) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
      if (paramInt1 == 0)
      {
        paramInt1 = i;
        paramInt2 = j;
        if (!this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardView.getUseCompatPadding()) {}
      }
      else
      {
        paramInt2 = j - (int)Math.ceil(b() * 2.0F);
        paramInt1 = i - (int)Math.ceil(c() * 2.0F);
      }
      i = this.jdField_a_of_type_Int;
      if (ViewCompat.getLayoutDirection(this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardView) == 1)
      {
        j = paramInt1;
      }
      else
      {
        j = i;
        i = paramInt1;
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable.setLayerInset(2, i, this.jdField_a_of_type_Int, j, paramInt2);
    }
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_AndroidGraphicsRect.set(paramInt1, paramInt2, paramInt3, paramInt4);
    e();
  }
  
  void a(ColorStateList paramColorStateList)
  {
    if (this.jdField_c_of_type_AndroidContentResColorStateList == paramColorStateList) {
      return;
    }
    this.jdField_c_of_type_AndroidContentResColorStateList = paramColorStateList;
    d();
  }
  
  void a(@NonNull TypedArray paramTypedArray)
  {
    this.jdField_c_of_type_AndroidContentResColorStateList = MaterialResources.a(this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardView.getContext(), paramTypedArray, R.styleable.dc);
    if (this.jdField_c_of_type_AndroidContentResColorStateList == null) {
      this.jdField_c_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(-1);
    }
    this.jdField_c_of_type_Int = paramTypedArray.getDimensionPixelSize(R.styleable.dd, 0);
    this.jdField_b_of_type_Boolean = paramTypedArray.getBoolean(R.styleable.cV, false);
    this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardView.setLongClickable(this.jdField_b_of_type_Boolean);
    this.jdField_b_of_type_AndroidContentResColorStateList = MaterialResources.a(this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardView.getContext(), paramTypedArray, R.styleable.da);
    a(MaterialResources.a(this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardView.getContext(), paramTypedArray, R.styleable.cX));
    b(paramTypedArray.getDimensionPixelSize(R.styleable.cZ, 0));
    c(paramTypedArray.getDimensionPixelSize(R.styleable.cY, 0));
    this.jdField_a_of_type_AndroidContentResColorStateList = MaterialResources.a(this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardView.getContext(), paramTypedArray, R.styleable.db);
    if (this.jdField_a_of_type_AndroidContentResColorStateList == null) {
      this.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(MaterialColors.a(this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardView, R.attr.colorControlHighlight));
    }
    c(MaterialResources.a(this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardView.getContext(), paramTypedArray, R.styleable.cW));
    g();
    b();
    d();
    this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardView.a(a(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable));
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardView.isClickable()) {
      paramTypedArray = a();
    } else {
      paramTypedArray = this.jdField_b_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramTypedArray;
    this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardView.setForeground(a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable));
  }
  
  void a(@Nullable Drawable paramDrawable)
  {
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if (paramDrawable != null)
    {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = DrawableCompat.wrap(paramDrawable.mutate());
      DrawableCompat.setTintList(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, this.jdField_b_of_type_AndroidContentResColorStateList);
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable != null)
    {
      paramDrawable = d();
      this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable.setDrawableByLayerId(R.id.O, paramDrawable);
    }
  }
  
  void a(@NonNull ShapeAppearanceModel paramShapeAppearanceModel)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel = paramShapeAppearanceModel;
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.setShapeAppearanceModel(paramShapeAppearanceModel);
    MaterialShapeDrawable localMaterialShapeDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable;
    localMaterialShapeDrawable.g(localMaterialShapeDrawable.h() ^ true);
    localMaterialShapeDrawable = this.jdField_b_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable;
    if (localMaterialShapeDrawable != null) {
      localMaterialShapeDrawable.setShapeAppearanceModel(paramShapeAppearanceModel);
    }
    localMaterialShapeDrawable = this.d;
    if (localMaterialShapeDrawable != null) {
      localMaterialShapeDrawable.setShapeAppearanceModel(paramShapeAppearanceModel);
    }
    localMaterialShapeDrawable = this.jdField_c_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable;
    if (localMaterialShapeDrawable != null) {
      localMaterialShapeDrawable.setShapeAppearanceModel(paramShapeAppearanceModel);
    }
  }
  
  void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  void b()
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.r(this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardView.getCardElevation());
  }
  
  void b(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.p(paramFloat);
    MaterialShapeDrawable localMaterialShapeDrawable = this.jdField_b_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable;
    if (localMaterialShapeDrawable != null) {
      localMaterialShapeDrawable.p(paramFloat);
    }
    localMaterialShapeDrawable = this.d;
    if (localMaterialShapeDrawable != null) {
      localMaterialShapeDrawable.p(paramFloat);
    }
  }
  
  void b(@Dimension int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  void b(ColorStateList paramColorStateList)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.g(paramColorStateList);
  }
  
  void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  void c()
  {
    if (!a()) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardView.a(a(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable));
    }
    this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardView.setForeground(a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable));
  }
  
  void c(@Dimension int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  void c(@Nullable ColorStateList paramColorStateList)
  {
    MaterialShapeDrawable localMaterialShapeDrawable = this.jdField_b_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable;
    ColorStateList localColorStateList = paramColorStateList;
    if (paramColorStateList == null) {
      localColorStateList = ColorStateList.valueOf(0);
    }
    localMaterialShapeDrawable.g(localColorStateList);
  }
  
  void d()
  {
    this.jdField_b_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.a(this.jdField_c_of_type_Int, this.jdField_c_of_type_AndroidContentResColorStateList);
  }
  
  void d(@Nullable ColorStateList paramColorStateList)
  {
    this.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList;
    g();
  }
  
  void e()
  {
    if ((!d()) && (!e())) {
      i = 0;
    } else {
      i = 1;
    }
    float f;
    if (i != 0) {
      f = e();
    } else {
      f = 0.0F;
    }
    int i = (int)(f - d());
    this.jdField_a_of_type_ComGoogleAndroidMaterialCardMaterialCardView.a(this.jdField_a_of_type_AndroidGraphicsRect.left + i, this.jdField_a_of_type_AndroidGraphicsRect.top + i, this.jdField_a_of_type_AndroidGraphicsRect.right + i, this.jdField_a_of_type_AndroidGraphicsRect.bottom + i);
  }
  
  void e(@Nullable ColorStateList paramColorStateList)
  {
    this.jdField_b_of_type_AndroidContentResColorStateList = paramColorStateList;
    Drawable localDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
    if (localDrawable != null) {
      DrawableCompat.setTintList(localDrawable, paramColorStateList);
    }
  }
  
  @RequiresApi(api=23)
  void f()
  {
    Object localObject = this.jdField_c_of_type_AndroidGraphicsDrawableDrawable;
    if (localObject != null)
    {
      localObject = ((Drawable)localObject).getBounds();
      int i = ((Rect)localObject).bottom;
      this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setBounds(((Rect)localObject).left, ((Rect)localObject).top, ((Rect)localObject).right, i - 1);
      this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setBounds(((Rect)localObject).left, ((Rect)localObject).top, ((Rect)localObject).right, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.card.MaterialCardViewHelper
 * JD-Core Version:    0.7.0.1
 */