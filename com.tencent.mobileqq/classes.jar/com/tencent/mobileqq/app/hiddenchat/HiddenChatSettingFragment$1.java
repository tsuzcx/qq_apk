package com.tencent.mobileqq.app.hiddenchat;

import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class HiddenChatSettingFragment$1
  extends CardObserver
{
  HiddenChatSettingFragment$1(HiddenChatSettingFragment paramHiddenChatSettingFragment) {}
  
  protected void onSetHiddenSession(boolean paramBoolean, int paramInt)
  {
    super.onSetHiddenSession(paramBoolean, paramInt);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSetHiddenSession ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" type=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("HiddenChatSetting", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt == 42318)
    {
      if (!paramBoolean)
      {
        localObject = this.a;
        HiddenChatSettingFragment.a((HiddenChatSettingFragment)localObject, HiddenChatSettingFragment.a((HiddenChatSettingFragment)localObject), HiddenChatUtil.a(HiddenChatSettingFragment.a(this.a).getCurrentUin(), this.a.getBaseActivity()));
      }
    }
    else if ((paramInt == 42319) && (!paramBoolean))
    {
      localObject = this.a;
      HiddenChatSettingFragment.a((HiddenChatSettingFragment)localObject, HiddenChatSettingFragment.b((HiddenChatSettingFragment)localObject), HiddenChatUtil.b(HiddenChatSettingFragment.a(this.a).getCurrentUin(), this.a.getBaseActivity()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.hiddenchat.HiddenChatSettingFragment.1
 * JD-Core Version:    0.7.0.1
 */