package com.tencent.android.gldrawable.api.base;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.Gravity;
import com.tencent.android.gldrawable.api.IGLDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/android/gldrawable/api/base/ScaleTypeDrawable;", "Lcom/tencent/android/gldrawable/api/IGLDrawable;", "()V", "clipArea", "Landroid/graphics/RectF;", "drawRect", "Landroid/graphics/Rect;", "forceLockWH", "", "viewRect", "calculateClipArea", "dstBounds", "calculateLockWH", "width", "", "height", "draw", "", "canvas", "Landroid/graphics/Canvas;", "onDraw", "left", "top", "right", "bottom", "setDrawArea", "x0", "", "y0", "x1", "y1", "setLockWH", "b", "api_release"}, k=1, mv={1, 1, 16})
public abstract class ScaleTypeDrawable
  extends IGLDrawable
{
  private RectF clipArea;
  private final Rect drawRect = new Rect();
  private boolean forceLockWH;
  private final Rect viewRect = new Rect();
  
  @NotNull
  public final Rect calculateClipArea(@NotNull Rect paramRect)
  {
    Intrinsics.checkParameterIsNotNull(paramRect, "dstBounds");
    RectF localRectF = this.clipArea;
    if (localRectF != null)
    {
      float f2 = localRectF.width();
      float f1 = localRectF.height();
      f2 = paramRect.width() / f2;
      f1 = paramRect.height() / f1;
      this.drawRect.left = ((int)(paramRect.left - localRectF.left * f2));
      this.drawRect.right = ((int)(paramRect.right + f2 * (1.0F - localRectF.right)));
      this.drawRect.top = ((int)(paramRect.top - localRectF.top * f1));
      this.drawRect.bottom = ((int)(paramRect.bottom + f1 * (1.0F - localRectF.bottom)));
    }
    return this.drawRect;
  }
  
  @NotNull
  public final Rect calculateLockWH(int paramInt1, int paramInt2, @NotNull Rect paramRect)
  {
    Intrinsics.checkParameterIsNotNull(paramRect, "dstBounds");
    this.drawRect.set(0, 0, paramInt1, paramInt2);
    float f1 = paramRect.width() / this.drawRect.width();
    float f2 = paramRect.height() / this.drawRect.height();
    Rect localRect;
    if (f1 > f2)
    {
      this.drawRect.right = paramRect.width();
      localRect = this.drawRect;
      localRect.bottom = ((int)(localRect.bottom * f1));
    }
    else
    {
      this.drawRect.bottom = paramRect.height();
      localRect = this.drawRect;
      localRect.right = ((int)(localRect.right * f2));
    }
    Gravity.apply(17, this.drawRect.width(), this.drawRect.height(), paramRect, this.drawRect);
    return this.drawRect;
  }
  
  public final void draw(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    Rect localRect = getBounds();
    Intrinsics.checkExpressionValueIsNotNull(localRect, "bounds");
    if (localRect.isEmpty()) {
      this.viewRect.set(0, 0, paramCanvas.getWidth(), paramCanvas.getHeight());
    } else {
      this.viewRect.set(localRect);
    }
    if (this.viewRect.isEmpty()) {
      return;
    }
    if ((getIntrinsicHeight() > 0) && (getIntrinsicWidth() > 0))
    {
      if (this.forceLockWH)
      {
        localRect = calculateLockWH(getIntrinsicWidth(), getIntrinsicHeight(), this.viewRect);
        onDraw(paramCanvas, localRect.left, localRect.top, localRect.right, localRect.bottom);
        return;
      }
      if (this.clipArea != null)
      {
        localRect = calculateClipArea(this.viewRect);
        onDraw(paramCanvas, localRect.left, localRect.top, localRect.right, localRect.bottom);
        return;
      }
      onDraw(paramCanvas, this.viewRect.left, this.viewRect.top, this.viewRect.right, this.viewRect.bottom);
      return;
    }
    onDraw(paramCanvas, this.viewRect.left, this.viewRect.top, this.viewRect.right, this.viewRect.bottom);
  }
  
  public abstract void onDraw(@NotNull Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public final void setDrawArea(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if ((paramFloat1 < 0.0F) || (paramFloat2 < 0.0F) || (paramFloat3 < 0.0F) || (paramFloat4 < 0.0F) || (paramFloat1 > 1.0F) || (paramFloat2 > 1.0F) || (paramFloat3 > 1.0F) || (paramFloat4 > 1.0F)) {
      this.clipArea = ((RectF)null);
    }
    this.clipArea = new RectF(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public final void setLockWH(boolean paramBoolean)
  {
    this.forceLockWH = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.android.gldrawable.api.base.ScaleTypeDrawable
 * JD-Core Version:    0.7.0.1
 */