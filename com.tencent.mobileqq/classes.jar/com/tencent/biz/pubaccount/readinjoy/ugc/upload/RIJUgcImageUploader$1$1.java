package com.tencent.biz.pubaccount.readinjoy.ugc.upload;

import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer.FileUploadController.FileUploadListener;
import com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer.ImageUploadController;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;

class RIJUgcImageUploader$1$1
  implements FileUploadController.FileUploadListener
{
  RIJUgcImageUploader$1$1(RIJUgcImageUploader.1 param1) {}
  
  public void a() {}
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.i(RIJUgcImageUploader.a, 2, "uploadImage finish, url=" + paramString1);
    }
    RIJUgcImageUploader.a(this.a.this$0, false);
    ThreadManagerV2.getUIHandlerV2().post(new RIJUgcImageUploader.1.1.1(this, paramInt, paramString1));
    RIJUgcImageUploader.a(this.a.this$0).b();
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    RIJUgcImageUploader.a(this.a.this$0).a(paramLong1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.upload.RIJUgcImageUploader.1.1
 * JD-Core Version:    0.7.0.1
 */