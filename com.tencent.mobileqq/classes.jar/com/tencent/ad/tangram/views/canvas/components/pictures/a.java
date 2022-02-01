package com.tencent.ad.tangram.views.canvas.components.pictures;

import com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentData;
import java.util.ArrayList;

public class a
  extends AdCanvasComponentData
{
  public int floatingBarBackgroundColor;
  public int floatingBarTextColor;
  public ArrayList<com.tencent.ad.tangram.views.canvas.components.picture.a> imageList;
  
  public int getToLoadIdSize()
  {
    boolean bool = isValid();
    int j = 0;
    int i = j;
    if (bool)
    {
      ArrayList localArrayList = this.imageList;
      i = j;
      if (localArrayList != null) {
        i = 0 + localArrayList.size();
      }
    }
    return i;
  }
  
  public boolean isValid()
  {
    return super.isValid();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.components.pictures.a
 * JD-Core Version:    0.7.0.1
 */