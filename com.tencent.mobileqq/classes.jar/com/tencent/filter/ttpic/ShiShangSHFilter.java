package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureResParam;

public class ShiShangSHFilter
  extends BaseFilter
{
  private int effectindex = 0;
  
  public ShiShangSHFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public ShiShangSHFilter(int paramInt)
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    this.effectindex = paramInt;
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.glslProgramShader = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n";
    BaseFilter localBaseFilter1;
    BaseFilter localBaseFilter2;
    if (this.effectindex == 0)
    {
      localBaseFilter1 = new BaseFilter(BaseFilter.getFragmentShader(54));
      localBaseFilter1.addParam(new TextureResParam("inputImageTexture2", "sh/shishang_sh_curve.png", 33986));
      setNextFilter(localBaseFilter1, null);
      localBaseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(61));
      localBaseFilter2.addParam(new TextureResParam("inputImageTexture2", "sh/shishang_sh_blend.jpg", 33986));
      localBaseFilter1.setNextFilter(localBaseFilter2, null);
    }
    for (;;)
    {
      super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
      return;
      localBaseFilter1 = new BaseFilter(BaseFilter.getFragmentShader(62));
      localBaseFilter1.addParam(new TextureResParam("inputImageTexture2", "sh/fugu_sh_blend.jpg", 33986));
      setNextFilter(localBaseFilter1, null);
      localBaseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(3));
      localBaseFilter2.addParam(new UniformParam.FloatParam("filterAdjustParam", 0.3F));
      localBaseFilter1.setNextFilter(localBaseFilter2, new int[] { this.srcTextureIndex });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.filter.ttpic.ShiShangSHFilter
 * JD-Core Version:    0.7.0.1
 */