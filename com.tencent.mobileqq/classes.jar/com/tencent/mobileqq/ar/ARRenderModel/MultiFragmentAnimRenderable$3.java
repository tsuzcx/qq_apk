package com.tencent.mobileqq.ar.ARRenderModel;

import aobb;
import aobx;
import java.util.concurrent.locks.ReentrantLock;

public class MultiFragmentAnimRenderable$3
  implements Runnable
{
  public MultiFragmentAnimRenderable$3(aobx paramaobx) {}
  
  public void run()
  {
    aobx.a(this.this$0).lock();
    if (aobx.a(this.this$0) != null)
    {
      aobx.a(this.this$0).f();
      aobx.a(this.this$0, null);
    }
    aobx.a(this.this$0).unlock();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.MultiFragmentAnimRenderable.3
 * JD-Core Version:    0.7.0.1
 */