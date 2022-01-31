package com.tencent.mobileqq.activity.aio.doodle;

import addk;
import addl;
import mqq.util.WeakReference;

public class DoodleMsgView$1$1
  implements Runnable
{
  public DoodleMsgView$1$1(addk paramaddk) {}
  
  public void run()
  {
    if (DoodleMsgView.a(this.a.a) != null)
    {
      addl localaddl = (addl)DoodleMsgView.a(this.a.a).get();
      if (localaddl != null) {
        localaddl.g();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleMsgView.1.1
 * JD-Core Version:    0.7.0.1
 */