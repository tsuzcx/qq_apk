package com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import qvc;

public class ViolaVideoUpdateController$1
  implements Runnable
{
  public ViolaVideoUpdateController$1(qvc paramqvc) {}
  
  public void run()
  {
    qvc.a(this.this$0).run();
    ThreadManagerV2.getUIHandlerV2().postDelayed(this, qvc.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.ViolaVideoUpdateController.1
 * JD-Core Version:    0.7.0.1
 */