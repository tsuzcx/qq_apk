package com.app.hubert.guide.model;

import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.view.View;

public abstract interface HighLight
{
  @Nullable
  public abstract HighlightOptions getOptions();
  
  public abstract float getRadius();
  
  public abstract RectF getRectF(View paramView);
  
  public abstract int getRound();
  
  public abstract HighLight.Shape getShape();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.app.hubert.guide.model.HighLight
 * JD-Core Version:    0.7.0.1
 */