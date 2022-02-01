package com.tencent.avgame.gamelogic.data;

import android.os.HandlerThread;

class Game$1
  extends HandlerThread
{
  Game$1(Game paramGame, String paramString, int paramInt)
  {
    super(paramString);
  }
  
  protected void onLooperPrepared()
  {
    Game.a(this.this$0, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.data.Game.1
 * JD-Core Version:    0.7.0.1
 */