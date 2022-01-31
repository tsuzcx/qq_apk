package com.tencent.kingkong;

import android.os.Looper;
import zpt;

public class UpdateManager$UpdateThread
  extends Thread
{
  private zpt a;
  
  public void run()
  {
    Looper.prepare();
    this.a = new zpt();
    Looper.loop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.kingkong.UpdateManager.UpdateThread
 * JD-Core Version:    0.7.0.1
 */