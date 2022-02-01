package com.tencent.biz.pubaccount.Advertisement.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.tencent.mobileqq.widget.ProgressButton;

public class AdProgressButton
  extends ProgressButton
{
  public AdProgressButton(Context paramContext)
  {
    super(paramContext);
  }
  
  public AdProgressButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    getPaddingLeft();
    getPaddingRight();
    int i = getPaddingTop();
    int j = getPaddingBottom();
    int k = getHeight();
    getWidth();
    if (this.jdField_a_of_type_Float == 0.0F) {
      this.jdField_a_of_type_Float = (getWidth() / this.jdField_a_of_type_Int);
    }
    paramCanvas.drawRoundRect(new RectF(0.0F, 0.0F, this.jdField_a_of_type_Float * this.b, k - i - j), 5.0F, 5.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
    super.onDraw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.view.AdProgressButton
 * JD-Core Version:    0.7.0.1
 */