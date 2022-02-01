package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.nearby.gameroom.IGameRoomAVControllerDelegate;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.werewolves.WerewolvesPluginInterface;
import com.tencent.mobileqq.werewolves.WerewolvesPluginManager;

class GameRoomChatPie$1
  implements View.OnTouchListener
{
  GameRoomChatPie$1(GameRoomChatPie paramGameRoomChatPie) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    paramView = this.a.bC.c();
    if (i == 0)
    {
      if ((paramView != null) && (paramView.f()))
      {
        this.a.bu.setText(HardCodeUtil.a(2131903080));
        this.a.bu.setPressed(true);
        ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).startSpeak();
        paramView.a(true);
        return true;
      }
      this.a.p(false);
      return true;
    }
    if ((i != 3) && (i != 1)) {
      return false;
    }
    this.a.bu.setText(HardCodeUtil.a(2131903076));
    this.a.bu.setPressed(false);
    ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).stopSpeak();
    if (paramView != null) {
      paramView.a(false);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie.1
 * JD-Core Version:    0.7.0.1
 */