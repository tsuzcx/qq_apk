package com.tencent.mobileqq.armap;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;

class SupercellActivity$12
  implements SurfaceTexture.OnFrameAvailableListener
{
  SupercellActivity$12(SupercellActivity paramSupercellActivity) {}
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    SupercellActivity.access$200(this.this$0).queueEvent(SupercellActivity.access$2100(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.SupercellActivity.12
 * JD-Core Version:    0.7.0.1
 */