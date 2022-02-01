package com.tencent.avgame.ipc;

import android.content.Intent;
import com.tencent.common.app.business.BaseAVGameAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class AVGameClientQIPCModule$1
  implements EIPCResultCallback
{
  AVGameClientQIPCModule$1(AVGameClientQIPCModule paramAVGameClientQIPCModule, String paramString, int paramInt) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult == null) || (!paramEIPCResult.isSuccess()))
    {
      paramEIPCResult = new Intent("action_notify_av_game_room_changed");
      paramEIPCResult.putExtra("action_key_room_id", this.a);
      paramEIPCResult.putExtra("action_key_status", this.b);
      AVGameClientQIPCModule.a(this.c).getApp().sendBroadcast(paramEIPCResult);
      paramEIPCResult = new StringBuilder();
      paramEIPCResult.append("status change with broadcast ");
      paramEIPCResult.append(this.b);
      paramEIPCResult.append(" ");
      paramEIPCResult.append(this.a);
      QLog.d("AVGameClientQIPCModule", 2, paramEIPCResult.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ipc.AVGameClientQIPCModule.1
 * JD-Core Version:    0.7.0.1
 */