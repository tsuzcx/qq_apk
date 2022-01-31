package com.tencent.gdtad.views.canvas.framework;

import com.tencent.gdtad.aditem.GdtAd;
import java.io.Serializable;
import java.util.List;

public class GdtCanvasPageData
  implements Serializable
{
  public GdtAd ad;
  public int backgroundColor;
  public List components;
  public String id;
  
  public boolean isValid()
  {
    return (this.ad != null) && (this.components != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.framework.GdtCanvasPageData
 * JD-Core Version:    0.7.0.1
 */