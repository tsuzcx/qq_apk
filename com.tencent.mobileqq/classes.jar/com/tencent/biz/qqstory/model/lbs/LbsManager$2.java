package com.tencent.biz.qqstory.model.lbs;

import vwq;
import xvv;

public class LbsManager$2
  implements Runnable
{
  public LbsManager$2(vwq paramvwq, int paramInt) {}
  
  public void run()
  {
    xvv.d("LbsManager", "onLocation Timeout  %d ms", new Object[] { Integer.valueOf(this.a) });
    this.this$0.a(false, this.this$0.b);
    vwq.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.lbs.LbsManager.2
 * JD-Core Version:    0.7.0.1
 */