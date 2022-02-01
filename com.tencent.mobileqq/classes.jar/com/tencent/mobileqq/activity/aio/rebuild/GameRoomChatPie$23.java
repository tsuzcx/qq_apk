package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.nearby.gameroom.IGameRoomAVControllerDelegate;
import com.tencent.mobileqq.qroute.QRoute;

class GameRoomChatPie$23
  extends BroadcastReceiver
{
  GameRoomChatPie$23(GameRoomChatPie paramGameRoomChatPie) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).reset(paramContext);
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie.23
 * JD-Core Version:    0.7.0.1
 */