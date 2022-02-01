package com.tencent.aelight.camera.aeeditor.view.videotrack;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class RoundFrameLayout
  extends FrameLayout
{
  private Path a = new Path();
  private RectF b = new RectF();
  private int c = 0;
  
  public RoundFrameLayout(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public RoundFrameLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RoundFrameLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.a.reset();
    this.b.set(0.0F, 0.0F, paramInt1, paramInt2);
    Path localPath = this.a;
    RectF localRectF = this.b;
    paramInt1 = this.c;
    localPath.addRoundRect(localRectF, paramInt1, paramInt1, Path.Direction.CW);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.clipPath(this.a);
    super.dispatchDraw(paramCanvas);
    paramCanvas.restore();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    a(paramInt1, paramInt2);
  }
  
  public void setRadius(int paramInt)
  {
    this.c = paramInt;
    a(getWidth(), getHeight());
    postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.videotrack.RoundFrameLayout
 * JD-Core Version:    0.7.0.1
 */