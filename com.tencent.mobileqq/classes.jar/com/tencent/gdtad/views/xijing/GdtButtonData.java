package com.tencent.gdtad.views.xijing;

import android.text.TextUtils;
import java.io.Serializable;

public class GdtButtonData
  implements Serializable
{
  public int backgroundColor = 0;
  public int borderCornerRadius;
  public GdtTextData text = new GdtTextData();
  
  public boolean isValid()
  {
    return (this.text != null) && (this.text.isValid()) && (!TextUtils.isEmpty(this.text.text)) && (this.borderCornerRadius >= 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.xijing.GdtButtonData
 * JD-Core Version:    0.7.0.1
 */