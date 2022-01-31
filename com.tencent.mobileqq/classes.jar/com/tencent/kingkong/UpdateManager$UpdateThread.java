package com.tencent.kingkong;

import android.os.Looper;
import rac;

public class UpdateManager$UpdateThread
  extends Thread
{
  private rac a;
  
  public void run()
  {
    Looper.prepare();
    this.a = new rac();
    Looper.loop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.kingkong.UpdateManager.UpdateThread
 * JD-Core Version:    0.7.0.1
 */