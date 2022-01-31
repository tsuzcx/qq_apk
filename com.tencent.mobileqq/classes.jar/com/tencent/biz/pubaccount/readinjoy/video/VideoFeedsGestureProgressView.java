package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class VideoFeedsGestureProgressView
  extends View
{
  private float jdField_a_of_type_Float;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  
  public VideoFeedsGestureProgressView(Context paramContext)
  {
    super(paramContext);
  }
  
  public VideoFeedsGestureProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public VideoFeedsGestureProgressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(1711276032);
    paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    paramCanvas.drawRect(0.0F, getHeight() - getHeight() * this.jdField_a_of_type_Float, getWidth(), getHeight(), this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public void setProgress(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGestureProgressView
 * JD-Core Version:    0.7.0.1
 */