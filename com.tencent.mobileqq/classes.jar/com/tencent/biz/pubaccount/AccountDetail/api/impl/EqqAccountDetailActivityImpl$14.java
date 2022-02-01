package com.tencent.biz.pubaccount.accountdetail.api.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr.PaConfigInfo;

class EqqAccountDetailActivityImpl$14
  implements View.OnClickListener
{
  EqqAccountDetailActivityImpl$14(EqqAccountDetailActivityImpl paramEqqAccountDetailActivityImpl, IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo) {}
  
  public void onClick(View paramView)
  {
    this.b.selectedState = this.a.f;
    paramView = this.b;
    paramView.showMessageSettingActionSheet(this.a, paramView.selectedState);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.EqqAccountDetailActivityImpl.14
 * JD-Core Version:    0.7.0.1
 */