package com.google.android.material.shape;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import com.google.android.material.R.styleable;

public class ShapeAppearanceModel
{
  public static final CornerSize a;
  CornerTreatment jdField_a_of_type_ComGoogleAndroidMaterialShapeCornerTreatment;
  EdgeTreatment jdField_a_of_type_ComGoogleAndroidMaterialShapeEdgeTreatment;
  CornerSize jdField_b_of_type_ComGoogleAndroidMaterialShapeCornerSize;
  CornerTreatment jdField_b_of_type_ComGoogleAndroidMaterialShapeCornerTreatment;
  EdgeTreatment jdField_b_of_type_ComGoogleAndroidMaterialShapeEdgeTreatment;
  CornerSize jdField_c_of_type_ComGoogleAndroidMaterialShapeCornerSize;
  CornerTreatment jdField_c_of_type_ComGoogleAndroidMaterialShapeCornerTreatment;
  EdgeTreatment jdField_c_of_type_ComGoogleAndroidMaterialShapeEdgeTreatment;
  CornerSize jdField_d_of_type_ComGoogleAndroidMaterialShapeCornerSize;
  CornerTreatment jdField_d_of_type_ComGoogleAndroidMaterialShapeCornerTreatment;
  EdgeTreatment jdField_d_of_type_ComGoogleAndroidMaterialShapeEdgeTreatment;
  CornerSize e;
  
  static
  {
    jdField_a_of_type_ComGoogleAndroidMaterialShapeCornerSize = new RelativeCornerSize(0.5F);
  }
  
