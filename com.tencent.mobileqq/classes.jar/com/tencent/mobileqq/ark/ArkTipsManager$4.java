package com.tencent.mobileqq.ark;

import appj;
import appo;
import java.lang.ref.WeakReference;

public class ArkTipsManager$4
  implements Runnable
{
  public ArkTipsManager$4(appj paramappj, long paramLong) {}
  
  public void run()
  {
    if ((appj.a(this.this$0) != null) && (this.a == appj.a(this.this$0).b))
    {
      appj.a(this.this$0, this.a);
      appj.a(this.this$0, new WeakReference(appj.a(this.this$0).a));
      this.this$0.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkTipsManager.4
 * JD-Core Version:    0.7.0.1
 */