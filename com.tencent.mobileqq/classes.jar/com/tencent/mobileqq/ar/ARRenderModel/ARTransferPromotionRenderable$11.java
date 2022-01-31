package com.tencent.mobileqq.ar.ARRenderModel;

import akjp;
import akjt;
import aklt;
import akma;
import akmc;

public class ARTransferPromotionRenderable$11
  implements Runnable
{
  public ARTransferPromotionRenderable$11(akma paramakma) {}
  
  public void run()
  {
    if (akma.a(this.this$0) == 6)
    {
      if ((akma.a(this.this$0) != null) && (!akma.a(this.this$0).a.booleanValue())) {
        akma.a(this.this$0).b(0, 1);
      }
      if (((akma.a(this.this$0).a() != 0) && (akma.c(this.this$0))) || (akma.a(this.this$0).a.booleanValue())) {
        break label124;
      }
      this.this$0.a();
    }
    for (;;)
    {
      if (akma.a(this.this$0) == null) {
        akma.a(this.this$0, new akjp());
      }
      return;
      label124:
      if (!akma.a(this.this$0).a.booleanValue()) {
        akma.a(this.this$0).c(1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.11
 * JD-Core Version:    0.7.0.1
 */