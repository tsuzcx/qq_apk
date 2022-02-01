package com.tencent.avgame.gameroom.stage;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import nku;

public class CountDownClockView
  extends ImageView
{
  private int jdField_a_of_type_Int;
  ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private int jdField_b_of_type_Int;
  private Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint();
  private RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private int jdField_c_of_type_Int;
  private RectF jdField_c_of_type_AndroidGraphicsRectF = new RectF();
  private final int d = -90;
  private final int e = 360;
  
  public CountDownClockView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public CountDownClockView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public CountDownClockView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-469632);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setFlags(1);
    setBackgroundResource(2130838740);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-1831);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_b_of_type_AndroidGraphicsPaint.setFlags(1);
  }
  
  private void a(Canvas paramCanvas)
  {
    paramCanvas.translate(0.5F * this.jdField_a_of_type_Int, 0.5625F * this.jdField_b_of_type_Int);
    paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, -90.0F, this.jdField_c_of_type_Int, true, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  private void b(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.rotate(this.jdField_c_of_type_Int);
    c(paramCanvas);
    paramCanvas.restore();
  }
  
  private void c(Canvas paramCanvas)
  {
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_b_of_type_AndroidGraphicsPaint);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (paramLong2 > paramLong1) {
      return;
    }
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { (int)(360L * paramLong2 * 1.0D / paramLong1), 360 }).setDuration(paramLong1 - paramLong2);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new nku(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    paramCanvas.save();
    a(paramCanvas);
    c(paramCanvas);
    b(paramCanvas);
    paramCanvas.restore();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int != paramInt1))
    {
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt2;
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
      float f = 0.025F * this.jdField_a_of_type_Int;
      this.jdField_a_of_type_AndroidGraphicsPath.moveTo(-f, 0.0F);
      this.jdField_b_of_type_AndroidGraphicsRectF.set(-f, -f, f, f);
      this.jdField_a_of_type_AndroidGraphicsPath.addArc(this.jdField_b_of_type_AndroidGraphicsRectF, 180.0F, -180.0F);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(f, -0.1625F * this.jdField_a_of_type_Int);
      this.jdField_c_of_type_AndroidGraphicsRectF.set(-f, -0.1875F * this.jdField_a_of_type_Int, f, -0.1375F * this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsPath.addArc(this.jdField_c_of_type_AndroidGraphicsRectF, 0.0F, -180.0F);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(-f, 0.0F);
      f = 0.1875F * this.jdField_a_of_type_Int;
      this.jdField_a_of_type_AndroidGraphicsRectF.set(-f, -f, f, f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.CountDownClockView
 * JD-Core Version:    0.7.0.1
 */