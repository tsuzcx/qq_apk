package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common;

import java.util.HashMap;

public class ImageCommon
{
  public static final int SCALE_TYPE_CENTER_CROP = 2;
  public static final int SCALE_TYPE_FIT_XY = 1;
  private static HashMap<String, Integer> sImageResourceNameMap = new HashMap();
  
  public static Integer getDrawableResourceId(String paramString)
  {
    return (Integer)sImageResourceNameMap.get(paramString);
  }
  
  public static void registerDrawable(String paramString, int paramInt)
  {
    sImageResourceNameMap.put(paramString, Integer.valueOf(paramInt));
  }
  
  public static void registerResource(String paramString, int paramInt)
  {
    registerDrawable(paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ImageCommon
 * JD-Core Version:    0.7.0.1
 */