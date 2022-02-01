package com.tencent.mobileqq.activity.history;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.history.helper.ChatHistoryItemSelectHelper;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.GeneralClickHandler;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ChatHistoryC2CLinkFragment$1
  implements View.OnClickListener
{
  ChatHistoryC2CLinkFragment$1(ChatHistoryC2CLinkFragment paramChatHistoryC2CLinkFragment) {}
  
  public void onClick(View paramView)
  {
    if (!(paramView.getTag() instanceof String))
    {
      Object localObject1 = (ChatMessage)((ChatHistoryC2CLinkAdapter.HistoryStructItemHolder)paramView.getTag()).g;
      if (this.a.i)
      {
        this.a.j.b(localObject1);
        this.a.x.notifyDataSetChanged();
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
            StructMsgForGeneralShare.GeneralClickHandler localGeneralClickHandler = new StructMsgForGeneralShare.GeneralClickHandler(this.a.u, paramView, (StructMsgForGeneralShare)localObject2);
            StructMsgForGeneralShare.onClickEvent(this.a.u, this.a.v, (StructMsgForGeneralShare)localObject2, paramView, localGeneralClickHandler);
          }
          else if ((localObject1 instanceof StructMsgForAudioShare))
          {
            localObject2 = (StructMsgForAudioShare)localObject1;
            StructMsgForAudioShare.onClickEvent(this.a.v, (StructMsgForAudioShare)localObject2);
          }
          ((AbsShareMsg)localObject1).getOnClickListener().onClick(paramView);
        }
      }
      this.a.x.notifyDataSetChanged();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CLinkFragment.1
 * JD-Core Version:    0.7.0.1
 */