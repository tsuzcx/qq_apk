package com.tencent.magicbrush;

import com.tencent.magicbrush.ui.a;

class MBRuntime$9
  implements Runnable
{
  MBRuntime$9(MBRuntime paramMBRuntime) {}
  
  public void run()
  {
    if (this.a.b.enable_request_animation_frame) {
      this.a.g.d();
    }
    MBRuntime localMBRuntime = this.a;
    localMBRuntime.nativePause(localMBRuntime.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.MBRuntime.9
 * JD-Core Version:    0.7.0.1
 */