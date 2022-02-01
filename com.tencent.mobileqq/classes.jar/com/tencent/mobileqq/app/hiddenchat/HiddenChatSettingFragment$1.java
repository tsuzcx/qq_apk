package com.tencent.mobileqq.app.hiddenchat;

import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class HiddenChatSettingFragment$1
  extends CardObserver
{
  HiddenChatSettingFragment$1(HiddenChatSettingFragment paramHiddenChatSettingFragment) {}
  
  public void onSetHiddenSession(boolean paramBoolean, int paramInt)
  {
    super.onSetHiddenSession(paramBoolean, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("HiddenChatSetting", 2, "onSetHiddenSession " + paramBoolean + " type=" + paramInt);
    }
    if (paramInt == 42318) {
      if (!paramBoolean) {
        HiddenChatSettingFragment.a(this.a, HiddenChatSettingFragment.a(this.a), HiddenChatUtil.a(HiddenChatSettingFragment.a(this.a).getCurrentUin(), this.a.getActivity()));
      }
    }
    while ((paramInt != 42319) || (paramBoolean)) {
      return;
    }
    HiddenChatSettingFragment.a(this.a, HiddenChatSettingFragment.b(this.a), HiddenChatUtil.b(HiddenChatSettingFragment.a(this.a).getCurrentUin(), this.a.getActivity()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.hiddenchat.HiddenChatSettingFragment.1
 * JD-Core Version:    0.7.0.1
 */