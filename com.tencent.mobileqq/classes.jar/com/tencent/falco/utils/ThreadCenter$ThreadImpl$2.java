package com.tencent.falco.utils;

import android.os.Handler;
import android.util.Log;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class ThreadCenter$ThreadImpl$2
  implements Runnable
{
  ThreadCenter$ThreadImpl$2(ThreadCenter.ThreadImpl paramThreadImpl) {}
  
  public void run()
  {
    Log.i("threadimpl_log", "idle check begin...");
    Iterator localIterator = ThreadCenter.ThreadImpl.access$200(this.this$0).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((ThreadCenter.CoreHandler)localEntry.getValue()).isIdle())
      {
        ((ThreadCenter.CoreHandler)localEntry.getValue()).quitThread();
        localIterator.remove();
        Log.e("threadimpl_log", "remove handler thread: " + (String)localEntry.getKey());
      }
    }
    ThreadCenter.ThreadImpl.access$300(this.this$0).postDelayed(this, 300000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.utils.ThreadCenter.ThreadImpl.2
 * JD-Core Version:    0.7.0.1
 */