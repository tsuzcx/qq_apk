package com.tencent.luggage.wxa.dr;

import com.tencent.mm.game.liblockstep.LockStepNative.ILockStepListener;
import com.tencent.mm.plugin.appbrand.jsruntime.q;
import java.lang.ref.WeakReference;

class a$1
  implements LockStepNative.ILockStepListener
{
  a$1(a parama, WeakReference paramWeakReference) {}
  
  public void onCallBack(long paramLong, String paramString)
  {
    ((q)this.a.get()).a(new a.1.1(this, paramString, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dr.a.1
 * JD-Core Version:    0.7.0.1
 */