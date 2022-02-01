package com.tencent.mobileqq.ark;

import java.lang.ref.WeakReference;

class ArkTipsManager$4
  implements Runnable
{
  ArkTipsManager$4(ArkTipsManager paramArkTipsManager, long paramLong) {}
  
  public void run()
  {
    if ((ArkTipsManager.a(this.this$0) != null) && (this.a == ArkTipsManager.a(this.this$0).g))
    {
      ArkTipsManager.a(this.this$0, this.a);
      ArkTipsManager localArkTipsManager = this.this$0;
      ArkTipsManager.a(localArkTipsManager, new WeakReference(ArkTipsManager.a(localArkTipsManager).a));
      this.this$0.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkTipsManager.4
 * JD-Core Version:    0.7.0.1
 */