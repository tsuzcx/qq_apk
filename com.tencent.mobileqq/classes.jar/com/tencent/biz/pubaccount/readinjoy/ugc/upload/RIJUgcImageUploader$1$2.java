package com.tencent.biz.pubaccount.readinjoy.ugc.upload;

import com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer.ImageUploadController;
import com.tencent.qphone.base.util.QLog;

class RIJUgcImageUploader$1$2
  implements Runnable
{
  RIJUgcImageUploader$1$2(RIJUgcImageUploader.1 param1) {}
  
  public void run()
  {
    if (RIJUgcImageUploader.a(this.a.this$0))
    {
      RIJUgcImageUploader.a(this.a.this$0, false);
      QLog.i(RIJUgcImageUploader.a, 1, "cancel before upload");
      return;
    }
    RIJUgcImageUploader.a(this.a.this$0).a(RIJUgcImageUploader.a(this.a.this$0), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.upload.RIJUgcImageUploader.1.2
 * JD-Core Version:    0.7.0.1
 */