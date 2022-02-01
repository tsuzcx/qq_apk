package com.tencent.map.sdk.a;

import android.os.Handler;

public abstract class bj$a
  implements Runnable
{
  private bj$a(bj parambj) {}
  
  public final void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!bj.a(this.a).postAtFrontOfQueue(this)) {
        bj.a(this.a).post(this);
      }
      return;
    }
    bj.a(this.a).post(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.sdk.a.bj.a
 * JD-Core Version:    0.7.0.1
 */