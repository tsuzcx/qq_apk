package com.google.android.material.transition.platform;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.transition.PathMotion;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

final class MaterialContainerTransform$TransitionDrawable
  extends Drawable
{
  private final float jdField_a_of_type_Float;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private final Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  private final PathMeasure jdField_a_of_type_AndroidGraphicsPathMeasure;
  private final RectF jdField_a_of_type_AndroidGraphicsRectF;
  private final View jdField_a_of_type_AndroidViewView;
  private final MaterialShapeDrawable jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable = new MaterialShapeDrawable();
  private final ShapeAppearanceModel jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel;
  private final FadeModeEvaluator jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformFadeModeEvaluator;
  private FadeModeResult jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformFadeModeResult;
  private final FitModeEvaluator jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformFitModeEvaluator;
  private FitModeResult jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformFitModeResult;
  private final MaskEvaluator jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformMaskEvaluator = new MaskEvaluator();
  private final MaterialContainerTransform.ProgressThresholdsGroup jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformMaterialContainerTransform$ProgressThresholdsGroup;
  private final boolean jdField_a_of_type_Boolean;
  private final float[] jdField_a_of_type_ArrayOfFloat = new float[2];
  private final float jdField_b_of_type_Float;
  private final Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint();
  private final RectF jdField_b_of_type_AndroidGraphicsRectF;
  private final View jdField_b_of_type_AndroidViewView;
  private final ShapeAppearanceModel jdField_b_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel;
  private final boolean jdField_b_of_type_Boolean;
  private final float jdField_c_of_type_Float;
  private final Paint jdField_c_of_type_AndroidGraphicsPaint = new Paint();
  private final RectF jdField_c_of_type_AndroidGraphicsRectF;
  private final boolean jdField_c_of_type_Boolean;
  private final float jdField_d_of_type_Float;
  private final Paint jdField_d_of_type_AndroidGraphicsPaint = new Paint();
  private final RectF jdField_d_of_type_AndroidGraphicsRectF;
  private final float jdField_e_of_type_Float;
  private final Paint jdField_e_of_type_AndroidGraphicsPaint = new Paint();
  private final RectF jdField_e_of_type_AndroidGraphicsRectF;
  private float jdField_f_of_type_Float;
  private final Paint jdField_f_of_type_AndroidGraphicsPaint = new Paint();
  private final RectF jdField_f_of_type_AndroidGraphicsRectF;
  private float jdField_g_of_type_Float;
  private RectF jdField_g_of_type_AndroidGraphicsRectF;
  private float h;
  
  private MaterialContainerTransform$TransitionDrawable(PathMotion paramPathMotion, View paramView1, RectF paramRectF1, ShapeAppearanceModel paramShapeAppearanceModel1, float paramFloat1, View paramView2, RectF paramRectF2, ShapeAppearanceModel paramShapeAppearanceModel2, float paramFloat2, @ColorInt int paramInt1, @ColorInt int paramInt2, @ColorInt int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, FadeModeEvaluator paramFadeModeEvaluator, FitModeEvaluator paramFitModeEvaluator, MaterialContainerTransform.ProgressThresholdsGroup paramProgressThresholdsGroup, boolean paramBoolean3)
  {
    this.jdField_a_of_type_AndroidViewView = paramView1;
    this.jdField_a_of_type_AndroidGraphicsRectF = paramRectF1;
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel = paramShapeAppearanceModel1;
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_AndroidViewView = paramView2;
    this.jdField_b_of_type_AndroidGraphicsRectF = paramRectF2;
    this.jdField_b_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel = paramShapeAppearanceModel2;
    this.jdField_b_of_type_Float = paramFloat2;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformFadeModeEvaluator = paramFadeModeEvaluator;
    this.jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformFitModeEvaluator = paramFitModeEvaluator;
    this.jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformMaterialContainerTransform$ProgressThresholdsGroup = paramProgressThresholdsGroup;
    this.jdField_c_of_type_Boolean = paramBoolean3;
    paramView1 = (WindowManager)paramView1.getContext().getSystemService("window");
    paramShapeAppearanceModel1 = new DisplayMetrics();
    paramView1.getDefaultDisplay().getMetrics(paramShapeAppearanceModel1);
    this.jdField_d_of_type_Float = paramShapeAppearanceModel1.widthPixels;
    this.jdField_e_of_type_Float = paramShapeAppearanceModel1.heightPixels;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt1);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(paramInt2);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(paramInt3);
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.g(ColorStateList.valueOf(0));
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.D(2);
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.g(false);
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.G(-7829368);
    this.jdField_c_of_type_AndroidGraphicsRectF = new RectF(paramRectF1);
    this.jdField_d_of_type_AndroidGraphicsRectF = new RectF(this.jdField_c_of_type_AndroidGraphicsRectF);
    this.jdField_e_of_type_AndroidGraphicsRectF = new RectF(this.jdField_c_of_type_AndroidGraphicsRectF);
    this.jdField_f_of_type_AndroidGraphicsRectF = new RectF(this.jdField_e_of_type_AndroidGraphicsRectF);
    paramView1 = a(paramRectF1);
    paramShapeAppearanceModel1 = a(paramRectF2);
    this.jdField_a_of_type_AndroidGraphicsPathMeasure = new PathMeasure(paramPathMotion.getPath(paramView1.x, paramView1.y, paramShapeAppearanceModel1.x, paramShapeAppearanceModel1.y), false);
    this.jdField_c_of_type_Float = this.jdField_a_of_type_AndroidGraphicsPathMeasure.getLength();
    this.jdField_a_of_type_ArrayOfFloat[0] = paramRectF1.centerX();
    this.jdField_a_of_type_ArrayOfFloat[1] = paramRectF1.top;
    this.jdField_e_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_e_of_type_AndroidGraphicsPaint.setShader(TransitionUtils.a(paramInt4));
    this.jdField_f_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_f_of_type_AndroidGraphicsPaint.setStrokeWidth(10.0F);
    b(0.0F);
  }
  
  private static float a(RectF paramRectF, float paramFloat)
  {
    return (paramRectF.centerX() / (paramFloat / 2.0F) - 1.0F) * 0.3F;
  }
  
  private static PointF a(RectF paramRectF)
  {
    return new PointF(paramRectF.centerX(), paramRectF.top);
  }
  
  private void a(float paramFloat)
  {
    if (this.h != paramFloat) {
      b(paramFloat);
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.clipPath(this.jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformMaskEvaluator.a(), Region.Op.DIFFERENCE);
    if (Build.VERSION.SDK_INT > 28) {
      b(paramCanvas);
    } else {
      c(paramCanvas);
    }
    paramCanvas.restore();
  }
  
  private void a(Canvas paramCanvas, Paint paramPaint)
  {
    if ((paramPaint.getColor() != 0) && (paramPaint.getAlpha() > 0)) {
      paramCanvas.drawRect(getBounds(), paramPaint);
    }
  }
  
  private void a(Canvas paramCanvas, RectF paramRectF, @ColorInt int paramInt)
  {
    this.jdField_f_of_type_AndroidGraphicsPaint.setColor(paramInt);
    paramCanvas.drawRect(paramRectF, this.jdField_f_of_type_AndroidGraphicsPaint);
  }
  
  private void a(Canvas paramCanvas, RectF paramRectF, Path paramPath, @ColorInt int paramInt)
  {
    paramRectF = a(paramRectF);
    if (this.h == 0.0F)
    {
      paramPath.reset();
      paramPath.moveTo(paramRectF.x, paramRectF.y);
      return;
    }
    paramPath.lineTo(paramRectF.x, paramRectF.y);
    this.jdField_f_of_type_AndroidGraphicsPaint.setColor(paramInt);
    paramCanvas.drawPath(paramPath, this.jdField_f_of_type_AndroidGraphicsPaint);
  }
  
  private static float b(RectF paramRectF, float paramFloat)
  {
    return paramRectF.centerY() / paramFloat * 1.5F;
  }
  
  private void b(float paramFloat)
  {
    this.h = paramFloat;
    Object localObject = this.jdField_e_of_type_AndroidGraphicsPaint;
    if (this.jdField_a_of_type_Boolean) {
      f1 = TransitionUtils.a(0.0F, 255.0F, paramFloat);
    } else {
      f1 = TransitionUtils.a(255.0F, 0.0F, paramFloat);
    }
    ((Paint)localObject).setAlpha((int)f1);
    this.jdField_a_of_type_AndroidGraphicsPathMeasure.getPosTan(this.jdField_c_of_type_Float * paramFloat, this.jdField_a_of_type_ArrayOfFloat, null);
    localObject = this.jdField_a_of_type_ArrayOfFloat;
    float f4 = localObject[0];
    float f3 = localObject[1];
    if (paramFloat <= 1.0F)
    {
      f1 = f3;
      f2 = f4;
      if (paramFloat < 0.0F) {}
    }
    for (;;)
    {
      break;
      if (paramFloat > 1.0F)
      {
        f2 = 0.99F;
        f1 = (paramFloat - 1.0F) / 0.009999991F;
      }
      else
      {
        f2 = 0.01F;
        f1 = paramFloat / 0.01F * -1.0F;
      }
      this.jdField_a_of_type_AndroidGraphicsPathMeasure.getPosTan(this.jdField_c_of_type_Float * f2, this.jdField_a_of_type_ArrayOfFloat, null);
      localObject = this.jdField_a_of_type_ArrayOfFloat;
      f2 = localObject[0];
      float f5 = localObject[1];
      f2 = f4 + (f4 - f2) * f1;
      f1 = f3 + (f3 - f5) * f1;
    }
    f3 = ((Float)Preconditions.checkNotNull(Float.valueOf(MaterialContainerTransform.ProgressThresholds.a(MaterialContainerTransform.ProgressThresholdsGroup.b(this.jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformMaterialContainerTransform$ProgressThresholdsGroup))))).floatValue();
    f4 = ((Float)Preconditions.checkNotNull(Float.valueOf(MaterialContainerTransform.ProgressThresholds.b(MaterialContainerTransform.ProgressThresholdsGroup.b(this.jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformMaterialContainerTransform$ProgressThresholdsGroup))))).floatValue();
    this.jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformFitModeResult = this.jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformFitModeEvaluator.a(paramFloat, f3, f4, this.jdField_a_of_type_AndroidGraphicsRectF.width(), this.jdField_a_of_type_AndroidGraphicsRectF.height(), this.jdField_b_of_type_AndroidGraphicsRectF.width(), this.jdField_b_of_type_AndroidGraphicsRectF.height());
    this.jdField_c_of_type_AndroidGraphicsRectF.set(f2 - this.jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformFitModeResult.jdField_c_of_type_Float / 2.0F, f1, this.jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformFitModeResult.jdField_c_of_type_Float / 2.0F + f2, this.jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformFitModeResult.jdField_d_of_type_Float + f1);
    this.jdField_e_of_type_AndroidGraphicsRectF.set(f2 - this.jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformFitModeResult.jdField_e_of_type_Float / 2.0F, f1, f2 + this.jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformFitModeResult.jdField_e_of_type_Float / 2.0F, this.jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformFitModeResult.jdField_f_of_type_Float + f1);
    this.jdField_d_of_type_AndroidGraphicsRectF.set(this.jdField_c_of_type_AndroidGraphicsRectF);
    this.jdField_f_of_type_AndroidGraphicsRectF.set(this.jdField_e_of_type_AndroidGraphicsRectF);
    float f1 = ((Float)Preconditions.checkNotNull(Float.valueOf(MaterialContainerTransform.ProgressThresholds.a(MaterialContainerTransform.ProgressThresholdsGroup.c(this.jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformMaterialContainerTransform$ProgressThresholdsGroup))))).floatValue();
    float f2 = ((Float)Preconditions.checkNotNull(Float.valueOf(MaterialContainerTransform.ProgressThresholds.b(MaterialContainerTransform.ProgressThresholdsGroup.c(this.jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformMaterialContainerTransform$ProgressThresholdsGroup))))).floatValue();
    boolean bool = this.jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformFitModeEvaluator.a(this.jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformFitModeResult);
    if (bool) {
      localObject = this.jdField_d_of_type_AndroidGraphicsRectF;
    } else {
      localObject = this.jdField_f_of_type_AndroidGraphicsRectF;
    }
    f1 = TransitionUtils.a(0.0F, 1.0F, f1, f2, paramFloat);
    if (!bool) {
      f1 = 1.0F - f1;
    }
    this.jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformFitModeEvaluator.a((RectF)localObject, f1, this.jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformFitModeResult);
    this.jdField_g_of_type_AndroidGraphicsRectF = new RectF(Math.min(this.jdField_d_of_type_AndroidGraphicsRectF.left, this.jdField_f_of_type_AndroidGraphicsRectF.left), Math.min(this.jdField_d_of_type_AndroidGraphicsRectF.top, this.jdField_f_of_type_AndroidGraphicsRectF.top), Math.max(this.jdField_d_of_type_AndroidGraphicsRectF.right, this.jdField_f_of_type_AndroidGraphicsRectF.right), Math.max(this.jdField_d_of_type_AndroidGraphicsRectF.bottom, this.jdField_f_of_type_AndroidGraphicsRectF.bottom));
    this.jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformMaskEvaluator.a(paramFloat, this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel, this.jdField_b_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel, this.jdField_c_of_type_AndroidGraphicsRectF, this.jdField_d_of_type_AndroidGraphicsRectF, this.jdField_f_of_type_AndroidGraphicsRectF, MaterialContainerTransform.ProgressThresholdsGroup.d(this.jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformMaterialContainerTransform$ProgressThresholdsGroup));
    this.jdField_f_of_type_Float = TransitionUtils.a(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, paramFloat);
    f3 = a(this.jdField_g_of_type_AndroidGraphicsRectF, this.jdField_d_of_type_Float);
    f1 = b(this.jdField_g_of_type_AndroidGraphicsRectF, this.jdField_e_of_type_Float);
    f2 = this.jdField_f_of_type_Float;
    f3 = (int)(f3 * f2);
    this.jdField_g_of_type_Float = ((int)(f1 * f2));
    this.jdField_d_of_type_AndroidGraphicsPaint.setShadowLayer(f2, f3, this.jdField_g_of_type_Float, 754974720);
    f1 = ((Float)Preconditions.checkNotNull(Float.valueOf(MaterialContainerTransform.ProgressThresholds.a(MaterialContainerTransform.ProgressThresholdsGroup.a(this.jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformMaterialContainerTransform$ProgressThresholdsGroup))))).floatValue();
    f2 = ((Float)Preconditions.checkNotNull(Float.valueOf(MaterialContainerTransform.ProgressThresholds.b(MaterialContainerTransform.ProgressThresholdsGroup.a(this.jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformMaterialContainerTransform$ProgressThresholdsGroup))))).floatValue();
    this.jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformFadeModeResult = this.jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformFadeModeEvaluator.a(paramFloat, f1, f2);
    if (this.jdField_b_of_type_AndroidGraphicsPaint.getColor() != 0) {
      this.jdField_b_of_type_AndroidGraphicsPaint.setAlpha(this.jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformFadeModeResult.jdField_a_of_type_Int);
    }
    if (this.jdField_c_of_type_AndroidGraphicsPaint.getColor() != 0) {
      this.jdField_c_of_type_AndroidGraphicsPaint.setAlpha(this.jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformFadeModeResult.b);
    }
    invalidateSelf();
  }
  
  private void b(Canvas paramCanvas)
  {
    ShapeAppearanceModel localShapeAppearanceModel = this.jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformMaskEvaluator.a();
    if (localShapeAppearanceModel.a(this.jdField_g_of_type_AndroidGraphicsRectF))
    {
      float f1 = localShapeAppearanceModel.a().a(this.jdField_g_of_type_AndroidGraphicsRectF);
      paramCanvas.drawRoundRect(this.jdField_g_of_type_AndroidGraphicsRectF, f1, f1, this.jdField_d_of_type_AndroidGraphicsPaint);
      return;
    }
    paramCanvas.drawPath(this.jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformMaskEvaluator.a(), this.jdField_d_of_type_AndroidGraphicsPaint);
  }
  
  private void c(Canvas paramCanvas)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.setBounds((int)this.jdField_g_of_type_AndroidGraphicsRectF.left, (int)this.jdField_g_of_type_AndroidGraphicsRectF.top, (int)this.jdField_g_of_type_AndroidGraphicsRectF.right, (int)this.jdField_g_of_type_AndroidGraphicsRectF.bottom);
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.r(this.jdField_f_of_type_Float);
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.E((int)this.jdField_g_of_type_Float);
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.setShapeAppearanceModel(this.jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformMaskEvaluator.a());
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.draw(paramCanvas);
  }
  
  private void d(Canvas paramCanvas)
  {
    a(paramCanvas, this.jdField_b_of_type_AndroidGraphicsPaint);
    TransitionUtils.a(paramCanvas, getBounds(), this.jdField_c_of_type_AndroidGraphicsRectF.left, this.jdField_c_of_type_AndroidGraphicsRectF.top, this.jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformFitModeResult.jdField_a_of_type_Float, this.jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformFadeModeResult.jdField_a_of_type_Int, new MaterialContainerTransform.TransitionDrawable.1(this));
  }
  
  private void e(Canvas paramCanvas)
  {
    a(paramCanvas, this.jdField_c_of_type_AndroidGraphicsPaint);
    TransitionUtils.a(paramCanvas, getBounds(), this.jdField_e_of_type_AndroidGraphicsRectF.left, this.jdField_e_of_type_AndroidGraphicsRectF.top, this.jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformFitModeResult.jdField_b_of_type_Float, this.jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformFadeModeResult.b, new MaterialContainerTransform.TransitionDrawable.2(this));
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    if (this.jdField_e_of_type_AndroidGraphicsPaint.getAlpha() > 0) {
      paramCanvas.drawRect(getBounds(), this.jdField_e_of_type_AndroidGraphicsPaint);
    }
    int i;
    if (this.jdField_c_of_type_Boolean) {
      i = paramCanvas.save();
    } else {
      i = -1;
    }
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_f_of_type_Float > 0.0F)) {
      a(paramCanvas);
    }
    this.jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformMaskEvaluator.a(paramCanvas);
    a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint);
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformFadeModeResult.jdField_a_of_type_Boolean)
    {
      d(paramCanvas);
      e(paramCanvas);
    }
    else
    {
      e(paramCanvas);
      d(paramCanvas);
    }
    if (this.jdField_c_of_type_Boolean)
    {
      paramCanvas.restoreToCount(i);
      a(paramCanvas, this.jdField_c_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPath, -65281);
      a(paramCanvas, this.jdField_d_of_type_AndroidGraphicsRectF, -256);
      a(paramCanvas, this.jdField_c_of_type_AndroidGraphicsRectF, -16711936);
      a(paramCanvas, this.jdField_f_of_type_AndroidGraphicsRectF, -16711681);
      a(paramCanvas, this.jdField_e_of_type_AndroidGraphicsRectF, -16776961);
    }
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt)
  {
    throw new UnsupportedOperationException("Setting alpha on is not supported");
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter)
  {
    throw new UnsupportedOperationException("Setting a color filter is not supported");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.transition.platform.MaterialContainerTransform.TransitionDrawable
 * JD-Core Version:    0.7.0.1
 */