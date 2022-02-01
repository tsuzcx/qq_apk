package com.tencent.mobileqq.activity.history;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;

class ChatHistoryTroopMediaFragment$2
  implements DialogInterface.OnClickListener
{
  ChatHistoryTroopMediaFragment$2(ChatHistoryTroopMediaFragment paramChatHistoryTroopMediaFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.getBaseActivity().setResult(8001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMediaFragment.2
 * JD-Core Version:    0.7.0.1
 */