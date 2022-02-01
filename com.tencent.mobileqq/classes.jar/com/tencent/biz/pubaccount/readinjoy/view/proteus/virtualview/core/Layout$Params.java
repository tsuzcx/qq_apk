package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.valueitem.SizeValue;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil.QLog;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;

public class Layout$Params
{
  public int mLayoutHeight = -2;
  public int mLayoutMarginBottom = 0;
  public int mLayoutMarginLeft = 0;
  public int mLayoutMarginRight = 0;
  public int mLayoutMarginTop = 0;
  public int mLayoutWidth = -1;
  
  private static int strAttributeToPx(String paramString)
  {
    if (paramString == null) {
      return 0;
    }
    try
    {
      int i = Utils.rp2px(Double.valueOf(paramString).doubleValue());
      return i;
    }
    catch (NumberFormatException paramString)
    {
      LogUtil.QLog.d("Layout_TMTEST", 2, "strAttributeToPx: " + paramString.getMessage());
    }
    return 0;
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      this.mLayoutWidth = ((SizeValue)paramObject).getLayoutSize();
      return true;
    }
    this.mLayoutHeight = ((SizeValue)paramObject).getLayoutSize();
    return true;
  }
  
  public boolean setAttribute(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
    case 3: 
    case 5: 
    case 6: 
    case 4: 
      for (;;)
      {
        return false;
        this.mLayoutMarginTop = strAttributeToPx(paramString);
        continue;
        this.mLayoutMarginRight = strAttributeToPx(paramString);
        continue;
        this.mLayoutMarginBottom = strAttributeToPx(paramString);
        continue;
        this.mLayoutMarginLeft = strAttributeToPx(paramString);
      }
    case 58: 
      this.mLayoutHeight = SizeValue.getLayoutSize(1004, Double.valueOf(paramString).doubleValue());
      return true;
    case 59: 
      this.mLayoutWidth = SizeValue.getLayoutSize(1004, Double.valueOf(paramString).doubleValue());
      return true;
    case 60: 
      this.mLayoutHeight = SizeValue.getLayoutSize(1003, Double.valueOf(paramString).doubleValue());
      return true;
    }
    this.mLayoutWidth = SizeValue.getLayoutSize(1003, Double.valueOf(paramString).doubleValue());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params
 * JD-Core Version:    0.7.0.1
 */