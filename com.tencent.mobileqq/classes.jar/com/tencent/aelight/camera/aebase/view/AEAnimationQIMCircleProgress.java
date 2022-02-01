package com.tencent.aelight.camera.aebase.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import com.tencent.widget.QIMCircleProgress;

class AEAnimationQIMCircleProgress
  extends AnimationQIMCircleProgress
{
  private static final int[] d = new int[9];
  private RectF b;
  private Paint c;
  
  static
  {
    d[0] = Color.parseColor("#B380CF");
    d[1] = Color.parseColor("#FD86A2");
    d[2] = Color.parseColor("#F78A92");
    d[3] = Color.parseColor("#FB785A");
    d[4] = Color.parseColor("#FF904B");
    d[5] = Color.parseColor("#F8BF72");
    d[6] = Color.parseColor("#8190E0");
    d[7] = Color.parseColor("#5F7EFB");
    d[8] = Color.parseColor("#B380CF");
  }
  
  public AEAnimationQIMCircleProgress(Context paramContext)
  {
    super(paramContext);
  }
  
  public AEAnimationQIMCircleProgress(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a()
  {
    if (this.c != null) {
      return;
    }
    this.c = new Paint();
    this.c.setAntiAlias(true);
    this.c.setStyle(Paint.Style.STROKE);
    this.c.setStrokeWidth(this.mStrokeWidth);
    SweepGradient localSweepGradient = new SweepGradient(this.b.centerX(), this.b.centerY(), d, null);
    this.c.setShader(localSweepGradient);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    float f1 = QIMCircleProgress.MAX_PROGRESS * -0.005555556F;
    a();
    float f2 = (this.mProgress - f1) * 360.0F / QIMCircleProgress.MAX_PROGRESS - 4.0F;
    if (f2 > 0.0F) {
      paramCanvas.drawArc(this.b, f1 * 360.0F / QIMCircleProgress.MAX_PROGRESS - 90.0F + 2.0F, f2, false, this.c);
    }
    if (this.mMode != 2) {
      drawCenterCircle(paramCanvas);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.b = new RectF(this.mStrokeWidth + this.mProgressOffset, this.mStrokeWidth + this.mProgressOffset, paramInt1 - this.mStrokeWidth - this.mProgressOffset, paramInt2 - this.mStrokeWidth - this.mProgressOffset);
    this.mWidth = getWidth();
    this.mHeight = getHeight();
  }
  
  public void setStrokeWidth(float paramFloat)
  {
    super.setStrokeWidth(paramFloat);
    Paint localPaint = this.c;
    if (localPaint != null) {
      localPaint.setStrokeWidth(this.mStrokeWidth);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.view.AEAnimationQIMCircleProgress
 * JD-Core Version:    0.7.0.1
 */