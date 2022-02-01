package com.tencent.avgame.gamelogic;

import android.content.Intent;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class GameEngine$2
  implements Runnable
{
  GameEngine$2(GameEngine paramGameEngine) {}
  
  public void run()
  {
    GameEngine.a(this.this$0).getApp().sendBroadcast(new Intent("tencent.avgame.notify.voice.record.on"), "com.tencent.msg.permission.pushnotify");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.GameEngine.2
 * JD-Core Version:    0.7.0.1
 */