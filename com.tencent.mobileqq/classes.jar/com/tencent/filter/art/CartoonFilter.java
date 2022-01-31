package com.tencent.filter.art;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.filter.BaseFilter;

public class CartoonFilter
  extends BaseFilter
{
  private int type;
  
  public CartoonFilter(int paramInt)
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    this.type = paramInt;
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    ClearGLSL();
    if (paramBoolean)
    {
      this.glslProgramShader = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n";
      setNextFilter(null, null);
    }
    for (;;)
    {
      super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
      return;
      this.glslProgramShader = BaseFilter.getFragmentShader(78);
      BaseFilter localBaseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(77));
      setNextFilter(localBaseFilter2, null);
      BaseFilter localBaseFilter1 = new BaseFilter(BaseFilter.getFragmentShader(79));
      localBaseFilter2.setNextFilter(localBaseFilter1, null);
      localBaseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(72));
      localBaseFilter2.addParam(new UniformParam.FloatParam("threshold", 0.0F));
      localBaseFilter1.setNextFilter(localBaseFilter2, null);
      localBaseFilter1 = new BaseFilter(BaseFilter.getFragmentShader(82));
      localBaseFilter2.setNextFilter(localBaseFilter1, null);
      localBaseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(73));
      localBaseFilter2.addParam(new UniformParam.FloatParam("inv_2sigma2", 127.00195F));
      localBaseFilter2.addParam(new UniformParam.FloatParam("inv_sigma_root_2pi", 0.0008F));
      localBaseFilter1.setNextFilter(localBaseFilter2, new int[] { 2 });
      localBaseFilter1 = new BaseFilter(BaseFilter.getFragmentShader(76));
      localBaseFilter1.addParam(new UniformParam.FloatParam("par", 0.15F));
      localBaseFilter2.setNextFilter(localBaseFilter1, new int[] { 4 });
      localBaseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(75));
      localBaseFilter2.addParam(new UniformParam.FloatParam("par", 0.35F));
      localBaseFilter2.addParam(new UniformParam.FloatParam("par_b", 0.2F));
      localBaseFilter1.setNextFilter(localBaseFilter2, new int[] { 4, 5 });
      localBaseFilter1 = new BaseFilter(BaseFilter.getFragmentShader(74));
      localBaseFilter1.addParam(new UniformParam.FloatParam("inv_2sigma", 12.0F));
      localBaseFilter2.setNextFilter(localBaseFilter1, new int[] { 4 });
      if (this.type == 1)
      {
        localBaseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(71));
        localBaseFilter2.addParam(new UniformParam.FloatParam("inv_2sigma2", 144.5F));
        localBaseFilter2.addParam(new UniformParam.FloatParam("inv_sigma_root_2pi", 0.02F));
        localBaseFilter1.setNextFilter(localBaseFilter2, new int[] { 5, 4 });
        localBaseFilter1 = new BaseFilter(BaseFilter.getFragmentShader(70));
        localBaseFilter1.addParam(new UniformParam.FloatParam("inv_2sigma2", 144.5F));
        localBaseFilter1.addParam(new UniformParam.FloatParam("inv_sigma_root_2pi", 0.02F));
        localBaseFilter2.setNextFilter(localBaseFilter1, new int[] { 4 });
        localBaseFilter1.setNextFilter(new BaseFilter(BaseFilter.getFragmentShader(80)), new int[] { 8 });
      }
      else if (this.type == 2)
      {
        localBaseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(71));
        localBaseFilter2.addParam(new UniformParam.FloatParam("inv_2sigma2", 144.5F));
        localBaseFilter2.addParam(new UniformParam.FloatParam("inv_sigma_root_2pi", 0.02F));
        localBaseFilter1.setNextFilter(localBaseFilter2, new int[] { 5, 4 });
        localBaseFilter1 = new BaseFilter(BaseFilter.getFragmentShader(70));
        localBaseFilter1.addParam(new UniformParam.FloatParam("inv_2sigma2", 144.5F));
        localBaseFilter1.addParam(new UniformParam.FloatParam("inv_sigma_root_2pi", 0.02F));
        localBaseFilter2.setNextFilter(localBaseFilter1, new int[] { 4 });
        localBaseFilter1.setNextFilter(new BaseFilter(BaseFilter.getFragmentShader(81)), new int[] { 8 });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.filter.art.CartoonFilter
 * JD-Core Version:    0.7.0.1
 */