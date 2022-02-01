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
  public static final CornerSize a = new RelativeCornerSize(0.5F);
  CornerTreatment b;
  CornerTreatment c;
  CornerTreatment d;
  CornerTreatment e;
  CornerSize f;
  CornerSize g;
  CornerSize h;
  CornerSize i;
  EdgeTreatment j;
  EdgeTreatment k;
  EdgeTreatment l;
  EdgeTreatment m;
  
  public ShapeAppearanceModel()
  {
    this.b = MaterialShapeUtils.a();
    this.c = MaterialShapeUtils.a();
    this.d = MaterialShapeUtils.a();
    this.e = MaterialShapeUtils.a();
    this.f = new AbsoluteCornerSize(0.0F);
    this.g = new AbsoluteCornerSize(0.0F);
    this.h = new AbsoluteCornerSize(0.0F);
    this.i = new AbsoluteCornerSize(0.0F);
    this.j = MaterialShapeUtils.b();
    this.k = MaterialShapeUtils.b();
    this.l = MaterialShapeUtils.b();
    this.m = MaterialShapeUtils.b();
  }
  
  private ShapeAppearanceModel(@NonNull ShapeAppearanceModel.Builder paramBuilder)
  {
    this.b = ShapeAppearanceModel.Builder.a(paramBuilder);
    this.c = ShapeAppearanceModel.Builder.b(paramBuilder);
    this.d = ShapeAppearanceModel.Builder.c(paramBuilder);
    this.e = ShapeAppearanceModel.Builder.d(paramBuilder);
    this.f = ShapeAppearanceModel.Builder.e(paramBuilder);
    this.g = ShapeAppearanceModel.Builder.f(paramBuilder);
    this.h = ShapeAppearanceModel.Builder.g(paramBuilder);
    this.i = ShapeAppearanceModel.Builder.h(paramBuilder);
    this.j = ShapeAppearanceModel.Builder.i(paramBuilder);
    this.k = ShapeAppearanceModel.Builder.j(paramBuilder);
    this.l = ShapeAppearanceModel.Builder.k(paramBuilder);
    this.m = ShapeAppearanceModel.Builder.l(paramBuilder);
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
    int n = paramInt1;
    if (paramInt2 != 0)
    {
      localObject = new ContextThemeWrapper(paramContext, paramInt1);
      n = paramInt2;
    }
    paramContext = ((Context)localObject).obtainStyledAttributes(n, R.styleable.fX);
    try
    {
      int i1 = paramContext.getInt(R.styleable.fY, 0);
      paramInt1 = paramContext.getInt(R.styleable.gb, i1);
      paramInt2 = paramContext.getInt(R.styleable.gc, i1);
      n = paramContext.getInt(R.styleable.ga, i1);
      i1 = paramContext.getInt(R.styleable.fZ, i1);
      CornerSize localCornerSize2 = a(paramContext, R.styleable.gd, paramCornerSize);
      paramCornerSize = a(paramContext, R.styleable.gg, localCornerSize2);
      localObject = a(paramContext, R.styleable.gh, localCornerSize2);
      CornerSize localCornerSize1 = a(paramContext, R.styleable.gf, localCornerSize2);
      localCornerSize2 = a(paramContext, R.styleable.ge, localCornerSize2);
      paramCornerSize = new ShapeAppearanceModel.Builder().a(paramInt1, paramCornerSize).b(paramInt2, (CornerSize)localObject).c(n, localCornerSize1).d(i1, localCornerSize2);
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
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.eL, paramInt1, paramInt2);
    paramInt1 = paramAttributeSet.getResourceId(R.styleable.eM, 0);
    paramInt2 = paramAttributeSet.getResourceId(R.styleable.eN, 0);
    paramAttributeSet.recycle();
    return a(paramContext, paramInt1, paramInt2, paramCornerSize);
  }
  
  @NonNull
  public ShapeAppearanceModel a(float paramFloat)
  {
    return n().a(paramFloat).a();
  }
  
  @NonNull
  public ShapeAppearanceModel a(@NonNull CornerSize paramCornerSize)
  {
    return n().a(paramCornerSize).a();
  }
  
  @NonNull
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public ShapeAppearanceModel a(@NonNull ShapeAppearanceModel.CornerSizeUnaryOperator paramCornerSizeUnaryOperator)
  {
    return n().b(paramCornerSizeUnaryOperator.a(f())).c(paramCornerSizeUnaryOperator.a(g())).e(paramCornerSizeUnaryOperator.a(i())).d(paramCornerSizeUnaryOperator.a(h())).a();
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public boolean a(@NonNull RectF paramRectF)
  {
    int n;
    if ((this.m.getClass().equals(EdgeTreatment.class)) && (this.k.getClass().equals(EdgeTreatment.class)) && (this.j.getClass().equals(EdgeTreatment.class)) && (this.l.getClass().equals(EdgeTreatment.class))) {
      n = 1;
    } else {
      n = 0;
    }
    float f1 = this.f.a(paramRectF);
    int i1;
    if ((this.g.a(paramRectF) == f1) && (this.i.a(paramRectF) == f1) && (this.h.a(paramRectF) == f1)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2;
    if (((this.c instanceof RoundedCornerTreatment)) && ((this.b instanceof RoundedCornerTreatment)) && ((this.d instanceof RoundedCornerTreatment)) && ((this.e instanceof RoundedCornerTreatment))) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    return (n != 0) && (i1 != 0) && (i2 != 0);
  }
  
  @NonNull
  public CornerTreatment b()
  {
    return this.b;
  }
  
  @NonNull
  public CornerTreatment c()
  {
    return this.c;
  }
  
  @NonNull
  public CornerTreatment d()
  {
    return this.d;
  }
  
  @NonNull
  public CornerTreatment e()
  {
    return this.e;
  }
  
  @NonNull
  public CornerSize f()
  {
    return this.f;
  }
  
  @NonNull
  public CornerSize g()
  {
    return this.g;
  }
  
  @NonNull
  public CornerSize h()
  {
    return this.h;
  }
  
  @NonNull
  public CornerSize i()
  {
    return this.i;
  }
  
  @NonNull
  public EdgeTreatment j()
  {
    return this.m;
  }
  
  @NonNull
  public EdgeTreatment k()
  {
    return this.j;
  }
  
  @NonNull
  public EdgeTreatment l()
  {
    return this.k;
  }
  
  @NonNull
  public EdgeTreatment m()
  {
    return this.l;
  }
  
  @NonNull
  public ShapeAppearanceModel.Builder n()
  {
    return new ShapeAppearanceModel.Builder(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.shape.ShapeAppearanceModel
 * JD-Core Version:    0.7.0.1
 */