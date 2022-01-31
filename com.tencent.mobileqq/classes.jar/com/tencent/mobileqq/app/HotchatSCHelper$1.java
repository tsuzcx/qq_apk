package com.tencent.mobileqq.app;

import ajyv;
import ajyx;
import android.os.Handler;

public class HotchatSCHelper$1
  implements Runnable
{
  public HotchatSCHelper$1(ajyv paramajyv, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    if (!this.this$0.jdField_a_of_type_Boolean) {
      return;
    }
    this.this$0.jdField_a_of_type_Ajyx.a();
    long l1 = System.currentTimeMillis();
    long l2 = this.a - Math.abs(l1 - this.b);
    if (l2 < 0L) {
      l1 = 100L;
    }
    for (;;)
    {
      this.this$0.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, l1);
      return;
      l1 = l2;
      if (l2 > this.a) {
        l1 = this.a;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.HotchatSCHelper.1
 * JD-Core Version:    0.7.0.1
 */