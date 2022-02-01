package com.tencent.mobileqq.activity;

import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.msgbox.FilterMsgBoxObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class ChatSettingActivity$7
  extends FilterMsgBoxObserver
{
  ChatSettingActivity$7(ChatSettingActivity paramChatSettingActivity) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    super.onUpdate(paramInt, paramBoolean, paramObject);
    if (paramInt == 0)
    {
      QQToast.a(BaseApplication.getContext(), 2131699091, 0).a();
      if (this.a.e != null) {
        this.a.e.setVisibility(8);
      }
      if (ChatSettingActivity.b(this.a) != null) {
        ChatSettingActivity.b(this.a).setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity.7
 * JD-Core Version:    0.7.0.1
 */