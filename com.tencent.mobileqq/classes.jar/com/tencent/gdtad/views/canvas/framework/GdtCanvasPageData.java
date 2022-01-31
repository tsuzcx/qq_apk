package com.tencent.gdtad.views.canvas.framework;

import com.tencent.gdtad.views.canvas.components.GdtCanvasComponentData;
import com.tencent.gdtad.views.canvas.components.pictures.GdtCanvasMultiPictureComponentData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import yxs;

public class GdtCanvasPageData
  implements Serializable
{
  public String arkApp;
  public String arkView;
  public int backgroundColor;
  public List<GdtCanvasComponentData> components;
  private GdtCanvasComponentData firstImageComponent;
  public int floatingBarBackgroundColor;
  public int floatingBarTextColor;
  public boolean hasFixedButtonData;
  public String id;
  public boolean isFloatingBarStyleSetted;
  
  public GdtCanvasComponentData getComponent(int paramInt)
  {
    if ((!isValid()) || (paramInt < 0) || (paramInt > getSize()))
    {
      yxs.d("GdtCanvasPageData", "getComponent error");
      return null;
    }
    return (GdtCanvasComponentData)this.components.get(paramInt);
  }
  
  public GdtCanvasComponentData getPageFirstImageComponentData()
  {
    if (this.firstImageComponent != null) {
      return this.firstImageComponent;
    }
    int i = 0;
    while (i < this.components.size())
    {
      GdtCanvasComponentData localGdtCanvasComponentData = getComponent(i);
      if (((localGdtCanvasComponentData instanceof GdtCanvasMultiPictureComponentData)) && (((GdtCanvasMultiPictureComponentData)localGdtCanvasComponentData).imageList != null))
      {
        localGdtCanvasComponentData = (GdtCanvasComponentData)((GdtCanvasMultiPictureComponentData)localGdtCanvasComponentData).imageList.get(0);
        this.firstImageComponent = localGdtCanvasComponentData;
        return localGdtCanvasComponentData;
      }
      i += 1;
    }
    return null;
  }
  
  public int getSize()
  {
    if (isValid()) {
      return this.components.size();
    }
    return 0;
  }
  
  public int getToLoadIdSize()
  {
    if (isValid())
    {
      Iterator localIterator = this.components.iterator();
      for (int i = 0;; i = ((GdtCanvasComponentData)localIterator.next()).getToLoadIdSize() + i)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
      }
    }
    int j = 0;
    return j;
  }
  
  public boolean isValid()
  {
    return this.components != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.framework.GdtCanvasPageData
 * JD-Core Version:    0.7.0.1
 */