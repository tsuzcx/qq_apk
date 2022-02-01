package com.tencent.avgame.gamelogic;

import java.util.List;
import mxl;
import myc;
import myr;

public class GameEngine$1
  implements Runnable
{
  public GameEngine$1(mxl parammxl, myc parammyc) {}
  
  public void run()
  {
    List localList = this.a.a();
    new myr(this.this$0.a()).a(localList, ".mp3", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.GameEngine.1
 * JD-Core Version:    0.7.0.1
 */