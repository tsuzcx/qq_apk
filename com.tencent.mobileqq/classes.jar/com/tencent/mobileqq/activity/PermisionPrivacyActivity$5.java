package com.tencent.mobileqq.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PermisionPrivacyActivity$5
  implements CompoundButton.OnCheckedChangeListener
{
  PermisionPrivacyActivity$5(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = true;
    if (!NetworkUtil.g(this.a))
    {
      QQToast.a(BaseApplication.getContext(), 1, 2131694511, 0).b(this.a.getTitleBarHeight());
      FormSwitchItem localFormSwitchItem = this.a.j;
      if (!paramBoolean) {
        localFormSwitchItem.setChecked(bool);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      bool = false;
      break;
      ((CardHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).g(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PermisionPrivacyActivity.5
 * JD-Core Version:    0.7.0.1
 */