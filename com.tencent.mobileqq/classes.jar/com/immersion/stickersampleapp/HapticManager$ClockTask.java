package com.immersion.stickersampleapp;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class HapticManager$ClockTask
  implements Runnable
{
  HapticManager$ClockTask(HapticManager paramHapticManager) {}
  
  public void run()
  {
    ThreadManager.getUIHandler().post(HapticManager.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.immersion.stickersampleapp.HapticManager.ClockTask
 * JD-Core Version:    0.7.0.1
 */