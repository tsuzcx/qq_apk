package com.tencent.gdtad.views.canvas.components;

import android.text.TextUtils;
import java.io.Serializable;

public abstract class GdtCanvasComponentData
  implements Serializable
{
  public String id;
  public int paddingBottom;
  public int paddingTop;
  
  public boolean isValid()
  {
    return (!TextUtils.isEmpty(this.id)) && (this.paddingTop >= 0) && (this.paddingBottom >= 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.GdtCanvasComponentData
 * JD-Core Version:    0.7.0.1
 */