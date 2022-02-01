package com.tencent.luggage.wxa.sp;

import android.opengl.GLES20;
import com.tencent.luggage.wxa.sq.a.a;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/wmpf/samelayer/recordview/proc/GLTextureRenderProcExternalTexture;", "Lcom/tencent/wmpf/samelayer/recordview/proc/LuggageCameraGLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "attributePosition", "attributeTextureCoord", "externalTexture", "getExternalTexture", "()I", "setExternalTexture", "(I)V", "programId", "uniformMatrix", "uniformTexture", "release", "", "renderImpl", "setInputTexture", "texture", "luggage-camera_release"}, k=1, mv={1, 1, 16})
public class a
  extends c
{
  private int a = com.tencent.luggage.wxa.sq.a.d.a("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
  private int c = GLES20.glGetAttribLocation(this.a, "a_position");
  private int d = GLES20.glGetAttribLocation(this.a, "a_texCoord");
  private int e = GLES20.glGetUniformLocation(this.a, "texture");
  private int f = GLES20.glGetUniformLocation(this.a, "uMatrix");
  private int g = -1;
  
  public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  protected void a()
  {
    if (this.g != -1)
    {
      GLES20.glUseProgram(this.a);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(36197, this.g);
      float f1 = 9729;
      GLES20.glTexParameterf(36197, 10241, f1);
      GLES20.glTexParameterf(36197, 10240, f1);
      f1 = 33071;
      GLES20.glTexParameterf(36197, 10242, f1);
      GLES20.glTexParameterf(36197, 10243, f1);
      GLES20.glUniform1i(this.e, 0);
      GLES20.glUniformMatrix4fv(this.f, 1, false, e(), 0);
      d().position(0);
      GLES20.glVertexAttribPointer(this.c, 2, 5126, false, 0, (Buffer)d());
      GLES20.glEnableVertexAttribArray(this.c);
      c().position(0);
      GLES20.glVertexAttribPointer(this.d, 2, 5126, false, 0, (Buffer)c());
      GLES20.glEnableVertexAttribArray(this.d);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(this.c);
      GLES20.glDisableVertexAttribArray(this.d);
      GLES20.glBindTexture(36197, 0);
      GLES20.glFinish();
    }
  }
  
  public void a(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void b()
  {
    super.b();
    GLES20.glDeleteProgram(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sp.a
 * JD-Core Version:    0.7.0.1
 */