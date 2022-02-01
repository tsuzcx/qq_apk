package com.tencent.avgame.gameroom.gamelist;

import com.tencent.avgame.gamelogic.IGameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;

class GameListView$8
  implements Runnable
{
  GameListView$8(GameListView paramGameListView) {}
  
  public void run()
  {
    if ((GameListView.c(this.this$0) != null) && (IGameEngine.I().s().j() == 0)) {
      GameListView.c(this.this$0).a(this.this$0.b.a(), this.this$0.b.b(), this.this$0.b.c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.gamelist.GameListView.8
 * JD-Core Version:    0.7.0.1
 */