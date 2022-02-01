package com.tencent.luggage.wxa.dr;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.game.liblockstep.LockStepNative;

class a$5
  implements Runnable
{
  a$5(a parama) {}
  
  public void run()
  {
    synchronized (this.a)
    {
      if (this.a.a != null)
      {
        o.d("Luggage.LockStepNativeInstallHelper", "DestroyTask destoryLockStep");
        this.a.a.destoryLockStep();
        this.a.a = null;
      }
      else
      {
        o.d("Luggage.LockStepNativeInstallHelper", "DestroyTask lockStepNative is null");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dr.a.5
 * JD-Core Version:    0.7.0.1
 */