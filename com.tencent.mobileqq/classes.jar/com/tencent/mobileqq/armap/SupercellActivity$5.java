package com.tencent.mobileqq.armap;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;

class SupercellActivity$5
  implements Runnable
{
  SupercellActivity$5(SupercellActivity paramSupercellActivity) {}
  
  @TargetApi(11)
  public void run()
  {
    for (;;)
    {
      try
      {
        SupercellActivity.access$900(this.this$0).updateTexImage();
        if (this.this$0.dataEndCount < 10)
        {
          SupercellActivity localSupercellActivity = this.this$0;
          localSupercellActivity.dataEndCount += 1;
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        continue;
      }
      try
      {
        SupercellActivity.access$900(this.this$0).getTransformMatrix(this.this$0.m2);
        SupercellActivity.access$200(this.this$0).nativeTextureM(SupercellActivity.access$600(this.this$0), this.this$0.m2);
        if (this.this$0.isFristData)
        {
          this.this$0.isFristData = false;
          SupercellActivity.access$200(this.this$0);
          ARGLSurfaceView.setDrawTexture(SupercellActivity.access$600(this.this$0), SupercellActivity.access$1000(this.this$0));
        }
        return;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.SupercellActivity.5
 * JD-Core Version:    0.7.0.1
 */