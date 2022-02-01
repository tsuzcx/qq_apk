package com.tencent.ad.tangram.canvas.views.canvas.components.button;

import com.tencent.ad.tangram.canvas.views.canvas.components.AdCanvasComponentData;

public class a
  extends AdCanvasComponentData
{
  public String actionUrl;
  public com.tencent.ad.tangram.canvas.views.xijing.a button = new com.tencent.ad.tangram.canvas.views.xijing.a();
  public int formIndex;
  public String formModId;
  public int gravity = 0;
  public int height = 0;
  public boolean isFixed = false;
  public String linkType;
  public int toBottom = 0;
  public int whiteSpace = 0;
  public int width = 0;
  
  public boolean isValid()
  {
    return (super.isValid()) && (this.paddingLeft >= 0) && (this.paddingRight >= 0) && (this.height > 0) && (this.button.isValid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.button.a
 * JD-Core Version:    0.7.0.1
 */