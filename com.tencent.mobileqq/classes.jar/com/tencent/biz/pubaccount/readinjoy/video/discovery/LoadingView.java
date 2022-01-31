package com.tencent.biz.pubaccount.readinjoy.video.discovery;

import actj;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import bbdh;

public class LoadingView
  extends View
{
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private int jdField_b_of_type_Int;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private Rect jdField_b_of_type_AndroidGraphicsRect;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public LoadingView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public LoadingView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public LoadingView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_b_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.parseColor("#E8E8E7"));
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(actj.a(2.0F, getResources()));
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(Color.parseColor("#ffffff"));
    this.jdField_a_of_type_Int = actj.a(28.0F, getResources());
    this.jdField_b_of_type_Int = actj.a(100.0F, getResources());
    this.c = actj.a(15.0F, getResources());
    this.e = ((int)(bbdh.i() * 0.29D));
    this.d = (this.e * 4 / 3);
    this.f = actj.a(9.0F, getResources());
    this.g = actj.a(18.0F, getResources());
  }
  
  private void a(Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsRectF.left = (getLeft() + getPaddingLeft());
    this.jdField_a_of_type_AndroidGraphicsRectF.top = ((this.c + this.g * 2) / 2 - this.jdField_a_of_type_Int / 2);
    this.jdField_a_of_type_AndroidGraphicsRectF.right = (this.jdField_a_of_type_AndroidGraphicsRectF.left + this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (this.jdField_a_of_type_AndroidGraphicsRectF.top + this.jdField_a_of_type_Int);
    paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  private void b(Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsRect.left = ((int)(getLeft() + this.f + this.jdField_a_of_type_AndroidGraphicsRectF.right));
    this.jdField_a_of_type_AndroidGraphicsRect.top = this.g;
    this.jdField_a_of_type_AndroidGraphicsRect.right = (this.jdField_a_of_type_AndroidGraphicsRect.left + this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsRect.bottom = (this.jdField_a_of_type_AndroidGraphicsRect.top + this.c);
    paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  private void c(Canvas paramCanvas)
  {
    this.jdField_b_of_type_AndroidGraphicsRect.left = (getLeft() + getPaddingLeft());
    this.jdField_b_of_type_AndroidGraphicsRect.top = (this.jdField_a_of_type_AndroidGraphicsRect.bottom + this.g);
    this.jdField_b_of_type_AndroidGraphicsRect.right = (this.jdField_b_of_type_AndroidGraphicsRect.left + (int)bbdh.i());
    this.jdField_b_of_type_AndroidGraphicsRect.bottom = (this.jdField_b_of_type_AndroidGraphicsRect.top + this.d);
    paramCanvas.drawRect(this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  private void d(Canvas paramCanvas)
  {
    paramCanvas.drawLine(this.jdField_b_of_type_AndroidGraphicsRect.left + this.e, this.jdField_b_of_type_AndroidGraphicsRect.top, this.jdField_b_of_type_AndroidGraphicsRect.left + this.e, this.jdField_b_of_type_AndroidGraphicsRect.left + this.jdField_b_of_type_AndroidGraphicsRect.top + this.d, this.jdField_b_of_type_AndroidGraphicsPaint);
    paramCanvas.drawLine(this.jdField_b_of_type_AndroidGraphicsRect.left + this.e * 2, this.jdField_b_of_type_AndroidGraphicsRect.top, this.jdField_b_of_type_AndroidGraphicsRect.left + this.e * 2, this.jdField_b_of_type_AndroidGraphicsRect.top + this.d, this.jdField_b_of_type_AndroidGraphicsPaint);
    paramCanvas.drawLine(this.jdField_b_of_type_AndroidGraphicsRect.left + this.e * 3, this.jdField_b_of_type_AndroidGraphicsRect.top, this.jdField_b_of_type_AndroidGraphicsRect.left + this.e * 3, this.jdField_b_of_type_AndroidGraphicsRect.top + this.d, this.jdField_b_of_type_AndroidGraphicsPaint);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    a(paramCanvas);
    b(paramCanvas);
    c(paramCanvas);
    d(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = this.c;
    paramInt2 = this.g;
    int i = this.d;
    setMeasuredDimension((int)bbdh.i(), paramInt1 + paramInt2 * 2 + i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.discovery.LoadingView
 * JD-Core Version:    0.7.0.1
 */