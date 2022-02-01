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
    if ((paramView == this.jdField_a_of_type_AndroidWidgetButton) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie.a.a() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie.a.a().c();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((paramView == this.b) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie.a.a() != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie.a.a().f();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie.17
 * JD-Core Version:    0.7.0.1
 */