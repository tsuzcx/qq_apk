package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GameMsgChatPie$7
  implements View.OnClickListener
{
  GameMsgChatPie$7(GameMsgChatPie paramGameMsgChatPie) {}
  
  public void onClick(View paramView)
  {
    GameMsgChatPie.o(this.a);
    this.a.bG();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie.7
 * JD-Core Version:    0.7.0.1
 */