package com.tencent.mobileqq.ar.ARRenderModel;

import aorw;
import aosa;
import aoua;
import aouh;
import aouj;

public class ARTransferPromotionRenderable$11
  implements Runnable
{
  public ARTransferPromotionRenderable$11(aouh paramaouh) {}
  
  public void run()
  {
    if (aouh.a(this.this$0) == 6)
    {
      if ((aouh.a(this.this$0) != null) && (!aouh.a(this.this$0).a.booleanValue())) {
        aouh.a(this.this$0).b(0, 1);
      }
      if (((aouh.a(this.this$0).a() != 0) && (aouh.c(this.this$0))) || (aouh.a(this.this$0).a.booleanValue())) {
        break label124;
      }
      this.this$0.a();
    }
    for (;;)
    {
      if (aouh.a(this.this$0) == null) {
        aouh.a(this.this$0, new aorw());
      }
      return;
      label124:
      if (!aouh.a(this.this$0).a.booleanValue()) {
        aouh.a(this.this$0).c(1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.11
 * JD-Core Version:    0.7.0.1
 */