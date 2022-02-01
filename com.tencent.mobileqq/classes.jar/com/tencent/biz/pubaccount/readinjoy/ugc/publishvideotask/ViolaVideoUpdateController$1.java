package com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;

class ViolaVideoUpdateController$1
  implements Runnable
{
  ViolaVideoUpdateController$1(ViolaVideoUpdateController paramViolaVideoUpdateController) {}
  
  public void run()
  {
    ViolaVideoUpdateController.a(this.this$0).run();
    ThreadManagerV2.getUIHandlerV2().postDelayed(this, ViolaVideoUpdateController.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.ViolaVideoUpdateController.1
 * JD-Core Version:    0.7.0.1
 */