package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.FloatsParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.TextureResParam;

public class TeaMilkFilter
  extends BaseFilter
{
  public TeaMilkFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Object localObject = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localObject).setInput(0.0F, -20.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F);
    setNextFilter((BaseFilter)localObject, null);
    BaseFilter localBaseFilter = new BaseFilter(BaseFilter.getFragmentShader(56));
    localBaseFilter.addParam(new UniformParam.FloatsParam("color2", new float[] { 0.09019608F, 0.0666667F, 0.0666667F, 1.0F }));
    localBaseFilter.addParam(new UniformParam.FloatParam("transparency", 0.5F));
    ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
    localObject = new BaseFilter(BaseFilter.getFragmentShader(54));
    ((BaseFilter)localObject).addParam(new TextureResParam("inputImageTexture2", "sh/teamilk_curve2.png", 33986));
    localBaseFilter.setNextFilter((BaseFilter)localObject, null);
    localBaseFilter = new BaseFilter(BaseFilter.getFragmentShader(59));
    localBaseFilter.addParam(new UniformParam.FloatsParam("color2", new float[] { 0.9411765F, 0.9176471F, 0.854902F, 1.0F }));
    localBaseFilter.addParam(new UniformParam.FloatParam("transparency", 1.0F));
    ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.filter.ttpic.TeaMilkFilter
 * JD-Core Version:    0.7.0.1
 */