package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.nearby.gameroom.IGameRoomAVControllerDelegate;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.werewolves.WerewolvesPluginInterface;
import com.tencent.mobileqq.werewolves.WerewolvesPluginManager;

class GameRoomChatPie$3
  implements View.OnTouchListener
{
  GameRoomChatPie$3(GameRoomChatPie paramGameRoomChatPie) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    paramView = this.a.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a();
    if (i == 0)
    {
      this.a.i.setText(HardCodeUtil.a(2131705240));
      this.a.i.setTextColor(this.a.h);
      ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).startSpeak();
      if (paramView != null) {
        paramView.a(true);
      }
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_wolf", "", "in_game", "wolf_talk", 0, 0, "", "", "", "");
      return true;
    }
    if ((i != 3) && (i != 1)) {
      return false;
    }
    this.a.i.setText(HardCodeUtil.a(2131705179));
    this.a.i.setTextColor(this.a.g);
    ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).stopSpeak();
    if (paramView != null) {
      paramView.a(false);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie.3
 * JD-Core Version:    0.7.0.1
 */