  public ShapeAppearanceModel()
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeCornerTreatment = MaterialShapeUtils.a();
    this.jdField_b_of_type_ComGoogleAndroidMaterialShapeCornerTreatment = MaterialShapeUtils.a();
    this.jdField_c_of_type_ComGoogleAndroidMaterialShapeCornerTreatment = MaterialShapeUtils.a();
    this.jdField_d_of_type_ComGoogleAndroidMaterialShapeCornerTreatment = MaterialShapeUtils.a();
    this.jdField_b_of_type_ComGoogleAndroidMaterialShapeCornerSize = new AbsoluteCornerSize(0.0F);
    this.jdField_c_of_type_ComGoogleAndroidMaterialShapeCornerSize = new AbsoluteCornerSize(0.0F);
    this.jdField_d_of_type_ComGoogleAndroidMaterialShapeCornerSize = new AbsoluteCornerSize(0.0F);
    this.e = new AbsoluteCornerSize(0.0F);
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeEdgeTreatment = MaterialShapeUtils.a();
    this.jdField_b_of_type_ComGoogleAndroidMaterialShapeEdgeTreatment = MaterialShapeUtils.a();
    this.jdField_c_of_type_ComGoogleAndroidMaterialShapeEdgeTreatment = MaterialShapeUtils.a();
    this.jdField_d_of_type_ComGoogleAndroidMaterialShapeEdgeTreatment = MaterialShapeUtils.a();
  }
  
  private ShapeAppearanceModel(@NonNull ShapeAppearanceModel.Builder paramBuilder)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeCornerTreatment = ShapeAppearanceModel.Builder.a(paramBuilder);
    this.jdField_b_of_type_ComGoogleAndroidMaterialShapeCornerTreatment = ShapeAppearanceModel.Builder.b(paramBuilder);
    this.jdField_c_of_type_ComGoogleAndroidMaterialShapeCornerTreatment = ShapeAppearanceModel.Builder.c(paramBuilder);
    this.jdField_d_of_type_ComGoogleAndroidMaterialShapeCornerTreatment = ShapeAppearanceModel.Builder.d(paramBuilder);
    this.jdField_b_of_type_ComGoogleAndroidMaterialShapeCornerSize = ShapeAppearanceModel.Builder.a(paramBuilder);
    this.jdField_c_of_type_ComGoogleAndroidMaterialShapeCornerSize = ShapeAppearanceModel.Builder.b(paramBuilder);
    this.jdField_d_of_type_ComGoogleAndroidMaterialShapeCornerSize = ShapeAppearanceModel.Builder.c(paramBuilder);
    this.e = ShapeAppearanceModel.Builder.d(paramBuilder);
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeEdgeTreatment = ShapeAppearanceModel.Builder.a(paramBuilder);
    this.jdField_b_of_type_ComGoogleAndroidMaterialShapeEdgeTreatment = ShapeAppearanceModel.Builder.b(paramBuilder);
    this.jdField_c_of_type_ComGoogleAndroidMaterialShapeEdgeTreatment = ShapeAppearanceModel.Builder.c(paramBuilder);
    this.jdField_d_of_type_ComGoogleAndroidMaterialShapeEdgeTreatment = ShapeAppearanceModel.Builder.d(paramBuilder);
  }
  
  @NonNull
  private static CornerSize a(TypedArray paramTypedArray, int paramInt, @NonNull CornerSize paramCornerSize)
  {
    TypedValue localTypedValue = paramTypedArray.peekValue(paramInt);
    if (localTypedValue == null) {
      return paramCornerSize;
    }
    if (localTypedValue.type == 5) {
      return new AbsoluteCornerSize(TypedValue.complexToDimensionPixelSize(localTypedValue.data, paramTypedArray.getResources().getDisplayMetrics()));
    }
    if (localTypedValue.type == 6) {
      return new RelativeCornerSize(localTypedValue.getFraction(1.0F, 1.0F));
    }
    return paramCornerSize;
  }
  
  @NonNull
  public static ShapeAppearanceModel.Builder a()
  {
    return new ShapeAppearanceModel.Builder();
  }
  
  @NonNull
  public static ShapeAppearanceModel.Builder a(Context paramContext, @StyleRes int paramInt1, @StyleRes int paramInt2)
  {
    return a(paramContext, paramInt1, paramInt2, 0);
  }
  
  @NonNull
  private static ShapeAppearanceModel.Builder a(Context paramContext, @StyleRes int paramInt1, @StyleRes int paramInt2, int paramInt3)
  {
    return a(paramContext, paramInt1, paramInt2, new AbsoluteCornerSize(paramInt3));
  }
  
  @NonNull
  private static ShapeAppearanceModel.Builder a(Context paramContext, @StyleRes int paramInt1, @StyleRes int paramInt2, @NonNull CornerSize paramCornerSize)
  {
    Object localObject = paramContext;
    int i = paramInt1;
    if (paramInt2 != 0)
    {
      localObject = new ContextThemeWrapper(paramContext, paramInt1);
      i = paramInt2;
    }
    paramContext = ((Context)localObject).obtainStyledAttributes(i, R.styleable.ap);
    try
    {
      int j = paramContext.getInt(R.styleable.dT, 0);
      paramInt1 = paramContext.getInt(R.styleable.dW, j);
      paramInt2 = paramContext.getInt(R.styleable.dX, j);
      i = paramContext.getInt(R.styleable.dV, j);
      j = paramContext.getInt(R.styleable.dU, j);
      CornerSize localCornerSize2 = a(paramContext, R.styleable.dY, paramCornerSize);
      paramCornerSize = a(paramContext, R.styleable.eb, localCornerSize2);
      localObject = a(paramContext, R.styleable.ec, localCornerSize2);
      CornerSize localCornerSize1 = a(paramContext, R.styleable.ea, localCornerSize2);
      localCornerSize2 = a(paramContext, R.styleable.dZ, localCornerSize2);
      paramCornerSize = new ShapeAppearanceModel.Builder().a(paramInt1, paramCornerSize).b(paramInt2, (CornerSize)localObject).c(i, localCornerSize1).d(j, localCornerSize2);
      return paramCornerSize;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  @NonNull
  public static ShapeAppearanceModel.Builder a(@NonNull Context paramContext, AttributeSet paramAttributeSet, @AttrRes int paramInt1, @StyleRes int paramInt2)
  {
    return a(paramContext, paramAttributeSet, paramInt1, paramInt2, 0);
  }
  
  @NonNull
  public static ShapeAppearanceModel.Builder a(@NonNull Context paramContext, AttributeSet paramAttributeSet, @AttrRes int paramInt1, @StyleRes int paramInt2, int paramInt3)
  {
    return a(paramContext, paramAttributeSet, paramInt1, paramInt2, new AbsoluteCornerSize(paramInt3));
  }
  
  @NonNull
  public static ShapeAppearanceModel.Builder a(@NonNull Context paramContext, AttributeSet paramAttributeSet, @AttrRes int paramInt1, @StyleRes int paramInt2, @NonNull CornerSize paramCornerSize)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.W, paramInt1, paramInt2);
    paramInt1 = paramAttributeSet.getResourceId(R.styleable.di, 0);
    paramInt2 = paramAttributeSet.getResourceId(R.styleable.dj, 0);
    paramAttributeSet.recycle();
    return a(paramContext, paramInt1, paramInt2, paramCornerSize);
  }
  
  @NonNull
  public CornerSize a()
  {
    return this.jdField_b_of_type_ComGoogleAndroidMaterialShapeCornerSize;
  }
  
  @NonNull
  public CornerTreatment a()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialShapeCornerTreatment;
  }
  
  @NonNull
  public EdgeTreatment a()
  {
    return this.jdField_d_of_type_ComGoogleAndroidMaterialShapeEdgeTreatment;
  }
  
  @NonNull
  public ShapeAppearanceModel a(float paramFloat)
  {
    return b().a(paramFloat).a();
  }
  
  @NonNull
  public ShapeAppearanceModel a(@NonNull CornerSize paramCornerSize)
  {
    return b().a(paramCornerSize).a();
  }
  
  @NonNull
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public ShapeAppearanceModel a(@NonNull ShapeAppearanceModel.CornerSizeUnaryOperator paramCornerSizeUnaryOperator)
  {
    return b().b(paramCornerSizeUnaryOperator.a(a())).c(paramCornerSizeUnaryOperator.a(b())).e(paramCornerSizeUnaryOperator.a(d())).d(paramCornerSizeUnaryOperator.a(c())).a();
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public boolean a(@NonNull RectF paramRectF)
  {
    int i;
    if ((this.jdField_d_of_type_ComGoogleAndroidMaterialShapeEdgeTreatment.getClass().equals(EdgeTreatment.class)) && (this.jdField_b_of_type_ComGoogleAndroidMaterialShapeEdgeTreatment.getClass().equals(EdgeTreatment.class)) && (this.jdField_a_of_type_ComGoogleAndroidMaterialShapeEdgeTreatment.getClass().equals(EdgeTreatment.class)) && (this.jdField_c_of_type_ComGoogleAndroidMaterialShapeEdgeTreatment.getClass().equals(EdgeTreatment.class))) {
      i = 1;
    } else {
      i = 0;
    }
    float f = this.jdField_b_of_type_ComGoogleAndroidMaterialShapeCornerSize.a(paramRectF);
    int j;
    if ((this.jdField_c_of_type_ComGoogleAndroidMaterialShapeCornerSize.a(paramRectF) == f) && (this.e.a(paramRectF) == f) && (this.jdField_d_of_type_ComGoogleAndroidMaterialShapeCornerSize.a(paramRectF) == f)) {
      j = 1;
    } else {
      j = 0;
    }
    int k;
    if (((this.jdField_b_of_type_ComGoogleAndroidMaterialShapeCornerTreatment instanceof RoundedCornerTreatment)) && ((this.jdField_a_of_type_ComGoogleAndroidMaterialShapeCornerTreatment instanceof RoundedCornerTreatment)) && ((this.jdField_c_of_type_ComGoogleAndroidMaterialShapeCornerTreatment instanceof RoundedCornerTreatment)) && ((this.jdField_d_of_type_ComGoogleAndroidMaterialShapeCornerTreatment instanceof RoundedCornerTreatment))) {
      k = 1;
    } else {
      k = 0;
    }
    return (i != 0) && (j != 0) && (k != 0);
  }
  
  @NonNull
  public CornerSize b()
  {
    return this.jdField_c_of_type_ComGoogleAndroidMaterialShapeCornerSize;
  }
  
  @NonNull
  public CornerTreatment b()
  {
    return this.jdField_b_of_type_ComGoogleAndroidMaterialShapeCornerTreatment;
  }
  
  @NonNull
  public EdgeTreatment b()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialShapeEdgeTreatment;
  }
  
  @NonNull
  public ShapeAppearanceModel.Builder b()
  {
    return new ShapeAppearanceModel.Builder(this);
  }
  
  @NonNull
  public CornerSize c()
  {
    return this.jdField_d_of_type_ComGoogleAndroidMaterialShapeCornerSize;
  }
  
  @NonNull
  public CornerTreatment c()
  {
    return this.jdField_c_of_type_ComGoogleAndroidMaterialShapeCornerTreatment;
  }
  
  @NonNull
  public EdgeTreatment c()
  {
    return this.jdField_b_of_type_ComGoogleAndroidMaterialShapeEdgeTreatment;
  }
  
  @NonNull
  public CornerSize d()
  {
    return this.e;
  }
  
  @NonNull
  public CornerTreatment d()
  {
    return this.jdField_d_of_type_ComGoogleAndroidMaterialShapeCornerTreatment;
  }
  
  @NonNull
  public EdgeTreatment d()
  {
    return this.jdField_c_of_type_ComGoogleAndroidMaterialShapeEdgeTreatment;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.shape.ShapeAppearanceModel
 * JD-Core Version:    0.7.0.1
 */