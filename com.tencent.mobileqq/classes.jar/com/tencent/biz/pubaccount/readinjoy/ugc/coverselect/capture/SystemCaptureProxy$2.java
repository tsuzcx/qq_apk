package com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.capture;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import com.tencent.qphone.base.util.QLog;
import qrw;
import qry;
import qsf;

public class SystemCaptureProxy$2
  implements Runnable
{
  public SystemCaptureProxy$2(qsf paramqsf, qrw paramqrw, qry paramqry) {}
  
  public void run()
  {
    if (qsf.a(this.this$0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SystemCaptureProxy", 2, "capture return for released.");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SystemCaptureProxy", 2, "capture captureTask:" + this.jdField_a_of_type_Qrw + "  useScaleAPI:" + qsf.b(this.this$0));
    }
    for (Object localObject = null;; localObject = localBitmap2)
    {
      try
      {
        if (!qsf.b(this.this$0)) {
          break label159;
        }
        localBitmap2 = qsf.a(this.this$0).getScaledFrameAtTime(this.jdField_a_of_type_Qrw.c * 1000, 0, this.jdField_a_of_type_Qrw.d, this.jdField_a_of_type_Qrw.e);
        localObject = localBitmap2;
      }
      catch (Error localError)
      {
        for (;;)
        {
          Bitmap localBitmap2;
          qsf.a(this.this$0, false);
          Bitmap localBitmap1 = qsf.a(this.this$0, qsf.a(this.this$0), this.jdField_a_of_type_Qrw);
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          label159:
          QLog.e("SystemCaptureProxy", 1, "capture failed for captureTask" + this.jdField_a_of_type_Qrw, localThrowable);
        }
        this.jdField_a_of_type_Qry.a();
      }
      if (this.jdField_a_of_type_Qry == null) {
        break;
      }
      if ((localObject == null) || (localObject.isRecycled())) {
        break label248;
      }
      this.jdField_a_of_type_Qry.a(localObject, this.jdField_a_of_type_Qrw);
      return;
      localBitmap2 = qsf.a(this.this$0, qsf.a(this.this$0), this.jdField_a_of_type_Qrw);
    }
    label248:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.capture.SystemCaptureProxy.2
 * JD-Core Version:    0.7.0.1
 */