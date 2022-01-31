package com.tencent.gdtad.views.canvas.components.button;

import com.tencent.gdtad.views.canvas.components.GdtCanvasComponentData;

public class GdtCanvasButtonComponentData
  extends GdtCanvasComponentData
{
  public String actionUrl;
  public int backgroundColor;
  public int borderColor;
  public int borderCornerRadius;
  public int borderType;
  public int borderWidth;
  public int fontColor;
  public int fontSize;
  public String title;
  
  public boolean isValid()
  {
    return (super.isValid()) && (this.fontSize >= 0) && (this.borderWidth >= 0) && (this.borderCornerRadius >= 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.button.GdtCanvasButtonComponentData
 * JD-Core Version:    0.7.0.1
 */