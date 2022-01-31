package com.tencent.kingkong;

import android.os.Looper;
import rcs;

public class UpdateManager$UpdateThread
  extends Thread
{
  private rcs a;
  
  public void run()
  {
    Looper.prepare();
    this.a = new rcs();
    Looper.loop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.kingkong.UpdateManager.UpdateThread
 * JD-Core Version:    0.7.0.1
 */