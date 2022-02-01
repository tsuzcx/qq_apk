package com.tencent.biz.pubaccount.readinjoy.ugc.upload;

import com.tencent.mobileqq.app.ThreadManagerV2;
import rrb;
import rrc;
import rrn;

public class RIJUgcImageUploader$1
  implements Runnable
{
  public RIJUgcImageUploader$1(rrb paramrrb) {}
  
  public void run()
  {
    rrb.a(this.this$0, new rrn(rrb.a(this.this$0), rrb.a(this.this$0), new rrc(this)));
    ThreadManagerV2.excute(new RIJUgcImageUploader.1.2(this), 128, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.upload.RIJUgcImageUploader.1
 * JD-Core Version:    0.7.0.1
 */