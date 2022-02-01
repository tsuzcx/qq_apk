package com.tencent.mobileqq.ar.ARRenderModel;

import apca;
import apce;
import apef;
import apem;
import apeo;

public class ARTransferPromotionRenderable$11
  implements Runnable
{
  public ARTransferPromotionRenderable$11(apem paramapem) {}
  
  public void run()
  {
    if (apem.a(this.this$0) == 6)
    {
      if ((apem.a(this.this$0) != null) && (!apem.a(this.this$0).a.booleanValue())) {
        apem.a(this.this$0).b(0, 1);
      }
      if (((apem.a(this.this$0).a() != 0) && (apem.c(this.this$0))) || (apem.a(this.this$0).a.booleanValue())) {
        break label124;
      }
      this.this$0.a();
    }
    for (;;)
    {
      if (apem.a(this.this$0) == null) {
        apem.a(this.this$0, new apca());
      }
      return;
      label124:
      if (!apem.a(this.this$0).a.booleanValue()) {
        apem.a(this.this$0).c(1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.11
 * JD-Core Version:    0.7.0.1
 */