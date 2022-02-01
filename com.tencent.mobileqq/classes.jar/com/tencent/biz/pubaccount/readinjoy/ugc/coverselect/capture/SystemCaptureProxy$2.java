package com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.capture;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;

class SystemCaptureProxy$2
  implements Runnable
{
  SystemCaptureProxy$2(SystemCaptureProxy paramSystemCaptureProxy, CaptureTask paramCaptureTask, CaptureTask.OnCaptureCallback paramOnCaptureCallback) {}
  
  public void run()
  {
    if (SystemCaptureProxy.a(this.this$0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SystemCaptureProxy", 2, "capture return for released.");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SystemCaptureProxy", 2, "capture captureTask:" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureCaptureTask + "  useScaleAPI:" + SystemCaptureProxy.b(this.this$0));
    }
    for (Object localObject = null;; localObject = localBitmap2)
    {
      try
      {
        if ((!SystemCaptureProxy.b(this.this$0)) || (Build.VERSION.SDK_INT < 27)) {
          break label167;
        }
        localBitmap2 = SystemCaptureProxy.a(this.this$0).getScaledFrameAtTime(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureCaptureTask.c * 1000, 0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureCaptureTask.d, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureCaptureTask.e);
        localObject = localBitmap2;
      }
      catch (Error localError)
      {
        for (;;)
        {
          Bitmap localBitmap2;
          SystemCaptureProxy.a(this.this$0, false);
          Bitmap localBitmap1 = SystemCaptureProxy.a(this.this$0, SystemCaptureProxy.a(this.this$0), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureCaptureTask);
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          label167:
          QLog.e("SystemCaptureProxy", 1, "capture failed for captureTask" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureCaptureTask, localThrowable);
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureCaptureTask$OnCaptureCallback.a();
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureCaptureTask$OnCaptureCallback == null) {
        break;
      }
      if ((localObject == null) || (localObject.isRecycled())) {
        break label256;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureCaptureTask$OnCaptureCallback.a(localObject, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureCaptureTask);
      return;
      localBitmap2 = SystemCaptureProxy.a(this.this$0, SystemCaptureProxy.a(this.this$0), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureCaptureTask);
    }
    label256:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.capture.SystemCaptureProxy.2
 * JD-Core Version:    0.7.0.1
 */