package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import javax.microedition.khronos.opengles.GL10;

class GLTextureView$GLThreadManager
{
  private static String jdField_a_of_type_JavaLangString = "GLThreadManager";
  private int jdField_a_of_type_Int;
  private GLTextureView.GLThread jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleGLTextureView$GLThread;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  
  private void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Int = GLTextureView.a();
      if (this.jdField_a_of_type_Int >= 131072) {
        this.c = true;
      }
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(GLTextureView.GLThread paramGLThread)
  {
    try
    {
      GLTextureView.GLThread.a(paramGLThread, true);
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleGLTextureView$GLThread == paramGLThread) {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleGLTextureView$GLThread = null;
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
        if (!this.b)
        {
          a();
          paramGL10 = paramGL10.glGetString(7937);
          int i = this.jdField_a_of_type_Int;
          boolean bool2 = false;
          if (i < 131072)
          {
            if (!paramGL10.startsWith("Q3Dimension MSM7500 "))
            {
              bool1 = true;
              this.c = bool1;
              notifyAll();
            }
          }
          else
          {
            bool1 = bool2;
            if (!this.c) {
              bool1 = true;
            }
            this.d = bool1;
            this.b = true;
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
      boolean bool = this.d;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean a(GLTextureView.GLThread paramGLThread)
  {
    GLTextureView.GLThread localGLThread = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleGLTextureView$GLThread;
    if ((localGLThread != paramGLThread) && (localGLThread != null))
    {
      a();
      if (this.c) {
        return true;
      }
      paramGLThread = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleGLTextureView$GLThread;
      if (paramGLThread != null) {
        paramGLThread.e();
      }
      return false;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleGLTextureView$GLThread = paramGLThread;
    notifyAll();
    return true;
  }
  
  public void b(GLTextureView.GLThread paramGLThread)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleGLTextureView$GLThread == paramGLThread) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleGLTextureView$GLThread = null;
    }
    notifyAll();
  }
  
  public boolean b()
  {
    try
    {
      a();
      boolean bool = this.c;
      return bool ^ true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.GLTextureView.GLThreadManager
 * JD-Core Version:    0.7.0.1
 */