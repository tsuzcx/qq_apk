package com.tencent.mobileqq.activity.aio.doodle;

import mqq.util.WeakReference;

class DoodleMsgView$1$2
  implements Runnable
{
  DoodleMsgView$1$2(DoodleMsgView.1 param1, int paramInt) {}
  
  public void run()
  {
    if (DoodleMsgView.g(this.b.a) != null)
    {
      DoodleMsgViewListener localDoodleMsgViewListener = (DoodleMsgViewListener)DoodleMsgView.g(this.b.a).get();
      if (localDoodleMsgViewListener != null) {
        localDoodleMsgViewListener.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleMsgView.1.2
 * JD-Core Version:    0.7.0.1
 */