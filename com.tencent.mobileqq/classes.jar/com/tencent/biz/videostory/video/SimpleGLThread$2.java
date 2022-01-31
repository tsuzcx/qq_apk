package com.tencent.biz.videostory.video;

import wyq;

public class SimpleGLThread$2
  implements Runnable
{
  public SimpleGLThread$2(wyq paramwyq, Object paramObject) {}
  
  public void run()
  {
    synchronized (this.a)
    {
      this.a.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.video.SimpleGLThread.2
 * JD-Core Version:    0.7.0.1
 */