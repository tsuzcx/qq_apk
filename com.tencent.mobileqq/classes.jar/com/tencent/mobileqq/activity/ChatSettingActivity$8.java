package com.tencent.mobileqq.activity;

import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.msgbox.FilterMsgBoxObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class ChatSettingActivity$8
  extends FilterMsgBoxObserver
{
  ChatSettingActivity$8(ChatSettingActivity paramChatSettingActivity) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    super.onUpdate(paramInt, paramBoolean, paramObject);
    if (paramInt == 0)
    {
      QQToast.makeText(BaseApplication.getContext(), 2131897214, 0).show();
      if (this.a.y != null) {
        this.a.y.setVisibility(8);
      }
      if (ChatSettingActivity.j(this.a) != null) {
        ChatSettingActivity.j(this.a).setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity.8
 * JD-Core Version:    0.7.0.1
 */