package com.tencent.mobileqq.ar.ARRenderModel;

import apfm;
import apfq;
import aphq;
import aphx;
import aphz;

public class ARTransferPromotionRenderable$11
  implements Runnable
{
  public ARTransferPromotionRenderable$11(aphx paramaphx) {}
  
  public void run()
  {
    if (aphx.a(this.this$0) == 6)
    {
      if ((aphx.a(this.this$0) != null) && (!aphx.a(this.this$0).a.booleanValue())) {
        aphx.a(this.this$0).b(0, 1);
      }
      if (((aphx.a(this.this$0).a() != 0) && (aphx.c(this.this$0))) || (aphx.a(this.this$0).a.booleanValue())) {
        break label124;
      }
      this.this$0.a();
    }
    for (;;)
    {
      if (aphx.a(this.this$0) == null) {
        aphx.a(this.this$0, new apfm());
      }
      return;
      label124:
      if (!aphx.a(this.this$0).a.booleanValue()) {
        aphx.a(this.this$0).c(1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.11
 * JD-Core Version:    0.7.0.1
 */