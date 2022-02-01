package com.tencent.hippy.qq.view.tkd.common;

import com.tencent.mtt.hippy.common.HippyArray;

public class HippyTKDCommonBorderHandler
{
  public static void handleCommonBorderColor(HippyTKDCommonBorderHandler.HippyQBCommonBorder paramHippyQBCommonBorder, String paramString, Object paramObject)
  {
    boolean bool = "backgroundColors".equals(paramString);
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject6 = null;
    Object localObject1 = null;
    if (bool)
    {
      paramString = localObject1;
      if ((paramObject instanceof HippyArray)) {
        paramString = (HippyArray)paramObject;
      }
      paramHippyQBCommonBorder.setBackgroundColors(paramString);
      return;
    }
    if ("borderColors".equals(paramString))
    {
      paramString = localObject2;
      if ((paramObject instanceof HippyArray)) {
        paramString = (HippyArray)paramObject;
      }
      paramHippyQBCommonBorder.setBorderColors(paramString);
      return;
    }
    if ("borderLeftColors".equals(paramString))
    {
      paramString = localObject3;
      if ((paramObject instanceof HippyArray)) {
        paramString = (HippyArray)paramObject;
      }
      paramHippyQBCommonBorder.setBorderLeftColors(paramString);
      return;
    }
    if ("borderRightColors".equals(paramString))
    {
      paramString = localObject4;
      if ((paramObject instanceof HippyArray)) {
        paramString = (HippyArray)paramObject;
      }
      paramHippyQBCommonBorder.setBorderRightColors(paramString);
      return;
    }
    if ("borderTopColors".equals(paramString))
    {
      paramString = localObject5;
      if ((paramObject instanceof HippyArray)) {
        paramString = (HippyArray)paramObject;
      }
      paramHippyQBCommonBorder.setBorderTopColors(paramString);
      return;
    }
    if ("borderBottomColors".equals(paramString))
    {
      paramString = localObject6;
      if ((paramObject instanceof HippyArray)) {
        paramString = (HippyArray)paramObject;
      }
      paramHippyQBCommonBorder.setBorderBottomColors(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.common.HippyTKDCommonBorderHandler
 * JD-Core Version:    0.7.0.1
 */