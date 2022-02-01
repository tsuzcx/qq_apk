package com.tencent.mobileqq.activity.history;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ChatHistoryTroopMemberFragment$14
  implements View.OnClickListener
{
  ChatHistoryTroopMemberFragment$14(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    ChatHistoryTroopMemberFragment localChatHistoryTroopMemberFragment = this.a;
    localChatHistoryTroopMemberFragment.f = false;
    localChatHistoryTroopMemberFragment.u = "";
    localChatHistoryTroopMemberFragment.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (this.a.d != 22) {
      this.a.b.setVisibility(0);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.14
 * JD-Core Version:    0.7.0.1
 */