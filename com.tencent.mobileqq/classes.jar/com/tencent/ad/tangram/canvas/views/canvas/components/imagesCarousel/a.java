package com.tencent.ad.tangram.canvas.views.canvas.components.imagesCarousel;

import com.tencent.ad.tangram.canvas.views.canvas.components.AdCanvasComponentData;
import java.util.ArrayList;

public class a
  extends AdCanvasComponentData
{
  public int displaySpeed = 2;
  public boolean enableImageRoundRectBackground = false;
  public int height;
  public String imageBorderColor;
  public int imageBorderWidth;
  public int imageHeight;
  public ArrayList<com.tencent.ad.tangram.canvas.views.canvas.components.picture.a> imageList;
  public int imageRadius;
  public int imageWidth;
  public int marginBottom;
  public int marginLeft;
  public int marginRight;
  public int marginTop;
  public int pageLimit = 2;
  public int pageMargin = 0;
  public int width;
  
  public int getToLoadIdSize()
  {
    int j = 0;
    int i = j;
    if (isValid())
    {
      i = j;
      if (this.imageList != null) {
        i = 0 + this.imageList.size();
      }
    }
    return i;
  }
  
  public boolean isValid()
  {
    return (super.isValid()) && (this.imageWidth > 0) && (this.imageHeight > 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.imagesCarousel.a
 * JD-Core Version:    0.7.0.1
 */