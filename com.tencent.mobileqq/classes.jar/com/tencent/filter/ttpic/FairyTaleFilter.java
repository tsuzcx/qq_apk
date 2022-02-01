package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.FloatsParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.TextureResParam;

public class FairyTaleFilter
  extends BaseFilter
{
  public FairyTaleFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Object localObject2 = new BaseFilter(BaseFilter.getFragmentShader(57));
    ((BaseFilter)localObject2).addParam(new UniformParam.FloatsParam("shadowsShift", new float[] { -0.02745098F, 0.0F, 0.01176471F }));
    ((BaseFilter)localObject2).addParam(new UniformParam.FloatsParam("midtonesShift", new float[] { -0.03921569F, 0.0588235F, 0.09803922F }));
    ((BaseFilter)localObject2).addParam(new UniformParam.FloatsParam("highlightsShift", new float[] { -0.1176471F, 0.03921569F, 0.0F }));
    setNextFilter((BaseFilter)localObject2, null);
    Object localObject1 = new BaseFilter(BaseFilter.getFragmentShader(13));
    ((BaseFilter)localObject1).addParam(new UniformParam.FloatParam("contrast", 1.05F));
    ((BaseFilter)localObject1).addParam(new UniformParam.FloatParam("saturation", 1.0F));
    ((BaseFilter)localObject1).addParam(new UniformParam.FloatParam("brightness", 1.0F));
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new BaseFilter(BaseFilter.getFragmentShader(60));
    ((BaseFilter)localObject2).addParam(new UniformParam.FloatParam("inputH", 1.0F));
    ((BaseFilter)localObject2).addParam(new UniformParam.FloatParam("inputS", 1.01F));
    ((BaseFilter)localObject2).addParam(new UniformParam.FloatParam("inputV", 1.02F));
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    localObject1 = new BaseFilter(BaseFilter.getFragmentShader(54));
    ((BaseFilter)localObject1).addParam(new TextureResParam("inputImageTexture2", "sh/fairytale_curve.png", 33986));
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localObject2).setInput(-10.0F, 45.0F, 5.0F, 310.0F, 330.0F, 356.0F, 30.0F);
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    localObject1 = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localObject1).setInput(-15.0F, -10.0F, 10.0F, 354.0F, 26.0F, 74.0F, 101.0F);
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.filter.ttpic.FairyTaleFilter
 * JD-Core Version:    0.7.0.1
 */