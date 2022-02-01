package com.tencent.av.opengl.texture;

import android.opengl.GLES20;
import com.tencent.av.opengl.glrenderer.GLCanvas;
import com.tencent.av.opengl.glrenderer.GLES20Canvas;
import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.av.opengl.program.TextureProgramFactory;
import com.tencent.av.opengl.shader.ShaderParameter;
import com.tencent.av.opengl.utils.AVGLUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class FrameBufferCenterTexture
{
  private static int b = -1;
  private static FrameBufferCenterTexture i;
  boolean a;
  private int c = 0;
  private int d = 0;
  private int e;
  private int f;
  private int g;
  private int h;
  private FloatBuffer j;
  
  private FrameBufferCenterTexture()
  {
    int k = b;
    this.e = k;
    this.f = k;
    this.g = k;
    this.h = k;
    this.j = null;
    this.a = true;
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int m = this.e;
    int k = m;
    if (m == b)
    {
      int[] arrayOfInt = new int[1];
      GLES20.glGenFramebuffers(1, arrayOfInt, 0);
      k = arrayOfInt[0];
    }
    GLES20.glBindFramebuffer(36160, k);
    GLES20.glBindTexture(3553, paramInt3);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
    GLES20.glBindTexture(3553, 0);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt3, 0);
    GLES20.glBindFramebuffer(36160, 0);
    return k;
  }
  
  public static FrameBufferCenterTexture a()
  {
    if (i == null) {
      i = new FrameBufferCenterTexture();
    }
    return i;
  }
  
  private int b(int paramInt1, int paramInt2, int paramInt3)
  {
    int m = this.g;
    int k = m;
    if (m == b)
    {
      int[] arrayOfInt = new int[1];
      GLES20.glGenFramebuffers(1, arrayOfInt, 0);
      k = arrayOfInt[0];
    }
    GLES20.glBindFramebuffer(36160, k);
    GLES20.glBindTexture(3553, paramInt3);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
    GLES20.glBindTexture(3553, 0);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt3, 0);
    GLES20.glBindFramebuffer(36160, 0);
    return k;
  }
  
  private void c()
  {
    if (this.j != null) {
      return;
    }
    float[] arrayOfFloat = new float[8];
    arrayOfFloat[0] = -0.5F;
    arrayOfFloat[1] = -0.5F;
    arrayOfFloat[2] = 0.5F;
    arrayOfFloat[3] = -0.5F;
    arrayOfFloat[4] = -0.5F;
    arrayOfFloat[5] = 0.5F;
    arrayOfFloat[6] = 0.5F;
    arrayOfFloat[7] = 0.5F;
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(arrayOfFloat.length * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.j = localByteBuffer.asFloatBuffer();
    this.j.put(arrayOfFloat);
    this.j.position(0);
  }
  
  private void d()
  {
    if (this.h == b)
    {
      int[] arrayOfInt = new int[1];
      GLES20.glGenTextures(1, arrayOfInt, 0);
      this.h = arrayOfInt[0];
    }
    this.g = b(this.c, this.d, this.h);
  }
  
  private void e()
  {
    if (this.f == b)
    {
      int[] arrayOfInt = new int[1];
      GLES20.glGenTextures(1, arrayOfInt, 0);
      this.f = arrayOfInt[0];
    }
    this.e = a(this.c, this.d, this.f);
  }
  
  public void a(GLCanvas paramGLCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.a)
    {
      paramGLCanvas = TextureProgramFactory.a(0);
      GLES20.glUseProgram(paramGLCanvas.a());
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.h);
      GLES20.glUniform1i(paramGLCanvas.b()[4].a, 0);
      GLES20.glUniform1f(paramGLCanvas.b()[2].a, 1.0F);
    }
  }
  
  public void a(GLCanvas paramGLCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float[] paramArrayOfFloat, int paramInt8, int paramInt9)
  {
    int k = this.c;
    int m = paramInt1 * 2;
    if ((k != m) || (this.e == b))
    {
      this.c = m;
      this.d = (paramInt2 * 2);
      e();
      d();
      c();
    }
    GLES20.glBindFramebuffer(36160, this.e);
    GLES20.glViewport(0, 0, this.c, this.d);
    GLES20.glClearColor(0.4F, 0.4F, 0.4F, 1.0F);
    GLES20.glClear(16640);
    TextureProgram localTextureProgram = TextureProgramFactory.a(2);
    ShaderParameter[] arrayOfShaderParameter = localTextureProgram.b();
    GLES20.glUseProgram(localTextureProgram.a());
    k = localTextureProgram.b()[7].a;
    float f1 = paramInt1;
    GLES20.glUniform1f(k, f1);
    k = localTextureProgram.b()[8].a;
    float f2 = paramInt2;
    GLES20.glUniform1f(k, f2);
    GLES20.glUniformMatrix4fv(localTextureProgram.b()[9].a, 1, false, paramArrayOfFloat, 0);
    GLES20.glUniform1i(localTextureProgram.b()[10].a, paramInt8);
    GLES20.glUniform1i(localTextureProgram.b()[11].a, paramInt9);
    GLES20Canvas.a(false);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt5);
    GLES20.glUniform1i(arrayOfShaderParameter[4].a, 0);
    GLES20.glActiveTexture(33985);
    GLES20.glBindTexture(3553, paramInt6);
    GLES20.glUniform1i(arrayOfShaderParameter[5].a, 1);
    GLES20.glActiveTexture(33986);
    GLES20.glBindTexture(3553, paramInt7);
    GLES20.glUniform1i(arrayOfShaderParameter[6].a, 2);
    GLES20.glUniform1f(arrayOfShaderParameter[2].a, 1.0F);
    GLES20.glUniformMatrix4fv(arrayOfShaderParameter[1].a, 1, false, AVGLUtils.matrixV, 0);
    GLES20.glUniformMatrix4fv(arrayOfShaderParameter[3].a, 1, false, AVGLUtils.matrix, 0);
    GLES20.glVertexAttribPointer(arrayOfShaderParameter[0].a, 2, 5126, false, 8, this.j);
    GLES20.glEnableVertexAttribArray(arrayOfShaderParameter[0].a);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glDisableVertexAttribArray(arrayOfShaderParameter[0].a);
    GLES20.glBindFramebuffer(36160, this.g);
    GLES20.glViewport(0, 0, this.c, this.d);
    GLES20.glClearColor(0.4F, 0.4F, 0.4F, 1.0F);
    GLES20.glClear(16640);
    localTextureProgram = TextureProgramFactory.a(3);
    arrayOfShaderParameter = localTextureProgram.b();
    GLES20.glUseProgram(localTextureProgram.a());
    GLES20.glUniform1f(localTextureProgram.b()[7].a, f1);
    GLES20.glUniform1f(localTextureProgram.b()[8].a, f2);
    GLES20.glUniformMatrix4fv(localTextureProgram.b()[9].a, 1, false, paramArrayOfFloat, 0);
    GLES20.glUniform1i(localTextureProgram.b()[10].a, paramInt8);
    GLES20.glUniform1i(localTextureProgram.b()[11].a, paramInt9);
    GLES20Canvas.a(false);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.f);
    GLES20.glUniform1i(arrayOfShaderParameter[4].a, 0);
    GLES20.glUniform1f(arrayOfShaderParameter[2].a, 1.0F);
    GLES20.glUniformMatrix4fv(arrayOfShaderParameter[1].a, 1, false, AVGLUtils.matrixV, 0);
    GLES20.glUniformMatrix4fv(arrayOfShaderParameter[3].a, 1, false, AVGLUtils.matrix, 0);
    GLES20.glVertexAttribPointer(arrayOfShaderParameter[0].a, 2, 5126, false, 8, this.j);
    GLES20.glEnableVertexAttribArray(arrayOfShaderParameter[0].a);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glDisableVertexAttribArray(arrayOfShaderParameter[0].a);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glViewport(0, 0, paramInt3, paramInt4);
    a(paramGLCanvas, paramInt1, paramInt2, paramInt5, paramInt6, paramInt7);
  }
  
  public void b()
  {
    int k = this.e;
    if (k != b)
    {
      GLES20.glDeleteFramebuffers(2, new int[] { k, this.g }, 0);
      GLES20.glDeleteTextures(2, new int[] { this.f, this.h }, 0);
    }
    k = b;
    this.e = k;
    this.f = k;
    this.g = k;
    this.h = k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.texture.FrameBufferCenterTexture
 * JD-Core Version:    0.7.0.1
 */