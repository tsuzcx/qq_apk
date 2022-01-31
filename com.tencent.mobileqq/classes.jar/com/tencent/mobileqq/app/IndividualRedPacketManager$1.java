package com.tencent.mobileqq.app;

import ajzf;
import bbpe;
import bbpk;
import com.tencent.qphone.base.util.QLog;

public class IndividualRedPacketManager$1
  implements Runnable
{
  public IndividualRedPacketManager$1(ajzf paramajzf) {}
  
  public void run()
  {
    this.this$0.a(true);
    if (QLog.isColorLevel()) {
      QLog.d(ajzf.b(), 2, "AIO_BG_WIDTH:" + this.this$0.b);
    }
    this.this$0.a().d();
    this.this$0.a().c();
    this.this$0.a();
    if (this.this$0.j > 0)
    {
      bbpk localbbpk = this.this$0.a().a(String.valueOf(this.this$0.j), true);
      if ((localbbpk == null) || (localbbpk.a == null) || (localbbpk.b == null) || (localbbpk.c == null)) {
        this.this$0.a().a(16L, String.valueOf(this.this$0.j), null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.IndividualRedPacketManager.1
 * JD-Core Version:    0.7.0.1
 */