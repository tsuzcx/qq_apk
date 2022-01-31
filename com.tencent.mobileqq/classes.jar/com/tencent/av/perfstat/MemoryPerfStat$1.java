package com.tencent.av.perfstat;

import bhow;
import com.tencent.common.app.BaseApplicationImpl;
import luy;

public class MemoryPerfStat$1
  implements Runnable
{
  public MemoryPerfStat$1(luy paramluy) {}
  
  public void run()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    luy.a(this.this$0, localBaseApplicationImpl);
    luy.a(this.this$0);
    if (luy.a(this.this$0) == 1) {
      luy.a(this.this$0).sendEmptyMessageDelayed(1, 30000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.perfstat.MemoryPerfStat.1
 * JD-Core Version:    0.7.0.1
 */