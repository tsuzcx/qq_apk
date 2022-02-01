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
  private static final int[] jdField_a_of_type_ArrayOfInt = new int[9];
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private Paint b;
  
  static
  {
    jdField_a_of_type_ArrayOfInt[0] = Color.parseColor("#B380CF");
    jdField_a_of_type_ArrayOfInt[1] = Color.parseColor("#FD86A2");
    jdField_a_of_type_ArrayOfInt[2] = Color.parseColor("#F78A92");
    jdField_a_of_type_ArrayOfInt[3] = Color.parseColor("#FB785A");
    jdField_a_of_type_ArrayOfInt[4] = Color.parseColor("#FF904B");
    jdField_a_of_type_ArrayOfInt[5] = Color.parseColor("#F8BF72");
    jdField_a_of_type_ArrayOfInt[6] = Color.parseColor("#8190E0");
    jdField_a_of_type_ArrayOfInt[7] = Color.parseColor("#5F7EFB");
    jdField_a_of_type_ArrayOfInt[8] = Color.parseColor("#B380CF");
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
    if (this.b != null) {
      return;
    }
    this.b = new Paint();
    this.b.setAntiAlias(true);
    this.b.setStyle(Paint.Style.STROKE);
    this.b.setStrokeWidth(this.mStrokeWidth);
    SweepGradient localSweepGradient = new SweepGradient(this.jdField_a_of_type_AndroidGraphicsRectF.centerX(), this.jdField_a_of_type_AndroidGraphicsRectF.centerY(), jdField_a_of_type_ArrayOfInt, null);
    this.b.setShader(localSweepGradient);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    float f1 = QIMCircleProgress.MAX_PROGRESS * -0.005555556F;
    a();
    float f2 = (this.mProgress - f1) * 360.0F / QIMCircleProgress.MAX_PROGRESS - 4.0F;
    if (f2 > 0.0F) {
      paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, f1 * 360.0F / QIMCircleProgress.MAX_PROGRESS - 90.0F + 2.0F, f2, false, this.b);
    }
    if (this.mMode != 2) {
      drawCenterCircle(paramCanvas);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(this.mStrokeWidth + this.mProgressOffset, this.mStrokeWidth + this.mProgressOffset, paramInt1 - this.mStrokeWidth - this.mProgressOffset, paramInt2 - this.mStrokeWidth - this.mProgressOffset);
    this.mWidth = getWidth();
    this.mHeight = getHeight();
  }
  
  public void setStrokeWidth(float paramFloat)
  {
    super.setStrokeWidth(paramFloat);
    Paint localPaint = this.b;
    if (localPaint != null) {
      localPaint.setStrokeWidth(this.mStrokeWidth);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.view.AEAnimationQIMCircleProgress
 * JD-Core Version:    0.7.0.1
 */