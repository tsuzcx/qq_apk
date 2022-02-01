package com.tencent.autotemplate.filter;

import android.graphics.Matrix;
import android.opengl.GLES20;
import com.tencent.taveffect.core.TAVRectangle;
import com.tencent.taveffect.core.TAVTextureInfo;
import com.tencent.taveffect.effects.BaseEffect;
import com.tencent.taveffect.utils.TAVGLUtils;

@Deprecated
public class ScaleFilter
  extends BaseEffect
{
  private static final String FRAGMENT_SHADER_CODE = "sTexture;\nuniform sampler2D blurTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform float blurOffsetX;  // x轴边框模糊偏移值\nuniform float blurOffsetY;  // y轴边框模糊偏移值\nvoid main() {\n   vec2 uv = vTextureCoord.xy;\n   vec4 color;\n   // 中间为原图，需要缩小\n   if (uv.x >= blurOffsetX && uv.x <= 1.0 - blurOffsetX && uv.y >= blurOffsetY && uv.y <= 1.0 - blurOffsetY) {\n       // 内部UV缩放值\n       float scaleX = 1.0 / (1.0 - 2.0 * blurOffsetX);\n       float scaleY = 1.0 / (1.0 - 2.0 * blurOffsetY);\n       // 计算出内部新的UV坐标\n       vec2 newUV = vec2((uv.x - blurOffsetX) * scaleX, (uv.y - blurOffsetY) * scaleY);\n       color = texture2D(sTexture, newUV);\n   } else {\n       color = texture2D(blurTexture, uv);\n   }\n   gl_FragColor = color;\n}";
  private int blurOffsetXHandle;
  private int blurOffsetYHandle;
  private int blurTextureHandle;
  private TAVTextureInfo blurTextureInfo;
  private float offsetX;
  private float offsetY;
  
  public TAVTextureInfo applyNewTexture(TAVTextureInfo paramTAVTextureInfo1, TAVTextureInfo paramTAVTextureInfo2)
  {
    this.blurTextureInfo = paramTAVTextureInfo1;
    return super.applyNewTexture(paramTAVTextureInfo2);
  }
  
  public void beforeDraw(TAVTextureInfo paramTAVTextureInfo)
  {
    GLES20.glUniform1f(this.blurOffsetXHandle, this.offsetX);
    GLES20.glUniform1f(this.blurOffsetYHandle, this.offsetY);
    GLES20.glActiveTexture(33985);
    GLES20.glBindTexture(3553, this.blurTextureInfo.textureID);
    GLES20.glUniform1i(this.blurTextureHandle, 1);
  }
  
  public String getFragmentShaderCode(TAVTextureInfo paramTAVTextureInfo)
  {
    if (paramTAVTextureInfo.textureType == 36197) {
      return " #extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES sTexture;\nuniform sampler2D blurTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform float blurOffsetX;  // x轴边框模糊偏移值\nuniform float blurOffsetY;  // y轴边框模糊偏移值\nvoid main() {\n   vec2 uv = vTextureCoord.xy;\n   vec4 color;\n   // 中间为原图，需要缩小\n   if (uv.x >= blurOffsetX && uv.x <= 1.0 - blurOffsetX && uv.y >= blurOffsetY && uv.y <= 1.0 - blurOffsetY) {\n       // 内部UV缩放值\n       float scaleX = 1.0 / (1.0 - 2.0 * blurOffsetX);\n       float scaleY = 1.0 / (1.0 - 2.0 * blurOffsetY);\n       // 计算出内部新的UV坐标\n       vec2 newUV = vec2((uv.x - blurOffsetX) * scaleX, (uv.y - blurOffsetY) * scaleY);\n       color = texture2D(sTexture, newUV);\n   } else {\n       color = texture2D(blurTexture, uv);\n   }\n   gl_FragColor = color;\n}";
    }
    return "uniform sampler2D sTexture;\nuniform sampler2D blurTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform float blurOffsetX;  // x轴边框模糊偏移值\nuniform float blurOffsetY;  // y轴边框模糊偏移值\nvoid main() {\n   vec2 uv = vTextureCoord.xy;\n   vec4 color;\n   // 中间为原图，需要缩小\n   if (uv.x >= blurOffsetX && uv.x <= 1.0 - blurOffsetX && uv.y >= blurOffsetY && uv.y <= 1.0 - blurOffsetY) {\n       // 内部UV缩放值\n       float scaleX = 1.0 / (1.0 - 2.0 * blurOffsetX);\n       float scaleY = 1.0 / (1.0 - 2.0 * blurOffsetY);\n       // 计算出内部新的UV坐标\n       vec2 newUV = vec2((uv.x - blurOffsetX) * scaleX, (uv.y - blurOffsetY) * scaleY);\n       color = texture2D(sTexture, newUV);\n   } else {\n       color = texture2D(blurTexture, uv);\n   }\n   gl_FragColor = color;\n}";
  }
  
  public TAVTextureInfo getOutputTextureInfo(TAVTextureInfo paramTAVTextureInfo)
  {
    if (this.outputTextureInfo == null) {
      this.outputTextureInfo = new TAVTextureInfo();
    }
    this.outputTextureInfo.setFrameTimeUs(paramTAVTextureInfo.frameTimeUs);
    this.outputTextureInfo.setWidth(this.rendererWidth);
    this.outputTextureInfo.setHeight(this.rendererHeight);
    this.outputTextureInfo.setPreRotation(paramTAVTextureInfo.getPreRotation());
    this.outputTextureInfo.setTextureType(3553);
    this.outputTextureInfo.setTextureID(this.textureID[0]);
    return this.outputTextureInfo;
  }
  
  public void initShader(TAVTextureInfo paramTAVTextureInfo)
  {
    super.initShader(paramTAVTextureInfo);
    this.blurOffsetXHandle = GLES20.glGetUniformLocation(this.program, "blurOffsetX");
    TAVGLUtils.checkEglError("glGetUniformLocation blurOffsetX");
    this.blurOffsetYHandle = GLES20.glGetUniformLocation(this.program, "blurOffsetY");
    TAVGLUtils.checkEglError("glGetUniformLocation blurOffsetY");
    this.blurTextureHandle = GLES20.glGetUniformLocation(this.program, "blurTexture");
    TAVGLUtils.checkEglError("glGetUniformLocation blurTexture");
  }
  
  public void setBlurTextureInfo(TAVTextureInfo paramTAVTextureInfo)
  {
    this.blurTextureInfo = paramTAVTextureInfo;
  }
  
  public void setOffsetX(float paramFloat)
  {
    this.offsetX = paramFloat;
  }
  
  public void setOffsetY(float paramFloat)
  {
    this.offsetY = paramFloat;
  }
  
  public void setParams(Matrix paramMatrix1, Matrix paramMatrix2, TAVRectangle paramTAVRectangle, float paramFloat)
  {
    this.cropRect = paramTAVRectangle;
    this.alpha = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.filter.ScaleFilter
 * JD-Core Version:    0.7.0.1
 */