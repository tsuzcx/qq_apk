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
  private static final boolean a;
  private final MaterialButton b;
  @NonNull
  private ShapeAppearanceModel c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  @Nullable
  private PorterDuff.Mode j;
  @Nullable
  private ColorStateList k;
  @Nullable
  private ColorStateList l;
  @Nullable
  private ColorStateList m;
  @Nullable
  private Drawable n;
  private boolean o = false;
  private boolean p = false;
  private boolean q = false;
  private boolean r;
  private LayerDrawable s;
  private int t;
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 21) {
      bool = true;
    } else {
      bool = false;
    }
    a = bool;
  }
  
  MaterialButtonHelper(MaterialButton paramMaterialButton, @NonNull ShapeAppearanceModel paramShapeAppearanceModel)
  {
    this.b = paramMaterialButton;
    this.c = paramShapeAppearanceModel;
  }
  
  @NonNull
  private InsetDrawable a(Drawable paramDrawable)
  {
    return new InsetDrawable(paramDrawable, this.d, this.f, this.e, this.g);
  }
  
  private void b(@Dimension int paramInt1, @Dimension int paramInt2)
  {
    int i1 = ViewCompat.getPaddingStart(this.b);
    int i2 = this.b.getPaddingTop();
    int i3 = ViewCompat.getPaddingEnd(this.b);
    int i4 = this.b.getPaddingBottom();
    int i5 = this.f;
    int i6 = this.g;
    this.g = paramInt2;
    this.f = paramInt1;
    if (!this.p) {
      o();
    }
    ViewCompat.setPaddingRelative(this.b, i1, i2 + paramInt1 - i5, i3, i4 + paramInt2 - i6);
  }
  
  private void b(@NonNull ShapeAppearanceModel paramShapeAppearanceModel)
  {
    if (i() != null) {
      i().setShapeAppearanceModel(paramShapeAppearanceModel);
    }
    if (r() != null) {
      r().setShapeAppearanceModel(paramShapeAppearanceModel);
    }
    if (k() != null) {
      k().setShapeAppearanceModel(paramShapeAppearanceModel);
    }
  }
  
  @Nullable
  private MaterialShapeDrawable c(boolean paramBoolean)
  {
    LayerDrawable localLayerDrawable = this.s;
    if ((localLayerDrawable != null) && (localLayerDrawable.getNumberOfLayers() > 0))
    {
      if (a) {
        return (MaterialShapeDrawable)((LayerDrawable)((InsetDrawable)this.s.getDrawable(0)).getDrawable()).getDrawable(paramBoolean ^ true);
      }
      return (MaterialShapeDrawable)this.s.getDrawable(paramBoolean ^ true);
    }
    return null;
  }
  
  private void o()
  {
    this.b.setInternalBackground(p());
    MaterialShapeDrawable localMaterialShapeDrawable = i();
    if (localMaterialShapeDrawable != null) {
      localMaterialShapeDrawable.r(this.t);
    }
  }
  
  private Drawable p()
  {
    MaterialShapeDrawable localMaterialShapeDrawable = new MaterialShapeDrawable(this.c);
    localMaterialShapeDrawable.a(this.b.getContext());
    DrawableCompat.setTintList(localMaterialShapeDrawable, this.k);
    Object localObject = this.j;
    if (localObject != null) {
      DrawableCompat.setTintMode(localMaterialShapeDrawable, (PorterDuff.Mode)localObject);
    }
    localMaterialShapeDrawable.a(this.i, this.l);
    localObject = new MaterialShapeDrawable(this.c);
    ((MaterialShapeDrawable)localObject).setTint(0);
    float f1 = this.i;
    int i1;
    if (this.o) {
      i1 = MaterialColors.a(this.b, R.attr.t);
    } else {
      i1 = 0;
    }
    ((MaterialShapeDrawable)localObject).a(f1, i1);
    if (a)
    {
      this.n = new MaterialShapeDrawable(this.c);
      DrawableCompat.setTint(this.n, -1);
      this.s = new RippleDrawable(RippleUtils.b(this.m), a(new LayerDrawable(new Drawable[] { localObject, localMaterialShapeDrawable })), this.n);
      return this.s;
    }
    this.n = new RippleDrawableCompat(this.c);
    DrawableCompat.setTintList(this.n, RippleUtils.b(this.m));
    this.s = new LayerDrawable(new Drawable[] { localObject, localMaterialShapeDrawable, this.n });
    return a(this.s);
  }
  
  private void q()
  {
    MaterialShapeDrawable localMaterialShapeDrawable1 = i();
    MaterialShapeDrawable localMaterialShapeDrawable2 = r();
    if (localMaterialShapeDrawable1 != null)
    {
      localMaterialShapeDrawable1.a(this.i, this.l);
      if (localMaterialShapeDrawable2 != null)
      {
        float f1 = this.i;
        int i1;
        if (this.o) {
          i1 = MaterialColors.a(this.b, R.attr.t);
        } else {
          i1 = 0;
        }
        localMaterialShapeDrawable2.a(f1, i1);
      }
    }
  }
  
  @Nullable
  private MaterialShapeDrawable r()
  {
    return c(true);
  }
  
  void a()
  {
    this.p = true;
    this.b.setSupportBackgroundTintList(this.k);
    this.b.setSupportBackgroundTintMode(this.j);
  }
  
  void a(int paramInt)
  {
    if (i() != null) {
      i().setTint(paramInt);
    }
  }
  
  void a(int paramInt1, int paramInt2)
  {
    Drawable localDrawable = this.n;
    if (localDrawable != null) {
      localDrawable.setBounds(this.d, this.f, paramInt2 - this.e, paramInt1 - this.g);
    }
  }
  
  void a(@Nullable ColorStateList paramColorStateList)
  {
    if (this.k != paramColorStateList)
    {
      this.k = paramColorStateList;
      if (i() != null) {
        DrawableCompat.setTintList(i(), this.k);
      }
    }
  }
  
  void a(@NonNull TypedArray paramTypedArray)
  {
    this.d = paramTypedArray.getDimensionPixelOffset(R.styleable.dF, 0);
    this.e = paramTypedArray.getDimensionPixelOffset(R.styleable.dG, 0);
    this.f = paramTypedArray.getDimensionPixelOffset(R.styleable.dH, 0);
    this.g = paramTypedArray.getDimensionPixelOffset(R.styleable.dI, 0);
    if (paramTypedArray.hasValue(R.styleable.dM))
    {
      this.h = paramTypedArray.getDimensionPixelSize(R.styleable.dM, -1);
      a(this.c.a(this.h));
      this.q = true;
    }
    this.i = paramTypedArray.getDimensionPixelSize(R.styleable.dW, 0);
    this.j = ViewUtils.a(paramTypedArray.getInt(R.styleable.dL, -1), PorterDuff.Mode.SRC_IN);
    this.k = MaterialResources.a(this.b.getContext(), paramTypedArray, R.styleable.dK);
    this.l = MaterialResources.a(this.b.getContext(), paramTypedArray, R.styleable.dV);
    this.m = MaterialResources.a(this.b.getContext(), paramTypedArray, R.styleable.dU);
    this.r = paramTypedArray.getBoolean(R.styleable.dJ, false);
    this.t = paramTypedArray.getDimensionPixelSize(R.styleable.dN, 0);
    int i1 = ViewCompat.getPaddingStart(this.b);
    int i2 = this.b.getPaddingTop();
    int i3 = ViewCompat.getPaddingEnd(this.b);
    int i4 = this.b.getPaddingBottom();
    if (paramTypedArray.hasValue(R.styleable.dE)) {
      a();
    } else {
      o();
    }
    ViewCompat.setPaddingRelative(this.b, i1 + this.d, i2 + this.f, i3 + this.e, i4 + this.g);
  }
  
  void a(@Nullable PorterDuff.Mode paramMode)
  {
    if (this.j != paramMode)
    {
      this.j = paramMode;
      if ((i() != null) && (this.j != null)) {
        DrawableCompat.setTintMode(i(), this.j);
      }
    }
  }
  
  void a(@NonNull ShapeAppearanceModel paramShapeAppearanceModel)
  {
    this.c = paramShapeAppearanceModel;
    b(paramShapeAppearanceModel);
  }
  
  void a(boolean paramBoolean)
  {
    this.o = paramBoolean;
    q();
  }
  
  void b(int paramInt)
  {
    if (this.i != paramInt)
    {
      this.i = paramInt;
      q();
    }
  }
  
  void b(@Nullable ColorStateList paramColorStateList)
  {
    if (this.m != paramColorStateList)
    {
      this.m = paramColorStateList;
      if ((a) && ((this.b.getBackground() instanceof RippleDrawable)))
      {
        ((RippleDrawable)this.b.getBackground()).setColor(RippleUtils.b(paramColorStateList));
        return;
      }
      if ((!a) && ((this.b.getBackground() instanceof RippleDrawableCompat))) {
        ((RippleDrawableCompat)this.b.getBackground()).setTintList(RippleUtils.b(paramColorStateList));
      }
    }
  }
  
  void b(boolean paramBoolean)
  {
    this.r = paramBoolean;
  }
  
  boolean b()
  {
    return this.p;
  }
  
  ColorStateList c()
  {
    return this.k;
  }
  
  void c(int paramInt)
  {
    if ((!this.q) || (this.h != paramInt))
    {
      this.h = paramInt;
      this.q = true;
      a(this.c.a(paramInt));
    }
  }
  
  void c(@Nullable ColorStateList paramColorStateList)
  {
    if (this.l != paramColorStateList)
    {
      this.l = paramColorStateList;
      q();
    }
  }
  
  PorterDuff.Mode d()
  {
    return this.j;
  }
  
  public void d(@Dimension int paramInt)
  {
    b(this.f, paramInt);
  }
  
  @Nullable
  ColorStateList e()
  {
    return this.m;
  }
  
  public void e(@Dimension int paramInt)
  {
    b(paramInt, this.g);
  }
  
  @Nullable
  ColorStateList f()
  {
    return this.l;
  }
  
  int g()
  {
    return this.i;
  }
  
  int h()
  {
    return this.h;
  }
  
  @Nullable
  MaterialShapeDrawable i()
  {
    return c(false);
  }
  
  boolean j()
  {
    return this.r;
  }
  
  @Nullable
  public Shapeable k()
  {
    LayerDrawable localLayerDrawable = this.s;
    if ((localLayerDrawable != null) && (localLayerDrawable.getNumberOfLayers() > 1))
    {
      if (this.s.getNumberOfLayers() > 2) {
        return (Shapeable)this.s.getDrawable(2);
      }
      return (Shapeable)this.s.getDrawable(1);
    }
    return null;
  }
  
  @NonNull
  ShapeAppearanceModel l()
  {
    return this.c;
  }
  
  public int m()
  {
    return this.g;
  }
  
  public int n()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.button.MaterialButtonHelper
 * JD-Core Version:    0.7.0.1
 */