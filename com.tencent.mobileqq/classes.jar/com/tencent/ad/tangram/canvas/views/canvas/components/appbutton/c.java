package com.tencent.ad.tangram.canvas.views.canvas.components.appbutton;

import com.tencent.ad.tangram.canvas.views.canvas.components.AdCanvasComponentData;
import com.tencent.ad.tangram.canvas.views.xijing.a;

public class c
  extends AdCanvasComponentData
{
  public a button = new a();
  public boolean canShowProgress = false;
  public int fontColor = 0;
  public int gravity = 0;
  public int height = 0;
  public boolean isFixed = false;
  public int toBottom = 0;
  public int whiteSpace = 0;
  public int width = 0;
  
  public boolean isValid()
  {
    return (super.isValid()) && (this.width > 0) && (this.height > 0) && (this.button.isValid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.c
 * JD-Core Version:    0.7.0.1
 */