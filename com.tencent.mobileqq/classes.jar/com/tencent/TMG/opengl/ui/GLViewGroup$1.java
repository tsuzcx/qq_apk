package com.tencent.TMG.opengl.ui;

import java.util.Collections;

class GLViewGroup$1
  implements GLView.OnZOrderChangedListener
{
  GLViewGroup$1(GLViewGroup paramGLViewGroup) {}
  
  public void OnZOrderChanged(GLView paramGLView, int paramInt1, int paramInt2)
  {
    Collections.sort(GLViewGroup.access$000(this.this$0), GLViewGroup.access$100(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.TMG.opengl.ui.GLViewGroup.1
 * JD-Core Version:    0.7.0.1
 */