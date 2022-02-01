package com.tencent.biz.pubaccount.util.api.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;

class PublicAccountH5AbilityPluginImpl$21
  implements View.OnClickListener
{
  PublicAccountH5AbilityPluginImpl$21(PublicAccountH5AbilityPluginImpl paramPublicAccountH5AbilityPluginImpl) {}
  
  public void onClick(View paramView)
  {
    this.a.paActionSheet.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl.21
 * JD-Core Version:    0.7.0.1
 */