package com.tencent.mobileqq.ar;

class ScanningSurfaceView$DrawThread
  extends Thread
{
  public void run()
  {
    while (ScanningSurfaceView.a(this.this$0))
    {
      long l = System.currentTimeMillis();
      ScanningSurfaceView.a(this.this$0);
      try
      {
        Thread.sleep(Math.max(0L, ScanningSurfaceView.a(this.this$0) - (System.currentTimeMillis() - l)));
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
    }
    if (ScanningSurfaceView.b(this.this$0)) {
      ScanningSurfaceView.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ScanningSurfaceView.DrawThread
 * JD-Core Version:    0.7.0.1
 */