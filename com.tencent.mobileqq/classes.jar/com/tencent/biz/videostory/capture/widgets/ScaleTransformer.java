package com.tencent.biz.videostory.capture.widgets;

import android.view.View;

public class ScaleTransformer
  implements VideoStoryScrollItemTransformer
{
  private Pivot a = Pivot.a(1);
  private Pivot b = Pivot.b(1);
  private float c = 0.8F;
  private float d = 0.2F;
  
  public void a(View paramView, float paramFloat)
  {
    this.a.a(paramView);
    this.b.a(paramView);
    paramFloat = Math.abs(paramFloat);
    paramFloat = this.c + this.d * (1.0F - paramFloat);
    paramView.setScaleX(paramFloat);
    paramView.setScaleY(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.capture.widgets.ScaleTransformer
 * JD-Core Version:    0.7.0.1
 */