package com.tencent.av.perfstat;

import bkgm;
import com.tencent.common.app.BaseApplicationImpl;
import lsa;

public class MemoryPerfStat$1
  implements Runnable
{
  public MemoryPerfStat$1(lsa paramlsa) {}
  
  public void run()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    lsa.a(this.this$0, localBaseApplicationImpl);
    lsa.a(this.this$0);
    if (lsa.a(this.this$0) == 1) {
      lsa.a(this.this$0).sendEmptyMessageDelayed(1, 30000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.perfstat.MemoryPerfStat.1
 * JD-Core Version:    0.7.0.1
 */