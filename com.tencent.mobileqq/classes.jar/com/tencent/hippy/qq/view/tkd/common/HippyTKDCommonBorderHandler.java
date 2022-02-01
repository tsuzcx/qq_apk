package com.tencent.hippy.qq.view.tkd.common;

import com.tencent.mtt.hippy.common.HippyArray;

public class HippyTKDCommonBorderHandler
{
  public static void handleCommonBorderColor(HippyTKDCommonBorderHandler.HippyQBCommonBorder paramHippyQBCommonBorder, String paramString, Object paramObject)
  {
    if ("backgroundColors".equals(paramString)) {
      if ((paramObject instanceof HippyArray))
      {
        paramString = (HippyArray)paramObject;
        paramHippyQBCommonBorder.setBackgroundColors(paramString);
      }
    }
    do
    {
      return;
      paramString = null;
      break;
      if ("borderColors".equals(paramString))
      {
        if ((paramObject instanceof HippyArray)) {}
        for (paramString = (HippyArray)paramObject;; paramString = null)
        {
          paramHippyQBCommonBorder.setBorderColors(paramString);
          return;
        }
      }
      if ("borderLeftColors".equals(paramString))
      {
        if ((paramObject instanceof HippyArray)) {}
        for (paramString = (HippyArray)paramObject;; paramString = null)
        {
          paramHippyQBCommonBorder.setBorderLeftColors(paramString);
          return;
        }
      }
      if ("borderRightColors".equals(paramString))
      {
        if ((paramObject instanceof HippyArray)) {}
        for (paramString = (HippyArray)paramObject;; paramString = null)
        {
          paramHippyQBCommonBorder.setBorderRightColors(paramString);
          return;
        }
      }
      if ("borderTopColors".equals(paramString))
      {
        if ((paramObject instanceof HippyArray)) {}
        for (paramString = (HippyArray)paramObject;; paramString = null)
        {
          paramHippyQBCommonBorder.setBorderTopColors(paramString);
          return;
        }
      }
    } while (!"borderBottomColors".equals(paramString));
    if ((paramObject instanceof HippyArray)) {}
    for (paramString = (HippyArray)paramObject;; paramString = null)
    {
      paramHippyQBCommonBorder.setBorderBottomColors(paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.common.HippyTKDCommonBorderHandler
 * JD-Core Version:    0.7.0.1
 */