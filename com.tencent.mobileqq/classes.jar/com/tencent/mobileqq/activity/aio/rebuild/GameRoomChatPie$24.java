package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.gameroom.GameRoomAVController;
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
    if (TextUtils.isEmpty(paramContext)) {}
    while (!paramContext.startsWith("10-")) {
      return;
    }
    this.a.a.c();
    this.a.l.setEnabled(true);
    if (QLog.isColorLevel()) {
      QLog.d(this.a.b, 2, "onBind enter room setSoundDisable");
    }
    this.a.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie.24
 * JD-Core Version:    0.7.0.1
 */