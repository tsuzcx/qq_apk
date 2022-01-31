package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.htmlcss;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CssStyleSet
{
  private final Map<String, CssStyle> cssStyleMap = new HashMap();
  
  public void addCssStyle(CssStyle paramCssStyle)
  {
    this.cssStyleMap.put(paramCssStyle.styleName, paramCssStyle);
  }
  
  public void addInheritStyle(CssStyleSet paramCssStyleSet)
  {
    if (paramCssStyleSet != null)
    {
      paramCssStyleSet = paramCssStyleSet.getCssStyleMap().entrySet().iterator();
      while (paramCssStyleSet.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramCssStyleSet.next();
        if (((CssStyle)localEntry.getValue()).isInherit) {
          addCssStyle((CssStyle)localEntry.getValue());
        }
      }
    }
  }
  
  public Map<String, CssStyle> getCssStyleMap()
  {
    return this.cssStyleMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.htmlcss.CssStyleSet
 * JD-Core Version:    0.7.0.1
 */