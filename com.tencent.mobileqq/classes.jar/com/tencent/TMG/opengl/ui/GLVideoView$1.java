package com.tencent.TMG.opengl.ui;

import com.tencent.TMG.opengl.texture.YUVTexture;
import com.tencent.TMG.opengl.texture.YUVTexture.GLRenderListener;
import com.tencent.TMG.utils.QLog;

class GLVideoView$1
  implements YUVTexture.GLRenderListener
{
  GLVideoView$1(GLVideoView paramGLVideoView) {}
  
  public void onRenderFlush()
  {
    this.this$0.flush();
    this.this$0.invalidate();
  }
  
  public void onRenderFrame()
  {
    this.this$0.invalidate();
  }
  
  public void onRenderInfoNotify(int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GLVideoView", 0, "onRenderInfoNotify uin: " + GLVideoView.access$000(this.this$0) + ", mVideoSrcType: " + GLVideoView.access$100(this.this$0) + ", width: " + paramInt1 + ", height: " + paramInt2 + ", angle: " + paramInt3);
    }
    GLVideoView.access$200(this.this$0).setTextureSize(paramInt1, paramInt2);
    this.this$0.invalidate();
  }
  
  public void onRenderReset()
  {
    this.this$0.flush();
    this.this$0.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.TMG.opengl.ui.GLVideoView.1
 * JD-Core Version:    0.7.0.1
 */