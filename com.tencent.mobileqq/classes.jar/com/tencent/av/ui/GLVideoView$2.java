package com.tencent.av.ui;

import com.tencent.av.opengl.ui.GLRootView;
import mep;

public class GLVideoView$2
  implements Runnable
{
  public GLVideoView$2(mep parammep) {}
  
  public void run()
  {
    GLRootView localGLRootView = this.this$0.a();
    if (localGLRootView != null)
    {
      mep.e(this.this$0);
      localGLRootView.postDelayed(this.this$0.a, 80L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.GLVideoView.2
 * JD-Core Version:    0.7.0.1
 */