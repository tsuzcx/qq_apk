package com.tencent.ad.tangram.canvas.views.canvas.components.appInfoButton;

import com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.c;

public class a
  extends c
{
  public String appName;
  public int appNameFontSize;
  public int backgroundColor;
  public String desc;
  public int descFontSize;
  public float descLineSpacing;
  public long downloadCount;
  public long fileSize;
  public int fileSizeAndDownFontSize;
  public String logoUrl;
  
  public boolean isValid()
  {
    return (super.isValid()) && (this.paddingLeft >= 0) && (this.paddingRight >= 0) && (this.height > 0) && (this.button.isValid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.appInfoButton.a
 * JD-Core Version:    0.7.0.1
 */