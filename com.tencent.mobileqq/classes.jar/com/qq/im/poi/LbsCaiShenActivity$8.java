package com.qq.im.poi;

import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import com.tencent.mobileqq.armap.ARGLSurfaceView;
import com.tencent.mobileqq.armap.CameraSurfaceView;

class LbsCaiShenActivity$8
  implements Camera.PreviewCallback
{
  LbsCaiShenActivity$8(LbsCaiShenActivity paramLbsCaiShenActivity) {}
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    while (LbsCaiShenActivity.access$200(this.this$0).a * LbsCaiShenActivity.access$200(this.this$0).b * 3 / 2 > paramArrayOfByte.length)
    {
      LbsCaiShenActivity.access$200(this.this$0).a /= 2;
      LbsCaiShenActivity.access$200(this.this$0).b /= 2;
    }
    LbsCaiShenActivity.access$302(this.this$0, paramArrayOfByte);
    LbsCaiShenActivity.access$400(this.this$0).queueEvent(this.this$0.yuvDataTextureRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.qq.im.poi.LbsCaiShenActivity.8
 * JD-Core Version:    0.7.0.1
 */