package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.FloatsParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureResParam;

public class GaoGuangLanZiFilter
  extends BaseFilter
{
  public GaoGuangLanZiFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    BaseFilter localBaseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(54));
    localBaseFilter2.addParam(new TextureResParam("inputImageTexture2", "sh/gaoguanglanzi.png", 33986));
    setNextFilter(localBaseFilter2, null);
    BaseFilter localBaseFilter1 = new BaseFilter(BaseFilter.getFragmentShader(57));
    localBaseFilter1.addParam(new UniformParam.FloatsParam("shadowsShift", new float[] { -0.05294118F, 0.0F, 0.06784314F }));
    localBaseFilter1.addParam(new UniformParam.FloatsParam("midtonesShift", new float[] { -0.05294118F, 0.0F, 0.06784314F }));
    localBaseFilter1.addParam(new UniformParam.FloatsParam("highlightsShift", new float[] { -0.1252941F, 0.0F, 0.1356863F }));
    localBaseFilter1.addParam(new UniformParam.IntParam("preserveLuminosity", 1));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    localBaseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(60));
    localBaseFilter2.addParam(new UniformParam.FloatParam("inputH", 1.0F));
    localBaseFilter2.addParam(new UniformParam.FloatParam("inputS", 1.0F));
    localBaseFilter2.addParam(new UniformParam.FloatParam("inputV", 1.094F));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.filter.ttpic.GaoGuangLanZiFilter
 * JD-Core Version:    0.7.0.1
 */