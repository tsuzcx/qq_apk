package com.tencent.mobileqq.ark;

import aqcz;
import aqde;
import java.lang.ref.WeakReference;

public class ArkTipsManager$4
  implements Runnable
{
  public ArkTipsManager$4(aqcz paramaqcz, long paramLong) {}
  
  public void run()
  {
    if ((aqcz.a(this.this$0) != null) && (this.a == aqcz.a(this.this$0).b))
    {
      aqcz.a(this.this$0, this.a);
      aqcz.a(this.this$0, new WeakReference(aqcz.a(this.this$0).a));
      this.this$0.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkTipsManager.4
 * JD-Core Version:    0.7.0.1
 */