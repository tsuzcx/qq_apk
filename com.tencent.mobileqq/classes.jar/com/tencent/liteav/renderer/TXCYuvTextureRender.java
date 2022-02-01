package com.tencent.liteav.renderer;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.util.f;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class TXCYuvTextureRender
{
  private static final int BYTES_PER_FLOAT = 4;
  private static final int INVALID_TEXTURE_ID = -12345;
  private static final int POSITION_COMPONENT_COUNT = 2;
  private static final String TAG = "TXCYuvTextureRender";
  private static final int TEXTURE_COORDINATES_COMPONENT_COUNT = 2;
  private static final String mFragmentShaderCode = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D yTexture;\nuniform sampler2D uTexture;\nuniform mat3 convertMatrix;\nuniform vec3 offset;\n\nvoid main()\n{\n    highp vec3 yuvColor;\n    highp vec3 rgbColor;\n\n    // Get the YUV values\n    yuvColor.x = texture2D(yTexture, textureCoordinate).r;\n    yuvColor.y = texture2D(uTexture, vec2(textureCoordinate.x * 0.5, textureCoordinate.y * 0.5)).r;\n    yuvColor.z = texture2D(uTexture, vec2(textureCoordinate.x * 0.5, textureCoordinate.y * 0.5 + 0.5)).r;\n\n    // Do the color transform   \n    yuvColor += offset;\n    rgbColor = convertMatrix * yuvColor; \n\n    gl_FragColor = vec4(rgbColor, 1.0);\n}\n";
  private static final String mVertexShaderCode = "uniform mat4 uMatrix;uniform mat4 uTextureMatrix;attribute vec2 position;attribute vec2 inputTextureCoordinate;varying vec2 textureCoordinate;void main() {vec4 pos  = vec4(position, 0.0, 1.0);gl_Position = uMatrix * pos;textureCoordinate = (uTextureMatrix*vec4(inputTextureCoordinate, 0.0, 0.0)).xy;}";
  float[] bt601_fullrage_ffmpeg_matrix = { 1.0F, 1.0F, 1.0F, 0.0F, -0.3441F, 1.772F, 1.402F, -0.7141F, 0.0F };
  float[] bt601_fullrange_ffmpeg_offset = { 0.0F, -0.5019608F, -0.5019608F };
  float[] bt601_videorage_ffmpeg_matrix = { 1.1644F, 1.1644F, 1.1644F, 0.0F, -0.3918F, 2.0172F, 1.596F, -0.813F, 0.0F };
  float[] bt601_videorange_ffmpeg_offset = { -0.0627451F, -0.5019608F, -0.5019608F };
  private final int def_InputType_YUVJ420 = 4;
  private int mConvertMatrixUniform = -1;
  private int mConvertOffsetUniform = -1;
  private int mFrameBufferID = -12345;
  private int mFrameBufferTextureID = -12345;
  private int mHeight;
  private short[] mIndices;
  private ShortBuffer mIndicesBuffer;
  private float[] mMVPMatrix = new float[16];
  private boolean mNeedReLoadFrameBuffer = false;
  private int mPositionHandle;
  private int mProgram;
  private int mRawDataFrameType = -1;
  private FloatBuffer mTextureBuffer;
  private int mTextureCoordinatesHandle;
  private int[] mTextureIds;
  private float[] mTextureMatrix = new float[16];
  private int mTextureMatrixHandle;
  private int mTextureUnitHandle0;
  private int mTextureUnitHandle1;
  private FloatBuffer mVertexBuffer;
  private int mVertexMatrixHandle;
  private float[] mVerticesCoordinates;
  private int mVideoHeight = 0;
  private int mVideoWidth = 0;
  private int mWidth;
  private float[] mbt601_fullRange_matrix3 = { 1.0F, 1.0F, 1.0F, 0.0F, -0.343F, 1.765F, 1.4F, -0.711F, 0.0F };
  private float[] mbt601_offset_matrix = { 0.0F, -0.5F, -0.5F };
  private float[] mbt601_videoRange_matrix3 = { 1.164F, 1.164F, 1.164F, 0.0F, -0.392F, 2.017F, 1.596F, -0.813F, 0.0F };
  private float[] mbt709_videoRange_matrix3 = { 1.164F, 1.164F, 1.164F, 0.0F, -0.213F, 2.112F, 1.793F, -0.533F, 0.0F };
  
  static
  {
    f.f();
  }
  
  public TXCYuvTextureRender()
  {
    float[] arrayOfFloat = new float[8];
    float[] tmp403_402 = arrayOfFloat;
    tmp403_402[0] = 0.0F;
    float[] tmp407_403 = tmp403_402;
    tmp407_403[1] = 1.0F;
    float[] tmp411_407 = tmp407_403;
    tmp411_407[2] = 1.0F;
    float[] tmp415_411 = tmp411_407;
    tmp415_411[3] = 1.0F;
    float[] tmp419_415 = tmp415_411;
    tmp419_415[4] = 0.0F;
    float[] tmp423_419 = tmp419_415;
    tmp423_419[5] = 0.0F;
    float[] tmp427_423 = tmp423_419;
    tmp427_423[6] = 1.0F;
    float[] tmp432_427 = tmp427_423;
    tmp432_427[7] = 0.0F;
    tmp432_427;
    this.mIndices = new short[] { 0, 1, 2, 1, 3, 2 };
    this.mVerticesCoordinates = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
    this.mTextureBuffer = ByteBuffer.allocateDirect(arrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mTextureBuffer.put(arrayOfFloat);
    this.mTextureBuffer.position(0);
    this.mVertexBuffer = ByteBuffer.allocateDirect(this.mVerticesCoordinates.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mVertexBuffer.put(this.mVerticesCoordinates);
    this.mVertexBuffer.position(0);
    this.mIndicesBuffer = ByteBuffer.allocateDirect(this.mIndices.length * 2).order(ByteOrder.nativeOrder()).asShortBuffer();
    this.mIndicesBuffer.put(this.mIndices);
    this.mIndicesBuffer.position(0);
  }
  
  private void destroyFrameBuffer()
  {
    int i = this.mFrameBufferID;
    if (i != -12345)
    {
      GLES20.glDeleteFramebuffers(1, new int[] { i }, 0);
      this.mFrameBufferID = -12345;
    }
    i = this.mFrameBufferTextureID;
    if (i != -12345)
    {
      GLES20.glDeleteTextures(1, new int[] { i }, 0);
      this.mFrameBufferTextureID = -12345;
    }
  }
  
  public static native void nativeLoadTexture(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int[] paramArrayOfInt);
  
  private void reloadFrameBuffer()
  {
    if (!this.mNeedReLoadFrameBuffer) {
      return;
    }
    Object localObject1 = TAG;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("reloadFrameBuffer. size = ");
    ((StringBuilder)localObject2).append(this.mWidth);
    ((StringBuilder)localObject2).append("*");
    ((StringBuilder)localObject2).append(this.mHeight);
    TXCLog.i((String)localObject1, ((StringBuilder)localObject2).toString());
    destroyFrameBuffer();
    localObject1 = new int[1];
    localObject2 = new int[1];
    GLES20.glGenTextures(1, (int[])localObject1, 0);
    GLES20.glGenFramebuffers(1, (int[])localObject2, 0);
    this.mFrameBufferTextureID = localObject1[0];
    this.mFrameBufferID = localObject2[0];
    localObject1 = TAG;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("frameBuffer id = ");
    ((StringBuilder)localObject2).append(this.mFrameBufferID);
    ((StringBuilder)localObject2).append(", texture id = ");
    ((StringBuilder)localObject2).append(this.mFrameBufferTextureID);
    TXCLog.d((String)localObject1, ((StringBuilder)localObject2).toString());
    GLES20.glBindTexture(3553, this.mFrameBufferTextureID);
    GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glBindFramebuffer(36160, this.mFrameBufferID);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.mFrameBufferTextureID, 0);
    GLES20.glBindTexture(3553, 0);
    GLES20.glBindFramebuffer(36160, 0);
    this.mNeedReLoadFrameBuffer = false;
  }
  
  public int checkError()
  {
    int i = GLES20.glGetError();
    if (i == 0) {
      return i;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gl error=");
    localStringBuilder.append(i);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public void createTexture()
  {
    int i = GLES20.glCreateShader(35633);
    checkError();
    GLES20.glShaderSource(i, "uniform mat4 uMatrix;uniform mat4 uTextureMatrix;attribute vec2 position;attribute vec2 inputTextureCoordinate;varying vec2 textureCoordinate;void main() {vec4 pos  = vec4(position, 0.0, 1.0);gl_Position = uMatrix * pos;textureCoordinate = (uTextureMatrix*vec4(inputTextureCoordinate, 0.0, 0.0)).xy;}");
    checkError();
    GLES20.glCompileShader(i);
    checkError();
    int j = GLES20.glCreateShader(35632);
    checkError();
    GLES20.glShaderSource(j, "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D yTexture;\nuniform sampler2D uTexture;\nuniform mat3 convertMatrix;\nuniform vec3 offset;\n\nvoid main()\n{\n    highp vec3 yuvColor;\n    highp vec3 rgbColor;\n\n    // Get the YUV values\n    yuvColor.x = texture2D(yTexture, textureCoordinate).r;\n    yuvColor.y = texture2D(uTexture, vec2(textureCoordinate.x * 0.5, textureCoordinate.y * 0.5)).r;\n    yuvColor.z = texture2D(uTexture, vec2(textureCoordinate.x * 0.5, textureCoordinate.y * 0.5 + 0.5)).r;\n\n    // Do the color transform   \n    yuvColor += offset;\n    rgbColor = convertMatrix * yuvColor; \n\n    gl_FragColor = vec4(rgbColor, 1.0);\n}\n");
    checkError();
    GLES20.glCompileShader(j);
    this.mProgram = GLES20.glCreateProgram();
    checkError();
    GLES20.glAttachShader(this.mProgram, i);
    checkError();
    GLES20.glAttachShader(this.mProgram, j);
    checkError();
    GLES20.glLinkProgram(this.mProgram);
    checkError();
    GLES20.glDeleteShader(i);
    GLES20.glDeleteShader(j);
    this.mVertexMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uMatrix");
    checkError();
    this.mTextureMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uTextureMatrix");
    checkError();
    this.mPositionHandle = GLES20.glGetAttribLocation(this.mProgram, "position");
    checkError();
    this.mTextureCoordinatesHandle = GLES20.glGetAttribLocation(this.mProgram, "inputTextureCoordinate");
    checkError();
    this.mTextureUnitHandle0 = GLES20.glGetUniformLocation(this.mProgram, "yTexture");
    checkError();
    this.mTextureUnitHandle1 = GLES20.glGetUniformLocation(this.mProgram, "uTexture");
    checkError();
    this.mConvertOffsetUniform = GLES20.glGetUniformLocation(this.mProgram, "offset");
    GLES20.glUniform3fv(this.mConvertOffsetUniform, 1, FloatBuffer.wrap(this.bt601_fullrange_ffmpeg_offset));
    this.mConvertMatrixUniform = GLES20.glGetUniformLocation(this.mProgram, "convertMatrix");
    GLES20.glUniformMatrix3fv(this.mConvertMatrixUniform, 1, false, this.bt601_fullrage_ffmpeg_matrix, 0);
    this.mTextureIds = new int[2];
    GLES20.glGenTextures(2, this.mTextureIds, 0);
  }
  
  public void drawFrame(TXSVideoFrame paramTXSVideoFrame)
  {
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glClear(16640);
    Matrix.setIdentityM(this.mMVPMatrix, 0);
    Matrix.setIdentityM(this.mTextureMatrix, 0);
    GLES20.glUseProgram(this.mProgram);
    checkError();
    GLES20.glEnableVertexAttribArray(this.mPositionHandle);
    checkError();
    this.mVertexBuffer.position(0);
    GLES20.glVertexAttribPointer(this.mPositionHandle, 2, 5126, false, 8, this.mVertexBuffer);
    checkError();
    GLES20.glEnableVertexAttribArray(this.mTextureCoordinatesHandle);
    checkError();
    this.mTextureBuffer.position(0);
    GLES20.glVertexAttribPointer(this.mTextureCoordinatesHandle, 2, 5126, false, 8, this.mTextureBuffer);
    checkError();
    GLES20.glUniformMatrix4fv(this.mVertexMatrixHandle, 1, false, this.mMVPMatrix, 0);
    checkError();
    GLES20.glUniformMatrix4fv(this.mTextureMatrixHandle, 1, false, this.mTextureMatrix, 0);
    checkError();
    int i = paramTXSVideoFrame.frameType;
    String str;
    StringBuilder localStringBuilder;
    if (4 == i)
    {
      GLES20.glUniform3fv(this.mConvertOffsetUniform, 1, FloatBuffer.wrap(this.bt601_fullrange_ffmpeg_offset));
      GLES20.glUniformMatrix3fv(this.mConvertMatrixUniform, 1, false, this.bt601_fullrage_ffmpeg_matrix, 0);
      if (i != this.mRawDataFrameType)
      {
        this.mRawDataFrameType = i;
        str = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(" frame type ");
        localStringBuilder.append(i);
        localStringBuilder.append(" matrix_test fullRange");
        TXCLog.i(str, localStringBuilder.toString());
      }
    }
    else
    {
      GLES20.glUniform3fv(this.mConvertOffsetUniform, 1, FloatBuffer.wrap(this.bt601_videorange_ffmpeg_offset));
      GLES20.glUniformMatrix3fv(this.mConvertMatrixUniform, 1, false, this.bt601_videorage_ffmpeg_matrix, 0);
      if (i != this.mRawDataFrameType)
      {
        this.mRawDataFrameType = i;
        str = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(" frame type ");
        localStringBuilder.append(i);
        localStringBuilder.append(" matrix_test videoRange");
        TXCLog.i(str, localStringBuilder.toString());
      }
    }
    GLES20.glUniform1i(this.mTextureUnitHandle0, 0);
    checkError();
    GLES20.glUniform1i(this.mTextureUnitHandle1, 1);
    checkError();
    if ((paramTXSVideoFrame.buffer != null) && (this.mTextureIds != null)) {
      nativeLoadTexture(paramTXSVideoFrame.buffer, paramTXSVideoFrame.width, paramTXSVideoFrame.height, this.mTextureIds);
    }
    paramTXSVideoFrame.release();
    GLES20.glDrawElements(4, this.mIndices.length, 5123, this.mIndicesBuffer);
    GLES20.glDisableVertexAttribArray(this.mPositionHandle);
    GLES20.glDisableVertexAttribArray(this.mTextureCoordinatesHandle);
  }
  
  public int drawToTexture(TXSVideoFrame paramTXSVideoFrame)
  {
    reloadFrameBuffer();
    int i = this.mFrameBufferID;
    if (i == -12345)
    {
      TXCLog.w(TAG, "invalid frame buffer id");
      return -12345;
    }
    GLES20.glBindFramebuffer(36160, i);
    GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
    drawFrame(paramTXSVideoFrame);
    GLES20.glBindFramebuffer(36160, 0);
    return this.mFrameBufferTextureID;
  }
  
  public void flipVertical(boolean paramBoolean)
  {
    float[] arrayOfFloat;
    if (paramBoolean)
    {
      arrayOfFloat = new float[8];
      float[] tmp10_9 = arrayOfFloat;
      tmp10_9[0] = 0.0F;
      float[] tmp14_10 = tmp10_9;
      tmp14_10[1] = 1.0F;
      float[] tmp18_14 = tmp14_10;
      tmp18_14[2] = 1.0F;
      float[] tmp22_18 = tmp18_14;
      tmp22_18[3] = 1.0F;
      float[] tmp26_22 = tmp22_18;
      tmp26_22[4] = 0.0F;
      float[] tmp30_26 = tmp26_22;
      tmp30_26[5] = 0.0F;
      float[] tmp34_30 = tmp30_26;
      tmp34_30[6] = 1.0F;
      float[] tmp39_34 = tmp34_30;
      tmp39_34[7] = 0.0F;
      tmp39_34;
    }
    else
    {
      arrayOfFloat = new float[8];
      float[] tmp54_53 = arrayOfFloat;
      tmp54_53[0] = 0.0F;
      float[] tmp58_54 = tmp54_53;
      tmp58_54[1] = 0.0F;
      float[] tmp62_58 = tmp58_54;
      tmp62_58[2] = 1.0F;
      float[] tmp66_62 = tmp62_58;
      tmp66_62[3] = 0.0F;
      float[] tmp70_66 = tmp66_62;
      tmp70_66[4] = 0.0F;
      float[] tmp74_70 = tmp70_66;
      tmp74_70[5] = 1.0F;
      float[] tmp78_74 = tmp74_70;
      tmp78_74[6] = 1.0F;
      float[] tmp83_78 = tmp78_74;
      tmp83_78[7] = 1.0F;
      tmp83_78;
    }
    this.mTextureBuffer = ByteBuffer.allocateDirect(arrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mTextureBuffer.put(arrayOfFloat);
    this.mTextureBuffer.position(0);
  }
  
  public void onSurfaceDestroy()
  {
    int[] arrayOfInt = this.mTextureIds;
    if (arrayOfInt != null)
    {
      GLES20.glDeleteTextures(2, arrayOfInt, 0);
      this.mTextureIds = null;
    }
    destroyFrameBuffer();
    GLES20.glDeleteProgram(this.mProgram);
  }
  
  public void setHasFrameBuffer(int paramInt1, int paramInt2)
  {
    if ((this.mWidth == paramInt1) && (this.mHeight == paramInt2)) {
      return;
    }
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    this.mNeedReLoadFrameBuffer = true;
  }
  
  public void setVideoSize(int paramInt1, int paramInt2)
  {
    this.mVideoWidth = paramInt1;
    this.mVideoHeight = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.renderer.TXCYuvTextureRender
 * JD-Core Version:    0.7.0.1
 */