package com.tencent.mobileqq.activity.qwallet.preload;

import java.util.TimerTask;

abstract class PreloadResource$PreloadTimerTask
  extends TimerTask
{
  private boolean a;
  
  public abstract void a();
  
  public boolean a()
  {
    return this.a;
  }
  
  public void run()
  {
    a();
    this.a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.PreloadResource.PreloadTimerTask
 * JD-Core Version:    0.7.0.1
 */