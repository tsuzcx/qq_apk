package com.tencent.filter;

import com.tencent.aekit.openrender.UniformParam.FloatsParam;
import com.tencent.aekit.openrender.internal.Frame;
import java.util.Map;

public class MotionBlurFilter
  extends BaseFilter
{
  private static String FRAGMENT_SHADER = "precision highp float;\n \n uniform sampler2D inputImageTexture;\n \n varying vec2 textureCoordinate;\n varying vec2 oneStepBackTextureCoordinate;\n varying vec2 twoStepsBackTextureCoordinate;\n varying vec2 threeStepsBackTextureCoordinate;\n varying vec2 fourStepsBackTextureCoordinate;\n varying vec2 oneStepForwardTextureCoordinate;\n varying vec2 twoStepsForwardTextureCoordinate;\n varying vec2 threeStepsForwardTextureCoordinate;\n varying vec2 fourStepsForwardTextureCoordinate;\n \n void main()\n {\n     lowp vec4 fragmentColor = texture2D(inputImageTexture, textureCoordinate) * 0.18;\n     fragmentColor += texture2D(inputImageTexture, oneStepBackTextureCoordinate) * 0.15;\n     fragmentColor += texture2D(inputImageTexture, twoStepsBackTextureCoordinate) *  0.12;\n     fragmentColor += texture2D(inputImageTexture, threeStepsBackTextureCoordinate) * 0.09;\n     fragmentColor += texture2D(inputImageTexture, fourStepsBackTextureCoordinate) * 0.05;\n     fragmentColor += texture2D(inputImageTexture, oneStepForwardTextureCoordinate) * 0.15;\n     fragmentColor += texture2D(inputImageTexture, twoStepsForwardTextureCoordinate) *  0.12;\n     fragmentColor += texture2D(inputImageTexture, threeStepsForwardTextureCoordinate) * 0.09;\n     fragmentColor += texture2D(inputImageTexture, fourStepsForwardTextureCoordinate) * 0.05;\n\n     gl_FragColor = fragmentColor;\n }";
  private static String VERTEXT_SHADER = "attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n \n uniform vec2 directionalTexelStep;\n \n varying vec2 textureCoordinate;\n varying vec2 oneStepBackTextureCoordinate;\n varying vec2 twoStepsBackTextureCoordinate;\n varying vec2 threeStepsBackTextureCoordinate;\n varying vec2 fourStepsBackTextureCoordinate;\n varying vec2 oneStepForwardTextureCoordinate;\n varying vec2 twoStepsForwardTextureCoordinate;\n varying vec2 threeStepsForwardTextureCoordinate;\n varying vec2 fourStepsForwardTextureCoordinate;\n \n void main()\n {\n     gl_Position = position;\n     \n     textureCoordinate = inputTextureCoordinate.xy;\n     oneStepBackTextureCoordinate = inputTextureCoordinate.xy - directionalTexelStep;\n     twoStepsBackTextureCoordinate = inputTextureCoordinate.xy - 2.0 * directionalTexelStep;\n     threeStepsBackTextureCoordinate = inputTextureCoordinate.xy - 3.0 * directionalTexelStep;\n     fourStepsBackTextureCoordinate = inputTextureCoordinate.xy - 4.0 * directionalTexelStep;\n     oneStepForwardTextureCoordinate = inputTextureCoordinate.xy + directionalTexelStep;\n     twoStepsForwardTextureCoordinate = inputTextureCoordinate.xy + 2.0 * directionalTexelStep;\n     threeStepsForwardTextureCoordinate = inputTextureCoordinate.xy + 3.0 * directionalTexelStep;\n     fourStepsForwardTextureCoordinate = inputTextureCoordinate.xy + 4.0 * directionalTexelStep;\n }";
  private BaseFilter filter1 = new BaseFilter(VERTEXT_SHADER, FRAGMENT_SHADER);
  private float mBlurAngle = 0.0F;
  private float mBlurSize = 0.0F;
  private float mHeight;
  private float mWidth;
  private Frame newFrame = new Frame();
  
  public MotionBlurFilter()
  {
    super(VERTEXT_SHADER, FRAGMENT_SHADER);
  }
  
  private void recalculateTexelOffsets()
  {
    float[] arrayOfFloat = new float[2];
    float f = this.mHeight / this.mWidth;
    if (this.mBlurSize <= 2.0F)
    {
      arrayOfFloat[0] = ((float)(this.mBlurSize * Math.cos(this.mBlurAngle * 3.141592653589793D / 180.0D) * f / this.mWidth));
      arrayOfFloat[1] = ((float)(this.mBlurSize * Math.sin(this.mBlurAngle * 3.141592653589793D / 180.0D) / this.mWidth));
      addParam(new UniformParam.FloatsParam("directionalTexelStep", arrayOfFloat));
      arrayOfFloat[0] = 0.0F;
      arrayOfFloat[1] = 0.0F;
      this.filter1.addParam(new UniformParam.FloatsParam("directionalTexelStep", arrayOfFloat));
      return;
    }
    arrayOfFloat[0] = ((float)(2.0D * Math.cos(this.mBlurAngle * 3.141592653589793D / 180.0D) * f / this.mWidth));
    arrayOfFloat[1] = ((float)(2.0D * Math.sin(this.mBlurAngle * 3.141592653589793D / 180.0D) / this.mWidth));
    addParam(new UniformParam.FloatsParam("directionalTexelStep", arrayOfFloat));
    arrayOfFloat[0] = ((float)((this.mBlurSize - 2.0F) * Math.cos(this.mBlurAngle * 3.141592653589793D / 180.0D) * f / this.mWidth));
    arrayOfFloat[1] = ((float)((this.mBlurSize - 2.0F) * Math.sin(this.mBlurAngle * 3.141592653589793D / 180.0D) / this.mWidth));
    this.filter1.addParam(new UniformParam.FloatsParam("directionalTexelStep", arrayOfFloat));
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.mWidth = paramFloat1;
    this.mHeight = paramFloat2;
    setNextFilter(this.filter1, null);
    recalculateTexelOffsets();
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void beforeRender(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 != this.mWidth) || (paramInt3 != this.mHeight))
    {
      this.mWidth = paramInt2;
      this.mHeight = paramInt3;
      recalculateTexelOffsets();
    }
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
    if (this.newFrame != null) {
      this.newFrame.clear();
    }
  }
  
  public Frame render(Frame paramFrame)
  {
    RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.newFrame);
    return this.newFrame;
  }
  
  public void setParameterDic(Map<String, Object> paramMap)
  {
    if (paramMap.containsKey("blurSize")) {
      this.mBlurSize = ((Float)paramMap.get("blurSize")).floatValue();
    }
    if (paramMap.containsKey("blurAngle")) {
      this.mBlurAngle = ((Float)paramMap.get("blurAngle")).floatValue();
    }
    if (getProgramIds() > 0) {
      recalculateTexelOffsets();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.filter.MotionBlurFilter
 * JD-Core Version:    0.7.0.1
 */