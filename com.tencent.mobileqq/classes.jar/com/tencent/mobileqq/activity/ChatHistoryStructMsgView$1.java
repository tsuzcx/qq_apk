package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.adapter.ChatHistoryStructAdapter;
import com.tencent.mobileqq.adapter.ChatHistoryStructAdapter.HistoryStructItemHolder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.GeneralClickHandler;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ChatHistoryStructMsgView$1
  implements View.OnClickListener
{
  ChatHistoryStructMsgView$1(ChatHistoryStructMsgView paramChatHistoryStructMsgView) {}
  
  public void onClick(View paramView)
  {
    if (!(paramView.getTag() instanceof String))
    {
      Object localObject1 = (ChatMessage)((ChatHistoryStructAdapter.HistoryStructItemHolder)paramView.getTag()).f;
      if (this.a.i())
      {
        if (this.a.D.c((ChatMessage)localObject1))
        {
          this.a.D.d((ChatMessage)localObject1);
        }
        else
        {
          if (this.a.D.b()) {
            break label229;
          }
          this.a.D.b((ChatMessage)localObject1);
        }
      }
      else if ((localObject1 instanceof MessageForStructing))
      {
        localObject1 = (MessageForStructing)localObject1;
        if ((((MessageForStructing)localObject1).structingMsg != null) && ((((MessageForStructing)localObject1).structingMsg instanceof AbsShareMsg)))
        {
          localObject1 = (AbsShareMsg)((MessageForStructing)localObject1).structingMsg;
          Object localObject2;
          if ((localObject1 instanceof StructMsgForGeneralShare))
          {
            localObject2 = (StructMsgForGeneralShare)localObject1;
            StructMsgForGeneralShare.GeneralClickHandler localGeneralClickHandler = new StructMsgForGeneralShare.GeneralClickHandler(this.a.b, paramView, (StructMsgForGeneralShare)localObject2);
            StructMsgForGeneralShare.onClickEvent(this.a.b, this.a.c, (StructMsgForGeneralShare)localObject2, paramView, localGeneralClickHandler);
          }
          else if ((localObject1 instanceof StructMsgForAudioShare))
          {
            localObject2 = (StructMsgForAudioShare)localObject1;
            StructMsgForAudioShare.onClickEvent(this.a.c, (StructMsgForAudioShare)localObject2);
          }
          ((AbsShareMsg)localObject1).getOnClickListener().onClick(paramView);
        }
      }
      this.a.e.notifyDataSetChanged();
    }
    label229:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryStructMsgView.1
 * JD-Core Version:    0.7.0.1
 */