package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.FloatsParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureResParam;

public class GaoLengFilter
  extends BaseFilter
{
  public GaoLengFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    BaseFilter localBaseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(54));
    localBaseFilter2.addParam(new TextureResParam("inputImageTexture2", "sh/gaoleng_curve.png", 33986));
    setNextFilter(localBaseFilter2, null);
    BaseFilter localBaseFilter1 = new BaseFilter(BaseFilter.getFragmentShader(57));
    localBaseFilter1.addParam(new UniformParam.FloatsParam("shadowsShift", new float[] { -0.2235294F, 0.03921569F, 0.08627451F }));
    localBaseFilter1.addParam(new UniformParam.FloatsParam("midtonesShift", new float[] { -0.1490196F, 0.0F, 0.08627451F }));
    localBaseFilter1.addParam(new UniformParam.FloatsParam("highlightsShift", new float[] { -0.01960784F, 0.01960784F, 0.0588235F }));
    localBaseFilter1.addParam(new UniformParam.IntParam("preserveLuminosity", 1));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    localBaseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(116));
    localBaseFilter2.addParam(new UniformParam.FloatsParam("color2", new float[] { 0.0666667F, 0.6F, 0.8745098F, 1.0F }));
    localBaseFilter2.addParam(new UniformParam.FloatParam("transparency", 0.7F));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    localBaseFilter1 = new BaseFilter(BaseFilter.getFragmentShader(55));
    localBaseFilter1.addParam(new UniformParam.FloatParam("scaleC", -0.07500002F));
    localBaseFilter1.addParam(new UniformParam.FloatParam("scaleT", 0.0F));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    localBaseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(13));
    localBaseFilter2.addParam(new UniformParam.FloatParam("contrast", 1.13F));
    localBaseFilter2.addParam(new UniformParam.FloatParam("saturation", 1.0F));
    localBaseFilter2.addParam(new UniformParam.FloatParam("brightness", 1.0F));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    localBaseFilter1 = new BaseFilter(BaseFilter.getFragmentShader(108));
    localBaseFilter1.addParam(new UniformParam.FloatParam("inputH", 1.0F));
    localBaseFilter1.addParam(new UniformParam.FloatParam("inputS", 1.0F));
    localBaseFilter1.addParam(new UniformParam.FloatParam("inputV", 0.98F));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.filter.ttpic.GaoLengFilter
 * JD-Core Version:    0.7.0.1
 */