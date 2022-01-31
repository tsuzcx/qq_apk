package com.tencent.mobileqq.ark;

import anpd;
import anpi;
import java.lang.ref.WeakReference;

public class ArkTipsManager$4
  implements Runnable
{
  public ArkTipsManager$4(anpd paramanpd, long paramLong) {}
  
  public void run()
  {
    if ((anpd.a(this.this$0) != null) && (this.a == anpd.a(this.this$0).b))
    {
      anpd.a(this.this$0, this.a);
      anpd.a(this.this$0, new WeakReference(anpd.a(this.this$0).a));
      this.this$0.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkTipsManager.4
 * JD-Core Version:    0.7.0.1
 */