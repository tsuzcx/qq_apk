package com.tencent.mobileqq.bigbrother;

import android.support.v4.util.SparseArrayCompat;

public class TeleScreen
{
  private static final TeleScreen a = new TeleScreen();
  private final SparseArrayCompat<JumpCallback> b = new SparseArrayCompat();
  private int c;
  
  public static TeleScreen a()
  {
    return a;
  }
  
  public int a(JumpCallback paramJumpCallback)
  {
    synchronized (this.b)
    {
      do
      {
        this.c += 1;
      } while ((this.b.get(this.c) != null) || (this.c == 0));
      this.b.put(this.c, paramJumpCallback);
      int i = this.c;
      return i;
    }
    for (;;)
    {
      throw paramJumpCallback;
    }
  }
  
  public void a(int paramInt)
  {
    synchronized (this.b)
    {
      this.b.delete(paramInt);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    synchronized (this.b)
    {
      JumpCallback localJumpCallback = (JumpCallback)this.b.get(paramInt1);
      if (localJumpCallback != null) {
        localJumpCallback.onJump(paramInt1, paramInt2);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bigbrother.TeleScreen
 * JD-Core Version:    0.7.0.1
 */