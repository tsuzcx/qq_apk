package com.tencent.gdtad.views.canvas;

import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.canvas.framework.GdtCanvasPageData;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public class GdtCanvasData
  implements Serializable
{
  public long actionSetId = -2147483648L;
  public GdtAd ad;
  public int basicWidth = -2147483648;
  public String id;
  public String name;
  public List pages;
  
  public GdtCanvasPageData getPage(int paramInt)
  {
    if ((!isValid()) || (paramInt < 0) || (paramInt > getSize()))
    {
      GdtLog.d("GdtCanvasData", "getPage error");
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
  
  public boolean isValid()
  {
    return (this.ad != null) && (!TextUtils.isEmpty(this.id)) && (this.basicWidth > 0) && (this.pages != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.GdtCanvasData
 * JD-Core Version:    0.7.0.1
 */