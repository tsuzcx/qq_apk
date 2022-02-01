package com.tencent.mobileqq.ar.ARRenderModel;

import aoty;
import aouu;
import java.util.concurrent.locks.ReentrantLock;

public class MultiFragmentAnimRenderable$3
  implements Runnable
{
  public MultiFragmentAnimRenderable$3(aouu paramaouu) {}
  
  public void run()
  {
    aouu.a(this.this$0).lock();
    if (aouu.a(this.this$0) != null)
    {
      aouu.a(this.this$0).f();
      aouu.a(this.this$0, null);
    }
    aouu.a(this.this$0).unlock();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.MultiFragmentAnimRenderable.3
 * JD-Core Version:    0.7.0.1
 */