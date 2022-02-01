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
import androidx.annotation.ColorInt;
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
  private static final int[] a = { 16842912 };
  private static final double b = Math.cos(Math.toRadians(45.0D));
  @NonNull
  private final MaterialCardView c;
  @NonNull
  private final Rect d = new Rect();
  @NonNull
  private final MaterialShapeDrawable e;
  @NonNull
  private final MaterialShapeDrawable f;
  @Dimension
  private int g;
  @Dimension
  private int h;
  @Dimension
  private int i;
  @Nullable
  private Drawable j;
  @Nullable
  private Drawable k;
  @Nullable
  private ColorStateList l;
  @Nullable
  private ColorStateList m;
  @Nullable
  private ShapeAppearanceModel n;
  @Nullable
  private ColorStateList o;
  @Nullable
  private Drawable p;
  @Nullable
  private LayerDrawable q;
  @Nullable
  private MaterialShapeDrawable r;
  @Nullable
  private MaterialShapeDrawable s;
  private boolean t = false;
  private boolean u;
  
  public MaterialCardViewHelper(@NonNull MaterialCardView paramMaterialCardView, AttributeSet paramAttributeSet, int paramInt1, @StyleRes int paramInt2)
  {
    this.c = paramMaterialCardView;
    this.e = new MaterialShapeDrawable(paramMaterialCardView.getContext(), paramAttributeSet, paramInt1, paramInt2);
    this.e.a(paramMaterialCardView.getContext());
    this.e.H(-12303292);
    ShapeAppearanceModel.Builder localBuilder = this.e.getShapeAppearanceModel().n();
    paramMaterialCardView = paramMaterialCardView.getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.aG, paramInt1, R.style.a);
    if (paramMaterialCardView.hasValue(R.styleable.aH)) {
      localBuilder.a(paramMaterialCardView.getDimension(R.styleable.aH, 0.0F));
    }
    this.f = new MaterialShapeDrawable();
    a(localBuilder.a());
    paramMaterialCardView.recycle();
  }
  
  private float A()
  {
    if ((this.c.getPreventCornerOverlap()) && ((Build.VERSION.SDK_INT < 21) || (this.c.getUseCompatPadding())))
    {
      double d1 = b;
      double d2 = this.c.getCardViewRadius();
      Double.isNaN(d2);
      return (float)((1.0D - d1) * d2);
    }
    return 0.0F;
  }
  
  private boolean B()
  {
    return (this.c.getPreventCornerOverlap()) && (!z());
  }
  
  private boolean C()
  {
    return (this.c.getPreventCornerOverlap()) && (z()) && (this.c.getUseCompatPadding());
  }
  
  private float D()
  {
    return Math.max(Math.max(a(this.n.b(), this.e.ab()), a(this.n.c(), this.e.ac())), Math.max(a(this.n.d(), this.e.ae()), a(this.n.e(), this.e.ad())));
  }
  
  @NonNull
  private Drawable E()
  {
    if (this.p == null) {
      this.p = F();
    }
    if (this.q == null)
    {
      Drawable localDrawable = I();
      this.q = new LayerDrawable(new Drawable[] { this.p, this.f, localDrawable });
      this.q.setId(2, R.id.O);
    }
    return this.q;
  }
  
  @NonNull
  private Drawable F()
  {
    if (RippleUtils.a)
    {
      this.s = J();
      return new RippleDrawable(this.l, null, this.s);
    }
    return G();
  }
  
  @NonNull
  private Drawable G()
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    this.r = J();
    this.r.g(this.l);
    MaterialShapeDrawable localMaterialShapeDrawable = this.r;
    localStateListDrawable.addState(new int[] { 16842919 }, localMaterialShapeDrawable);
    return localStateListDrawable;
  }
  
  private void H()
  {
    if (RippleUtils.a)
    {
      localObject = this.p;
      if (localObject != null)
      {
        ((RippleDrawable)localObject).setColor(this.l);
        return;
      }
    }
    Object localObject = this.r;
    if (localObject != null) {
      ((MaterialShapeDrawable)localObject).g(this.l);
    }
  }
  
  @NonNull
  private Drawable I()
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    Drawable localDrawable = this.k;
    if (localDrawable != null) {
      localStateListDrawable.addState(a, localDrawable);
    }
    return localStateListDrawable;
  }
  
  @NonNull
  private MaterialShapeDrawable J()
  {
    return new MaterialShapeDrawable(this.n);
  }
  
  private float a(CornerTreatment paramCornerTreatment, float paramFloat)
  {
    if ((paramCornerTreatment instanceof RoundedCornerTreatment))
    {
      double d1 = b;
      double d2 = paramFloat;
      Double.isNaN(d2);
      return (float)((1.0D - d1) * d2);
    }
    if ((paramCornerTreatment instanceof CutCornerTreatment)) {
      return paramFloat / 2.0F;
    }
    return 0.0F;
  }
  
  private void b(Drawable paramDrawable)
  {
    if ((Build.VERSION.SDK_INT >= 23) && ((this.c.getForeground() instanceof InsetDrawable)))
    {
      ((InsetDrawable)this.c.getForeground()).setDrawable(paramDrawable);
      return;
    }
    this.c.setForeground(c(paramDrawable));
  }
  
  @NonNull
  private Drawable c(Drawable paramDrawable)
  {
    int i1;
    if (Build.VERSION.SDK_INT < 21) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2;
    if ((i1 == 0) && (!this.c.getUseCompatPadding()))
    {
      i1 = 0;
      i2 = 0;
    }
    else
    {
      i2 = (int)Math.ceil(x());
      i1 = (int)Math.ceil(y());
    }
    return new MaterialCardViewHelper.1(this, paramDrawable, i1, i2, i1, i2);
  }
  
  private float x()
  {
    float f2 = this.c.getMaxCardElevation();
    float f1;
    if (C()) {
      f1 = D();
    } else {
      f1 = 0.0F;
    }
    return f2 * 1.5F + f1;
  }
  
  private float y()
  {
    float f2 = this.c.getMaxCardElevation();
    float f1;
    if (C()) {
      f1 = D();
    } else {
      f1 = 0.0F;
    }
    return f2 + f1;
  }
  
  private boolean z()
  {
    return (Build.VERSION.SDK_INT >= 21) && (this.e.af());
  }
  
  void a(float paramFloat)
  {
    a(this.n.a(paramFloat));
    this.j.invalidateSelf();
    if ((C()) || (B())) {
      o();
    }
    if (C()) {
      m();
    }
  }
  
  void a(@Dimension int paramInt)
  {
    if (paramInt == this.i) {
      return;
    }
    this.i = paramInt;
    n();
  }
  
  void a(int paramInt1, int paramInt2)
  {
    if (this.q != null)
    {
      int i2 = this.g;
      int i3 = this.h;
      int i1 = paramInt1 - i2 - i3;
      i2 = paramInt2 - i2 - i3;
      if (Build.VERSION.SDK_INT < 21) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
      if (paramInt1 == 0)
      {
        paramInt1 = i1;
        paramInt2 = i2;
        if (!this.c.getUseCompatPadding()) {}
      }
      else
      {
        paramInt2 = i2 - (int)Math.ceil(x() * 2.0F);
        paramInt1 = i1 - (int)Math.ceil(y() * 2.0F);
      }
      i1 = this.g;
      if (ViewCompat.getLayoutDirection(this.c) == 1)
      {
        i2 = paramInt1;
      }
      else
      {
        i2 = i1;
        i1 = paramInt1;
      }
      this.q.setLayerInset(2, i1, this.g, i2, paramInt2);
    }
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.d.set(paramInt1, paramInt2, paramInt3, paramInt4);
    o();
  }
  
  void a(ColorStateList paramColorStateList)
  {
    if (this.o == paramColorStateList) {
      return;
    }
    this.o = paramColorStateList;
    n();
  }
  
  void a(@NonNull TypedArray paramTypedArray)
  {
    this.o = MaterialResources.a(this.c.getContext(), paramTypedArray, R.styleable.eD);
    if (this.o == null) {
      this.o = ColorStateList.valueOf(-1);
    }
    this.i = paramTypedArray.getDimensionPixelSize(R.styleable.eE, 0);
    this.u = paramTypedArray.getBoolean(R.styleable.ew, false);
    this.c.setLongClickable(this.u);
    this.m = MaterialResources.a(this.c.getContext(), paramTypedArray, R.styleable.eB);
    a(MaterialResources.b(this.c.getContext(), paramTypedArray, R.styleable.ey));
    b(paramTypedArray.getDimensionPixelSize(R.styleable.eA, 0));
    c(paramTypedArray.getDimensionPixelSize(R.styleable.ez, 0));
    this.l = MaterialResources.a(this.c.getContext(), paramTypedArray, R.styleable.eC);
    if (this.l == null) {
      this.l = ColorStateList.valueOf(MaterialColors.a(this.c, R.attr.o));
    }
    c(MaterialResources.a(this.c.getContext(), paramTypedArray, R.styleable.ex));
    H();
    l();
    n();
    this.c.setBackgroundInternal(c(this.e));
    if (this.c.isClickable()) {
      paramTypedArray = E();
    } else {
      paramTypedArray = this.f;
    }
    this.j = paramTypedArray;
    this.c.setForeground(c(this.j));
  }
  
  void a(@Nullable Drawable paramDrawable)
  {
    this.k = paramDrawable;
    if (paramDrawable != null)
    {
      this.k = DrawableCompat.wrap(paramDrawable.mutate());
      DrawableCompat.setTintList(this.k, this.m);
    }
    if (this.q != null)
    {
      paramDrawable = I();
      this.q.setDrawableByLayerId(R.id.O, paramDrawable);
    }
  }
  
  void a(@NonNull ShapeAppearanceModel paramShapeAppearanceModel)
  {
    this.n = paramShapeAppearanceModel;
    this.e.setShapeAppearanceModel(paramShapeAppearanceModel);
    MaterialShapeDrawable localMaterialShapeDrawable = this.e;
    localMaterialShapeDrawable.g(localMaterialShapeDrawable.af() ^ true);
    localMaterialShapeDrawable = this.f;
    if (localMaterialShapeDrawable != null) {
      localMaterialShapeDrawable.setShapeAppearanceModel(paramShapeAppearanceModel);
    }
    localMaterialShapeDrawable = this.s;
    if (localMaterialShapeDrawable != null) {
      localMaterialShapeDrawable.setShapeAppearanceModel(paramShapeAppearanceModel);
    }
    localMaterialShapeDrawable = this.r;
    if (localMaterialShapeDrawable != null) {
      localMaterialShapeDrawable.setShapeAppearanceModel(paramShapeAppearanceModel);
    }
  }
  
  void a(boolean paramBoolean)
  {
    this.t = paramBoolean;
  }
  
  boolean a()
  {
    return this.t;
  }
  
  @ColorInt
  int b()
  {
    ColorStateList localColorStateList = this.o;
    if (localColorStateList == null) {
      return -1;
    }
    return localColorStateList.getDefaultColor();
  }
  
  void b(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    this.e.p(paramFloat);
    MaterialShapeDrawable localMaterialShapeDrawable = this.f;
    if (localMaterialShapeDrawable != null) {
      localMaterialShapeDrawable.p(paramFloat);
    }
    localMaterialShapeDrawable = this.s;
    if (localMaterialShapeDrawable != null) {
      localMaterialShapeDrawable.p(paramFloat);
    }
  }
  
  void b(@Dimension int paramInt)
  {
    this.h = paramInt;
  }
  
  void b(ColorStateList paramColorStateList)
  {
    this.e.g(paramColorStateList);
  }
  
  void b(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }
  
  @Nullable
  ColorStateList c()
  {
    return this.o;
  }
  
  void c(@Dimension int paramInt)
  {
    this.g = paramInt;
  }
  
  void c(@Nullable ColorStateList paramColorStateList)
  {
    MaterialShapeDrawable localMaterialShapeDrawable = this.f;
    ColorStateList localColorStateList = paramColorStateList;
    if (paramColorStateList == null) {
      localColorStateList = ColorStateList.valueOf(0);
    }
    localMaterialShapeDrawable.g(localColorStateList);
  }
  
  @Dimension
  int d()
  {
    return this.i;
  }
  
  void d(@Nullable ColorStateList paramColorStateList)
  {
    this.l = paramColorStateList;
    H();
  }
  
  @NonNull
  MaterialShapeDrawable e()
  {
    return this.e;
  }
  
  void e(@Nullable ColorStateList paramColorStateList)
  {
    this.m = paramColorStateList;
    Drawable localDrawable = this.k;
    if (localDrawable != null) {
      DrawableCompat.setTintList(localDrawable, paramColorStateList);
    }
  }
  
  ColorStateList f()
  {
    return this.e.M();
  }
  
  ColorStateList g()
  {
    return this.f.M();
  }
  
  @NonNull
  Rect h()
  {
    return this.d;
  }
  
  void i()
  {
    Drawable localDrawable = this.j;
    if (this.c.isClickable()) {
      localObject = E();
    } else {
      localObject = this.f;
    }
    this.j = ((Drawable)localObject);
    Object localObject = this.j;
    if (localDrawable != localObject) {
      b((Drawable)localObject);
    }
  }
  
  float j()
  {
    return this.e.ab();
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  float k()
  {
    return this.e.S();
  }
  
  void l()
  {
    this.e.r(this.c.getCardElevation());
  }
  
  void m()
  {
    if (!a()) {
      this.c.setBackgroundInternal(c(this.e));
    }
    this.c.setForeground(c(this.j));
  }
  
  void n()
  {
    this.f.a(this.i, this.o);
  }
  
  void o()
  {
    if ((!B()) && (!C())) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    float f1;
    if (i1 != 0) {
      f1 = D();
    } else {
      f1 = 0.0F;
    }
    int i1 = (int)(f1 - A());
    this.c.a(this.d.left + i1, this.d.top + i1, this.d.right + i1, this.d.bottom + i1);
  }
  
  boolean p()
  {
    return this.u;
  }
  
  @Nullable
  ColorStateList q()
  {
    return this.m;
  }
  
  @Nullable
  ColorStateList r()
  {
    return this.l;
  }
  
  @Nullable
  Drawable s()
  {
    return this.k;
  }
  
  @Dimension
  int t()
  {
    return this.h;
  }
  
  @Dimension
  int u()
  {
    return this.g;
  }
  
  @RequiresApi(api=23)
  void v()
  {
    Object localObject = this.p;
    if (localObject != null)
    {
      localObject = ((Drawable)localObject).getBounds();
      int i1 = ((Rect)localObject).bottom;
      this.p.setBounds(((Rect)localObject).left, ((Rect)localObject).top, ((Rect)localObject).right, i1 - 1);
      this.p.setBounds(((Rect)localObject).left, ((Rect)localObject).top, ((Rect)localObject).right, i1);
    }
  }
  
  ShapeAppearanceModel w()
  {
    return this.n;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.card.MaterialCardViewHelper
 * JD-Core Version:    0.7.0.1
 */