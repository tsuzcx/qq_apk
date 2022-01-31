package com.tencent.ad.tangram.canvas.views.canvas.framework;

import com.tencent.ad.tangram.canvas.views.canvas.components.AdCanvasComponentData;
import com.tencent.ad.tangram.log.AdLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
  implements Serializable
{
  private static final String TAG = "AdCanvasPageData";
  public String arkApp;
  public String arkView;
  public int backgroundColor;
  public List<AdCanvasComponentData> components;
  private AdCanvasComponentData firstImageComponent;
  public int floatingBarBackgroundColor;
  public int floatingBarTextColor;
  public boolean hasFixedButtonData = false;
  public String id;
  public boolean isFloatingBarStyleSetted = false;
  
  public AdCanvasComponentData getComponent(int paramInt)
  {
    if ((!isValid()) || (paramInt < 0) || (paramInt > getSize()))
    {
      AdLog.e("AdCanvasPageData", "getComponent error");
      return null;
    }
    return (AdCanvasComponentData)this.components.get(paramInt);
  }
  
  public AdCanvasComponentData getPageFirstImageComponentData()
  {
    if (this.firstImageComponent != null) {
      return this.firstImageComponent;
    }
    int i = 0;
    while (i < this.components.size())
    {
      AdCanvasComponentData localAdCanvasComponentData = getComponent(i);
      if (((localAdCanvasComponentData instanceof com.tencent.ad.tangram.canvas.views.canvas.components.pictures.a)) && (((com.tencent.ad.tangram.canvas.views.canvas.components.pictures.a)localAdCanvasComponentData).imageList != null))
      {
        localAdCanvasComponentData = (AdCanvasComponentData)((com.tencent.ad.tangram.canvas.views.canvas.components.pictures.a)localAdCanvasComponentData).imageList.get(0);
        this.firstImageComponent = localAdCanvasComponentData;
        return localAdCanvasComponentData;
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
      for (int i = 0;; i = ((AdCanvasComponentData)localIterator.next()).getToLoadIdSize() + i)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.framework.a
 * JD-Core Version:    0.7.0.1
 */