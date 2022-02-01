package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.FloatsParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.TextureResParam;

public class MilkCoffeeFilter
  extends BaseFilter
{
  public MilkCoffeeFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Object localObject2 = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localObject2).setInput(3.0F, 40.0F, 3.0F, 329.0F, 352.0F, 10.0F, 35.0F);
    setNextFilter((BaseFilter)localObject2, null);
    Object localObject1 = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localObject1).setInput(-5.0F, 5.0F, 10.0F, 6.0F, 32.0F, 52.0F, 82.0F);
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new BaseFilter(BaseFilter.getFragmentShader(54));
    ((BaseFilter)localObject2).addParam(new TextureResParam("inputImageTexture2", "sh/milkcoffee_curve.png", 33986));
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    localObject1 = new BaseFilter(BaseFilter.getFragmentShader(134));
    ((BaseFilter)localObject1).addParam(new UniformParam.FloatsParam("color2", new float[] { 0.7294118F, 0.5372549F, 0.5058824F, 1.0F }));
    ((BaseFilter)localObject1).addParam(new UniformParam.FloatParam("transparency", 0.1F));
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new BaseFilter(BaseFilter.getFragmentShader(57));
    ((BaseFilter)localObject2).addParam(new UniformParam.FloatsParam("shadowsShift", new float[] { 0.0F, 0.0F, -0.02352941F }));
    ((BaseFilter)localObject2).addParam(new UniformParam.FloatsParam("midtonesShift", new float[] { 0.0F, 0.0F, -0.02352941F }));
    ((BaseFilter)localObject2).addParam(new UniformParam.FloatsParam("highlightsShift", new float[] { -0.007843138F, 0.0F, 0.0F }));
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.filter.ttpic.MilkCoffeeFilter
 * JD-Core Version:    0.7.0.1
 */