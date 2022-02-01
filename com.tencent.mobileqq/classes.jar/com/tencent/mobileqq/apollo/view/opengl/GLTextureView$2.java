package com.tencent.mobileqq.apollo.view.opengl;

import com.tencent.qphone.base.util.QLog;

class GLTextureView$2
  implements Runnable
{
  GLTextureView$2(GLTextureView paramGLTextureView) {}
  
  public void run()
  {
    if (GLTextureView.access$000(this.this$0) != 1.0F) {
      GLTextureView.access$100(this.this$0, 1.0F);
    }
    QLog.d("GLTextureView", 1, "TextureView mCheckSurfaceChangeTask, ableToDraw:" + this.this$0.mGLThread.a() + ",alpha:" + GLTextureView.access$000(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.opengl.GLTextureView.2
 * JD-Core Version:    0.7.0.1
 */