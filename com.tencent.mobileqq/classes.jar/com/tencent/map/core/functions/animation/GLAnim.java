package com.tencent.map.core.functions.animation;

import javax.microedition.khronos.opengles.GL10;

public abstract class GLAnim
{
  public static final long ANIM_FIRST_START = -1L;
  public static final int STATE_DRAWING = 1;
  public static final int STATE_FINISHED = 2;
  public static final int STATE_PENDING = 0;
  private long a;
  private boolean b;
  private long c;
  protected long duration;
  protected int mState;
  
  public GLAnim(long paramLong)
  {
    this.duration = paramLong;
    this.a = -1L;
    this.mState = 0;
  }
  
  public void draw(GL10 paramGL10)
  {
    if (this.mState != 1) {}
    long l;
    do
    {
      return;
      if (this.a == -1L) {
        this.a = System.currentTimeMillis();
      }
      l = System.currentTimeMillis() - this.a;
    } while (this.c - l > 0L);
    l -= this.c;
    if (l >= this.duration)
    {
      if (this.b) {
        onRestart();
      }
      this.mState = 2;
    }
    performDraw(paramGL10, l);
  }
  
  public long getDuration()
  {
    return this.duration;
  }
  
  public boolean isDrawing()
  {
    return this.mState == 1;
  }
  
  public boolean isFinished()
  {
    return this.mState == 2;
  }
  
  protected void onRestart()
  {
    this.mState = 1;
    this.a = -1L;
  }
  
  protected abstract void performDraw(GL10 paramGL10, long paramLong);
  
  public void setDelay(long paramLong)
  {
    this.c = paramLong;
  }
  
  public void setRepeat(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void start()
  {
    this.mState = 1;
    this.a = -1L;
  }
  
  public void stop()
  {
    this.mState = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.core.functions.animation.GLAnim
 * JD-Core Version:    0.7.0.1
 */