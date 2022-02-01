package com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityNodeInfo;

class NickHandler$1
  extends View.AccessibilityDelegate
{
  NickHandler$1(NickHandler paramNickHandler) {}
  
  @TargetApi(16)
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      paramAccessibilityNodeInfo.setVisibleToUser(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.NickHandler.1
 * JD-Core Version:    0.7.0.1
 */