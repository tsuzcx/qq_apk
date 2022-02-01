package com.tencent.filter.art;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.filter.BaseFilter;

public class NightRGBStretchFilter
  extends BaseFilter
{
  private BaseFilter adjustFilter = null;
  private float strenth = 0.5F;
  
  public NightRGBStretchFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.glslProgramShader = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n";
    BaseFilter localBaseFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    localBaseFilter.scaleFact = Math.min(100.0F / Math.min(paramFloat2, paramFloat1), 1.0F);
    setNextFilter(localBaseFilter, null);
    this.adjustFilter = new NightRGBStretchFilter.NightRGBStretchImpFilter();
    this.adjustFilter.addParam(new UniformParam.FloatParam("param", this.strenth));
    if (this.strenth >= 0.5F) {
      this.adjustFilter.addParam(new UniformParam.FloatParam("scale", 2.0F));
    }
    for (;;)
    {
      localBaseFilter.setNextFilter(this.adjustFilter, new int[] { this.srcTextureIndex + 1 });
      super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
      return;
      this.adjustFilter.addParam(new UniformParam.FloatParam("scale", 1.0F));
    }
  }
  
  public void clearGLSL()
  {
    this.adjustFilter = null;
    super.clearGLSL();
  }
  
  public boolean isAdjustFilter()
  {
    return true;
  }
  
  public void setAdjustParam(float paramFloat)
  {
    this.strenth = paramFloat;
    if (this.adjustFilter != null) {
      this.adjustFilter.addParam(new UniformParam.FloatParam("param", this.strenth));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.filter.art.NightRGBStretchFilter
 * JD-Core Version:    0.7.0.1
 */