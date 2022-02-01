package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ChatHistory$ChatHistoryAdapter$7
  implements View.OnClickListener
{
  ChatHistory$ChatHistoryAdapter$7(ChatHistory.ChatHistoryAdapter paramChatHistoryAdapter, MessageRecord paramMessageRecord) {}
  
  public void onClick(View paramView)
  {
    AIOEmotionFragment.a(paramView.getContext(), this.a, this.b.f.K, AnimationUtils.a(paramView));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter.7
 * JD-Core Version:    0.7.0.1
 */