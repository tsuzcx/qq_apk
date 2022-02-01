package com.tencent.mm.plugin.appbrand.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.MainThread;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandCircleProgressView;", "Landroid/view/View;", "ctx", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "angle", "", "animDuration", "", "getAnimDuration", "()J", "setAnimDuration", "(J)V", "animator", "Landroid/animation/ValueAnimator;", "getAnimator", "()Landroid/animation/ValueAnimator;", "animator$delegate", "Lkotlin/Lazy;", "<set-?>", "", "circleColor", "getCircleColor", "()I", "setCircleColor", "(I)V", "circleColor$delegate", "Lkotlin/properties/ReadWriteProperty;", "circlePaint", "Landroid/graphics/Paint;", "getCirclePaint", "()Landroid/graphics/Paint;", "circlePaint$delegate", "circleStrokeWidth", "getCircleStrokeWidth", "()F", "setCircleStrokeWidth", "(F)V", "circleStrokeWidth$delegate", "currentPlayTime", "dotColor", "getDotColor", "setDotColor", "dotColor$delegate", "dotPaint", "getDotPaint", "dotPaint$delegate", "dotWidth", "getDotWidth", "setDotWidth", "dotWidth$delegate", "pointX", "pointY", "processToDraw", "value", "progress", "getProgress", "setProgress", "progressColor", "getProgressColor", "setProgressColor", "progressColor$delegate", "progressPaint", "getProgressPaint", "progressPaint$delegate", "progressWidth", "getProgressWidth", "setProgressWidth", "progressWidth$delegate", "radius", "getRadius", "step", "transitionTimingMs", "getTransitionTimingMs", "setTransitionTimingMs", "onDetachedFromWindow", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "promote", "startAnim", "stopAnim", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class AppBrandCircleProgressView
  extends View
{
  public static final AppBrandCircleProgressView.g b = new AppBrandCircleProgressView.g(null);
  private int c = 2000;
  private long d = 1500L;
  private int e;
  @NotNull
  private final ReadWriteProperty f;
  @NotNull
  private final ReadWriteProperty g;
  @NotNull
  private final ReadWriteProperty h;
  @NotNull
  private final ReadWriteProperty i;
  @NotNull
  private final ReadWriteProperty j;
  @NotNull
  private final ReadWriteProperty k;
  private final Lazy l;
  private final Lazy m;
  private final Lazy n;
  private final Lazy o;
  private long p;
  private float q;
  private float r;
  private float s;
  private int t;
  private float u;
  
  public AppBrandCircleProgressView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = Delegates.INSTANCE;
    paramContext = Integer.valueOf(-7829368);
    this.f = ((ReadWriteProperty)new AppBrandCircleProgressView.a(paramContext, paramContext, this));
    paramAttributeSet = Delegates.INSTANCE;
    this.g = ((ReadWriteProperty)new AppBrandCircleProgressView.b(paramContext, paramContext, this));
    paramContext = Delegates.INSTANCE;
    paramContext = Integer.valueOf(-16711936);
    this.h = ((ReadWriteProperty)new AppBrandCircleProgressView.c(paramContext, paramContext, this));
    paramContext = Delegates.INSTANCE;
    paramContext = Float.valueOf(1.0F);
    this.i = ((ReadWriteProperty)new AppBrandCircleProgressView.d(paramContext, paramContext, this));
    paramAttributeSet = Delegates.INSTANCE;
    this.j = ((ReadWriteProperty)new AppBrandCircleProgressView.e(paramContext, paramContext, this));
    paramContext = Delegates.INSTANCE;
    paramContext = Float.valueOf(3.0F);
    this.k = ((ReadWriteProperty)new AppBrandCircleProgressView.f(paramContext, paramContext, this));
    this.l = LazyKt.lazy((Function0)new AppBrandCircleProgressView.h(this));
    this.m = LazyKt.lazy((Function0)new AppBrandCircleProgressView.i(this));
    this.n = LazyKt.lazy((Function0)new AppBrandCircleProgressView.j(this));
    this.o = LazyKt.lazy((Function0)new AppBrandCircleProgressView.k(this));
    this.t = 1;
    this.u = this.e;
  }
  
  private final void c()
  {
    getAnimator().cancel();
  }
  
  private final ValueAnimator getAnimator()
  {
    return (ValueAnimator)this.l.getValue();
  }
  
  private final Paint getCirclePaint()
  {
    return (Paint)this.m.getValue();
  }
  
  private final Paint getDotPaint()
  {
    return (Paint)this.n.getValue();
  }
  
  private final Paint getProgressPaint()
  {
    return (Paint)this.o.getValue();
  }
  
  private final float getRadius()
  {
    if (isLaidOut())
    {
      float f1 = getMeasuredHeight();
      float f2 = 2;
      return Math.min(f1 - Math.max(getProgressWidth(), getDotWidth()) * f2, getMeasuredWidth() - f2 * Math.max(getProgressWidth(), getDotWidth())) / 2.0F;
    }
    return 0.0F;
  }
  
  @MainThread
  public final void a()
  {
    this.p = 0L;
    getAnimator().addUpdateListener((ValueAnimator.AnimatorUpdateListener)new AppBrandCircleProgressView.l(this));
    getAnimator().start();
  }
  
  public final void b()
  {
    this.c = 0;
    getAnimator().setDuration(1000L);
    this.t = 5;
  }
  
  public final long getAnimDuration()
  {
    return this.d;
  }
  
  public final int getCircleColor()
  {
    return ((Number)this.f.getValue(this, a[0])).intValue();
  }
  
  public final float getCircleStrokeWidth()
  {
    return ((Number)this.i.getValue(this, a[3])).floatValue();
  }
  
  public final int getDotColor()
  {
    return ((Number)this.g.getValue(this, a[1])).intValue();
  }
  
  public final float getDotWidth()
  {
    return ((Number)this.j.getValue(this, a[4])).floatValue();
  }
  
  public final int getProgress()
  {
    return this.e;
  }
  
  public final int getProgressColor()
  {
    return ((Number)this.h.getValue(this, a[2])).intValue();
  }
  
  public final float getProgressWidth()
  {
    return ((Number)this.k.getValue(this, a[5])).floatValue();
  }
  
  public final int getTransitionTimingMs()
  {
    return this.c;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    c();
  }
  
  protected void onDraw(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    if (this.q != 0.0F)
    {
      if (this.r == 0.0F) {
        return;
      }
      float f4 = getMeasuredWidth();
      float f1 = getMeasuredHeight();
      paramCanvas.drawCircle(f4 / 2.0F, f1 / 2.0F, getRadius(), getCirclePaint());
      if (this.p <= this.c)
      {
        paramCanvas.drawCircle(this.q + getRadius() + Math.max(getProgressWidth(), getDotWidth()), this.r + getRadius() + Math.max(getProgressWidth(), getDotWidth()), getDotWidth(), getDotPaint());
        return;
      }
      float f2 = this.u;
      if (f2 < this.e) {
        this.u = (f2 + this.t);
      } else if (f2 <= 80) {
        this.u = (f2 + 0.5F);
      }
      f2 = this.u * 360 / 100.0F;
      float f3 = 2;
      f4 /= f3;
      float f5 = getRadius();
      f1 /= f3;
      paramCanvas.drawArc(f4 - f5, f1 - getRadius(), getRadius() + f4, getRadius() + f1, this.s, f2, false, getProgressPaint());
      if (this.u >= 100) {
        c();
      }
    }
  }
  
  public final void setAnimDuration(long paramLong)
  {
    this.d = paramLong;
  }
  
  public final void setCircleColor(int paramInt)
  {
    this.f.setValue(this, a[0], Integer.valueOf(paramInt));
  }
  
  public final void setCircleStrokeWidth(float paramFloat)
  {
    this.i.setValue(this, a[3], Float.valueOf(paramFloat));
  }
  
  public final void setDotColor(int paramInt)
  {
    this.g.setValue(this, a[1], Integer.valueOf(paramInt));
  }
  
  public final void setDotWidth(float paramFloat)
  {
    this.j.setValue(this, a[4], Float.valueOf(paramFloat));
  }
  
  public final void setProgress(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("progress = [%d]");
    localStringBuilder.append(paramInt);
    o.d("AppBrandCircleProgressView", localStringBuilder.toString());
    this.e = paramInt;
  }
  
  public final void setProgressColor(int paramInt)
  {
    this.h.setValue(this, a[2], Integer.valueOf(paramInt));
  }
  
  public final void setProgressWidth(float paramFloat)
  {
    this.k.setValue(this, a[5], Float.valueOf(paramFloat));
  }
  
  public final void setTransitionTimingMs(int paramInt)
  {
    this.c = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandCircleProgressView
 * JD-Core Version:    0.7.0.1
 */