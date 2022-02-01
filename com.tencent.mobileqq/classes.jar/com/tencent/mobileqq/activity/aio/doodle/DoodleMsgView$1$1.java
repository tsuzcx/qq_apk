package com.tencent.mobileqq.activity.aio.doodle;

import mqq.util.WeakReference;

class DoodleMsgView$1$1
  implements Runnable
{
  DoodleMsgView$1$1(DoodleMsgView.1 param1) {}
  
  public void run()
  {
    if (DoodleMsgView.g(this.a.a) != null)
    {
      DoodleMsgViewListener localDoodleMsgViewListener = (DoodleMsgViewListener)DoodleMsgView.g(this.a.a).get();
      if (localDoodleMsgViewListener != null) {
        localDoodleMsgViewListener.i();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleMsgView.1.1
 * JD-Core Version:    0.7.0.1
 */