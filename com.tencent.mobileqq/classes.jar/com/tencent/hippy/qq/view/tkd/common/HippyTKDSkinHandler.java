package com.tencent.hippy.qq.view.tkd.common;

import android.view.View;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.views.common.CommonBorder;
import com.tencent.mtt.hippy.views.common.CommonBorder.BorderWidthDirection;

public class HippyTKDSkinHandler
{
  HippyArray mBackgroundColors;
  HippyArray mBorderBottomColors;
  HippyArray mBorderColors;
  HippyArray mBorderLeftColors;
  HippyArray mBorderRightColors;
  HippyArray mBorderTopColors;
  
  public static int getColor(HippyArray paramHippyArray)
  {
    if ((paramHippyArray != null) && (paramHippyArray.size() > 0))
    {
      int j = paramHippyArray.getInt(0);
      int i = j;
      if (ThemeUtil.isNowThemeIsNight(null, false, ""))
      {
        i = j;
        if (paramHippyArray.size() > 1) {
          i = paramHippyArray.getInt(1);
        }
      }
      return i;
    }
    return 0;
  }
  
  public static String getSource(HippyArray paramHippyArray)
  {
    if ((paramHippyArray != null) && (paramHippyArray.size() > 0))
    {
      String str2 = paramHippyArray.getString(0);
      String str1 = str2;
      if (ThemeUtil.isNowThemeIsNight(null, false, ""))
      {
        str1 = str2;
        if (paramHippyArray.size() > 1) {
          str1 = paramHippyArray.getString(1);
        }
      }
      return str1;
    }
    return null;
  }
  
  public HippyArray getBackgroundColors()
  {
    return this.mBackgroundColors;
  }
  
  public void setBackgroundColors(View paramView, HippyArray paramHippyArray)
  {
    this.mBackgroundColors = paramHippyArray;
    paramView.setBackgroundColor(getColor(this.mBackgroundColors));
  }
  
  public void setBorderBottomColors(CommonBorder paramCommonBorder, HippyArray paramHippyArray)
  {
    this.mBorderBottomColors = paramHippyArray;
    paramCommonBorder.setBorderColor(getColor(this.mBorderBottomColors), CommonBorder.BorderWidthDirection.BOTTOM.ordinal());
  }
  
  public void setBorderColors(CommonBorder paramCommonBorder, HippyArray paramHippyArray)
  {
    this.mBorderColors = paramHippyArray;
    paramCommonBorder.setBorderColor(getColor(this.mBorderColors), CommonBorder.BorderWidthDirection.ALL.ordinal());
  }
  
  public void setBorderLeftColors(CommonBorder paramCommonBorder, HippyArray paramHippyArray)
  {
    this.mBorderLeftColors = paramHippyArray;
    paramCommonBorder.setBorderColor(getColor(this.mBorderLeftColors), CommonBorder.BorderWidthDirection.LEFT.ordinal());
  }
  
  public void setBorderRightColors(CommonBorder paramCommonBorder, HippyArray paramHippyArray)
  {
    this.mBorderRightColors = paramHippyArray;
    paramCommonBorder.setBorderColor(getColor(this.mBorderRightColors), CommonBorder.BorderWidthDirection.RIGHT.ordinal());
  }
  
  public void setBorderTopColors(CommonBorder paramCommonBorder, HippyArray paramHippyArray)
  {
    this.mBorderTopColors = paramHippyArray;
    paramCommonBorder.setBorderColor(getColor(this.mBorderTopColors), CommonBorder.BorderWidthDirection.TOP.ordinal());
  }
  
  public void switchSkin(View paramView)
  {
    HippyArray localHippyArray = this.mBackgroundColors;
    if (localHippyArray != null) {
      setBackgroundColors(paramView, localHippyArray);
    }
    localHippyArray = this.mBorderColors;
    if ((localHippyArray != null) && ((paramView instanceof CommonBorder))) {
      setBorderColors((CommonBorder)paramView, localHippyArray);
    }
    localHippyArray = this.mBorderLeftColors;
    if ((localHippyArray != null) && ((paramView instanceof CommonBorder))) {
      setBorderLeftColors((CommonBorder)paramView, localHippyArray);
    }
    localHippyArray = this.mBorderTopColors;
    if ((localHippyArray != null) && ((paramView instanceof CommonBorder))) {
      setBorderTopColors((CommonBorder)paramView, localHippyArray);
    }
    localHippyArray = this.mBorderRightColors;
    if ((localHippyArray != null) && ((paramView instanceof CommonBorder))) {
      setBorderRightColors((CommonBorder)paramView, localHippyArray);
    }
    localHippyArray = this.mBorderBottomColors;
    if ((localHippyArray != null) && ((paramView instanceof CommonBorder))) {
      setBorderBottomColors((CommonBorder)paramView, localHippyArray);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.common.HippyTKDSkinHandler
 * JD-Core Version:    0.7.0.1
 */