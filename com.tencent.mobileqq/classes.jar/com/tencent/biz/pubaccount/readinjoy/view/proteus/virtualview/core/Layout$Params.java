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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("strAttributeToPx: ");
      localStringBuilder.append(paramString.getMessage());
      LogUtil.QLog.d("Layout_TMTEST", 2, localStringBuilder.toString());
    }
    return 0;
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return false;
      }
      this.mLayoutHeight = ((SizeValue)paramObject).getLayoutSize();
      return true;
    }
    this.mLayoutWidth = ((SizeValue)paramObject).getLayoutSize();
    return true;
  }
  
  public boolean setAttribute(int paramInt, String paramString)
  {
    if (paramInt != 3)
    {
      if (paramInt != 4)
      {
        if (paramInt != 5)
        {
          if (paramInt != 6) {
            switch (paramInt)
            {
            default: 
              break;
            case 61: 
              this.mLayoutWidth = SizeValue.getLayoutSize(1003, Double.valueOf(paramString).doubleValue());
              return true;
            case 60: 
              this.mLayoutHeight = SizeValue.getLayoutSize(1003, Double.valueOf(paramString).doubleValue());
              return true;
            case 59: 
              this.mLayoutWidth = SizeValue.getLayoutSize(1004, Double.valueOf(paramString).doubleValue());
              return true;
            case 58: 
              this.mLayoutHeight = SizeValue.getLayoutSize(1004, Double.valueOf(paramString).doubleValue());
              return true;
            }
          } else {
            this.mLayoutMarginBottom = strAttributeToPx(paramString);
          }
        }
        else {
          this.mLayoutMarginRight = strAttributeToPx(paramString);
        }
      }
      else {
        this.mLayoutMarginLeft = strAttributeToPx(paramString);
      }
    }
    else {
      this.mLayoutMarginTop = strAttributeToPx(paramString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params
 * JD-Core Version:    0.7.0.1
 */