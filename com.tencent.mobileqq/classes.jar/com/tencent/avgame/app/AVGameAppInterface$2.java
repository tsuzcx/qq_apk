package com.tencent.avgame.app;

import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.qav.AVGameBusinessCtrl;

class AVGameAppInterface$2
  implements Runnable
{
  AVGameAppInterface$2(AVGameAppInterface paramAVGameAppInterface) {}
  
  public void run()
  {
    AVGameBusinessCtrl.a();
    GameEngine.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.app.AVGameAppInterface.2
 * JD-Core Version:    0.7.0.1
 */