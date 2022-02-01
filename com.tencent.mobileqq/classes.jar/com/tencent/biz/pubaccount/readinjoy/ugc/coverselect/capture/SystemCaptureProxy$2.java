package com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.capture;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;
import rku;
import rkw;
import rld;

public class SystemCaptureProxy$2
  implements Runnable
{
  public SystemCaptureProxy$2(rld paramrld, rku paramrku, rkw paramrkw) {}
  
  public void run()
  {
    if (rld.a(this.this$0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SystemCaptureProxy", 2, "capture return for released.");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SystemCaptureProxy", 2, "capture captureTask:" + this.jdField_a_of_type_Rku + "  useScaleAPI:" + rld.b(this.this$0));
    }
    for (Object localObject = null;; localObject = localBitmap2)
    {
      try
      {
        if ((!rld.b(this.this$0)) || (Build.VERSION.SDK_INT < 27)) {
          break label167;
        }
        localBitmap2 = rld.a(this.this$0).getScaledFrameAtTime(this.jdField_a_of_type_Rku.c * 1000, 0, this.jdField_a_of_type_Rku.d, this.jdField_a_of_type_Rku.e);
        localObject = localBitmap2;
      }
      catch (Error localError)
      {
        for (;;)
        {
          Bitmap localBitmap2;
          rld.a(this.this$0, false);
          Bitmap localBitmap1 = rld.a(this.this$0, rld.a(this.this$0), this.jdField_a_of_type_Rku);
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          label167:
          QLog.e("SystemCaptureProxy", 1, "capture failed for captureTask" + this.jdField_a_of_type_Rku, localThrowable);
        }
        this.jdField_a_of_type_Rkw.a();
      }
      if (this.jdField_a_of_type_Rkw == null) {
        break;
      }
      if ((localObject == null) || (localObject.isRecycled())) {
        break label256;
      }
      this.jdField_a_of_type_Rkw.a(localObject, this.jdField_a_of_type_Rku);
      return;
      localBitmap2 = rld.a(this.this$0, rld.a(this.this$0), this.jdField_a_of_type_Rku);
    }
    label256:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.capture.SystemCaptureProxy.2
 * JD-Core Version:    0.7.0.1
 */