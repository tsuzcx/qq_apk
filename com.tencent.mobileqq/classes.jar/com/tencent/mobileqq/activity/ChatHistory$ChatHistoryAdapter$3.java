package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ChatHistory$ChatHistoryAdapter$3
  implements View.OnClickListener
{
  ChatHistory$ChatHistoryAdapter$3(ChatHistory.ChatHistoryAdapter paramChatHistoryAdapter, String paramString) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.app.vibratorAndAudioForShake(this.jdField_a_of_type_JavaLangString, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter.3
 * JD-Core Version:    0.7.0.1
 */