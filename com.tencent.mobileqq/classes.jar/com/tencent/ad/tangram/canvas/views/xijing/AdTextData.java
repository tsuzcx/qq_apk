package com.tencent.ad.tangram.canvas.views.xijing;

import android.support.annotation.Keep;
import java.io.Serializable;

@Keep
public class AdTextData
  implements Serializable
{
  public static final String FONT_WEIGHT_BOLD = "bold";
  public static final String FONT_WEIGHT_NORMAL = "normal";
  public int color = 0;
  public int lengthMax = -2147483648;
  public int size;
  public String text;
  public String weight = "normal";
  
  public boolean isValid()
  {
    return this.size > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.xijing.AdTextData
 * JD-Core Version:    0.7.0.1
 */