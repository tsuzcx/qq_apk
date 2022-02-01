package com.tencent.mobileqq.ar.model;

import android.opengl.GLES20;
import aoav;
import aobb;
import aolz;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.util.Map;

public class UniformGLRenderManagerImpl$3
  implements Runnable
{
  public UniformGLRenderManagerImpl$3(aolz paramaolz) {}
  
  public void run()
  {
    if (aolz.a(this.this$0)) {
      QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "stopModelRender. has been refused");
    }
    do
    {
      return;
      if (this.this$0.jdField_a_of_type_Aobb != null)
      {
        this.this$0.jdField_a_of_type_JavaUtilMap.remove(this.this$0.jdField_a_of_type_Aobb.c());
        this.this$0.jdField_a_of_type_Aobb.f();
        this.this$0.jdField_a_of_type_Aobb = null;
      }
      if (aolz.a(this.this$0) != null)
      {
        GLES20.glDeleteTextures(1, new int[] { aolz.a(this.this$0).getTexId() }, 0);
        aolz.a(this.this$0).destroy();
        aolz.a(this.this$0, null);
      }
      if (aolz.a(this.this$0) != null)
      {
        aolz.a(this.this$0).release();
        aolz.a(this.this$0, null);
      }
    } while (aolz.a(this.this$0) == null);
    aolz.a(this.this$0).d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.UniformGLRenderManagerImpl.3
 * JD-Core Version:    0.7.0.1
 */