package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GameMsgChatPie$6
  implements View.OnClickListener
{
  GameMsgChatPie$6(GameMsgChatPie paramGameMsgChatPie) {}
  
  public void onClick(View paramView)
  {
    GameMsgChatPie.o(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie.6
 * JD-Core Version:    0.7.0.1
 */