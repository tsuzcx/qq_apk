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
    while (!this.c)
    {
      boolean bool3 = this.a;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (!bool3)
      {
        lw locallw = this.b;
        bool1 = bool2;
        if (locallw != null)
        {
          bool1 = bool2;
          if (locallw.a != null) {
            bool1 = locallw.a.c();
          }
        }
      }
      if (!bool1) {
        try
        {
          sleep(160L);
        }
        catch (InterruptedException localInterruptedException)
        {
          or.b(Log.getStackTraceString(localInterruptedException));
          Thread.currentThread().interrupt();
        }
      }
    }
    byte[] arrayOfByte = this.d;
    if (arrayOfByte != null) {
      try
      {
        this.d.notifyAll();
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.lx
 * JD-Core Version:    0.7.0.1
 */