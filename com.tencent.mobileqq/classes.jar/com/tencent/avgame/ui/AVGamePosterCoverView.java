package com.tencent.avgame.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;

public class AVGamePosterCoverView
  extends AsyncImageView
{
  private int jdField_a_of_type_Int = 16;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private int b = this.jdField_a_of_type_Int << 1;
  
  public AVGamePosterCoverView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public AVGamePosterCoverView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
  }
  
  private void b(Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsPath.moveTo(0.0F, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(0.0F, 0.0F);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_a_of_type_Int, 0.0F);
    this.jdField_a_of_type_AndroidGraphicsPath.arcTo(new RectF(0.0F, 0.0F, this.b, this.b), -90.0F, -90.0F);
    this.jdField_a_of_type_AndroidGraphicsPath.close();
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  private void c(Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsPath.moveTo(getWidth(), this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(getWidth(), 0.0F);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(getWidth() - this.jdField_a_of_type_Int, 0.0F);
    this.jdField_a_of_type_AndroidGraphicsPath.arcTo(new RectF(getWidth() - this.b, 0.0F, getWidth(), this.b), -90.0F, 90.0F);
    this.jdField_a_of_type_AndroidGraphicsPath.close();
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  private void d(Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsPath.moveTo(0.0F, getHeight() - this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(0.0F, getHeight());
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_a_of_type_Int, getHeight());
    this.jdField_a_of_type_AndroidGraphicsPath.arcTo(new RectF(0.0F, getHeight() - this.b, this.b, getHeight()), 90.0F, 90.0F);
    this.jdField_a_of_type_AndroidGraphicsPath.close();
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  private void e(Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsPath.moveTo(getWidth() - this.jdField_a_of_type_Int, getHeight());
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(getWidth(), getHeight());
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(getWidth(), getHeight() - this.jdField_a_of_type_Int);
    RectF localRectF = new RectF(getWidth() - this.b, getHeight() - this.b, getWidth(), getHeight());
    this.jdField_a_of_type_AndroidGraphicsPath.arcTo(localRectF, 0.0F, 90.0F);
    this.jdField_a_of_type_AndroidGraphicsPath.close();
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    b(paramCanvas);
    c(paramCanvas);
    d(paramCanvas);
    e(paramCanvas);
  }
  
  public void setRadius(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGamePosterCoverView
 * JD-Core Version:    0.7.0.1
 */