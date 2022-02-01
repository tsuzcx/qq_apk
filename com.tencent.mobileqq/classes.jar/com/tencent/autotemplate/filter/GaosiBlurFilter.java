package com.tencent.autotemplate.filter;

import android.graphics.Matrix;
import android.opengl.GLES20;
import com.tencent.taveffect.core.TAVTextureInfo;
import com.tencent.taveffect.effects.BaseEffect;
import com.tencent.taveffect.utils.TAVGLUtils;

public class GaosiBlurFilter
  extends BaseEffect
{
  private String FRAGMENT_SHADER;
  private int heightOffsetHandle;
  protected boolean horizontal;
  private int radius;
  private int radiusHandle;
  private int widthOffsetHandle;
  
  public GaosiBlurFilter(boolean paramBoolean, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform int uRadius;\nuniform float uWidthOffset;\nuniform float uHeightOffset;\nmediump float getGaussWeight(mediump float currentPos, mediump float sigma) {\n    return 1.0 / sigma * exp(-(currentPos * currentPos) / (2.0 * sigma * sigma));\n}\nvoid main() {\n");
    localStringBuilder.append(getGaussianSampleCode());
    localStringBuilder.append("}");
    this.FRAGMENT_SHADER = localStringBuilder.toString();
    this.horizontal = paramBoolean;
    this.radius = paramInt;
  }
  
  private String getBoxSampleCode()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("   int diameter = 2 * uRadius + 1; \n");
    localStringBuilder.append("   vec4 sampleTex;\n");
    localStringBuilder.append("   vec3 col = vec3(0.0, 0.0, 0.0);  \n");
    localStringBuilder.append("   float weightSum = 0.0; \n");
    localStringBuilder.append("   for(int i = 0; i < diameter; i++) {\n");
    localStringBuilder.append("       vec2 offset = vec2(float(i - uRadius) * uWidthOffset, float(i - uRadius) * uHeightOffset);  \n");
    localStringBuilder.append("       sampleTex = vec4(texture2D(uTexture, vTextureCoord.st+offset));\n");
    localStringBuilder.append("       float index = float(i); \n");
    localStringBuilder.append("       float boxWeight = float(1.0) / float(diameter); \n");
    localStringBuilder.append("       col += sampleTex.rgb * boxWeight; \n");
    localStringBuilder.append("       weightSum += boxWeight;\n");
    localStringBuilder.append("   }   \n");
    localStringBuilder.append("   gl_FragColor = vec4(col / weightSum, sampleTex.a);   \n");
    return localStringBuilder.toString();
  }
  
  private String getGaussianSampleCode()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("   int diameter = 2 * uRadius + 1;  \n");
    localStringBuilder.append("   vec4 sampleTex;\n");
    localStringBuilder.append("   vec3 col = vec3(0.0, 0.0, 0.0);  \n");
    localStringBuilder.append("   float weightSum = 0.0; \n");
    localStringBuilder.append("   for(int i = 0; i < diameter; i++) {\n");
    localStringBuilder.append("       vec2 offset = vec2(float(i - uRadius) * uWidthOffset, float(i - uRadius) * uHeightOffset);  \n");
    localStringBuilder.append("       sampleTex = vec4(texture2D(uTexture, vTextureCoord.st+offset));\n");
    localStringBuilder.append("       float index = float(i); \n");
    localStringBuilder.append("       float gaussWeight = getGaussWeight(index - float(diameter - 1)/2.0,");
    localStringBuilder.append("           (float(diameter - 1)/2.0 + 1.0) / 2.0); \n");
    localStringBuilder.append("       col += sampleTex.rgb * gaussWeight; \n");
    localStringBuilder.append("       weightSum += gaussWeight;\n");
    localStringBuilder.append("   }   \n");
    localStringBuilder.append("   gl_FragColor = vec4(col / weightSum, sampleTex.a);   \n");
    return localStringBuilder.toString();
  }
  
  private String getStackSampleCode()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("int diameter = 2 * uRadius + 1;  \n");
    localStringBuilder.append("   vec4 sampleTex;\n");
    localStringBuilder.append("   vec3 col = vec3(0.0, 0.0, 0.0);  \n");
    localStringBuilder.append("   float weightSum = 0.0; \n");
    localStringBuilder.append("   for(int i = 0; i < diameter; i++) {\n");
    localStringBuilder.append("       vec2 offset = vec2(float(i - uRadius) * uWidthOffset, float(i - uRadius) * uHeightOffset);  \n");
    localStringBuilder.append("       sampleTex = vec4(texture2D(uTexture, vTextureCoord.st+offset));\n");
    localStringBuilder.append("       float index = float(i); \n");
    localStringBuilder.append("       float boxWeight = float(uRadius) + 1.0 - abs(index - float(uRadius)); \n");
    localStringBuilder.append("       col += sampleTex.rgb * boxWeight; \n");
    localStringBuilder.append("       weightSum += boxWeight;\n");
    localStringBuilder.append("   }   \n");
    localStringBuilder.append("   gl_FragColor = vec4(col / weightSum, sampleTex.a);   \n");
    return localStringBuilder.toString();
  }
  
  protected void beforeDraw(TAVTextureInfo paramTAVTextureInfo)
  {
    GLES20.glUniform1i(this.radiusHandle, this.radius);
    int i = this.widthOffsetHandle;
    boolean bool = this.horizontal;
    float f2 = 0.0F;
    if (bool) {
      f1 = 0.0F;
    } else {
      f1 = 1.0F / paramTAVTextureInfo.width;
    }
    GLES20.glUniform1f(i, f1);
    i = this.heightOffsetHandle;
    float f1 = f2;
    if (this.horizontal) {
      f1 = 1.0F / paramTAVTextureInfo.height;
    }
    GLES20.glUniform1f(i, f1);
  }
  
  protected String getFragmentShaderCode(TAVTextureInfo paramTAVTextureInfo)
  {
    if (paramTAVTextureInfo.textureType == 36197)
    {
      paramTAVTextureInfo = new StringBuilder();
      paramTAVTextureInfo.append(" #extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES ");
      paramTAVTextureInfo.append(this.FRAGMENT_SHADER);
      return paramTAVTextureInfo.toString();
    }
    paramTAVTextureInfo = new StringBuilder();
    paramTAVTextureInfo.append("uniform sampler2D ");
    paramTAVTextureInfo.append(this.FRAGMENT_SHADER);
    return paramTAVTextureInfo.toString();
  }
  
  protected void initShader(TAVTextureInfo paramTAVTextureInfo)
  {
    super.initShader(paramTAVTextureInfo);
    this.radiusHandle = GLES20.glGetUniformLocation(this.program, "uRadius");
    TAVGLUtils.checkEglError("glGetUniformLocation uRadius");
    this.widthOffsetHandle = GLES20.glGetUniformLocation(this.program, "uWidthOffset");
    TAVGLUtils.checkEglError("glGetUniformLocation uWidthOffset");
    this.heightOffsetHandle = GLES20.glGetUniformLocation(this.program, "uHeightOffset");
    TAVGLUtils.checkEglError("glGetUniformLocation uHeightOffset");
  }
  
  public void scale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (this.xyMatrix == null) {
      this.xyMatrix = new Matrix();
    }
    this.xyMatrix.reset();
    this.xyMatrix.setScale(paramFloat1, paramFloat1);
    this.xyMatrix.postTranslate(paramFloat2, paramFloat3);
  }
  
  public void setRadius(int paramInt)
  {
    this.radius = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.filter.GaosiBlurFilter
 * JD-Core Version:    0.7.0.1
 */