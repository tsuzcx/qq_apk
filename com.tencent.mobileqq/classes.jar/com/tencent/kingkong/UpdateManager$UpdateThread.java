package com.tencent.kingkong;

import achb;
import android.os.Looper;

public class UpdateManager$UpdateThread
  extends Thread
{
  private achb a;
  
  public void run()
  {
    Looper.prepare();
    this.a = new achb();
    Looper.loop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.kingkong.UpdateManager.UpdateThread
 * JD-Core Version:    0.7.0.1
 */