package com.tencent.magicbrush;

import com.tencent.magicbrush.handler.JsTouchEventHandler.a;

class MBRuntime$4
  implements Runnable
{
  MBRuntime$4(MBRuntime paramMBRuntime, JsTouchEventHandler.a parama, long paramLong, int paramInt) {}
  
  public void run()
  {
    if (this.d.a == 0L)
    {
      this.a.a(this.b);
      return;
    }
    MBRuntime localMBRuntime = this.d;
    localMBRuntime.nativeNotifyTouchEvent(localMBRuntime.a, this.c, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.MBRuntime.4
 * JD-Core Version:    0.7.0.1
 */