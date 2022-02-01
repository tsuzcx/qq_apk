package com.tencent.biz.qqcircle.richframework.util;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;

public class AccessibilityUtil
{
  @TargetApi(14)
  public static void a(View paramView, CharSequence paramCharSequence, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      paramView.setAccessibilityDelegate(new AccessibilityUtil.7(paramCharSequence, paramString));
    }
  }
  
  public static void a(View paramView, String paramString)
  {
    a(paramView, null, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.util.AccessibilityUtil
 * JD-Core Version:    0.7.0.1
 */