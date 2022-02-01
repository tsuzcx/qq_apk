package com.tencent.ad.tangram.canvas.views.canvas.components;

import android.support.annotation.Keep;
import android.text.TextUtils;
import java.io.Serializable;

@Keep
public abstract class AdCanvasComponentData
  implements Serializable
{
  public String id;
  public boolean isAddToLoadStatistics = true;
  public int paddingBottom = 0;
  public int paddingLeft = 0;
  public int paddingRight = 0;
  public int paddingTop = 0;
  
  public int getToLoadIdSize()
  {
    return 1;
  }
  
  public boolean isValid()
  {
    return (!TextUtils.isEmpty(this.id)) && (this.paddingTop >= 0) && (this.paddingBottom >= 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.AdCanvasComponentData
 * JD-Core Version:    0.7.0.1
 */