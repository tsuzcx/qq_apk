package com.tencent.gdtad.views.canvas;

import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import java.io.Serializable;
import java.util.List;

public class GdtCanvasData
  implements Serializable
{
  public GdtAd ad;
  public int basicWidth;
  public String id;
  public String name;
  public List pages;
  
  public boolean isValid()
  {
    return (this.ad != null) && (!TextUtils.isEmpty(this.id)) && (this.basicWidth > 0) && (this.pages != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.GdtCanvasData
 * JD-Core Version:    0.7.0.1
 */