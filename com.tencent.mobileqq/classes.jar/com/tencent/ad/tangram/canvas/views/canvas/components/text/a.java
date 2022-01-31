package com.tencent.ad.tangram.canvas.views.canvas.components.text;

import android.text.TextUtils;
import com.tencent.ad.tangram.canvas.views.canvas.components.AdCanvasComponentData;

public class a
  extends AdCanvasComponentData
{
  public String content;
  public int fontSize;
  public int marginBottom = 0;
  public int marginLeft = 0;
  public int marginRight = 0;
  public int marginTop = 0;
  
  public boolean isValid()
  {
    return (super.isValid()) && (!TextUtils.isEmpty(this.content));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.text.a
 * JD-Core Version:    0.7.0.1
 */