package com.tencent.mobileqq.ar.model;

import android.opengl.GLES20;
import apho;
import apsm;
import com.tencent.mobileqq.ar.ARRecord.VideoRecordController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.util.Map;

public class UniformGLRenderManagerImpl$3
  implements Runnable
{
  public UniformGLRenderManagerImpl$3(apsm paramapsm) {}
  
  public void run()
  {
    if (apsm.a(this.this$0)) {
      QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "stopModelRender. has been refused");
    }
    do
    {
      return;
      if (this.this$0.jdField_a_of_type_Apho != null)
      {
        this.this$0.jdField_a_of_type_JavaUtilMap.remove(this.this$0.jdField_a_of_type_Apho.c());
        this.this$0.jdField_a_of_type_Apho.f();
        this.this$0.jdField_a_of_type_Apho = null;
      }
      if (apsm.a(this.this$0) != null)
      {
        GLES20.glDeleteTextures(1, new int[] { apsm.a(this.this$0).getTexId() }, 0);
        apsm.a(this.this$0).destroy();
        apsm.a(this.this$0, null);
      }
      if (apsm.a(this.this$0) != null)
      {
        apsm.a(this.this$0).release();
        apsm.a(this.this$0, null);
      }
    } while (apsm.a(this.this$0) == null);
    apsm.a(this.this$0).d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.UniformGLRenderManagerImpl.3
 * JD-Core Version:    0.7.0.1
 */