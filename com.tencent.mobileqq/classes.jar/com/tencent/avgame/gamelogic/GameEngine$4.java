package com.tencent.avgame.gamelogic;

import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.gameres.AvGameResDownloadManager;
import java.util.List;

class GameEngine$4
  implements Runnable
{
  GameEngine$4(GameEngine paramGameEngine, EngineData paramEngineData) {}
  
  public void run()
  {
    List localList = this.a.a();
    new AvGameResDownloadManager(this.this$0.a()).a(localList, ".mp3", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.GameEngine.4
 * JD-Core Version:    0.7.0.1
 */