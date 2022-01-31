package com.tencent.mobileqq.ar.ARRenderModel;

import alac;
import alay;
import java.util.concurrent.locks.ReentrantLock;

public class MultiFragmentAnimRenderable$3
  implements Runnable
{
  public MultiFragmentAnimRenderable$3(alay paramalay) {}
  
  public void run()
  {
    alay.a(this.this$0).lock();
    if (alay.a(this.this$0) != null)
    {
      alay.a(this.this$0).f();
      alay.a(this.this$0, null);
    }
    alay.a(this.this$0).unlock();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.MultiFragmentAnimRenderable.3
 * JD-Core Version:    0.7.0.1
 */