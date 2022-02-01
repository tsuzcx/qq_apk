package com.tencent.av.opengl.ui;

import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.ConcurrentModificationException;

class GLViewGroup$1
  implements GLView.OnZOrderChangedListener
{
  GLViewGroup$1(GLViewGroup paramGLViewGroup) {}
  
  public void a(GLView paramGLView, int paramInt1, int paramInt2)
  {
    try
    {
      Collections.sort(GLViewGroup.a(this.a), GLViewGroup.b(this.a));
      return;
    }
    catch (ConcurrentModificationException paramGLView)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnZOrderChanged", 2, "OnZOrderChanged FATAL EXCEPTION:", paramGLView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.ui.GLViewGroup.1
 * JD-Core Version:    0.7.0.1
 */