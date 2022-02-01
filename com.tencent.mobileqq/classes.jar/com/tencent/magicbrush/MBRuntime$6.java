package com.tencent.magicbrush;

import com.tencent.magicbrush.ui.MBViewManager;
import com.tencent.magicbrush.ui.i;

class MBRuntime$6
  implements Runnable
{
  MBRuntime$6(MBRuntime paramMBRuntime, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    i locali = this.c.k().findOrNull(this.a);
    if (locali != null) {
      locali.setOpaque(this.b ^ true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.MBRuntime.6
 * JD-Core Version:    0.7.0.1
 */