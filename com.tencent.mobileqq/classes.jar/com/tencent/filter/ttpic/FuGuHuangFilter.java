package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.FloatsParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureResParam;

public class FuGuHuangFilter
  extends BaseFilter
{
  public FuGuHuangFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    BaseFilter localBaseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(56));
    localBaseFilter2.addParam(new UniformParam.FloatsParam("color2", new float[] { 0.1529412F, 0.09411765F, 0.09803922F, 1.0F }));
    localBaseFilter2.addParam(new UniformParam.FloatParam("transparency", 1.0F));
    setNextFilter(localBaseFilter2, null);
    BaseFilter localBaseFilter1 = new BaseFilter(BaseFilter.getFragmentShader(54));
    localBaseFilter1.addParam(new TextureResParam("inputImageTexture2", "sh/fuguhuang.png", 33986));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    localBaseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(57));
    localBaseFilter2.addParam(new UniformParam.FloatsParam("shadowsShift", new float[] { 0.0F, 0.0F, 0.0F }));
    localBaseFilter2.addParam(new UniformParam.FloatsParam("midtonesShift", new float[] { 0.0F, 0.0F, 0.0F }));
    localBaseFilter2.addParam(new UniformParam.FloatsParam("highlightsShift", new float[] { 0.0F, 0.0F, -0.12549F }));
    localBaseFilter2.addParam(new UniformParam.IntParam("preserveLuminosity", 1));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    localBaseFilter1 = new BaseFilter(BaseFilter.getFragmentShader(60));
    localBaseFilter1.addParam(new UniformParam.FloatParam("inputH", 1.0F));
    localBaseFilter1.addParam(new UniformParam.FloatParam("inputS", 1.0F));
    localBaseFilter1.addParam(new UniformParam.FloatParam("inputV", 0.974F));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    localBaseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(63));
    localBaseFilter2.addParam(new UniformParam.FloatsParam("color2", new float[] { 0.9490196F, 0.9098039F, 0.8039216F, 1.0F }));
    localBaseFilter2.addParam(new UniformParam.FloatParam("transparency", 0.5F));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.filter.ttpic.FuGuHuangFilter
 * JD-Core Version:    0.7.0.1
 */