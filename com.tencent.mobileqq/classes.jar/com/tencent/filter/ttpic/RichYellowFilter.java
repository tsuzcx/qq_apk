package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam.FloatsParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.TextureResParam;

public class RichYellowFilter
  extends BaseFilter
{
  public RichYellowFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Object localObject2 = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localObject2).setInput(7.0F, 16.0F, 9.0F, 332.0F, 347.0F, 11.0F, 29.0F);
    setNextFilter((BaseFilter)localObject2, null);
    Object localObject1 = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localObject1).setInput(0.0F, -6.0F, 5.0F, 359.0F, 17.0F, 49.0F, 72.0F);
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new BaseFilter(BaseFilter.getFragmentShader(54));
    ((BaseFilter)localObject2).addParam(new TextureResParam("inputImageTexture2", "sh/richyellow_curve.png", 33986));
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    localObject1 = new BaseFilter(BaseFilter.getFragmentShader(57));
    ((BaseFilter)localObject1).addParam(new UniformParam.FloatsParam("shadowsShift", new float[] { 0.01176471F, 0.0F, -0.01176471F }));
    ((BaseFilter)localObject1).addParam(new UniformParam.FloatsParam("midtonesShift", new float[] { -0.02745098F, 0.0F, 0.02745098F }));
    ((BaseFilter)localObject1).addParam(new UniformParam.FloatsParam("highlightsShift", new float[] { 0.02352941F, 0.01176471F, -0.02745098F }));
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.filter.ttpic.RichYellowFilter
 * JD-Core Version:    0.7.0.1
 */