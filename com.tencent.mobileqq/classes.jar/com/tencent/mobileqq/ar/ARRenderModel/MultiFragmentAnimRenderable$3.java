package com.tencent.mobileqq.ar.ARRenderModel;

import amqs;
import amro;
import java.util.concurrent.locks.ReentrantLock;

public class MultiFragmentAnimRenderable$3
  implements Runnable
{
  public MultiFragmentAnimRenderable$3(amro paramamro) {}
  
  public void run()
  {
    amro.a(this.this$0).lock();
    if (amro.a(this.this$0) != null)
    {
      amro.a(this.this$0).f();
      amro.a(this.this$0, null);
    }
    amro.a(this.this$0).unlock();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.MultiFragmentAnimRenderable.3
 * JD-Core Version:    0.7.0.1
 */