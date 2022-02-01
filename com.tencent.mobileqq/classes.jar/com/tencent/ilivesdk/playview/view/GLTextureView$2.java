package com.tencent.ilivesdk.playview.view;

import android.view.View;
import android.view.View.OnLayoutChangeListener;

class GLTextureView$2
  implements View.OnLayoutChangeListener
{
  GLTextureView$2(GLTextureView paramGLTextureView) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this.this$0.surfaceChanged(this.this$0.getSurfaceTexture(), 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.playview.view.GLTextureView.2
 * JD-Core Version:    0.7.0.1
 */