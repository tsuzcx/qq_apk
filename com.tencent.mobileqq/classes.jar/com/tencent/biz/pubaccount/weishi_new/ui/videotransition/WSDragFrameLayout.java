package com.tencent.biz.pubaccount.weishi_new.ui.videotransition;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.Window;
import android.widget.FrameLayout;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/ui/videotransition/WSDragFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "clipHeight", "clipTop", "downPoint", "Landroid/graphics/PointF;", "downTime", "", "draggingType", "isDragging", "", "isEnableDragHorizontal", "()Z", "setEnableDragHorizontal", "(Z)V", "isEnableDragVertical", "setEnableDragVertical", "isFeatureEnable", "setFeatureEnable", "lastPoint", "onDragListener", "Lcom/tencent/biz/pubaccount/weishi_new/ui/videotransition/WSDragFrameLayout$OnDragListener;", "getOnDragListener", "()Lcom/tencent/biz/pubaccount/weishi_new/ui/videotransition/WSDragFrameLayout$OnDragListener;", "setOnDragListener", "(Lcom/tencent/biz/pubaccount/weishi_new/ui/videotransition/WSDragFrameLayout$OnDragListener;)V", "startDragPoint", "touchSlop", "windowBgDrawable", "Landroid/graphics/drawable/ColorDrawable;", "getWindowBgDrawable", "()Landroid/graphics/drawable/ColorDrawable;", "windowBgDrawable$delegate", "Lkotlin/Lazy;", "animToRecover", "", "startX", "", "startY", "startScale", "getDragType", "deltaX", "deltaY", "getScaleFactor", "deltaXDown", "deltaYDown", "widthAfterFactor", "heightAfterFactor", "init", "isFastDrag", "upX", "upY", "deltaTime", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "setClipVertical", "setScale", "scale", "width", "height", "setTranslation", "setWindowBgAlpha", "factor", "Companion", "OnDragListener", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSDragFrameLayout
  extends FrameLayout
{
  public static final WSDragFrameLayout.Companion a = new WSDragFrameLayout.Companion(null);
  private boolean b;
  private boolean c = true;
  private boolean d = true;
  @Nullable
  private WSDragFrameLayout.OnDragListener e;
  private final Lazy f = LazyKt.lazy((Function0)WSDragFrameLayout.windowBgDrawable.2.INSTANCE);
  private PointF g = new PointF();
  private PointF h = new PointF();
  private PointF i = new PointF();
  private boolean j;
  private int k;
  private int l;
  private long m;
  private int n;
  private int o;
  
  public WSDragFrameLayout(@NotNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WSDragFrameLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WSDragFrameLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private final float a(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        paramFloat1 = 1.0F;
      } else {
        paramFloat1 = 1.0F - paramFloat2 / paramFloat4;
      }
    }
    else {
      paramFloat1 = 1.0F - paramFloat1 / paramFloat3;
    }
    if (paramFloat1 - 0.5F < 1.E-015D) {
      return 0.5F;
    }
    paramFloat2 = paramFloat1;
    if (paramFloat1 - 1.0F > 1.E-015D) {
      paramFloat2 = 1.0F;
    }
    return paramFloat2;
  }
  
  private final int a(float paramFloat1, float paramFloat2)
  {
    int i1;
    if (Math.abs(paramFloat1) > Math.abs(paramFloat2)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((i1 != 0) && (this.c) && (paramFloat1 > this.k)) {
      return 1;
    }
    if ((i1 == 0) && (this.d) && (paramFloat2 > this.k)) {
      return 2;
    }
    return 0;
  }
  
  private final void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    ValueAnimator localValueAnimator = ObjectAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new WSDragFrameLayout.animToRecover..inlined.apply.lambda.1(this, paramFloat1, paramFloat2, paramFloat3));
    localValueAnimator.setDuration(200L);
    localValueAnimator.start();
  }
  
  private final boolean a(PointF paramPointF, float paramFloat1, float paramFloat2, long paramLong)
  {
    float f3 = paramPointF.x;
    float f1 = paramPointF.y;
    float f2 = (float)paramLong / 1000.0F;
    paramFloat1 = (paramFloat1 - f3) / f2;
    f3 = 500;
    return (paramFloat1 > f3) || ((paramFloat2 - f1) / f2 > f3);
  }
  
  private final void b()
  {
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    Intrinsics.checkExpressionValueIsNotNull(localViewConfiguration, "ViewConfiguration.get(context)");
    this.k = localViewConfiguration.getScaledTouchSlop();
    setWillNotDraw(false);
  }
  
  private final void b(float paramFloat1, float paramFloat2)
  {
    setTranslationX(getTranslationX() + paramFloat1);
    setTranslationY(getTranslationY() + paramFloat2);
  }
  
  private final void b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = 2;
    setPivotX(paramFloat2 / f1);
    setPivotY(paramFloat3 / f1);
    setScaleX(paramFloat1);
    setScaleY(paramFloat1);
  }
  
  private final ColorDrawable getWindowBgDrawable()
  {
    return (ColorDrawable)this.f.getValue();
  }
  
  private final void setWindowBgAlpha(float paramFloat)
  {
    int i1 = 255;
    int i2 = (int)(paramFloat * 0.5F * 'ÿ');
    if (i2 < 0) {
      i1 = 0;
    } else if (i2 <= 255) {
      i1 = i2;
    }
    getWindowBgDrawable().setAlpha(i1);
    Context localContext = getContext();
    if (localContext != null)
    {
      ((Activity)localContext).getWindow().setBackgroundDrawable((Drawable)getWindowBgDrawable());
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
  }
  
  public final boolean a()
  {
    return this.b;
  }
  
  @Nullable
  public final WSDragFrameLayout.OnDragListener getOnDragListener()
  {
    return this.e;
  }
  
  protected void onDraw(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    if (this.o > 0) {
      paramCanvas.clipRect(0, this.n, paramCanvas.getWidth(), this.n + this.o);
    }
  }
  
  public boolean onInterceptTouchEvent(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "ev");
    if (!this.b) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if (i1 == 2)
      {
        this.l = a(paramMotionEvent.getRawX() - this.g.x, paramMotionEvent.getRawY() - this.g.y);
        if (!this.j)
        {
          i1 = this.l;
          if ((i1 != 1) && (i1 != 2)) {}
        }
        else
        {
          WSDragFrameLayout.OnDragListener localOnDragListener = this.e;
          if (localOnDragListener != null) {
            localOnDragListener.a();
          }
          this.j = true;
          this.h.set(paramMotionEvent.getRawX(), paramMotionEvent.getRawY());
          this.i.set(paramMotionEvent.getRawX(), paramMotionEvent.getRawY());
          return true;
        }
      }
    }
    else
    {
      this.m = System.currentTimeMillis();
      this.g.set(paramMotionEvent.getRawX(), paramMotionEvent.getRawY());
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "ev");
    if (!this.b) {
      return super.onTouchEvent(paramMotionEvent);
    }
    int i1 = paramMotionEvent.getAction();
    if (i1 != 1) {
      if (i1 != 2)
      {
        if (i1 != 3) {
          break label280;
        }
      }
      else
      {
        float f1 = paramMotionEvent.getRawX();
        float f2 = paramMotionEvent.getRawY();
        float f3 = this.h.x;
        float f4 = this.h.y;
        this.h.set(f1, f2);
        float f5 = a(this.l, f1 - this.i.x, f2 - this.i.y, getWidth() * 1.8F, getHeight() * 1.8F);
        b(f5, getWidth(), getHeight());
        b(f1 - f3, f2 - f4);
        setWindowBgAlpha(f5);
        break label280;
      }
    }
    this.j = false;
    this.l = 0;
    WSDragFrameLayout.OnDragListener localOnDragListener;
    if ((getScaleX() - 0.9F >= 1.0E-006D) && (!a(this.g, paramMotionEvent.getRawX(), paramMotionEvent.getRawY(), System.currentTimeMillis() - this.m)))
    {
      localOnDragListener = this.e;
      if (localOnDragListener != null) {
        localOnDragListener.a(false);
      }
      a(getTranslationX(), getTranslationY(), getScaleX());
    }
    else
    {
      localOnDragListener = this.e;
      if (localOnDragListener != null) {
        localOnDragListener.a(true);
      }
    }
    label280:
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public final void setClipVertical(int paramInt1, int paramInt2)
  {
    this.n = paramInt1;
    this.o = paramInt2;
  }
  
  public final void setEnableDragHorizontal(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public final void setEnableDragVertical(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public final void setFeatureEnable(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public final void setOnDragListener(@Nullable WSDragFrameLayout.OnDragListener paramOnDragListener)
  {
    this.e = paramOnDragListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.ui.videotransition.WSDragFrameLayout
 * JD-Core Version:    0.7.0.1
 */