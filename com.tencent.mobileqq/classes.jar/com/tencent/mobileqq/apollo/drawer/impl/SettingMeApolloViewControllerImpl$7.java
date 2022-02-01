package com.tencent.mobileqq.apollo.drawer.impl;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow;

class SettingMeApolloViewControllerImpl$7
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  SettingMeApolloViewControllerImpl$7(SettingMeApolloViewControllerImpl paramSettingMeApolloViewControllerImpl) {}
  
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      SettingMeApolloViewControllerImpl.access$1500(this.a).getViewTreeObserver().removeOnGlobalLayoutListener(this);
    } else {
      SettingMeApolloViewControllerImpl.access$1500(this.a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
    SettingMeApolloViewControllerImpl.access$1600(this.a).a(SettingMeApolloViewControllerImpl.access$1500(this.a), -ViewUtils.dip2px(10.0F), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.drawer.impl.SettingMeApolloViewControllerImpl.7
 * JD-Core Version:    0.7.0.1
 */