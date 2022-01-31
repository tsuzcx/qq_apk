package com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.utils;

import android.content.res.Resources;
import android.util.TypedValue;

public class DynamicUnitUtils
{
  public static int a(float paramFloat)
  {
    return (int)TypedValue.applyDimension(1, paramFloat, Resources.getSystem().getDisplayMetrics());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.utils.DynamicUnitUtils
 * JD-Core Version:    0.7.0.1
 */