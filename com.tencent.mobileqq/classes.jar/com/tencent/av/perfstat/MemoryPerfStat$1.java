package com.tencent.av.perfstat;

import bjng;
import com.tencent.common.app.BaseApplicationImpl;
import lse;

public class MemoryPerfStat$1
  implements Runnable
{
  public MemoryPerfStat$1(lse paramlse) {}
  
  public void run()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    lse.a(this.this$0, localBaseApplicationImpl);
    lse.a(this.this$0);
    if (lse.a(this.this$0) == 1) {
      lse.a(this.this$0).sendEmptyMessageDelayed(1, 30000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.perfstat.MemoryPerfStat.1
 * JD-Core Version:    0.7.0.1
 */