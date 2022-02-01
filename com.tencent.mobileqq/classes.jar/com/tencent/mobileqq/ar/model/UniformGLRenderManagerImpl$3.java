package com.tencent.mobileqq.ar.model;

import android.opengl.GLES20;
import apdx;
import aped;
import appa;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.util.Map;

public class UniformGLRenderManagerImpl$3
  implements Runnable
{
  public UniformGLRenderManagerImpl$3(appa paramappa) {}
  
  public void run()
  {
    if (appa.a(this.this$0)) {
      QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "stopModelRender. has been refused");
    }
    do
    {
      return;
      if (this.this$0.jdField_a_of_type_Aped != null)
      {
        this.this$0.jdField_a_of_type_JavaUtilMap.remove(this.this$0.jdField_a_of_type_Aped.c());
        this.this$0.jdField_a_of_type_Aped.f();
        this.this$0.jdField_a_of_type_Aped = null;
      }
      if (appa.a(this.this$0) != null)
      {
        GLES20.glDeleteTextures(1, new int[] { appa.a(this.this$0).getTexId() }, 0);
        appa.a(this.this$0).destroy();
        appa.a(this.this$0, null);
      }
      if (appa.a(this.this$0) != null)
      {
        appa.a(this.this$0).release();
        appa.a(this.this$0, null);
      }
    } while (appa.a(this.this$0) == null);
    appa.a(this.this$0).d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.UniformGLRenderManagerImpl.3
 * JD-Core Version:    0.7.0.1
 */