package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.htmlcss;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;

public class CssStyle
{
  public boolean isInherit;
  public String styleName;
  public Object styleValue;
  
  public static CssStyle createStyle(String paramString1, String paramString2)
  {
    CssStyle localCssStyle = new CssStyle();
    localCssStyle.styleName = paramString1;
    int i = -1;
    switch (paramString1.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        localCssStyle.styleValue = paramString2;
        localCssStyle.isInherit = true;
        return localCssStyle;
        if (paramString1.equals("line-height"))
        {
          i = 0;
          continue;
          if (paramString1.equals("font-size"))
          {
            i = 1;
            continue;
            if (paramString1.equals("color"))
            {
              i = 2;
              continue;
              if (paramString1.equals("width"))
              {
                i = 3;
                continue;
                if (paramString1.equals("height"))
                {
                  i = 4;
                  continue;
                  if (paramString1.equals("-webkit-line-clamp")) {
                    i = 5;
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    localCssStyle.styleValue = getSize(paramString2);
    localCssStyle.isInherit = true;
    return localCssStyle;
    localCssStyle.styleValue = getSize(paramString2);
    localCssStyle.isInherit = true;
    return localCssStyle;
    localCssStyle.styleValue = paramString2;
    localCssStyle.isInherit = true;
    return localCssStyle;
    localCssStyle.styleValue = getSize(paramString2);
    return localCssStyle;
    localCssStyle.styleValue = getSize(paramString2);
    return localCssStyle;
    localCssStyle.styleValue = Integer.valueOf(paramString2);
    localCssStyle.isInherit = true;
    return localCssStyle;
  }
  
  public static CssStyle getDisplay(boolean paramBoolean)
  {
    CssStyle localCssStyle = new CssStyle();
    localCssStyle.styleName = "display";
    if (paramBoolean)
    {
      localCssStyle.styleValue = "block";
      return localCssStyle;
    }
    localCssStyle.styleValue = "inline";
    return localCssStyle;
  }
  
  private static Object getSize(String paramString)
  {
    Integer localInteger = null;
    if (paramString.endsWith("rpx")) {
      localInteger = Integer.valueOf(Utils.rp2px(Integer.valueOf(paramString.substring(0, paramString.length() - 3).trim()).intValue()) / 2);
    }
    while (!paramString.endsWith("px")) {
      return localInteger;
    }
    return Integer.valueOf(Utils.dp2px(Integer.valueOf(paramString.substring(0, paramString.length() - 2)).intValue()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.htmlcss.CssStyle
 * JD-Core Version:    0.7.0.1
 */