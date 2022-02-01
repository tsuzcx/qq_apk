package com.tencent.mobileqq.activity.aio.doodle;

import agpl;
import agpm;
import mqq.util.WeakReference;

public class DoodleMsgView$1$1
  implements Runnable
{
  public DoodleMsgView$1$1(agpl paramagpl) {}
  
  public void run()
  {
    if (DoodleMsgView.a(this.a.a) != null)
    {
      agpm localagpm = (agpm)DoodleMsgView.a(this.a.a).get();
      if (localagpm != null) {
        localagpm.g();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleMsgView.1.1
 * JD-Core Version:    0.7.0.1
 */