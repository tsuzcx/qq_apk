package com.tencent.ad.tangram.views.canvas;

import android.support.annotation.Keep;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.views.canvas.components.appbutton.c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Keep
public class AdCanvasData
  implements Serializable
{
  private static final String TAG = "AdCanvasData";
  public Ad ad;
  public ArrayList<c> appFixedButtonComponentDataList = new ArrayList();
  public String appInfoRightUrl;
  private boolean autodownload;
  public int basicWidth = -2147483648;
  public String commonPageId;
  public String firstPictureComponentIdWithHotArea = "";
  public ArrayList<com.tencent.ad.tangram.views.canvas.components.fixedbutton.a> fixedButtonComponentDataList = new ArrayList();
  public boolean hasFixedButtonData = false;
  public boolean hasMultiPictureData = false;
  public String id;
  public String name;
  public long pageId = -2147483648L;
  public String pageTitle;
  public String pageType;
  public String pageUrl;
  public List<com.tencent.ad.tangram.views.canvas.framework.a> pages;
  public String sourceId;
  
  public boolean getAutoDownLoad()
  {
    return (isValid()) && (this.autodownload);
  }
  
  public com.tencent.ad.tangram.views.canvas.framework.a getPage(int paramInt)
  {
    if ((isValid()) && (paramInt >= 0) && (paramInt <= getSize())) {
      return (com.tencent.ad.tangram.views.canvas.framework.a)this.pages.get(paramInt);
    }
    AdLog.e("AdCanvasData", "getPage error");
    return null;
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
    while (localIterator.hasNext())
    {
      com.tencent.ad.tangram.views.canvas.framework.a locala = (com.tencent.ad.tangram.views.canvas.framework.a)localIterator.next();
      int j;
      if (locala != null) {
        j = locala.getSize();
      } else {
        j = 0;
      }
      i += j;
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
    while (localIterator.hasNext())
    {
      com.tencent.ad.tangram.views.canvas.framework.a locala = (com.tencent.ad.tangram.views.canvas.framework.a)localIterator.next();
      int j;
      if (locala != null) {
        j = locala.getToLoadIdSize();
      } else {
        j = 0;
      }
      i += j;
    }
    return i;
  }
  
  public boolean isPageWithoutButton()
  {
    return (this.fixedButtonComponentDataList.size() == 0) && (this.appFixedButtonComponentDataList.size() == 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.AdCanvasData
 * JD-Core Version:    0.7.0.1
 */