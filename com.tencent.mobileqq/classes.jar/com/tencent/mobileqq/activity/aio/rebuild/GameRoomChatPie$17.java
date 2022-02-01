package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.werewolves.WerewolvesPluginInterface;
import com.tencent.mobileqq.werewolves.WerewolvesPluginManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GameRoomChatPie$17
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if ((paramView == this.a) && (this.c.bC.c() != null)) {
      this.c.bC.c().g();
    } else if ((paramView == this.b) && (this.c.bC.c() != null)) {
      this.c.bC.c().m();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie.17
 * JD-Core Version:    0.7.0.1
 */