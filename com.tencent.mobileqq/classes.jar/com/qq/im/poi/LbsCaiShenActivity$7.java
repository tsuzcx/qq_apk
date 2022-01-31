package com.qq.im.poi;

import android.opengl.GLES20;
import com.tencent.mobileqq.armap.ARGLSurfaceView;
import com.tencent.mobileqq.armap.CameraSurfaceView;
import com.tencent.qphone.base.util.QLog;

class LbsCaiShenActivity$7
  implements Runnable
{
  LbsCaiShenActivity$7(LbsCaiShenActivity paramLbsCaiShenActivity) {}
  
  public void run()
  {
    Object localObject = LbsCaiShenActivity.access$300(this.this$0);
    LbsCaiShenActivity.access$302(this.this$0, null);
    if (localObject != null)
    {
      if (!this.this$0.renderisFrist) {
        break label167;
      }
      this.this$0.yuvTextur = new int[2];
      GLES20.glGenTextures(2, this.this$0.yuvTextur, 0);
      if (QLog.isColorLevel()) {
        QLog.i("LbsPack", 2, "yuvTextur :" + this.this$0.yuvTextur[0] + ", yuvTextur 1 :" + this.this$0.yuvTextur[1]);
      }
      if ((this.this$0.yuvTextur[0] == 0) || (this.this$0.yuvTextur[0] == -1)) {
        this.this$0.yuvTextur = null;
      }
    }
    else
    {
      return;
    }
    this.this$0.yuvTextur[0] = 10000;
    this.this$0.yuvTextur[1] = 10001;
    label167:
    this.this$0.drawYuvToTexture(LbsCaiShenActivity.access$200(this.this$0).a, LbsCaiShenActivity.access$200(this.this$0).b, (byte[])localObject, this.this$0.yuvTextur);
    if (this.this$0.renderisFrist)
    {
      LbsCaiShenActivity.access$400(this.this$0).nativeSetCameraYUVTexture(LbsCaiShenActivity.access$400(this.this$0).getEngineHandler(), this.this$0.yuvTextur[0], this.this$0.yuvTextur[1], LbsCaiShenActivity.access$200(this.this$0).c);
      this.this$0.renderisFrist = false;
    }
    if (this.this$0.renderCount == 2) {
      this.this$0.resizeSurface();
    }
    localObject = this.this$0;
    ((LbsCaiShenActivity)localObject).renderCount += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.qq.im.poi.LbsCaiShenActivity.7
 * JD-Core Version:    0.7.0.1
 */