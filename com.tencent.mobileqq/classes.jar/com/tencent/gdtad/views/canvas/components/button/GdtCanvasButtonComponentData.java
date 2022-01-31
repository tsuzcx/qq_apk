package com.tencent.gdtad.views.canvas.components.button;

import com.tencent.gdtad.views.canvas.components.GdtCanvasComponentData;
import com.tencent.gdtad.views.canvas.framework.GdtCanvasButtonData;

public class GdtCanvasButtonComponentData
  extends GdtCanvasComponentData
{
  public String actionUrl;
  public GdtCanvasButtonData button = new GdtCanvasButtonData();
  public int height;
  public int paddingLeft;
  public int paddingRight;
  
  public boolean isValid()
  {
    return (super.isValid()) && (this.paddingLeft >= 0) && (this.paddingRight >= 0) && (this.height > 0) && (this.button.isValid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.button.GdtCanvasButtonComponentData
 * JD-Core Version:    0.7.0.1
 */