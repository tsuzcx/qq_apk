package com.tencent.mobileqq.app;

import anxc;
import bhne;
import bhnk;
import com.tencent.qphone.base.util.QLog;

public class IndividualRedPacketManager$1
  implements Runnable
{
  public IndividualRedPacketManager$1(anxc paramanxc) {}
  
  public void run()
  {
    this.this$0.a(true);
    if (QLog.isColorLevel()) {
      QLog.d(anxc.b(), 2, "AIO_BG_WIDTH:" + this.this$0.b);
    }
    this.this$0.a().d();
    this.this$0.a().c();
    this.this$0.a();
    if (this.this$0.j > 0)
    {
      bhnk localbhnk = this.this$0.a().a(String.valueOf(this.this$0.j), true);
      if ((localbhnk == null) || (localbhnk.a == null) || (localbhnk.b == null) || (localbhnk.c == null)) {
        this.this$0.a().a(16L, String.valueOf(this.this$0.j), null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.IndividualRedPacketManager.1
 * JD-Core Version:    0.7.0.1
 */