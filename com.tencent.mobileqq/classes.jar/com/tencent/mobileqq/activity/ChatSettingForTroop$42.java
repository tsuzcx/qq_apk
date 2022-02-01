package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.qphone.base.util.QLog;

class ChatSettingForTroop$42
  implements View.OnLongClickListener
{
  ChatSettingForTroop$42(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public boolean onLongClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "setTroopUinTextViewClickListener onLongClick");
    }
    ChatSettingForTroop.p(this.a);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.42
 * JD-Core Version:    0.7.0.1
 */