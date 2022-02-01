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
  
  protected void onDraw(Canvas paramCanvas)
  {
    getPaddingLeft();
    getPaddingRight();
    int i = getPaddingTop();
    int j = getPaddingBottom();
    int k = getHeight();
    getWidth();
    if (this.b == 0.0F) {
      this.b = (getWidth() / this.d);
    }
    paramCanvas.drawRoundRect(new RectF(0.0F, 0.0F, this.b * this.c, k - i - j), 5.0F, 5.0F, this.a);
    super.onDraw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.view.AdProgressButton
 * JD-Core Version:    0.7.0.1
 */