package com.tencent.biz.qqstory.model.lbs;

import tev;
import veg;

public class LbsManager$2
  implements Runnable
{
  public LbsManager$2(tev paramtev, int paramInt) {}
  
  public void run()
  {
    veg.d("LbsManager", "onLocation Timeout  %d ms", new Object[] { Integer.valueOf(this.a) });
    this.this$0.a(false, this.this$0.b);
    tev.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.lbs.LbsManager.2
 * JD-Core Version:    0.7.0.1
 */