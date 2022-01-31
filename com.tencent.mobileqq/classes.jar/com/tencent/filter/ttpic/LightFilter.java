package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam.FloatsParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.TextureResParam;

public class LightFilter
  extends BaseFilter
{
  public LightFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    BaseFilter localBaseFilter = new BaseFilter(BaseFilter.getFragmentShader(54));
    localBaseFilter.addParam(new TextureResParam("inputImageTexture2", "sh/light_curve.png", 33986));
    setNextFilter(localBaseFilter, null);
    HSVColorChannelFilter localHSVColorChannelFilter = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localHSVColorChannelFilter).setInput(0.0F, -30.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F);
    localBaseFilter.setNextFilter(localHSVColorChannelFilter, null);
    localBaseFilter = new BaseFilter(BaseFilter.getFragmentShader(57));
    localBaseFilter.addParam(new UniformParam.FloatsParam("shadowsShift", new float[] { 0.0F, 0.0F, 0.03921569F }));
    localBaseFilter.addParam(new UniformParam.FloatsParam("midtonesShift", new float[] { -0.0588235F, 0.0F, 0.0F }));
    localBaseFilter.addParam(new UniformParam.FloatsParam("highlightsShift", new float[] { 0.0F, 0.0F, 0.0F }));
    localHSVColorChannelFilter.setNextFilter(localBaseFilter, null);
    localHSVColorChannelFilter = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localHSVColorChannelFilter).setInput(-8.0F, 28.0F, 0.0F, 319.0F, 346.0F, 18.0F, 31.0F);
    localBaseFilter.setNextFilter(localHSVColorChannelFilter, null);
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.filter.ttpic.LightFilter
 * JD-Core Version:    0.7.0.1
 */