package com.tencent.magicbrush;

import com.tencent.magicbrush.ui.a;

class MBRuntime$8
  implements Runnable
{
  MBRuntime$8(MBRuntime paramMBRuntime) {}
  
  public void run()
  {
    MBRuntime localMBRuntime = this.a;
    localMBRuntime.nativeResume(localMBRuntime.a);
    if (this.a.b.enable_request_animation_frame) {
      this.a.g.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.MBRuntime.8
 * JD-Core Version:    0.7.0.1
 */