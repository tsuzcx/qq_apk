package com.tencent.gdtad.views.canvas.components;

import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import java.io.Serializable;

public abstract class GdtCanvasComponentData
  implements Serializable
{
  public GdtAd ad;
  public int height;
  public String id;
  public int paddingBottom;
  public int paddingTop;
  public int type;
  public int width;
  
  public boolean isValid()
  {
    return (this.ad != null) && (!TextUtils.isEmpty(this.id)) && (this.width > 0) && (this.height > 0) && (this.paddingTop >= 0) && (this.paddingBottom >= 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.GdtCanvasComponentData
 * JD-Core Version:    0.7.0.1
 */