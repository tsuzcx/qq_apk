package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ChatHistory$ChatHistoryAdapter$6
  implements View.OnClickListener
{
  ChatHistory$ChatHistoryAdapter$6(ChatHistory.ChatHistoryAdapter paramChatHistoryAdapter, PicEmoticonInfo paramPicEmoticonInfo) {}
  
  public void onClick(View paramView)
  {
    if ((paramView != null) && ((paramView instanceof ImageView)))
    {
      View localView = (View)paramView.getParent();
      Object localObject = paramView.getTag();
      String str = EmoticonUtils.emoticonSoundPath.replace("[epId]", this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId).replace("[eId]", this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.eId);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.a == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.a = new ChatHistory.PlayingPttHistoryInfo(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.a.a(1, localView, localObject, str);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter.6
 * JD-Core Version:    0.7.0.1
 */