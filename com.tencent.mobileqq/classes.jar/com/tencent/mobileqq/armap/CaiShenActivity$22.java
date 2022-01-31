package com.tencent.mobileqq.armap;

import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;

class CaiShenActivity$22
  implements Camera.PreviewCallback
{
  CaiShenActivity$22(CaiShenActivity paramCaiShenActivity) {}
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (CaiShenActivity.access$2100(this.this$0).a * CaiShenActivity.access$2100(this.this$0).b * 3 / 2 != paramArrayOfByte.length) {
      return;
    }
    CaiShenActivity.access$2202(this.this$0, paramArrayOfByte);
    CaiShenActivity.access$600(this.this$0).queueEvent(this.this$0.yuvDataTextureRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.CaiShenActivity.22
 * JD-Core Version:    0.7.0.1
 */