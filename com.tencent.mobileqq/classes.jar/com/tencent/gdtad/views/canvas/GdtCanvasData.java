package com.tencent.gdtad.views.canvas;

import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.canvas.components.GdtCanvasComponentData;
import com.tencent.gdtad.views.canvas.components.appbutton.GdtCanvasAppBtnComponentData;
import com.tencent.gdtad.views.canvas.components.button.GdtCanvasButtonComponentData;
import com.tencent.gdtad.views.canvas.components.fixedbutton.GdtCanvasFixedButtonComponentData;
import com.tencent.gdtad.views.canvas.framework.GdtCanvasPageData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import yxp;

public class GdtCanvasData
  implements Serializable
{
  public GdtAd ad;
  public ArrayList<GdtCanvasAppBtnComponentData> appFixedButtonComponentDataList = new ArrayList();
  private boolean autodownload;
  public int basicWidth = -2147483648;
  public String commonPageId;
  public String firstPictureComponentIdWithHotArea = "";
  public ArrayList<GdtCanvasFixedButtonComponentData> fixedButtonComponentDataList = new ArrayList();
  public boolean hasFixedButtonData;
  public String id;
  public String name;
  public long pageId = -2147483648L;
  public String pageType;
  public String pageUrl;
  public List<GdtCanvasPageData> pages;
  public String sourceId;
  public ArrayList<GdtCanvasButtonComponentData> webFixedButtonComponentDataList = new ArrayList();
  
  public boolean getAutoDownLoad()
  {
    if (isValid()) {
      return this.autodownload;
    }
    return false;
  }
  
  public GdtCanvasPageData getPage(int paramInt)
  {
    if ((!isValid()) || (paramInt < 0) || (paramInt > getSize()))
    {
      yxp.d("GdtCanvasData", "getPage error");
      return null;
    }
    return (GdtCanvasPageData)this.pages.get(paramInt);
  }
  
  public int getSize()
  {
    if (isValid()) {
      return this.pages.size();
    }
    return 0;
  }
  
  public int getSizeOfComponents()
  {
    if (!isValid()) {
      return 0;
    }
    Iterator localIterator = this.pages.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      GdtCanvasPageData localGdtCanvasPageData = (GdtCanvasPageData)localIterator.next();
      if (localGdtCanvasPageData != null) {}
      for (int j = localGdtCanvasPageData.getSize();; j = 0)
      {
        i = j + i;
        break;
      }
    }
    return i;
  }
  
  public int getToLoadIdsize()
  {
    if (!isValid()) {
      return 0;
    }
    Iterator localIterator = this.pages.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      GdtCanvasPageData localGdtCanvasPageData = (GdtCanvasPageData)localIterator.next();
      if (localGdtCanvasPageData != null) {}
      for (int j = localGdtCanvasPageData.getToLoadIdSize();; j = 0)
      {
        i = j + i;
        break;
      }
    }
    return i;
  }
  
  public boolean isPageWithoutButton()
  {
    int j;
    if ((getPage(0) != null) && (getPage(0).components != null)) {
      if (getPage(0).components.size() == 0) {
        j = 1;
      }
    }
    for (;;)
    {
      if ((j != 0) && (this.fixedButtonComponentDataList.size() == 0) && (this.webFixedButtonComponentDataList.size() == 0) && (this.appFixedButtonComponentDataList.size() == 0))
      {
        return true;
        Iterator localIterator = getPage(0).components.iterator();
        int i = 1;
        j = i;
        if (!localIterator.hasNext()) {
          continue;
        }
        if (!((GdtCanvasComponentData)localIterator.next() instanceof GdtCanvasButtonComponentData)) {
          break label122;
        }
        i = 0;
      }
      label122:
      for (;;)
      {
        break;
        return false;
      }
      j = 1;
    }
  }
  
  public boolean isValid()
  {
    return (this.ad != null) && (this.basicWidth > 0) && (this.pages != null);
  }
  
  public void setAutodownload(boolean paramBoolean)
  {
    this.autodownload = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.GdtCanvasData
 * JD-Core Version:    0.7.0.1
 */