package com.tencent.mobileqq.ar;

class ObjectSurfaceView$1
  implements Runnable
{
  ObjectSurfaceView$1(ObjectSurfaceView paramObjectSurfaceView) {}
  
  public void run()
  {
    while (ObjectSurfaceView.a(this.this$0))
    {
      long l = System.currentTimeMillis();
      ObjectSurfaceView.b(this.this$0);
      try
      {
        Thread.sleep(Math.max(0L, ObjectSurfaceView.c(this.this$0) - (System.currentTimeMillis() - l)));
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
    }
    if (ObjectSurfaceView.d(this.this$0)) {
      ObjectSurfaceView.b(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ObjectSurfaceView.1
 * JD-Core Version:    0.7.0.1
 */