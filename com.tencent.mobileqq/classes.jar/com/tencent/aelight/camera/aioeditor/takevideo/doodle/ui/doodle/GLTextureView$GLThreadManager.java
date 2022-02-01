package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import javax.microedition.khronos.opengles.GL10;

class GLTextureView$GLThreadManager
{
  private static String a = "GLThreadManager";
  private boolean b;
  private int c;
  private boolean d;
  private boolean e;
  private boolean f;
  private GLTextureView.GLThread g;
  
  private void c()
  {
    if (!this.b)
    {
      this.c = GLTextureView.e();
      if (this.c >= 131072) {
        this.e = true;
      }
      this.b = true;
    }
  }
  
  public void a(GLTextureView.GLThread paramGLThread)
  {
    try
    {
      GLTextureView.GLThread.a(paramGLThread, true);
      if (this.g == paramGLThread) {
        this.g = null;
      }
      notifyAll();
      return;
    }
    finally {}
  }
  
  public void a(GL10 paramGL10)
  {
    for (;;)
    {
      try
      {
        if (!this.d)
        {
          c();
          paramGL10 = paramGL10.glGetString(7937);
          int i = this.c;
          boolean bool2 = false;
          if (i < 131072)
          {
            if (!paramGL10.startsWith("Q3Dimension MSM7500 "))
            {
              bool1 = true;
              this.e = bool1;
              notifyAll();
            }
          }
          else
          {
            bool1 = bool2;
            if (!this.e) {
              bool1 = true;
            }
            this.f = bool1;
            this.d = true;
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      boolean bool1 = false;
    }
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = this.f;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean b()
  {
    try
    {
      c();
      boolean bool = this.e;
      return bool ^ true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean b(GLTextureView.GLThread paramGLThread)
  {
    GLTextureView.GLThread localGLThread = this.g;
    if ((localGLThread != paramGLThread) && (localGLThread != null))
    {
      c();
      if (this.e) {
        return true;
      }
      paramGLThread = this.g;
      if (paramGLThread != null) {
        paramGLThread.g();
      }
      return false;
    }
    this.g = paramGLThread;
    notifyAll();
    return true;
  }
  
  public void c(GLTextureView.GLThread paramGLThread)
  {
    if (this.g == paramGLThread) {
      this.g = null;
    }
    notifyAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.GLTextureView.GLThreadManager
 * JD-Core Version:    0.7.0.1
 */