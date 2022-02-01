package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam.FloatsParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.BeautysFilter;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.TextureResParam;

public class TianMeiZiPaiFilter
  extends BaseFilter
{
  public TianMeiZiPaiFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Object localObject = new BeautysFilter(0, 0);
    ((BaseFilter)localObject).setEffectIndex(2);
    ((BaseFilter)localObject).setSrcFilterIndex(this.srcTextureIndex + 1);
    ((BaseFilter)localObject).applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
    setNextFilter((BaseFilter)localObject, null);
    BaseFilter localBaseFilter = ((BaseFilter)localObject).getLastFilter();
    localObject = new BaseFilter(BaseFilter.getFragmentShader(54));
    ((BaseFilter)localObject).addParam(new TextureResParam("inputImageTexture2", "sh/tianmeizipai_curve.png", 33986));
    localBaseFilter.setNextFilter((BaseFilter)localObject, null);
    localBaseFilter = new BaseFilter(BaseFilter.getFragmentShader(57));
    localBaseFilter.addParam(new UniformParam.FloatsParam("shadowsShift", new float[] { 0.0F, 0.0F, 0.0F }));
    localBaseFilter.addParam(new UniformParam.FloatsParam("midtonesShift", new float[] { 0.0F, 0.0F, 0.0F }));
    localBaseFilter.addParam(new UniformParam.FloatsParam("highlightsShift", new float[] { 0.03137255F, 0.0F, 0.0F }));
    ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
    localObject = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localObject).setInput(0.0F, 3.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F);
    localBaseFilter.setNextFilter((BaseFilter)localObject, null);
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.TianMeiZiPaiFilter
 * JD-Core Version:    0.7.0.1
 */