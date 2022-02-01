package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils;

import android.text.TextUtils;

public class AssertUtil
{
  private static final String TAG = "AssertUtil";
  private static AssertUtil.IAssertUtil assertUtil;
  private static final String[] attributesBlackList = { "margin_left", "margin_top", "margin_right", "margin_bottom", "view_id", "event_type", "height", "width", "value", "default_visible" };
  private static boolean isDebugVersion = false;
  
  public static void assertInValidAttributesBinding(String paramString)
  {
    if (!isDebugVersion) {}
    for (;;)
    {
      return;
      if (assertUtil != null)
      {
        String[] arrayOfString = attributesBlackList;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          if (TextUtils.equals(arrayOfString[i], paramString))
          {
            assertUtil.assertInValidAttributesBinding(paramString);
            return;
          }
          i += 1;
        }
      }
    }
  }
  
  public static boolean isDebugVersion()
  {
    return isDebugVersion;
  }
  
  public static void registerAssertUtil(AssertUtil.IAssertUtil paramIAssertUtil)
  {
    if (paramIAssertUtil != null) {}
    for (boolean bool = true;; bool = false)
    {
      isDebugVersion = bool;
      assertUtil = paramIAssertUtil;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.AssertUtil
 * JD-Core Version:    0.7.0.1
 */