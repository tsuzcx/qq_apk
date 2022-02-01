package com.tencent.mobileqq.ar.model;

import android.opengl.GLES20;
import com.tencent.mobileqq.ar.ARRecord.VideoRecordController;
import com.tencent.mobileqq.ar.ARRenderModel.ARBaseRender;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.util.Map;

class UniformGLRenderManagerImpl$3
  implements Runnable
{
  UniformGLRenderManagerImpl$3(UniformGLRenderManagerImpl paramUniformGLRenderManagerImpl) {}
  
  public void run()
  {
    if (UniformGLRenderManagerImpl.a(this.this$0)) {
      QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "stopModelRender. has been refused");
    }
    do
    {
      return;
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender != null)
      {
        this.this$0.jdField_a_of_type_JavaUtilMap.remove(this.this$0.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender.c());
        this.this$0.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender.f();
        this.this$0.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender = null;
      }
      if (UniformGLRenderManagerImpl.a(this.this$0) != null)
      {
        GLES20.glDeleteTextures(1, new int[] { UniformGLRenderManagerImpl.a(this.this$0).getTexId() }, 0);
        UniformGLRenderManagerImpl.a(this.this$0).destroy();
        UniformGLRenderManagerImpl.a(this.this$0, null);
      }
      if (UniformGLRenderManagerImpl.a(this.this$0) != null)
      {
        UniformGLRenderManagerImpl.a(this.this$0).release();
        UniformGLRenderManagerImpl.a(this.this$0, null);
      }
    } while (UniformGLRenderManagerImpl.a(this.this$0) == null);
    UniformGLRenderManagerImpl.a(this.this$0).d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.UniformGLRenderManagerImpl.3
 * JD-Core Version:    0.7.0.1
 */