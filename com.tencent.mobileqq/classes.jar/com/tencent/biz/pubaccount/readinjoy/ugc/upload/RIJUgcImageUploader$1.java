package com.tencent.biz.pubaccount.readinjoy.ugc.upload;

import com.tencent.mobileqq.app.ThreadManagerV2;
import sdq;
import sdr;
import sec;

public class RIJUgcImageUploader$1
  implements Runnable
{
  public RIJUgcImageUploader$1(sdq paramsdq) {}
  
  public void run()
  {
    sdq.a(this.this$0, new sec(sdq.a(this.this$0), sdq.a(this.this$0), new sdr(this)));
    ThreadManagerV2.excute(new RIJUgcImageUploader.1.2(this), 128, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.upload.RIJUgcImageUploader.1
 * JD-Core Version:    0.7.0.1
 */