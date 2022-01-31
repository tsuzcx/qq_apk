package com.tencent.av.perfstat;

import bfob;
import com.tencent.common.app.BaseApplicationImpl;
import lsr;

public class MemoryPerfStat$1
  implements Runnable
{
  public MemoryPerfStat$1(lsr paramlsr) {}
  
  public void run()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    lsr.a(this.this$0, localBaseApplicationImpl);
    lsr.a(this.this$0);
    if (lsr.a(this.this$0) == 1) {
      lsr.a(this.this$0).sendEmptyMessageDelayed(1, 30000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.perfstat.MemoryPerfStat.1
 * JD-Core Version:    0.7.0.1
 */