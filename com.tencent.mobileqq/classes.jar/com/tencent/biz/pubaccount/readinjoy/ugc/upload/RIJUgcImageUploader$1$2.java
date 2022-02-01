package com.tencent.biz.pubaccount.readinjoy.ugc.upload;

import com.tencent.qphone.base.util.QLog;
import rkb;
import rkn;

class RIJUgcImageUploader$1$2
  implements Runnable
{
  RIJUgcImageUploader$1$2(RIJUgcImageUploader.1 param1) {}
  
  public void run()
  {
    if (rkb.a(this.a.this$0))
    {
      rkb.a(this.a.this$0, false);
      QLog.i(rkb.a, 1, "cancel before upload");
      return;
    }
    rkb.a(this.a.this$0).a(rkb.a(this.a.this$0), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.upload.RIJUgcImageUploader.1.2
 * JD-Core Version:    0.7.0.1
 */