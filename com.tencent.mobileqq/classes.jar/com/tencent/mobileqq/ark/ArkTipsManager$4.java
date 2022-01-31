package com.tencent.mobileqq.ark;

import aluc;
import aluh;
import java.lang.ref.WeakReference;

public class ArkTipsManager$4
  implements Runnable
{
  public ArkTipsManager$4(aluc paramaluc, long paramLong) {}
  
  public void run()
  {
    if ((aluc.a(this.this$0) != null) && (this.a == aluc.a(this.this$0).b))
    {
      aluc.a(this.this$0, this.a);
      aluc.a(this.this$0, new WeakReference(aluc.a(this.this$0).a));
      this.this$0.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkTipsManager.4
 * JD-Core Version:    0.7.0.1
 */