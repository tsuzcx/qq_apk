package com.tencent.mobileqq.ar.ARRenderModel;

import java.util.concurrent.locks.ReentrantLock;

class MultiFragmentAnimRenderable$3
  implements Runnable
{
  MultiFragmentAnimRenderable$3(MultiFragmentAnimRenderable paramMultiFragmentAnimRenderable) {}
  
  public void run()
  {
    MultiFragmentAnimRenderable.a(this.this$0).lock();
    if (MultiFragmentAnimRenderable.b(this.this$0) != null)
    {
      MultiFragmentAnimRenderable.b(this.this$0).l();
      MultiFragmentAnimRenderable.a(this.this$0, null);
    }
    MultiFragmentAnimRenderable.a(this.this$0).unlock();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.MultiFragmentAnimRenderable.3
 * JD-Core Version:    0.7.0.1
 */