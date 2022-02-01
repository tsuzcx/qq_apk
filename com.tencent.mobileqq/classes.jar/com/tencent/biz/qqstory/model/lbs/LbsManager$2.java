package com.tencent.biz.qqstory.model.lbs;

import com.tencent.biz.qqstory.support.logging.SLog;

class LbsManager$2
  implements Runnable
{
  LbsManager$2(LbsManager paramLbsManager, int paramInt) {}
  
  public void run()
  {
    SLog.d("LbsManager", "onLocation Timeout  %d ms", new Object[] { Integer.valueOf(this.a) });
    LbsManager localLbsManager = this.this$0;
    localLbsManager.a(false, localLbsManager.c);
    LbsManager.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.lbs.LbsManager.2
 * JD-Core Version:    0.7.0.1
 */