package com.tencent.jalpha.videoplayer.view;

import com.tencent.jalpha.common.Logger;

class GLTextureView$1
  implements Runnable
{
  GLTextureView$1(GLTextureView paramGLTextureView) {}
  
  public void run()
  {
    GLTextureView.access$000(this.this$0).onWindowResize(this.this$0.getWidth(), this.this$0.getHeight());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TextureView mCheckAlphaTask,alpha:");
    localStringBuilder.append(GLTextureView.access$100(this.this$0));
    Logger.d("GLTextureView", localStringBuilder.toString());
    if (GLTextureView.access$100(this.this$0) != 1.0F) {
      GLTextureView.access$200(this.this$0, 1.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.jalpha.videoplayer.view.GLTextureView.1
 * JD-Core Version:    0.7.0.1
 */