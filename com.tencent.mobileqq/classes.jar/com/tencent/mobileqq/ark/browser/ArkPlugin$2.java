package com.tencent.mobileqq.ark.browser;

import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ArkPlugin$2
  implements View.OnClickListener
{
  ArkPlugin$2(ArkPlugin paramArkPlugin) {}
  
  public void onClick(View paramView)
  {
    if ((ArkPlugin.a(this.a) == 0) && (!TextUtils.isEmpty(ArkPlugin.b(this.a)))) {
      ArkPlugin.a(this.a, null);
    }
    ArkPlugin.a(this.a).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.browser.ArkPlugin.2
 * JD-Core Version:    0.7.0.1
 */