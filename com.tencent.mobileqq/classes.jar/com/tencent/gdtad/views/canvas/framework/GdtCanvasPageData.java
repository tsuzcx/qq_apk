package com.tencent.gdtad.views.canvas.framework;

import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.canvas.components.GdtCanvasComponentData;
import java.io.Serializable;
import java.util.List;

public class GdtCanvasPageData
  implements Serializable
{
  public int backgroundColor;
  public List components;
  public String id;
  
  public GdtCanvasComponentData getComponent(int paramInt)
  {
    if ((!isValid()) || (paramInt < 0) || (paramInt > getSize()))
    {
      GdtLog.d("GdtCanvasPageData", "getComponent error");
      return null;
    }
    return (GdtCanvasComponentData)this.components.get(paramInt);
  }
  
  public int getSize()
  {
    if (isValid()) {
      return this.components.size();
    }
    return 0;
  }
  
  public boolean isValid()
  {
    return this.components != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.framework.GdtCanvasPageData
 * JD-Core Version:    0.7.0.1
 */