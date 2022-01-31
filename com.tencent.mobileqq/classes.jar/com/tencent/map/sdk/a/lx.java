package com.tencent.map.sdk.a;

import android.util.Log;

public final class lx
  extends Thread
{
  public boolean a = false;
  private lw b;
  private boolean c = false;
  private byte[] d = null;
  
  public lx(lw paramlw)
  {
    this.b = paramlw;
  }
  
  public final void a()
  {
    this.a = false;
    try
    {
      notifyAll();
      return;
    }
    finally {}
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    this.d = paramArrayOfByte;
    this.c = true;
    interrupt();
  }
  
  public final void run()
  {
    boolean bool;
    if (!this.c)
    {
      if (this.a) {
        break label105;
      }
      if (this.b != null)
      {
        lw locallw = this.b;
        if (locallw.a != null) {
          bool = locallw.a.c();
        }
      }
    }
    while (!bool)
    {
      try
      {
        sleep(160L);
      }
      catch (InterruptedException localInterruptedException)
      {
        or.b(Log.getStackTraceString(localInterruptedException));
        Thread.currentThread().interrupt();
      }
      break;
      bool = false;
      continue;
      if (this.d == null) {
        return;
      }
      synchronized (this.d)
      {
        this.d.notifyAll();
        return;
      }
      label105:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.lx
 * JD-Core Version:    0.7.0.1
 */