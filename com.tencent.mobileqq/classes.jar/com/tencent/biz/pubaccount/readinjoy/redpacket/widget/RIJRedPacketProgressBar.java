package com.tencent.biz.pubaccount.readinjoy.redpacket.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import bdaq;
import com.tencent.common.app.BaseApplicationImpl;

public class RIJRedPacketProgressBar
  extends View
{
  private static final float jdField_a_of_type_Float = a(27.0F);
  private static final float jdField_b_of_type_Float = a(27.0F);
  private static final float jdField_c_of_type_Float = a(2.0F);
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint();
  private Paint jdField_c_of_type_AndroidGraphicsPaint = new Paint();
  private float d;
  
  public RIJRedPacketProgressBar(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public RIJRedPacketProgressBar(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private static int a(float paramFloat)
  {
    return bdaq.a(BaseApplicationImpl.getContext(), paramFloat);
  }
  
  private void a()
  {
    setBackgroundColor(0);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.parseColor("#FFFFCC00"));
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(jdField_c_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_c_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(Color.parseColor("#FFFF570F"));
    this.jdField_a_of_type_AndroidGraphicsRectF.left = (jdField_c_of_type_Float / 2.0F);
    this.jdField_a_of_type_AndroidGraphicsRectF.top = (jdField_c_of_type_Float / 2.0F);
    this.jdField_a_of_type_AndroidGraphicsRectF.right = (jdField_a_of_type_Float - jdField_c_of_type_Float / 2.0F);
    this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (jdField_b_of_type_Float - jdField_c_of_type_Float / 2.0F);
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    invalidate();
    requestLayout();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (paramCanvas != null) {
      paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, -90.0F, this.d / 100.0F * 360.0F, false, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension((int)jdField_a_of_type_Float, (int)jdField_b_of_type_Float);
  }
  
  public void setProgress(float paramFloat)
  {
    this.d = paramFloat;
    invalidate();
    requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressBar
 * JD-Core Version:    0.7.0.1
 */