package com.tencent.kingkong;

import android.os.Looper;

public class UpdateManager$UpdateThread
  extends Thread
{
  private UpdateManager.UpdateHandler a = null;
  
  public void run()
  {
    Looper.prepare();
    this.a = new UpdateManager.UpdateHandler();
    Looper.loop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.kingkong.UpdateManager.UpdateThread
 * JD-Core Version:    0.7.0.1
 */