package com.tencent.avgame.gameroom.video;

import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;

class AVGameControlUIImpl$2$5
  implements Runnable
{
  AVGameControlUIImpl$2$5(AVGameControlUIImpl.2 param2) {}
  
  public void run()
  {
    if ((GameEngine.a().A()) && (!GameEngine.a().B()) && (GameEngine.a().s().j() == 0)) {
      return;
    }
    AVGameControlUIImpl.c(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameControlUIImpl.2.5
 * JD-Core Version:    0.7.0.1
 */