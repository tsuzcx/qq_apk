package com.tencent.biz.pubaccount.weishi_new.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.Op;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build.VERSION;
import android.view.View;

public class RoundCornerHelper
{
  public int a;
  public Paint a;
  public Path a;
  public RectF a;
  public Region a;
  public boolean a;
  public int b;
  
  public void a()
  {
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_AndroidGraphicsRegion = new Region();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
  }
  
  public void a(Canvas paramCanvas)
  {
    if (this.b > 0)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.b * 2);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    if (Build.VERSION.SDK_INT <= 27)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    Path localPath = new Path();
    localPath.addRect(0.0F, 0.0F, (int)this.jdField_a_of_type_AndroidGraphicsRectF.width(), (int)this.jdField_a_of_type_AndroidGraphicsRectF.height(), Path.Direction.CW);
    localPath.op(this.jdField_a_of_type_AndroidGraphicsPath, Path.Op.DIFFERENCE);
    paramCanvas.drawPath(localPath, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public void a(View paramView)
  {
    int i = (int)this.jdField_a_of_type_AndroidGraphicsRectF.width();
    int j = (int)this.jdField_a_of_type_AndroidGraphicsRectF.height();
    RectF localRectF = new RectF();
    localRectF.left = paramView.getPaddingLeft();
    localRectF.top = paramView.getPaddingTop();
    localRectF.right = (i - paramView.getPaddingRight());
    localRectF.bottom = (j - paramView.getPaddingBottom());
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    float f1;
    if (localRectF.width() >= localRectF.height()) {
      f1 = localRectF.height();
    } else {
      f1 = localRectF.width();
    }
    f1 /= 2.0F;
    float f2 = i / 2;
    float f3 = j / 2;
    paramView = new PointF(f2, f3);
    if (Build.VERSION.SDK_INT <= 27)
    {
      this.jdField_a_of_type_AndroidGraphicsPath.addCircle(paramView.x, paramView.y, f1, Path.Direction.CW);
      this.jdField_a_of_type_AndroidGraphicsPath.moveTo(0.0F, 0.0F);
      this.jdField_a_of_type_AndroidGraphicsPath.moveTo(i, j);
    }
    else
    {
      f2 = f3 - f1;
      this.jdField_a_of_type_AndroidGraphicsPath.moveTo(localRectF.left, f2);
      this.jdField_a_of_type_AndroidGraphicsPath.addCircle(paramView.x, f2 + f1, f1, Path.Direction.CW);
    }
    paramView = new Region((int)localRectF.left, (int)localRectF.top, (int)localRectF.right, (int)localRectF.bottom);
    this.jdField_a_of_type_AndroidGraphicsRegion.setPath(this.jdField_a_of_type_AndroidGraphicsPath, paramView);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, paramInt1, paramInt2);
    a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.RoundCornerHelper
 * JD-Core Version:    0.7.0.1
 */