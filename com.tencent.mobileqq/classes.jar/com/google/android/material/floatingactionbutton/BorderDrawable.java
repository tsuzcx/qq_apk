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
  float jdField_a_of_type_Float;
  @ColorInt
  private int jdField_a_of_type_Int;
  @Nullable
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  @NonNull
  private final Paint jdField_a_of_type_AndroidGraphicsPaint;
  private final Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private final BorderDrawable.BorderState jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonBorderDrawable$BorderState = new BorderDrawable.BorderState(this, null);
  private ShapeAppearanceModel jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel;
  private final ShapeAppearancePathProvider jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearancePathProvider = ShapeAppearancePathProvider.a();
  private boolean jdField_a_of_type_Boolean = true;
  @ColorInt
  private int jdField_b_of_type_Int;
  private final RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  @ColorInt
  private int c;
  @ColorInt
  private int d;
  @ColorInt
  private int e;
  
  BorderDrawable(ShapeAppearanceModel paramShapeAppearanceModel)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel = paramShapeAppearanceModel;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
  }
  
  @NonNull
  private Shader a()
  {
    Object localObject = this.jdField_a_of_type_AndroidGraphicsRect;
    copyBounds((Rect)localObject);
    float f1 = this.jdField_a_of_type_Float / ((Rect)localObject).height();
    int i = ColorUtils.compositeColors(this.jdField_a_of_type_Int, this.e);
    int j = ColorUtils.compositeColors(this.jdField_b_of_type_Int, this.e);
    int k = ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.jdField_b_of_type_Int, 0), this.e);
    int m = ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.d, 0), this.e);
    int n = ColorUtils.compositeColors(this.d, this.e);
    int i1 = ColorUtils.compositeColors(this.c, this.e);
    float f2 = ((Rect)localObject).top;
    float f3 = ((Rect)localObject).bottom;
    localObject = Shader.TileMode.CLAMP;
    return new LinearGradient(0.0F, f2, 0.0F, f3, new int[] { i, j, k, m, n, i1 }, new float[] { 0.0F, f1, 0.5F, 0.5F, 1.0F - f1, 1.0F }, (Shader.TileMode)localObject);
  }
  
  @NonNull
  protected RectF a()
  {
    this.jdField_b_of_type_AndroidGraphicsRectF.set(getBounds());
    return this.jdField_b_of_type_AndroidGraphicsRectF;
  }
  
  public void a(@Dimension float paramFloat)
  {
    if (this.jdField_a_of_type_Float != paramFloat)
    {
      this.jdField_a_of_type_Float = paramFloat;
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(paramFloat * 1.3333F);
      this.jdField_a_of_type_Boolean = true;
      invalidateSelf();
    }
  }
  
  void a(@ColorInt int paramInt1, @ColorInt int paramInt2, @ColorInt int paramInt3, @ColorInt int paramInt4)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
  }
  
  void a(@Nullable ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null) {
      this.e = paramColorStateList.getColorForState(getState(), this.e);
    }
    this.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList;
    this.jdField_a_of_type_Boolean = true;
    invalidateSelf();
  }
  
  public void a(ShapeAppearanceModel paramShapeAppearanceModel)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel = paramShapeAppearanceModel;
    invalidateSelf();
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setShader(a());
      this.jdField_a_of_type_Boolean = false;
    }
    float f1 = this.jdField_a_of_type_AndroidGraphicsPaint.getStrokeWidth() / 2.0F;
    copyBounds(this.jdField_a_of_type_AndroidGraphicsRect);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(this.jdField_a_of_type_AndroidGraphicsRect);
    float f2 = Math.min(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel.a().a(a()), this.jdField_a_of_type_AndroidGraphicsRectF.width() / 2.0F);
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel.a(a()))
    {
      this.jdField_a_of_type_AndroidGraphicsRectF.inset(f1, f1);
      paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, f2, f2, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  @Nullable
  public Drawable.ConstantState getConstantState()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonBorderDrawable$BorderState;
  }
  
  public int getOpacity()
  {
    if (this.jdField_a_of_type_Float > 0.0F) {
      return -3;
    }
    return -2;
  }
  
  @TargetApi(21)
  public void getOutline(@NonNull Outline paramOutline)
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel.a(a()))
    {
      float f = this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel.a().a(a());
      paramOutline.setRoundRect(getBounds(), f);
      return;
    }
    copyBounds(this.jdField_a_of_type_AndroidGraphicsRect);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(this.jdField_a_of_type_AndroidGraphicsRect);
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearancePathProvider.a(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel, 1.0F, this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPath);
    if (this.jdField_a_of_type_AndroidGraphicsPath.isConvex()) {
      paramOutline.setConvexPath(this.jdField_a_of_type_AndroidGraphicsPath);
    }
  }
  
  public boolean getPadding(@NonNull Rect paramRect)
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel.a(a()))
    {
      int i = Math.round(this.jdField_a_of_type_Float);
      paramRect.set(i, i, i, i);
    }
    return true;
  }
  
  public boolean isStateful()
  {
    ColorStateList localColorStateList = this.jdField_a_of_type_AndroidContentResColorStateList;
    return ((localColorStateList != null) && (localColorStateList.isStateful())) || (super.isStateful());
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    ColorStateList localColorStateList = this.jdField_a_of_type_AndroidContentResColorStateList;
    if (localColorStateList != null)
    {
      int i = localColorStateList.getColorForState(paramArrayOfInt, this.e);
      if (i != this.e)
      {
        this.jdField_a_of_type_Boolean = true;
        this.e = i;
      }
    }
    if (this.jdField_a_of_type_Boolean) {
      invalidateSelf();
    }
    return this.jdField_a_of_type_Boolean;
  }
  
  public void setAlpha(@IntRange(from=0L, to=255L) int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
    invalidateSelf();
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.BorderDrawable
 * JD-Core Version:    0.7.0.1
 */