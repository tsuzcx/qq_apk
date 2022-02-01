package com.tencent.mobileqq.activity.aio.doodle;

import aflf;
import aflg;
import mqq.util.WeakReference;

public class DoodleMsgView$1$1
  implements Runnable
{
  public DoodleMsgView$1$1(aflf paramaflf) {}
  
  public void run()
  {
    if (DoodleMsgView.a(this.a.a) != null)
    {
      aflg localaflg = (aflg)DoodleMsgView.a(this.a.a).get();
      if (localaflg != null) {
        localaflg.g();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleMsgView.1.1
 * JD-Core Version:    0.7.0.1
 */