package com.tencent.av.perfstat;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.util.WeakReferenceHandler;

class MemoryPerfStat$1
  implements Runnable
{
  MemoryPerfStat$1(MemoryPerfStat paramMemoryPerfStat) {}
  
  public void run()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    MemoryPerfStat.a(this.this$0, localBaseApplicationImpl);
    MemoryPerfStat.a(this.this$0);
    if (MemoryPerfStat.a(this.this$0) == 1) {
      MemoryPerfStat.a(this.this$0).sendEmptyMessageDelayed(1, 30000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.perfstat.MemoryPerfStat.1
 * JD-Core Version:    0.7.0.1
 */