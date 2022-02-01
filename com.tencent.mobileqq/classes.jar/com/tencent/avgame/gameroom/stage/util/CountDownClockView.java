package com.tencent.avgame.gameroom.stage.util;

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

public class CountDownClockView
  extends ImageView
  implements IBaseCountDownClockView
{
  private static final String jdField_a_of_type_JavaLangString = "com.tencent.avgame.gameroom.stage.util.CountDownClockView";
  private int jdField_a_of_type_Int;
  ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private IBaseCountDownClockView.OnCountDownListener jdField_a_of_type_ComTencentAvgameGameroomStageUtilIBaseCountDownClockView$OnCountDownListener;
  private int jdField_b_of_type_Int;
  private Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint();
  private RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private int jdField_c_of_type_Int = 0;
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
    setBackgroundResource(2130838653);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-1831);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_b_of_type_AndroidGraphicsPaint.setFlags(1);
  }
  
  private void a(Canvas paramCanvas)
  {
    paramCanvas.translate(this.jdField_a_of_type_Int * 0.5F, this.jdField_b_of_type_Int * 0.5625F);
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
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    double d1 = paramLong2 * 360L;
    Double.isNaN(d1);
    double d2 = paramLong1;
    Double.isNaN(d2);
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { (int)(d1 * 1.0D / d2), 360 }).setDuration(paramLong1 - paramLong2);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new CountDownClockView.1(this));
    ValueAnimatorUtil.a();
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
    paramInt3 = this.jdField_a_of_type_Int;
    if ((paramInt3 == 0) || (paramInt3 != paramInt1))
    {
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt2;
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
      float f1 = this.jdField_a_of_type_Int * 0.025F;
      Object localObject = this.jdField_a_of_type_AndroidGraphicsPath;
      float f2 = -f1;
      ((Path)localObject).moveTo(f2, 0.0F);
      this.jdField_b_of_type_AndroidGraphicsRectF.set(f2, f2, f1, f1);
      this.jdField_a_of_type_AndroidGraphicsPath.addArc(this.jdField_b_of_type_AndroidGraphicsRectF, 180.0F, -180.0F);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(f1, this.jdField_a_of_type_Int * -0.1625F);
      localObject = this.jdField_c_of_type_AndroidGraphicsRectF;
      paramInt1 = this.jdField_a_of_type_Int;
      ((RectF)localObject).set(f2, paramInt1 * -0.1875F, f1, paramInt1 * -0.1375F);
      this.jdField_a_of_type_AndroidGraphicsPath.addArc(this.jdField_c_of_type_AndroidGraphicsRectF, 0.0F, -180.0F);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(f2, 0.0F);
      f1 = this.jdField_a_of_type_Int * 0.1875F;
      localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
      f2 = -f1;
      ((RectF)localObject).set(f2, f2, f1, f1);
    }
  }
  
  public void setOnTimeEndListener(IBaseCountDownClockView.OnCountDownListener paramOnCountDownListener)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomStageUtilIBaseCountDownClockView$OnCountDownListener = paramOnCountDownListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.util.CountDownClockView
 * JD-Core Version:    0.7.0.1
 */