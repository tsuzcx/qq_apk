package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common;

import java.util.HashMap;

public class ImageCommon
{
  private static HashMap a = new HashMap();
  
  public static Integer a(String paramString)
  {
    return (Integer)a.get(paramString);
  }
  
  public static void a(String paramString, int paramInt)
  {
    a.put(paramString, Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ImageCommon
 * JD-Core Version:    0.7.0.1
 */