package com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityNodeInfo;

class TroopRelevantHandler$1
  extends View.AccessibilityDelegate
{
  TroopRelevantHandler$1(TroopRelevantHandler paramTroopRelevantHandler) {}
  
  @TargetApi(16)
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      paramAccessibilityNodeInfo.setVisibleToUser(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler.TroopRelevantHandler.1
 * JD-Core Version:    0.7.0.1
 */