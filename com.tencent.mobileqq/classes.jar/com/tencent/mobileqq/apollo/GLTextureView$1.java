package com.tencent.mobileqq.apollo;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public final class GLTextureView$1
  implements Runnable
{
  public void run()
  {
    GLTextureView.access$002(GLTextureView.getInt(BaseApplicationImpl.getContext(), "ro.opengles.version", 0).intValue());
    QLog.i("GLTextureView", 1, "checkGLVersion sGLESVersion:" + GLTextureView.access$000());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.GLTextureView.1
 * JD-Core Version:    0.7.0.1
 */