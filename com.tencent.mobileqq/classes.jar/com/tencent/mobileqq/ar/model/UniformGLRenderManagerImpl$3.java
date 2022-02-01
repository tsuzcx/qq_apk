package com.tencent.mobileqq.ar.model;

import android.opengl.GLES20;
import aoty;
import apew;
import com.tencent.mobileqq.ar.ARRecord.VideoRecordController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.util.Map;

public class UniformGLRenderManagerImpl$3
  implements Runnable
{
  public UniformGLRenderManagerImpl$3(apew paramapew) {}
  
  public void run()
  {
    if (apew.a(this.this$0)) {
      QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "stopModelRender. has been refused");
    }
    do
    {
      return;
      if (this.this$0.jdField_a_of_type_Aoty != null)
      {
        this.this$0.jdField_a_of_type_JavaUtilMap.remove(this.this$0.jdField_a_of_type_Aoty.c());
        this.this$0.jdField_a_of_type_Aoty.f();
        this.this$0.jdField_a_of_type_Aoty = null;
      }
      if (apew.a(this.this$0) != null)
      {
        GLES20.glDeleteTextures(1, new int[] { apew.a(this.this$0).getTexId() }, 0);
        apew.a(this.this$0).destroy();
        apew.a(this.this$0, null);
      }
      if (apew.a(this.this$0) != null)
      {
        apew.a(this.this$0).release();
        apew.a(this.this$0, null);
      }
    } while (apew.a(this.this$0) == null);
    apew.a(this.this$0).d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.UniformGLRenderManagerImpl.3
 * JD-Core Version:    0.7.0.1
 */