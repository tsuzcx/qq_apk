package com.google.android.material.floatingactionbutton;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
class BorderDrawable
  extends Drawable
{
  @Dimension
  float a;
  private final ShapeAppearancePathProvider b = ShapeAppearancePathProvider.a();
  @NonNull
  private final Paint c;
  private final Path d = new Path();
  private final Rect e = new Rect();
  private final RectF f = new RectF();
  private final RectF g = new RectF();
  private final BorderDrawable.BorderState h = new BorderDrawable.BorderState(this, null);
  @ColorInt
  private int i;
  @ColorInt
  private int j;
  @ColorInt
  private int k;
  @ColorInt
  private int l;
  @ColorInt
  private int m;
  private boolean n = true;
  private ShapeAppearanceModel o;
  @Nullable
  private ColorStateList p;
  
  BorderDrawable(ShapeAppearanceModel paramShapeAppearanceModel)
  {
    this.o = paramShapeAppearanceModel;
    this.c = new Paint(1);
    this.c.setStyle(Paint.Style.STROKE);
  }
  
  @NonNull
  private Shader b()
  {
    Object localObject = this.e;
    copyBounds((Rect)localObject);
    float f1 = this.a / ((Rect)localObject).height();
    int i1 = ColorUtils.compositeColors(this.i, this.m);
    int i2 = ColorUtils.compositeColors(this.j, this.m);
    int i3 = ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.j, 0), this.m);
    int i4 = ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.l, 0), this.m);
    int i5 = ColorUtils.compositeColors(this.l, this.m);
    int i6 = ColorUtils.compositeColors(this.k, this.m);
    float f2 = ((Rect)localObject).top;
    float f3 = ((Rect)localObject).bottom;
    localObject = Shader.TileMode.CLAMP;
    return new LinearGradient(0.0F, f2, 0.0F, f3, new int[] { i1, i2, i3, i4, i5, i6 }, new float[] { 0.0F, f1, 0.5F, 0.5F, 1.0F - f1, 1.0F }, (Shader.TileMode)localObject);
  }
  
  @NonNull
  protected RectF a()
  {
    this.g.set(getBounds());
    return this.g;
  }
  
  public void a(@Dimension float paramFloat)
  {
    if (this.a != paramFloat)
    {
      this.a = paramFloat;
      this.c.setStrokeWidth(paramFloat * 1.3333F);
      this.n = true;
      invalidateSelf();
    }
  }
  
  void a(@ColorInt int paramInt1, @ColorInt int paramInt2, @ColorInt int paramInt3, @ColorInt int paramInt4)
  {
    this.i = paramInt1;
    this.j = paramInt2;
    this.k = paramInt3;
    this.l = paramInt4;
  }
  
  void a(@Nullable ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null) {
      this.m = paramColorStateList.getColorForState(getState(), this.m);
    }
    this.p = paramColorStateList;
    this.n = true;
    invalidateSelf();
  }
  
  public void a(ShapeAppearanceModel paramShapeAppearanceModel)
  {
    this.o = paramShapeAppearanceModel;
    invalidateSelf();
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    if (this.n)
    {
      this.c.setShader(b());
      this.n = false;
    }
    float f1 = this.c.getStrokeWidth() / 2.0F;
    copyBounds(this.e);
    this.f.set(this.e);
    float f2 = Math.min(this.o.f().a(a()), this.f.width() / 2.0F);
    if (this.o.a(a()))
    {
      this.f.inset(f1, f1);
      paramCanvas.drawRoundRect(this.f, f2, f2, this.c);
    }
  }
  
  @Nullable
  public Drawable.ConstantState getConstantState()
  {
    return this.h;
  }
  
  public int getOpacity()
  {
    if (this.a > 0.0F) {
      return -3;
    }
    return -2;
  }
  
  @TargetApi(21)
  public void getOutline(@NonNull Outline paramOutline)
  {
    if (this.o.a(a()))
    {
      float f1 = this.o.f().a(a());
      paramOutline.setRoundRect(getBounds(), f1);
      return;
    }
    copyBounds(this.e);
    this.f.set(this.e);
    this.b.a(this.o, 1.0F, this.f, this.d);
    if (this.d.isConvex()) {
      paramOutline.setConvexPath(this.d);
    }
  }
  
  public boolean getPadding(@NonNull Rect paramRect)
  {
    if (this.o.a(a()))
    {
      int i1 = Math.round(this.a);
      paramRect.set(i1, i1, i1, i1);
    }
    return true;
  }
  
  public boolean isStateful()
  {
    ColorStateList localColorStateList = this.p;
    return ((localColorStateList != null) && (localColorStateList.isStateful())) || (super.isStateful());
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.n = true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    ColorStateList localColorStateList = this.p;
    if (localColorStateList != null)
    {
      int i1 = localColorStateList.getColorForState(paramArrayOfInt, this.m);
      if (i1 != this.m)
      {
        this.n = true;
        this.m = i1;
      }
    }
    if (this.n) {
      invalidateSelf();
    }
    return this.n;
  }
  
  public void setAlpha(@IntRange(from=0L, to=255L) int paramInt)
  {
    this.c.setAlpha(paramInt);
    invalidateSelf();
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter)
  {
    this.c.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.BorderDrawable
 * JD-Core Version:    0.7.0.1
 */