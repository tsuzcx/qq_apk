package com.sina.weibo.sdk.b;

import android.os.Process;

final class c$2
  extends c.d<Params, Result>
{
  c$2(c paramc)
  {
    super((byte)0);
  }
  
  public final Result call()
  {
    Process.setThreadPriority(this.W.U);
    return this.W.o();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.b.c.2
 * JD-Core Version:    0.7.0.1
 */