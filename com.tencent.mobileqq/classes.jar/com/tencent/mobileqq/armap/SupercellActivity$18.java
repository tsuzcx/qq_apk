package com.tencent.mobileqq.armap;

import android.opengl.GLES20;
import com.tencent.qphone.base.util.QLog;

class SupercellActivity$18
  implements Runnable
{
  SupercellActivity$18(SupercellActivity paramSupercellActivity) {}
  
  public void run()
  {
    Object localObject = SupercellActivity.access$2800(this.this$0);
    SupercellActivity.access$2802(this.this$0, null);
    if (localObject != null)
    {
      if (!this.this$0.renderisFrist) {
        break label167;
      }
      this.this$0.yuvTextur = new int[2];
      GLES20.glGenTextures(2, this.this$0.yuvTextur, 0);
      if (QLog.isColorLevel()) {
        QLog.i("SupercellActivity", 2, "yuvTextur :" + this.this$0.yuvTextur[0] + ", yuvTextur 1 :" + this.this$0.yuvTextur[1]);
      }
      if ((this.this$0.yuvTextur[0] == 0) || (this.this$0.yuvTextur[0] == -1)) {
        this.this$0.yuvTextur = null;
      }
    }
    else
    {
      return;
    }
    this.this$0.yuvTextur[0] = 20000;
    this.this$0.yuvTextur[1] = 20001;
    label167:
    this.this$0.drawYuvToTexture(SupercellActivity.access$2000(this.this$0).a, SupercellActivity.access$2000(this.this$0).b, (byte[])localObject, this.this$0.yuvTextur);
    if ((this.this$0.videoWidth > 0) && (this.this$0.videoHeight > 0))
    {
      SupercellActivity.access$200(this.this$0);
      ARGLSurfaceView.setVideoSize(SupercellActivity.access$600(this.this$0), this.this$0.videoWidth, this.this$0.videoHeight);
    }
    if (this.this$0.renderisFrist)
    {
      SupercellActivity.access$200(this.this$0).nativeSetCameraYUVTexture(SupercellActivity.access$200(this.this$0).mEngineHandler, this.this$0.yuvTextur[0], this.this$0.yuvTextur[1], SupercellActivity.access$2000(this.this$0).c);
      this.this$0.renderisFrist = false;
    }
    if (this.this$0.renderCount == 2) {
      this.this$0.resizeSurface();
    }
    localObject = this.this$0;
    ((SupercellActivity)localObject).renderCount += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.SupercellActivity.18
 * JD-Core Version:    0.7.0.1
 */