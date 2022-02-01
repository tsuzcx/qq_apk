package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticonview.EmotionPanelConstans;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ChatHistory$ChatHistoryAdapter$6
  implements View.OnClickListener
{
  ChatHistory$ChatHistoryAdapter$6(ChatHistory.ChatHistoryAdapter paramChatHistoryAdapter, IPicEmoticonInfo paramIPicEmoticonInfo) {}
  
  public void onClick(View paramView)
  {
    if ((paramView != null) && ((paramView instanceof ImageView)))
    {
      View localView = (View)paramView.getParent();
      Object localObject = paramView.getTag();
      String str = EmotionPanelConstans.emoticonSoundPath.replace("[epId]", this.a.getEmoticon().epId).replace("[eId]", this.a.getEmoticon().eId);
      if (this.b.f.al == null) {
        this.b.f.al = new ChatHistory.PlayingPttHistoryInfo(this.b.f);
      }
      this.b.f.al.a(1, localView, localObject, str);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter.6
 * JD-Core Version:    0.7.0.1
 */