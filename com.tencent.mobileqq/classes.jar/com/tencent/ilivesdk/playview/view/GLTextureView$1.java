package com.tencent.ilivesdk.playview.view;

import com.tencent.ilivesdk.utils.LogUtils;

class GLTextureView$1
  implements Runnable
{
  GLTextureView$1(GLTextureView paramGLTextureView) {}
  
  public void run()
  {
    GLTextureView.access$000(this.this$0).onWindowResize(this.this$0.getWidth(), this.this$0.getHeight());
    LogUtils.d("Render|GLTextureView", "TextureView mCheckAlphaTask,alpha:" + GLTextureView.access$100(this.this$0));
    if (GLTextureView.access$100(this.this$0) != 1.0F) {
      GLTextureView.access$200(this.this$0, 1.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.playview.view.GLTextureView.1
 * JD-Core Version:    0.7.0.1
 */