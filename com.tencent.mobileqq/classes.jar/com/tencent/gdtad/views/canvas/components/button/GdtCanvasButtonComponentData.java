package com.tencent.gdtad.views.canvas.components.button;

import com.tencent.gdtad.views.canvas.components.GdtCanvasComponentData;
import com.tencent.gdtad.views.xijing.GdtButtonData;

public class GdtCanvasButtonComponentData
  extends GdtCanvasComponentData
{
  public String actionUrl;
  public GdtButtonData button = new GdtButtonData();
  public int formIndex;
  public String formModId;
  public int gravity = 0;
  public int height;
  public boolean isFixed;
  public String linkType;
  public int toBottom;
  public int whiteSpace;
  public int width;
  
  public boolean isValid()
  {
    return (super.isValid()) && (this.paddingLeft >= 0) && (this.paddingRight >= 0) && (this.height > 0) && (this.button.isValid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.button.GdtCanvasButtonComponentData
 * JD-Core Version:    0.7.0.1
 */