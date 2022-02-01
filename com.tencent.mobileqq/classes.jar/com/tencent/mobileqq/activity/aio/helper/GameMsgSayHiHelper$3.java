package com.tencent.mobileqq.activity.aio.helper;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GameMsgSayHiHelper$3
  implements View.OnClickListener
{
  GameMsgSayHiHelper$3(GameMsgSayHiHelper paramGameMsgSayHiHelper) {}
  
  public void onClick(View paramView)
  {
    this.a.a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.GameMsgSayHiHelper.3
 * JD-Core Version:    0.7.0.1
 */