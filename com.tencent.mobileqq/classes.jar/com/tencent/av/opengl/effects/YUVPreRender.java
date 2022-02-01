package com.tencent.av.opengl.effects;

import android.opengl.GLES20;
import com.tencent.av.camera.AndroidCamera;
import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.av.opengl.program.TextureProgramFactory;
import com.tencent.av.opengl.shader.ShaderParameter;
import com.tencent.av.opengl.texture.YUVTexture;
import com.tencent.av.opengl.utils.AVGLUtils;
import com.tencent.av.utils.PerfRecorder;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public class YUVPreRender
  implements PreRender
{
  protected int a = -1;
  protected int b = -1;
  private ByteBuffer c = null;
  
  public YUVPreRender()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SurfaceTag", 2, "SurfacePreRender");
    }
    CameraFrame.a("YUVMode");
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOfFloat, byte[] paramArrayOfByte, int paramInt4, int paramInt5, int paramInt6, int paramInt7, ByteBuffer paramByteBuffer, FloatBuffer paramFloatBuffer)
  {
    if (paramArrayOfByte != null)
    {
      int i = paramArrayOfByte.length;
      int j = paramInt1 * paramInt2;
      int k = j * 3 / 2;
      if (i >= k)
      {
        if (paramByteBuffer.capacity() < k) {
          return;
        }
        paramByteBuffer.position(0);
        paramByteBuffer.put(paramArrayOfByte, 0, j);
        paramByteBuffer.position(0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, paramInt4);
        GLES20.glTexParameterf(3553, 10241, 9729.0F);
        GLES20.glTexParameterf(3553, 10240, 9729.0F);
        GLES20.glTexParameterf(3553, 10242, 33071.0F);
        GLES20.glTexParameterf(3553, 10243, 33071.0F);
        GLES20.glTexImage2D(3553, 0, 6409, paramInt1, paramInt2, 0, 6409, 5121, paramByteBuffer);
        paramByteBuffer.position(0);
        paramByteBuffer.put(paramArrayOfByte, j, j / 2);
        paramByteBuffer.position(0);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, paramInt5);
        GLES20.glTexParameterf(3553, 10241, 9729.0F);
        GLES20.glTexParameterf(3553, 10240, 9729.0F);
        GLES20.glTexParameterf(3553, 10242, 33071.0F);
        GLES20.glTexParameterf(3553, 10243, 33071.0F);
        GLES20.glTexImage2D(3553, 0, 6410, paramInt1 / 2, paramInt2 / 2, 0, 6410, 5121, paramByteBuffer);
        GLES20.glBindFramebuffer(36160, paramInt6);
        GLES20.glViewport(0, 0, paramInt2, paramInt1);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glClear(16640);
        paramArrayOfByte = TextureProgramFactory.a(1);
        paramByteBuffer = paramArrayOfByte.b();
        GLES20.glUseProgram(paramArrayOfByte.a());
        GLES20.glUniform1f(paramByteBuffer[2].a, 1.0F);
        GLES20.glUniform1f(paramByteBuffer[7].a, paramInt1);
        GLES20.glUniform1f(paramByteBuffer[8].a, paramInt2);
        GLES20.glUniformMatrix4fv(paramByteBuffer[9].a, 1, false, paramArrayOfFloat, 0);
        if (paramInt3 == 17) {
          GLES20.glUniform1i(paramByteBuffer[10].a, 3);
        } else {
          GLES20.glUniform1i(paramByteBuffer[10].a, 1);
        }
        GLES20.glUniform1i(paramByteBuffer[11].a, 0);
        GLES20.glDisable(3042);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, paramInt4);
        GLES20.glUniform1i(paramByteBuffer[4].a, 0);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, paramInt5);
        GLES20.glUniform1i(paramByteBuffer[5].a, 1);
        if (paramInt7 % 4 == 1) {
          GLES20.glUniformMatrix4fv(paramByteBuffer[1].a, 1, false, AVGLUtils.matrixVRotate90, 0);
        } else {
          GLES20.glUniformMatrix4fv(paramByteBuffer[1].a, 1, false, AVGLUtils.matrixVRotate270, 0);
        }
        GLES20.glUniformMatrix4fv(paramByteBuffer[3].a, 1, false, AVGLUtils.matrix, 0);
        GLES20.glVertexAttribPointer(paramByteBuffer[0].a, 2, 5126, false, 8, paramFloatBuffer);
        GLES20.glEnableVertexAttribArray(paramByteBuffer[0].a);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(paramByteBuffer[0].a);
        GLES20.glBindFramebuffer(36160, 0);
      }
    }
  }
  
  private void a(CameraFrame paramCameraFrame, int paramInt, FloatBuffer paramFloatBuffer)
  {
    a(paramCameraFrame.b, paramCameraFrame.c, AndroidCamera.d, YUVTexture.q, paramCameraFrame.a, this.a, this.b, paramInt, RenderUtil.a(paramCameraFrame.g), this.c, paramFloatBuffer);
    GLES20.glViewport(0, 0, paramCameraFrame.b, paramCameraFrame.c);
  }
  
  public GLTexture a(FilterProcessRender paramFilterProcessRender, CameraFrame paramCameraFrame, GLTexture paramGLTexture)
  {
    if (paramFilterProcessRender.j != null) {
      paramFilterProcessRender.j.a("preRender");
    }
    int i = paramCameraFrame.b * paramCameraFrame.c * 3 / 2;
    ByteBuffer localByteBuffer = this.c;
    if ((localByteBuffer != null) && (localByteBuffer.capacity() != i))
    {
      this.c.clear();
      this.c = null;
    }
    if (this.c == null) {
      this.c = ByteBuffer.allocate(i);
    }
    a(paramCameraFrame, paramGLTexture.a, paramFilterProcessRender.m);
    if (paramFilterProcessRender.j != null) {
      paramFilterProcessRender.j.b("preRender");
    }
    if (paramFilterProcessRender.h != null)
    {
      paramFilterProcessRender.h.b(9, paramGLTexture.a, paramGLTexture.b);
      paramFilterProcessRender.h.a(paramFilterProcessRender, 1, paramCameraFrame, paramGLTexture);
    }
    return paramGLTexture;
  }
  
  public void a()
  {
    int[] arrayOfInt = new int[2];
    GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
    this.a = arrayOfInt[0];
    this.b = arrayOfInt[1];
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public boolean a(CameraFrame paramCameraFrame)
  {
    return (paramCameraFrame != null) && (paramCameraFrame.a != null) && (paramCameraFrame.a.length > 0);
  }
  
  public void b()
  {
    ByteBuffer localByteBuffer = this.c;
    if (localByteBuffer != null) {
      localByteBuffer.clear();
    }
    this.c = null;
  }
  
  public void c()
  {
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = this.a;
    arrayOfInt[1] = this.b;
    GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    this.a = -1;
    this.b = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.YUVPreRender
 * JD-Core Version:    0.7.0.1
 */