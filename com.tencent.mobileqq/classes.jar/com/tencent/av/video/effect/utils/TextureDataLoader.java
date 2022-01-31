package com.tencent.av.video.effect.utils;

import android.opengl.GLES20;
import com.tencent.av.video.effect.core.EffectTexture;
import com.tencent.av.video.effect.core.qqavimage.util.OpenGlUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class TextureDataLoader
{
  static final float[] CUBE = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  public static final int NO_PROGRAM = 0;
  static final float[] TEXTURE_COORDINATE = { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
  public static float[] YUV_2_RGB_MATRIX = { 1.0F, 1.0F, 1.0F, 0.0F, 0.00093F, -0.3437F, 1.77216F, 0.0F, 1.401687F, -0.71417F, 0.00099F, 0.0F, -0.7011F, 0.525F, -0.8828F, 1.0F };
  public static final String YUV_FRAGMENT_SHADER = "precision highp float;\nvarying highp vec2 textureCoordinate;\nuniform int yuvFormat;\nuniform sampler2D inputImageTexture0;\nuniform sampler2D inputImageTexture1;\nuniform sampler2D inputImageTexture2;\nuniform mat4 colorMat;\nvoid main() {\n    vec3 yuvData;\n    yuvData.x = texture2D(inputImageTexture0, textureCoordinate).x;\n    if(yuvFormat==1){\n        vec2 uv = texture2D(inputImageTexture1, textureCoordinate).ra;\n        yuvData.y = uv.x;\n        yuvData.z = uv.y;\n    }else if(yuvFormat==2){\n        vec2 uv = texture2D(inputImageTexture1, textureCoordinate).ra;\n        yuvData.z = uv.x;\n        yuvData.y = uv.y;\n    }else{\n        yuvData.y = texture2D(inputImageTexture1, textureCoordinate).x;\n        yuvData.z = texture2D(inputImageTexture2, textureCoordinate).x;\n    }\n    vec4 rgbData =  colorMat*vec4(yuvData,1.0);\n    gl_FragColor  = vec4(rgbData.rgb,1.0);\n}";
  public static final String YUV_VERTEX_SHADER = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}";
  private ByteBuffer mDataBuffer = null;
  private int mGLAttribPosition;
  private int mGLAttribTextureCoordinate;
  private final FloatBuffer mGLCubeBuffer;
  private final FloatBuffer mGLTextureBuffer;
  private int mGLUniformColorMat;
  private int mGLUniformTexture0;
  private int mGLUniformTexture1;
  private int mGLUniformTexture2;
  private int mGLUniformYuvFormat;
  private int mHeight = 0;
  private int mProgramId = 0;
  int mResultFBO = -1;
  int mResultFBOReleTextureId = -1;
  private int mWidth = 0;
  private int[] mYuvTempTextureId = new int[3];
  
  public TextureDataLoader()
  {
    this.mYuvTempTextureId[0] = -1;
    this.mYuvTempTextureId[1] = -1;
    this.mYuvTempTextureId[2] = -1;
    this.mGLCubeBuffer = ByteBuffer.allocateDirect(CUBE.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mGLCubeBuffer.put(CUBE).position(0);
    this.mGLTextureBuffer = ByteBuffer.allocateDirect(TEXTURE_COORDINATE.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mGLTextureBuffer.put(TEXTURE_COORDINATE).position(0);
  }
  
  private void createResultFBO(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mResultFBO != -1)
    {
      GLES20.glDeleteFramebuffers(1, new int[] { this.mResultFBO }, 0);
      this.mResultFBO = -1;
    }
    this.mResultFBO = initFrameBuffer(paramInt1, paramInt2, paramInt3);
  }
  
  private static int initFrameBuffer(int paramInt1, int paramInt2, int paramInt3)
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    GLES20.glBindFramebuffer(36160, arrayOfInt[0]);
    GLES20.glBindTexture(3553, paramInt3);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
    GLES20.glBindTexture(3553, 0);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt3, 0);
    GLES20.glBindFramebuffer(36160, 0);
    return arrayOfInt[0];
  }
  
  public void destroy()
  {
    this.mWidth = 0;
    this.mHeight = 0;
    if (this.mDataBuffer != null)
    {
      this.mDataBuffer.clear();
      this.mDataBuffer = null;
    }
    if (this.mResultFBO != -1)
    {
      GLES20.glDeleteFramebuffers(1, new int[] { this.mResultFBO }, 0);
      this.mResultFBO = -1;
      this.mResultFBOReleTextureId = -1;
    }
    if (this.mYuvTempTextureId[0] != -1)
    {
      GLES20.glDeleteTextures(this.mYuvTempTextureId.length, this.mYuvTempTextureId, 0);
      this.mYuvTempTextureId[0] = -1;
      this.mYuvTempTextureId[1] = -1;
      this.mYuvTempTextureId[2] = -1;
    }
  }
  
  public EffectTexture loadDataToTexture(byte[] paramArrayOfByte, ColorFormat paramColorFormat, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0) || (paramInt1 == 0) || (paramInt2 == 0)) {
      return new EffectTexture(paramInt3, -1, paramInt1, paramInt2);
    }
    int[] arrayOfInt = new int[1];
    if (paramInt3 == -1)
    {
      GLES20.glGenTextures(1, arrayOfInt, 0);
      GLES20.glBindTexture(3553, arrayOfInt[0]);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
    }
    for (;;)
    {
      paramInt3 = arrayOfInt[0];
      if ((this.mWidth != paramInt1) || (this.mHeight != paramInt2))
      {
        this.mWidth = paramInt1;
        this.mHeight = paramInt2;
        if (this.mDataBuffer != null) {
          this.mDataBuffer.clear();
        }
        this.mDataBuffer = ByteBuffer.allocate(this.mWidth * this.mHeight * 4);
        createResultFBO(paramInt1, paramInt2, paramInt3);
        this.mResultFBOReleTextureId = paramInt3;
      }
      if (this.mResultFBOReleTextureId != paramInt3)
      {
        createResultFBO(this.mWidth, this.mHeight, paramInt3);
        this.mResultFBOReleTextureId = paramInt3;
      }
      if (this.mProgramId == 0)
      {
        this.mProgramId = OpenGlUtils.loadProgram("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "precision highp float;\nvarying highp vec2 textureCoordinate;\nuniform int yuvFormat;\nuniform sampler2D inputImageTexture0;\nuniform sampler2D inputImageTexture1;\nuniform sampler2D inputImageTexture2;\nuniform mat4 colorMat;\nvoid main() {\n    vec3 yuvData;\n    yuvData.x = texture2D(inputImageTexture0, textureCoordinate).x;\n    if(yuvFormat==1){\n        vec2 uv = texture2D(inputImageTexture1, textureCoordinate).ra;\n        yuvData.y = uv.x;\n        yuvData.z = uv.y;\n    }else if(yuvFormat==2){\n        vec2 uv = texture2D(inputImageTexture1, textureCoordinate).ra;\n        yuvData.z = uv.x;\n        yuvData.y = uv.y;\n    }else{\n        yuvData.y = texture2D(inputImageTexture1, textureCoordinate).x;\n        yuvData.z = texture2D(inputImageTexture2, textureCoordinate).x;\n    }\n    vec4 rgbData =  colorMat*vec4(yuvData,1.0);\n    gl_FragColor  = vec4(rgbData.rgb,1.0);\n}");
        this.mGLAttribPosition = GLES20.glGetAttribLocation(this.mProgramId, "position");
        this.mGLAttribTextureCoordinate = GLES20.glGetAttribLocation(this.mProgramId, "inputTextureCoordinate");
        this.mGLUniformTexture0 = GLES20.glGetUniformLocation(this.mProgramId, "inputImageTexture0");
        this.mGLUniformTexture1 = GLES20.glGetUniformLocation(this.mProgramId, "inputImageTexture1");
        this.mGLUniformTexture2 = GLES20.glGetUniformLocation(this.mProgramId, "inputImageTexture2");
        this.mGLUniformYuvFormat = GLES20.glGetUniformLocation(this.mProgramId, "yuvFormat");
        this.mGLUniformColorMat = GLES20.glGetUniformLocation(this.mProgramId, "colorMat");
      }
      if (this.mYuvTempTextureId[0] == -1) {
        GLES20.glGenTextures(this.mYuvTempTextureId.length, this.mYuvTempTextureId, 0);
      }
      if (paramColorFormat != ColorFormat.RGBA) {
        break;
      }
      this.mDataBuffer.position(0);
      this.mDataBuffer.put(paramArrayOfByte, 0, paramInt1 * paramInt2 * 4);
      this.mDataBuffer.position(0);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.mResultFBOReleTextureId);
      GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, this.mDataBuffer);
      return new EffectTexture(paramInt3, this.mResultFBO, this.mWidth, this.mHeight);
      GLES20.glBindTexture(3553, paramInt3);
      arrayOfInt[0] = paramInt3;
    }
    this.mDataBuffer.position(0);
    this.mDataBuffer.put(paramArrayOfByte, 0, paramInt1 * paramInt2);
    this.mDataBuffer.position(0);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.mYuvTempTextureId[0]);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glTexImage2D(3553, 0, 6409, paramInt1, paramInt2, 0, 6409, 5121, this.mDataBuffer);
    if ((paramColorFormat == ColorFormat.NV12) || (paramColorFormat == ColorFormat.NV21))
    {
      this.mDataBuffer.position(0);
      this.mDataBuffer.put(paramArrayOfByte, paramInt1 * paramInt2, paramInt1 * paramInt2 / 2);
      this.mDataBuffer.position(0);
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(3553, this.mYuvTempTextureId[1]);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glTexImage2D(3553, 0, 6410, paramInt1 / 2, paramInt2 / 2, 0, 6410, 5121, this.mDataBuffer);
      label723:
      GLES20.glBindFramebuffer(36160, this.mResultFBO);
      GLES20.glViewport(0, 0, paramInt1, paramInt2);
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
      GLES20.glClear(16640);
      GLES20.glUseProgram(this.mProgramId);
      GLES20.glUniformMatrix4fv(this.mGLUniformColorMat, 1, false, YUV_2_RGB_MATRIX, 0);
      if (paramColorFormat != ColorFormat.NV12) {
        break label1227;
      }
      GLES20.glUniform1i(this.mGLUniformYuvFormat, 1);
    }
    for (;;)
    {
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.mYuvTempTextureId[0]);
      GLES20.glUniform1i(this.mGLUniformTexture0, 0);
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(3553, this.mYuvTempTextureId[1]);
      GLES20.glUniform1i(this.mGLUniformTexture1, 1);
      GLES20.glActiveTexture(33986);
      GLES20.glBindTexture(3553, this.mYuvTempTextureId[2]);
      GLES20.glUniform1i(this.mGLUniformTexture2, 2);
      this.mGLCubeBuffer.position(0);
      GLES20.glEnableVertexAttribArray(this.mGLAttribPosition);
      GLES20.glVertexAttribPointer(this.mGLAttribPosition, 2, 5126, false, 0, this.mGLCubeBuffer);
      this.mGLTextureBuffer.position(0);
      GLES20.glEnableVertexAttribArray(this.mGLAttribTextureCoordinate);
      GLES20.glVertexAttribPointer(this.mGLAttribTextureCoordinate, 2, 5126, false, 0, this.mGLTextureBuffer);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(this.mGLAttribPosition);
      GLES20.glDisableVertexAttribArray(this.mGLAttribTextureCoordinate);
      GLES20.glBindTexture(3553, 0);
      GLES20.glBindFramebuffer(36160, 0);
      break;
      this.mDataBuffer.position(0);
      this.mDataBuffer.put(paramArrayOfByte, paramInt1 * paramInt2, paramInt1 * paramInt2 / 4);
      this.mDataBuffer.position(0);
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(3553, this.mYuvTempTextureId[1]);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glTexImage2D(3553, 0, 6409, paramInt1 / 2, paramInt2 / 2, 0, 6409, 5121, this.mDataBuffer);
      this.mDataBuffer.position(0);
      this.mDataBuffer.put(paramArrayOfByte, paramInt1 * paramInt2 + paramInt1 * paramInt2 / 4, paramInt1 * paramInt2 / 4);
      this.mDataBuffer.position(0);
      GLES20.glActiveTexture(33986);
      GLES20.glBindTexture(3553, this.mYuvTempTextureId[2]);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glTexImage2D(3553, 0, 6409, paramInt1 / 2, paramInt2 / 2, 0, 6409, 5121, this.mDataBuffer);
      break label723;
      label1227:
      if (paramColorFormat == ColorFormat.NV21) {
        GLES20.glUniform1i(this.mGLUniformYuvFormat, 2);
      } else {
        GLES20.glUniform1i(this.mGLUniformYuvFormat, 3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.video.effect.utils.TextureDataLoader
 * JD-Core Version:    0.7.0.1
 */