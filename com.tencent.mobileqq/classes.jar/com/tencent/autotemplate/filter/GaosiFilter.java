package com.tencent.autotemplate.filter;

import android.opengl.GLES20;
import android.util.Log;
import com.tencent.taveffect.core.TAVBaseFilter;
import com.tencent.taveffect.core.TAVRectangle;
import com.tencent.taveffect.core.TAVTextureInfo;
import com.tencent.taveffect.utils.TAVGLUtils;
import com.tencent.taveffect.utils.TAVMatrixUtils;
import com.tencent.taveffect.utils.TVTGLProgramUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

@Deprecated
public class GaosiFilter
  extends TAVBaseFilter
{
  protected static final int FLOAT_SIZE_BYTES = 4;
  public static final String FRAGMENT_SHADER = "precision mediump float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputTexture;// 原始图像\n// 高斯算子左右偏移值，当偏移值为2时，高斯算子为5 x 5\nconst int SHIFT_SIZE = 2;\nvarying vec4 blurShiftCoordinates[SHIFT_SIZE];\nvec4 drawGaosiImage(sampler2D targetTexture);\nvoid main() {\n    gl_FragColor = drawGaosiImage(inputTexture);\n}\n\nvec4 drawGaosiImage(sampler2D targetTexture) {\n    // 计算当前坐标的颜色值\n    vec4 currentColor = texture2D(targetTexture, textureCoordinate);\n    mediump vec3 sum = currentColor.rgb;\n    // 计算偏移坐标的颜色值总和\n    for (int i = 0; i < SHIFT_SIZE; i++) {\n        sum += texture2D(targetTexture, blurShiftCoordinates[i].xy).rgb;\n        sum += texture2D(targetTexture, blurShiftCoordinates[i].zw).rgb;\n    }\n    // 求出平均值\n    vec4 gaosiColor = vec4(sum * 1.0 / float(2 * SHIFT_SIZE + 1), currentColor.a);\n    return gaosiColor;\n}";
  protected static final int TRIANGLE_VERTICES_DATA_POS_OFFSET = 0;
  protected static final int TRIANGLE_VERTICES_DATA_STRIDE_BYTES = 8;
  public static String VERTEX_SHADER_CODE = "uniform vec2 uScreenSize;\nuniform vec2 uTextureSize;\nuniform mat3 uMatrix;\nuniform mat3 stMatrix;\nuniform float texelWidthOffset;\nuniform float texelHeightOffset;\n// 高斯算子左右偏移值，当偏移值为2时，高斯算子为5 x 5\nconst int SHIFT_SIZE = 2;\nattribute vec2 aPosition;\nvarying vec2 textureCoordinate;\nvarying vec4 blurShiftCoordinates[SHIFT_SIZE];\nvoid main() {\n  vec3 position = uMatrix * vec3(aPosition, 1);\n  vec2 clipSpace = (position.xy / uScreenSize) * 2.0 - 1.0;\n  gl_Position = vec4(clipSpace, 0, 1);\n  vec3 coord = vec3(aPosition / uTextureSize, 1);\n  textureCoordinate = (stMatrix * coord).xy;\n\t\n// 记录偏移坐标\n   vec2 singleStepOffset = vec2(texelHeightOffset, texelWidthOffset);\n    \n   for (int i = 0; i < SHIFT_SIZE; i++) \n   {\n       blurShiftCoordinates[i] = vec4(textureCoordinate.xy - float(i + 1) * singleStepOffset, textureCoordinate.xy + float(i + 1) * singleStepOffset);\n\t}\n}\n";
  private int aPositionHandle;
  protected float blurSize = 5.0F;
  private int[] fbo = new int[1];
  protected boolean horizontal;
  protected TAVTextureInfo outputTextureInfo;
  private int texelHeightOffsetLocation;
  private int texelWidthOffsetLocation;
  protected int[] textureID = new int[1];
  protected FloatBuffer triangleVertices;
  private int uScreenSizeHandle;
  private int uTextureSizeHandle;
  
  public GaosiFilter(boolean paramBoolean)
  {
    this.horizontal = paramBoolean;
  }
  
  private void bindFramebuffer()
  {
    GLES20.glGetIntegerv(2978, this.defaultViewport, 0);
    int[] arrayOfInt = this.fbo;
    if (arrayOfInt[0] == 0)
    {
      GLES20.glGenTextures(1, this.textureID, 0);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.textureID[0]);
      GLES20.glTexImage2D(3553, 0, 6407, this.rendererWidth, this.rendererHeight, 0, 6407, 5121, null);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameteri(3553, 10242, 33071);
      GLES20.glTexParameteri(3553, 10243, 33071);
      GLES20.glBindTexture(3553, 0);
      GLES20.glGenFramebuffers(1, this.fbo, 0);
      GLES20.glBindFramebuffer(36160, this.fbo[0]);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.textureID[0], 0);
      GLES20.glClear(16384);
      GLES20.glViewport(0, 0, this.rendererWidth, this.rendererHeight);
      return;
    }
    GLES20.glBindFramebuffer(36160, arrayOfInt[0]);
    GLES20.glClear(16384);
    GLES20.glViewport(0, 0, this.rendererWidth, this.rendererHeight);
  }
  
  private void finishDraw(TAVTextureInfo paramTAVTextureInfo)
  {
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(paramTAVTextureInfo.textureType, 0);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glViewport(this.defaultViewport[0], this.defaultViewport[1], this.defaultViewport[2], this.defaultViewport[3]);
  }
  
  protected void afterDraw(TAVTextureInfo paramTAVTextureInfo) {}
  
  public TAVTextureInfo applyNewTexture(TAVTextureInfo paramTAVTextureInfo)
  {
    if ((this.rendererWidth == 0) || (this.rendererHeight == 0))
    {
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("rendererWidth = ");
      localStringBuilder.append(this.rendererWidth);
      localStringBuilder.append(", rendererHeight = ");
      localStringBuilder.append(this.rendererHeight);
      Log.w(str, localStringBuilder.toString());
    }
    if ((paramTAVTextureInfo.textureType != this.textureType) || (this.program == 0)) {
      initShader(paramTAVTextureInfo);
    }
    bindFramebuffer();
    useProgram();
    beforeDraw(paramTAVTextureInfo);
    onDraw(paramTAVTextureInfo);
    afterDraw(paramTAVTextureInfo);
    finishDraw(paramTAVTextureInfo);
    return getOutputTextureInfo(paramTAVTextureInfo);
  }
  
  protected void beforeDraw(TAVTextureInfo paramTAVTextureInfo)
  {
    boolean bool = this.horizontal;
    float f1 = 0.0F;
    float f2;
    if (bool)
    {
      f2 = getHorizontalTexelOffsetRatio() / paramTAVTextureInfo.width;
    }
    else
    {
      f1 = getVerticalTexelOffsetRatio() / paramTAVTextureInfo.height;
      f2 = 0.0F;
    }
    GLES20.glUniform1f(this.texelWidthOffsetLocation, f2);
    GLES20.glUniform1f(this.texelHeightOffsetLocation, f1);
  }
  
  protected String getFragmentShaderCode()
  {
    return "precision mediump float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputTexture;// 原始图像\n// 高斯算子左右偏移值，当偏移值为2时，高斯算子为5 x 5\nconst int SHIFT_SIZE = 2;\nvarying vec4 blurShiftCoordinates[SHIFT_SIZE];\nvec4 drawGaosiImage(sampler2D targetTexture);\nvoid main() {\n    gl_FragColor = drawGaosiImage(inputTexture);\n}\n\nvec4 drawGaosiImage(sampler2D targetTexture) {\n    // 计算当前坐标的颜色值\n    vec4 currentColor = texture2D(targetTexture, textureCoordinate);\n    mediump vec3 sum = currentColor.rgb;\n    // 计算偏移坐标的颜色值总和\n    for (int i = 0; i < SHIFT_SIZE; i++) {\n        sum += texture2D(targetTexture, blurShiftCoordinates[i].xy).rgb;\n        sum += texture2D(targetTexture, blurShiftCoordinates[i].zw).rgb;\n    }\n    // 求出平均值\n    vec4 gaosiColor = vec4(sum * 1.0 / float(2 * SHIFT_SIZE + 1), currentColor.a);\n    return gaosiColor;\n}";
  }
  
  public float getHorizontalTexelOffsetRatio()
  {
    return this.blurSize;
  }
  
  protected TAVTextureInfo getOutputTextureInfo(TAVTextureInfo paramTAVTextureInfo)
  {
    if (this.outputTextureInfo == null) {
      this.outputTextureInfo = new TAVTextureInfo();
    }
    this.outputTextureInfo.setFrameTimeUs(paramTAVTextureInfo.frameTimeUs);
    this.outputTextureInfo.setWidth(paramTAVTextureInfo.width);
    this.outputTextureInfo.setHeight(paramTAVTextureInfo.height);
    this.outputTextureInfo.setPreRotation(paramTAVTextureInfo.getPreRotation());
    this.outputTextureInfo.setTextureType(3553);
    this.outputTextureInfo.setTextureID(this.textureID[0]);
    return this.outputTextureInfo;
  }
  
  public float getVerticalTexelOffsetRatio()
  {
    return this.blurSize;
  }
  
  protected void initShader(TAVTextureInfo paramTAVTextureInfo)
  {
    this.triangleVertices = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asFloatBuffer();
    String str1 = getFragmentShaderCode();
    String str2 = VERTEX_SHADER_CODE;
    this.vertexShaderCode = str2;
    this.fragmentShaderCode = str1;
    this.program = TVTGLProgramUtils.createProgram(str2, str1);
    if (this.program == 0)
    {
      new RuntimeException("failed creating program").printStackTrace();
      return;
    }
    this.aPositionHandle = GLES20.glGetAttribLocation(this.program, "aPosition");
    TAVGLUtils.checkEglError("glGetAttribLocation aPosition");
    this.xyMatrixHandle = GLES20.glGetUniformLocation(this.program, "uMatrix");
    TAVGLUtils.checkEglError("glGetUniformLocation uMatrix");
    this.stMatrixHandle = GLES20.glGetUniformLocation(this.program, "stMatrix");
    TAVGLUtils.checkEglError("glGetUniformLocation stMatrix");
    this.uScreenSizeHandle = GLES20.glGetUniformLocation(this.program, "uScreenSize");
    TAVGLUtils.checkEglError("glGetUniformLocation uScreenSize");
    this.uTextureSizeHandle = GLES20.glGetUniformLocation(this.program, "uTextureSize");
    TAVGLUtils.checkEglError("glGetUniformLocation uTextureSize");
    this.stMatrixHandle = GLES20.glGetUniformLocation(this.program, "stMatrix");
    TAVGLUtils.checkEglError("glGetUniformLocation stMatrix");
    this.textureType = paramTAVTextureInfo.textureType;
    this.texelWidthOffsetLocation = GLES20.glGetUniformLocation(this.program, "texelWidthOffset");
    TAVGLUtils.checkEglError("glGetUniformLocation texelWidthOffset");
    this.texelHeightOffsetLocation = GLES20.glGetUniformLocation(this.program, "texelHeightOffset");
    TAVGLUtils.checkEglError("glGetUniformLocation texelHeightOffset");
  }
  
  protected void onDraw(TAVTextureInfo paramTAVTextureInfo)
  {
    if (this.cropRect == null) {
      this.cropRect = new TAVRectangle(0.0F, 0.0F, paramTAVTextureInfo.width, paramTAVTextureInfo.height);
    }
    float f1 = this.cropRect.x;
    float f2 = this.cropRect.y;
    float f3 = this.cropRect.height;
    float f4 = this.cropRect.x;
    float f5 = this.cropRect.y;
    float f6 = this.cropRect.x;
    float f7 = this.cropRect.width;
    float f8 = this.cropRect.y;
    float f9 = this.cropRect.height;
    float f10 = this.cropRect.x;
    float f11 = this.cropRect.width;
    float f12 = this.cropRect.y;
    this.triangleVertices.rewind();
    this.triangleVertices.put(new float[] { f1, f2 + f3, f4, f5, f6 + f7, f8 + f9, f10 + f11, f12 });
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(paramTAVTextureInfo.textureType, paramTAVTextureInfo.textureID);
    this.triangleVertices.position(0);
    GLES20.glVertexAttribPointer(this.aPositionHandle, 2, 5126, false, 8, this.triangleVertices);
    TAVGLUtils.checkEglError("glVertexAttribPointer maPosition");
    GLES20.glEnableVertexAttribArray(this.aPositionHandle);
    TAVGLUtils.checkEglError("glEnableVertexAttribArray aPositionHandle");
    GLES20.glUniformMatrix3fv(this.xyMatrixHandle, 1, false, TAVMatrixUtils.toOpenGL2DMatrix(this.xyMatrix), 0);
    GLES20.glUniform2f(this.uTextureSizeHandle, paramTAVTextureInfo.width, paramTAVTextureInfo.height);
    GLES20.glUniform2f(this.uScreenSizeHandle, this.rendererWidth, this.rendererHeight);
    GLES20.glDrawArrays(5, 0, 4);
    TAVGLUtils.checkEglError("glDrawArrays");
  }
  
  public void release()
  {
    int[] arrayOfInt = this.textureID;
    if (arrayOfInt[0] != 0)
    {
      GLES20.glDeleteTextures(1, arrayOfInt, 0);
      this.textureID[0] = 0;
    }
    arrayOfInt = this.fbo;
    if (arrayOfInt[0] != 0)
    {
      GLES20.glDeleteFramebuffers(1, arrayOfInt, 0);
      this.fbo[0] = 0;
    }
    GLES20.glDeleteProgram(this.program);
    this.program = 0;
    this.xyMatrix = null;
    this.stMatrix = null;
    this.cropRect = null;
  }
  
  protected void useProgram()
  {
    GLES20.glUseProgram(this.program);
    TAVGLUtils.checkEglError("glUseProgram");
    GLES20.glUniformMatrix3fv(this.stMatrixHandle, 1, false, TAVMatrixUtils.toOpenGL2DMatrix(this.stMatrix), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.filter.GaosiFilter
 * JD-Core Version:    0.7.0.1
 */