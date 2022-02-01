package com.tencent.common.danmaku.edit.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.common.danmaku.R.styleable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/common/danmaku/edit/views/RoundRelativeLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mFilter", "Landroid/graphics/PaintFlagsDrawFilter;", "mRect", "Landroid/graphics/RectF;", "mRoundLayoutRadius", "", "mRoundPath", "Landroid/graphics/Path;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "onLayout", "changed", "", "l", "", "t", "r", "b", "setRoundLayoutRadius", "roundLayoutRadius", "setRoundPath", "qqdanmaku_release"}, k=1, mv={1, 1, 16})
public class RoundRelativeLayout
  extends RelativeLayout
{
  private float a = 16.0F;
  private Path b = new Path();
  private RectF c = new RectF();
  private final PaintFlagsDrawFilter d = new PaintFlagsDrawFilter(0, 3);
  
  public RoundRelativeLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setWillNotDraw(false);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.L);
      this.a = paramContext.getDimensionPixelSize(R.styleable.M, 0);
      paramContext.recycle();
    }
  }
  
  private final void a()
  {
    this.b.reset();
    Path localPath = this.b;
    RectF localRectF = this.c;
    float f = this.a;
    localPath.addRoundRect(localRectF, f, f, Path.Direction.CW);
  }
  
  public void draw(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    if (this.a > 0.0F)
    {
      paramCanvas.setDrawFilter((DrawFilter)this.d);
      paramCanvas.clipPath(this.b);
    }
    super.draw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.c.set(0.0F, 0.0F, getWidth() - 1, getHeight() - 1);
    a();
  }
  
  public final void setRoundLayoutRadius(float paramFloat)
  {
    this.a = paramFloat;
    a();
    postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.edit.views.RoundRelativeLayout
 * JD-Core Version:    0.7.0.1
 */