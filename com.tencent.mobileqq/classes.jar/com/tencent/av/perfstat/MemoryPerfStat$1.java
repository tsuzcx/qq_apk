package com.tencent.av.perfstat;

import befq;
import com.tencent.common.app.BaseApplicationImpl;
import lif;

public class MemoryPerfStat$1
  implements Runnable
{
  public MemoryPerfStat$1(lif paramlif) {}
  
  public void run()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    lif.a(this.this$0, localBaseApplicationImpl);
    lif.a(this.this$0);
    if (lif.a(this.this$0) == 1) {
      lif.a(this.this$0).sendEmptyMessageDelayed(1, 30000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.perfstat.MemoryPerfStat.1
 * JD-Core Version:    0.7.0.1
 */