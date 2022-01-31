package com.tencent.mobileqq.arcard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.view.View;

public class ARCardLoadingProgressView
  extends View
{
  private float jdField_a_of_type_Float = 56.0F;
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  boolean jdField_a_of_type_Boolean = true;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  boolean jdField_b_of_type_Boolean = true;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private Paint jdField_c_of_type_AndroidGraphicsPaint;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int = 70;
  private float jdField_e_of_type_Float = 1.6875F;
  private int jdField_e_of_type_Int;
  
  public ARCardLoadingProgressView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  private void a()
  {
    this.jdField_b_of_type_Float = 56.0F;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_e_of_type_Float * 9.0F);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-1929379841);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_e_of_type_Float * 9.0F);
    this.jdField_c_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_c_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_c_of_type_AndroidGraphicsPaint.setTextSize(28.0F * this.jdField_e_of_type_Float);
    Paint.FontMetrics localFontMetrics = this.jdField_c_of_type_AndroidGraphicsPaint.getFontMetrics();
    this.jdField_d_of_type_Float = ((int)Math.ceil(localFontMetrics.descent - localFontMetrics.ascent));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_e_of_type_Int % 10 == 9) {
      this.jdField_b_of_type_Boolean = false;
    }
    if (this.jdField_e_of_type_Int % 10 == 0) {
      this.jdField_b_of_type_Boolean = true;
    }
    if (this.jdField_b_of_type_Boolean) {}
    for (this.jdField_e_of_type_Int += 1;; this.jdField_e_of_type_Int -= 1)
    {
      this.jdField_a_of_type_Int = (getWidth() / 2);
      this.jdField_b_of_type_Int = (getHeight() / 2);
      if (this.jdField_a_of_type_AndroidGraphicsRectF.left != this.jdField_a_of_type_Int - this.jdField_b_of_type_Float * this.jdField_e_of_type_Float)
      {
        this.jdField_a_of_type_AndroidGraphicsRectF.left = (this.jdField_a_of_type_Int - this.jdField_b_of_type_Float * this.jdField_e_of_type_Float);
        this.jdField_a_of_type_AndroidGraphicsRectF.top = (this.jdField_b_of_type_Int - this.jdField_b_of_type_Float * this.jdField_e_of_type_Float);
        this.jdField_a_of_type_AndroidGraphicsRectF.right = (this.jdField_a_of_type_Int + this.jdField_b_of_type_Float * this.jdField_e_of_type_Float);
        this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (this.jdField_b_of_type_Int + this.jdField_b_of_type_Float * this.jdField_e_of_type_Float);
      }
      if (this.jdField_b_of_type_AndroidGraphicsRectF.left != this.jdField_a_of_type_Int - this.jdField_b_of_type_Float * this.jdField_e_of_type_Float)
      {
        this.jdField_b_of_type_AndroidGraphicsRectF.left = (this.jdField_a_of_type_Int - this.jdField_b_of_type_Float * this.jdField_e_of_type_Float);
        this.jdField_b_of_type_AndroidGraphicsRectF.top = (this.jdField_b_of_type_Int - this.jdField_b_of_type_Float * this.jdField_e_of_type_Float);
        this.jdField_b_of_type_AndroidGraphicsRectF.right = (this.jdField_a_of_type_Int + this.jdField_b_of_type_Float * this.jdField_e_of_type_Float);
        this.jdField_b_of_type_AndroidGraphicsRectF.bottom = (this.jdField_b_of_type_Int + this.jdField_b_of_type_Float * this.jdField_e_of_type_Float);
      }
      this.jdField_d_of_type_Int += 10;
      paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_d_of_type_Int + 270, 135.0F, false, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawArc(this.jdField_b_of_type_AndroidGraphicsRectF, 0.0F, 360.0F, false, this.jdField_b_of_type_AndroidGraphicsPaint);
      if (this.jdField_c_of_type_Int > 99) {
        this.jdField_c_of_type_Int = 99;
      }
      String str = this.jdField_c_of_type_Int + "%";
      this.jdField_c_of_type_Float = this.jdField_c_of_type_AndroidGraphicsPaint.measureText(str, 0, str.length());
      paramCanvas.drawText(str, this.jdField_a_of_type_Int - this.jdField_c_of_type_Float / 2.0F, this.jdField_b_of_type_Int + this.jdField_d_of_type_Float / 4.0F, this.jdField_c_of_type_AndroidGraphicsPaint);
      postInvalidateDelayed(15L);
      return;
    }
  }
  
  public void setScale(int paramInt)
  {
    this.jdField_e_of_type_Float = (paramInt / 640.0F);
  }
  
  public void setShowProgress(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setTotalProgress(int paramInt)
  {
    if (paramInt > this.jdField_c_of_type_Int) {
      this.jdField_c_of_type_Int = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.arcard.ARCardLoadingProgressView
 * JD-Core Version:    0.7.0.1
 */