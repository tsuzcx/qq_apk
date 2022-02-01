package com.tencent.mobileqq.activity.history;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ChatHistoryTroopMemberFragment$38
  implements View.OnClickListener
{
  ChatHistoryTroopMemberFragment$38(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
    if ((localDialog != null) && (localDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.38
 * JD-Core Version:    0.7.0.1
 */