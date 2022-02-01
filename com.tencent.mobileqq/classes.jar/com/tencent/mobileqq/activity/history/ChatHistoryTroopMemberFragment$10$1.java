package com.tencent.mobileqq.activity.history;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ChatHistoryTroopMemberFragment$10$1
  implements View.OnClickListener
{
  ChatHistoryTroopMemberFragment$10$1(ChatHistoryTroopMemberFragment.10 param10) {}
  
  public void onClick(View paramView)
  {
    this.a.a.g = false;
    this.a.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131691933);
    this.a.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.a.a.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.a.a.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.a.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
    this.a.a.d.setVisibility(8);
    this.a.a.d = ((TextView)ChatHistoryTroopMemberFragment.a(this.a.a, 2131369487));
    this.a.a.d.setVisibility(0);
    this.a.a.d.setOnClickListener(this.a.a.b);
    if (this.a.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter != null) {
      this.a.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.10.1
 * JD-Core Version:    0.7.0.1
 */