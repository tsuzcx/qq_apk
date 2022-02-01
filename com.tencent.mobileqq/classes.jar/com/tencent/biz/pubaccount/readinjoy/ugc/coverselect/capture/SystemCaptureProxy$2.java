package com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.capture;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;
import rmz;
import rnb;
import rni;

public class SystemCaptureProxy$2
  implements Runnable
{
  public SystemCaptureProxy$2(rni paramrni, rmz paramrmz, rnb paramrnb) {}
  
  public void run()
  {
    if (rni.a(this.this$0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SystemCaptureProxy", 2, "capture return for released.");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SystemCaptureProxy", 2, "capture captureTask:" + this.jdField_a_of_type_Rmz + "  useScaleAPI:" + rni.b(this.this$0));
    }
    for (Object localObject = null;; localObject = localBitmap2)
    {
      try
      {
        if ((!rni.b(this.this$0)) || (Build.VERSION.SDK_INT < 27)) {
          break label167;
        }
        localBitmap2 = rni.a(this.this$0).getScaledFrameAtTime(this.jdField_a_of_type_Rmz.c * 1000, 0, this.jdField_a_of_type_Rmz.d, this.jdField_a_of_type_Rmz.e);
        localObject = localBitmap2;
      }
      catch (Error localError)
      {
        for (;;)
        {
          Bitmap localBitmap2;
          rni.a(this.this$0, false);
          Bitmap localBitmap1 = rni.a(this.this$0, rni.a(this.this$0), this.jdField_a_of_type_Rmz);
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          label167:
          QLog.e("SystemCaptureProxy", 1, "capture failed for captureTask" + this.jdField_a_of_type_Rmz, localThrowable);
        }
        this.jdField_a_of_type_Rnb.a();
      }
      if (this.jdField_a_of_type_Rnb == null) {
        break;
      }
      if ((localObject == null) || (localObject.isRecycled())) {
        break label256;
      }
      this.jdField_a_of_type_Rnb.a(localObject, this.jdField_a_of_type_Rmz);
      return;
      localBitmap2 = rni.a(this.this$0, rni.a(this.this$0), this.jdField_a_of_type_Rmz);
    }
    label256:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.capture.SystemCaptureProxy.2
 * JD-Core Version:    0.7.0.1
 */