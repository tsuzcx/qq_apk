package com.tencent.av.ui.redbag;

import mqb;
import mqw;
import mqy;

public class AVRedBagMgr$4
  implements Runnable
{
  public AVRedBagMgr$4(mqb parammqb, mqy parammqy) {}
  
  public void run()
  {
    if (this.a.b()) {
      this.this$0.a(this.this$0.a(), this.a);
    }
    do
    {
      return;
      mqb.a(mqb.c(this.this$0), this.a);
    } while (!this.a.a());
    mqw.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.redbag.AVRedBagMgr.4
 * JD-Core Version:    0.7.0.1
 */