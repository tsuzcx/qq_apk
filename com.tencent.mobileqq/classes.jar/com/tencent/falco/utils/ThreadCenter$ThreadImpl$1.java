package com.tencent.falco.utils;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;

class ThreadCenter$ThreadImpl$1
  implements Runnable
{
  ThreadCenter$ThreadImpl$1(ThreadCenter.ThreadImpl paramThreadImpl, Runnable paramRunnable, ThreadCenter.TaskProxy paramTaskProxy) {}
  
  public void run()
  {
    ThreadCenter.ThreadImpl.access$000(this.this$0).remove(this.val$task);
    ThreadCenter.ThreadImpl.access$100(this.this$0).execute(this.val$taskProxy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.utils.ThreadCenter.ThreadImpl.1
 * JD-Core Version:    0.7.0.1
 */