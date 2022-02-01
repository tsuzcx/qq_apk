package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.FloatsParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.TextureResParam;

public class OceanFilter
  extends BaseFilter
{
  public OceanFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    BaseFilter localBaseFilter = new BaseFilter(BaseFilter.getFragmentShader(54));
    localBaseFilter.addParam(new TextureResParam("inputImageTexture2", "sh/ocean_curve2.png", 33986));
    setNextFilter(localBaseFilter, null);
    Object localObject = new BaseFilter(BaseFilter.getFragmentShader(54));
    ((BaseFilter)localObject).addParam(new TextureResParam("inputImageTexture2", "sh/ocean_curve3.png", 33986));
    localBaseFilter.setNextFilter((BaseFilter)localObject, null);
    localBaseFilter = new BaseFilter(BaseFilter.getFragmentShader(59));
    localBaseFilter.addParam(new UniformParam.FloatsParam("color2", new float[] { 0.8431373F, 0.8784314F, 0.7843137F, 1.0F }));
    localBaseFilter.addParam(new UniformParam.FloatParam("transparency", 0.35F));
    ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
    localObject = new BaseFilter(BaseFilter.getFragmentShader(116));
    ((BaseFilter)localObject).addParam(new UniformParam.FloatsParam("color2", new float[] { 0.09411765F, 0.1960784F, 0.301961F, 1.0F }));
    ((BaseFilter)localObject).addParam(new UniformParam.FloatParam("transparency", 0.42F));
    localBaseFilter.setNextFilter((BaseFilter)localObject, null);
    localBaseFilter = new BaseFilter(BaseFilter.getFragmentShader(57));
    localBaseFilter.addParam(new UniformParam.FloatsParam("shadowsShift", new float[] { -0.1176471F, 0.0F, 0.1137255F }));
    localBaseFilter.addParam(new UniformParam.FloatsParam("midtonesShift", new float[] { -0.07058824F, 0.0F, 0.03921569F }));
    localBaseFilter.addParam(new UniformParam.FloatsParam("highlightsShift", new float[] { -0.02352941F, 0.0F, 0.01960784F }));
    ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
    localObject = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localObject).setInput(0.0F, 9.0F, 9.0F, 307.0F, 336.0F, 6.0F, 37.0F);
    localBaseFilter.setNextFilter((BaseFilter)localObject, null);
    localBaseFilter = new BaseFilter(BaseFilter.getFragmentShader(13));
    localBaseFilter.addParam(new UniformParam.FloatParam("contrast", 1.1F));
    localBaseFilter.addParam(new UniformParam.FloatParam("saturation", 1.0F));
    localBaseFilter.addParam(new UniformParam.FloatParam("brightness", 1.0F));
    ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.filter.ttpic.OceanFilter
 * JD-Core Version:    0.7.0.1
 */