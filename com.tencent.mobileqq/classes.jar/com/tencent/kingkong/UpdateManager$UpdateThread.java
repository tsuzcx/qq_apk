package com.tencent.kingkong;

import adkh;
import android.os.Looper;

public class UpdateManager$UpdateThread
  extends Thread
{
  private adkh a;
  
  public void run()
  {
    Looper.prepare();
    this.a = new adkh();
    Looper.loop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.kingkong.UpdateManager.UpdateThread
 * JD-Core Version:    0.7.0.1
 */