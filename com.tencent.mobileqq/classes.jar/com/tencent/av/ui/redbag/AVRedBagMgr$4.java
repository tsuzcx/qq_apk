package com.tencent.av.ui.redbag;

import mrt;
import mso;
import msq;

public class AVRedBagMgr$4
  implements Runnable
{
  public AVRedBagMgr$4(mrt parammrt, msq parammsq) {}
  
  public void run()
  {
    if (this.a.b()) {
      this.this$0.a(this.this$0.a(), this.a);
    }
    do
    {
      return;
      mrt.a(mrt.c(this.this$0), this.a);
    } while (!this.a.a());
    mso.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.redbag.AVRedBagMgr.4
 * JD-Core Version:    0.7.0.1
 */