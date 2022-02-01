package com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.capture;

import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;

class CaptureTask$1
  implements CaptureTask.OnCaptureCallback
{
  CaptureTask$1(CaptureTask paramCaptureTask, Bitmap[] paramArrayOfBitmap) {}
  
  public void a()
  {
    CaptureTask.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureCaptureTask);
    if (CaptureTask.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureCaptureTask) <= 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CaptureTask", 2, "onCaptureFailed try angin tryCount:" + CaptureTask.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureCaptureTask) + "  CaptureTask:" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureCaptureTask);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureCaptureTask.a(null);
    }
  }
  
  public void a(Bitmap paramBitmap, CaptureTask paramCaptureTask)
  {
    this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[0] = paramBitmap;
    CaptureTask.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureCaptureTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.capture.CaptureTask.1
 * JD-Core Version:    0.7.0.1
 */