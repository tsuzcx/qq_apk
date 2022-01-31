package com.tencent.av.gaudio;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class AVNotifyCenter$2
  implements Runnable
{
  AVNotifyCenter$2(AVNotifyCenter paramAVNotifyCenter) {}
  
  public void run()
  {
    Iterator localIterator = this.this$0.a.keySet().iterator();
    long l;
    while (localIterator.hasNext())
    {
      l = ((Long)localIterator.next()).longValue();
      this.this$0.a(l, 2, this.this$0.b(l), false);
      this.this$0.a(1, 2, l, null, 0L);
      this.this$0.a(21, 2, l, 0L);
      localIterator.remove();
    }
    localIterator = this.this$0.b.keySet().iterator();
    while (localIterator.hasNext())
    {
      l = ((Long)localIterator.next()).longValue();
      this.this$0.a(l, 1, this.this$0.b(l), false);
      this.this$0.a(1, l, 10, 21, 0);
      this.this$0.a(2, 1, l, null, 0L);
      this.this$0.a(21, 1, l, 0L);
      localIterator.remove();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.av.gaudio.AVNotifyCenter.2
 * JD-Core Version:    0.7.0.1
 */