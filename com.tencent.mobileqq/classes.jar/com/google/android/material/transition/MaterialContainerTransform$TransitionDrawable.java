package com.google.android.material.transition;

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
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import androidx.transition.PathMotion;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

final class MaterialContainerTransform$TransitionDrawable
  extends Drawable
{
  private final MaterialContainerTransform.ProgressThresholdsGroup A;
  private final FadeModeEvaluator B;
  private final FitModeEvaluator C;
  private final boolean D;
  private final Paint E = new Paint();
  private final Path F = new Path();
  private FadeModeResult G;
  private FitModeResult H;
  private RectF I;
  private float J;
  private float K;
  private float L;
  private final View a;
  private final RectF b;
  private final ShapeAppearanceModel c;
  private final float d;
  private final View e;
  private final RectF f;
  private final ShapeAppearanceModel g;
  private final float h;
  private final Paint i = new Paint();
  private final Paint j = new Paint();
  private final Paint k = new Paint();
  private final Paint l = new Paint();
  private final Paint m = new Paint();
  private final MaskEvaluator n = new MaskEvaluator();
  private final PathMeasure o;
  private final float p;
  private final float[] q = new float[2];
  private final boolean r;
  private final float s;
  private final float t;
  private final boolean u;
  private final MaterialShapeDrawable v = new MaterialShapeDrawable();
  private final RectF w;
  private final RectF x;
  private final RectF y;
  private final RectF z;
  
  private MaterialContainerTransform$TransitionDrawable(PathMotion paramPathMotion, View paramView1, RectF paramRectF1, ShapeAppearanceModel paramShapeAppearanceModel1, float paramFloat1, View paramView2, RectF paramRectF2, ShapeAppearanceModel paramShapeAppearanceModel2, float paramFloat2, @ColorInt int paramInt1, @ColorInt int paramInt2, @ColorInt int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, FadeModeEvaluator paramFadeModeEvaluator, FitModeEvaluator paramFitModeEvaluator, MaterialContainerTransform.ProgressThresholdsGroup paramProgressThresholdsGroup, boolean paramBoolean3)
  {
    this.a = paramView1;
    this.b = paramRectF1;
    this.c = paramShapeAppearanceModel1;
    this.d = paramFloat1;
    this.e = paramView2;
    this.f = paramRectF2;
    this.g = paramShapeAppearanceModel2;
    this.h = paramFloat2;
    this.r = paramBoolean1;
    this.u = paramBoolean2;
    this.B = paramFadeModeEvaluator;
    this.C = paramFitModeEvaluator;
    this.A = paramProgressThresholdsGroup;
    this.D = paramBoolean3;
    paramView1 = (WindowManager)paramView1.getContext().getSystemService("window");
    paramShapeAppearanceModel1 = new DisplayMetrics();
    paramView1.getDefaultDisplay().getMetrics(paramShapeAppearanceModel1);
    this.s = paramShapeAppearanceModel1.widthPixels;
    this.t = paramShapeAppearanceModel1.heightPixels;
    this.i.setColor(paramInt1);
    this.j.setColor(paramInt2);
    this.k.setColor(paramInt3);
    this.v.g(ColorStateList.valueOf(0));
    this.v.D(2);
    this.v.g(false);
    this.v.H(-7829368);
    this.w = new RectF(paramRectF1);
    this.x = new RectF(this.w);
    this.y = new RectF(this.w);
    this.z = new RectF(this.y);
    paramView1 = a(paramRectF1);
    paramShapeAppearanceModel1 = a(paramRectF2);
    this.o = new PathMeasure(paramPathMotion.getPath(paramView1.x, paramView1.y, paramShapeAppearanceModel1.x, paramShapeAppearanceModel1.y), false);
    this.p = this.o.getLength();
    this.q[0] = paramRectF1.centerX();
    this.q[1] = paramRectF1.top;
    this.m.setStyle(Paint.Style.FILL);
    this.m.setShader(TransitionUtils.a(paramInt4));
    this.E.setStyle(Paint.Style.STROKE);
    this.E.setStrokeWidth(10.0F);
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
    if (this.L != paramFloat) {
      b(paramFloat);
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.clipPath(this.n.a(), Region.Op.DIFFERENCE);
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
    this.E.setColor(paramInt);
    paramCanvas.drawRect(paramRectF, this.E);
  }
  
  private void a(Canvas paramCanvas, RectF paramRectF, Path paramPath, @ColorInt int paramInt)
  {
    paramRectF = a(paramRectF);
    if (this.L == 0.0F)
    {
      paramPath.reset();
      paramPath.moveTo(paramRectF.x, paramRectF.y);
      return;
    }
    paramPath.lineTo(paramRectF.x, paramRectF.y);
    this.E.setColor(paramInt);
    paramCanvas.drawPath(paramPath, this.E);
  }
  
  private static float b(RectF paramRectF, float paramFloat)
  {
    return paramRectF.centerY() / paramFloat * 1.5F;
  }
  
  private void b(float paramFloat)
  {
    this.L = paramFloat;
    Object localObject = this.m;
    if (this.r) {
      f1 = TransitionUtils.a(0.0F, 255.0F, paramFloat);
    } else {
      f1 = TransitionUtils.a(255.0F, 0.0F, paramFloat);
    }
    ((Paint)localObject).setAlpha((int)f1);
    this.o.getPosTan(this.p * paramFloat, this.q, null);
    localObject = this.q;
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
      this.o.getPosTan(this.p * f2, this.q, null);
      localObject = this.q;
      f2 = localObject[0];
      float f5 = localObject[1];
      f2 = f4 + (f4 - f2) * f1;
      f1 = f3 + (f3 - f5) * f1;
    }
    f3 = ((Float)Preconditions.checkNotNull(Float.valueOf(MaterialContainerTransform.ProgressThresholds.a(MaterialContainerTransform.ProgressThresholdsGroup.b(this.A))))).floatValue();
    f4 = ((Float)Preconditions.checkNotNull(Float.valueOf(MaterialContainerTransform.ProgressThresholds.b(MaterialContainerTransform.ProgressThresholdsGroup.b(this.A))))).floatValue();
    this.H = this.C.a(paramFloat, f3, f4, this.b.width(), this.b.height(), this.f.width(), this.f.height());
    this.w.set(f2 - this.H.c / 2.0F, f1, this.H.c / 2.0F + f2, this.H.d + f1);
    this.y.set(f2 - this.H.e / 2.0F, f1, f2 + this.H.e / 2.0F, this.H.f + f1);
    this.x.set(this.w);
    this.z.set(this.y);
    float f1 = ((Float)Preconditions.checkNotNull(Float.valueOf(MaterialContainerTransform.ProgressThresholds.a(MaterialContainerTransform.ProgressThresholdsGroup.c(this.A))))).floatValue();
    float f2 = ((Float)Preconditions.checkNotNull(Float.valueOf(MaterialContainerTransform.ProgressThresholds.b(MaterialContainerTransform.ProgressThresholdsGroup.c(this.A))))).floatValue();
    boolean bool = this.C.a(this.H);
    if (bool) {
      localObject = this.x;
    } else {
      localObject = this.z;
    }
    f1 = TransitionUtils.a(0.0F, 1.0F, f1, f2, paramFloat);
    if (!bool) {
      f1 = 1.0F - f1;
    }
    this.C.a((RectF)localObject, f1, this.H);
    this.I = new RectF(Math.min(this.x.left, this.z.left), Math.min(this.x.top, this.z.top), Math.max(this.x.right, this.z.right), Math.max(this.x.bottom, this.z.bottom));
    this.n.a(paramFloat, this.c, this.g, this.w, this.x, this.z, MaterialContainerTransform.ProgressThresholdsGroup.d(this.A));
    this.J = TransitionUtils.a(this.d, this.h, paramFloat);
    f3 = a(this.I, this.s);
    f1 = b(this.I, this.t);
    f2 = this.J;
    f3 = (int)(f3 * f2);
    this.K = ((int)(f1 * f2));
    this.l.setShadowLayer(f2, f3, this.K, 754974720);
    f1 = ((Float)Preconditions.checkNotNull(Float.valueOf(MaterialContainerTransform.ProgressThresholds.a(MaterialContainerTransform.ProgressThresholdsGroup.a(this.A))))).floatValue();
    f2 = ((Float)Preconditions.checkNotNull(Float.valueOf(MaterialContainerTransform.ProgressThresholds.b(MaterialContainerTransform.ProgressThresholdsGroup.a(this.A))))).floatValue();
    this.G = this.B.a(paramFloat, f1, f2);
    if (this.j.getColor() != 0) {
      this.j.setAlpha(this.G.a);
    }
    if (this.k.getColor() != 0) {
      this.k.setAlpha(this.G.b);
    }
    invalidateSelf();
  }
  
  private void b(Canvas paramCanvas)
  {
    ShapeAppearanceModel localShapeAppearanceModel = this.n.b();
    if (localShapeAppearanceModel.a(this.I))
    {
      float f1 = localShapeAppearanceModel.f().a(this.I);
      paramCanvas.drawRoundRect(this.I, f1, f1, this.l);
      return;
    }
    paramCanvas.drawPath(this.n.a(), this.l);
  }
  
  private void c(Canvas paramCanvas)
  {
    this.v.setBounds((int)this.I.left, (int)this.I.top, (int)this.I.right, (int)this.I.bottom);
    this.v.r(this.J);
    this.v.F((int)this.K);
    this.v.setShapeAppearanceModel(this.n.b());
    this.v.draw(paramCanvas);
  }
  
  private void d(Canvas paramCanvas)
  {
    a(paramCanvas, this.j);
    TransitionUtils.a(paramCanvas, getBounds(), this.w.left, this.w.top, this.H.a, this.G.a, new MaterialContainerTransform.TransitionDrawable.1(this));
  }
  
  private void e(Canvas paramCanvas)
  {
    a(paramCanvas, this.k);
    TransitionUtils.a(paramCanvas, getBounds(), this.y.left, this.y.top, this.H.b, this.G.b, new MaterialContainerTransform.TransitionDrawable.2(this));
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    if (this.m.getAlpha() > 0) {
      paramCanvas.drawRect(getBounds(), this.m);
    }
    int i1;
    if (this.D) {
      i1 = paramCanvas.save();
    } else {
      i1 = -1;
    }
    if ((this.u) && (this.J > 0.0F)) {
      a(paramCanvas);
    }
    this.n.a(paramCanvas);
    a(paramCanvas, this.i);
    if (this.G.c)
    {
      d(paramCanvas);
      e(paramCanvas);
    }
    else
    {
      e(paramCanvas);
      d(paramCanvas);
    }
    if (this.D)
    {
      paramCanvas.restoreToCount(i1);
      a(paramCanvas, this.w, this.F, -65281);
      a(paramCanvas, this.x, -256);
      a(paramCanvas, this.w, -16711936);
      a(paramCanvas, this.z, -16711681);
      a(paramCanvas, this.y, -16776961);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.transition.MaterialContainerTransform.TransitionDrawable
 * JD-Core Version:    0.7.0.1
 */