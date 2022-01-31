package com.tencent.ad.tangram.canvas.views.xijing;

import android.text.TextUtils;
import java.io.Serializable;

public class a
  implements Serializable
{
  public int backgroundColor = 0;
  public int borderCornerRadius = 5;
  public int borderWidth = 2;
  public AdTextData text = new AdTextData();
  
  public boolean isValid()
  {
    return (this.text != null) && (this.text.isValid()) && (!TextUtils.isEmpty(this.text.text)) && (this.borderCornerRadius >= 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.xijing.a
 * JD-Core Version:    0.7.0.1
 */