package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class VideoFeedsAlphaMaskView
  extends View
{
  private float jdField_a_of_type_Float = 1.0F;
  private final int jdField_a_of_type_Int = -635823590;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private final int b = 218;
  
  public VideoFeedsAlphaMaskView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-635823590);
  }
  
  public VideoFeedsAlphaMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-635823590);
  }
  
  public VideoFeedsAlphaMaskView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-635823590);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha((int)(this.jdField_a_of_type_Float * 218.0F));
    paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public void setAlpha(float paramFloat)
  {
    if (this.jdField_a_of_type_Float != paramFloat)
    {
      this.jdField_a_of_type_Float = paramFloat;
      invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAlphaMaskView
 * JD-Core Version:    0.7.0.1
 */