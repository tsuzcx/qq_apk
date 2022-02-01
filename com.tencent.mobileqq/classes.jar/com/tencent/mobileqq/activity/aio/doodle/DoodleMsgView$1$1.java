package com.tencent.mobileqq.activity.aio.doodle;

import agcj;
import agck;
import mqq.util.WeakReference;

public class DoodleMsgView$1$1
  implements Runnable
{
  public DoodleMsgView$1$1(agcj paramagcj) {}
  
  public void run()
  {
    if (DoodleMsgView.a(this.a.a) != null)
    {
      agck localagck = (agck)DoodleMsgView.a(this.a.a).get();
      if (localagck != null) {
        localagck.g();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleMsgView.1.1
 * JD-Core Version:    0.7.0.1
 */