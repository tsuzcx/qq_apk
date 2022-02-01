package com.tencent.biz.pubaccount.weishi_new.view;

import android.annotation.TargetApi;
import android.view.View;
import android.view.View.AccessibilityDelegate;

class WSPopupMenuDialog$2
  extends View.AccessibilityDelegate
{
  WSPopupMenuDialog$2(WSPopupMenuDialog paramWSPopupMenuDialog) {}
  
  @TargetApi(14)
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    if (paramInt != 32) {
      super.sendAccessibilityEvent(paramView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.WSPopupMenuDialog.2
 * JD-Core Version:    0.7.0.1
 */