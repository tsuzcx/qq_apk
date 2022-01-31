package com.tencent.mobileqq.armap;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;

class SupercellActivity$4
  implements Runnable
{
  SupercellActivity$4(SupercellActivity paramSupercellActivity) {}
  
  @TargetApi(11)
  public void run()
  {
    if (this.this$0.isStartPlayEnd) {}
    for (;;)
    {
      return;
      if ((this.this$0.videoWidth <= 0) || (this.this$0.videoHeight <= 0)) {
        continue;
      }
      SupercellActivity.access$200(this.this$0);
      ARGLSurfaceView.setVideoSize(SupercellActivity.access$600(this.this$0), this.this$0.videoWidth, this.this$0.videoHeight);
      try
      {
        SupercellActivity.access$700(this.this$0).updateTexImage();
        if (this.this$0.dataCount < 10)
        {
          Object localObject = this.this$0;
          ((SupercellActivity)localObject).dataCount += 1;
          localObject = new float[16];
          SupercellActivity.access$700(this.this$0).getTransformMatrix((float[])localObject);
          SupercellActivity.access$200(this.this$0).nativeTextureM(SupercellActivity.access$600(this.this$0), (float[])localObject);
        }
        if (!this.this$0.isFristData) {
          continue;
        }
        this.this$0.isFristData = false;
        SupercellActivity.access$200(this.this$0);
        ARGLSurfaceView.setDrawTexture(SupercellActivity.access$600(this.this$0), SupercellActivity.access$800(this.this$0));
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.SupercellActivity.4
 * JD-Core Version:    0.7.0.1
 */