package com.tencent.biz.pubaccount.readinjoy.ugc.upload;

import com.tencent.mobileqq.app.ThreadManagerV2;
import qxg;
import qxh;
import qxs;

public class RIJUgcImageUploader$1
  implements Runnable
{
  public RIJUgcImageUploader$1(qxg paramqxg) {}
  
  public void run()
  {
    qxg.a(this.this$0, new qxs(qxg.a(this.this$0), qxg.a(this.this$0), new qxh(this)));
    ThreadManagerV2.excute(new RIJUgcImageUploader.1.2(this), 128, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.upload.RIJUgcImageUploader.1
 * JD-Core Version:    0.7.0.1
 */