package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.nearby.gameroom.GameRoomAVController;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.werewolves.WerewolvesPluginInterface;
import com.tencent.mobileqq.werewolves.WerewolvesPluginManager;

class GameRoomChatPie$3
  implements View.OnTouchListener
{
  GameRoomChatPie$3(GameRoomChatPie paramGameRoomChatPie) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    int i = paramMotionEvent.getAction();
    paramView = this.a.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a();
    if (i == 0)
    {
      this.a.m.setText(HardCodeUtil.a(2131705163));
      this.a.m.setTextColor(this.a.l);
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController.b();
      if (paramView != null) {
        paramView.a(true);
      }
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_wolf", "", "in_game", "wolf_talk", 0, 0, "", "", "", "");
      bool = true;
    }
    while ((i != 3) && (i != 1)) {
      return bool;
    }
    this.a.m.setText(HardCodeUtil.a(2131705102));
    this.a.m.setTextColor(this.a.k);
    this.a.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController.c();
    if (paramView != null) {
      paramView.a(false);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie.3
 * JD-Core Version:    0.7.0.1
 */