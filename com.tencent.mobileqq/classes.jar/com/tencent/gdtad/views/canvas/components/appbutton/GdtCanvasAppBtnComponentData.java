package com.tencent.gdtad.views.canvas.components.appbutton;

import com.tencent.gdtad.views.canvas.components.GdtCanvasComponentData;
import com.tencent.gdtad.views.xijing.GdtButtonData;

public class GdtCanvasAppBtnComponentData
  extends GdtCanvasComponentData
{
  public GdtButtonData button = new GdtButtonData();
  public boolean canShowProgress;
  public int fontColor = 0;
  public int gravity = 0;
  public int height;
  public boolean isFixed;
  public int toBottom;
  public int whiteSpace;
  public int width;
  
  public boolean isValid()
  {
    return (super.isValid()) && (this.width > 0) && (this.height > 0) && (this.button.isValid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.appbutton.GdtCanvasAppBtnComponentData
 * JD-Core Version:    0.7.0.1
 */