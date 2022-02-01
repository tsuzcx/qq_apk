package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.htmlcss;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CssStyleSet
{
  public static final String A_STYLE = "a";
  public static final String BLOCK_STYLE = "block";
  public static final String BOLD_STYLE = "bold";
  public static final String CLAMP_STYLE = "-webkit-line-clamp";
  public static final String COLOR_STYLE = "color";
  public static final String DISPLAY_STYLE = "display";
  public static final String DIV_STYLE = "div";
  public static final String FONT_SIZE_STYLE = "font-size";
  public static final String FONT_WEIGHT_STYLE = "font-weight";
  public static final String HEIGHT_STYLE = "height";
  public static final String HREF_STYLE = "href";
  public static final String INLINE_STYLE = "inline";
  public static final String LINE_HEIGHT_STYLE = "line-height";
  public static final String P_STYLE = "p";
  public static final String RATIO_STYLE = "ratio";
  public static final String STRONG_STYLE = "strong";
  public static final String WIDTH_STYLE = "width";
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.htmlcss.CssStyleSet
 * JD-Core Version:    0.7.0.1
 */