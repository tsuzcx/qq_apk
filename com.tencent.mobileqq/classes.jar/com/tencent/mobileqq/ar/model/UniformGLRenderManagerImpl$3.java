package com.tencent.mobileqq.ar.model;

import amqs;
import anbw;
import android.opengl.GLES20;
import com.tencent.mobileqq.ar.ARRecord.VideoRecordController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.util.Map;

public class UniformGLRenderManagerImpl$3
  implements Runnable
{
  public UniformGLRenderManagerImpl$3(anbw paramanbw) {}
  
  public void run()
  {
    if (anbw.a(this.this$0)) {
      QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "stopModelRender. has been refused");
    }
    do
    {
      return;
      if (this.this$0.jdField_a_of_type_Amqs != null)
      {
        this.this$0.jdField_a_of_type_JavaUtilMap.remove(this.this$0.jdField_a_of_type_Amqs.c());
        this.this$0.jdField_a_of_type_Amqs.f();
        this.this$0.jdField_a_of_type_Amqs = null;
      }
      if (anbw.a(this.this$0) != null)
      {
        GLES20.glDeleteTextures(1, new int[] { anbw.a(this.this$0).getTexId() }, 0);
        anbw.a(this.this$0).destroy();
        anbw.a(this.this$0, null);
      }
      if (anbw.a(this.this$0) != null)
      {
        anbw.a(this.this$0).release();
        anbw.a(this.this$0, null);
      }
    } while (anbw.a(this.this$0) == null);
    anbw.a(this.this$0).d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.UniformGLRenderManagerImpl.3
 * JD-Core Version:    0.7.0.1
 */