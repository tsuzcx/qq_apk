package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.FloatsParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.TextureResParam;

public class LollyFilter
  extends BaseFilter
{
  public LollyFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Object localObject2 = new BaseFilter(BaseFilter.getFragmentShader(59));
    ((BaseFilter)localObject2).addParam(new UniformParam.FloatsParam("color2", new float[] { 0.388235F, 0.9490196F, 0.9960784F, 1.0F }));
    ((BaseFilter)localObject2).addParam(new UniformParam.FloatParam("transparency", 0.18F));
    setNextFilter((BaseFilter)localObject2, null);
    Object localObject1 = new BaseFilter(BaseFilter.getFragmentShader(57));
    ((BaseFilter)localObject1).addParam(new UniformParam.FloatsParam("shadowsShift", new float[] { -0.03921569F, -0.04705882F, 0.03137255F }));
    ((BaseFilter)localObject1).addParam(new UniformParam.FloatsParam("midtonesShift", new float[] { -0.0627451F, -0.007843138F, 0.03137255F }));
    ((BaseFilter)localObject1).addParam(new UniformParam.FloatsParam("highlightsShift", new float[] { 0.0F, -0.03921569F, 0.03137255F }));
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new BaseFilter(BaseFilter.getFragmentShader(54));
    ((BaseFilter)localObject2).addParam(new TextureResParam("inputImageTexture2", "sh/lolly_curve.png", 33986));
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    localObject1 = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localObject1).setInput(7.0F, 30.0F, 0.0F, 306.0F, 336.0F, 6.0F, 36.0F);
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localObject2).setInput(-14.0F, 24.0F, 0.0F, 169.0F, 180.0F, 229.0F, 259.0F);
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    localObject1 = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localObject1).setInput(0.0F, 30.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F);
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.filter.ttpic.LollyFilter
 * JD-Core Version:    0.7.0.1
 */