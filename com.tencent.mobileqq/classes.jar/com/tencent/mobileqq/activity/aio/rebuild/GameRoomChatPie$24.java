package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.gameroom.IGameRoomAVControllerDelegate;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class GameRoomChatPie$24
  extends BroadcastReceiver
{
  GameRoomChatPie$24(GameRoomChatPie paramGameRoomChatPie) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent.getStringExtra("peerUin");
    paramIntent.getIntExtra("sessionType", -1);
    paramContext = paramIntent.getStringExtra("sessionId");
    if (TextUtils.isEmpty(paramContext)) {
      return;
    }
    if (paramContext.startsWith("10-"))
    {
      ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).stopSpeak();
      this.a.bu.setEnabled(true);
      if (QLog.isColorLevel()) {
        QLog.d(this.a.c, 2, "onBind enter room setSoundDisable");
      }
      ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).setSoundEnable(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie.24
 * JD-Core Version:    0.7.0.1
 */