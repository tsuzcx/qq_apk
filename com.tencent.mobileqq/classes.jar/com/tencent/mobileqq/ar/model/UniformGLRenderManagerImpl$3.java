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
    if (UniformGLRenderManagerImpl.a(this.this$0))
    {
      QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "stopModelRender. has been refused");
      return;
    }
    if (this.this$0.e != null)
    {
      this.this$0.l.remove(this.this$0.e.n());
      this.this$0.e.l();
      this.this$0.e = null;
    }
    if (UniformGLRenderManagerImpl.b(this.this$0) != null)
    {
      GLES20.glDeleteTextures(1, new int[] { UniformGLRenderManagerImpl.b(this.this$0).getTexId() }, 0);
      UniformGLRenderManagerImpl.b(this.this$0).destroy();
      UniformGLRenderManagerImpl.a(this.this$0, null);
    }
    if (UniformGLRenderManagerImpl.c(this.this$0) != null)
    {
      UniformGLRenderManagerImpl.c(this.this$0).release();
      UniformGLRenderManagerImpl.a(this.this$0, null);
    }
    if (UniformGLRenderManagerImpl.d(this.this$0) != null) {
      UniformGLRenderManagerImpl.d(this.this$0).f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.UniformGLRenderManagerImpl.3
 * JD-Core Version:    0.7.0.1
 */