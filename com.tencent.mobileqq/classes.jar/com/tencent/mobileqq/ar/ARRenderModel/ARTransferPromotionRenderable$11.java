package com.tencent.mobileqq.ar.ARRenderModel;

import amoq;
import amou;
import amqu;
import amrb;
import amrd;

public class ARTransferPromotionRenderable$11
  implements Runnable
{
  public ARTransferPromotionRenderable$11(amrb paramamrb) {}
  
  public void run()
  {
    if (amrb.a(this.this$0) == 6)
    {
      if ((amrb.a(this.this$0) != null) && (!amrb.a(this.this$0).a.booleanValue())) {
        amrb.a(this.this$0).b(0, 1);
      }
      if (((amrb.a(this.this$0).a() != 0) && (amrb.c(this.this$0))) || (amrb.a(this.this$0).a.booleanValue())) {
        break label124;
      }
      this.this$0.a();
    }
    for (;;)
    {
      if (amrb.a(this.this$0) == null) {
        amrb.a(this.this$0, new amoq());
      }
      return;
      label124:
      if (!amrb.a(this.this$0).a.booleanValue()) {
        amrb.a(this.this$0).c(1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.11
 * JD-Core Version:    0.7.0.1
 */