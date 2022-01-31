package com.tencent.mobileqq.activity.aio.doodle;

import aezy;
import aezz;
import mqq.util.WeakReference;

public class DoodleMsgView$1$1
  implements Runnable
{
  public DoodleMsgView$1$1(aezy paramaezy) {}
  
  public void run()
  {
    if (DoodleMsgView.a(this.a.a) != null)
    {
      aezz localaezz = (aezz)DoodleMsgView.a(this.a.a).get();
      if (localaezz != null) {
        localaezz.g();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleMsgView.1.1
 * JD-Core Version:    0.7.0.1
 */