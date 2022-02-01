package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.FloatsParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.TextureResParam;

public class RichBlueFilter
  extends BaseFilter
{
  public RichBlueFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Object localObject = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localObject).setInput(0.0F, -19.0F, 8.0F, 354.0F, 20.0F, 52.0F, 77.0F);
    setNextFilter((BaseFilter)localObject, null);
    BaseFilter localBaseFilter = new BaseFilter(BaseFilter.getFragmentShader(54));
    localBaseFilter.addParam(new TextureResParam("inputImageTexture2", "sh/richblue_curve.png", 33986));
    ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
    localObject = new BaseFilter(BaseFilter.getFragmentShader(57));
    ((BaseFilter)localObject).addParam(new UniformParam.FloatsParam("shadowsShift", new float[] { -0.172549F, -0.03921569F, 0.1647059F }));
    ((BaseFilter)localObject).addParam(new UniformParam.FloatsParam("midtonesShift", new float[] { 0.02352941F, -0.007843138F, 0.07843138F }));
    ((BaseFilter)localObject).addParam(new UniformParam.FloatsParam("highlightsShift", new float[] { 0.03137255F, 0.0F, 0.0F }));
    localBaseFilter.setNextFilter((BaseFilter)localObject, null);
    localBaseFilter = new BaseFilter(BaseFilter.getFragmentShader(13));
    localBaseFilter.addParam(new UniformParam.FloatParam("contrast", 0.97F));
    localBaseFilter.addParam(new UniformParam.FloatParam("saturation", 1.0F));
    localBaseFilter.addParam(new UniformParam.FloatParam("brightness", 1.0F));
    ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.filter.ttpic.RichBlueFilter
 * JD-Core Version:    0.7.0.1
 */