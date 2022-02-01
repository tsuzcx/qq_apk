package com.tencent.ad.tangram.views.xijing;

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
    AdTextData localAdTextData = this.text;
    return (localAdTextData != null) && (localAdTextData.isValid()) && (!TextUtils.isEmpty(this.text.text)) && (this.borderCornerRadius >= 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.xijing.a
 * JD-Core Version:    0.7.0.1
 */