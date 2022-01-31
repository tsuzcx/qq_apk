package com.tencent.mobileqq.activity.aio.doodle;

import acsr;
import acss;
import mqq.util.WeakReference;

public class DoodleMsgView$1$1
  implements Runnable
{
  public DoodleMsgView$1$1(acsr paramacsr) {}
  
  public void run()
  {
    if (DoodleMsgView.a(this.a.a) != null)
    {
      acss localacss = (acss)DoodleMsgView.a(this.a.a).get();
      if (localacss != null) {
        localacss.g();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleMsgView.1.1
 * JD-Core Version:    0.7.0.1
 */