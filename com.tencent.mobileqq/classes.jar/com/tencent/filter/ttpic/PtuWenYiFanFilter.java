package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.FloatsParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureResParam;

public class PtuWenYiFanFilter
  extends BaseFilter
{
  public PtuWenYiFanFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    BaseFilter localBaseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(54));
    localBaseFilter2.addParam(new TextureResParam("inputImageTexture2", "sh/wenyifan_curve.png", 33986));
    setNextFilter(localBaseFilter2, null);
    BaseFilter localBaseFilter1 = new BaseFilter(BaseFilter.getFragmentShader(115));
    localBaseFilter1.addParam(new UniformParam.FloatsParam("color2", new float[] { 0.9764706F, 0.2980392F, 0.2980392F, 1.0F }));
    localBaseFilter1.addParam(new UniformParam.FloatParam("transparency", 0.17F));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    localBaseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(57));
    localBaseFilter2.addParam(new UniformParam.FloatsParam("shadowsShift", new float[] { -0.05098039F, 0.0F, 0.0F }));
    localBaseFilter2.addParam(new UniformParam.FloatsParam("midtonesShift", new float[] { 0.0F, 0.0F, 0.0F }));
    localBaseFilter2.addParam(new UniformParam.FloatsParam("highlightsShift", new float[] { -0.04705882F, -0.03921569F, 0.0F }));
    localBaseFilter2.addParam(new UniformParam.IntParam("preserveLuminosity", 1));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    localBaseFilter1 = new BaseFilter(BaseFilter.getFragmentShader(59));
    localBaseFilter1.addParam(new UniformParam.FloatsParam("color2", new float[] { 0.7882353F, 0.9019608F, 0.8862745F, 1.0F }));
    localBaseFilter1.addParam(new UniformParam.FloatParam("transparency", 1.0F));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    localBaseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(13));
    localBaseFilter2.addParam(new UniformParam.FloatParam("contrast", 1.0F));
    localBaseFilter2.addParam(new UniformParam.FloatParam("saturation", 1.1F));
    localBaseFilter2.addParam(new UniformParam.FloatParam("brightness", 1.0F));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.PtuWenYiFanFilter
 * JD-Core Version:    0.7.0.1
 */