package com.tencent.av.perfstat;

import blhq;
import com.tencent.common.app.BaseApplicationImpl;
import lsw;

public class MemoryPerfStat$1
  implements Runnable
{
  public MemoryPerfStat$1(lsw paramlsw) {}
  
  public void run()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    lsw.a(this.this$0, localBaseApplicationImpl);
    lsw.a(this.this$0);
    if (lsw.a(this.this$0) == 1) {
      lsw.a(this.this$0).sendEmptyMessageDelayed(1, 30000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.perfstat.MemoryPerfStat.1
 * JD-Core Version:    0.7.0.1
 */