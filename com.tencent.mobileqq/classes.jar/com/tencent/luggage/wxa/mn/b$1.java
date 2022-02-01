package com.tencent.luggage.wxa.mn;

import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.luggage.wxa.qz.af;

final class b$1
  extends View.AccessibilityDelegate
{
  b$1(String paramString1, String paramString2) {}
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfo);
    if (!af.c(this.a)) {
      paramAccessibilityNodeInfo.setContentDescription(this.a);
    }
    if ((!af.c(this.b)) && (this.b.equalsIgnoreCase("button")))
    {
      paramAccessibilityNodeInfo.setClickable(true);
      paramAccessibilityNodeInfo.setClassName(Button.class.getName());
      return;
    }
    paramAccessibilityNodeInfo.setClickable(false);
    paramAccessibilityNodeInfo.setClassName(TextView.class.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mn.b.1
 * JD-Core Version:    0.7.0.1
 */