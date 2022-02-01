package com.tencent.ad.tangram.views.canvas.framework;

import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentData;
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
  public boolean hasMultiPictureData = false;
  public String id;
  public com.tencent.ad.tangram.views.a imageLoadParams;
  public boolean isFloatingBarStyleSetted = false;
  
  public AdCanvasComponentData getComponent(int paramInt)
  {
    if ((isValid()) && (paramInt >= 0) && (paramInt <= getSize())) {
      return (AdCanvasComponentData)this.components.get(paramInt);
    }
    AdLog.e("AdCanvasPageData", "getComponent error");
    return null;
  }
  
  public AdCanvasComponentData getPageFirstImageComponentData()
  {
    Object localObject = this.firstImageComponent;
    if (localObject != null) {
      return localObject;
    }
    int i = 0;
    while (i < this.components.size())
    {
      localObject = getComponent(i);
      if ((localObject instanceof com.tencent.ad.tangram.views.canvas.components.pictures.a))
      {
        localObject = (com.tencent.ad.tangram.views.canvas.components.pictures.a)localObject;
        if (((com.tencent.ad.tangram.views.canvas.components.pictures.a)localObject).imageList != null)
        {
          localObject = (AdCanvasComponentData)((com.tencent.ad.tangram.views.canvas.components.pictures.a)localObject).imageList.get(0);
          this.firstImageComponent = ((AdCanvasComponentData)localObject);
          return localObject;
        }
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
    boolean bool = isValid();
    int j = 0;
    int i = 0;
    if (bool)
    {
      Iterator localIterator = this.components.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        i += ((AdCanvasComponentData)localIterator.next()).getToLoadIdSize();
      }
    }
    return j;
  }
  
  public boolean isValid()
  {
    return this.components != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.framework.a
 * JD-Core Version:    0.7.0.1
 */