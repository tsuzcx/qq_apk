package com.google.android.material.shape;

import android.content.res.ColorStateList;
import android.graphics.ColorFilter;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.elevation.ElevationOverlayProvider;

final class MaterialShapeDrawable$MaterialShapeDrawableState
  extends Drawable.ConstantState
{
  @NonNull
  public ShapeAppearanceModel a;
  @Nullable
  public ElevationOverlayProvider b;
  @Nullable
  public ColorFilter c;
  @Nullable
  public ColorStateList d = null;
  @Nullable
  public ColorStateList e = null;
  @Nullable
  public ColorStateList f = null;
  @Nullable
  public ColorStateList g = null;
  @Nullable
  public PorterDuff.Mode h = PorterDuff.Mode.SRC_IN;
  @Nullable
  public Rect i = null;
  public float j = 1.0F;
  public float k = 1.0F;
  public float l;
  public int m = 255;
  public float n = 0.0F;
  public float o = 0.0F;
  public float p = 0.0F;
  public int q = 0;
  public int r = 0;
  public int s = 0;
  public int t = 0;
  public boolean u = false;
  public Paint.Style v = Paint.Style.FILL_AND_STROKE;
  
  public MaterialShapeDrawable$MaterialShapeDrawableState(@NonNull MaterialShapeDrawableState paramMaterialShapeDrawableState)
  {
    this.a = paramMaterialShapeDrawableState.a;
    this.b = paramMaterialShapeDrawableState.b;
    this.l = paramMaterialShapeDrawableState.l;
    this.c = paramMaterialShapeDrawableState.c;
    this.d = paramMaterialShapeDrawableState.d;
    this.e = paramMaterialShapeDrawableState.e;
    this.h = paramMaterialShapeDrawableState.h;
    this.g = paramMaterialShapeDrawableState.g;
    this.m = paramMaterialShapeDrawableState.m;
    this.j = paramMaterialShapeDrawableState.j;
    this.s = paramMaterialShapeDrawableState.s;
    this.q = paramMaterialShapeDrawableState.q;
    this.u = paramMaterialShapeDrawableState.u;
    this.k = paramMaterialShapeDrawableState.k;
    this.n = paramMaterialShapeDrawableState.n;
    this.o = paramMaterialShapeDrawableState.o;
    this.p = paramMaterialShapeDrawableState.p;
    this.r = paramMaterialShapeDrawableState.r;
    this.t = paramMaterialShapeDrawableState.t;
    this.f = paramMaterialShapeDrawableState.f;
    this.v = paramMaterialShapeDrawableState.v;
    paramMaterialShapeDrawableState = paramMaterialShapeDrawableState.i;
    if (paramMaterialShapeDrawableState != null) {
      this.i = new Rect(paramMaterialShapeDrawableState);
    }
  }
  
  public MaterialShapeDrawable$MaterialShapeDrawableState(ShapeAppearanceModel paramShapeAppearanceModel, ElevationOverlayProvider paramElevationOverlayProvider)
  {
    this.a = paramShapeAppearanceModel;
    this.b = paramElevationOverlayProvider;
  }
  
  public int getChangingConfigurations()
  {
    return 0;
  }
  
  @NonNull
  public Drawable newDrawable()
  {
    MaterialShapeDrawable localMaterialShapeDrawable = new MaterialShapeDrawable(this, null);
    MaterialShapeDrawable.a(localMaterialShapeDrawable, true);
    return localMaterialShapeDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.shape.MaterialShapeDrawable.MaterialShapeDrawableState
 * JD-Core Version:    0.7.0.1
 */