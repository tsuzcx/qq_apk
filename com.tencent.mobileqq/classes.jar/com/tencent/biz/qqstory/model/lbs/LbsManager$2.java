package com.tencent.biz.qqstory.model.lbs;

import wll;
import ykq;

public class LbsManager$2
  implements Runnable
{
  public LbsManager$2(wll paramwll, int paramInt) {}
  
  public void run()
  {
    ykq.d("LbsManager", "onLocation Timeout  %d ms", new Object[] { Integer.valueOf(this.a) });
    this.this$0.a(false, this.this$0.b);
    wll.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.lbs.LbsManager.2
 * JD-Core Version:    0.7.0.1
 */