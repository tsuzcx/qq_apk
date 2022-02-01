package com.tencent.livesdk.livesdkplayer.renderview;

import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;

class TPSurfaceView$1
  implements SurfaceHolder.Callback
{
  TPSurfaceView$1(TPSurfaceView paramTPSurfaceView) {}
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if (TPSurfaceView.access$000(this.this$0) != null) {
      TPSurfaceView.access$000(this.this$0).onViewChanged(paramSurfaceHolder, this.this$0.getWidth(), this.this$0.getHeight());
    }
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (TPSurfaceView.access$000(this.this$0) != null) {
      TPSurfaceView.access$000(this.this$0).onViewCreated(paramSurfaceHolder, this.this$0.getWidth(), this.this$0.getHeight());
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    if (TPSurfaceView.access$000(this.this$0) != null) {
      TPSurfaceView.access$000(this.this$0).onViewDestroyed(paramSurfaceHolder);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.livesdkplayer.renderview.TPSurfaceView.1
 * JD-Core Version:    0.7.0.1
 */