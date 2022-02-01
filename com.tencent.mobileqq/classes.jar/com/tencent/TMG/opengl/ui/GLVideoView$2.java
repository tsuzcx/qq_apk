package com.tencent.TMG.opengl.ui;

class GLVideoView$2
  implements Runnable
{
  GLVideoView$2(GLVideoView paramGLVideoView) {}
  
  public void run()
  {
    GLRootView localGLRootView = this.this$0.getGLRootView();
    if (localGLRootView != null)
    {
      this.this$0.invalidate();
      localGLRootView.postDelayed(GLVideoView.access$300(this.this$0), 80L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.opengl.ui.GLVideoView.2
 * JD-Core Version:    0.7.0.1
 */