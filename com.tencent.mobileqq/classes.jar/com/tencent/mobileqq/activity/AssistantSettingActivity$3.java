package com.tencent.mobileqq.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingActivity$3
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingActivity$3(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = true;
    if (!NetworkUtil.d(this.a.getActivity()))
    {
      AssistantSettingActivity.a(this.a, 2131694510, 1);
      AssistantSettingActivity localAssistantSettingActivity = this.a;
      if (!paramBoolean) {
        AssistantSettingActivity.a(localAssistantSettingActivity, bool, this);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      bool = false;
      break;
      ((CardHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).q(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssistantSettingActivity.3
 * JD-Core Version:    0.7.0.1
 */