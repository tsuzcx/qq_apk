package com.google.android.exoplayer2.ext.mediaplayer;

import android.os.Handler;

public class Repeater
{
  private Handler delayedHandler;
  private Repeater.RepeatListener listener;
  private Repeater.PollRunnable pollRunnable = new Repeater.PollRunnable(this, null);
  private int repeatDelay = 1000;
  private volatile boolean repeaterRunning = false;
  
  Repeater(Handler paramHandler)
  {
    this.delayedHandler = paramHandler;
  }
  
  void setRepeatListener(Repeater.RepeatListener paramRepeatListener)
  {
    this.listener = paramRepeatListener;
  }
  
  void setRepeaterDelay(int paramInt)
  {
    this.repeatDelay = paramInt;
  }
  
  void start()
  {
    if (!this.repeaterRunning)
    {
      this.repeaterRunning = true;
      this.pollRunnable.performPoll();
    }
  }
  
  void stop()
  {
    this.repeaterRunning = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.mediaplayer.Repeater
 * JD-Core Version:    0.7.0.1
 */