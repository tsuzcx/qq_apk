package com.tencent.mobileqq.armap;

import android.opengl.GLES20;
import com.tencent.qphone.base.util.QLog;

class CaiShenActivity$21
  implements Runnable
{
  CaiShenActivity$21(CaiShenActivity paramCaiShenActivity) {}
  
  public void run()
  {
    Object localObject = CaiShenActivity.access$2200(this.this$0);
    CaiShenActivity.access$2202(this.this$0, null);
    if (localObject != null)
    {
      if (!this.this$0.renderisFrist) {
        break label167;
      }
      this.this$0.yuvTextur = new int[2];
      GLES20.glGenTextures(2, this.this$0.yuvTextur, 0);
      if (QLog.isColorLevel()) {
        QLog.i("CaiShenActivity", 2, "yuvTextur :" + this.this$0.yuvTextur[0] + ", yuvTextur 1 :" + this.this$0.yuvTextur[1]);
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
    this.this$0.drawYuvToTexture(CaiShenActivity.access$2100(this.this$0).a, CaiShenActivity.access$2100(this.this$0).b, (byte[])localObject, this.this$0.yuvTextur);
    if (this.this$0.renderisFrist)
    {
      CaiShenActivity.access$600(this.this$0).nativeSetCameraYUVTexture(CaiShenActivity.access$600(this.this$0).mEngineHandler, this.this$0.yuvTextur[0], this.this$0.yuvTextur[1], CaiShenActivity.access$2100(this.this$0).c);
      this.this$0.renderisFrist = false;
    }
    if (this.this$0.renderCount == 2) {
      this.this$0.resizeSurface();
    }
    localObject = this.this$0;
    ((CaiShenActivity)localObject).renderCount += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.CaiShenActivity.21
 * JD-Core Version:    0.7.0.1
 */