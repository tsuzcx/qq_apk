package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam.FloatsParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureResParam;

public class JiaoPianFilter
  extends BaseFilter
{
  public JiaoPianFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    BaseFilter localBaseFilter1 = new BaseFilter(BaseFilter.getFragmentShader(57));
    localBaseFilter1.addParam(new UniformParam.FloatsParam("shadowsShift", new float[] { -0.0588235F, 0.03529412F, -0.02352941F }));
    localBaseFilter1.addParam(new UniformParam.FloatsParam("midtonesShift", new float[] { 0.0F, 0.0F, 0.0F }));
    localBaseFilter1.addParam(new UniformParam.FloatsParam("highlightsShift", new float[] { 0.07450981F, 0.0F, -0.01568628F }));
    localBaseFilter1.addParam(new UniformParam.IntParam("preserveLuminosity", 1));
    setNextFilter(localBaseFilter1, null);
    BaseFilter localBaseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(106));
    localBaseFilter2.addParam(new TextureResParam("inputImageTexture2", "sh/jiaopian.png", 33986));
    localBaseFilter2.addParam(new UniformParam.FloatsParam("channelvec", new float[] { 0.0F, 1.0F, 0.0F }));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.filter.ttpic.JiaoPianFilter
 * JD-Core Version:    0.7.0.1
 */