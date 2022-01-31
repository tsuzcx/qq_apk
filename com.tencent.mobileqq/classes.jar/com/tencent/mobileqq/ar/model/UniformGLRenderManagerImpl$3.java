package com.tencent.mobileqq.ar.model;

import amvh;
import android.opengl.GLES20;
import angf;
import com.tencent.mobileqq.ar.ARRecord.VideoRecordController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.util.Map;

public class UniformGLRenderManagerImpl$3
  implements Runnable
{
  public UniformGLRenderManagerImpl$3(angf paramangf) {}
  
  public void run()
  {
    if (angf.a(this.this$0)) {
      QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "stopModelRender. has been refused");
    }
    do
    {
      return;
      if (this.this$0.jdField_a_of_type_Amvh != null)
      {
        this.this$0.jdField_a_of_type_JavaUtilMap.remove(this.this$0.jdField_a_of_type_Amvh.c());
        this.this$0.jdField_a_of_type_Amvh.f();
        this.this$0.jdField_a_of_type_Amvh = null;
      }
      if (angf.a(this.this$0) != null)
      {
        GLES20.glDeleteTextures(1, new int[] { angf.a(this.this$0).getTexId() }, 0);
        angf.a(this.this$0).destroy();
        angf.a(this.this$0, null);
      }
      if (angf.a(this.this$0) != null)
      {
        angf.a(this.this$0).release();
        angf.a(this.this$0, null);
      }
    } while (angf.a(this.this$0) == null);
    angf.a(this.this$0).d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.UniformGLRenderManagerImpl.3
 * JD-Core Version:    0.7.0.1
 */