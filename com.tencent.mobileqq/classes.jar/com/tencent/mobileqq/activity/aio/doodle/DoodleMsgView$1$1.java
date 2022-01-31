package com.tencent.mobileqq.activity.aio.doodle;

import aevj;
import aevk;
import mqq.util.WeakReference;

public class DoodleMsgView$1$1
  implements Runnable
{
  public DoodleMsgView$1$1(aevj paramaevj) {}
  
  public void run()
  {
    if (DoodleMsgView.a(this.a.a) != null)
    {
      aevk localaevk = (aevk)DoodleMsgView.a(this.a.a).get();
      if (localaevk != null) {
        localaevk.g();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleMsgView.1.1
 * JD-Core Version:    0.7.0.1
 */