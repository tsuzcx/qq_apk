package com.tencent.gdtad.views.canvas.components;

import android.text.TextUtils;
import java.io.Serializable;

public abstract class GdtCanvasComponentData
  implements Serializable
{
  public String id;
  public boolean isAddToLoadStatistics = true;
  public int paddingBottom;
  public int paddingLeft;
  public int paddingRight;
  public int paddingTop;
  
  public int getToLoadIdSize()
  {
    return 1;
  }
  
  public boolean isValid()
  {
    return (!TextUtils.isEmpty(this.id)) && (this.paddingTop >= 0) && (this.paddingBottom >= 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.GdtCanvasComponentData
 * JD-Core Version:    0.7.0.1
 */