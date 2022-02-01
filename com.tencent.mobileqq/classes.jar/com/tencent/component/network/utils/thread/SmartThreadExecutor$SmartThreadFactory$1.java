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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("run: new thread start ");
    localStringBuilder.append(getName());
    Log.i("SmartThreadFactory", localStringBuilder.toString());
    this.val$r.run();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("run: new thread end ");
    localStringBuilder.append(getName());
    Log.i("SmartThreadFactory", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.utils.thread.SmartThreadExecutor.SmartThreadFactory.1
 * JD-Core Version:    0.7.0.1
 */