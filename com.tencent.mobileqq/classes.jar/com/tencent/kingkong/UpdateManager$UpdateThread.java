package com.tencent.kingkong;

import abuu;
import android.os.Looper;

public class UpdateManager$UpdateThread
  extends Thread
{
  private abuu a;
  
  public void run()
  {
    Looper.prepare();
    this.a = new abuu();
    Looper.loop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.kingkong.UpdateManager.UpdateThread
 * JD-Core Version:    0.7.0.1
 */