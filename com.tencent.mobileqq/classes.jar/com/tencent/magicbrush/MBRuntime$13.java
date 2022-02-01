package com.tencent.magicbrush;

import android.view.Surface;

class MBRuntime$13
  implements Runnable
{
  MBRuntime$13(MBRuntime paramMBRuntime, int paramInt1, Surface paramSurface, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    MBRuntime localMBRuntime = this.e;
    localMBRuntime.nativeNotifyWindowAvailableForSurface(localMBRuntime.a, this.a, this.b, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.MBRuntime.13
 * JD-Core Version:    0.7.0.1
 */