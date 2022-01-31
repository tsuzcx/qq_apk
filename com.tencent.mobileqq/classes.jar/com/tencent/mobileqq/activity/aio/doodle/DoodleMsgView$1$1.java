package com.tencent.mobileqq.activity.aio.doodle;

import addh;
import addi;
import mqq.util.WeakReference;

public class DoodleMsgView$1$1
  implements Runnable
{
  public DoodleMsgView$1$1(addh paramaddh) {}
  
  public void run()
  {
    if (DoodleMsgView.a(this.a.a) != null)
    {
      addi localaddi = (addi)DoodleMsgView.a(this.a.a).get();
      if (localaddi != null) {
        localaddi.g();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleMsgView.1.1
 * JD-Core Version:    0.7.0.1
 */