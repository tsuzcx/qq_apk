package com.tencent.av.ui;

import com.tencent.av.opengl.ui.GLRootView;

class GLVideoView$2
  implements Runnable
{
  GLVideoView$2(GLVideoView paramGLVideoView) {}
  
  public void run()
  {
    GLRootView localGLRootView = this.this$0.i();
    if (localGLRootView != null)
    {
      GLVideoView.g(this.this$0);
      localGLRootView.postDelayed(this.this$0.aJ, 80L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.GLVideoView.2
 * JD-Core Version:    0.7.0.1
 */