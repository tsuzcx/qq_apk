package com.tencent.mobileqq.ar.ARRenderModel;

import amtf;
import amtj;
import amvj;
import amvq;
import amvs;

public class ARTransferPromotionRenderable$11
  implements Runnable
{
  public ARTransferPromotionRenderable$11(amvq paramamvq) {}
  
  public void run()
  {
    if (amvq.a(this.this$0) == 6)
    {
      if ((amvq.a(this.this$0) != null) && (!amvq.a(this.this$0).a.booleanValue())) {
        amvq.a(this.this$0).b(0, 1);
      }
      if (((amvq.a(this.this$0).a() != 0) && (amvq.c(this.this$0))) || (amvq.a(this.this$0).a.booleanValue())) {
        break label124;
      }
      this.this$0.a();
    }
    for (;;)
    {
      if (amvq.a(this.this$0) == null) {
        amvq.a(this.this$0, new amtf());
      }
      return;
      label124:
      if (!amvq.a(this.this$0).a.booleanValue()) {
        amvq.a(this.this$0).c(1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.11
 * JD-Core Version:    0.7.0.1
 */