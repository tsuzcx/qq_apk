package com.tencent.component.network.utils.thread;

import android.util.Log;

class SmartThreadExecutor$SmartThreadFactory$1
  extends Thread
{
  SmartThreadExecutor$SmartThreadFactory$1(SmartThreadExecutor.SmartThreadFactory paramSmartThreadFactory, String paramString, Runnable paramRunnable)
  {
    super(paramString);
  }
  
  public void run()
  {
    super.run();
    Log.i("SmartThreadFactory", "run: new thread start " + getName());
    this.val$r.run();
    Log.i("SmartThreadFactory", "run: new thread end " + getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.network.utils.thread.SmartThreadExecutor.SmartThreadFactory.1
 * JD-Core Version:    0.7.0.1
 */