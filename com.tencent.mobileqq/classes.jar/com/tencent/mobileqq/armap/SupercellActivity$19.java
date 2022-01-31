package com.tencent.mobileqq.armap;

import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import com.tencent.qphone.base.util.QLog;

class SupercellActivity$19
  implements Camera.PreviewCallback
{
  SupercellActivity$19(SupercellActivity paramSupercellActivity) {}
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SupercellActivity", 2, "cameraWidth : ww  " + SupercellActivity.access$2000(this.this$0).a + ",cameraHeight 1 :" + SupercellActivity.access$2000(this.this$0).b + "   " + paramArrayOfByte.length + "   " + SupercellActivity.access$2000(this.this$0).a * SupercellActivity.access$2000(this.this$0).b * 3 / 2);
    }
    if (SupercellActivity.access$2000(this.this$0).a * SupercellActivity.access$2000(this.this$0).b * 3 / 2 != paramArrayOfByte.length) {
      return;
    }
    SupercellActivity.access$2802(this.this$0, paramArrayOfByte);
    SupercellActivity.access$200(this.this$0).queueEvent(this.this$0.yuvDataTextureRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.SupercellActivity.19
 * JD-Core Version:    0.7.0.1
 */