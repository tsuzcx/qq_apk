package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import com.tencent.avgame.business.api.IAvGameManager;
import com.tencent.qphone.base.util.QLog;

class AVGameShareJoinRoomAction$2
  implements Runnable
{
  AVGameShareJoinRoomAction$2(AVGameShareJoinRoomAction paramAVGameShareJoinRoomAction, IAvGameManager paramIAvGameManager, String paramString1, String paramString2) {}
  
  public void run()
  {
    if ((this.this$0.b instanceof Activity))
    {
      this.a.joinAvGameRoom((Activity)this.this$0.b, 1, this.b, this.c);
      return;
    }
    QLog.e("AVGameShareJoinRoomAction", 2, "directJoinRoom context not instance of activity");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.AVGameShareJoinRoomAction.2
 * JD-Core Version:    0.7.0.1
 */