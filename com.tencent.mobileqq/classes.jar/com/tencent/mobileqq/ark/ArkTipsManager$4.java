package com.tencent.mobileqq.ark;

import anku;
import ankz;
import java.lang.ref.WeakReference;

public class ArkTipsManager$4
  implements Runnable
{
  public ArkTipsManager$4(anku paramanku, long paramLong) {}
  
  public void run()
  {
    if ((anku.a(this.this$0) != null) && (this.a == anku.a(this.this$0).b))
    {
      anku.a(this.this$0, this.a);
      anku.a(this.this$0, new WeakReference(anku.a(this.this$0).a));
      this.this$0.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkTipsManager.4
 * JD-Core Version:    0.7.0.1
 */