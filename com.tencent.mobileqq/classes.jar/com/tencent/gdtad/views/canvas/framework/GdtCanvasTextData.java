package com.tencent.gdtad.views.canvas.framework;

import java.io.Serializable;

public class GdtCanvasTextData
  implements Serializable
{
  public int color = 0;
  public int lengthMax = -2147483648;
  public int size;
  public String text;
  
  public boolean isValid()
  {
    return this.size > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.framework.GdtCanvasTextData
 * JD-Core Version:    0.7.0.1
 */