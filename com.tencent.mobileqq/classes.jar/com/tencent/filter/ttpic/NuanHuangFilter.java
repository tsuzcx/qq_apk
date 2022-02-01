package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.FloatsParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureResParam;

public class NuanHuangFilter
  extends BaseFilter
{
  public NuanHuangFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    BaseFilter localBaseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(57));
    localBaseFilter2.addParam(new UniformParam.FloatsParam("shadowsShift", new float[] { 0.0F, 0.0F, -0.1552941F }));
    localBaseFilter2.addParam(new UniformParam.FloatsParam("midtonesShift", new float[] { 0.03921569F, 0.0F, -0.1764706F }));
    localBaseFilter2.addParam(new UniformParam.FloatsParam("highlightsShift", new float[] { 0.0F, 0.0F, -0.08934902F }));
    localBaseFilter2.addParam(new UniformParam.IntParam("preserveLuminosity", 1));
    setNextFilter(localBaseFilter2, null);
    BaseFilter localBaseFilter1 = new BaseFilter(BaseFilter.getFragmentShader(54));
    localBaseFilter1.addParam(new TextureResParam("inputImageTexture2", "sh/nuanhuang.png", 33986));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    localBaseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(60));
    localBaseFilter2.addParam(new UniformParam.FloatParam("inputH", 1.0F));
    localBaseFilter2.addParam(new UniformParam.FloatParam("inputS", 1.06F));
    localBaseFilter2.addParam(new UniformParam.FloatParam("inputV", 1.04F));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.filter.ttpic.NuanHuangFilter
 * JD-Core Version:    0.7.0.1
 */