package com.tencent.gdtad.views.canvas.components.picture;

import android.text.TextUtils;
import com.tencent.gdtad.views.canvas.components.GdtCanvasComponentData;

public class GdtCanvasPictureComponentData
  extends GdtCanvasComponentData
{
  public String actionUrl;
  public int height;
  public String imageId;
  public String url;
  public int width;
  
  public boolean isValid()
  {
    return (super.isValid()) && (this.width > 0) && (this.height > 0) && (!TextUtils.isEmpty(this.url));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.picture.GdtCanvasPictureComponentData
 * JD-Core Version:    0.7.0.1
 */