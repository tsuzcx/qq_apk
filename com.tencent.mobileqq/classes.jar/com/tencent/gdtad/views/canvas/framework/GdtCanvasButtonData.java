package com.tencent.gdtad.views.canvas.framework;

import android.text.TextUtils;
import java.io.Serializable;

public class GdtCanvasButtonData
  implements Serializable
{
  public int backgroundColor = 0;
  public int borderCornerRadius;
  public GdtCanvasTextData text = new GdtCanvasTextData();
  
  public boolean isValid()
  {
    return (this.text != null) && (this.text.isValid()) && (!TextUtils.isEmpty(this.text.text)) && (this.borderCornerRadius >= 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.framework.GdtCanvasButtonData
 * JD-Core Version:    0.7.0.1
 */