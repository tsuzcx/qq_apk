package com.app.hubert.guide.model;

import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.view.View;

public class HighlightRectF
  implements HighLight
{
  private HighlightOptions options;
  private RectF rectF;
  private int round;
  private HighLight.Shape shape;
  
  public HighlightRectF(@NonNull RectF paramRectF, @NonNull HighLight.Shape paramShape, int paramInt)
  {
    this.rectF = paramRectF;
    this.shape = paramShape;
    this.round = paramInt;
  }
  
  public HighlightOptions getOptions()
  {
    return this.options;
  }
  
  public float getRadius()
  {
    return Math.min(this.rectF.width() / 2.0F, this.rectF.height() / 2.0F);
  }
  
  public RectF getRectF(View paramView)
  {
    return this.rectF;
  }
  
  public int getRound()
  {
    return this.round;
  }
  
  public HighLight.Shape getShape()
  {
    return this.shape;
  }
  
  public void setOptions(HighlightOptions paramHighlightOptions)
  {
    this.options = paramHighlightOptions;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.app.hubert.guide.model.HighlightRectF
 * JD-Core Version:    0.7.0.1
 */