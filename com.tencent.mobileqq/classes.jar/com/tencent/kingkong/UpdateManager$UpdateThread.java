package com.tencent.kingkong;

import abqf;
import android.os.Looper;

public class UpdateManager$UpdateThread
  extends Thread
{
  private abqf a;
  
  public void run()
  {
    Looper.prepare();
    this.a = new abqf();
    Looper.loop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.kingkong.UpdateManager.UpdateThread
 * JD-Core Version:    0.7.0.1
 */