package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.view.View;
import android.view.View.OnLayoutChangeListener;

class GLTextureView$1
  implements View.OnLayoutChangeListener
{
  GLTextureView$1(GLTextureView paramGLTextureView) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    paramView = this.a;
    paramView.a(paramView.getSurfaceTexture(), 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.GLTextureView.1
 * JD-Core Version:    0.7.0.1
 */