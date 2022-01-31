package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam.FloatsParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureResParam;

public class MenghuanFilter
  extends BaseFilter
{
  public MenghuanFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    BaseFilter localBaseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(54));
    localBaseFilter2.addParam(new TextureResParam("inputImageTexture2", "sh/menghuan_curve.png", 33986));
    setNextFilter(localBaseFilter2, null);
    BaseFilter localBaseFilter1 = new BaseFilter(BaseFilter.getFragmentShader(118));
    if (this.needFlipBlend) {}
    for (int i = 1;; i = 0)
    {
      localBaseFilter1.addParam(new TextureResParam("inputImageTexture2", "sh/menghuan_blend.png", 33986, i));
      localBaseFilter2.setNextFilter(localBaseFilter1, null);
      localBaseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(122));
      localBaseFilter2.addParam(new UniformParam.FloatsParam("levelMinimum", new float[] { 0.1607843F, 0.1607843F, 0.1607843F }));
      localBaseFilter2.addParam(new UniformParam.FloatsParam("levelMiddle", new float[] { 1.0F, 1.0F, 1.0F }));
      localBaseFilter2.addParam(new UniformParam.FloatsParam("levelMaximum", new float[] { 1.0F, 1.0F, 1.0F }));
      localBaseFilter2.addParam(new UniformParam.FloatsParam("minOutput", new float[] { 0.0F, 0.0F, 0.0F }));
      localBaseFilter2.addParam(new UniformParam.FloatsParam("maxOutput", new float[] { 1.0F, 1.0F, 1.0F }));
      localBaseFilter1.setNextFilter(localBaseFilter2, null);
      super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.filter.ttpic.MenghuanFilter
 * JD-Core Version:    0.7.0.1
 */