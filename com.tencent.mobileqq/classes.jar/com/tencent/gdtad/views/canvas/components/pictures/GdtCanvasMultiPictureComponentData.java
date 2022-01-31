package com.tencent.gdtad.views.canvas.components.pictures;

import com.tencent.gdtad.views.canvas.components.GdtCanvasComponentData;
import com.tencent.gdtad.views.canvas.components.picture.GdtCanvasPictureComponentData;
import java.util.ArrayList;

public class GdtCanvasMultiPictureComponentData
  extends GdtCanvasComponentData
{
  public int floatingBarBackgroundColor;
  public int floatingBarTextColor;
  public ArrayList<GdtCanvasPictureComponentData> imageList;
  
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
    return super.isValid();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.pictures.GdtCanvasMultiPictureComponentData
 * JD-Core Version:    0.7.0.1
 */