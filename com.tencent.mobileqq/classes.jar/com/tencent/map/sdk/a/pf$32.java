package com.tencent.map.sdk.a;

import com.tencent.map.sdk.engine.jni.JNI;

public final class pf$32
  implements lw.a
{
  public pf$32(pf parampf, int paramInt, int[] paramArrayOfInt) {}
  
  public final void a()
  {
    JNI localJNI = pf.b(this.c);
    long l1 = pf.a(this.c);
    long l2 = this.a;
    int[] arrayOfInt = this.b;
    localJNI.nativeSetTurnArrowStyle(l1, l2, arrayOfInt[0], arrayOfInt[1]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.pf.32
 * JD-Core Version:    0.7.0.1
 */