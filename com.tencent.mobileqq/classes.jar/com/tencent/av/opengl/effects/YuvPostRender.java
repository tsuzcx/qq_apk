package com.tencent.av.opengl.effects;

import android.opengl.GLES20;
import android.os.Build;
import com.tencent.av.opengl.glrenderer.GLES20Canvas;
import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.av.opengl.program.TextureProgramFactory;
import com.tencent.av.opengl.shader.ShaderParameter;
import com.tencent.av.opengl.utils.AVGLUtils;
import com.tencent.av.utils.PerfRecorder;
import com.tencent.av.utils.QAVConfigUtils;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public class YuvPostRender
  implements PostRender
{
  int jdField_a_of_type_Int = -1;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = true;
  byte[] jdField_a_of_type_ArrayOfByte;
  int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean = true;
  byte[] jdField_b_of_type_ArrayOfByte;
  private int jdField_c_of_type_Int = -1;
  private byte[] jdField_c_of_type_ArrayOfByte;
  private int d = -1;
  
  public YuvPostRender(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    d();
  }
  
  static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, FloatBuffer paramFloatBuffer)
  {
    GLES20.glBindFramebuffer(36160, paramInt4);
    GLES20.glViewport(0, 0, paramInt2, paramInt1);
    TextureProgram localTextureProgram = TextureProgramFactory.a(5);
    ShaderParameter[] arrayOfShaderParameter = localTextureProgram.a();
    GLES20.glUseProgram(localTextureProgram.a());
    GLES20Canvas.a(false);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt3);
    GLES20.glUniform1i(arrayOfShaderParameter[4].jdField_a_of_type_Int, 0);
    GLES20.glUniform1f(arrayOfShaderParameter[2].jdField_a_of_type_Int, 1.0F);
    GLES20.glUniformMatrix4fv(arrayOfShaderParameter[1].jdField_a_of_type_Int, 1, false, AVGLUtils.matrixVRotate90, 0);
    GLES20.glUniformMatrix4fv(arrayOfShaderParameter[3].jdField_a_of_type_Int, 1, false, AVGLUtils.matrix, 0);
    GLES20.glVertexAttribPointer(arrayOfShaderParameter[0].jdField_a_of_type_Int, 2, 5126, false, 8, paramFloatBuffer);
    GLES20.glEnableVertexAttribArray(arrayOfShaderParameter[0].jdField_a_of_type_Int);
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
    int i = paramCameraFrame.jdField_a_of_type_Int;
    int j = paramCameraFrame.jdField_b_of_type_Int;
    int k = i * j * 3 / 2;
    if (this.jdField_b_of_type_Boolean)
    {
      if ((this.jdField_b_of_type_ArrayOfByte == null) || (this.jdField_b_of_type_ArrayOfByte.length != k)) {
        this.jdField_b_of_type_ArrayOfByte = new byte[k];
      }
      i = i * j * 1 / 2;
      if ((this.jdField_c_of_type_ArrayOfByte == null) || (this.jdField_c_of_type_ArrayOfByte.length != i)) {
        this.jdField_c_of_type_ArrayOfByte = new byte[i];
      }
      if (!this.jdField_b_of_type_Boolean) {
        break label311;
      }
      b(paramFilterProcessRender.jdField_a_of_type_Int, paramFilterProcessRender.jdField_b_of_type_Int, paramGLTexture.jdField_b_of_type_Int, this.jdField_c_of_type_Int, paramFloatBuffer);
      b(paramFilterProcessRender.jdField_a_of_type_Int, paramFilterProcessRender.jdField_b_of_type_Int);
    }
    for (;;)
    {
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glViewport(0, 0, paramCameraFrame.jdField_a_of_type_Int, paramCameraFrame.jdField_b_of_type_Int);
      if ((!this.jdField_a_of_type_Boolean) || (!paramCameraFrame.b()))
      {
        paramCameraFrame.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
        paramCameraFrame.jdField_a_of_type_Int = paramFilterProcessRender.jdField_b_of_type_Int;
        paramCameraFrame.jdField_b_of_type_Int = paramFilterProcessRender.jdField_a_of_type_Int;
        paramCameraFrame.jdField_c_of_type_Int = 21;
        if (this.jdField_b_of_type_Boolean)
        {
          paramCameraFrame.jdField_c_of_type_Int = 100;
          paramCameraFrame.jdField_a_of_type_ArrayOfByte = this.jdField_b_of_type_ArrayOfByte;
        }
        paramCameraFrame.d = ((paramCameraFrame.d - RenderUtil.a(paramCameraFrame.jdField_a_of_type_Boolean) - 1 + 4) % 4);
        paramRenderResult.a(paramCameraFrame, paramFaceData.jdField_a_of_type_ArrayOfByte, paramFaceData.jdField_b_of_type_ArrayOfByte, paramFaceData.jdField_c_of_type_ArrayOfByte, paramFaceData.jdField_a_of_type_Short, paramFaceData.jdField_b_of_type_Short);
      }
      this.jdField_a_of_type_Boolean = false;
      return;
      i = i * j * 4;
      if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length == i)) {
        break;
      }
      this.jdField_a_of_type_ArrayOfByte = new byte[i];
      break;
      label311:
      a(paramFilterProcessRender.jdField_a_of_type_Int, paramFilterProcessRender.jdField_b_of_type_Int, paramGLTexture.jdField_b_of_type_Int, this.jdField_b_of_type_Int, paramFloatBuffer);
      a(this.jdField_b_of_type_Int, paramFilterProcessRender.jdField_b_of_type_Int, paramFilterProcessRender.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfByte);
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "saveTexture2I420DataBuffer called");
    }
    Object localObject = ByteBuffer.wrap(this.jdField_b_of_type_ArrayOfByte);
    GLES20.glBindFramebuffer(36160, this.jdField_c_of_type_Int);
    GLES20.glReadPixels(0, 0, paramInt2 * 2 / 8, paramInt1, 6408, 5121, (Buffer)localObject);
    localObject = this.jdField_c_of_type_ArrayOfByte;
    ByteBuffer localByteBuffer = ByteBuffer.wrap((byte[])localObject);
    GLES20.glReadPixels(paramInt2 * 2 / 8, 0, paramInt2 * 1 / 8, paramInt1, 6408, 5121, localByteBuffer);
    GLES20.glBindFramebuffer(36160, 0);
    System.arraycopy(localObject, 0, this.jdField_b_of_type_ArrayOfByte, paramInt2 * paramInt1, localObject.length);
  }
  
  static void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, FloatBuffer paramFloatBuffer)
  {
    GLES20.glBindFramebuffer(36160, paramInt4);
    GLES20.glViewport(0, 0, paramInt2, paramInt1);
    TextureProgram localTextureProgram = TextureProgramFactory.a(6);
    ShaderParameter[] arrayOfShaderParameter = localTextureProgram.a();
    GLES20.glUseProgram(localTextureProgram.a());
    GLES20Canvas.a(false);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt3);
    GLES20.glUniform1i(arrayOfShaderParameter[4].jdField_a_of_type_Int, 0);
    GLES20.glUniform1f(arrayOfShaderParameter[2].jdField_a_of_type_Int, 1.0F);
    GLES20.glUniformMatrix4fv(arrayOfShaderParameter[1].jdField_a_of_type_Int, 1, false, AVGLUtils.matrixVRotate90, 0);
    GLES20.glUniformMatrix4fv(arrayOfShaderParameter[3].jdField_a_of_type_Int, 1, false, AVGLUtils.matrix, 0);
    GLES20.glUniform1f(arrayOfShaderParameter[7].jdField_a_of_type_Int, paramInt1);
    GLES20.glUniform1f(arrayOfShaderParameter[8].jdField_a_of_type_Int, paramInt2);
    GLES20.glVertexAttribPointer(arrayOfShaderParameter[0].jdField_a_of_type_Int, 2, 5126, false, 8, paramFloatBuffer);
    GLES20.glEnableVertexAttribArray(arrayOfShaderParameter[0].jdField_a_of_type_Int);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  private void d()
  {
    this.jdField_b_of_type_Boolean = QAVConfigUtils.g();
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "initUseRBG2I420Switch useRGB2I420Shader = " + this.jdField_b_of_type_Boolean);
    if (this.jdField_b_of_type_Boolean)
    {
      String str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.useRGB2I420ShaderCfg.name(), "1");
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "initUseRBG2I420Switch dpcValue = " + str);
      if (str.equals("0")) {
        this.jdField_b_of_type_Boolean = false;
      }
    }
    if (AudioHelper.a(21) == 1) {
      this.jdField_b_of_type_Boolean = true;
    }
    for (;;)
    {
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "initUseRBG2I420Switch,after getDebugValue, initial useRGB2I420Shader = " + this.jdField_b_of_type_Boolean + ",Build.MODEL = " + Build.MODEL);
      return;
      if (AudioHelper.a(21) == 0) {
        this.jdField_b_of_type_Boolean = false;
      }
    }
  }
  
  public int a()
  {
    int i = 0;
    if (this.jdField_a_of_type_ArrayOfByte != null) {
      i = 42;
    }
    while (this.jdField_b_of_type_ArrayOfByte == null) {
      return i;
    }
    return 35;
  }
  
  public void a()
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
    if (this.jdField_b_of_type_Boolean)
    {
      this.d = arrayOfInt[0];
      return;
    }
    this.jdField_a_of_type_Int = arrayOfInt[0];
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_c_of_type_Int = AVGLUtils.initFrameBuffer(paramInt2, paramInt1, this.d);
      return;
    }
    this.jdField_b_of_type_Int = AVGLUtils.initFrameBuffer(paramInt2, paramInt1, this.jdField_a_of_type_Int);
  }
  
  public void a(FilterProcessRender paramFilterProcessRender, CameraFrame paramCameraFrame, GLTexture paramGLTexture, FaceData paramFaceData, RenderResult paramRenderResult)
  {
    if (paramFilterProcessRender.jdField_a_of_type_ComTencentAvUtilsPerfRecorder != null) {
      paramFilterProcessRender.jdField_a_of_type_ComTencentAvUtilsPerfRecorder.a("postRender");
    }
    a(paramFilterProcessRender, paramCameraFrame, paramGLTexture, paramFaceData, paramFilterProcessRender.jdField_a_of_type_JavaNioFloatBuffer, paramRenderResult);
    if (paramFilterProcessRender.jdField_a_of_type_ComTencentAvUtilsPerfRecorder != null) {
      paramFilterProcessRender.jdField_a_of_type_ComTencentAvUtilsPerfRecorder.b("postRender");
    }
    if (paramFilterProcessRender.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessTest != null)
    {
      paramCameraFrame = GLTexture.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Int);
      paramFilterProcessRender.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessTest.a(paramFilterProcessRender, 4, null, paramCameraFrame);
      paramFilterProcessRender.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessTest.d();
      paramCameraFrame.a();
    }
  }
  
  public byte[] a()
  {
    byte[] arrayOfByte = null;
    if (this.jdField_a_of_type_ArrayOfByte != null) {
      arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    }
    while (this.jdField_b_of_type_ArrayOfByte == null) {
      return arrayOfByte;
    }
    return this.jdField_b_of_type_ArrayOfByte;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ArrayOfByte = null;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_ArrayOfByte = null;
      this.jdField_c_of_type_ArrayOfByte = null;
    }
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      arrayOfInt = new int[1];
      arrayOfInt[0] = this.d;
      GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
      this.d = -1;
      GLES20.glDeleteFramebuffers(1, new int[] { this.jdField_c_of_type_Int }, 0);
      this.jdField_c_of_type_Int = -1;
      return;
    }
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = this.jdField_a_of_type_Int;
    GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    this.jdField_a_of_type_Int = -1;
    GLES20.glDeleteFramebuffers(1, new int[] { this.jdField_b_of_type_Int }, 0);
    this.jdField_b_of_type_Int = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.effects.YuvPostRender
 * JD-Core Version:    0.7.0.1
 */