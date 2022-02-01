package com.tencent.av.opengl.effects;

import android.opengl.GLES20;
import android.os.Build;
import com.tencent.av.opengl.glrenderer.GLES20Canvas;
import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.av.opengl.program.TextureProgramFactory;
import com.tencent.av.opengl.shader.ShaderParameter;
import com.tencent.av.opengl.utils.AVGLUtils;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.PerfRecorder;
import com.tencent.av.utils.QAVConfigUtils;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public class YuvPostRender
  implements PostRender
{
  int a = -1;
  int b = -1;
  byte[] c;
  byte[] d;
  private boolean e = true;
  private boolean f = true;
  private int g = -1;
  private int h = -1;
  private byte[] i;
  private String j;
  
  public YuvPostRender(String paramString)
  {
    this.j = paramString;
    f();
  }
  
  static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, FloatBuffer paramFloatBuffer)
  {
    GLES20.glBindFramebuffer(36160, paramInt4);
    GLES20.glViewport(0, 0, paramInt2, paramInt1);
    TextureProgram localTextureProgram = TextureProgramFactory.a(5);
    ShaderParameter[] arrayOfShaderParameter = localTextureProgram.b();
    GLES20.glUseProgram(localTextureProgram.a());
    GLES20Canvas.a(false);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt3);
    GLES20.glUniform1i(arrayOfShaderParameter[4].a, 0);
    GLES20.glUniform1f(arrayOfShaderParameter[2].a, 1.0F);
    GLES20.glUniformMatrix4fv(arrayOfShaderParameter[1].a, 1, false, AVGLUtils.matrixVRotate90, 0);
    GLES20.glUniformMatrix4fv(arrayOfShaderParameter[3].a, 1, false, AVGLUtils.matrix, 0);
    GLES20.glVertexAttribPointer(arrayOfShaderParameter[0].a, 2, 5126, false, 8, paramFloatBuffer);
    GLES20.glEnableVertexAttribArray(arrayOfShaderParameter[0].a);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    GLES20.glBindFramebuffer(36160, paramInt1);
    GLES20.glViewport(0, 0, paramInt2, paramInt3);
    GLES20.glReadPixels(0, 0, paramInt2, paramInt3, 6408, 5121, ByteBuffer.wrap(paramArrayOfByte));
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  private void a(FilterProcessRender paramFilterProcessRender, CameraFrame paramCameraFrame, GLTexture paramGLTexture, FaceData paramFaceData, FloatBuffer paramFloatBuffer, RenderResult paramRenderResult)
  {
    int k = paramCameraFrame.b * paramCameraFrame.c;
    int m = k * 3 / 2;
    byte[] arrayOfByte;
    if (this.f)
    {
      arrayOfByte = this.d;
      if ((arrayOfByte == null) || (arrayOfByte.length != m)) {
        this.d = new byte[m];
      }
      k = k * 1 / 2;
      arrayOfByte = this.i;
      if ((arrayOfByte == null) || (arrayOfByte.length != k)) {
        this.i = new byte[k];
      }
    }
    else
    {
      k *= 4;
      arrayOfByte = this.c;
      if ((arrayOfByte == null) || (arrayOfByte.length != k)) {
        this.c = new byte[k];
      }
    }
    if (this.f)
    {
      b(paramFilterProcessRender.b, paramFilterProcessRender.c, paramGLTexture.b, this.g, paramFloatBuffer);
      b(paramFilterProcessRender.b, paramFilterProcessRender.c);
    }
    else
    {
      a(paramFilterProcessRender.b, paramFilterProcessRender.c, paramGLTexture.b, this.b, paramFloatBuffer);
      a(this.b, paramFilterProcessRender.c, paramFilterProcessRender.b, this.c);
    }
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glViewport(0, 0, paramCameraFrame.b, paramCameraFrame.c);
    if ((!this.e) || (!paramCameraFrame.c()))
    {
      paramCameraFrame.a = this.c;
      paramCameraFrame.b = paramFilterProcessRender.c;
      paramCameraFrame.c = paramFilterProcessRender.b;
      paramCameraFrame.d = 21;
      if (this.f)
      {
        paramCameraFrame.d = 100;
        paramCameraFrame.a = this.d;
      }
      paramCameraFrame.e = ((paramCameraFrame.e - RenderUtil.a(paramCameraFrame.g) - 1 + 4) % 4);
      paramRenderResult.a(paramCameraFrame, paramFaceData.d, paramFaceData.e, paramFaceData.f, paramFaceData.g, paramFaceData.h);
    }
    this.e = false;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.j, 2, "saveTexture2I420DataBuffer called");
    }
    Object localObject = ByteBuffer.wrap(this.d);
    GLES20.glBindFramebuffer(36160, this.g);
    int k = paramInt2 * 2 / 8;
    GLES20.glReadPixels(0, 0, k, paramInt1, 6408, 5121, (Buffer)localObject);
    localObject = this.i;
    ByteBuffer localByteBuffer = ByteBuffer.wrap((byte[])localObject);
    GLES20.glReadPixels(k, 0, paramInt2 * 1 / 8, paramInt1, 6408, 5121, localByteBuffer);
    GLES20.glBindFramebuffer(36160, 0);
    System.arraycopy(localObject, 0, this.d, paramInt2 * paramInt1, localObject.length);
  }
  
  static void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, FloatBuffer paramFloatBuffer)
  {
    GLES20.glBindFramebuffer(36160, paramInt4);
    GLES20.glViewport(0, 0, paramInt2, paramInt1);
    TextureProgram localTextureProgram = TextureProgramFactory.a(6);
    ShaderParameter[] arrayOfShaderParameter = localTextureProgram.b();
    GLES20.glUseProgram(localTextureProgram.a());
    GLES20Canvas.a(false);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt3);
    GLES20.glUniform1i(arrayOfShaderParameter[4].a, 0);
    GLES20.glUniform1f(arrayOfShaderParameter[2].a, 1.0F);
    GLES20.glUniformMatrix4fv(arrayOfShaderParameter[1].a, 1, false, AVGLUtils.matrixVRotate90, 0);
    GLES20.glUniformMatrix4fv(arrayOfShaderParameter[3].a, 1, false, AVGLUtils.matrix, 0);
    GLES20.glUniform1f(arrayOfShaderParameter[7].a, paramInt1);
    GLES20.glUniform1f(arrayOfShaderParameter[8].a, paramInt2);
    GLES20.glVertexAttribPointer(arrayOfShaderParameter[0].a, 2, 5126, false, 8, paramFloatBuffer);
    GLES20.glEnableVertexAttribArray(arrayOfShaderParameter[0].a);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  private void f()
  {
    this.f = QAVConfigUtils.m();
    String str = this.j;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initUseRBG2I420Switch useRGB2I420Shader = ");
    ((StringBuilder)localObject).append(this.f);
    QLog.d(str, 1, ((StringBuilder)localObject).toString());
    if (this.f)
    {
      str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.useRGB2I420ShaderCfg.name(), "1");
      localObject = this.j;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initUseRBG2I420Switch dpcValue = ");
      localStringBuilder.append(str);
      QLog.d((String)localObject, 1, localStringBuilder.toString());
      if (str.equals("0")) {
        this.f = false;
      }
    }
    if (AudioHelper.a(21) == 1) {
      this.f = true;
    } else if (AudioHelper.a(21) == 0) {
      this.f = false;
    }
    str = this.j;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initUseRBG2I420Switch,after getDebugValue, initial useRGB2I420Shader = ");
    ((StringBuilder)localObject).append(this.f);
    ((StringBuilder)localObject).append(",Build.MODEL = ");
    ((StringBuilder)localObject).append(Build.MODEL);
    QLog.d(str, 1, ((StringBuilder)localObject).toString());
  }
  
  public void a()
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
    if (this.f)
    {
      this.h = arrayOfInt[0];
      return;
    }
    this.a = arrayOfInt[0];
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.f)
    {
      this.g = AVGLUtils.initFrameBuffer(paramInt2, paramInt1, this.h);
      return;
    }
    this.b = AVGLUtils.initFrameBuffer(paramInt2, paramInt1, this.a);
  }
  
  public void a(FilterProcessRender paramFilterProcessRender, CameraFrame paramCameraFrame, GLTexture paramGLTexture, FaceData paramFaceData, RenderResult paramRenderResult)
  {
    if (paramFilterProcessRender.j != null) {
      paramFilterProcessRender.j.a("postRender");
    }
    a(paramFilterProcessRender, paramCameraFrame, paramGLTexture, paramFaceData, paramFilterProcessRender.m, paramRenderResult);
    if (paramFilterProcessRender.j != null) {
      paramFilterProcessRender.j.b("postRender");
    }
    if (paramFilterProcessRender.h != null)
    {
      paramCameraFrame = GLTexture.a(this.b, this.a);
      paramFilterProcessRender.h.a(paramFilterProcessRender, 4, null, paramCameraFrame);
      paramFilterProcessRender.h.d();
      paramCameraFrame.a();
    }
  }
  
  public void b()
  {
    this.c = null;
    if (this.f)
    {
      this.d = null;
      this.i = null;
    }
  }
  
  public void c()
  {
    if (this.f)
    {
      arrayOfInt = new int[1];
      arrayOfInt[0] = this.h;
      GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
      this.h = -1;
      GLES20.glDeleteFramebuffers(1, new int[] { this.g }, 0);
      this.g = -1;
      return;
    }
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = this.a;
    GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    this.a = -1;
    GLES20.glDeleteFramebuffers(1, new int[] { this.b }, 0);
    this.b = -1;
  }
  
  public byte[] d()
  {
    byte[] arrayOfByte = this.c;
    if (arrayOfByte != null) {
      return arrayOfByte;
    }
    arrayOfByte = this.d;
    if (arrayOfByte != null) {
      return arrayOfByte;
    }
    return null;
  }
  
  public int e()
  {
    if (this.c != null) {
      return 42;
    }
    if (this.d != null) {
      return 35;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.YuvPostRender
 * JD-Core Version:    0.7.0.1
 */