package com.tencent.biz.pubaccount.readinjoy.ugc.upload;

import com.tencent.qphone.base.util.QLog;
import sdq;
import sec;

class RIJUgcImageUploader$1$2
  implements Runnable
{
  RIJUgcImageUploader$1$2(RIJUgcImageUploader.1 param1) {}
  
  public void run()
  {
    if (sdq.a(this.a.this$0))
    {
      sdq.a(this.a.this$0, false);
      QLog.i(sdq.a, 1, "cancel before upload");
      return;
    }
    sdq.a(this.a.this$0).a(sdq.a(this.a.this$0), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.upload.RIJUgcImageUploader.1.2
 * JD-Core Version:    0.7.0.1
 */