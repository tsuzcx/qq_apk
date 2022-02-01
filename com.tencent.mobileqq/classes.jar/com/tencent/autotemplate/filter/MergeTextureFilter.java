package com.tencent.autotemplate.filter;

import android.opengl.GLES20;
import com.tencent.taveffect.core.TAVTextureInfo;
import com.tencent.taveffect.effects.BaseEffect;
import com.tencent.taveffect.utils.TAVGLUtils;

public class MergeTextureFilter
  extends BaseEffect
{
  private static final String FRAGMENT_SHADER_CODE = "sTexture;\nuniform sampler2D blurTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform float blurOffsetX;  // x轴边框模糊偏移值\nuniform float blurOffsetY;  // y轴边框模糊偏移值\nuniform float blurOffsetXEnd;  // x轴边框模糊偏移值\nuniform float blurOffsetYEnd;  // y轴边框模糊偏移值\nvoid main() {\n   if (vTextureCoord.x >= blurOffsetX && vTextureCoord.x <= blurOffsetXEnd && vTextureCoord.y >= blurOffsetY && vTextureCoord.y <= blurOffsetYEnd) {\n       gl_FragColor = texture2D(sTexture, vTextureCoord);\n   } else {\n       gl_FragColor = texture2D(blurTexture, vTextureCoord);\n   }\n}";
  public static final float MERGE_FOR_ERROR = 0.01F;
  private int blurOffsetXEndHandle;
  private int blurOffsetXHandle;
  private int blurOffsetYEndHandle;
  private int blurOffsetYHandle;
  private int blurTextureHandle;
  private TAVTextureInfo blurTextureInfo;
  private float offsetX;
  private float offsetY;
  
  public void beforeDraw(TAVTextureInfo paramTAVTextureInfo)
  {
    if (this.offsetX == 0.0F)
    {
      GLES20.glUniform1f(this.blurOffsetXHandle, 0.0F);
      GLES20.glUniform1f(this.blurOffsetXEndHandle, 1.0F);
      if (this.offsetY != 0.0F) {
        break label110;
      }
      GLES20.glUniform1f(this.blurOffsetYHandle, 0.0F);
      GLES20.glUniform1f(this.blurOffsetYEndHandle, 1.0F);
    }
    for (;;)
    {
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(3553, this.blurTextureInfo.textureID);
      GLES20.glUniform1i(this.blurTextureHandle, 1);
      return;
      GLES20.glUniform1f(this.blurOffsetXHandle, this.offsetX + 0.01F);
      GLES20.glUniform1f(this.blurOffsetXEndHandle, 1.0F - this.offsetX - 0.01F);
      break;
      label110:
      GLES20.glUniform1f(this.blurOffsetYHandle, this.offsetY + 0.01F);
      GLES20.glUniform1f(this.blurOffsetYEndHandle, 1.0F - this.offsetY - 0.01F);
    }
  }
  
  public String getFragmentShaderCode(TAVTextureInfo paramTAVTextureInfo)
  {
    if (paramTAVTextureInfo.textureType == 36197) {
      return " #extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES sTexture;\nuniform sampler2D blurTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform float blurOffsetX;  // x轴边框模糊偏移值\nuniform float blurOffsetY;  // y轴边框模糊偏移值\nuniform float blurOffsetXEnd;  // x轴边框模糊偏移值\nuniform float blurOffsetYEnd;  // y轴边框模糊偏移值\nvoid main() {\n   if (vTextureCoord.x >= blurOffsetX && vTextureCoord.x <= blurOffsetXEnd && vTextureCoord.y >= blurOffsetY && vTextureCoord.y <= blurOffsetYEnd) {\n       gl_FragColor = texture2D(sTexture, vTextureCoord);\n   } else {\n       gl_FragColor = texture2D(blurTexture, vTextureCoord);\n   }\n}";
    }
    return "uniform sampler2D sTexture;\nuniform sampler2D blurTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform float blurOffsetX;  // x轴边框模糊偏移值\nuniform float blurOffsetY;  // y轴边框模糊偏移值\nuniform float blurOffsetXEnd;  // x轴边框模糊偏移值\nuniform float blurOffsetYEnd;  // y轴边框模糊偏移值\nvoid main() {\n   if (vTextureCoord.x >= blurOffsetX && vTextureCoord.x <= blurOffsetXEnd && vTextureCoord.y >= blurOffsetY && vTextureCoord.y <= blurOffsetYEnd) {\n       gl_FragColor = texture2D(sTexture, vTextureCoord);\n   } else {\n       gl_FragColor = texture2D(blurTexture, vTextureCoord);\n   }\n}";
  }
  
  public void initShader(TAVTextureInfo paramTAVTextureInfo)
  {
    super.initShader(paramTAVTextureInfo);
    this.blurOffsetXHandle = GLES20.glGetUniformLocation(this.program, "blurOffsetX");
    TAVGLUtils.checkEglError("glGetUniformLocation blurOffsetX");
    this.blurOffsetYHandle = GLES20.glGetUniformLocation(this.program, "blurOffsetY");
    TAVGLUtils.checkEglError("glGetUniformLocation blurOffsetY");
    this.blurOffsetXEndHandle = GLES20.glGetUniformLocation(this.program, "blurOffsetXEnd");
    TAVGLUtils.checkEglError("glGetUniformLocation blurOffsetX");
    this.blurOffsetYEndHandle = GLES20.glGetUniformLocation(this.program, "blurOffsetYEnd");
    TAVGLUtils.checkEglError("glGetUniformLocation blurOffsetY");
    this.blurTextureHandle = GLES20.glGetUniformLocation(this.program, "blurTexture");
    TAVGLUtils.checkEglError("glGetUniformLocation blurTexture");
  }
  
  public TAVTextureInfo mergeTexture(TAVTextureInfo paramTAVTextureInfo1, TAVTextureInfo paramTAVTextureInfo2)
  {
    this.blurTextureInfo = paramTAVTextureInfo1;
    return super.applyNewTexture(paramTAVTextureInfo2);
  }
  
  public void setOffsetX(float paramFloat)
  {
    this.offsetX = paramFloat;
  }
  
  public void setOffsetY(float paramFloat)
  {
    this.offsetY = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.autotemplate.filter.MergeTextureFilter
 * JD-Core Version:    0.7.0.1
 */