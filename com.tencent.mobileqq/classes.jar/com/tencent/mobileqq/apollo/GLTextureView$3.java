package com.tencent.mobileqq.apollo;

import com.tencent.qphone.base.util.QLog;

class GLTextureView$3
  implements Runnable
{
  GLTextureView$3(GLTextureView paramGLTextureView) {}
  
  public void run()
  {
    if ((GLTextureView.access$1800(this.this$0)) && (GLTextureView.access$1400(this.this$0)) && (GLTextureView.access$1900(this.this$0) != 1.0F)) {
      GLTextureView.access$2000(this.this$0, 1.0F);
    }
    if (QLog.isColorLevel()) {
      QLog.d("GLTextureView", 2, "TextureView mCheckSurfaceChangeTask, mSurfaceHadDraw:" + GLTextureView.access$1400(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.GLTextureView.3
 * JD-Core Version:    0.7.0.1
 */