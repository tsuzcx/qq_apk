package com.tencent.mobileqq.ark.browser;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ArkWebModule$3
  implements View.OnClickListener
{
  ArkWebModule$3(ArkWebModule paramArkWebModule) {}
  
  public void onClick(View paramView)
  {
    DoraemonUtil.a(ArkWebModule.a(this.a), -3, "user canceled");
    ArkWebModule.a(this.a).a();
    ArkWebModule.a(this.a).dismiss();
    ArkWebModule.a(this.a, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.browser.ArkWebModule.3
 * JD-Core Version:    0.7.0.1
 */