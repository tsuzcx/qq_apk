package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.FloatsParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.TextureResParam;

public class NextDoorFilter
  extends BaseFilter
{
  public NextDoorFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Object localObject = new BaseFilter(BaseFilter.getFragmentShader(107));
    ((BaseFilter)localObject).addParam(new TextureResParam("inputImageTexture2", "sh/nextdoor_center_curve.png", 33986));
    ((BaseFilter)localObject).addParam(new TextureResParam("inputImageTexture3", "sh/nextdoor_center_curve_mask.png", 33987));
    setNextFilter((BaseFilter)localObject, null);
    BaseFilter localBaseFilter = new BaseFilter(BaseFilter.getFragmentShader(107));
    localBaseFilter.addParam(new TextureResParam("inputImageTexture2", "sh/nextdoor_edge_curve.png", 33986));
    localBaseFilter.addParam(new TextureResParam("inputImageTexture3", "sh/nextdoor_edge_curve_mask.png", 33987));
    ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
    localObject = new BaseFilter(BaseFilter.getFragmentShader(57));
    ((BaseFilter)localObject).addParam(new UniformParam.FloatsParam("shadowsShift", new float[] { 0.0F, -0.05490196F, 0.1019608F }));
    ((BaseFilter)localObject).addParam(new UniformParam.FloatsParam("midtonesShift", new float[] { 0.0F, -0.08627451F, 0.0F }));
    ((BaseFilter)localObject).addParam(new UniformParam.FloatsParam("highlightsShift", new float[] { 0.0F, 0.0F, 0.0F }));
    ((BaseFilter)localObject).addParam(new UniformParam.IntParam("preserveLuminosity", 1));
    localBaseFilter.setNextFilter((BaseFilter)localObject, null);
    localBaseFilter = new BaseFilter(BaseFilter.getFragmentShader(59));
    localBaseFilter.addParam(new UniformParam.FloatsParam("color2", new float[] { 0.9921569F, 0.8470588F, 0.6392157F, 1.0F }));
    localBaseFilter.addParam(new UniformParam.FloatParam("transparency", 0.3F));
    ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
    localObject = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localObject).setInput(1.0F, 20.0F, 0.0F, 335.0F, 352.0F, 16.0F, 28.0F);
    localBaseFilter.setNextFilter((BaseFilter)localObject, null);
    localBaseFilter = new BaseFilter(BaseFilter.getFragmentShader(13));
    localBaseFilter.addParam(new UniformParam.FloatParam("contrast", 1.1F));
    localBaseFilter.addParam(new UniformParam.FloatParam("saturation", 1.0F));
    localBaseFilter.addParam(new UniformParam.FloatParam("brightness", 1.0F));
    ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.filter.ttpic.NextDoorFilter
 * JD-Core Version:    0.7.0.1
 */