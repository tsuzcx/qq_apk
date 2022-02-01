package com.tencent.biz.pubaccount.readinjoy.ugc.upload;

import com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer.ImageUploadController;
import com.tencent.mobileqq.app.ThreadManagerV2;

class RIJUgcImageUploader$1
  implements Runnable
{
  RIJUgcImageUploader$1(RIJUgcImageUploader paramRIJUgcImageUploader) {}
  
  public void run()
  {
    RIJUgcImageUploader.a(this.this$0, new ImageUploadController(RIJUgcImageUploader.a(this.this$0), RIJUgcImageUploader.a(this.this$0), new RIJUgcImageUploader.1.1(this)));
    ThreadManagerV2.excute(new RIJUgcImageUploader.1.2(this), 128, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.upload.RIJUgcImageUploader.1
 * JD-Core Version:    0.7.0.1
 */