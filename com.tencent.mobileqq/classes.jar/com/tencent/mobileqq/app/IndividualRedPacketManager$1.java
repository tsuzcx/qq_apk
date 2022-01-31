package com.tencent.mobileqq.app;

import alvg;
import bdsv;
import bdtb;
import com.tencent.qphone.base.util.QLog;

public class IndividualRedPacketManager$1
  implements Runnable
{
  public IndividualRedPacketManager$1(alvg paramalvg) {}
  
  public void run()
  {
    this.this$0.a(true);
    if (QLog.isColorLevel()) {
      QLog.d(alvg.b(), 2, "AIO_BG_WIDTH:" + this.this$0.b);
    }
    this.this$0.a().d();
    this.this$0.a().c();
    this.this$0.a();
    if (this.this$0.j > 0)
    {
      bdtb localbdtb = this.this$0.a().a(String.valueOf(this.this$0.j), true);
      if ((localbdtb == null) || (localbdtb.a == null) || (localbdtb.b == null) || (localbdtb.c == null)) {
        this.this$0.a().a(16L, String.valueOf(this.this$0.j), null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.IndividualRedPacketManager.1
 * JD-Core Version:    0.7.0.1
 */